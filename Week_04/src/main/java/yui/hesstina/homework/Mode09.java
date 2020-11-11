package yui.hesstina.homework;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * BlockingQueue
 **/
public class Mode09 {

    private static int RESULT;

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法

        BlockingQueue blockingQueue = new ArrayBlockingQueue(1);

        Thread thread = new Thread(() -> {
            RESULT = CommonMethod.sum(); //这是得到的返回值
            try {
                blockingQueue.put("");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();

        blockingQueue.take();

        int result = RESULT;

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为：" + result);

        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

        // 然后退出main线程
    }

}
