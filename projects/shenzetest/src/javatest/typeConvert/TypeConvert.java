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
package javatest.typeConvert;

/**
 * DOC zshen class global comment. Detailled comment
 */
public class TypeConvert {

    /**
     * DOC zshen Comment method "main".
     * 
     * @param args
     */
    public static void main(String[] args) {
        Object aa = null;
        String bb = (String) aa;
        if (bb == null) {
            System.out.println("Convert is sucess");
        }
        if (bb instanceof String) {
            System.out.println("instanceof is sucess");
        }

    }

}
