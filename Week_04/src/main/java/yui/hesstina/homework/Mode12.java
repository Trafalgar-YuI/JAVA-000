package yui.hesstina.homework;

import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Condition
 **/
public class Mode12 {

    private static int RESULT;

    public static Lock LOCK = new ReentrantLock();
    public static Condition CONDITION = LOCK.newCondition();

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法

        Thread thread = new Thread(() -> {
            LOCK.lock();
            try {
                RESULT = CommonMethod.sum(); //这是得到的返回值
                CONDITION.signal();
            } finally {
                LOCK.unlock();
            }

        });
        thread.start();

        LOCK.lock();
        int result = 0;
        try {
            CONDITION.await();
            result = RESULT;
        } finally {
            LOCK.unlock();
        }


        // 确保  拿到result 并输出
        System.out.println("异步计算结果为：" + result);

        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

        // 然后退出main线程
    }

}
