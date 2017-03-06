package mutilThread.thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.Phaser;

public class MultiThreadingIdGenerator {
	 static ConcurrentSkipListMap<Integer,Integer> asMap =new ConcurrentSkipListMap<Integer,Integer>();
	 private static final Phaser phaser = new Phaser(1);
    public static void main(String[] args) {
        IdGenerator counter = new IdGenerator();//无线程同步的结果
//        IdGenerator counter = new SynchronizedIdGenerator();//线程同步后的结果
        for (int i = 0; i < 100; i++) {
        	phaser.register();
            new IdGeneratorThread(counter).start();
        }
        phaser.arriveAndAwaitAdvance();
        phaser.arriveAndAwaitAdvance();
        phaser.arriveAndDeregister();
        for(Integer value:asMap.keySet()){
        	if(asMap.get(value)>1){
        		System.out.println("key:"+value+"==> value:"+asMap.get(value));
        	}
        }
        
    }

    private static class IdGeneratorThread extends Thread {
        private IdGenerator counter;
        public IdGeneratorThread(IdGenerator counter) {
            this.counter = counter;
        }
        public void run() {
        	phaser.arriveAndAwaitAdvance();
        	try{
        	int next = counter.getNext();
        	Integer index = MultiThreadingIdGenerator.asMap.get(next);
        	if(index==null){
        		index=1;
        	}else{
        		index++;
        	}
        	MultiThreadingIdGenerator.asMap.put(next, index);
//            System.out.println(this.getName() + " => " + next);
        	}finally{
        		phaser.arriveAndDeregister();
        	}
        }
    }
    
    
}
