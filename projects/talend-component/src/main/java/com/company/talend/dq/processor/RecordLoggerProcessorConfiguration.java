package com.company.talend.dq.processor;

import java.io.Serializable;

import org.talend.sdk.component.api.configuration.Option;
import org.talend.sdk.component.api.configuration.ui.layout.GridLayout;
import org.talend.sdk.component.api.configuration.ui.widget.Code;
import org.talend.sdk.component.api.meta.Documentation;

@GridLayout({
    // the generated layout put one configuration entry per line,
    // customize it as much as needed
        @GridLayout.Row({ "javacode" }) })
@Documentation("TODO fill the documentation for this configuration")
public class RecordLoggerProcessorConfiguration implements Serializable {

    @Option
    @Code("java")
    @Documentation("")
    private String javacode;

    public String getJavacode() {
        return javacode;
    }

    public RecordLoggerProcessorConfiguration setJavacode(String javacode) {
        this.javacode = javacode;
        return this;
    }
}