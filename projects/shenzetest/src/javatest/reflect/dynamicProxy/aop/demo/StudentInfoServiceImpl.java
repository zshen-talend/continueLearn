package javatest.reflect.dynamicProxy.aop.demo;

public class StudentInfoServiceImpl implements StudentInfoService {

    @Override
    public void findInfo(String name) {
        System.out.println("你目前输入的名字是:" + name);
    }
}
