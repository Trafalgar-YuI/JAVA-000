package yui.hesstina.course;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ServerSocket 第一种实现
 *
 * @package: yui.hesstina.course
 * @class: HttpService1
 * @description: ServerSocket 第一种实现
 * @author: YuI
 * @create: 2020/11/24 22:22 
 * @since:
 **/
public class HttpService1 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8801);
        while (true) {
            Socket socket = serverSocket.accept();
            service(socket);
        }
    }

    private static void service(Socket socket) {
        try {
            Thread.sleep(20);

            String body = "Hello, NIO";
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println("HTTP/1.1 200 OK");
            writer.println("Content-Type:text/json;charset=utf-8");
            writer.println("Content-Length:" + body.getBytes().length);
            writer.println();
            writer.write(body);
            writer.close();

            socket.close();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
