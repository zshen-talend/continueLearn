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
package designerPattern.createPattern.prototype.shallowCopy;

/**
 * created by talend on Dec 2, 2014 Detailled comment
 * 
 */
public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        testPrototype();
    }

    private static void testPrototype() {
        Prototype pro = new Prototype();
        pro.setName("original object");
        NewPrototype newObj = new NewPrototype();
        newObj.setId("test1");
        newObj.setPrototype(pro);

        NewPrototype copyObj = (NewPrototype) newObj.clone();
        copyObj.setId("testCopy");
        copyObj.getPrototype().setName("changed object");

        System.out.println("original object id:" + newObj.getId());
        System.out.println("original object name:" + newObj.getPrototype().getName());

        System.out.println("cloned object id:" + copyObj.getId());
        System.out.println("cloned object name:" + copyObj.getPrototype().getName());

    }

}
