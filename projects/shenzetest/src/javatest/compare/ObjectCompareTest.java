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
    
    private final static double THRESHOLD = 0.0000001;

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
        
        double d1=0.8d;
        Float F1=0.8f;
        if(d1<F1) {
            System.out.println(d1+"<" + F1);
        }
        if(F1.doubleValue()>d1) {
            System.out.println(F1+">" + d1);
        }
        if(F1.doubleValue()-d1>0) {
            System.out.println(F1+"-" + d1+">0");
            System.out.println(F1+"-" + d1+"="+(F1.doubleValue()-d1));
        }
        if(F1.floatValue()-d1>0) {
            System.out.println(F1+"-" + d1+">0");
            System.out.println(F1+"-" + d1+"="+(F1.floatValue()-d1));
        }
        if(Double.compare(F1.doubleValue(), d1)==0) {
            System.out.println(F1+"Double.compare("+F1.doubleValue()+","+d1+" )" + d1+"==0");
        }
        if(d1-F1>0.0000001) {
            System.out.println(F1+"-"+d1+" >0.0000001");
        }
        if(0.8F-0.8d>0.0000001) {
            System.out.println(F1+"-"+d1+" >0.0000001");
        }else {
            System.out.println(F1+"-"+d1+" ="+(0.8d-0.8f));
        }
        if(String.valueOf(d1).compareToIgnoreCase(String.valueOf(F1))==0) {
            System.out.println(String.valueOf(d1)+"-"+String.valueOf(F1)+"equals");
        }
    }
}
