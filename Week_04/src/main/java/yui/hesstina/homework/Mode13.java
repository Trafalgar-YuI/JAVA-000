package yui.hesstina.homework;

import java.util.concurrent.Exchanger;

/**
 * Exchanger
 **/
public class Mode13 {

    private static Exchanger<Integer> EXCHANGER = new Exchanger<>();

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法

        Thread thread = new Thread(() -> {
            try {
                EXCHANGER.exchange(CommonMethod.sum()); //这是得到的返回值
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();

        int result = 0;
        result = EXCHANGER.exchange(result);

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为：" + result);

        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

        // 然后退出main线程
    }

}
