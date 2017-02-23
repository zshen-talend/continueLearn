package memory.leak;

import java.util.HashMap;
import java.util.Map;

// cache cause memory leak
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
