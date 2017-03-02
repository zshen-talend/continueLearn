package mutilThread.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIdGenerator {
    private final AtomicInteger counter = new AtomicInteger(0);
    public int getNext() {
        return counter.getAndIncrement();
    }
   
    public static void main(String[] args) {
        AtomicIdGenerator generator = new AtomicIdGenerator();
        System.out.println(generator.getNext());
    }
}
