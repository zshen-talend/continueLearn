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

import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {

    Timer timer;

    public TimerTest(int seconds) {
        timer = new Timer();
        timer.schedule(new TimerTestTask(), seconds * 1000);
    }

    class TimerTestTask extends TimerTask {

        @Override
        public void run() {
            System.out.println("In TimerTestTask, execute run method.");
            timer.cancel();
        }
    }

    public static void main(String args[]) {
        System.out.println("Prepare to schedule task.");
        new TimerTest(2);
        System.out.println("Task scheduled.");
    }
}
