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


import org.mapdb.Atomic;
import org.mapdb.DB;
import org.mapdb.DBMaker;

import java.util.Map;

/**
 * Demonstrates Atomic.Long usage as unique-key generator.
 * In SQL terms it demonstrates unique IDs using AUTO_INCREMENT.
 * Variable is atomically incremented and persisted after JVM shutdown.
 *
 */
public class SQL_Auto_Incremental_Unique_Key {
    public static void main(String[] args) {
        DB db = DBMaker.newTempFileDB().make();

        //open or create new map
        Map<Long, String> map = db.getTreeMap("map");

        // open existing or create new Atomic record with given name
        // if no record with given name exist, new recid is created with value `0`
        Atomic.Long keyinc = db.getAtomicLong("map_keyinc");


        // Allocate new unique key to use in map
        // Atomic.Long will use `compare-and-swap` operation to atomically store incremented value
        // Key values can be used only for single insert
        // key == 1
        Long key = keyinc.incrementAndGet();
        map.put(key, "some string");

        // insert second entry,
        // key==2
        map.put(keyinc.incrementAndGet(), "some other string");

        System.out.println(map);

    }
}