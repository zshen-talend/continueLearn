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
package designerPattern.createPattern.prototype.SerializableDeepCopy;

/**
 * created by talend on Dec 2, 2014 Detailled comment
 * 
 */
public class TestDeepClone {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        PrototypeSe po = new PrototypeSe();
        po.setName("test1");
        NewPrototypeSe se = new NewPrototypeSe();
        se.setPrototype(po);

        NewPrototypeSe deepClone = (NewPrototypeSe) se.deepClone();
        deepClone.getPrototype().setName("test2");

        System.out.println("original name:" + se.getPrototype().getName());
        System.out.println("cloned name:" + deepClone.getPrototype().getName());

    }
}
