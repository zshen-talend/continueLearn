package memory;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

public class ShowMemory {
    static String x;
    public static void main(String arg[]) {
        ShowMemory sm = new ShowMemory();
        sm.show();
        x = "";
        for(int i=0; i<1000; i++)
            x += " string number " + i;
        sm.show();
        x = null;
        sm.show();
        MemoryMXBean mem = ManagementFactory.getMemoryMXBean();
        mem.gc();
        sm.show();
    }
    void show() {
        MemoryMXBean mem = ManagementFactory.getMemoryMXBean();
        MemoryUsage heap = mem.getHeapMemoryUsage();
        System.out.println("Heap committed=" + heap.getCommitted() +
                            " init=" + heap.getInit() +
                            " max=" + heap.getMax() +
                            " used=" + heap.getUsed());
    }
}