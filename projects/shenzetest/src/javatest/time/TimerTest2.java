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
package javatest.time;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest2 {

    public static void main(String[] args) {
        // 调用schedule方法执行任务
        new Timer().schedule(new TimerTask() {

            @Override
            public void run() {
                System.out.println("boom...");
            }
        }, 10000, 3000);// 过10秒执行，之后每隔3秒执行一次

        // 每隔1秒打印一次时间
        while (true) {
            System.out.println(new Date().getSeconds());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}