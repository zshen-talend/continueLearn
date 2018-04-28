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
import java.util.concurrent.ConcurrentNavigableMap;

import org.mapdb.DB;
import org.mapdb.DBMaker;

/**
 * Hello world application to demonstrate storage open, commit and close operations
 */
public class HelloWorld {

    public static void main(String[] args) throws IOException {

        // Configure and open database using builder pattern.
        // All options are available with code auto-completion.
        File dbFile = File.createTempFile("mapdb", "db");
        DB db = DBMaker.newFileDB(dbFile).closeOnJvmShutdown().encryptionEnable("password").make();

        // open an collection, TreeMap has better performance then HashMap
        ConcurrentNavigableMap<Integer, String> map = db.getTreeMap("collectionName");

        map.put(2, "one");
        map.put(1, "two");
        // map.keySet() is now [1,2] even before commit

        db.commit(); // persist changes into disk

        map.put(3, "three");
        // map.keySet() is now [1,2,3]
        db.rollback(); // revert recent changes
        // map.keySet() is now [1,2]

        for (Integer key : map.keySet()) {
            System.out.println(key);
        }

        db.close();

    }
}