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
package javatest.overriding;

/**
 * DOC zshen class global comment. Detailled comment
 */
public class OverridingTest {

    public void println(Object str) {
        System.out.println("Object: " + str);
    }

    public void println(String str) {
        System.out.println("String: " + str);
    }

    public static void main(String[] args) {
        OverridingTest overridingTest = new OverridingTest();
        Object obj = "Object";
        String str = "String";
        System.out.println("第一次输出:");
        overridingTest.println(obj);
        overridingTest.println(str);
        obj = str;
        System.out.println("第二次输出:");
        overridingTest.println(obj);
        overridingTest.println(str);
    }
}
