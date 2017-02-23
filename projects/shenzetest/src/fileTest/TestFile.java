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
package fileTest;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * DOC Administrator class global comment. Detailled comment
 */
public class TestFile {

    Map<Object, Object> objectMap = new HashMap<Object, Object>();

    /**
     * DOC Administrator Comment method "main".
     * 
     * @param args
     */
    public void TestMethod1() {
        File file = new File(
                "E:\\TDQ_EE_MPX-All-r39834-V4.0.0\\TDQ_EE_MPX-All-r39834-V4.0.0\\workspace\\NEWPROJECT\\TDQ_Data Profiling\\Reports\\cmVwb3J0NA==20100423040856_0.1.rep");
        if (objectMap.get(file) == null) {
            objectMap.remove(file);
            objectMap.put(file, file.getName());
        }
    }

    /**
     * DOC Administrator Comment method "main".
     * 
     * @param args
     */
    public void TestMethod2() {
        File file = new File(new File("C:/Users/talend/Desktop/aa/fname_index").getName()); //$NON-NLS-1$
        file.toString();
        if (file.exists()) {
            System.out.println("true"); //$NON-NLS-1$
        }
        System.out.println("false"); //$NON-NLS-1$
    }

    public static void main(String[] args) {
        TestFile classInstance = new TestFile();
        classInstance.TestMethod2();
    }
}
