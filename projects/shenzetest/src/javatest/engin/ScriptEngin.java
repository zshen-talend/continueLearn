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
package javatest.engin;

import java.util.Date;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.apache.log4j.Logger;

import jdk.nashorn.api.scripting.ScriptObjectMirror;

/**
 * DOC zshen class global comment. Detailled comment
 */
public class ScriptEngin {

    static Logger log = Logger.getLogger(ScriptEngin.class);


    public void expersion() {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("javascript"); //$NON-NLS-1$
        Object inputData = "mm"; //$NON-NLS-1$
        String expersion = "==\"mm\""; //$NON-NLS-1$
        try {
            System.out.println(engine.eval("\"" + inputData.toString() + "\"" + expersion)); //$NON-NLS-1$ //$NON-NLS-2$
        } catch (ScriptException e) {
            log.error(e, e);
        }
        Date date = new Date();
        engine.put("date1", date); //$NON-NLS-1$
        engine.put("date2", date); //$NON-NLS-1$
        try {
            System.out.println(engine.eval("date1==date2")); //$NON-NLS-1$
        } catch (ScriptException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void regex() {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("javascript"); //$NON-NLS-1$
        Object inputData = "mm"; //$NON-NLS-1$
        String expersion = "\\\\w{2}"; //$NON-NLS-1$
        engine.put("mm", inputData); //$NON-NLS-1$
        try {
            Object eval = engine.eval("mm.match(\"" + expersion + "\")"); //$NON-NLS-1$ //$NON-NLS-2$
            System.out.println(eval == null ? "null" : ((ScriptObjectMirror) eval).get("0")); //$NON-NLS-1$
        } catch (ScriptException e) {
            log.error(e, e);
        }
    }

    @SuppressWarnings({ "removal", "deprecation" })
    public void contactStr() {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("javascript"); //$NON-NLS-1$
        String oneHandrued = "100";
        engine.put("contextaa", oneHandrued); //$NON-NLS-1$
        try {
            Object eval = engine.eval("\"mm\"+contextaa"); //$NON-NLS-1$
            System.out.println(eval == null ? "null" : eval); //$NON-NLS-1$
        } catch (ScriptException e) {
            log.error(e, e);
        }
    }

    public static void main(String args[]) {
        ScriptEngin scriptEngin = new ScriptEngin();
        // scriptEngin.regex();
        scriptEngin.contactStr();

    }
}
