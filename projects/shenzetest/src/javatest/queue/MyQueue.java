// ============================================================================
//
// Copyright (C) 2006-2013 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package javatest.queue;

import java.util.LinkedList;


/**
 * created by zshen on Apr 28, 2013
 * Detailled comment
 *
 */
public class MyQueue {

    private LinkedList ll=new LinkedList();
    public void put(Object o){
     ll.addLast(o);
    }
    //使用removeFirst()方法，返回队列中第一个数据，然后将它从队列中删除
    public Object get(){
     return ll.removeFirst();
    }
    
    public boolean empty(){
     return ll.isEmpty();
    }
    
    
    /**
     * DOC zshen Comment method "main".
     * @param args
     */
    public static void main(String[] args) {
        MyQueue mq=new MyQueue();
        mq.put("zhangsan");
        mq.put("lisi");
        mq.put("wangwu");
        
        System.out.println(mq.get());
        System.out.println(mq.get());
        System.out.println(mq.get());
        System.out.println(mq.empty());
    }

}
