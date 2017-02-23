package javatest.reference.strong;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * DOC zshen 计算结果被缓存，导致缓存的对象不能被及时回收
 */
public class Calculator {

    private Map<String, Object> cache = new HashMap<String, Object>();

    public Object calculate(String expr) {
        if (cache.containsKey(expr)) {
            return cache.get(expr);
        }
        Object result = doCalculate(expr);
        cache.put(null, result);
        return result;
    }

    private Object doCalculate(String expr) {
        return new Object();
    }
}
