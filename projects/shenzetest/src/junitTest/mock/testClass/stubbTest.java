// ============================================================================
//
// Copyright (C) 2006-2011 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package junitTest.mock.testClass;

import java.util.LinkedList;

import org.junit.Test;
import org.mockito.Mockito;


/**
 * DOC zshen  class global comment. Detailled comment
 */
public class stubbTest {

    @Test
    public void TestStubb() {
  //You can mock concrete classes, not only interfaces
    @SuppressWarnings("unchecked")
    LinkedList<String> mockedList = Mockito.mock(LinkedList.class);
    
    //stubbing
        // Mockito.stub(mockedList.get(0)).toReturn("first");
        //
        Mockito.stub(mockedList.get(1)).toThrow(new RuntimeException());

        Mockito.when(mockedList.get(0)).thenReturn("first");
        // Mockito.when(mockedList.get(1)).thenThrow(new RuntimeException());

    //following prints "first"
    System.out.println(mockedList.get(0));
    
    //following throws runtime exception
        try {
            System.out.println(mockedList.get(1));
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    //following prints "null" because get(999) was not stubbed
    System.out.println(mockedList.get(999));
     
    //Although it is possible to verify a stubbed invocation, usually it's just redundant
    //If your code cares what get(0) returns then something else breaks (often before even verify() gets executed).
    //If your code doesn't care what get(0) returns then it should not be stubbed. Not convinced? See here.
    Mockito.verify(mockedList).get(0);
    }
}
