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
package designerPattern.structPattern.adapter.interfaceAdapter;

/**
 * created by talend on Dec 12, 2014 Detailled comment
 * 
 */
public class SourceSub2 extends Wrapper2 {

    @Override
    public void method2() {
        System.out.println("the sourceable interface's second Sub2!"); //$NON-NLS-1$
    }
}
