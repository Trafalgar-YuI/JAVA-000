package yui.hesstina.homework.w1.q1.service.impl;

import yui.hesstina.homework.w1.q1.annotation.Aspect;
import yui.hesstina.homework.w1.q1.service.ITestService;

/**
 * @author YuI
 */
@Aspect(aspectPath = "yui.hesstina.homework.w1.q1.aspect.TestAspect")
public class TestJdkServiceImpl implements ITestService {

    @Override
    public void test1() {
        System.out.println("这是一个 JDK 测试方法 test1");
    }

    @Override
    public void test2() {
        System.out.println("这是一个 JDK 测试方法 test2");
    }
}
