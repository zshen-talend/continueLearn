import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

// ============================================================================
//
// Copyright (C) 2006-2010 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================

/**
 * DOC zshen  class global comment. Detailled comment
 */
public class DatabaseMetadataTest {

    public static Connection getConnection() throws Exception {

        String driver = "org.gjt.mm.mysql.Driver";
        // String url = "jdbc:mysql://localhost/tiger";
        String url = "jdbc:mysql://localhost/tbi";
        String username = "shenze";
        String password = "shenze";
        Class.forName(driver); // load MySQL driver
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }

    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        try {
            conn = getConnection();
            System.out.println("-------- getBestRowIdentifier ------");
            System.out.println("conn=" + conn);
            String bestRowIdentifier = conn.getCatalog();
            ResultSet catalogNames = conn.getMetaData().getCatalogs();
            while (catalogNames.next()) {
                String name = catalogNames.getString("TABLE_CAT");
                System.out.println(name);
            }
            System.out.println(bestRowIdentifier);
            System.out.println("------------------------------------");
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        } finally {
            conn.close();
        }
    }

}

