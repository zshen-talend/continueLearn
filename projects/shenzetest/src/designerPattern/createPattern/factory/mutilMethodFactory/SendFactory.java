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
package designerPattern.createPattern.factory.mutilMethodFactory;

import designerPattern.createPattern.factory.commonFactory.MailSender;
import designerPattern.createPattern.factory.commonFactory.Sender;
import designerPattern.createPattern.factory.commonFactory.SmsSender;

/**
 * created by talend on Nov 27, 2014 Detailled comment
 * 
 */
public class SendFactory {

    public Sender produceMail() {
        return new MailSender();
    }

    public Sender produceSms() {
        return new SmsSender();
    }
}
