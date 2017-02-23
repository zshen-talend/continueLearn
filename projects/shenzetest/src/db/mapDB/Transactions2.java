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
package db.mapDB;

import java.util.Map;

import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.TxBlock;
import org.mapdb.TxMaker;
import org.mapdb.TxRollbackException;

/**
 * Demonstrates easier way to execute concurrent transactions.
 */
public class Transactions2 {

    public static void main(String[] args) {
        TxMaker txMaker = DBMaker.newMemoryDB().makeTxMaker();

        // Execute transaction within single block.
        txMaker.execute(new TxBlock() {

            public void tx(DB db) throws TxRollbackException {
                Map m = db.getHashMap("test");
                m.put("test", "test");
            }
        });

        // show result of block execution
        DB tx1 = txMaker.makeTx();
        Object val = tx1.getHashMap("test").get("test");
        System.out.println(val);

        tx1.close();
        txMaker.close();
    }

}