// ============================================================================
//
// Copyright (C) 2006-2016 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package db.mapDB.v3_0;

import org.mapdb.Serializer;
import org.mapdb.SortedTableMap;
import org.mapdb.volume.MappedFileVol;
import org.mapdb.volume.Volume;

/**
 * DOC zshen class global comment. Detailled comment
 */

public class SortedTableMapTest {

    public static void main(String args[]) {
        // create memory mapped volume
        Volume volume = MappedFileVol.FACTORY.makeVolume("D:\\test data\\mapDBTest.txt", false);
        // open consumer which will feed map with content
        SortedTableMap.Sink<Integer, String> sink =
                SortedTableMap.create(volume, Serializer.INTEGER, Serializer.STRING).createFromSink();
        // feed content into consumer
        for (int key = 100; key < 100000; key++) {
            sink.put(key, "value" + key);
        }
        sink.put(0, "value0");
        // finally open created map
        SortedTableMap<Integer, String> map = sink.create();

        volume = MappedFileVol.FACTORY.makeVolume("D:\\test data\\mapDBTest.txt", true);
        // read-only=true
        map = SortedTableMap.open(volume, Serializer.INTEGER, Serializer.STRING);

        System.out.println(map.firstKey());
        System.out.println(map.get(0));

    }
}
