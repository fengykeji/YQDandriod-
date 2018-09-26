package com.ccsoft.yunqudao.utils;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by lxk on 2017/9/14.
 */

public class JsonUtil {

    public static <T> T jsonToEntity(String jso,Class<T> clazz){
        T o = null;
        try {
            Gson gson = new Gson();
            o = gson.fromJson(jso, clazz);

            return o;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            try {
                JSONObject jsonObject = new JSONObject(jso);
                String message = jsonObject.getString("message");

                o = clazz.newInstance();
                Method method = clazz.getMethod("setMessage", String.class);
                method.invoke(o, message);

                Method method1 = clazz.getMethod("setStatus", int.class);
                method1.invoke(o, 0);

            } catch (Exception e1) {
                // TODO Auto-generated catch block

                try {
                    o = clazz.newInstance();
                    Method method = null;
                    method = clazz.getMethod("setMessage", String.class);
                    method.invoke(o, "网络错误");
                    Method method1 = clazz.getMethod("setStatus", int.class);
                    method1.invoke(o, 0);

                } catch (InstantiationException e2) {
                    e2.printStackTrace();
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                }catch (NoSuchMethodException e2) {
                    e2.printStackTrace();
                }catch (InvocationTargetException e2) {
                    e2.printStackTrace();
                }


            }
        }

        return o;
    }

}
