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
package javatest.ClassLoader;


/**
 * DOC zshen class global comment. Detailled comment
 * 
 * //系统加载器 应用级别主要是classpath下的 sun.misc.Launcher$AppClassLoader@9304b1 ·// 扩展加载器负责java的一些相关的jar
 * sun.misc.Launcher$ExtClassLoader@190d11
 * 
 * 
 */
public class TestClassLoaderTree {

    public static void main(String[] args) {
        String classDataRootPath = "C:\\workspace\\Classloader\\classData";
        FileSystemClassLoader fscl1 = new FileSystemClassLoader(classDataRootPath);
        String className = "javatest.ClassLoader.TestSameClass.Sample";
        Class<?> class1 = null;
        Object obj1 = null;
        try {
            class1 = fscl1.loadClass(className);
            obj1 = class1.newInstance();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        ClassLoader loader = obj1.getClass().getClassLoader();
        while (loader != null) {
            System.out.println(loader.toString());
            loader = loader.getParent();
        }
    }
}
