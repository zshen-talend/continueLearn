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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import routines.system.FormatterUtils;
import routines.system.ParserUtils;

/**
 * DOC zshen class global comment. Detailled comment
 */
public class DataFormateTest {

    public static void main(String args[]) {
        String x = "Wed May 06 16:22:55 CST 2020";
        SimpleDateFormat sdf1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
        try {
            Date date = sdf1.parse(x);
            System.out.println("。。。。" + date);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH时");
            String sDate = sdf.format(date);
            System.out.println(sDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Date date1 = new Date();
        System.out.println(date1.toString());
        Date date2 = ParserUtils.parseTo_Date("1985-11-11", "yyyy-MM-dd");
        System.out.println(date2);
        SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
        Date date3 = null;
        try {
            date3 = format.parse("Mon Sep 04 13:53:45 CST 2017");
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(date3);
//        Date date4 = ParserUtils.parseTo_Date("Mon Sep 04 13:53:45 CST 2017", "EEE MMM dd HH:mm:ss zzz yyyy");
        System.out.println(FormatterUtils.format_Date(date3, "yyyy-MM-dd"));
        
        String dateStr="14-05-2019";
        Date readDate = ParserUtils.parseTo_Date(dateStr, "dd-MM-yyyy");
        System.out.println(new java.sql.Date(readDate.getTime()).toString());
    }

}
