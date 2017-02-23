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
package zip;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.zip.Adler32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * DOC zshen  class global comment. Detailled comment
 */
public class Zipstream {
    public static void main(String[] args) throws Exception{
        FileOutputStream f = new FileOutputStream("c:\\text.zip");
     CheckedOutputStream csum=new CheckedOutputStream(f,new Adler32());
     ZipOutputStream zos=new ZipOutputStream(csum);
     BufferedOutputStream out = new BufferedOutputStream(zos);
     zos.setComment("A test of Java Ziping!");
     
        BufferedReader in = new BufferedReader(new FileReader("c:\\ssssss.csv"));
        zos.putNextEntry(new ZipEntry("ssssss.csv"));
     int c;
     while((c = in.read()) != -1){
      out.write(c); 
     }
     in.close();
     out.flush();
     out.close();
    }
   }
