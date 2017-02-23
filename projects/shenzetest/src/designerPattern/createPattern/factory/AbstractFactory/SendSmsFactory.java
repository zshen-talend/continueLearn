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
package designerPattern.createPattern.factory.AbstractFactory;

/**
 * created by talend on Nov 27, 2014 Detailled comment
 * 
 */
public class SendSmsFactory implements Provider {

    /*
     * (non-Javadoc)
     * 
     * @see designerPattern.createPattern.AbstractFactory.Provider#produce()
     */
    public Sender produce() {
        return new SmsSender();
    }

}
