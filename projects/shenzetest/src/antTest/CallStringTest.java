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
// 调用类在这里，被调用类在shenze1的工程里，会把这两个工程的类打包成一个jar
// 到当前工程的lib下名称为result.jar,对应的build文件叫做build.xml
// ============================================================================
package antTest;

import antTest1.StringTest;


/**
 * DOC zshen  class global comment. Detailled comment
 */
public class CallStringTest {

    public static void main(String args[]) {
        StringTest.main(args);
    }
}
