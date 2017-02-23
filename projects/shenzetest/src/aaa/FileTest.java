// ============================================================================
//
// Copyright (C) 2006-2009 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package aaa;

/**
 * DOC Administrator class global comment. Detailled comment
 */
public class FileTest {

    /**
     * DOC Administrator Comment method "main".
     * 
     * @param args
     */
    public static void main(String[] args) {
        String sWorkspaceDir_tLaunchDQReports_1 = new String(new java.io.File(
                "D:/eclipse_3.5_talend/TalendDataQuality-win32-x86.exe").getParent()).replace('\\', '/');
        System.out.println(sWorkspaceDir_tLaunchDQReports_1);
    }

}
