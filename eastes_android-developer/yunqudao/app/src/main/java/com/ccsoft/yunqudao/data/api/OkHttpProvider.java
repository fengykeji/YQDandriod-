package com.ccsoft.yunqudao.data.api;


import com.ccsoft.yunqudao.App;
import com.ccsoft.yunqudao.BuildConfig;
import com.ccsoft.yunqudao.utils.LogUtil;
import com.ccsoft.yunqudao.utils.NetworkUtil;
import java.io.File;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Desc:
 * Author: WangGuoku.
 * Date:2018/3/13 17:04
 */
public class OkHttpProvider {

    private final static long DEFAULT_CONNECT_TIMEOUT = 15;
    private final static long DEFAULT_WRITE_TIMEOUT = 15;
    private final static long DEFAULT_READ_TIMEOUT = 15;


    public static OkHttpClient getOkHttpClient() {

        //定制OkHttp
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        //设置超时时间
        httpClientBuilder.connectTimeout(DEFAULT_CONNECT_TIMEOUT, TimeUnit.SECONDS);
        httpClientBuilder.writeTimeout(DEFAULT_WRITE_TIMEOUT, TimeUnit.SECONDS);
        httpClientBuilder.readTimeout(DEFAULT_READ_TIMEOUT, TimeUnit.SECONDS);
        //设置缓存
        File httpCacheDirectory = new File(App.getContext().getCacheDir(), "spapCache");
        httpClientBuilder.cache(new Cache(httpCacheDirectory, 20 * 1024 * 1024));

        ControlInterceptor controlInterceptor = new ControlInterceptor();
        httpClientBuilder.addInterceptor(controlInterceptor);
        httpClientBuilder.addNetworkInterceptor(controlInterceptor);

        //设置拦截器
        httpClientBuilder.addInterceptor(new HeaderInterceptor());
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                @Override
                public void log(String message) {
                    LogUtil.i("okhttp:" + message);
                }
            });
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            httpClientBuilder.addInterceptor(loggingInterceptor);
        }
        httpClientBuilder.retryOnConnectionFailure(true);
        setSSL(httpClientBuilder);
        return httpClientBuilder.build();
    }

    /**
     * 没有网络的情况下就从缓存中取
     * 有网络的情况则从网络获取
     */
    private static class ControlInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            if (!NetworkUtil.isNetworkConnected(App.getContext())) {
                request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build();
            }
            Response response = chain.proceed(request);
            if (NetworkUtil.isNetworkConnected(App.getContext())) {
                int maxAge = 0;
                response = response.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public, max-age=" + maxAge)
                        .build();
            } else {
                int maxStale = 60 * 60 * 24 * 2;
                response = response.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                        .build();
            }
            return response;
        }
    }

    private static class HeaderInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            try {
                Request originalRequest = chain.request();
                Request.Builder requestBuilder = originalRequest.newBuilder();
                requestBuilder.header("Accept-Charset", "UTF-8");
                requestBuilder.header("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
                requestBuilder.method(originalRequest.method(), originalRequest.body());
                Request request = requestBuilder.build();
                return chain.proceed(request);
            } catch (IOException e) {
                LogUtil.e("===头部拦截器===IOException===" + e.getMessage());
            }
            return null;
        }
    }

    /**
     * 设置忽略ssl证书验证
     */
    private static void setSSL(OkHttpClient.Builder builder) {
        try {
            X509TrustManager xtm = new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] chain, String authType) {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] chain, String authType) {
                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            };

            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new TrustManager[]{xtm}, new SecureRandom());

            HostnameVerifier DO_NOT_VERIFY = new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            };
            builder.sslSocketFactory(sslContext.getSocketFactory(), xtm);
            builder.hostnameVerifier(DO_NOT_VERIFY);
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            LogUtil.e("====设置忽略ssl证书验证=====" + e.getMessage());
        }
    }
}
