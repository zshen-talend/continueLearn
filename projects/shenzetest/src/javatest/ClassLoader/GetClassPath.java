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
package javatest.ClassLoader;


/**
 * DOC zshen  class global comment. Detailled comment
 */


import java.io.File;
import java.io.IOException;
import java.net.URL;

public class GetClassPath {

    public static void main(String[] args) {

        System.out.println(GetClassPath.getClassPath());
        File file = new File("index.html");
        try {
            System.out.println("获得webroot下文件的路径" + file.getCanonicalPath());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

/**

*在类中取得当前文件所在的相对路径与绝对路径

*

* @return String

*/

    public static String getClassPath() {
        String strClassName = GetClassPath.class.getName();
        String strPackageName = "";
        if (GetClassPath.class.getPackage() != null)
        {
            strPackageName = GetClassPath.class.getPackage().getName();
        }
        System.out.println("ClassName:" + strClassName);
        System.out.println("PackageName:" + strPackageName);
        String strClassFileName = "";
        if (!"".equals(strPackageName))
        {
            strClassFileName = strClassName.substring(strPackageName.length() + 1, strClassName.length());
        }
        else
        {
            strClassFileName = strClassName;
        }
        System.out.println("ClassFileName:" + strClassFileName);
        URL url = null;
        url = GetClassPath.class.getResource(strClassFileName + ".class");
        String strURL = url.toString();
        // strURL=strURL.substring(strURL.indexOf('/') + 1, strURL.lastIndexOf('/'));
        String result = "获得类的路径" + strClassFileName + "物理路径："
 + strURL;
        System.out.println(result);
        return strURL;
    }
}
