// ============================================================================
//
// Copyright (C) 2006-2015 Talend Inc. - www.talend.com
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

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * DOC talend class global comment. Detailled comment
 */
public class encodingTest {

    static String chartSet = "utf-8";

    public static void main(String args[]) throws UnsupportedEncodingException {
        // System.out.println(encodeWith("中", chartSet));
        // System.out.println(decodeWith(encodeWith("中", chartSet), chartSet));
        // System.out.println(URLEncoder.encode("中", chartSet));
        // System.out.println(URLDecoder.decode("%E4%B8%81", chartSet));
        System.out.println(decode("\\U3041"));
        System.out.println(decode(convertUnicode(0X3041)));
    }

    private static byte[] encodeWith(String text, String charsetName) {
        return text.getBytes(Charset.forName(charsetName));
    }

    private static String decodeWith(byte[] bytes, String charsetName) {
        return new String(bytes, Charset.forName(charsetName));
    }

    public static String decode(String unicodeStr) {
        if (unicodeStr == null) {
            return null;
        }
        StringBuffer retBuf = new StringBuffer();
        int maxLoop = unicodeStr.length();
        for (int i = 0; i < maxLoop; i++) {
            if (unicodeStr.charAt(i) == '\\') {
                if ((i < maxLoop - 5) && ((unicodeStr.charAt(i + 1) == 'u') || (unicodeStr.charAt(i + 1) == 'U'))) {
                    try {
                        retBuf.append((char) Integer.parseInt(unicodeStr.substring(i + 2, i + 6), 16));
                        i += 5;
                    } catch (NumberFormatException localNumberFormatException) {
                        retBuf.append(unicodeStr.charAt(i));
                    }
                } else {
                    retBuf.append(unicodeStr.charAt(i));
                }
            } else {
                retBuf.append(unicodeStr.charAt(i));
            }
        }
        return retBuf.toString();
    }

    public static String convertUnicode(int codeVlaue) {
        return "\\u" + Integer.toHexString(codeVlaue);
    }
}
