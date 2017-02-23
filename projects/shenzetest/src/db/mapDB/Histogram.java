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

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.mapdb.Bind;
import org.mapdb.DBMaker;
import org.mapdb.Fun;
import org.mapdb.HTreeMap;

/**
 * Shows how to split map into categories and count elements in each category
 * 
 * Here we show histogram of an {@code Math.random()}. We represent category as string for clarity, but any number or
 * other type could be used
 */
public class Histogram {

    public static void main(String[] args) {
        HTreeMap<Long, Double> map = DBMaker.newTempHashMap();

        // histogram, category is a key, count is a value
        ConcurrentMap<String, Long> histogram = new ConcurrentHashMap<String, Long>(); // any map will do

        // bind histogram to primary map
        // we need function which returns category for each map entry
        Bind.histogram(map, histogram, new Fun.Function2<String, Long, Double>() {

            public String run(Long key, Double value) {
                if (value < 0.25) {
                    return "first quarter";
                } else if (value < 0.5) {
                    return "second quarter";
                } else if (value < 0.75) {
                    return "third quarter";
                } else {
                    return "fourth quarter";
                }
            }
        });

        // insert some random stuff
        for (long key = 0; key < 1e4; key++) {
            map.put(key, Math.random());
        }

        System.out.println(histogram);
    }
}
