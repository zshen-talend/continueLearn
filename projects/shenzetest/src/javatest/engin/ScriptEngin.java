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

import jdk.nashorn.api.scripting.ScriptObjectMirror;

import org.apache.log4j.Logger;

/**
 * DOC zshen class global comment. Detailled comment
 */
public class ScriptEngin {

    static Logger log = Logger.getLogger(ScriptEngin.class);

    public void expersion() {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("javascript");
        Object inputData = "mm";
        String expersion = "==\"mm\"";
        try {
            System.out.println(engine.eval("\"" + inputData.toString() + "\"" + expersion));
        } catch (ScriptException e) {
            log.error(e, e);
        }
        Date date = new Date();
        engine.put("date1", date);
        engine.put("date2", date);
        try {
            System.out.println(engine.eval("date1==date2"));
        } catch (ScriptException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void regex() {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("javascript");
        Object inputData = "mm";
        String expersion = "\\\\w{2}";
        engine.put("mm", inputData);
        try {
            Object eval = engine.eval("mm.match(\"" + expersion + "\")");
            System.out.println(eval == null ? "null" : ((ScriptObjectMirror) eval).get(0));
        } catch (ScriptException e) {
            log.error(e, e);
        }
    }

    public static void main(String args[]) {
        ScriptEngin scriptEngin = new ScriptEngin();
        scriptEngin.regex();

    }
}
