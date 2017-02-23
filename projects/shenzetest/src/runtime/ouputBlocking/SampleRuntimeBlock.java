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
package runtime.ouputBlocking;

import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * created by zshen on Jun 28, 2013
 * Detailled comment
 *
 */
public class SampleRuntimeBlock {

    /**
     * DOC zshen Comment method "main".
     * 
     * @param args
     */
    public static void main(String[] args) {
        try {
            Runtime rt = Runtime.getRuntime();
            String[] cmdArray = new String[] { "cmd.exe", "/c", "ipconfig" };
            Process pr = rt.exec(cmdArray);
            BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            String line = null;

            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
            int exitVal = pr.waitFor();
            System.out.println("Exited with error code " + exitVal);

        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }

}
