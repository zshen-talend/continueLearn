package javatest.reflect.dynamicProxy;

import java.util.ArrayList;
import java.util.List;

public class DynamicProxyTest {

    public static void main(String[] args) {
        useGenericProxy();
    }

    public static void useGenericProxy() {
        String str = "Hello world";
        Comparable proxy = DynamicProxyUtils.makeProxy(Comparable.class, str);
        proxy.compareTo("Good");
        List<String> list = new ArrayList<String>();
        list = DynamicProxyUtils.makeProxy(List.class, list);
        list.add("Hello");
    }
}
