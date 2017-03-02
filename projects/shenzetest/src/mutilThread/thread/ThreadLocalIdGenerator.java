package mutilThread.thread;

public class ThreadLocalIdGenerator {
    private static final ThreadLocal<IdGenerator> idGenerator = new ThreadLocal<IdGenerator>() {
        protected IdGenerator initialValue() {
            return new IdGenerator();
        }
    };
    public static int getNext() {
        return idGenerator.get().getNext();
    }
}
