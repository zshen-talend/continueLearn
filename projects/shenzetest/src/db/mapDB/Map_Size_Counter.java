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


import org.mapdb.*;

import java.util.Map;

/**
 * Keep tracks of number of items in map.
 * <p/>
 * {@code Collections.size()} typically requires traversing entire collection in MapDB, but there is optional parameter
 * which controls if Map keeps track of its count.
 */
public class Map_Size_Counter {

    public static void main(String[] args) {

        //first option, create Map with counter (NOTE: counter is not on by default)
        DB db1 = DBMaker.newTempFileDB().make();
        //hashMap
        Map m = db1.createHashMap("map1a")
                .counterEnable() /**<<here is counter argument*/
                .make();
        //treeMap
        m = db1.createTreeMap("map1b")
                .counterEnable() /**<<here is counter argument*/
                .make();

        m.put("a","b");
        m.size();



        //second option, create external Atomic.Long and bind it to map */
        DB db2 = DBMaker.newTempFileDB().make();

        BTreeMap primary = db2.getTreeMap("map2");
        Atomic.Long sizeCounter = db1.getAtomicLong("mapSize");

        Bind.size(primary, sizeCounter);

        primary.put("111", "some value");

        sizeCounter.get();


    }

}