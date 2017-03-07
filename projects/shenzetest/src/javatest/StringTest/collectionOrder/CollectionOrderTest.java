package javatest.StringTest.collectionOrder;

import java.util.HashMap;
import java.util.Map;

public class CollectionOrderTest {

    static Map<Record, String> tableData = new HashMap<>();

    static Map<Integer, String> tableData1 = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("first Time result:=====>");
        initRecordMap(generateInputData());
        print();
        tableData.clear();
        tableData1.clear();
        System.out.println("second Time result:=====>");
        initRecordMap(generateInputData());
        print();
    }

    private static void print() {
        int index = 1;
        System.out.println("tableData:");
        for (String value : tableData.values()) {
            System.out.println("index " + index++ + " : " + value);
        }
        index = 1;
        System.out.println("tableData1:");
        for (String value : tableData1.values()) {
            System.out.println("index " + index++ + " : " + value);
        }
    }

    private static void initRecordMap(Object[][] generateInputData) {
        int colIndex = 0;
        for (Object[] row : generateInputData) {
            Record re = new Record();
            int rowIndex = 0;
            for (Object col : row) {
                re.putKey(rowIndex++, col.toString());

            }
            tableData.put(re, row[0].toString());
            tableData1.put(colIndex++, row[0].toString());
        }
    }

    private static Object[][] generateInputData() {

        return new Object[][] { { "Ashley", "cook" }, { "Brianna", "bell" }, { "Chloe", "cook" }, { "David", "bell" }, //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$
                { "Eric", "cook" }, { "Faith", "adam" } }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
    }

}
