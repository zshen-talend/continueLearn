package javatest.StringTest;

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
import java.nio.charset.Charset;

public class EncodingExplainer {

    private static final String[] TEST_CASES = { "éàùïô", "中国", "北京" };

    private static final String[] CHARSETS = { "cp1252", "iso8859-1", "gb2312", "utf-8" };

    private static final String TOP_LEFT_LABEL = "Encode\\Decode";

    private static final int MAX_LENGTH = 14;

    /**
     * @param args
     */
    public static void main(String[] args) {
        for (String text : TEST_CASES) {
            printEncodingTableFor(text);
        }
    }

    private static void printEncodingTableFor(String text) {

        System.out.println("----------Test for <" + text + ">-----------");
        for (int i = 0; i < CHARSETS.length + 1; i++) { // rows
            for (int j = 0; j < CHARSETS.length + 1; j++) { // columns
                if (i == 0) { // print table head
                    if (j == 0) {
                        System.out.print(appendWhitespaces(TOP_LEFT_LABEL));
                    } else {
                        System.out.print(appendWhitespaces(CHARSETS[j - 1]));
                    }
                } else { // print table content
                    if (j == 0) {
                        System.out.print(appendWhitespaces(CHARSETS[i - 1]));
                    } else {
                        System.out.print(appendWhitespaces(decodeWith(encodeWith(text, CHARSETS[i - 1]), CHARSETS[j - 1])));
                    }
                }
                if (j == CHARSETS.length) {
                    System.out.println();
                }

            }
        }
        System.out.println();
    }

    private static byte[] encodeWith(String text, String charsetName) {
        return text.getBytes(Charset.forName(charsetName));
    }

    private static String decodeWith(byte[] bytes, String charsetName) {
        return new String(bytes, Charset.forName(charsetName));
    }

    private static String appendWhitespaces(String text) {
        int num = MAX_LENGTH - text.length();
        for (int i = 0; i < num; i++) {
            text += " ";
        }
        text += "\t";
        return text;
    }

}
