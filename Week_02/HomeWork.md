# 作业

## Week02 作业题目（周四）

### 4. 根据上述自己对于 1 和 2 的演示，写一段对于不同 GC 的总结，提交到 Github。

使用压测工具（wrk 或 sb），演练 gateway-server-0.0.1-SNAPSHOT.jar 示例。

```shell
sb -u http://localhost:8088/api/hello -c 20 -N 60
```

|                 | 256M   | 512M   | 1G     | 2G     |
| --------------- | ------ | ------ | ------ | ------ |
| SerialGC        | 3734.9 | 3776.3 | 4277.5 | 4130.5 |
| ParallelGC      | 4310.3 | 4392.4 | 4329.4 | 4219.8 |
| ConcMarkSweepGC | 4006.9 | 3949.9 | 3569   | 4011.4 |
| G1              | 3463.3 | 3103.2 | 4170.3 | 4227.4 |

并行GC相对稳定很多，而且综合效率最高。因为没用做多次测试取平均 RPS，所以结论比较主观。



## Week02 作业题目（周六）

### 2. 写一段代码，使用 HttpClient 或 OkHttp 访问 http://localhost:8801 ，代码提交到 Github。
HttpClient 例子(src/main/java/yui/hesstina/homework/h_2_2/HttpClientDemo.java)
```java
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
```

OkHttp 例子(src/main/java/yui/hesstina/homework/h_2_2/OkHttpDemo.java)

```java
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
```

