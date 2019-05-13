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
package javatest.ClassLoader.TestSameClass;

public class Sample {

    private Sample instance;

    public void setSample(Object instance) {
        this.instance = (Sample) instance;
    }

    /**
     * Getter for instance.
     * 
     * @return the instance
     */
    public Sample getSample() {
        return this.instance;
    }

}
