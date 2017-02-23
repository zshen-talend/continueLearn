/*
 * Copyright 2011 Cheng Fu
 */
package javatest.reflect.function.program;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.Arrays;

/**
 *
 * @author chengfu
 */
public class Array {

    private static final MethodType typeCallback = MethodType.methodType(Object.class, Object.class, int.class);

    public static void forEach(Object[] array, MethodHandle handle) throws Throwable {
        assert typeCallback.equals(handle.type());
        for (int i = 0, len = array.length; i < len; i++) {
            handle.invoke(array[i], i);
        }
    }

    public static Object[] map(Object[] array, MethodHandle handle) throws Throwable {
        assert typeCallback.equals(handle.type());
        Object[] result = new Object[array.length];
        for (int i = 0, len = array.length; i < len; i++) {
            result[i] = handle.invoke(array[i], i);
        }
        return result;
    }

    public static Object handleArrayElement(Object value, int i) {
        if (value instanceof Integer) {
            return (int) value * 2;
        }
        return value;
    }

    public static Object reduce(Object[] array, Object initalValue, MethodHandle handle) throws Throwable {
        Object result = initalValue;
        for (Object element : array) {
            result = handle.invoke(result, element);
        }
        return result;
    }

    public static void main(String[] args) throws Throwable {
        Object[] testArray = { 1, 2, 3, 4, 5 };
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle mh = lookup.findStatic(Array.class, "handleArrayElement", typeCallback);
        Array.forEach(testArray, mh);
        Object[] result = Array.map(testArray, mh);
        System.out.println(Arrays.deepToString(result));
    }
}
