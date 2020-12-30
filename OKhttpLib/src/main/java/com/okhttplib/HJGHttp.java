package com.okhttplib;

import android.app.Application;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * 首次初始化
 */
public class HJGHttp {
    public static String url;
    public static Application app;

    /**
     * 初始化基础地址，以及传入application，以及是否开启调试模式
     *
     * @param baseUrl
     * @param application
     */
    public static void init(String baseUrl, Application application, boolean isDebug) {
        url = baseUrl;
        app = application;
        if (isDebug) {
            HttpBase.BODY_LOGGER.setLevel(HttpLoggingInterceptor.Level.BODY);
            HttpBase.BASIC_LOGGER.setLevel(HttpLoggingInterceptor.Level.BASIC);
        } else {
            HttpBase.BODY_LOGGER.setLevel(HttpLoggingInterceptor.Level.NONE);
            HttpBase.BASIC_LOGGER.setLevel(HttpLoggingInterceptor.Level.NONE);
        }
    }
}
