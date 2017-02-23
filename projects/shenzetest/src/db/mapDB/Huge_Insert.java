// ============================================================================
//
// Copyright (C) 2006-2014 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package db.mapDB;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import org.mapdb.BTreeKeySerializer;
import org.mapdb.BTreeMap;
import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.Fun;
import org.mapdb.Pump;

/**
 * Demonstrate how-to create large BTreeMap using data pump. Typical usage is to import data set from external source.
 * 
 * @author Jan Kotek
 */
public class Huge_Insert {

    public static void main(String[] args) throws IOException {

        /** max number of elements to import */
        final long max = (int) 1e7;

        /**
         * Open database in temporary directory
         */
        File dbFile = File.createTempFile("mapdb", "temp");
        DB db = DBMaker.newFileDB(dbFile)
        /** disabling Write Ahead Log makes import much faster */
        .transactionDisable().make();

        long time = System.currentTimeMillis();

        /**
         * Source of data which randomly generates strings. In real world this would return data from file.
         */
        Iterator<String> source = new Iterator<String>() {

            long counter = 0;

            public boolean hasNext() {
                return counter < max;
            }

            public String next() {
                counter++;
                return randomString(10);
            }

            public void remove() {
            }
        };

        /**
         * BTreeMap Data Pump requires data source to be presorted in reverse order (highest to lowest). There is method
         * in Data Pump we can use to sort data. It uses temporarly files and can handle fairly large data sets.
         */
        source = Pump.sort(source, true, 100000, Collections.reverseOrder(BTreeMap.COMPARABLE_COMPARATOR), // reverse
                                                                                                           // order
                                                                                                           // comparator
                db.getDefaultSerializer());

        /**
         * Disk space used by serialized keys should be minimised. Keys are sorted, so only difference between
         * consequential keys is stored. This method is called delta-packing and typically saves 60% of disk space.
         */
        BTreeKeySerializer<String> keySerializer = BTreeKeySerializer.STRING;

        /**
         * Translates Map Key into Map Value.
         */
        Fun.Function1<Integer, String> valueExtractor = new Fun.Function1<Integer, String>() {

            public Integer run(String s) {
                return s.hashCode();
            }
        };

        /**
         * Create BTreeMap and fill it with data
         */
        Map<String, Integer> map = db.createTreeMap("map").pumpSource(source, valueExtractor)
        // .pumpPresort(100000) // for presorting data we could also use this method
                .keySerializer(keySerializer).make();

        System.out.println("Finished; total time: " + (System.currentTimeMillis() - time) / 1000 + "s; there are " + map.size()
                + " items in map");

        // for (String str : map.keySet()) {
        // System.out.println(map.get(str));
        // }
        db.close();

    }

    public static String randomString(int size) {
        String chars = "0123456789abcdefghijklmnopqrstuvwxyz !@#$%^&*()_+=-{}[]:\",./<>?|\\";
        StringBuilder b = new StringBuilder(size);
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            b.append(chars.charAt(r.nextInt(chars.length())));
        }
        return b.toString();
    }

}