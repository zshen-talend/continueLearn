// ============================================================================
//
// Copyright (C) 2006-2011 Talend Inc. - www.talend.com
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
import java.sql.SQLException;
import java.sql.Statement;


/**
 * DOC zshen  class global comment. Detailled comment
 */
public class InsertData {

    private static String tableName = "talendDB.students";
    /**
     * DOC zshen Comment method "main".
     * @param args
     */
    public static void main(String[] args) {
        Connection terdataConnection = null;
        try {
            terdataConnection = JdbcGetSchema.getTerdataConnection();
            Statement createStatement = terdataConnection.createStatement();
            // create table
            for (int i = 1001; i < 10000; i++) {

                if (!insertData(createStatement, i)) {
                    return;
                }

            }
            createStatement.close();
            terdataConnection.close();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static boolean createTable(Statement createStatement, int index) throws SQLException {

 String sql = "create table " + tableName + index + " (" + "nc_pk              int                        not null,"
                + "stu_id             CHAR(36)                        not null,"
                + "stu_code           VARCHAR(32)                    not null," + "stu_name           VARCHAR(32),"
                + "stu_age            SMALLINT," + "stu_birthday       CHAR(10)," + "stu_sex            SMALLINT,"
                + "ts                 CHAR(19)," + "dr                 SMALLINT," + "reg_mon            DECIMAL(20,8),"
                + "temp_var1          VARCHAR(20)," + "temp_var2          VARCHAR(20)," + "temp_var3          VARCHAR(20),"
                + "temp_int1          INTEGER," + " temp_int2          INTEGER," + " constraint PK_STUDENT" + index
                + " primary key (stu_id));";

        boolean execute = createStatement.execute(sql, Statement.RETURN_GENERATED_KEYS);// .execute(sql,
        System.out.println("line:" + index + ": to execute create table " + sql + " is:" + execute);
        return execute;
    }

    public static boolean alertPrimarkey(Statement createStatement, int index) throws SQLException {

        String sql = "alter   table  " + tableName + index + "   add   constraint    test_PK" + index
                + "   Primary   Key(stu_id)";
        boolean executeResult = createStatement.execute(sql, Statement.RETURN_GENERATED_KEYS);// .execute(sql,
        System.out.println("line:" + index + ": execute is" + executeResult);
        return executeResult;
    }

    public static boolean insertData(Statement createStatement, int index) throws SQLException {
        // INSERT INTO Promotion
        // (EmpName, EmpNo, DeptNo, Sex, DOB)
        // VALUES ('John Smith', 10001, 876, 'M', 560231);
        String sql = "INSERT INTO " + tableName + 999 + "(";
        for (int i = 0; i < 20; i++) {
            sql += (i == 0 ? "" : ",") + "nc_pk" + i + ", stu_id" + i + ", stu_code" + i + ", stu_name" + i + ", stu_age" + i
                    + ","
                    + "stu_birthday"
                    + i + ", stu_sex" + i + ", ts" + i + ", dr" + i + ", reg_mon" + i + ", temp_var1" + i + "," + "temp_var2" + i
                    + ", temp_var3" + i + ", temp_int1" + i + ",  temp_int2" + i + ", temp_date" + i;
        }

        sql += ") values(";
        for (int i = 0; i < 20; i++) {
            int sum = index + i + 1;
            int age = i * 10;
            sql += (i == 0 ? "" : ",") + sum + ", 'student" + sum + "','stu_code" + i + "','stu_name" + i + "'," + age + ",'"
                    + "stu_birthday" + i + "'," + i % 2 + ", 'ts" + i + "'," + i + ", " + Float.intBitsToFloat(i) + ",'temp_var1"
                    + i + "','" + "temp_var2" + i + "', 'temp_var3" + i + "'," + i + "," + i + "," + "'2012-10-11'";
        }
        sql += ");";
        boolean executeResult = !createStatement.execute(sql, Statement.RETURN_GENERATED_KEYS);// .execute(sql,
        System.out.println("line:" + index + ": execute is" + executeResult);
        return executeResult;

    }

    public static boolean checkView(Statement createStatement, int index) throws SQLException {
        String sql = "select * from " + tableName + "_view" + index + ";";
        boolean executeResult;
        try {
            // success will return true
            executeResult = createStatement.execute(sql, Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException e) {
            sql = "drop view " + tableName + "_view" + index + ";";
            // success will return false
            executeResult = !createStatement.execute(sql, Statement.RETURN_GENERATED_KEYS);
            System.out.println("drop: " + tableName + "_view" + index + " : execute is" + executeResult);
        }// .execute(sql,
        System.out.println("line:" + index + ": execute is " + executeResult);
        return executeResult;

    }

    // public static boolean createTable(Statement createStatement, int index) throws SQLException {
    //
    // String sql = "create table " + tableName + index + " (";
    // for (int i = 0; i < 20; i++) {
    // sql += "nc_pk" + i + " int not null, stu_id" + i + " CHAR(36) not null, stu_code" + i
    // + " VARCHAR(32) not null, stu_name" + i + " VARCHAR(32), stu_age" + i + " SMALLINT," + "stu_birthday" + i
    // + " CHAR(10), stu_sex" + i + " SMALLINT, ts" + i + " CHAR(19), dr" + i + " SMALLINT, reg_mon" + i
    // + " DECIMAL(20,8), temp_var1" + i + " VARCHAR(20)," + "temp_var2" + i + " VARCHAR(20), temp_var3" + i
    // + " VARCHAR(20), temp_int1" + i + " INTEGER,  temp_int2" + i + " INTEGER, temp_date" + i + " DATE, ";
    // }
    // sql += (i == 0 ? "" : ",") + sum + ", 'student" + sum + "','stu_code" + i + "','stu_name" + i + "'," + age + ",'"
    // + "stu_birthday" + i
    // + "'," + i % 2 + ", 'ts" + i + "'," + i + ", " + Float.intBitsToFloat(i) + "," + i
    // + ",'" + "temp_var2" + i + "', 'temp_var3" + i + "'," + i + "," + i + "," + "'2012-10-1'";
    // sql += " constraint PK_STUDENT" + index + " primary key (stu_id0));";
    // boolean execute = createStatement.execute(sql, Statement.RETURN_GENERATED_KEYS);// .execute(sql,
    // System.out.println("line:" + index + ": to execute create table is:" + execute);
    // return execute;
    // }

}
