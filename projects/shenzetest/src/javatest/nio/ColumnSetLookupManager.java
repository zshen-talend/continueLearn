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
package javatest.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

import org.talend.designer.components.persistent.IRowCreator;

/**
 * created by talend on Jun 13, 2014 Detailled comment
 * 
 */
public class ColumnSetLookupManager extends AbstratcLookupManager<ColumnSetRow> {

    private FileChannel ch = null;

    private String container;

    private IRowCreator<ColumnSetRow> rowCreator;

    private Long maxLength = 100l;

    // this file should be init when we write something
    private MappedByteBuffer mbb = null;

    public ColumnSetLookupManager(String filePath, IRowCreator<ColumnSetRow> rowCreator) {
        this.container = filePath;
        this.rowCreator = rowCreator;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.designer.components.lookup.persistent.IPersistentLookupManager#initPut()
     */
    public void initPut() throws IOException {
        ch = new RandomAccessFile(buildTempFilePath(), "rw").getChannel();
        // here should mapping whole of the file
        mbb = ch.map(MapMode.READ_WRITE, 0, maxLength);
        // mark this position so that we can do rest to instead of map again
        mbb.mark();
        // do map at every columSetRow/

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.designer.components.lookup.persistent.IPersistentLookupManager#put(java.lang.Object)
     */
    public void put(ColumnSetRow bean) throws IOException {
        bean.writeData();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.designer.components.lookup.persistent.IPersistentLookupManager#endPut()
     */
    public void endPut() throws IOException {
        System.gc();

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.designer.components.lookup.persistent.IPersistentLookupManager#initGet()
     */
    public void initGet() throws IOException {
        ch = new RandomAccessFile(buildTempFilePath(), "rw").getChannel();
        // here should mapping whole of the file
        mbb = ch.map(MapMode.READ_ONLY, 0, maxLength);
        // mark this position so that we can do rest to instead of map again
        mbb.mark();
        // do map at every columSetRow/
    }

    /**
     * DOC talend Comment method "buildTempFilePath".
     * 
     * @return
     */
    private String buildTempFilePath() {
        return container + "CloumnSetData.bin"; //$NON-NLS-1$ 
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.designer.components.lookup.persistent.IPersistentLookupManager#lookup(java.lang.Object)
     */
    public void lookup(ColumnSetRow key) throws IOException {
        // need some cache i think ar here we will find columnSetRow in the cache firstly

        // find columnSetRow in the file
        mbb.reset();// we need to find the row from starting
        while (hasNext()) {
            ColumnSetRow nextColumnSetRow = next();
            if (nextColumnSetRow.compareTo(key) == 0) {
                nextColumnSetRow.increaseFrequency();
                nextColumnSetRow.copyDataTo(key);
                break;
            }
        }

        // if can not find one we will think current columnSetRow is a new one and need to persistence it dirctly

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.designer.components.lookup.persistent.IPersistentLookupManager#hasNext()
     */
    public boolean hasNext() throws IOException {
        mbb.mark();
        if (mbb.hasRemaining() && mbb.getInt() != 0) {
            mbb.reset();
            return true;
        }
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.designer.components.lookup.persistent.IPersistentLookupManager#next()
     */
    public ColumnSetRow next() throws IOException {
        ColumnSetRow newColumnSetInstance = rowCreator.createRowInstance();
        newColumnSetInstance.setStartLocation(mbb.position());
        newColumnSetInstance.setCh(ch);
        newColumnSetInstance.readData();
        return newColumnSetInstance;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.designer.components.lookup.persistent.IPersistentLookupManager#endGet()
     */
    public void endGet() throws IOException {
        System.gc();

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.designer.components.lookup.persistent.IPersistentLookupManager#clear()
     */
    public void clear() throws IOException {
        System.gc();

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.designer.components.lookup.persistent.IPersistentLookupManager#getNextFreeRow()
     */
    public ColumnSetRow getNextFreeRow() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Getter for ch.
     * 
     * @return the ch
     */
    public FileChannel getCh() {
        return this.ch;
    }
}
