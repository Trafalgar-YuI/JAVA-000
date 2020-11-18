package yui.hesstina.homework.w1.q1.aop;


import net.sf.cglib.proxy.Enhancer;
import yui.hesstina.homework.w1.q1.annotation.Aspect;
import yui.hesstina.homework.w1.q1.enums.ProxyModel;

import java.lang.reflect.Proxy;
import java.util.Objects;

/**
 * @author YuI
 */
public class ProxyAop {

    public static <T> T proxy(T target) throws Exception {
        Aspect aspect = target.getClass().getAnnotation(Aspect.class);

        if (Objects.isNull(aspect)) {
            return null;
        }

        String clazz = aspect.aspectPath();
        IAspect aspectClass = (IAspect) Class.forName(clazz).getConstructor().newInstance();

        ProxyModel model = aspect.model();

        if (ProxyModel.JDK == model) {
            return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                    target.getClass().getInterfaces(),
                    new JdkProxyHandler(target, aspectClass));
        }

        if (ProxyModel.CGLIB == model) {
            final Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(target.getClass());
            enhancer.setCallback(new CglibProxyHandler(target, aspectClass));
            return (T) enhancer.create();
        }

        return null;
    }

}
