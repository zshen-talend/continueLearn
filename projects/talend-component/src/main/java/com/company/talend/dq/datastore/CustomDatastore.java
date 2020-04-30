package com.company.talend.dq.datastore;

import java.io.Serializable;

import org.talend.sdk.component.api.configuration.Option;
import org.talend.sdk.component.api.configuration.type.DataStore;
import org.talend.sdk.component.api.configuration.ui.layout.GridLayout;
import org.talend.sdk.component.api.configuration.ui.widget.Credential;
import org.talend.sdk.component.api.meta.Documentation;

@DataStore("CustomDatastore")
@GridLayout({
    // the generated layout put one configuration entry per line,
    // customize it as much as needed
    @GridLayout.Row({ "url" }),
    @GridLayout.Row({ "userName" }),
    @GridLayout.Row({ "password" })
})
@Documentation("TODO fill the documentation for this configuration")
public class CustomDatastore implements Serializable {
    @Option
    @Documentation("TODO fill the documentation for this parameter")
    private java.net.URL url;

    @Option
    @Documentation("TODO fill the documentation for this parameter")
    private String userName;

    @Credential
    @Option
    @Documentation("TODO fill the documentation for this parameter")
    private String password;

    public java.net.URL getUrl() {
        return url;
    }

    public CustomDatastore setUrl(java.net.URL url) {
        this.url = url;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public CustomDatastore setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public CustomDatastore setPassword(String password) {
        this.password = password;
        return this;
    }
}