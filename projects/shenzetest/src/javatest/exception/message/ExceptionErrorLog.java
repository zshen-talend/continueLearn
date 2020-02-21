// ============================================================================
//
// Copyright (C) 2006-2020 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package javatest.exception.message;

import org.apache.log4j.Logger;

public class ExceptionErrorLog {

    private static Logger log = Logger.getLogger(ExceptionErrorLog.class);

    public static void main(String[] args) {
        try {
        ExceptionSub1 exceptionSub1 = new ExceptionSub1();
        exceptionSub1.sub1Method();
        } catch (Exception e) {
            log.warn(e, e);
        }
    }

}
