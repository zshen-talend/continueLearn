package customer.uos;

import javax.xml.stream.XMLStreamException;

public class MainTest {

    public static void main(String args[]) throws XMLStreamException {
        XMLParser xm = new XMLParser();
        xm.RunParse();
        System.out.println(xm.lineCount);
    }
}
