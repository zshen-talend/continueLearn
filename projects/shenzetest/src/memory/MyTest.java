// ============================================================================
//
// Copyright (C) 2006-2012 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package memory;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryPoolMXBean;
import java.lang.management.MemoryType;
import java.lang.management.MemoryUsage;

/**
 * created by talend on Aug 28, 2012 Detailled comment
 * 
 */
public class MyTest {

    public static void main(String arg[]) {
        MyTest m1 = new MyTest();
        MemoryMXBean mem = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapMemoryUsage = mem.getHeapMemoryUsage();
        MemoryPoolMXBean pool = m1.findTenuredGenPool();
        pool.setUsageThreshold(6900368);
        boolean lowMemory = false;
        // while (true) {
        // // if (pool.isUsageThresholdExceeded()) {
        // // // potential low memory, so redistribute tasks to other VMs
        // // lowMemory = true;
        // // redistributeTasks();
        // // // stop receiving new tasks
        // // stopReceivingTasks();
        // // } else {
        // // if (lowMemory) {
        // // // resume receiving tasks
        // // lowMemory = false;
        // // resumeReceivingTasks();
        // // }
        // // // processing outstanding task
        // // ...
        // }
        // sleep for sometime
        // try {
        // Thread.sleep(sometime);
        // } catch (InterruptedException e) {
        // ...
        // }

    }

    private MemoryPoolMXBean findTenuredGenPool() {
        for (MemoryPoolMXBean pool : ManagementFactory.getMemoryPoolMXBeans()) {
            if (pool.getType() == MemoryType.HEAP && pool.isUsageThresholdSupported()) {
                return pool;
            }
        }
        return null;
    }
}
