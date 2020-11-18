package yui.hesstina.homework.w1.q1;

import yui.hesstina.homework.w1.q1.aop.ProxyAop;
import yui.hesstina.homework.w1.q1.service.ITestService;
import yui.hesstina.homework.w1.q1.service.impl.TestCglibServiceImpl;
import yui.hesstina.homework.w1.q1.service.impl.TestJdkServiceImpl;

/**
 * @author YuI
 */
public class Test {

    public static void main(String[] args) throws Exception {
        ITestService impl1 = ProxyAop.proxy(new TestJdkServiceImpl());
        impl1.test1();
        impl1.test2();

        System.out.println(" ---------------------------------- ");

        TestCglibServiceImpl impl2 = ProxyAop.proxy(new TestCglibServiceImpl());
        impl2.test1();
        impl2.test2();
    }

}
