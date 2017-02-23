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
package designerPattern.createPattern.prototype;


/**
 * created by talend on Dec 2, 2014 Detailled comment
 * 
 */
public class Main {

    public static void main(String[] args) {
        testPrototype();
    }

    private static void testPrototype() {
        Prototype pro = new Prototype();
        pro.setName("original object");
        Prototype pro1 = (Prototype) pro.clone();
        pro.setName("changed object1");

        System.out.println("original object:" + pro.getName());
        System.out.println("cloned object:" + pro1.getName());

    }

}
