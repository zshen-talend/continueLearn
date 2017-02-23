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

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import antlr.collections.List;

/**
 * DOC zshen  class global comment. Detailled comment
 */
public class AnswerTest {

    @Test
    public void testAnswer() {
        List mock = Mockito.mock(List.class);
        Mockito.stub(mock.includes(Mockito.anyString())).toAnswer(new Answer() {

            public Object answer(InvocationOnMock invocation) {
                Object[] args = invocation.getArguments();
                Object mock = invocation.getMock();
                return "called with arguments: " + args;
            }
        });

        // Following prints "called with arguments: foo"
        System.out.println(mock.includes("foo"));

    }
}
