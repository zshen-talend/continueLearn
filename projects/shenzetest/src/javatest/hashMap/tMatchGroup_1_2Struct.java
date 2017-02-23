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
package javatest.hashMap;

/**
 * DOC zshen class global comment. Detailled comment
 */
public class tMatchGroup_1_2Struct {

    private final int DEFAULT_HASHCODE = 1;

    private final int PRIME = 31;

    private int hashCode = DEFAULT_HASHCODE;

    public boolean hashCodeDirty = true;

    public String city;

    @Override
    public int hashCode() {
        final int prime = PRIME;
        int result = DEFAULT_HASHCODE;

        result = prime * result + ((this.city == null) ? 0 : this.city.hashCode());
        this.hashCode = result;
        return this.hashCode;
    }

    public tMatchGroup_1_2Struct(String city) {
        this.city = city;
    }
}
