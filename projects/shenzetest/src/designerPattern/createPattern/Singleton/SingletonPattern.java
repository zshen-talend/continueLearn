// ============================================================================
//
// Copyright (C) 2006-2014 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package designerPattern.createPattern.Singleton;

/**
 * created by talend on Nov 27, 2014 Detailled comment
 * 
 */
public class SingletonPattern {

    /* 私有构造方法，防止被实例化 */
    private SingletonPattern() {
    }

    /* 此处使用一个内部类来维护单例 */
    private static class SingletonFactory {

        private static SingletonPattern instance = new SingletonPattern();
    }

    /* 获取实例 */
    public static SingletonPattern getInstance() {
        return SingletonFactory.instance;
    }

    /* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */
    public Object readResolve() {
        return getInstance();
    }
}
