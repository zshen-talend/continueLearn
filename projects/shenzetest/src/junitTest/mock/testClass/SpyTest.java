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
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

/**
 * DOC zshen  class global comment. Detailled comment
 */
public class SpyTest {

    @Test
    public void test1() {
        List<String> list = new LinkedList<String>();
        List<String> spy = Mockito.spy(list);

        // optionally, you can stub out some methods:
        Mockito.stub(spy.size()).toReturn(100);

        // using the spy calls real methods
        spy.add("one");
        spy.add("two");

        // prints "one" - the first element of a list
        System.out.println(spy.get(0));

        // size() method was stubbed - 100 is printed
        System.out.println(spy.size());

        // optionally, you can verify
        Mockito.verify(spy).add("one");
        Mockito.verify(spy).add("two");
        Mockito.verify(spy).get(0);
        Mockito.verify(spy).size();
        Mockito.verifyZeroInteractions(spy);

    }

    @Test
    public void test2() {
        List<String> list = new LinkedList<String>();

        List<String> spy = Mockito.spy(list);
        // spy.add("111111111111");
        // Impossible: real method is called so spy.get(0) throws IndexOutOfBoundsException (the list is yet empty)
        // Mockito.stub(spy.get(0)).toReturn("foo");

        // You have to use doReturn() for stubbing
        Mockito.doReturn("foo").when(spy).get(0);
        System.out.println(spy.get(0));

    }
}
