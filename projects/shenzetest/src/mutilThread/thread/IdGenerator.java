package mutilThread.thread;

public class IdGenerator {
    private int value = 0;
    public int getNext() {
        return value++;
    }
    public int getNextV2() {
    	return value++;
    }
}
