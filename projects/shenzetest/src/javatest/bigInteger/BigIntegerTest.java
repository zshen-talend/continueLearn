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
package javatest.bigInteger;

import java.math.BigInteger;


/**
 * DOC zshen  class global comment. Detailled comment
 */
public class BigIntegerTest {

    public static void main(String args[]) {
        BigInteger b1 = new BigInteger("193");
        BigInteger mod = b1.mod(new BigInteger("97"));
        System.out.println(97 - mod.intValue());
    }
}
