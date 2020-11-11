package yui.hesstina.homework;

/**
 * 公共调用的方法
 **/
public final class CommonMethod {

    private CommonMethod() {
        throw new IllegalStateException("Don't instantiation");
    }

    public static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if (a < 2) {
            return 1;
        }
        return fibo(a - 1) + fibo(a - 2);
    }

}
