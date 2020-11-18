package yui.hesstina.homework.w1.q1.annotation;

import yui.hesstina.homework.w1.q1.enums.ProxyModel;

import java.lang.annotation.*;

/**
 * @author YuI
 */
@Documented
@Target(value = ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {

    /**
     * aop 的实现类
     */
    String aspectPath();

    /**
     * 采用 jdk 或者 cglib, 默认 jdk
     */
    ProxyModel model() default ProxyModel.JDK;
}
