package yui.hesstina.course.classloader;

import sun.misc.Launcher;

import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

/**
 * @package: yui.hesstina.course
 * @description: 类加载器
 * @author: YuI
 * @create: 2020/10/18 0:50 
 **/
public class JvmClassLoaderPrintPath {

    public static void main(String[] args) {
        // 启动类加载器
        URL[] urls = Launcher.getBootstrapClassPath().getURLs();

        System.out.println("启动类加载器" + " ClassLoader " + Launcher.getBootstrapClassPath().toString() );
        for (URL url : urls) {
            System.out.println(" ==> " + url.getPath());
        }
        printClassLoader("启动类加载器", URLClassLoader.getSystemClassLoader());

        // 扩展类加载器
        printClassLoader("扩展类加载器", JvmClassLoaderPrintPath.class.getClassLoader().getParent());

        // 应用类加载器
        printClassLoader("应用类加载器", JvmClassLoaderPrintPath.class.getClassLoader());
    }

    private static void printClassLoader(String name, ClassLoader classLoader) {
        if (classLoader != null) {
            System.out.println(name + " ClassLoader " + classLoader.toString());
            printURLForClassLoader(classLoader);
        } else {
            System.out.println(name + " ClassLoader -> null");
        }
    }

    private static void printURLForClassLoader(ClassLoader classLoader) {
        Object ucp = insightField(classLoader, "ucp");
        Object path = insightField(ucp, "path");

        ArrayList ps = (ArrayList) path;
        for (Object p : ps) {
            System.out.println(" ==> " + p.toString());
        }
    }

    private static Object insightField(Object obj, String fieldName) {
        try {
            Field field = null;
            if (obj instanceof URLClassLoader) {
                field = URLClassLoader.class.getDeclaredField(fieldName);
            } else {
                field = obj.getClass().getDeclaredField(fieldName);
            }
            field.setAccessible(true);
            return field.get(obj);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

}
