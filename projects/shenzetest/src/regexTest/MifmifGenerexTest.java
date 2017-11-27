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
package regexTest;

import java.security.SecureRandom;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mifmif.common.regex.Generex;

/**
 * DOC qiongli class global comment. Detailled comment
 */
public class MifmifGenerexTest {

    private static String regex = "(0033 ?|\\+33 ?|0)[1-9]([-. ]?[0-9]{2}){4}";

    private static Generex generex = null;

    /**
     * 
     * DOC qiongli Comment method "main".
     * 
     * @param args
     */
    public static void main(String[] args) {
        // "^(\\+44[[:space:]]?7[[:digit:]]{3}|\\(?07[[:digit:]]{3}\\)?)[[:space:]]?[[:digit:]]{3}[[:space:]]?[[:digit:]]{3}$"
        // String patternStr = stringStartTrim("^(?:01000|99999)(0[1-9]\\d{3}|[1-9]\\d{4})$", "\\^");
        String patternStr = stringStartTrim("[\\u4E00-\\u4E01]", "\\^");
        System.out.println(patternStr);
        patternStr = stringEndTrim(patternStr, "\\$");
        System.out.println(patternStr);
        patternStr = patternStr + "$";
        generex = new Generex(patternStr);
        generex.setSeed(105l);
        String maskResult = generex.random();
        maskResult = maskResult.substring(0, maskResult.length() - 1);
        Pattern compile = java.util.regex.Pattern.compile(patternStr);
        Matcher matcher = compile.matcher(maskResult);
        System.out.println("maskResult:" + maskResult + "----------" + matcher.matches());
        System.out.println("pattern str is valid:" + Generex.isValidPattern(patternStr));
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.setSeed(100l);
        System.out.println("pattern str is valid:" + secureRandom.nextLong());
        // Generate random String
        // generateRandom();
        //
        // // generate the second String
        // generateIndex(2);
        // // Generate First 100 String that matches the given Regex.
        // generateFirst100();

    }

    /**
     * 去掉指定字符串的开头的指定字符
     * 
     * @param stream 原始字符串
     * @param trim 要删除的字符串
     * @return
     */
    public static String stringStartTrim(String stream, String trim) {
        // null或者空字符串的时候不处理
        if (stream == null || stream.length() == 0 || trim == null || trim.length() == 0) {
            return stream;
        }
        // 要删除的字符串结束位置
        int end;
        // 正规表达式
        String regPattern = "[" + trim + "]*+";
        Pattern pattern = Pattern.compile(regPattern, Pattern.CASE_INSENSITIVE);
        // 去掉原始字符串开头位置的指定字符
        Matcher matcher = pattern.matcher(stream);
        if (matcher.lookingAt()) {
            end = matcher.end();
            stream = stream.substring(end);
        }
        // 返回处理后的字符串
        return stream;
    }

    /**
     * 去掉指定字符串的开头的指定字符
     * 
     * @param stream 原始字符串
     * @param trim 要删除的字符串
     * @return
     */
    public static String stringEndTrim(String stream, String trim) {
        // null或者空字符串的时候不处理
        if (stream == null || stream.length() == 0 || trim == null || trim.length() == 0) {
            return stream;
        }
        // 要删除的字符串结束位置
        int strat;
        // 正规表达式
        String regPattern = "[" + trim + "]*$";
        Pattern pattern = Pattern.compile(regPattern, Pattern.CASE_INSENSITIVE);
        // 去掉原始字符串开头位置的指定字符
        Matcher matcher = pattern.matcher(stream);
        if (matcher.find()) {
            strat = matcher.start();
            stream = stream.substring(0, strat);
        }
        // 返回处理后的字符串
        return stream;
    }

    // generate the second String in lexicographical order that match the given Regex.
    private static void generateIndex(int columnIndex) {
        String secondString = generex.getMatchedString(columnIndex);
        System.out.println("--------Generate the 2nd String------");
        System.out.println(secondString);// it print '0b'
        assert secondString.matches(regex);
    }

    // Generate random String
    private static void generateRandom() {

        String randomStr = generex.random();
        System.out.println("--------Generate a random string1------");
        System.out.println(randomStr);// a random value from the previous String list
        assert randomStr.matches(regex);
        randomStr = generex.random();
        System.out.println("--------Generate a random string2------");
        System.out.println(randomStr);// a random value from the previous String list
        assert randomStr.matches(regex);
    }

    // Generate First 100 String that matches the given Regex.
    private static void generateFirst100() {
        System.out.println("--------Generate first 100 String------");
        List<String> matchedStrs = generex.getMatchedStrings(100);

        System.out.println(matchedStrs.size());

        for (int j = 0; j < matchedStrs.size(); j++) {
            String out = matchedStrs.get(j);
            System.out.println("row-" + j + "   " + out);
            assert out.matches(regex);
        }
    }

    // Generate all String that matches the given Regex.but it will take more time to execute and might OutofMemory
    private static void generateAll() {

        List<String> matchedStrs = generex.getAllMatchedStrings();

        System.out.println(matchedStrs.size());// it print '0b'
        // int i = 0;
        // // Using Generex iterator
        // Iterator iterator = generex.iterator();
        // while (iterator.hasNext()) {
        // System.out.println("i:" + i + "   " + iterator.next() + " ");
        // i++;
        // }

    }

}
