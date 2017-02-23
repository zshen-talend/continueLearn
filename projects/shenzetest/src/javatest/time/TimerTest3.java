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

/**
 * created by talend on Sep 18, 2014 Detailled comment
 * 
 */
public class TimerTest3 {

    private static int count = 0;

    public static void main(String[] args) {
        class MyTimerTask extends TimerTask {

            @Override
            public void run() {
                count = (count + 1) % 2;
                System.out.println("boom...");// 2.2秒后打印...... 4.4秒后再打印
                new Timer().schedule(new MyTimerTask(), 2000 + 2000 * count);// 3.4秒后执行
            }
        }
        new Timer().schedule(new MyTimerTask(), 2000);// 1.过2秒执行
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