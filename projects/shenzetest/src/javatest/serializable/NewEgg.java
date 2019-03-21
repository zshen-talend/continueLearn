// ============================================================================
//
// Copyright (C) 2006-2018 Talend Inc. - www.talend.com
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

public class NewEgg implements IEgg, java.io.Serializable {

    String id = "";

    public NewEgg(String id) {
        this.id = id;
    }

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * Getter for id.
     * 
     * @return the id
     */
    protected String getId() {
        return this.id;
    }

}
