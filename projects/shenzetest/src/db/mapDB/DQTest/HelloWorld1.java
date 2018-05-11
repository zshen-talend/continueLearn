// ============================================================================
//
// Copyright (C) 2006-2014 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package db.mapDB.DQTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentNavigableMap;

import org.mapdb.BTreeMap;
import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.Fun;
import org.mapdb.Pump;

/**
 * Hello world application to demonstrate storage open, commit and close operations
 */
public class HelloWorld1 {

    private static Random ran = new Random(1101);

    private static File dbFile = null;

    private static DB db = null;

    static boolean isPrint = false;

    public static void main(String[] args) throws IOException {

        // Configure and open database using builder pattern.
        // All options are available with code auto-completion.
        File dbFile = new File("E://mapDBaa.db");
        db = DBMaker.newFileDB(dbFile).closeOnJvmShutdown().encryptionEnable("password").make();

        // open an collection, TreeMap has better performance then HashMap

        final ConcurrentNavigableMap<List<Object>, Integer> map =
                db.createTreeMap("splitDB").comparator(new DBMapCompartor()).makeOrGet();
        for (int index = 0; index < 100000; index++) {
            List<Object> inputList = new ArrayList<>();
            int nextInt = ran.nextInt();
            inputList.add(nextInt);
            inputList.add("name" + nextInt);
            inputList.add(randomDate("2000-01-10", "2018-01-01"));
            inputList.add(ran.nextDouble());
            map.put(inputList, index);
        }

        for (List<Object> inputList : map.keySet()) {
            printData(map, inputList);
        }

        // Iterator<List<Object>> sortedIter =
        // Pump.sort(map.keySet().iterator(), false, 200, Collections.reverseOrder(map.comparator()),
        // db.getDefaultSerializer());
        long startTime = System.currentTimeMillis();
        System.out.println("starting at ----------------" + startTime);
        for (int index = 0; index <= 3; index++) {
            createSubMap(map, index);

            BTreeMap<List<Object>, Object> treeMap = db.getTreeMap("splitDB_" + index);
            Iterator<List<Object>> sortedIter = treeMap.keySet().iterator();
            System.out.println();
            while (sortedIter.hasNext()) {
                List<Object> next = sortedIter.next();
                printData(map, next);
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("end at ----------------" + endTime);
        System.out.println("spent ----------------" + (endTime - startTime));
        db.close();

    }

    /**
     * DOC zshen Comment method "createSubMap".
     */
    private static void createSubMap(final ConcurrentNavigableMap<List<Object>, Integer> map, Integer colIndex) {
        db.delete("splitDB_" + colIndex);
        Iterator<List<Object>> sortedIter =
                Pump.sort(map.keySet().iterator(), false, 200,
                        Collections.reverseOrder(new DBMapSpecialColCompartor(colIndex)), db.getDefaultSerializer());

        // System.out.println();
        // while (sortedIter.hasNext()) {
        // List<Object> next = sortedIter.next();
        // System.out.println(map.get(next) + "==>" + next);
        // }

        db.createTreeMap("splitDB_" + colIndex).pumpSource(sortedIter, new Fun.Function1<Integer, List<Object>>() {

            @Override
            public Integer run(List<Object> a) {
                return map.get(a);
            }

        }).comparator(new DBMapSpecialColCompartor(colIndex)).make();

    }

    /**
     * 获取随机日期
     * 
     * @param beginDate
     * 起始日期，格式为：yyyy-MM-dd
     * @param endDate
     * 结束日期，格式为：yyyy-MM-dd
     * @return
     */

    private static Date randomDate(String beginDate, String endDate) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date start = format.parse(beginDate);// 构造开始日期
            Date end = format.parse(endDate);// 构造结束日期
            // getTime()表示返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。
            if (start.getTime() >= end.getTime()) {
                return null;
            }
            long date = random(start.getTime(), end.getTime());

            return new Date(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static long random(long begin, long end) {
        long rtn = begin + (long) (ran.nextDouble() * (end - begin));
        // 如果返回的是开始时间和结束时间，则递归调用本函数查找随机值
        if (rtn == begin || rtn == end) {
            return random(begin, end);
        }
        return rtn;
    }

    /**
     * DOC zshen Comment method "printData".
     * 
     * @param map
     * @param next
     */
    protected static void printData(ConcurrentNavigableMap<List<Object>, Integer> map, List<Object> next) {
        if (isPrint) {
            System.out.println(map.get(next) + "==>" + next);
        }
    }
}