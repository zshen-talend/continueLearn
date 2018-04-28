// ============================================================================
//
// Copyright (C) 2006-2016 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package db.mapDB.DQTest;

/**
 * DOC zshen class global comment. Detailled comment
 */
public class DBMapSpecialColCompartor extends DBMapCompartor {

    private Integer colIndex = null;

    public DBMapSpecialColCompartor(int colIndex) {
        this.colIndex = colIndex;
    }

    /*
     * (non-Javadoc)
     * 
     * @see db.mapDB.DQTest.DBMapCompartor#listCompare(java.lang.Object[], java.lang.Object[])
     */
    @Override
    protected int listCompare(Object[] array1, Object[] array2) {
        if (colIndex == null) {
            return super.listCompare(array1, array2);
        }

        return compare(array1[colIndex], array2[colIndex]);
    }

}
