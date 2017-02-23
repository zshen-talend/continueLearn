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
package db.hibernate.student;

// Generated Apr 23, 2008 1:33:52 PM by Hibernate Tools 3.2.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * TdqValues generated by hbm2java.
 */
public class TdqValues implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private Integer valPk;

    private String valString;

   

    public TdqValues() {
    }

    public TdqValues(String valString) {
        this.valString = valString;
    }

    public Integer getValPk() {
        return this.valPk;
    }

    public void setValPk(Integer valPk) {
        this.valPk = valPk;
    }

    public String getValString() {
        return this.valString;
    }

    public void setValString(String valString) {
        this.valString = valString;
    }

    

}
