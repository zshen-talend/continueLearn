// ============================================================================
//
// Copyright (C) 2006-2013 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package runtime;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class Main {

    public static void main(String args[]) {

         try {
             Runtime rt = Runtime.getRuntime();
//            String[] cmdArray = new String[] { "D:\\oracle\\product\\10.2.0\\client_3\\BIN\\sqlldr.exe 'shenze/shenze@(description=(address=(protocol=tcp)(host=192.168.30.151)(port=1521))(connect_data=(SID=orcl)))' CONTROL='D:/worspace/trunk/tdq/out.csv.ctl' LOG='D:/worspace/trunk/tdq/out.csv.log'" };
            String[] cmdArray = new String[] {
                    "cmd.exe",
 "/c",
 "ipconfig" };
                   // "D:/oracle/product/10.2.0/client_3/BIN/sqlldr 'talend/talend@(description=(address=(protocol=tcp)(host=192.168.30.118)(port=1521))(connect_data=(SID=talend)))' CONTROL='D:/worspace/trunk/tdq/out.csv.ctl' LOG='D:/worspace/trunk/tdq/out.csv.log'" };
                    File file = new File("D:/oracle/product/10.2.0/client_3/BIN/");
            if(file.exists()){
                System.out.println("file is exsit");
            }
            Process pr = rt
.exec(cmdArray, null, file);
            // Process pr = rt.exec("cmd.exe /c ipconfig");
         BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));
             String line=null;

             while((line=input.readLine()) != null) {
                 System.out.println(line);
             }
             int exitVal = pr.waitFor();
             System.out.println("Exited with error code "+exitVal);

         } catch(Exception e) {
             System.out.println(e.toString());
             e.printStackTrace();
         }
     }
}