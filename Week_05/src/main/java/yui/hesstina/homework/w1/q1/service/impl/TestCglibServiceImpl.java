package yui.hesstina.homework.w1.q1.service.impl;

import yui.hesstina.homework.w1.q1.annotation.Aspect;
import yui.hesstina.homework.w1.q1.enums.ProxyModel;
import yui.hesstina.homework.w1.q1.service.ITestService;

@Aspect(aspectPath = "yui.hesstina.homework.w1.q1.aspect.TestAspect", model = ProxyModel.CGLIB)
public class TestCglibServiceImpl implements ITestService {

    @Override
    public void test1() {
        System.out.println("这是一个 CGLIB 测试方法 test1");
    }

    @Override
    public void test2() {
        System.out.println("这是一个 CGLIB 测试方法 test2");
    }
}
