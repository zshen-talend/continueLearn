// ============================================================================
//
// Copyright (C) 2006-2009 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package LanguageTest;

import java.text.NumberFormat;

/**
 * DOC Administrator class global comment. Detailled comment
 */
public class B {

    /**
     * DOC Administrator Comment method "main".
     * 
     * @param args
     */
    public static void main(String[] args) {

        Object input = 15.773160173160173;
        // Use default locale
        String value = NumberFormat.getInstance().format(input);
        System.out.println(value);// If default locale is Locale.FRANCE(fr_FR), here will
        // print 15,773 If default locale is Locale.US, here
        // will print 15.773

    }

}
