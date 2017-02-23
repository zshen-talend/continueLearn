/*
 * Copyright 2011 Cheng Fu
 */
package javatest.io;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author chengfu
 */
public class ReusableInputStream extends BufferedInputStream {

    private boolean readAttempted = false;

    public ReusableInputStream(InputStream input) {
        super(input);
    }

    @Override
    public synchronized int read() throws IOException {
        return super.read();
    }

    @Override
    public synchronized int read(byte[] b, int off, int len) throws IOException {
        return super.read(b, off, len);
    }

    @Override
    public int read(byte[] b) throws IOException {
        return super.read(b);
    }

}
