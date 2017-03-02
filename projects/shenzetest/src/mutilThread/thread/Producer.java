package mutilThread.thread;

public class Producer {
    private final Object lock;
    public Producer(Object lock) {
        this.lock = lock;
    }
    public void produce() {
        synchronized (lock) {
            
        }
    }
}
