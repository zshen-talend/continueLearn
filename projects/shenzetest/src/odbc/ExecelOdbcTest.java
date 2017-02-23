package odbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExecelOdbcTest {

    public static void main(String[] args) throws Exception {
        String url = "jdbc:odbc:execlodbc";
        String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
        String user = "root";
        String password = "shenze";

        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, user, password);
            // Get the MetaData
            DatabaseMetaData metaData = conn.getMetaData();
            isOdbcExcel(conn);
            // Get driver information
            System.out.println("Driver Informaion");
            System.out.println(metaData.getDriverName());
            System.out.println(metaData.getDriverVersion());
            // Get schema information
            System.out.println("catalogs");
            ResultSet catlogs = metaData.getCatalogs();
            while (catlogs.next()) {
                System.out.println(catlogs.getString(1));
            }
            // ResultSet schemas = metaData.getSchemas();
            // while (schemas.next()) {
            // System.out.println(schemas.getString(1));
            // }
            // Get table information
            System.out.println("Tables");

            ResultSet tables = metaData.getTables(null, null, null, new String[] { "TABLE", "SYSTEM TABLE", });
            while (tables.next()) {
                System.out.println(tables.getCursorName() + ":" + tables.getString(4));
            }
            conn.close();
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
}
