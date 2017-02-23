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
package javatest.exception;

/**
 * DOC zshen class global comment. Detailled comment
 */
public class ExceptionA extends Exception {

    /**
     * Creates a new instance of <code>ExceptionA</code> without detail message.
     */
    public ExceptionA() {
    }

    /**
     * Constructs an instance of <code>ExceptionA</code> with the specified detail message.
     * 
     * @param msg the detail message.
     */
    public ExceptionA(String msg) {
        super(msg);
    }

    protected void methodInExceptionA() {

    }
}