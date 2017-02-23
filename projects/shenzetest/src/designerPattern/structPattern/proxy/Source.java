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
package designerPattern.structPattern.proxy;

/**
 * created by talend on Dec 12, 2014 Detailled comment
 * 
 */
public class Source implements Sourceable {

    /*
     * (non-Javadoc)
     * 
     * @see designerPattern.structPattern.proxy.Sourceable#method()
     */
    @Override
    public void method() {
        System.out.println("the original method!");

    }

}
