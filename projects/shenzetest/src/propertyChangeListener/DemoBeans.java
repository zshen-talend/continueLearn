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

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class DemoBeans {

    private String demoName;

    PropertyChangeSupport listeners = new PropertyChangeSupport(this);

    public DemoBeans() {
        demoName = "initValue";
    }


    public String getDemoName() {
        return demoName;
    }


    public void setDemoName(String demoName) {
        String oldValue = this.demoName;
        this.demoName = demoName;
        //发布监听事件
        firePropertyChange("demoName", oldValue, demoName);

    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        listeners.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener){
        listeners.addPropertyChangeListener(listener);
    }


    /**
     * 触发属性改变的事件
     */
    protected void firePropertyChange(String prop, Object oldValue, Object newValue) {
        listeners.firePropertyChange(prop, oldValue, newValue);
    }

}
