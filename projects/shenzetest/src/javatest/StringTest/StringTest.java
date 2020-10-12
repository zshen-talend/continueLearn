// ============================================================================
//
// Copyright (C) 2006-2009 Talend Inc. - www.talend.com
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

import java.util.ArrayList;
import java.util.List;

/**
 * DOC Administrator class global comment. Detailled comment
 */
public class StringTest {

    List<String> list_a = null;

    List<String> list_b = null;

    /**
     * DOC Administrator Comment method "main".
     *
     * @param args
     */
    public static void main(String[] args) {
        // String charsToReplace =
        // "abcdefghijklmnopqrstuvwxyz\303\247\303\242\303\252\303\256\303\264\303\273\303\251\303\250\303\271\303\257\303\266\303\274ABCDEFGHIJKLMNOPQRSTUVWXYZ\303\207\303\202\303\212\303\216\303\224\303\233\303\211\303\210\303\231\303\217\303\226\303\2340123456789";
        // System.out.println(charsToReplace);
        // String StringAddInt = "a";
        // StringAddInt = StringAddInt + 1;
        // StringTest test1 = new StringTest();
        //
        // String.valueOf("null");
        // test1.ListOperation();
        //
        // // String testConvertToNull = String.valueOf(null);
        // // System.out.println("=========>String+1" + testConvertToNull);
        // System.out.println("=========>String.equals(null);" + StringAddInt.equals(null));
        // String a = Integer.toString("中".charAt(0), 16);
        // // System.out.println('20013');
        // System.out.println((char) Integer.valueOf(a, 16).intValue());
        // System.out.println(new Character("\\u" + a));
        // String aa = null;
        // System.out.println("111111111111111111111111111111111111111111111" + Integer.valueOf(aa));
        // StringBuffer stringBuffer = new StringBuffer();
        // stringBuffer.append(aa);
        "HOUSTON".hashCode(); //$NON-NLS-1$
        System.out.println("context.new1".split("context.")[1]);
        System.out.println(Integer.valueOf(String.valueOf('9')));
        System.out.println("aa" + System.getProperty("line.separator") + "bb");
        System.out.println("aa" + null + "bb");
        String null1 = "aa";
        String null2 = null;
        System.out.println(null1 instanceof Comparable);
        // System.out.println(null1.compareTo(null2));
        System.out
                .println("aaa \r\n  bbb".trim().replaceAll("\r|\n|   ", "").replaceAll("   ", ""));
        String formatStr = "\"Message-ID:  9371922.1072131931298.JavaMail.evans@thyme\r\n"
                + "Date: Tue, 16 Oct 2001 08:51:10 -0700 (PDT)\r\n" + "From: liz.taylor@enron.com\r\n"
                + "Subject: Mtg w/Mike Mears & Gene Vinogradoffw/the U.S. Gov. & Mr. Lay\r\n" + "Mime-Version: 1.0\r\n"
                + "Content-Type: text/plain; charset=us-ascii\r\n" + "Content-Transfer-Encoding: 7bit";
        System.out
                .println(formatStr.trim().replaceAll("\r|\n|   ", "").replaceAll("   ", ""));
        String[] split = "context.new1, context.new2".split(",");
        String fileNameStr = "";
        String result = "";
        for (int i = 0; i < split.length; i++) {
            if (i > 0) {
                fileNameStr += "+\",\"+";
            }
            fileNameStr += split[i];
        }
        if (fileNameStr.length() > 0) {
            result = fileNameStr;
        }
        System.out.println("the result is: " + result);
    }

    public void ListOperation() {
        list_a = new ArrayList<String>();
        list_b = new ArrayList<String>();
        for (int index = 0; index < 10; index++) {
            list_a.add(String.valueOf("shenze" + index));
        }
        list_b = null;
        for (int index = 0; index < 10; index++) {
            list_a.remove(index);
        }
        System.out.println("end");

    }

}
