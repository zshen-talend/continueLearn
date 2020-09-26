// ============================================================================
//
// Copyright (C) 2006-2020 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package javatest.process;


public class HelloWorld {

    public static void main(String[] args) throws InterruptedException {
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {

            public void run() {
                System.out.println("auto clean temporary file");
            }
        }));
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                System.exit(0);
            }
            System.out.println(i);
            Thread.sleep(10000);
        }
    }

}
