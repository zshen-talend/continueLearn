// ============================================================================
//
// Copyright (C) 2006-2011 Talend Inc. - www.talend.com
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
 * DOC zshen class global comment. Detailled comment
 */
public class ListClass {

    /**
     * DOC zshen Comment method "main".
     * 
     * @param args
     */
    public static void main(String[] args) {
        List<String> myList = new ArrayList<String>();
        String str1 = "aa"; //$NON-NLS-1$
        myList.add(str1);
        System.out.println(myList.contains("aa1".replaceAll("1", ""))); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        testRemoveList();
    }

    public static void testRemoveList() {
        List<String> strList1 = new ArrayList<String>();
        strList1.add("1"); //$NON-NLS-1$
        strList1.add("2"); //$NON-NLS-1$
        strList1.add("3"); //$NON-NLS-1$
        strList1.add("4"); //$NON-NLS-1$
        strList1.add("5"); //$NON-NLS-1$
        strList1.add("6"); //$NON-NLS-1$
        List<String> strList2 = new ArrayList<String>();
        strList2.addAll(strList1);
        for (int i = 0; i < strList2.size(); i++) {
            String str = strList2.get(i);
            if (str.equals("3")) { //$NON-NLS-1$
                strList1.remove(str);
            }
        }
    }

}
