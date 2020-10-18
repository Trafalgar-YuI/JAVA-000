package yui.hesstina.course;

/**
 * @package: yui.hesstina.course
 * @description:
 * @author: YuI
 * @create: 2020/10/17 18:20 
 **/
public class LocalVariableTest {

    public static void main(String[] args) {
        MovingAverage ma = new MovingAverage();
        int num1 = 1;
        int num2 = 2;
        ma.submit(num1);
        ma.submit(num2);
        double avg = ma.getAvg();
    }

}
