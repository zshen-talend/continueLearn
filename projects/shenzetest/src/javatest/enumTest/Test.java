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
package javatest.enumTest;

/**
 * DOC zshen class global comment. Detailled comment
 */
public class Test {

    /**
     * DOC zshen Comment method "main".
     * 
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(EmailVerifyResult.INVALID.getResultValue());
        EmailVerifyResult.INVALID.setResultValue("1111");
        System.out.println(EmailVerifyResult.INVALID.getResultValue());
        EmailVerifyResult.CORRECTED.setResultValue("2222");
        System.out.println(EmailVerifyResult.INVALID.getResultValue());
        System.out.println(EmailVerifyResult.CORRECTED.getResultValue());

    }

}
