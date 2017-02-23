package odbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class OracleODBCTest {

    public static void main(String[] args) throws Exception {
        // String url = "jdbc:odbc:oracleSystem";
        // String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
        // String user = "SYSTEM";
        // String password = "shenze";
        // String url = "jdbc:odbc:mssql2000";
        // String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
        // String user = "fzhong";// "UserName";
        // String password = "fzhong"; // "#Silence406";
        // String url = "jdbc:odbc:mysqlODBC5.1";
        // String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
        // String user = "shenze";// "UserName";
        // String password = "shenze"; // "#Silence406";
        String url = "jdbc:odbc:sqlite777";
        String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
        String user = "shenze";// "UserName";
        String password = "shenze"; // "#Silence406";

        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, user, password);
            // Get the MetaData
            DatabaseMetaData metaData = conn.getMetaData();
            executeGetSchemas(metaData);
            // isOdbcExcel(conn);
            // // Get driver information
            // System.out.println("Driver Informaion");
            // System.out.println(metaData.getDriverName());
            // System.out.println(metaData.getDriverVersion());
            // // Get schema information
            // // System.out.println("catalogs");
            // // ResultSet catlogs = metaData.getCatalogs();
            // // while (catlogs.next()) {
            // // System.out.println(catlogs.getString(1));
            // // }
            // System.out.println("Schemas");
            // ResultSet schemas = metaData.getSchemas();
            // while (schemas.next()) {
            // System.out.println(schemas.getString(1));
            // }
            // // Get table information
            // System.out.println("Tables");
            //
            // ResultSet tables = metaData.getTables("testtable", null, null, null);
            // while (tables.next()) {
            // System.out.println(tables.getString(2) + ":" + tables.getString(4));
            // }
            // conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static boolean isOdbcExcel(Connection connection) throws SQLException {
        DatabaseMetaData connectionMetadata = connection.getMetaData();
        if (connectionMetadata.getDriverName() != null
                && connectionMetadata.getDriverName().toLowerCase().startsWith(DatabaseConstant.ODBC_DRIVER_NAME)
                && connectionMetadata.getDatabaseProductName() != null
                && connectionMetadata.getDatabaseProductName().equals(DatabaseConstant.ODBC_MSSQL_PRODUCT_NAME)) {
            return true;
        }
        return false;
    }

    public static void executeGetSchemas(DatabaseMetaData dbmd) {
        try {
            System.out.println("DatabaseProductName :" + dbmd.getDatabaseProductName());
            ResultSet rs = dbmd.getTables("testtable", null, null, null);
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println("product version :" + dbmd.getDatabaseProductVersion());
            System.out.println("driver version :" + dbmd.getDriverName());
            // Display the result set data.
            int cols = rsmd.getColumnCount();
            System.out.println("columnCount :" + cols);
            for (int i = 1; i <= cols; i++) {
                System.out.print(rsmd.getColumnName(i));
                for (int j = 0; j < 40 - rsmd.getColumnName(i).length(); j++) {
                    System.out.print(" ");
                }
            }
            System.out.println();
            while (rs.next()) {

                for (int i = 1; i <= cols; i++) {
                    String value = rs.getString(i);
                    if (value == null) {
                        value = "null";
                    }
                    System.out.print(value);
                    for (int j = 0; j < 40 - value.length(); j++) {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
            rs.close();
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
