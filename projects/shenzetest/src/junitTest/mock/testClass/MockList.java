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

import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;


/**
 * DOC zshen  class global comment. Detailled comment
 */
public class MockList {

    
    @Test
    public void testList() {
    //mock creation
        @SuppressWarnings("unchecked")
        List<String> mockedList = Mockito.mock(List.class);
    
    //using mock object
    mockedList.add("one");
    mockedList.clear();
    
    //verification
    Mockito.verify(mockedList).add("one");
    Mockito.verify(mockedList).clear();
    }
}
