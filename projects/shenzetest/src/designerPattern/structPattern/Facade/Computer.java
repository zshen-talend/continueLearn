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
package designerPattern.structPattern.Facade;

/**
 * created by talend on Dec 12, 2014 Detailled comment
 * 
 */
public class Computer {

    private CPU cpu;

    private Memory memory;

    private Disk disk;

    public Computer() {
        cpu = new CPU();
        memory = new Memory();
        disk = new Disk();
    }

    public void startup() {
        System.out.println("start the computer!"); //$NON-NLS-1$
        cpu.startup();
        memory.startup();
        disk.startup();
        System.out.println("start computer finished!"); //$NON-NLS-1$
    }

    public void shutdown() {
        System.out.println("begin to close the computer!"); //$NON-NLS-1$
        cpu.shutdown();
        memory.shutdown();
        disk.shutdown();
        System.out.println("computer closed!"); //$NON-NLS-1$
    }
}
