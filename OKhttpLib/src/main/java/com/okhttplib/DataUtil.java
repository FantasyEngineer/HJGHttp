package com.okhttplib;

import android.content.Context;
import android.content.res.AssetManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by zrh on 2017/3/6.
 */
public class DataUtil {
    public static Gson gson = new GsonBuilder().disableHtmlEscaping().create();
    /**
     * 使用单一的Json解析入口可以方便更换解析工具
     *
     * @param json
     * @param tClass
     * @param <T>
     * @return
     */
    public static <T> T fromJson(String json, Class<T> tClass) {
        return gson.fromJson(json, tClass);
    }

    /**
     * 如果解析失败，返回默认的值
     *
     * @param json
     * @param tClass
     * @param <T>
     * @return
     */
    public static <T> T fromJson(String json, Class<T> tClass, T def) {
        try {
            return fromJson(json, tClass);
        } catch (Exception e) {
            e.printStackTrace();
            return def;
        }
    }

    /**
     * @param json
     * @param typeOfT use new TypeToken<ArrayList<T>>() {}.getType()
     * @param <T>
     * @return
     */
    public static <T> ArrayList<T> fromJson(String json, Type typeOfT) {
        return gson.fromJson(json, typeOfT);
    }

    public static String toJson(Serializable obj) {
        return gson.toJson(obj);
    }

    /**
     * 读取本地assets 文件夹中JSON文本
     */
    public static String getJson(Context mContext, String fileName) {
        // TODO Auto-generated method stub
        StringBuilder sb = new StringBuilder();
        AssetManager am = mContext.getAssets();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    am.open(fileName)));
            String next = "";
            while (null != (next = br.readLine())) {
                sb.append(next);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            sb.delete(0, sb.length());
        }
        return sb.toString().trim();
    }
}
