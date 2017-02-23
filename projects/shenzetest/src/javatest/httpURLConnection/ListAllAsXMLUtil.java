// ============================================================================
//
// Copyright (C) 2006-2016 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package javatest.httpURLConnection;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * This is the regex util class.
 * 
 * $Id: ListAllAsXMLUtil.java,v 1.1 2009/04/21 07:20:39 shong Exp $
 * 
 */

public class ListAllAsXMLUtil {

    public InputStream getReturnXMLInputStreamOfLast(String maxRows) throws Exception {

        String urlString = "http://regexlib.com/WebServices.asmx";

        String soapActionString = "http://regexlib.com/webservices.asmx/ListAllAsXml";
        java.net.URL url = new java.net.URL(urlString);
        java.net.HttpURLConnection httpConn = (java.net.HttpURLConnection) url.openConnection();
        String s = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"
                + "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">"
                + "<soap12:Body>" + "<ListAllAsXml xmlns=\"http://regexlib.com/webservices.asmx\">" + "<maxrows>" + maxRows
                + "</maxrows>" + "</ListAllAsXml>" + "</soap12:Body>" + "</soap12:Envelope>";
        byte[] buf = s.getBytes();
        httpConn.setRequestProperty("Content-Length", String.valueOf(buf.length));
        httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
        httpConn.setRequestProperty("soapActionString", soapActionString);
        httpConn.setRequestMethod("POST");
        httpConn.setDoOutput(true);
        httpConn.setDoInput(true);
        java.io.OutputStream out = httpConn.getOutputStream();
        out.write(buf);

        out.close();
        InputStream inStream = httpConn.getInputStream();

        // httpConn.disconnect();
        return inStream;

    }

    // public InputStream getReturnXMLInputStreamOfFind(String regexpSubstring, String keyWord, String minRate) throws Exception {
    // int ResponseCode = 0;
    // java.net.HttpURLConnection httpConn = null;
    // while (ResponseCode != 200) {
    // String urlString = "http://regexlib.com/WebServices.asmx?AspxAutoDetectCookieSupport=1";
    //
    // String soapActionString = "http://regexlib.com/webservices.asmx/listRegExp";
    // java.net.URL url = new java.net.URL(urlString);
    //
    // httpConn = (java.net.HttpURLConnection) url.openConnection();
    // httpConn.setInstanceFollowRedirects(false);
    // url = new java.net.URL("http://regexlib.com" + httpConn.getHeaderField("Location"));
    // httpConn = (java.net.HttpURLConnection) url.openConnection();
    // String s = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"
    // +
    // "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">"
    // + "<soap:Body>" + "<listRegExp xmlns=\"http://regexlib.com/webservices.asmx\">" + "<keyword>" + keyWord
    // + "</keyword>" + "<regexp_substring>" + regexpSubstring + "</regexp_substring>" + "<min_rating>" + minRate
    // + "</min_rating>" + "<howmanyrows>3</howmanyrows>" + "</listRegExp>" + "</soap:Body>" + "</soap:Envelope>";
    //
    // byte[] buf = s.getBytes();
    // httpConn.setRequestProperty("Content-Length", String.valueOf(buf.length));
    // httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
    // httpConn.setRequestProperty("soapActionString", soapActionString);
    // httpConn.setRequestMethod("POST");
    // httpConn.setDoOutput(true);
    // httpConn.setDoInput(true);
    // java.io.OutputStream out = httpConn.getOutputStream();
    // out.write(buf);
    // out.flush();
    // out.close();
    // ResponseCode = httpConn.getResponseCode();
    // System.out.println(ResponseCode);
    // System.out.println(httpConn.getResponseMessage());
    // }
    // InputStream inStream = httpConn.getInputStream();
    // // httpConn.disconnect();
    //
    // return inStream;
    // }

    public InputStream getReturnXMLInputStreamOfFind(String regexpSubstring, String keyWord, String minRate) throws Exception {
        int ResponseCode = 0;
        java.net.HttpURLConnection httpConn = null;
            String urlString = "http://regexlib.com/WebServices.asmx?AspxAutoDetectCookieSupport=1";

            String soapActionString = "http://regexlib.com/webservices.asmx/listRegExp";
            java.net.URL url = new java.net.URL(urlString);

            httpConn = (java.net.HttpURLConnection) url.openConnection();

            httpConn.setInstanceFollowRedirects(false);
            url = new java.net.URL("http://regexlib.com" + httpConn.getHeaderField("Location"));
            httpConn = (java.net.HttpURLConnection) url.openConnection();
            String s = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"
                    + "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">"
                    + "<soap12:Body>" + "<listRegExp xmlns=\"http://regexlib.com/webservices.asmx\">" + "<keyword>" + keyWord
                    + "</keyword>" + "<regexp_substring>" + regexpSubstring + "</regexp_substring>" + "<min_rating>" + minRate
                    + "</min_rating>" + "<howmanyrows>3</howmanyrows>" + "</listRegExp>" + "</soap12:Body>"
                    + "</soap12:Envelope>";

            byte[] buf = s.getBytes();
            httpConn.setRequestProperty("Content-Length", String.valueOf(buf.length));
            httpConn.setRequestProperty("Content-Type", "application/soap+xml; charset=utf-8");
            httpConn.setRequestProperty("soapActionString", soapActionString);
            httpConn.setRequestMethod("POST");
            httpConn.setDoOutput(true);
            httpConn.setDoInput(true);
            java.io.OutputStream out = httpConn.getOutputStream();
            out.write(buf);
            out.flush();
            out.close();
            ResponseCode = httpConn.getResponseCode();
            System.out.println(ResponseCode);
            System.out.println(httpConn.getResponseMessage());
        InputStream inStream = httpConn.getInputStream();

        return inStream;
    }
    
    public static void main(String[] parms) throws Exception {
        String loopElement_tFindRegexlibExpressions_1 = "/soap:Envelope/soap:Body/listRegExpResponse/listRegExpResult/diffgr:diffgram/NewDataSet/Expressions";
        ListAllAsXMLUtil xmlUtil=new ListAllAsXMLUtil();
        java.io.InputStream inStream_tFindRegexlibExpressions_1 = xmlUtil
.getReturnXMLInputStreamOfLast("20");
        // java.io.InputStream inStream_tFindRegexlibExpressions_1 = xmlUtil
        // .getReturnXMLInputStreamOfFind("a-z", "email", "1");
        BufferedInputStream buffIS = new BufferedInputStream(inStream_tFindRegexlibExpressions_1);
        FileOutputStream fileOS = new FileOutputStream("D:/tempOutPut.xml");
        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = buffIS.read(buf)) != -1) {
            fileOS.write(buf, 0, len);
        }
        //
        // SAXReader reader_tFindRegexlibExpressions_1 = new SAXReader();
        //
        // org.dom4j.Document doc_tFindRegexlibExpressions_1 = reader_tFindRegexlibExpressions_1
        // .read(inStream_tFindRegexlibExpressions_1);
        //
        // org.talend.regexUtil.NameSpaceTool nsTool_tFindRegexlibExpressions_1 = new org.talend.regexUtil.NameSpaceTool();
        //
        // nsTool_tFindRegexlibExpressions_1
        // .countNSMap(doc_tFindRegexlibExpressions_1
        // .getRootElement());
        //
        // java.util.HashMap<String, String> xmlNameSpaceMap_tFindRegexlibExpressions_1 =
        // nsTool_tFindRegexlibExpressions_1.xmlNameSpaceMap;
        //
        // org.dom4j.XPath x_tFindRegexlibExpressions_1 = doc_tFindRegexlibExpressions_1
        // .createXPath(nsTool_tFindRegexlibExpressions_1
        // .addDefaultNSPrefix(
        // loopElement_tFindRegexlibExpressions_1,
        // loopElement_tFindRegexlibExpressions_1));
        //
        // x_tFindRegexlibExpressions_1
        // .setNamespaceURIs(xmlNameSpaceMap_tFindRegexlibExpressions_1);
        //
        // java.util.List<org.dom4j.tree.AbstractNode> nodeList_tFindRegexlibExpressions_1 = x_tFindRegexlibExpressions_1
        // .selectNodes(doc_tFindRegexlibExpressions_1);
        buffIS.close();
        fileOS.close();
    }
}
