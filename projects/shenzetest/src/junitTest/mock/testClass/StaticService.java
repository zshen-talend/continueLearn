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
package junitTest.mock.testClass;


/**
 * DOC zshen  class global comment. Detailled comment
 */
public class StaticService {

    public static String say(String content) {
        System.out.println(content);
        return content;
    }

    public static String sayFinal(String content) {
        System.out.println(content);
        return content;
    }

    public static String sayNative(String content) {
        System.out.println(content);
        return content;
    }

    public static String sayFinalNative(String content) {
        System.out.println(content);
        return content;
    }

    public static String doStatic(int content) {
        System.out.println(content);
        return String.valueOf(content);
    }

    public static void sayHello() {
        System.out.println("Hello");

    }

    public static void sayHelloAgain() {
        System.out.println("Hello again");

    }

    public static int getNumberFromInner() {
        return 17;

    }

    public static int getNumberFromInnerInstance() {
        return 23;

    }


}
