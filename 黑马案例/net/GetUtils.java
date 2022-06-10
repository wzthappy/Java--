package Java.综合案例.黑马案例.net;

public class GetUtils {
    //无参方法
//    public static void get(String url,SuccessListener sListener,FailListener fListener) {
//
//    }

    //有参方法
//    public static void getWithParams(String url, Map<String,Object> params,SuccessListener sListener,FailListener fListener) {
//        CloseableHttpClient httpClient = HttpClientBuilder.create().setDefaultCookieStore(CookiesHolder.getCookieStore()).build();
//        CloseableHttpResponse response = null;
//        try {
//            //创建Get请求
//            url = joinParam(url,params);
//            HttpGet httpGet = new HttpGet(url);
//            RequestConfig requestConfig = RequestConfig.custom()
//                    .setSocketTimeout(3000)   //服务器响应时时间
//                    .setConnectTimeout(3000)   //连接服务器超时时间
//                    .build();
//            httpGet.setConfig(requestConfig);
//            //由客户端执行(发送)Get请求
//            response = httpClient.execute(httpGet);
//            //从响应模型中获取响应实体
//            HttpEntity responseEntity = response.getEntity();
//            if (responseEntity != null) {
//                sListener.success(EntityUtils.toString(responseEntity));
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            fListener.fail();
//        }  finally {
//            try {
//                //释放资源
//                if (httpClient != null) {
//                    httpClient.close();
//                }
//                if (response != null) {
//                    response.close();
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
