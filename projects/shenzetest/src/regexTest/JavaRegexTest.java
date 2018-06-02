// ============================================================================
//
// Copyright (C) 2006-2011 Talend Inc. - www.talend.com
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * DOC zshen class global comment. Detailled comment
 */
public class JavaRegexTest {

    static String[][] checkRanges = { { "4E00", "9FFF", "CJK Unified Ideographs" },// CJK Unified Ideographs (Han)
                                                                                   // (35MB)
            { "3400", "4DBF", "CJK Extension-A" },// CJK Extension-A (6MB)
            { "20000", "2A6DF", "CJK Extension B" },// CJK Extension B (40MB)
            { "2A700", "2B73F", "CJK Extension C" },// CJK Extension C (3MB)
            { "2B740", "2B81F", "CJK Extension D" },// CJK Extension D
            { "2B820", "2CEAF", "CJK Extension E" },// CJK Extension E (3.5MB)
            { "F900", "FAFF", "CJK Compatibility Ideographs" },// CJK Compatibility Ideographs
            { "2F800", "2FA1F", "CJK Compatibility Ideographs Supplement" },// CJK Compatibility Ideographs Supplement
            { "2F00", "2FDF", "CJK Radicals / KangXi Radicals" },// CJK Radicals / KangXi Radicals
            { "2E80", "2EFF", "CJK Radicals Supplement" },// CJK Radicals Supplement
            { "31C0", "31EF", "CJK Strokes" },// CJK Strokes
            { "3000", "303F", "CJK Symbols and Punctuation" }, // CJK Symbols and Punctuation
            { "16FE0", "16FFF", "Ideographic Symbols and Punctuation" }, // Ideographic Symbols and Punctuation
            { "FE30", "FE4F", "CJK Compatibility Forms" }, // CJK Compatibility Forms
            { "FF00", "FFEF", "Halfwidth and Fullwidth Forms" }, // Ideographic Description Characters
            { "FE50", "FE6F", "Small Form Variants" }, // Small Form Variants
            { "FE10", "FE1F", "Vertical Forms" }, // Vertical Forms
            { "3200", "32FF", "Enclosed CJK Letters and Months" }, // Enclosed CJK Letters and Months
            { "1F200", "1F2FF", "Enclosed Ideographic Supplement" }, // Enclosed Ideographic Supplement
            { "3300", "33FF", "CJK Compatibility" }, // CJK Compatibility
            { "2100", "214F", "Additional Squared Symbols" }, // Additional Squared Symbols
            { "1100", "11FF", "Hangul Jamo" }, // Hangul Jamo
            { "A960", "A97F", "Hangul Jamo Extended-A" }, // Hangul Jamo Extended-A
            { "D7B0", "D7FF", "Hangul Jamo Extended-B" }, // Hangul Jamo Extended-B
            { "3130", "318F", "Hangul Compatibility Jamo" }, // Hangul Compatibility Jamo
            { "FFA0", "FFDC", "Halfwidth Jamo" }, // Halfwidth Jamo
            { "AC00", "D7AF", "Hangul Syllables" }, // Hangul Syllables
            { "3040", "309F", "Hiragana" }, // Hiragana
            { "30A0", "30FF", "Katakana" }, // Katakana
            { "31F0", "31FF", "Katakana Phonetic Extensions" }, // Katakana Phonetic Extensions
            { "1B000", "1B0FF", "Kana Supplement" }, // Kana Supplement
            { "FF65", "FF9F", "Halfwidth Katakana" }, // Halfwidth Katakana
            { "3190", "319F", "Kanbun" }, // Kanbun
            { "A4D0", "A4FF", "Lisu" }, // Lisu
            { "16F00", "16F9F", "Miao" }, // Miao
            { "17000", "187FF", "CJK Compatibility" }, // CJK Compatibility
            { "18800", "18AFF", "Tangut Components" }, // Tangut Components
            { "A000", "A48F", "Yi Syllables" }, // Yi Syllables
            { "A490", "A4CF", "Yi Radicals" } // Yi Radicals
            };

    public static void main(String args[]) {
        // JavaRegexTest javaRegexTest = new JavaRegexTest();
        // javaRegexTest.printRangeOfHan();
        // javaRegexTest.checkSingleCharacter();
        for (int i = 0; i < 3; i++) {
            SecureRandom secureRandom = new SecureRandom();
            // secureRandom.setSeed(100L);
            System.out.println(secureRandom.nextInt());
        }

    }

    public void checkSingleCharacter() {
        String str = String.valueOf(Character.toChars(40909));
        // str = "^\\u4E00$";
        String regex = "^\\p{script=Han}$";

        Character.UnicodeBlock ub = Character.UnicodeBlock.of(40909);
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        System.out.println(Character.toChars(40909));
        System.out.println(str);
        System.out.println(m.find());
        System.out.println(ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS);
        System.out.println(CharSetUtil.decodeUnicode(str));
        System.out.println(CharSetUtil.convert(str));
    }

    public void printRangeOfHan() {
        // int count = 0;
        for (String[] blockRange : checkRanges) {
            System.out.println(blockRange[2] + ":");
            int StratIndex = 0;
            int endIndex = 0;
            for (int index = Integer.valueOf(blockRange[0], 16); index <= Integer.valueOf(blockRange[1], 16); index++) {
                String str = String.valueOf(Character.toChars(index));
                String regex = "^\\p{script=Han}$";
                Pattern p = Pattern.compile(regex);
                Matcher m = p.matcher(str);
                boolean find = m.find();
                if (find == true && StratIndex == 0) {
                    StratIndex = index;
                } else if (find == false && StratIndex > 0 && endIndex == 0) {
                    endIndex = index - 1;
                    System.out.println("[" + Integer.toHexString(StratIndex).toUpperCase() + "-"
                            + Integer.toHexString(endIndex).toUpperCase() + "]");
                    StratIndex = 0;
                    endIndex = 0;
                }
                // System.out.println(str + "(" + index + ") : " + m.find());
                // count++;
                // if (count == 10) {
                // return;
                // }
            }
            if (StratIndex > 0 && endIndex == 0) {
                endIndex = Integer.valueOf(blockRange[1], 16);
                System.out.println("[" + Integer.toHexString(StratIndex).toUpperCase() + "-"
                        + Integer.toHexString(endIndex).toUpperCase() + "]");
                StratIndex = 0;
                endIndex = 0;
            }
        }
    }

}
