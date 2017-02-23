package javatest.reflect.dynamicProxy;

import java.lang.reflect.Proxy;

public class DynamicProxyUtils {

    public static <T> T makeProxy(Class<T> intf, final T object) {
        LoggingInvocationHandler handler = new LoggingInvocationHandler(object);
        ClassLoader cl = object.getClass().getClassLoader();
        return (T) Proxy.newProxyInstance(cl, new Class<?>[] { intf }, handler);
    }
}
