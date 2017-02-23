package javatest.reflect.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class LoggingInvocationHandler implements InvocationHandler {

    private Object receiverObject;

    public LoggingInvocationHandler(Object object) {
        this.receiverObject = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用方法" + method.getName() + ": 参数为 " + Arrays.deepToString(args));
        return method.invoke(receiverObject, args);
    }

}
