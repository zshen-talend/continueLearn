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


import org.mapdb.BTreeKeySerializer;
import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.Fun;

import java.util.NavigableSet;

/**
 * Shows howto implement MultiMap (Map with more then one values for a singe key) correctly.
 * To do 1:N mapping most people would use Map[String, List[Long]], however MapDB
 * requires nodes to be immutable, so this is wrong.
 */
public class MultiMap {

    public static void main(String[] args) {
        DB db = DBMaker.newMemoryDB().make();

        // this is wrong, do not do it !!!
        //  Map<String,List<Long>> map

        //correct way is to use composite set, where 'map key' is primary key and 'map value' is secondary value
        NavigableSet<Fun.Tuple2<String,Long>> multiMap = db.getTreeSet("test");

        //optionally you can use set with Delta Encoding. This may save lot of space
        multiMap = db.createTreeSet("test2")
                .serializer(BTreeKeySerializer.TUPLE2)
                .make();

        multiMap.add(Fun.t2("aa",1L));
        multiMap.add(Fun.t2("aa",2L));
        multiMap.add(Fun.t2("aa",3L));
        multiMap.add(Fun.t2("bb",1L));

        //find all values for a key
        for(Long l: Fun.filter(multiMap, "aa")){
            System.out.println("value for key 'aa': "+l);
        }

        //check if pair exists

        boolean found = multiMap.contains(Fun.t2("bb",1L));
        System.out.println("Found: " + found);

        db.close();

    }
}