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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * DOC talend class global comment. Detailled comment
 */
public class ReplaceTest {

    public static void main(String[] args) {
        String value = "salut, comment ça va! 1 rue cat";
        String regex = "[\\u0063,\\u0031]";
        Matcher lowercase = Pattern.compile(regex).matcher(value);
        Matcher numeric = Pattern.compile("cat").matcher(value);
        System.out.println(numeric.replaceAll(lowercase.replaceAll("a")));

    }
}
