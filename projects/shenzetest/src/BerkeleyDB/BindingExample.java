package BerkeleyDB;

/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2004, 2010 Oracle and/or its affiliates.  All rights reserved.
 *
 */

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.sleepycat.bind.EntryBinding;
import com.sleepycat.bind.serial.SerialBinding;
import com.sleepycat.bind.serial.StoredClassCatalog;
import com.sleepycat.je.Cursor;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.je.LockMode;
import com.sleepycat.je.OperationStatus;

/**
 * BindingExample operates in the same way as SimpleExample, but uses a IntegerBinding and a SerialBinding to map
 * between Java objects and stored DatabaseEntry objects.
 */
class BindingExample {

    private static final int EXIT_SUCCESS = 0;

    private static final int EXIT_FAILURE = 1;

    private int numRecords; // num records to insert or retrieve

    private int offset; // where we want to start inserting

    private boolean doInsert; // if true, insert, else retrieve

    private File envDir;

    public BindingExample(int numRecords, boolean doInsert, File envDir, int offset) {
        this.numRecords = numRecords;
        this.doInsert = doInsert;
        this.envDir = envDir;
        this.offset = offset;
    }

    /**
     * Usage string
     */
    public static void usage() {
        System.out.println("usage: java " + "je.BindingExample " + "<envHomeDirectory> "
                + "<insert|retrieve> <numRecords> [offset]");
        System.exit(EXIT_FAILURE);
    }

    /**
     * Main
     */
    public static void main(String argv[]) {
        argv = new String[] { "d:\\tmp\\JEDB1", "retrieve", "3" };
        if (argv.length < 2) {
            usage();
            return;
        }
        File envHomeDirectory = new File(argv[0]);

        boolean doInsertArg = false;
        if (argv[1].equalsIgnoreCase("insert")) {
            doInsertArg = true;
        } else if (argv[1].equalsIgnoreCase("retrieve")) {
            doInsertArg = false;
        } else {
            usage();
        }

        int startOffset = 0;
        int numRecordsVal = 0;

        if (doInsertArg) {

            if (argv.length > 2) {
                numRecordsVal = Integer.parseInt(argv[2]);
            } else {
                usage();
                return;
            }

            if (argv.length > 3) {
                startOffset = Integer.parseInt(argv[3]);
            }
        }

        try {
            BindingExample app = new BindingExample(numRecordsVal, doInsertArg, envHomeDirectory, startOffset);
            app.run();
        } catch (DatabaseException e) {
            e.printStackTrace();
            System.exit(EXIT_FAILURE);
        }
        System.exit(EXIT_SUCCESS);
    }

    /**
     * Insert or retrieve data
     */
    public void run() throws DatabaseException {
        /* Create a new, transactional database environment */
        EnvironmentConfig envConfig = new EnvironmentConfig();
        envConfig.setTransactional(true);
        envConfig.setAllowCreate(true);
        Environment exampleEnv = new Environment(envDir, envConfig);

        /* Make a database within that environment */
        // Transaction txn = exampleEnv.beginTransaction(null, null);
        DatabaseConfig dbConfig = new DatabaseConfig();
        dbConfig.setTransactional(true);
        dbConfig.setAllowCreate(true);
        dbConfig.setSortedDuplicates(true);
        Database exampleDb = exampleEnv.openDatabase(null, "bindingsDb", dbConfig);

        /*
         * In our example, the database record is composed of an integer key and and instance of the MyData class as
         * data.
         * 
         * A class catalog database is needed for storing class descriptions for the serial binding used below. This
         * avoids storing class descriptions redundantly in each record.
         */
        DatabaseConfig catalogConfig = new DatabaseConfig();
        catalogConfig.setTransactional(true);
        catalogConfig.setAllowCreate(true);
        Database catalogDb = exampleEnv.openDatabase(null, "catalogDb", catalogConfig);
        StoredClassCatalog catalog = new StoredClassCatalog(catalogDb);

        /*
         * Create a serial binding for MyData data objects. Serial bindings can be used to store any Serializable
         * object.
         */
        EntryBinding<MyData> dataBinding = new SerialBinding<MyData>(catalog, MyData.class);

        // txn.commit();

        /*
         * Further below we'll use a tuple binding (IntegerBinding specifically) for integer keys. Tuples, unlike
         * serialized Java objects, have a well defined sort order.
         */

        /* DatabaseEntry represents the key and data of each record */
        DatabaseEntry keyEntry = new DatabaseEntry();
        DatabaseEntry dataEntry = new DatabaseEntry();

        if (doInsert) {

            /* put some data in */
            for (int i = offset; i < numRecords + offset; i++) {

                StringBuilder stars = new StringBuilder();
                for (int j = 0; j < i; j++) {
                    stars.append('*');
                }
                MyData data = new MyData(i);

                // IntegerBinding.intToEntry(i, keyEntry);
                dataBinding.objectToEntry(data, keyEntry);
                dataBinding.objectToEntry(data, dataEntry);

                // txn = exampleEnv.beginTransaction(null, null);
                OperationStatus status = exampleDb.put(null, keyEntry, dataEntry);

                /*
                 * Note that put will throw a DatabaseException when error conditions are found such as deadlock.
                 * However, the status return conveys a variety of information. For example, the put might succeed, or
                 * it might not succeed if the record exists and duplicates were not
                 */
                if (status != OperationStatus.SUCCESS) {
                    throw new RuntimeException("Data insertion got status " + status);
                }
                // txn.commit();
            }
        } else {

            /* retrieve the data */
            Cursor cursor = exampleDb.openCursor(null, null);
            MyData key = new MyData(2);
            while (cursor.getNext(keyEntry, dataEntry, LockMode.DEFAULT) == OperationStatus.SUCCESS) {

                // int key = IntegerBinding.entryToInt(keyEntry);
                key = dataBinding.entryToObject(keyEntry);
                MyData data = dataBinding.entryToObject(dataEntry);

                // System.out.println("key=" + key + " data=" + data);
            }
            cursor.close();
            dataBinding.objectToEntry(key, keyEntry);
            exampleDb.getSearchBoth(null, keyEntry, keyEntry, LockMode.DEFAULT);
            key = dataBinding.entryToObject(keyEntry);
            MyData data = dataBinding.entryToObject(dataEntry);
            System.out.println("key=" + key + " data=" + data);
        }

        catalogDb.close();
        exampleDb.close();
        exampleEnv.removeDatabase(null, "bindingsDb");
        exampleEnv.close();
    }

    // @SuppressWarnings("serial")
    // private static class MyData implements Serializable {
    //
    // private int num;
    //
    // private String msg;
    //
    // MyData(int number, String message) {
    // this.num = number;
    // this.msg = message;
    // }
    //
    // @Override
    // public String toString() {
    // return String.valueOf(num) + ' ' + msg;
    // }
    // }
    @SuppressWarnings("serial")
    private static class MyData implements Serializable {

        private List<Object> rowList = new ArrayList<Object>();

        private String msg;

        MyData(int input, String message) {
            rowList.add(input);
            this.msg = message;
        }

        MyData(int input) {
            rowList.add(input);
        }

        @Override
        public String toString() {
            String result = "";
            return String.valueOf(rowList.get(0));
        }
    }

}