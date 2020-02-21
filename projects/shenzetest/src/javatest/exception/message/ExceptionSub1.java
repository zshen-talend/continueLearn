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

public class ExceptionSub1 {

    private static Logger log = Logger.getLogger(ExceptionSub1.class);

    public void sub1Method() throws Exception {
        try {
        System.out.println("sub1Method");
        ExceptionSub2 exceptionSub2 = new ExceptionSub2();
        exceptionSub2.sub2Method();
        } catch (Exception e) {
            log.error(e, e);
        }

    }

}
