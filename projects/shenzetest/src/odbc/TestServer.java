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
package odbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestServer {

    static {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void main(String args[]) {
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement pstmt = null;
        String sql = "";
        ResultSet rs = null;
        long currenttime = System.currentTimeMillis();
        try {
            // conn = DriverManager.getConnection("jdbc:odbc:execlodbc", "", "");
            // stmt = conn.createStatement();
            // sql = "SELECT COUNT(`id`) 'aa' FROM `E:\\excelmysql\\table1`.`myfive`";
            conn = DriverManager.getConnection("jdbc:odbc:sqlserverDSN", "UserName", "#Silence406");
            stmt = conn.createStatement();
            sql = "SELECT \"ID\",\"number\" ,\"date\",\"NAME\" FROM \"GENERALDATA\"";

            // sql = "insert into [table2$] values('9999','shenze','2008-09-08','10')";

            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                // System.out.println(rs.getFloat("id") + " " + rs.getString("name") + " " + rs.getString("date") + " "
                // + rs.getString("number"));
                System.out.println(rs.getObject("GENERALDATA.id"));
                System.out.println(rs.getObject("number"));
                System.out.println(rs.getObject("date"));
                System.out.println(rs.getObject("name"));
            }
            // sql = "insert into [myfive] values(?,?,?)";
            // pstmt = conn.prepareStatement(sql);
            // pstmt.setObject(1, "9991");
            // pstmt.setObject(2, "shenze");
            // // pstmt.setObject(3, "2008-09-08");
            // pstmt.setObject(3, "10");
            // pstmt.executeUpdate();
            // sql = "SELECT count(*) FROM [myfive] where id in(select distinct id from [myfive])";
            // pstmt = conn.prepareStatement(sql);
            // pstmt.setMaxRows(100);
            //
            // pstmt.execute();

        } catch (Exception e) {
            System.err.println(e);
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
                rs = null;
                stmt = null;
                conn = null;

                // System.out.println(System.currentTimeMillis() - currenttime);
            } catch (Exception e) {
            }
        }
    }
}
