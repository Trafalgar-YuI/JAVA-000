package yui.hesstina.homework;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Future
 **/
public class Mode03 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法

        ExecutorService executor = Executors.newCachedThreadPool();
        //这是得到的返回值
        Future<Integer> future = executor.submit(CommonMethod::sum);

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为：" + future.get());

        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

        // 然后退出main线程
    }

}
