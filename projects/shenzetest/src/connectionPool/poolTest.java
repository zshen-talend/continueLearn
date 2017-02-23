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
package connectionPool;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * DOC OWNER class global comment. Detailled comment
 */
public class poolTest {

    /**
     * DOC OWNER Comment method "main".
     * 
     * @param args
     */
    public static void main(String[] args) {
        int num = 100;
        for (int i = 0; i < num; i++) {
            Connection conn = DbConnectionPool.getInstance().getConnection();
            try {

                if (conn != null && !conn.isClosed()) {
                    System.out.println("connection num: " + i + " connection id :" + conn.hashCode());
                    DbConnectionPool.getInstance().release(conn);
                } else {
                    System.out.println("null: " + i);
                }

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}
