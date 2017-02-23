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
package connectionPool;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import odbc.JdbcGetSchema;

/**
 * DOC OWNER class global comment. Detailled comment
 */
public class ResourceManager {

    private static Properties prop;
    static {
        InputStream is = ResourceManager.class.getResourceAsStream("resourceBundle.properties");
        prop = new Properties();
        try {
            prop.load(is);
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    // public static String getDriverClass() {
    // return r.getString("connection.driverClass");
    // }
    //
    // public static String getUrl() {
    // return r.getString("connection.url");
    // }
    //
    // public static String getUsername() {
    // return r.getString("connection.username");
    // }
    //
    // public static String getPassword() {
    // return r.getString("connection.password");
    // }

    public static int getPoolSize() {
        int poolSize = Integer.valueOf(prop.getProperty("connection.poolSize"));
        return poolSize;
    }

    public static void refresh() {
        InputStream is = ResourceManager.class.getClassLoader().getResourceAsStream("resourceBundle.properties");
        prop = new Properties();
        try {
            prop.load(is);
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    /**
     * DOC OWNER Comment method "main".
     * 
     * @param args
     */
    public static void main(String[] args) {
        try {
            Connection conn = JdbcGetSchema.getMySqlConnection();
        } catch (Exception e) {

            e.printStackTrace();
        }

    }

}
