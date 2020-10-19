package yui.hesstina.homework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URL;

/**
 * @package: yui.hesstina.homework
 * @description:
 * @author: YuI
 * @create: 2020/10/18 4:14 
 **/
public class HelloClassLoader extends ClassLoader {

    public static void main(String[] args) {
        HelloClassLoader helloClassLoader = new HelloClassLoader();

        try {
            // 实例化
            Object hello = helloClassLoader
                    .findClass("Hello")
                    .getConstructor()
                    .newInstance();

            // 获取到方法
            Method method = hello.getClass().getMethod("hello");

            // 方法调用
            method.invoke(hello);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) {
        byte[] bytes = readClassFile("META-INF/" + name + ".xlass");
        byte[] transformBytes = transformBytes(bytes);

        return defineClass(name, transformBytes, 0, transformBytes.length);
    }

    private byte[] readClassFile(String path) {
        URL url = HelloClassLoader.class.getClassLoader().getResource(path);
        if (url == null) {
            throw new NullPointerException("文件不存在");
        }

        File file = new File(url.getPath());
        if (!file.exists()) {
            throw new NullPointerException("文件不存在");
        }

        try (InputStream is = new FileInputStream(file)) {
            byte[] bytes = new byte[is.available()];
            is.read(bytes);

            return bytes;
        } catch (IOException e) {
            throw new NullPointerException("读取失败");
        }

    }

    private byte[] transformBytes(byte[] bytes) {
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (255 - bytes[i]);
        }
        return bytes;
    }
}
