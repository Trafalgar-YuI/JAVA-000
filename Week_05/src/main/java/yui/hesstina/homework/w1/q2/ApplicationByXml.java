package yui.hesstina.homework.w1.q2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import yui.hesstina.homework.w1.q2.bean.Person;

/**
 * @author YuI
 */
public class ApplicationByXml {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/META-INF/application-xml.xml");

        Person person = (Person) context.getBean("person1");
        System.out.println(person);
    }

}
