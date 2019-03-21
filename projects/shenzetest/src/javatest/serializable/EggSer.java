// ============================================================================
//
// Copyright (C) 2006-2015 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package javatest.serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * DOC talend class global comment. Detailled comment
 */
public class EggSer<T extends NewEgg> implements IEgg, java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    int number = 0;

    private transient List<T> brother = new ArrayList<>();

    public EggSer() {
        System.out.println("egg 构造函数"); //$NON-NLS-1$
    }

    /**
     * Getter for number.
     * 
     * @return the number
     */
    public int getNumber() {
        return this.number;
    }

    /**
     * Sets the number.
     * 
     * @param number the number to set
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Getter for brother.
     * 
     * @return the brother
     */
    public List<T> getBrother() {
        return this.brother;
    }

    /**
     * Sets the brother.
     * 
     * @param brother the brother to set
     */
    public void setBrother(List<T> brother) {
        this.brother = brother;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "egg number is " + number; //$NON-NLS-1$
    }

}
