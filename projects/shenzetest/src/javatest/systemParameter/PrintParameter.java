// ============================================================================
//
// Copyright (C) 2006-2020 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package javatest.systemParameter;


public class PrintParameter {

    public static void main(String[] args) {
        System.out.println(System.getProperty("${file_name}"));
        // 这里打不出来，这些属性是插件才有的，调试方式见具体的.bat文件，里面可以echo

    }

}
