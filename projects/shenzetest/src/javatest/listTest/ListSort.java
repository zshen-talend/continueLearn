// ============================================================================
//
// Copyright (C) 2006-2013 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package javatest.listTest;

import java.util.ArrayList;
import java.util.List;

/**
 * created by zshen on Mar 7, 2013 Detailled comment
 * 
 */
public class ListSort {

    /**
     * DOC zshen Comment method "main".
     * 
     * @param args
     */
    public static void main(String[] args) {
        List<String> myList = new ArrayList<String>();
        String str1 = "bb"; //$NON-NLS-1$
        myList.add("cc");
        myList.add("dd");
        myList.add(str1);
        myList.add("aa");

        // Collections.sort(myList, new Comparator<String>() {
        //
        // @Override
        // public int compare(String o1, String o2) {
        // // TODO Auto-generated method stub
        // return o1.compareTo(o2);
        // }
        //
        // });

        doBubbleSort(myList);
        System.out.println(myList.toString());
    }

    public static void doBubbleSort(List<String> joinKeyList) {
        int len = joinKeyList.size();
        List<String> sortList = new ArrayList<String>();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                String temp;
                if (joinKeyList.get(j).compareTo(joinKeyList.get(i)) < 0) {
                    joinKeyList.add(i, joinKeyList.get(j));
                    joinKeyList.remove(j + 1);
                }
            }
        }
    }
}
