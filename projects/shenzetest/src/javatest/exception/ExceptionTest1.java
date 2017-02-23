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
public class ExceptionTest1 {

    public void testThrow() throws ExceptionA {
        try {
            throw new ExceptionASub2();
        } catch (ExceptionA e) {
            try {
                throw e;
            } catch (ExceptionASub1 e2) {// java7 编译错误
                                         // java6 无编译错误
                //
            }
        }
    }
}
