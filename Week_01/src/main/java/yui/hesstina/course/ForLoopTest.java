package yui.hesstina.course;

/**
 * @package: yui.hesstina.course
 * @description:
 * @author: YuI
 * @create: 2020/10/17 18:31 
 **/
public class ForLoopTest {

    private static int[] numbers ={1,6,8};

    public static void main(String[] args) {
        MovingAverage ma = new MovingAverage();
        for (int number : numbers) {
            ma.submit(number);
        }
        double avg = ma.getAvg();
    }

}
