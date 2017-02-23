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
package iostream;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

public class FileChannelStudy {

    static String filename1 = "d:\\work\\code\\filechannelstudy.txt";

    static String filename2 = "d:\\work\\code\\file.txt";

    // static String content = "abcdefghijk\r\n";
    static String content = "a";

    static long size = 1024000000l;

    static long num = 100000;

    static long startT = 0;

    static long endT = 0;

    public static void setStartT() {
        startT = System.currentTimeMillis();
    }

    public static long ellipseT() {
        endT = System.currentTimeMillis();
        long consumeT = endT - startT;
        System.out.println("consume time :" + consumeT / 1000 + " second");
        return consumeT / 1000;
    }

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        // readFile1();
        createFile(true);
        // preparedFile1();
        // preparedFile2();
        preparedFile3();
        readFile2();

    }

    public static void createFile(boolean bReCreate) throws IOException {
        if (!bReCreate) {
            File f = new File(filename1);
            if (!f.exists()) {
                f.createNewFile();
            }
            f = new File(filename2);
            if (!f.exists()) {
                f.createNewFile();
            }
        } else {
            File f = new File(filename1);
            if (f.exists()) {
                f.delete();
            }
            f.createNewFile();
            f = new File(filename2);
            if (f.exists()) {
                f.delete();
            }
            f.createNewFile();
        }
    }

    public static void preparedFile2() throws IOException {

        BufferedOutputStream bo = new BufferedOutputStream(new FileOutputStream(filename2));
        try {
            System.out.println("fill file by io");
            setStartT();
            for (int i = 0; i < num; i++) {
                bo.write(content.getBytes());
            }
            ellipseT();
        } finally {
            if (bo != null) {
                bo.close();
            }
        }
    }

    public static void preparedFile1() throws IOException {
        long mapsize = content.getBytes().length * 10;
        long position = 0;
        FileChannel ch = new RandomAccessFile(filename1, "rw").getChannel();
        MappedByteBuffer mbb = ch.map(MapMode.READ_WRITE, position, mapsize);
        int cnt = 0;
        try {
            System.out.println("fill file by nio");
            setStartT();
            for (int i = 0; i < num; i++) {
                if (mbb.remaining() < content.getBytes().length) {
                    cnt++;
                    position += mbb.position();
                    mbb = null;
                    if (cnt % 50 == 0) {
                        System.gc();
                        System.out.println("call gc");
                    }
                    mbb = ch.map(MapMode.READ_WRITE, position, mapsize);
                }
                mbb.put(content.getBytes());
            }
            ellipseT();
        } finally {
            if (ch != null) {
                ch.close();
            }
        }
    }

    public static void preparedFile3() throws IOException {
        long mapsize = content.getBytes().length + 1;
        long position = 0;
        FileChannel ch = new RandomAccessFile(filename1, "rw").getChannel();
        MappedByteBuffer mbb = ch.map(MapMode.READ_WRITE, position, mapsize);
        int cnt = 0;
        try {
            System.out.println("fill file by nio");
            setStartT();
            for (int i = 0; i < 3; i++) {
                if (mbb.remaining() < content.getBytes().length) {
                    cnt++;
                    position += mbb.position();
                    mbb = null;
                    if (cnt % 50 == 0) {
                        System.gc();
                        System.out.println("call gc");
                    }
                    mbb = ch.map(MapMode.READ_WRITE, position, mapsize);
                }
                mbb.put("b".getBytes());
                mbb.put(content.getBytes());
            }
            mbb = ch.map(MapMode.READ_WRITE, 0, mapsize);
            mbb.put("ccc".getBytes());
            ellipseT();
        } finally {
            if (ch != null) {
                ch.close();
            }
        }
    }

    public static void readFile1() throws IOException {
        long mapsize = content.getBytes().length * 1000000;
        long position = 0;
        // long rper = 2000000000;
        long rper = 1300000000;
        FileChannel ch = new RandomAccessFile(filename1, "rw").getChannel();
        MappedByteBuffer mbb = ch.map(MapMode.READ_WRITE, 0, rper);
        int rs = 102400;
        byte dst[] = new byte[rs];
        int cnt = 0;
        while (mbb.hasRemaining()) {
            ByteBuffer bb = mbb.get(dst);
            cnt++;
            if (cnt % 50 == 0) {
                System.out.println(bb.toString());
            }
        }
    }

    public static void readFile2() throws IOException {
        long mapsize = content.getBytes().length + 10;
        long position = 0;
        // long rper = 2000000000;
        long rper = 130;
        FileChannel ch = new RandomAccessFile(filename1, "rw").getChannel();
        final MappedByteBuffer mbb = ch.map(MapMode.READ_WRITE, 0, rper);
        int rs = 2;
        byte dst[] = new byte[rs];
        int cnt = 0;
        while (mbb.hasRemaining()) {
            final ByteBuffer bb = mbb.get(dst);
            String strReturn = new String(dst, "UTF-8");
            System.out.println(strReturn);
            // remove unused handle
            // AccessController.doPrivileged(new PrivilegedAction() {
            //
            // public Object run() {
            // try {
            // Method getCleanerMethod = mbb.getClass().getMethod("cleaner", new Class[0]);
            // getCleanerMethod.setAccessible(true);
            // sun.misc.Cleaner cleaner = (sun.misc.Cleaner) getCleanerMethod.invoke(bb, new Object[0]);
            // cleaner.clean();
            // } catch (Exception e) {
            // e.printStackTrace();
            // }
            // return null;
            // }
            // });
        }
    }
}
