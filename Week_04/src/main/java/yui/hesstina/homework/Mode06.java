package yui.hesstina.homework;

/**
 * 循环等待
 **/
public class Mode06 {

    private static int RESULT;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法

        Thread thread = new Thread(() -> {
            RESULT = CommonMethod.sum(); //这是得到的返回值
        });
        thread.start();

        int result = 0;

        while (thread.isAlive()) {
            result = RESULT;
        }

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为：" + result);

        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

        // 然后退出main线程
    }

}
