package yui.hesstina.homework;

import java.util.concurrent.RecursiveTask;

/**
 * RecursiveTask
 **/
public class Mode14 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法

        RecursiveTask<Integer> recursiveTask = new RecursiveTask<Integer>() {
            @Override
            protected Integer compute() {
                return CommonMethod.sum(); //这是得到的返回值
            }
        };
        recursiveTask.fork();

        int result = recursiveTask.join();

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为：" + result);

        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

        // 然后退出main线程
    }

}
