package com.company.talend.dq.source;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.talend.sdk.component.api.configuration.Option;
import org.talend.sdk.component.api.input.Producer;
import org.talend.sdk.component.api.meta.Documentation;
import org.talend.sdk.component.api.record.Record;
import org.talend.sdk.component.api.service.record.RecordBuilderFactory;

import com.company.talend.dq.datastore.CustomDatastore;
import com.company.talend.dq.service.TalendComponentService;

@Documentation("TODO fill the documentation for this source")
public class MySQLInputSource implements Serializable {
    private final MySQLInputMapperConfiguration configuration;
    private final TalendComponentService service;
    private final RecordBuilderFactory builderFactory;

    private int index = 0;

    public MySQLInputSource(@Option("configuration") final MySQLInputMapperConfiguration configuration,
                        final TalendComponentService service,
                        final RecordBuilderFactory builderFactory) {
        this.configuration = configuration;
        this.service = service;
        this.builderFactory = builderFactory;
    }

    @PostConstruct
    public void init() {
        index = 100;
        // this method will be executed once for the whole component execution,
        // this is where you can establish a connection for instance
    }

    @Producer
    public Record next() {
        org.talend.sdk.component.api.record.Record.Builder newRecordBuilder = builderFactory.newRecordBuilder();

        CustomDatastore datastore = configuration.getDataset().getDatastore();
        String value = datastore.getUrl() + datastore.getUserName() + datastore.getPassword() + index--;
        Record record = newRecordBuilder.withString("zshenValue", value).build();
        // this is the method allowing you to go through the dataset associated
        // to the component configuration
        //
        // return null means the dataset has no more data to go through
        // you can use the builderFactory to create a new Record.
        if (index > 0) {
        return record;
        } else {
            return null;
        }
    }

    @PreDestroy
    public void release() {
        index = 0;
        // this is the symmetric method of the init() one,
        // release potential connections you created or data you cached
    }
}