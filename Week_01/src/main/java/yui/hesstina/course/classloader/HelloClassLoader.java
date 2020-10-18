package yui.hesstina.course.classloader;

import java.io.*;
import java.util.Base64;

/**
 * @package: yui.hesstina.course.classloader
 * @description:
 * @author: YuI
 * @create: 2020/10/18 1:27 
 **/
public class HelloClassLoader extends ClassLoader {

    public static void main(String[] args) {
        try {
            (new HelloClassLoader()).loadClass("yui.hesstina.course.classloader.Hello").newInstance();
            (new HelloClassLoader()).findClass("yui.hesstina.course.classloader.Hello").newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) {

        String helloBase64 = "yv66vgAAADQAHwoABgARCQASABMIABQKABUAFgcAFwcAGAEABjxpbml0PgEAAygpVgEABENvZGUBAA9MaW5lTn" +
                "VtYmVyVGFibGUBABJMb2NhbFZhcmlhYmxlVGFibGUBAAR0aGlzAQAnTHl1aS9oZXNzdGluYS9jb3Vyc2UvY2xhc3Nsb2FkZXIvS" +
                "GVsbG87AQAIPGNsaW5pdD4BAApTb3VyY2VGaWxlAQAKSGVsbG8uamF2YQwABwAIBwAZDAAaABsBABZIZWxsbyBDbGFzcyBJbml0" +
                "aWFsaXplBwAcDAAdAB4BACV5dWkvaGVzc3RpbmEvY291cnNlL2NsYXNzbG9hZGVyL0hlbGxvAQAQamF2YS9sYW5nL09iamVjdAE" +
                "AEGphdmEvbGFuZy9TeXN0ZW0BAANvdXQBABVMamF2YS9pby9QcmludFN0cmVhbTsBABNqYXZhL2lvL1ByaW50U3RyZWFtAQAHcH" +
                "JpbnRsbgEAFShMamF2YS9sYW5nL1N0cmluZzspVgAhAAUABgAAAAAAAgABAAcACAABAAkAAAAvAAEAAQAAAAUqtwABsQAAAAIAC" +
                "gAAAAYAAQAAAAkACwAAAAwAAQAAAAUADAANAAAACAAOAAgAAQAJAAAAJQACAAAAAAAJsgACEgO2AASxAAAAAQAKAAAACgACAAAA" +
                "DAAIAA0AAQAPAAAAAgAQ";

        byte[] bytes = Base64.getDecoder().decode(helloBase64);

        return defineClass(name, bytes, 0, bytes.length);
    }

    private void getBinary() {
        File file = new File("G:\\Program\\Java\\geektime-java-traning-camp-000\\Week_01\\target\\classes\\yui\\hesstina\\course\\classloader\\Hello.class");
        try (InputStream i = new FileInputStream(file)) {
            byte[] b = new byte[i.available()];
            int len = i.read(b);
            String s = Base64.getEncoder().encodeToString(b);
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
