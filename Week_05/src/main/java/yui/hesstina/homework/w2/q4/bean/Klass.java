package yui.hesstina.homework.w2.q4.bean;

import lombok.Data;

import java.util.List;

/**
 * @package: yui.hesstina.homework.w2.q4.bean
 * @class: Klass
 * @description:
 * @author: YuI
 * @create: 2020/11/22 14:56 
 * @since:
 **/
@Data
public class Klass {

    List<Student> students;

    public void dong() {
        System.out.println(this.getStudents());
    }

}
