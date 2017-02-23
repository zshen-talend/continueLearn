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

import java.util.Random;

import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.HTreeMap;
import org.mapdb.Serializer;
import org.mapdb.Store;

/**
 * This example shows how-to create off-heap cache, where entries expire when maximal store size is reached.
 * 
 * It also shows howto get basic statistics about store size.
 * 
 * It is more advanced version of previous example. It uses more settings, bypasses general serialization for best
 * performance and discussed other performance tunning
 * 
 */
public class CacheOffHeapAdvanced {

    public static void main(String[] args) {

        final double cacheSizeInGB = 1.0;

        // first create store
        DB db = DBMaker.newMemoryDirectDB().transactionDisable()
        // some additional options for DB
        // .asyncWriteEnable()
        // .cacheSize(100000)
                .make();

        HTreeMap cache = db.createHashMap("cache").expireStoreSize(cacheSizeInGB).counterEnable() // disable this if
                                                                                                  // cache.size() is not
                                                                                                  // used
                // use proper serializers to and improve performance
                .keySerializer(Serializer.LONG).valueSerializer(Serializer.BYTE_ARRAY).make();

        // generates random key and values
        Random r = new Random();
        // used to print store statistics
        Store store = Store.forDB(db);

        // insert some stuff in cycle
        for (long counter = 1; counter < 1e8; counter++) {
            long key = r.nextLong();
            byte[] value = new byte[1000];
            r.nextBytes(value);

            cache.put(key, value);

            if (counter % 1e5 == 0) {
                System.out.printf("Map size: %,d, counter %,d, curr store size: %,d, store free size: %,d\n", cache.sizeLong(),
                        counter, store.getCurrSize(), store.getFreeSize());
            }

        }

        // and release memory. Only necessary with `DBMaker.newCacheDirect()`
        cache.close();

    }
}