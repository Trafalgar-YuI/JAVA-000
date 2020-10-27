package yui.hesstina.homework.h_2_2;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;

import java.io.IOException;

/**
 * @program: geektime-java-traning-camp-000
 * @package: yui.hesstina.homework.h_2_2
 * @description: 使用 OkHttp
 * @author: YuI
 * @create: 2020/10/28 0:59
 **/
public class OkHttpDemo {

    public static void main(String[] args) {
        String url = "http://localhost:8801/";

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).get().build();

        Call call = client.newCall(request);
        try (ResponseBody responseBody = call.execute().body()) {
            if (responseBody != null) {
                System.out.println(responseBody.string());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
