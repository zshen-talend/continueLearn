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
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MappedFile {
    //文件名
    private String fileName;
    //文件路径
    private String filePath;
    //文件对象
    private File file;
    
    private MappedByteBuffer mappedByteBuffer;
    
    private FileChannel fileChannel;
    
    private boolean bundSuccess=false;
    //文件大小
    private final static long MAX_FILE_SIZE = 1024*1024*50;
    //文件写入位置
    private long writePosition = 0;
    //最后一次刷数据的时间
    private long lastFlushTime;
    //上一次刷的文件位置
    private long lastFlushFilePosition=0;
    //最大的脏数据量，系统必须触发一次强制刷
    private long MAX_FLUSH_DATA_SIZE = 1024*512;
    //最大的时间间隔，系统必须触发一次强制刷
    private long MAX_FLUSH_TIME_GAP = 1000;

    public MappedFile(String fileName, String filePath) {
        super();
        this.fileName = fileName;
        this.filePath = filePath;
        this.file = new File(filePath+"/"+fileName);
        if(!file.exists()){
             try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
         }
    }
    
    
    /**
      * 内存映射文件绑定
      * @return
      */
     public synchronized boolean boundChannelToByteBuffer(){
         try {
             RandomAccessFile raf = new RandomAccessFile(file, "rw");
             this.fileChannel = raf.getChannel();
        } catch (Exception e) {
            e.printStackTrace();
            this.bundSuccess=false;
            return false;
        }
        
        try {
            this.mappedByteBuffer = this.fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, MAX_FILE_SIZE);
        } catch (IOException e) {
            e.printStackTrace();
            this.bundSuccess=false;
            return false;
        }
        
         this.bundSuccess=true;
         return true;
     }
    
    public synchronized boolean appendData(byte[] data) throws Exception{
        if(!bundSuccess){
            throw new Exception("内存映射文件没有建立,请检查...");
        }
        
        writePosition = writePosition + data.length;
        if(writePosition >= MAX_FILE_SIZE){
             flush();
             writePosition = writePosition - data.length;
             System.out.println("File="+file.toURI().toString()+" is writed full.");
             System.out.println("already write data length:"+writePosition+"max file size="+MAX_FILE_SIZE);
             return false;
         }
        
        this.mappedByteBuffer.put(data);
        //检测修改量
        if(writePosition-lastFlushFilePosition>this.MAX_FLUSH_DATA_SIZE){
            flush();
        }
        //检测时间间隔
        if(System.currentTimeMillis()-lastFlushTime>this.MAX_FLUSH_TIME_GAP && writePosition>lastFlushFilePosition){
            flush();
        }
        
        return true;
    }
    
     
    public synchronized void flush(){
         this.mappedByteBuffer.force();
         this.lastFlushTime=System.currentTimeMillis();
         this.lastFlushFilePosition=writePosition;
     }


    public long getLastFlushTime() {
        return lastFlushTime;
    }


    public String getFileName() {
        return fileName;
    }


    public String getFilePath() {
        return filePath;
    }


    public boolean isBundSuccess() {
        return bundSuccess;
    }


    public File getFile() {
        return file;
    }


    public static long getMaxFileSize() {
        return MAX_FILE_SIZE;
    }


    public long getWritePosition() {
        return writePosition;
    }


    public long getLastFlushFilePosition() {
        return lastFlushFilePosition;
    }


    public long getMAX_FLUSH_DATA_SIZE() {
        return MAX_FLUSH_DATA_SIZE;
    }


    public long getMAX_FLUSH_TIME_GAP() {
        return MAX_FLUSH_TIME_GAP;
    }
}