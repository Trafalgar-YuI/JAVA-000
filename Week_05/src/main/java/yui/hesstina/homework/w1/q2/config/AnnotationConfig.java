package yui.hesstina.homework.w1.q2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import yui.hesstina.homework.w1.q2.bean.Person;

@Configuration
public class AnnotationConfig {

    @Bean("person2")
    public Person person() {
        Person person = new Person();
        person.setId(2);
        person.setName("YuI");
        return person;
    }

}
