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

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * created by talend on Dec 2, 2014 Detailled comment
 * 
 */
public class JDK1_7With1millionData {

    public static void main(String args[]) throws Exception {
        long time = System.currentTimeMillis();
        Connection mySqlConnection = JdbcGetSchema.getMySqlConnection();
        Statement createStatement = mySqlConnection.createStatement();
        boolean execute = createStatement.execute("SELECT * FROM tbi.generatetable30col");
        if (execute) {
            ResultSet resultSet = createStatement.getResultSet();
            System.out.println("query; total time: " + (System.currentTimeMillis() - time) / 1000 + "s; there are "
                    + resultSet.getFetchSize() + " items in resultSet");
            time = System.currentTimeMillis();
            JdbcGetSchema.printResult(resultSet);
            System.out.println("Finished; total time: " + (System.currentTimeMillis() - time) / 1000 + "s; there are "
                    + resultSet.getRow() + " items");
        } else {
            System.out.println("the sql query is fail");
        }

    }
}
