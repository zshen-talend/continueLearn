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

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;

/**
 * DOC zshen  class global comment. Detailled comment
 */
public class MockTestSummary {

    @Test
    public void testArgumentMatcher() {
        List<String> mock = Mockito.mock(List.class);

        Mockito.when(mock.addAll(Mockito.argThat(new IsListOfTwoElements()))).thenReturn(true);

        mock.addAll(Arrays.asList("one", "two"));

        Mockito.verify(mock).addAll(Mockito.argThat(new IsListOfTwoElements()));

    }


    @Test
    public void testVoidMethod() {
        List<String> mock = Mockito.mock(List.class);

        Mockito.when(mock.addAll(Mockito.argThat(new IsListOfTwoElements()))).thenReturn(true);
        Mockito.doNothing().when(mock).clear();

        mock.addAll(Arrays.asList("one", "two"));
        mock.clear();
        Mockito.verify(mock).addAll(Mockito.argThat(new IsListOfTwoElements()));

    }

    class IsListOfTwoElements extends ArgumentMatcher<List> {

        public boolean matches(Object list) {
            return ((List<?>) list).size() == 2;
        }

    }
}
