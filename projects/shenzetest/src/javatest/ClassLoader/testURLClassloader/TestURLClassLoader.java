package javatest.ClassLoader.testURLClassloader;

import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class TestURLClassLoader {

    public static Method initAddMethod() {
        try {
            Method add = URLClassLoader.class.getDeclaredMethod("addURL", new Class[] { URL.class });
            add.setAccessible(true);
            return add;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Method addURL = null;

    public static URLClassLoader classloader = null;

    public static void main(String[] args) {

        /*
         * 系统加载jar
         */
        try {

            // 系统ClassLoader只能加载.jar
            // 动态加载jar
            addURL = initAddMethod();
            classloader = (URLClassLoader) ClassLoader.getSystemClassLoader();
            String url = "file:" + System.getProperty("user.dir") + "/lib/sample/GetPI.jar"; // 包路径定义
            System.out.println(url);
            URL classUrl = new URL(url);
            addURL.invoke(classloader, new Object[] { classUrl });

            String className = "samples.OutputClass";
            Class<?> c = Class.forName(className);
            Object obj = c.newInstance();
            // 被调用函数的参数
            Class[] parameterTypes = {};
            Method method2 = c.getDeclaredMethod("Output", parameterTypes);
            method2.invoke(obj, null);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }
}