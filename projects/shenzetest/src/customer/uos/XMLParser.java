package customer.uos;

import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class XMLParser {

    public int lineCount = 0;

    public int threadCount = 0;

    int errorCount = 0;

    String currThread;

    List<Message> messList = null;

    List<Trace> traceList = null;

    List<Failure> failList = null;

    Message currMes = null;

    Trace currTrace = null;

    Failure currFail = null;

    boolean startTrace = false;

    boolean startFail = false;

    public void RunParse() throws XMLStreamException {
        String tagContent = null;
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = factory.createXMLStreamReader(ClassLoader.getSystemResourceAsStream("customer/uos/test.xml"));

        while (reader.hasNext()) {
            int event = reader.next();

            switch (event) {
            case XMLStreamConstants.START_ELEMENT:
                if ("result".equals(reader.getLocalName()) && "FAILURE".equals(reader.getAttributeValue(1))) {
                    currMes = new Message();
                    currMes.statusText = reader.getAttributeValue(0) + " " + reader.getAttributeValue(1);
                }
                if ("goto_trace".equals(reader.getLocalName())) {
                    traceList = new ArrayList<>();
                    failList = new ArrayList<>();
                    startTrace = true;
                }
                if ("failure".equals(reader.getLocalName()) && startTrace) {
                    currFail = new Failure();
                    startFail = true;
                }
                if ("assignment".equals(reader.getLocalName()) && startTrace) {
                    if (reader.getAttributeValue(7) != null) {
                        currThread = reader.getAttributeValue(7);
                    }
                    currTrace = new Trace();
                    currTrace.errorType = reader.getAttributeValue(0);
                }
                if ("cprover".equals(reader.getLocalName())) {
                    messList = new ArrayList<>();
                }
                break;

            case XMLStreamConstants.CHARACTERS:
                tagContent = reader.getText().trim();
                break;

            case XMLStreamConstants.END_ELEMENT:
                if (startTrace) {
                    switch (reader.getLocalName()) {
                    case "goto_trace":
                        errorCount++;
                        startTrace = false;
                        System.out.println("Error " + errorCount + " in Thread " + currThread + ":");
                        messList.add(currMes);
                        System.out.println("Error reason: ");
                        for (Failure fail : failList) {
                            System.out.println(fail);
                            lineCount++;
                        }
                        System.out.println("Counter examples:");
                        for (Trace tra : traceList) {
                            System.out.println(tra);
                            lineCount++;
                        }
                        System.out.println("----------------------------------------------");
                        break;
                    case "assignment":
                        traceList.add(currTrace);
                        break;
                    case "failure":
                        failList.add(currFail);
                        startFail = false;
                        break;
                    case "reason":
                        if (startFail) {
                            currFail.reason = tagContent;
                        }
                        break;
                    case "file":
                        if (startFail) {
                            currFail.file = tagContent;
                        }
                        break;
                    case "line":
                        if (startFail) {
                            currFail.line = tagContent;
                        }
                        break;
                    case "function":
                        if (startFail) {
                            currFail.function = tagContent;
                        }
                        break;
                    case "thread":
                        currThread = tagContent;
                        break;
                    case "full_lhs":
                        currTrace.errorType = tagContent;
                        break;
                    case "full_lhs_value":
                        currTrace.errorTrace = tagContent;
                        break;
                    }
                } else {
                    switch (reader.getLocalName()) {
                    case "program":
                        System.out.println("The verification program using is: " + tagContent);
                        break;
                    }
                }
                break;

            case XMLStreamConstants.START_DOCUMENT:
                messList = new ArrayList<>();
                traceList = new ArrayList<>();
                break;
            }

        }

        if (failList == null) {
            System.out.println("No error dectected! Verification successful!");
        }

        // Print the message list populated from XML
        // for (Message mess : messList){
        // System.out.println(mess);
        // lineCount++;
        // }
    }
}
