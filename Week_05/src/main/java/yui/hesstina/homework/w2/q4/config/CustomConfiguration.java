package yui.hesstina.homework.w2.q4.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import yui.hesstina.homework.w2.q4.bean.Klass;

/**
 * @package: yui.hesstina.homework.w2.q4.config
 * @class: Configuration
 * @description:
 * @author: YuI
 * @create: 2020/11/22 15:04 
 * @since:
 **/
@Configuration
public class CustomConfiguration {

    @Bean
    public Klass getKlass() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/META-INF/application-xml.xml");
        return context.getBean(Klass.class);
    }

}
