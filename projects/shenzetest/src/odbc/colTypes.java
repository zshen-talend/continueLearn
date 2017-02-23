// ============================================================================
//
// Copyright (C) 2006-2014 Talend Inc. - www.talend.com
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

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * created by talend on May 19, 2014 Detailled comment
 * 
 */
public class colTypes {

    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            java.sql.Connection connection1 = DriverManager.getConnection("jdbc:oracle:thin:@192.168.30.151:1521:orcl", "shenze",
                    "shenze");
            System.out.println(connection1);
            System.out.println(connection1.getMetaData().getDriverName() + " " + connection1.getMetaData().getDriverVersion());
            ResultSet rs = connection1.createStatement().executeQuery("select \"date\",datetiamp from generaldata");
            rs.next();
            printInfo(rs, 1);
            printInfo(rs, 2);
        } catch (Exception exception1) {
            exception1.printStackTrace();
        }
    }

    public static void printInfo(ResultSet rs, int i) throws SQLException {
        ResultSetMetaData meta = rs.getMetaData();
        System.out.printf("Colname=%s,Type=%s,TypeName=%s,val=[%s];\n", meta.getColumnName(i), meta.getColumnType(i),
                meta.getColumnTypeName(i), rs.getObject(i).toString());
    }

}
