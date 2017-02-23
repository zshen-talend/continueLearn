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
package designerPattern.createPattern.Singleton;

import java.util.Vector;

/**
 * created by talend on Nov 27, 2014 Detailled comment
 * 
 */
public class shadowInstance {

    private static shadowInstance instance = null;

    private Vector properties = null;

    public Vector getProperties() {
        return properties;
    }

    private shadowInstance() {
    }

    private static synchronized void syncInit() {
        if (instance == null) {
            instance = new shadowInstance();
        }
    }

    public static shadowInstance getInstance() {
        if (instance == null) {
            syncInit();
        }
        return instance;
    }

    public void updateProperties() {
        shadowInstance shadow = new shadowInstance();
        properties = shadow.getProperties();
    }
}
