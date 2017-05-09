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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * DOC zshen class global comment. Detailled comment
 */
public class JavaRegexTest {

    public static void main(String args[]) {
        String str = "\u2EF3";
        String regex = "^\\p{script=Han}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        System.out.println(m.find());
    }
}
