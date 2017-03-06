package Java8_new.lambda.runnable;
/**
 * Created by liangyh on 2016-11-27.
 */
public class RunnableTest {

    public static void main(String[] args) {
        //匿名内部类
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello Runnable 1!");
            }
        };

        //Lambda
        Runnable r2 = ()-> System.out.println("hello Runnable 2");

        r1.run();
        r2.run();
    }
}