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
package javatest.StringTest;

import org.apache.commons.lang.StringEscapeUtils;

/**
 * DOC zshen class global comment. Detailled comment
 */
public class StringEscapeUtilsTest {

    /**
     * DOC zshen Comment method "main".
     * 
     * @param args
     */
    public static void main(String[] args) {
        String escapeJava = StringEscapeUtils.escapeJava("^");
        System.out.println(escapeJava);
        System.out.println('\\' + "" + '^');
    }
}
