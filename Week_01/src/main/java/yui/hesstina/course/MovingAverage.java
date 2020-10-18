package yui.hesstina.course;

/**
 * @package: yui.hesstina.course
 * @description: 移动平均数
 * @author: YuI
 * @create: 2020/10/17 18:18 
 **/
public class MovingAverage {

    private int cout = 0;

    private double sum = 0.0D;

    public void submit(double value) {
        this.cout++;
        this.sum += value;
    }

    public double getAvg() {
        if (0 == this.cout) {
            return sum;
        }

        return this.sum / this.cout;
    }

}
