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
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.hsqldb.jdbc.jdbcDataSource;

public class JdbcGetSchema {

    public static void main(String[] args) throws Exception {
        Connection conn = getSQLServerConnection();
        System.out.println("Got Connection.");
        // Statement st = conn.createStatement();
        //
        // ResultSet result = st.executeQuery("SELECT REPLACE(CAST(new.table AS CHAR),2,3) FROM test.new");
        // // ResultSet result =
        // st.executeQuery("SELECT REPLACE(number,9,8) FROM testtable.generaldata WHERE number=519");
        // while (result.next()) {
        // // System.out.println("key=" + result.getObject(1));
        // }
        // executeGetValues(conn.getMetaData());
        // executeGetSchemas(conn.getMetaData(), "QSYS2"); //$NON-NLS-1$
        executeGetTableTypes(conn.getMetaData());
        // conn.getMetaData().getIndexInfo(null, "SHENZE", "TEST0001", false, true);
        // executeGetTables(conn.getMetaData());
        // executeGetColumns(conn.getMetaData());
        // // st.executeUpdate("drop table survey;");
        // //
        // // st.executeUpdate("create table survey (id int,name varchar(30));");
        // // st.executeUpdate("insert into survey (id,name ) values (1,'nameValue')");
        //
        // DatabaseMetaData meta = conn.getMetaData();
        // // ResultSet catalogs = meta.getCatalogs();
        // // while (catalogs.next()) {
        // // String tableCatalog = catalogs.getString("TABLE_CAT"); // "TABLE_CATALOG"
        // // System.out.println("Catalog:" + tableCatalog);
        // // }
        // ResultSet schemas = meta.getSchemas();
        // while (schemas.next()) {
        // String tableSchema = schemas.getString("TABLE_SCHEM"); // "TABLE_SCHEM"
        // // String tableCatalog = schemas.getString("TABLE_CATALOG"); // "TABLE_CATALOG"
        //
        // System.out.println("Schema:" + tableSchema);
        // // System.out.println("Catalog:" + tableCatalog);
        // }
        //
        // ResultSet tables = meta.getTables(null, null, null, null);
        // while (tables.next()) {
        // String tableSchema = tables.getString(1); // "TABLE_SCHEM"
        // // String tableCatalog = schemas.getString(2); // "TABLE_CATALOG"
        // System.out.println(tables.getString("TABLE_CAT") + ":" + tables.getString(2) + ":" +
        // tables.getString("TABLE_NAME"));
        // // System.out.println(tables.toString() + ":" + tables.getString(3));
        // }
        // // if (meta.getDatabaseProductName() != null) {
        // // st.execute("SHUTDOWN");
        // // }
        // ResultSet columns = meta.getColumns(null, null, null, null);
        // System.out.println("column:");
        // while (columns.next()) {
        // String tableSchema = columns.getString(1); // "TABLE_SCHEM"
        // // String tableCatalog = schemas.getString(2); // "TABLE_CATALOG"
        // System.out.println(columns.getString("TABLE_CAT") + ":" + columns.getString(2) + ":"
        // + columns.getString("TABLE_NAME") + ":" + columns.getString("COLUMN_NAME"));
        // // System.out.println(tables.toString() + ":" + tables.getString(3));
        // }
        // st.close();
        conn.close();
    }

    /**
     * 
     * DOC zshen Comment method "getHSQLConnection".
     * 
     * @return
     * @throws Exception connection HSQL by JDBC ENGIN standalone
     */
    private static Connection getHSQLConnection() throws Exception {
        jdbcDataSource dataSource = new jdbcDataSource();
        dataSource.setDatabase("jdbc:hsqldb:file:D:/TDDOWNLOAD/hsqldb/lib/test/test");
        return dataSource.getConnection("sa", "");
    }

    public static Connection getMySqlConnection() throws Exception {
        String driver = "org.gjt.mm.mysql.Driver";
        String url = "jdbc:mysql://192.168.32.211:3306/";
        String username = "shenze";
        String password = "shenze";

        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }

    public static Connection getAS400Connection() throws Exception {
        String driver = "com.ibm.as400.access.AS400JDBCDriver";
        String url = "jdbc:as400://82.127.49.45/cdc;libraries=cdc;prompt=false";

        String username = "talend";
        String password = "talend";
        // String driver = "com.ibm.as400.access.AS400JDBCDriver";
        // String url = "jdbc:as400://PUB1.RZKH.DE/;libraries=;prompt=false";
        //
        // String username = "yiliu";
        // String password = "abc123";

        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }

    public static Connection getVertica7Connection() throws Exception {
        String driver = "com.vertica.jdbc.Driver";
        String url = "jdbc:vertica://192.168.31.98:5433/";

        String username = "dbadmin";
        String password = "talend";

        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }

    public static Connection getOracleConnection() throws Exception {
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@(description=(address=(protocol=tcp)(host=192.168.0.74)(port=1521))(connect_data=(service_name=orcl)))";
        String username = "shenze";
        String password = "shenze";

        Class.forName(driver); // load Oracle driver
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }

    public static Connection getSQLServerConnection() throws Exception {
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

        String url = "jdbc:sqlserver://192.168.33.103:1433;noDatetimeStringSync=true";
        // String url = "jdbc:sqlserver://192.168.0.87:1433;databaseName=talend;";
        // String url = "jdbc:sqlserver://192.168.0.29:1433;";
        String username = "sa";// "fzhong";//"sa";// "UserName";
        String password = "sa"; // "fzhong";//"1234";// "#Silence406";

        Class.forName(driver); // load Oracle driver
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }
    // public static Connection getSQLServerConnection() throws Exception {
    // String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    //
    // String url = "jdbc:sqlserver://192.168.30.151:1433;";
    // // String url = "jdbc:sqlserver://192.168.0.87:1433;databaseName=talend;";
    // // String url = "jdbc:sqlserver://192.168.0.29:1433;";
    // String username = "UserName";// "fzhong";//"sa";// "UserName";
    // String password = "#Silence406"; // "fzhong";//"1234";// "#Silence406";
    //
    // Class.forName(driver); // load Oracle driver
    // Connection conn = DriverManager.getConnection(url, username, password);
    // return conn;
    // }

    public static Connection getSybaseConnection() throws Exception {
        String driver = "com.sybase.jdbc3.jdbc.SybDriver";
        String url = "jdbc:sybase:Tds:192.168.30.151:5000/shenze";
        String username = "shenze";
        String password = "shenze";

        Class.forName(driver); // load Oracle driver
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }

    public static Connection getTerdataConnection() throws Exception {
        String driver = "com.teradata.jdbc.TeraDriver";
        String url = "jdbc:teradata://192.168.0.130/talendDB";
        String username = "talend";
        String password = "talend";

        Class.forName(driver); // load Oracle driver
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }

    public static Connection getTerdataShenzeConnection() throws Exception {
        String driver = "com.teradata.jdbc.TeraDriver";
        String url = "jdbc:teradata://192.168.0.130/SHENZE";
        String username = "shenze";
        String password = "shenze";

        Class.forName(driver); // load Oracle driver
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }

    public static Connection getSybaseConnection15_5() throws Exception {
        String driver = "com.sybase.jdbc3.jdbc.SybDriver";
        String url = "jdbc:sybase:Tds:192.168.0.187:5000/data1db";
        String username = "ohtake";
        String password = "ohtake";

        Class.forName(driver); // load Oracle driver
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }

    public static Connection getOlapConnection() throws Exception {
        String driver = "org.jdbc4olap.jdbc.OlapDriver";
        String url = "jdbc:jdbc4olap:http://207.188.73.74:8000/sap/bw/xml/soap/xmla?sap-client=001";
        String username = "USER23";
        String password = "mk74n90r";

        Class.forName(driver); // load Oracle driver
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }

    public static Connection getDB2Connection() throws Exception {
        String driver = "com.ibm.db2.jcc.DB2Driver";
        String url = "jdbc:db2://192.168.0.130:50000/db2db2";
        String username = "db2admin";
        String password = "db2admin";

        Class.forName(driver); // load Oracle driver
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }

    public static void executeGetSchemas(DatabaseMetaData dbmd, String filterShcema) {
        try {
            System.out.println("DatabaseProductName :" + dbmd.getDatabaseProductName());
            // ResultSet rs = dbmd.getTables(null, null, "%", null);
            ResultSet rs = dbmd.getSchemas(null, filterShcema);
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println("product version :" + dbmd.getDatabaseProductVersion());
            System.out.println("driver version :" + dbmd.getDriverName());
            System.out.println("catalog :" + dbmd.getCatalogTerm());
            System.out.println("schema :" + dbmd.getSchemaTerm());
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
                // System.out.println("TABLE_CAT================>" + rs.getString(2));
                for (int i = 1; i <= cols; i++) {
                    if (!rs.getString("TABLE_SCHEM").equalsIgnoreCase(filterShcema)) { //$NON-NLS-1$
                        continue;
                    }
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

    public static void executeGetTables(DatabaseMetaData dbmd) {
        try {
            System.out.println("DatabaseProductName :" + dbmd.getDatabaseProductName());
            ResultSet rs = dbmd.getTables("test", "db2admin", "commonused", null);
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

    public static void executeGetTableTypes(DatabaseMetaData dbmd) {
        try {
            System.out.println("DatabaseProductName :" + dbmd.getDatabaseProductName());
            ResultSet rs = dbmd.getTableTypes();
            System.out.println("product version :" + dbmd.getDatabaseProductVersion());
            System.out.println("driver version :" + dbmd.getDriverName());
            // Display the result set data.
            printResult(rs);
            rs.close();
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printResult(ResultSet rs) throws SQLException {
        ResultSetMetaData rsmd = rs.getMetaData();
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
            System.out.println("this is the " + rs.getRow() + " item in here");
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
    }

    public static void executeGetColumns(DatabaseMetaData dbmd) {
        try {
            System.out.println("DatabaseProductName :" + dbmd.getDatabaseProductName());
            ResultSet rs = dbmd.getColumns("tbi", "dbo", "quoteTest1", null);
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

    public static void executeGetValues(DatabaseMetaData dbmd) {
        try {
            System.out.println("DatabaseProductName :" + dbmd.getDatabaseProductName());
            ResultSet rs = dbmd.getColumns(null, "PUBLIC", "test1", null);
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

    public static void executeGetCatalogs(DatabaseMetaData dbmd) {
        try {
            System.out.println("DatabaseProductName :" + dbmd.getDatabaseProductName());
            ResultSet rs = dbmd.getCatalogs();
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
