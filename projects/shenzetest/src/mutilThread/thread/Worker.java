package mutilThread.thread;

public class Worker {
    private volatile boolean done;
    public void setDone(boolean done){
        this.done = done;
    }
    public void work() {
        while (!done) {
            //执行任务
        }
    }
}
