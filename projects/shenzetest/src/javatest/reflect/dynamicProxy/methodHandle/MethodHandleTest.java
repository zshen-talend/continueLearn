// ============================================================================
//
// Copyright (C) 2006-2016 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package javatest.reflect.dynamicProxy.methodHandle;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * DOC zshen class global comment. Detailled comment
 */
public class MethodHandleTest {

    public static void main(String[] args) throws Throwable {
        invokeExact();
    }

    public static void invokeExact() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType type = MethodType.methodType(String.class, int.class, int.class);
        MethodHandle mh = lookup.findVirtual(String.class, "substring", type); //$NON-NLS-1$
        String str = (String) mh.invokeExact("Hello world", 1, 3); //$NON-NLS-1$
        System.out.println(str);
        try {
            MethodHandle findGetter = lookup.findGetter(demoClass.class, "name1", String.class);
            System.out.println(findGetter.invoke(new demoClass()));
        } catch (NoSuchFieldException e) {
            System.out.println(e);
        }

    }
}
