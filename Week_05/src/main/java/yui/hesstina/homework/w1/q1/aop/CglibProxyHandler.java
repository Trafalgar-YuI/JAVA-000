package yui.hesstina.homework.w1.q1.aop;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CglibProxyHandler implements MethodInterceptor {

    private final Object target;
    private final IAspect aspect;

    public CglibProxyHandler(Object target, IAspect aspect) {
        this.target = target;
        this.aspect = aspect;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        final Object target = this.target;
        Object result = null;
        // 开始前回调
        if (aspect.before(target, method, args)) {
            try {
                result = proxy.invoke(target, args);
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
