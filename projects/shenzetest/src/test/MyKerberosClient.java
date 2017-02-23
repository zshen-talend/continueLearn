package test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MyKerberosClient {

    public static void main(String[] args) {
        String url_tHiveConnection_1 = "jdbc:hive2://" + "cdhyarn.kerberos.com" + ":" + "10000" + "/"
                + "default;principal=hive/cdhyarn.kerberos.com@production.security.realm";

        String dbUser_tHiveConnection_1 = "xxx";
        String dbPwd_tHiveConnection_1 = "";

        java.sql.Connection conn_tHiveConnection_1 = null;

        String driverClass_tHiveConnection_1 = "org.apache.hive.jdbc.HiveDriver";
        try {
            java.lang.Class.forName(driverClass_tHiveConnection_1);
            conn_tHiveConnection_1 = java.sql.DriverManager.getConnection(url_tHiveConnection_1, dbUser_tHiveConnection_1,
                    dbPwd_tHiveConnection_1);

            java.sql.Statement init_tHiveConnection_1 = conn_tHiveConnection_1.createStatement();
            ResultSet rs = init_tHiveConnection_1.executeQuery("select count(*) from zhaomingli");
            if (rs.next()) {
                int count = rs.getInt(1);
                System.out.println(count);
            }

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
