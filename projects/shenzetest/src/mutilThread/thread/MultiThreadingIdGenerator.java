package mutilThread.thread;

import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.Phaser;

public class MultiThreadingIdGenerator {

    static ConcurrentSkipListMap<Integer, Integer> asMap = new ConcurrentSkipListMap<Integer, Integer>();

    private static final Phaser phaser = new Phaser(1);

    public static void main(String[] args) {
        IdGenerator counter = new IdGenerator();// ���߳�ͬ���Ľ��
        // IdGenerator counter = new SynchronizedIdGenerator();// �߳�ͬ����Ľ��
        for (int i = 0; i < 1; i++) {
            phaser.register();
            new IdGeneratorThread(counter).start();
        }
        int result = phaser.arriveAndAwaitAdvance();
        System.out.println("main thread first time arriveAndAwaitAdvance " + result);
        result = phaser.arriveAndAwaitAdvance();
        System.out.println("main thread second time arriveAndAwaitAdvance " + result);
        result = phaser.arriveAndDeregister();
        System.out.println("main thread arriveAndDeregister " + result);
        for (Integer value : asMap.keySet()) {
            if (asMap.get(value) > 1) {
                System.out.println("key:" + value + "==> value:" + asMap.get(value));
            }
        }

    }

    private static class IdGeneratorThread extends Thread {

        private IdGenerator counter;

        public IdGeneratorThread(IdGenerator counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            System.out.println(counter + " => come here and start to wait others");
            int result = phaser.arriveAndAwaitAdvance();
            try {
                this.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("other thread arriveAndAwaitAdvance " + result);
            try {
                int next = counter.getNextV2();
                Integer index = MultiThreadingIdGenerator.asMap.get(next);
                if (index == null) {
                    index = 1;
                } else {
                    index++;
                }
                try {
                    this.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                MultiThreadingIdGenerator.asMap.put(next, index);
                System.out.println(this.getName() + " => " + next);
            } finally {
                result = phaser.arriveAndDeregister();
                System.out.println("other thread arriveAndDeregister " + result);
            }
        }
    }

}
