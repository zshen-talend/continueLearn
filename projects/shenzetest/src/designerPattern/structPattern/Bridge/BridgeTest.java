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
package designerPattern.structPattern.Bridge;

/**
 * created by talend on Dec 12, 2014 Detailled comment
 * 
 */
public class BridgeTest {

    public static void main(String[] args) {

        Bridge bridge = new MyBridge();

        /* 调用第一个对象 */
        Sourceable source1 = new SourceSub1();
        bridge.setSource(source1);
        bridge.method();

        /* 调用第二个对象 */
        Sourceable source2 = new SourceSub2();
        bridge.setSource(source2);
        bridge.method();
    }
}
