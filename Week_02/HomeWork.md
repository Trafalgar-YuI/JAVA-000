# 作业

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

