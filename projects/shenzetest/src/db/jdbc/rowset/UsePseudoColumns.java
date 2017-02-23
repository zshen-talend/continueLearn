package db.jdbc.rowset;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class UsePseudoColumns {

    public void usePseudoColumns1() throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.33.211:3306/tbi", "shenze", "shenze")) {
            DatabaseMetaData dbMetaData = connection.getMetaData();
            ResultSet rs = dbMetaData.getPseudoColumns("tbi", null, "*", "*");
            ResultSetMetaData rsMetaData = rs.getMetaData();
            int columnNum = rsMetaData.getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= columnNum; i++) {
                    System.out.println(rs.getObject(i));
                }
            }
        }
    }

    public void usePseudoColumns2() throws SQLException, ClassNotFoundException {
        String driver = "oracle.jdbc.driver.OracleDriver";
        Class.forName(driver); // load Oracle driver
        try (Connection connection = DriverManager
                .getConnection(
                        "jdbc:oracle:thin:@(description=(address=(protocol=tcp)(host=192.168.33.211)(port=1521))(connect_data=(service_name=orcl)))",
                        "shenze", "shenze")) {
            DatabaseMetaData dbMetaData = connection.getMetaData();
            ResultSet rs = dbMetaData.getPseudoColumns(null, "shenze", "*", "*");
            ResultSetMetaData rsMetaData = rs.getMetaData();
            int columnNum = rsMetaData.getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= columnNum; i++) {
                    System.out.println(rs.getObject(i));
                }
            }
        }
    }

    public static void main(String[] args) {
        UsePseudoColumns upc = new UsePseudoColumns();
        try {
            upc.usePseudoColumns1();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
