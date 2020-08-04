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
package javatest.compare;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * DOC zshen class global comment. Detailled comment
 */
public class ObjectCompareTest {

    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = simpleDateFormat.parse("2000-08-08");
        Date date2 = simpleDateFormat.parse("2000-08-08");
        System.out.println(date1.equals(date2));
        Map<Object, Integer> map = new HashMap<>();
        map.put(date1, 1);
        map.put(date2, 2);
        System.out.println("map size is " + map.size());

        Set<Object> set = new HashSet<>();
        set.add(date1);
        set.add(date2);
        System.out.println("set size is " + set.size());
    }
}
