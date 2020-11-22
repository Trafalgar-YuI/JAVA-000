package yui.hesstina.homework.w2.q4.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @package: yui.hesstina.homework.w2.q4.bean
 * @class: Student
 * @description:
 * @author: YuI
 * @create: 2020/11/22 14:52 
 * @since:
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student implements Serializable {

    private int id;
    private String name;

    public void init() {
        System.out.println("hello...........");
    }

    public Student create() {
        return new Student(101, "KK101");
    }

}
