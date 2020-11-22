package yui.hesstina.homework.w2.q4.bean;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * @package: yui.hesstina.homework.w2.q4.bean
 * @class: School
 * @description:
 * @author: YuI
 * @create: 2020/11/22 14:57 
 * @since:
 **/
public class School implements ISchool {

    @Autowired(required = true) //primary
    Klass class1;

    @Resource(name = "student100")
    Student student100;

    @Override
    public void ding() {
        System.out.println("Class1 have " + this.class1.getStudents().size() + " students and one is " + this.student100);
    }

}
