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
package javatest.integer;

/**
 * DOC zshen class global comment. Detailled comment
 */
public class HexConvert {

    public static void main(String[] args) {
        System.out.println("十转二：" + Integer.toBinaryString(120));
        System.out.println("十转八：" + Integer.toOctalString(120));
        System.out.println("十转十六：" + Integer.toHexString(120));
        System.out.println("二转十：" + Integer.valueOf("1010", 2));
        System.out.println("八转十：" + Integer.valueOf("125", 8));
        System.out.println("十六转十：" + Integer.valueOf("ABCDEF", 16));
        System.out.println(0XA + 1);
    }
}
