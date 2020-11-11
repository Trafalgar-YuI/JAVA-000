package yui.hesstina.course;

/**
 * @author LiuYi
 * @date 2020-11-10 13:00
 **/
public class DeamoThread {

    public static void main(String[] args) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Thread thread = Thread.currentThread();
                System.out.println("线程名字: " + thread.getName());
            }
        };

        Thread thread = new Thread(task);
        thread.setName("test-thread-1");
        thread.setDaemon(true);
        thread.start();
    }

}
