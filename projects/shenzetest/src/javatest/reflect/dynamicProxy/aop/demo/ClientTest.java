package javatest.reflect.dynamicProxy.aop.demo;

public class ClientTest {

    public static void main(String[] args) {
        StudentInfoService studentInfo = (StudentInfoService) AOPFactory
                .getAOPProxyedObject("javatest.reflect.dynamicProxy.aop.demo.StudentInfoServiceImpl");
        studentInfo.findInfo("阿飞");
    }
}
