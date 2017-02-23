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


/**
 * created by talend on Jun 5, 2014 Detailled comment
 * 
 */
public class SplitBigFiles {

    // public void execute() {
    // try {
    // File fcut = new File(frame.jTextField6.getText());
    // File fsave = new File(frame.jTextField5.getText() + "\\" + this.findname());
    // if (!fsave.exists()) {
    // fsave.mkdir();
    // }
    // File findex = new File(frame.jTextField5.getText() + "\\" + this.findname() + "\\cut.index");
    // FileWriter fw = new FileWriter(findex);
    // BufferedWriter bw = new BufferedWriter(fw);
    // bw.write(this.findname() + "." + this.findkuozhan(), 0, (this.findname() + "." + this.findkuozhan()).length());
    // bw.newLine();
    //
    // int num = size_i; // 分割份数
    // long totalsize = fcut.length(); // 文件总大小
    // long persize = totalsize / num; // 每个大小
    //
    // FileInputStream fis = new FileInputStream(fcut);
    // FileChannel fic = fis.getChannel();
    //
    // if (persize > buffersize) {
    // for (int i = 0; i < num; i++) {
    // RandomAccessFile ras = new RandomAccessFile(frame.jTextField5.getText() + "\\" + this.findname() + "\\"
    // + this.findname() + ".cut" + (i + 1), "rw");
    // FileChannel frs = ras.getChannel();
    // if (i < num - 1) {
    // for (int j = 0; j < persize / buffersize; j++) {
    // if (j < persize / buffersize - 1) {
    // MappedByteBuffer mibb = fic.map(FileChannel.MapMode.READ_ONLY, i * persize + j * buffersize,
    // buffersize);
    // MappedByteBuffer mobb = frs.map(FileChannel.MapMode.READ_WRITE, j * buffersize, buffersize);
    // mobb.put(mibb);
    // mibb.clear();
    // mobb.clear();
    // } else {
    // MappedByteBuffer mibb = fic.map(FileChannel.MapMode.READ_ONLY, i * persize + j * buffersize,
    // buffersize + persize % buffersize);
    // MappedByteBuffer mobb = frs.map(FileChannel.MapMode.READ_WRITE, j * buffersize, buffersize
    // + persize % buffersize);
    // mobb.put(mibb);
    // mibb.clear();
    // mobb.clear();
    // }
    // }
    // System.gc();
    // System.runFinalization();
    // bw.write(
    // frame.jTextField5.getText() + "\\" + this.findname() + "\\" + this.findname() + ".cut" + (i + 1),
    // 0,
    // (frame.jTextField5.getText() + "\\" + this.findname() + "\\" + this.findname() + ".cut" + (i + 1))
    // .length());
    // bw.newLine();
    // } else {
    // for (int j = 0; j < persize / buffersize; j++) {
    // if (j < persize / buffersize - 1) {
    // MappedByteBuffer mibb = fic.map(FileChannel.MapMode.READ_ONLY, i * persize + j * buffersize,
    // buffersize);
    // MappedByteBuffer mobb = frs.map(FileChannel.MapMode.READ_WRITE, j * buffersize, buffersize);
    // mobb.put(mibb);
    // mibb.clear();
    // mobb.clear();
    // } else {
    // MappedByteBuffer mibb = fic.map(FileChannel.MapMode.READ_ONLY, i * persize + j * buffersize,
    // totalsize - (i * persize + j * buffersize));
    // MappedByteBuffer mobb = frs.map(FileChannel.MapMode.READ_WRITE, j * buffersize, totalsize
    // - (i * persize + j * buffersize));
    // mobb.put(mibb);
    // mibb.clear();
    // mobb.clear();
    // }
    // }
    // System.gc();
    // System.runFinalization();
    // bw.write(
    // frame.jTextField5.getText() + "\\" + this.findname() + "\\" + this.findname() + ".cut" + (i + 1),
    // 0,
    // (frame.jTextField5.getText() + "\\" + this.findname() + "\\" + this.findname() + ".cut" + (i + 1))
    // .length());
    // bw.close();
    // fw.close();
    // }
    // ras.close();
    // frs.close();
    // }
    // fis.close();
    // fic.close();
    //
    // } else {
    // for (int i = 0; i < num; i++) {
    // RandomAccessFile ras = new RandomAccessFile(frame.jTextField5.getText() + "\\" + this.findname() + "\\"
    // + this.findname() + ".cut" + (i + 1), "rw");
    // FileChannel frs = ras.getChannel();
    // if (i < num - 1) {
    //
    // MappedByteBuffer mibb = fic.map(FileChannel.MapMode.READ_ONLY, i * persize, persize);
    // MappedByteBuffer mobb = frs.map(FileChannel.MapMode.READ_WRITE, 0, persize);
    // mobb.put(mibb);
    // mibb.clear();
    // mobb.clear();
    //
    // System.gc();
    // System.runFinalization();
    // bw.write(
    // frame.jTextField5.getText() + "\\" + this.findname() + "\\" + this.findname() + ".cut" + (i + 1),
    // 0,
    // (frame.jTextField5.getText() + "\\" + this.findname() + "\\" + this.findname() + ".cut" + (i + 1))
    // .length());
    // bw.newLine();
    // } else {
    //
    // MappedByteBuffer mibb = fic.map(FileChannel.MapMode.READ_ONLY, i * persize, totalsize - i * persize);
    // MappedByteBuffer mobb = frs.map(FileChannel.MapMode.READ_WRITE, 0, totalsize - i * persize);
    // mobb.put(mibb);
    // mibb.clear();
    // mobb.clear();
    //
    // System.gc();
    // System.runFinalization();
    // bw.write(
    // frame.jTextField5.getText() + "\\" + this.findname() + "\\" + this.findname() + ".cut" + (i + 1),
    // 0,
    // (frame.jTextField5.getText() + "\\" + this.findname() + "\\" + this.findname() + ".cut" + (i + 1))
    // .length());
    // bw.close();
    // fw.close();
    // }
    // ras.close();
    // frs.close();
    // }
    // fis.close();
    // fic.close();
    //
    // }
    // jop = new JOptionPane();
    // jop.showMessageDialog(frame.getContentPane(), "文件分割完毕！", "成功", JOptionPane.ERROR_MESSAGE);
    // } catch (Exception e) {
    // jop = new JOptionPane();
    // jop.showMessageDialog(frame.getContentPane(), e.toString(), "错误", JOptionPane.ERROR_MESSAGE);
    // }
    // }

    public static void main(String args[]) {

    }
}
