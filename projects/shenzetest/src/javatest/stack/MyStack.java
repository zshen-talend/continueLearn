package javatest.stack;

import java.util.LinkedList;

public class MyStack {

    private LinkedList ll = new LinkedList();

    public void push(Object o) {
        ll.addFirst(o);
    }

    public Object pop() {
        return ll.removeFirst();
    }

    public Object peek() {
        return ll.getFirst();
    }

    public boolean empty() {
        return ll.isEmpty();
    }

    public static void main(String[] args) {
        MyStack ms = new MyStack();
        ms.push("zhangsan");
        ms.push("lisi");
        ms.push("wangwu");

        System.out.println(ms.pop());
        System.out.println(ms.peek());
        System.out.println(ms.pop());
        System.out.println(ms.empty());
    }
}