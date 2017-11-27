// ============================================================================
//
// Copyright (C) 2006-2015 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package regexTest;

import nl.flotsam.xeger.Xeger;

/**
 * DOC talend class global comment. Detailled comment
 */
public class XegerTest {

    /**
     * DOC qiongli Comment method "main".
     * 
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // String regex = "[ab]{4,6}c";
        // FR Phone pattern
        String regex = "(0033 ?|\\+33 ?|0)[1-9]([-. ]?[0-9]{2}){4}";
        Xeger generator = new Xeger(regex);
        // generate first random 100 FR number
        for (int i = 0; i < 100; i++) {

            String result = generator.generate();
            System.out.println(result);
        }

    }

}
