package yui.hesstina.homework.w1.q2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import yui.hesstina.homework.w1.q2.bean.Person;
import yui.hesstina.homework.w1.q2.config.AnnotationConfig;

public class ApplicationByAnnotation {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfig.class);

        Person person = (Person) context.getBean("person2");
        System.out.println(person);
    }

}
