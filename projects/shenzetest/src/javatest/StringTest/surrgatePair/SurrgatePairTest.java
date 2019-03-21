// ============================================================================
//
// Copyright (C) 2006-2018 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package javatest.StringTest.surrgatePair;

public class SurrgatePairTest {

    public static void main(String[] args) {
        String inpuStr = "中崎𠀀𠀁𠀂𠀃𠀄"; //$NON-NLS-1$
        int codePointCount = inpuStr.codePointCount(0, inpuStr.length());
        System.out.println(inpuStr + "的长度是:" + codePointCount); //$NON-NLS-1$
        System.out.println(inpuStr + "3到5的字符是:" //$NON-NLS-1$
                + inpuStr.substring(inpuStr.offsetByCodePoints(0, 3), inpuStr.offsetByCodePoints(0, 5)));

        System.out.println(inpuStr + "第三个char是否是surrogatePair:" + Character.isHighSurrogate(inpuStr.charAt(2))); //$NON-NLS-1$
        System.out.println(inpuStr + "第三个char是:" //$NON-NLS-1$
                + (Character.isHighSurrogate(inpuStr.charAt(2)) ? inpuStr.substring(2, 4) : inpuStr.charAt(2)));
        System.out.println("The count size is " + getRealSize(inpuStr, 5));//8 //$NON-NLS-1$
        System.out.println("The string is  " + inpuStr.substring(0, getRealSize(inpuStr, 5))); //$NON-NLS-1$
        System.out.println("The count size is " + getRealSize(inpuStr, 6));//10 //$NON-NLS-1$
        System.out.println("The string is  " + inpuStr.substring(0, getRealSize(inpuStr, 6))); //$NON-NLS-1$
        inpuStr = "中崎𠀀中𠀁𠀂𠀃𠀄"; //$NON-NLS-1$
        System.out.println("The count size is " + getRealSize(inpuStr, 5));//7 //$NON-NLS-1$
        System.out.println("The string is  " + inpuStr.substring(0, getRealSize(inpuStr, 5))); //$NON-NLS-1$
        System.out.println("The count size is " + getRealSize(inpuStr, 6));//9 //$NON-NLS-1$
        System.out.println("The string is  " + inpuStr.substring(0, getRealSize(inpuStr, 6))); //$NON-NLS-1$
        //        inpuStr = "吉田あいうえお"; //$NON-NLS-1$
        //        System.out.println("The count size is " + getRealSize(inpuStr, 8));//7 //$NON-NLS-1$
        //        System.out.println("The string is  " + inpuStr.substring(0, getRealSize(inpuStr, 8) - 1)); //$NON-NLS-1$
        //        System.out.println("The count size is " + getRealSize(inpuStr, 9));//9 //$NON-NLS-1$
        //        System.out.println("The string is  " + inpuStr.substring(0, getRealSize(inpuStr, 9) - 1)); //$NON-NLS-1$
        inpuStr = " AＡaaaa  111C你我 他  中崎𠀀中𠀁a𠀂 𠀃𠀄"; //$NON-NLS-1$
        System.out.println(inpuStr
                + " replace all number  " + inpuStr.replaceAll("[[^\\p{IsAlnum}]&&[^\\p{IsWhite_Space}]]", "")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        System.out.println(inpuStr + " replace all number  " + replaceNonAlnumAndSpace(inpuStr, "")); //$NON-NLS-1$ //$NON-NLS-2$ 
        System.out.println(inpuStr
                + " conatins surrogate pair  " + (inpuStr.length() != inpuStr.codePointCount(0, inpuStr.length()))); //$NON-NLS-1$ 
        inpuStr = " AＡaaaa  111C你我 他  中崎中a "; //$NON-NLS-1$
        System.out.println(inpuStr
                + " conatins surrogate pair  " + (inpuStr.length() != inpuStr.codePointCount(0, inpuStr.length()))); //$NON-NLS-1$ 
    }

    public static int getRealSize(String input, int originalSize) {
        if (originalSize > input.length()) {
            return input.codePointCount(0, input.length()) + originalSize - input.length();
        }
        int codePointCount = input.codePointCount(0, originalSize);
        int lostNum = originalSize - codePointCount;
        int newSize = originalSize + lostNum * 2;
        if (Character.isHighSurrogate(input.charAt(newSize - 1))) {
            newSize++;
        }
        return newSize;
    }

    public static String replaceNonAlnumAndSpace(String inputStr, String replaceStr) {
        String resultStr = ""; //$NON-NLS-1$
        for (char str : inputStr.toCharArray()) {
            if (Character.isLetter(str) || Character.isDigit(str) || Character.isWhitespace(str)) {
                resultStr += str;
            }
        }
        return resultStr;
    }
}
