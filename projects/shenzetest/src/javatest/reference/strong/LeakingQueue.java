package javatest.reference.strong;

import java.util.ArrayList;
import java.util.List;

public class LeakingQueue<T> {

    private List<T> backendList = new ArrayList<T>();

    private int topIndex = 0;

    public void enqueue(T value) {
        backendList.add(value);
    }

    public T dequeue() {
        // 队列内的对象没有被移除，topIndex持续累加导致topIndex之前的对象不能被访问
        T result = backendList.get(topIndex);
        topIndex++;
        return result;
    }

    public static void main(String[] args) {
        LeakingQueue<String> stack = new LeakingQueue<String>();
        stack.enqueue("Hello");
        stack.enqueue("World");
        stack.dequeue();
        stack.enqueue("Goodbye");
        String value = stack.dequeue();
        System.out.println(value);
    }
}
