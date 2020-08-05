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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JavaProcess {

    public static void main(String[] args) throws IOException, InterruptedException {

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {

            public void run() {
                System.out.println("auto clean temporary file outside");
            }
        }));
        Process process = Runtime
                .getRuntime()
                .exec("java -cp D:\\code\\g5\\continueLearn\\projects\\shenzetest\\bin\\ javatest.process.HelloWorld");
        // wait for process finished
        // if (process.waitFor() != 0) {
        // System.exit(1);
        // }
        // process = Runtime.getRuntime().exec("cmd /c java -cp ./bin HelloWorld");
        InputStream is = process.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        // call end method with a new thread but it is same with in main thread
        // new Thread(() -> {
        // String temp = null;
        // try {
        // while ((temp = br.readLine()) != null) {
        // if (temp.equals("3")) {
        // // System.exit(0);
        // process.destroy();
        // }
        // System.out.println(new String(temp.getBytes("utf-8"), "utf-8"));
        // }
        // } catch (IOException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        // }).start();
        String temp = null;
        while ((temp = br.readLine()) != null) {
            if (temp.equals("3")) {
                // current jvm hook can be call whatever which method to end
                // System.exit(0);
                process.destroy();
            }
            System.out.println(new String(temp.getBytes("utf-8"), "utf-8"));
        }
    }
}
