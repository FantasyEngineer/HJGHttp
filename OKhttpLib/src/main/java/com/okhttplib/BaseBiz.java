package com.okhttplib;

import android.content.Context;

import com.okhttplib.persistentcookiejar.PersistentCookieJar;

/**
 *
 */
public abstract class BaseBiz {
    protected Context mContext;
    protected HttpRequester requester;

    public BaseBiz(Context context) {
        mContext = context;
        requester = HttpRequester.get();
    }

    /**
     * 以Gson的解析方式，通过Observable返回
     *
     * @param tClass
     * @param <T>
     * @return
     */
    public <T> T getRxGsonApi(Class<T> tClass) {
        return requester.rxGson().create(tClass);
    }

    /**
     * 以Gson的解析方式，通过对象返回
     *
     * @param tClass
     * @param <T>
     * @return
     */
    public <T> T getGsonApi(Class<T> tClass) {
        return requester.gsonRetrofit().create(tClass);
    }

    /**
     * 以UTF-8的Text方式返回字符串
     *
     * @param tClass
     * @param <T>
     * @return
     */
    public <T> T getTextApi(Class<T> tClass) {
        return requester.textRetrofit().create(tClass);
    }

    /**
     * 以UTF-8的Text方式返回Observable<String>
     *
     * @param tClass
     * @param <T>
     * @return
     */
    public <T> T getRxTextApi(Class<T> tClass) {
        return requester.rxTextRetrofit().create(tClass);
    }

    /**
     * 以最原始的方式返回Observable<Response<ResponseBody>>
     *
     * @param tClass
     * @param <T>
     * @return
     */
    public <T> T getApi(Class<T> tClass) {
        return requester.retrofit().create(tClass);
    }

    public static String getFullUrl(String url) {
        if (url == null) {
            return null;
        } else if (url.startsWith("http") || url.startsWith("file://")) {
            return url;
        } else if (url.startsWith("www")) {
            return "http://" + url;
        } else if (url.startsWith("/")) {
            return HJGHttp.url + url.substring(1, url.length());
        } else {
            return HJGHttp.url + url;
        }
    }
}