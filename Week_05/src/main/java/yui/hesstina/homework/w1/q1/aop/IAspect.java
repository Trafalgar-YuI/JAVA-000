package yui.hesstina.homework.w1.q1.aop;

import java.lang.reflect.Method;

/**
 * @author YuI
 */
public interface IAspect {

    boolean before(Object target, Method method, Object[] args);

    boolean after(Object target, Method method, Object[] args, Object result);

}
