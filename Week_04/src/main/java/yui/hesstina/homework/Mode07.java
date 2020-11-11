package yui.hesstina.homework;

/**
 * synchronized
 **/
public class Mode07 {

    private static int RESULT;

    private static Object LOCK = new Object();

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法

        Thread thread = new Thread(() -> {
            RESULT = CommonMethod.sum(); //这是得到的返回值
            synchronized (LOCK) {
                LOCK.notify();
            }
        });
        thread.start();

        synchronized (LOCK) {
            LOCK.wait();
        }

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为：" + RESULT);

        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

        // 然后退出main线程
    }

}
