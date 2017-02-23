// ============================================================================
//
// Copyright (C) 2006-2011 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package javatest.memoryTest;

import java.util.Date;
 
 
public class MemoryLeakTest {
 
    public static int n = 1;
    static int count = 20000;
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
 
    System.out.println(new Date() + " before memory:" + Runtime.getRuntime().totalMemory());
 
        for(int i = 0; i < count; ++i)
        {
            java.awt.EventQueue.invokeLater(new Runnable(){
 
 
 
                public void run() {
 
                    try {
                        Thread.currentThread().sleep(1);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
 
                    n++;
 
                    if(n == count)
                    {
                        System.out.println(new Date() + " now system exit " + Runtime.getRuntime().totalMemory());
                    }
 
                }
 
            });
        }
 
    System.out.println(new Date() +"  after memory:" + Runtime.getRuntime().totalMemory());
 
    }
 
}