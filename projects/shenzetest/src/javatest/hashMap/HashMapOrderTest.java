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
        Map<Integer, String> testMap = new HashMap<>();
        testMap.put(1, "a");
        testMap.put(2, "b");
        testMap.put(5, "e");
        testMap.put(3, "c");
        testMap.put(6, "f");
        testMap.put(4, "d");
        testMap.put(7, "g");

        Iterator<Integer> iterator = testMap.keySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(testMap.get(iterator.next()));
        }

        // test1();
    }

    protected static void test1() {
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
