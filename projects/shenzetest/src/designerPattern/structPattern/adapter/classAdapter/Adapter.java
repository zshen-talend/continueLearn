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
package designerPattern.structPattern.adapter.classAdapter;

import designerPattern.structPattern.adapter.Source;

/**
 * created by talend on Dec 12, 2014 Detailled comment
 * 
 */
public class Adapter extends Source implements Targetable {

    /*
     * (non-Javadoc)
     * 
     * @see designerPattern.structPattern.adapter.classAdapter.Targetable#method2()
     */
    @Override
    public void method2() {
        System.out.println("this is the targetable method!");
    }

}
