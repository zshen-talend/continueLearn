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
package javatest.ClassLoader.TestSameClass;

import java.lang.reflect.Method;

import javatest.ClassLoader.FileSystemClassLoader;

/**
 * DOC zshen class global comment. Detailled comment
 */
public class TestForSameClass {

    public static void main(String[] args) {
        testClassIdentity();
    }

    public static void testClassIdentity() {
        String classDataRootPath = "C:\\workspace\\Classloader\\classData";
        FileSystemClassLoader fscl1 = new FileSystemClassLoader(classDataRootPath);
        FileSystemClassLoader fscl2 = new FileSystemClassLoader(classDataRootPath);
        String className = "javatest.ClassLoader.TestSameClass.Sample";
        try {
            Class<?> class1 = fscl1.loadClass(className);
            Object obj1 = class1.newInstance();
            Class<?> class2 = fscl2.loadClass(className);
            Object obj2 = class2.newInstance();
            Method setSampleMethod = class1.getMethod("setSample", java.lang.Object.class);
            setSampleMethod.invoke(obj1, obj2);
            Method getSampleMethod = class1.getMethod("getSample");
            Object returnObject = getSampleMethod.invoke(obj1);

            System.out.println(returnObject.equals(obj2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
