// ============================================================================
//
// Copyright (C) 2006-2015 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package JDK7NewFeautre;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * DOC talend class global comment. Detailled comment
 */
public class ReadFile {

    public void read(String filename) throws IOException {
        FileInputStream input = null;
        IOException readException = null;
        try {
            input = new FileInputStream(filename);
            throw new IOException("new FileInputStream IOException");
        } catch (IOException ex) {
            readException = ex;
        } finally {
            if (input != null) {
                try {
                    input.close();
                    throw new IOException("input.close IOException");
                } catch (IOException ex) {
                    if (readException != null) {
                        readException.addSuppressed(ex);
                    } else {
                        readException = ex;
                    }
                }
            }
            if (readException != null) {
                throw readException;
            }
        }
    }

    public static void main(String[] args) {
        ReadFile readFile = new ReadFile();
        try {
            readFile.read("D:\\code\\trunk1\\shenzetest\\src\\JDK7NewFeautre\\ReadFile.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}