package com.company.talend.dq.source;

import java.io.Serializable;

import com.company.talend.dq.dataset.CustomDataset;

import org.talend.sdk.component.api.configuration.Option;
import org.talend.sdk.component.api.configuration.ui.layout.GridLayout;
import org.talend.sdk.component.api.meta.Documentation;

@GridLayout({
    // the generated layout put one configuration entry per line,
    // customize it as much as needed
    @GridLayout.Row({ "dataset" }),
    @GridLayout.Row({ "timeout" })
})
@Documentation("TODO fill the documentation for this configuration")
public class MySQLInputMapperConfiguration implements Serializable {
    @Option
    @Documentation("TODO fill the documentation for this parameter")
    private CustomDataset dataset;

    @Option
    @Documentation("TODO fill the documentation for this parameter")
    private int timeout;

    public CustomDataset getDataset() {
        return dataset;
    }

    public MySQLInputMapperConfiguration setDataset(CustomDataset dataset) {
        this.dataset = dataset;
        return this;
    }

    public int getTimeout() {
        return timeout;
    }

    public MySQLInputMapperConfiguration setTimeout(int timeout) {
        this.timeout = timeout;
        return this;
    }
}