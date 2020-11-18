package yui.hesstina.homework.w1.q1.aspect;

import yui.hesstina.homework.w1.q1.aop.IAspect;

import java.lang.reflect.Method;

/**
 * @author YuI
 */
public class TestAspect implements IAspect {

    @Override
    public boolean before(Object target, Method method, Object[] args) {
        System.out.println("方法调用前, 切面的类: " + target.getClass().getName() + "、切面的方法: " + method.getName());
        return true;
    }

    @Override
    public boolean after(Object target, Method method, Object[] args, Object result) {
        System.out.println("方法调用后, 切面的类: " + target.getClass().getName() + "、切面的方法: " + method.getName());
        return true;
    }

}
