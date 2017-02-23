// ============================================================================
//
// Copyright (C) 2006-2013 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package propertyChangeListener;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        DemoBeans beans = new DemoBeans();
        beans.addPropertyChangeListener(new PropertyChangeListener() {

            public void propertyChange(PropertyChangeEvent evt) {
                System.out.println("OldValue:" + evt.getOldValue());
                System.out.println("NewValue:" + evt.getNewValue());
                System.out.println("tPropertyName:" + evt.getPropertyName());
            }
        });
        beans.setDemoName("test");
    }

}
