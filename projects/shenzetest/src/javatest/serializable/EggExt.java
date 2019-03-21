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

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

/**
 * DOC talend class global comment. Detailled comment
 */
public class EggExt implements IEgg, Externalizable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    int number = 0;

    private List<NewEgg> brother = new ArrayList<>();

    public EggExt() {
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
    public List<NewEgg> getBrother() {
        return this.brother;
    }

    /**
     * Sets the brother.
     * 
     * @param brother the brother to set
     */
    public void setBrother(List<NewEgg> brother) {
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

    /*
     * (non-Javadoc)
     * 
     * @see java.io.Externalizable#writeExternal(java.io.ObjectOutput)
     */
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(number);
        System.out.println("Egg 序列化完成");

    }

    /*
     * (non-Javadoc)
     * 
     * @see java.io.Externalizable#readExternal(java.io.ObjectInput)
     */
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        number = in.readInt();
        System.out.println("Egg 反序列化完成");
    }

}
