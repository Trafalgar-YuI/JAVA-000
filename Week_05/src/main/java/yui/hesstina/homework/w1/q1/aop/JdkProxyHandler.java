package yui.hesstina.homework.w1.q1.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author YuI
 */
public class JdkProxyHandler implements InvocationHandler {

    private final Object target;
    private final IAspect aspect;

    public JdkProxyHandler(Object target, IAspect aspect) {
        this.target = target;
        this.aspect = aspect;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        final Object target = this.target;
        final IAspect aspect = this.aspect;

        Object result = null;

        // 开始前回调
        if (aspect.before(target, method, args)) {
            method.setAccessible(true);
            try {
                result = method.invoke(Modifier.isStatic(method.getModifiers()) ? null : target, args);
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        // 结束执行回调
        if (aspect.after(target, method, args, result)) {
            return result;
        }

        return null;
    }

}
