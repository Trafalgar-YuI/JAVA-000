package yui.hesstina.homework.h_2_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * @program: geektime-java-traning-camp-000
 * @package: yui.hesstina.homework.h_2_2
 * @description: 使用 HttpClient 的方式连接
 * @author: YuI
 * @create: 2020/10/28 0:26
 **/
public class HttpClientDemo {

    public static void main(String[] args) {
        HttpURLConnection connection = null;
        InputStream is = null;
        BufferedReader br = null;

        try {
            URL url = new URL("http://localhost:8801/");
            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setConnectTimeout(15000);
            connection.setReadTimeout(60000);
            connection.connect();

            StringBuilder sb = new StringBuilder();
            if (connection.getResponseCode() == 200) {
                is = connection.getInputStream();
                br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));

                String temp = null;
                while ((temp = br.readLine()) != null) {
                    sb.append(temp);
                    sb.append("\n");
                }
            }

            String result = sb.toString();
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
            try {
                if (is != null) {
                    is.close();
                }
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
