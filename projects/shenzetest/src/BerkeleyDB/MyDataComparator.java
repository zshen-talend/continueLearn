package BerkeleyDB;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Comparator;
import java.util.List;

public class MyDataComparator implements Comparator<byte[]> {

    public MyDataComparator() {
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
     */
    public int compare(byte[] o1, byte[] o2) {

        try {
            ObjectInputStream objInputStream = new ObjectInputStream(new ByteArrayInputStream(o1));
            List<Object> rowList = (List<Object>) objInputStream.readObject();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;
    }

}