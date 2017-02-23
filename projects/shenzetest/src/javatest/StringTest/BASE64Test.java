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
package javatest.StringTest;

import sun.misc.BASE64Decoder;

/**
 * created by talend on Mar 31, 2015 Detailled comment
 *
 */
public class BASE64Test {

    public static String getBASE64(String s) {
        if (s == null) {
            return null;
        }
        return (new sun.misc.BASE64Encoder()).encode(s.getBytes());
    }

    // 将 BASE64 编码的字符串 s 进行解码
    public static String getFromBASE64(String s) {
        if (s == null) {
            return null;
        }
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            byte[] b = decoder.decodeBuffer(s);
            return new String(b);
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String args[]) {
        String testString = "申泽";
        String base64Str = getBASE64(testString);
        System.out.println("test string: " + testString);
        System.out.print("encode : ");
        System.out.println(base64Str);
        System.out.print("decode : ");
        System.out.println(getFromBASE64(base64Str));

    }
}
