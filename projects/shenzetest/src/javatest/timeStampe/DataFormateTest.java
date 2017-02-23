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
package javatest.timeStampe;

import java.util.Date;

import routines.system.FormatterUtils;
import routines.system.ParserUtils;

/**
 * DOC zshen class global comment. Detailled comment
 */
public class DataFormateTest {

    public static void main(String args[]) {
        Date date1 = new Date();
        System.out.println(date1.toString());
        Date date2 = ParserUtils.parseTo_Date("1985-11-11", "yyyy-MM-dd");
        System.out.println(date2);
        Date date3 = ParserUtils.parseTo_Date("Thu May 22 00:00:00 CST 1980", "EEE MMM dd HH:mm:ss zzz yyyy");
        System.out.println(FormatterUtils.format_Date(date3, "yyyy-MM-dd"));
    }
}
