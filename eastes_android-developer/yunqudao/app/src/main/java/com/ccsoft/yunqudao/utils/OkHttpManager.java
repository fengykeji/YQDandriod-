package com.ccsoft.yunqudao.utils;


import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * www.liankewang.com
 * Created by cdlk04 on 2017/6/6.
 */
public class OkHttpManager {
    private static OkHttpManager mOkHttpManager;
    private OkHttpClient mOkHttpClient;
    private Gson mGson;
    private Handler mHandler;

    public OkHttpManager(){
        mOkHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(100,TimeUnit.SECONDS)
                .writeTimeout(60,TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();
        mGson = new Gson();
        mHandler = new Handler(Looper.getMainLooper());
    }

    public static OkHttpManager getInstance(){
        if (mOkHttpManager == null) {
            synchronized (OkHttpManager.class) {
                if (mOkHttpManager == null) {
                    mOkHttpManager = new OkHttpManager();
                }
            }
        }
        return mOkHttpManager;
    }

    /**
     * 创建Request对象
     * @param baseUrl
     * @param methodType
     * @param params
     * @return
     */
    private Request createRequest(String baseUrl, HttpMethodType methodType, Map<String,String> params){
        Request.Builder builder = new Request.Builder().url(baseUrl);
        if (methodType == HttpMethodType.GET){
            builder.get();
        }else if(methodType == HttpMethodType.POST){
            RequestBody body = createRequestBody(params);
            builder.post(body);
        }
        return builder.build();
    }

    /**
     * 创建一个Json Request
     * @param baseUrl
     * @param json
     * @return
     */
    private Request createJsonRequest(String baseUrl, String json){
        Request.Builder builder = new Request.Builder().url(baseUrl);
        RequestBody body = createJsonRequestBody(json);
        builder.post(body);
        return builder.build();
    }

    /**
     * 创建一个File Request
     * @param url
     * @param file
     * @return
     */
    private Request createFileRequest(String url, File file){
        Request.Builder builder = new Request.Builder().url(url);
        RequestBody body = createFileRequestBody(file);
        builder.post(body);
        return builder.build();
    }

    /**
     * 创建RequestBody
     * @param params
     * @return
     */
    private RequestBody createRequestBody(Map<String,String> params) {
        FormBody.Builder builder = new FormBody.Builder();
        if (params!=null&&!params.isEmpty()){
            System.out.println("---params:"+params.toString());
            for (Map.Entry<String, String> entry:params.entrySet()){
                builder.add(entry.getKey(),entry.getValue());
            }
        }
        return builder.build();
    }

    /**
     * 创建一个JSONBody
     * @param json
     * @return
     */
    private RequestBody createJsonRequestBody(String json){
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"),json);
        if (TextUtils.isEmpty(json)){
            return requestBody;
        }
        return null;
    }

    /**
     * 创建一个FileBody
     * @param file
     * @return
     */
    private RequestBody createFileRequestBody(File file){
        RequestBody requestBody = RequestBody.create(MediaType.parse("image/*; charset=utf-8"),file);
        if (file.isFile()){
            return requestBody;
        }
        return null;
    }

    /**
     * get方法
     * @param baseUrl
     * @param callBack
     */
    public void get(String baseUrl, BaseCallBack callBack){
        Request request = createRequest(baseUrl, HttpMethodType.GET,null);
        request(request,callBack);
    }

    /**
     * post方法
     * @param baseUrl
     * @param params
     * @param callBack
     */
    public void post(String baseUrl,Map<String,String> params, BaseCallBack callBack){
        Request request = createRequest(baseUrl, HttpMethodType.POST,params);
//        System.out.println("Request Header:"+request.headers());
        request(request,callBack);
    }

    /**
     * post string to Server
     * @param url
     * @param json
     * @param callBack
     */
    public  void postJson(String url, String json, BaseCallBack callBack){
        Request request =  createJsonRequest(url,json);
        request(request,callBack);
    }

    /**
     * post File to Server
     * @param url
     * @param file
     * @param callBack
     */
    public void postFile(String url, File file, BaseCallBack callBack){
        Request request = createFileRequest(url,file);
        request(request,callBack) ;
    }

    /**
     * downLoad file
     */
//    public void downLoadFile(String url, final String path, final UpdateManager manager){
//        Request request = createRequest(url,HttpMethodType.GET,null);
//        mOkHttpClient.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                if (response.isSuccessful()){
//                    InputStream inputStream = response.body().byteStream();
//                    long contentLength = response.body().contentLength();
//                    byte[] bytes = new byte[2048];
//                    File file = new File(path,manager.getmHashMap().get("name"));
//                    FileOutputStream fos = new FileOutputStream(file);
//                    int len = 0;
//                    while ((len = inputStream.read(bytes))!=-1){
//                        fos.write(bytes,0,0);
//                    }
//
//                }
//            }
//        });
//    }

    /**
     * Request的执行
     * @param request
     * @param callBack
     */
    public void request(Request request, final BaseCallBack callBack){
        //请求之前
        callBack.onRequestBefore();
        //执行Call
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callBackFailure(call,callBack,e);
            }

            @Override
            public void onResponse(Call call, Response response)  {
                if (response.isSuccessful()){
                    Object result = null;
                    try {
                        result = response.body().string();
                        callBackSuccess(call,response, result,callBack);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else{
                    callBackError(response,callBack,response.code());
                }
            }
        });
    }

    /**
     * callBackSuccess
     * @param call
     * @param response
     * @param obj
     * @param callBack
     */
    private void callBackSuccess(final Call call, final Response response,
                                 final Object obj, final BaseCallBack callBack){
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                try {
                    callBack.onSuccess(call,response,obj);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * callBackFailure
     * @param call
     * @param callBack
     * @param e
     */
    private void callBackFailure(final Call call, final BaseCallBack callBack, final Exception e){
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                callBack.onFailure(call,e);
            }
        });
    }

    /**
     * callBackError
     * @param response
     * @param callBack
     * @param errorCode
     */
    private void callBackError(final Response response, final BaseCallBack callBack, final int errorCode){
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                callBack.onError(response,errorCode);
            }
        });
    }

    /**
     * 提交方式
     */
    enum HttpMethodType {
        GET,
        POST
    }
}

