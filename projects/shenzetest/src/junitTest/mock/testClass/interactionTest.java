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
public class interactionTest {

    @Test
    public void testInteractionTrue() {
        @SuppressWarnings("unchecked")
        List<String> mockOne = Mockito.mock(List.class);
        @SuppressWarnings("unchecked")
        List<String> mockTwo = Mockito.mock(List.class);
        @SuppressWarnings("unchecked")
        List<String> mockThree = Mockito.mock(List.class);
        // using mocks - only mockOne is interacted
        mockOne.add("one");

        // ordinary verification
        Mockito.verify(mockOne).add("one");

        // verify that method was never called on a mock
        Mockito.verify(mockOne, Mockito.never()).add("two");

        // verify that other mocks were not interacted
        Mockito.verifyZeroInteractions(mockTwo, mockThree);
    }

    @Test
    public void testInteractionfalse() {
        @SuppressWarnings("unchecked")
        List<String> mockedList = Mockito.mock(List.class);

        // using mocks
        mockedList.add("one");
        mockedList.add("two");

        Mockito.verify(mockedList).add("one");
        // If below is work then the test will passed.
        // Mockito.verify(mockedList).add("two");

        // following verification will fail
        Mockito.verifyNoMoreInteractions(mockedList);

    }
}
