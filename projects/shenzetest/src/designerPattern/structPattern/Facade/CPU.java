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
package designerPattern.structPattern.Facade;

/**
 * created by talend on Dec 12, 2014 Detailled comment
 * 
 */
public class CPU {

    public void startup() {
        System.out.println("cpu startup!"); //$NON-NLS-1$
    }

    public void shutdown() {
        System.out.println("cpu shutdown!"); //$NON-NLS-1$
    }
}
