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
package javatest.hashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * DOC zshen class global comment. Detailled comment
 */
public class HashMapOrderTest {

    public static void main(String[] args) {
        Map<tMatchGroup_1_2Struct, String> testMap = new HashMap<>();
        testMap.put(new tMatchGroup_1_2Struct("CARLISLE"), "1");
        testMap.put(new tMatchGroup_1_2Struct("CARLISLE"), "2");
        testMap.put(new tMatchGroup_1_2Struct("KNOXVILLE"), "3");
        testMap.put(new tMatchGroup_1_2Struct("KNOXVILLE"), "4");

        Iterator<tMatchGroup_1_2Struct> iterator = testMap.keySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(testMap.get(iterator.next()));
        }
    }
}
