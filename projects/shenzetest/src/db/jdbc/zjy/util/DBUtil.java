package db.jdbc.zjy.util;

import java.sql.*;
import java.util.List;

import oracle.jdbc.driver.OracleDriver;

public class DBUtil {
	private static Connection conn = null;
  private static final String driver = "com.mysql.jdbc.Driver";
	private static final String dbURL = "jdbc:mysql://localhost:3306/Stuinfo";
	private static final String user = "shenze";
	private static final String password = "shenze";
//	private static final String driver = "oracle.jdbc.driver.OracleDriver";
//	private static final String dbURL = "jdbc:oracle:thin:@localhost:1521:ORCL";
//	private static final String user = "admin";
//	private static final String password = "admin";
	public static Connection getConnection() {
		try {			
			if (conn == null || conn.isClosed()) {
				Class.forName(driver);
				conn = DriverManager.getConnection(dbURL, user, password);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return conn;
	}
	public static ResultSet executeQuery(String sql) {
		Connection c = getConnection();
		ResultSet set = null;
		try {
			Statement st = c.createStatement();
			set = st.executeQuery(sql);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return set;
	}
	public static int executeUpdate(String sql) {
		Connection c = getConnection();
		int i = 0;
		try {
			Statement st = c.createStatement();
			i = st.executeUpdate(sql);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return i;
	}
	public static void main(String[] args) {
		
		System.out.println(getConnection());
//		ControlDB db = new ControlDB();
//		String sql = "select * from stuinfo";
//		List list = db.executeQueryStuinfo(sql);
//		System.out.println(list.size());
		
	}
}