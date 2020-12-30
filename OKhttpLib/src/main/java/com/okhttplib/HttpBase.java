package com.okhttplib;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.okhttplib.persistentcookiejar.PersistentCookieJar;
import com.okhttplib.persistentcookiejar.persistence.SharedPrefsCookiePersistor;

import java.util.concurrent.TimeUnit;

import io.reactivex.ObservableTransformer;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class HttpBase {
    public static ObservableTransformer IO_UI = new ClassicIOTransformer();
    public static HttpLoggingInterceptor BODY_LOGGER = new HttpLoggingInterceptor();
    public static HttpLoggingInterceptor BASIC_LOGGER = new HttpLoggingInterceptor();
    private static OkHttpClient client;
    private static OkHttpClient glideClient;
    public static PlainTextConverterFactory TEXT = PlainTextConverterFactory.create();
    public static GsonConverterFactory GSON = GsonConverterFactory.create(DataUtil.gson);
    private final SharedPrefsCookiePersistor spcp;
    //    private final PersistentCookieJar cookieJar;
    public Context context;

    public HttpBase(Context context) {
        this.context = context;
        spcp = new SharedPrefsCookiePersistor(context);
//        cookieJar = new PersistentCookieJar(new SetCookieCache(), spcp);
        initHttp();
    }

    void initHttp() {
        initApiClient();
        initGlideClient();
    }

    void initApiClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(getConnectTimeOutSeconds(), TimeUnit.SECONDS);
        builder.readTimeout(getReadTimeOutSeconds(), TimeUnit.SECONDS);
        builder.writeTimeout(getWriteTimeOutSeconds(), TimeUnit.SECONDS);
        builder.addInterceptor(BODY_LOGGER);
        builder.addInterceptor(BASIC_LOGGER);
//        builder.addInterceptor(new Interceptor() {
//            @Override
//            public Response intercept(Chain chain) throws IOException {
////                i++;
//                Response response = chain.proceed(chain.request());
////                if (i > 2) {
////                    Log.d("HttpBase", "response:" + response);
////                    Log.d("HttpBase", response.body().string());
////                }
//                if (response.header("token") != null) {
//                    //存入token,保存本地
////                    UserManager.getInstance().setToken(response.header("token"));
//                }
//                return response;
//            }
//        });
//        builder.cookieJar(cookieJar);
        HttpsUtils.setUnsafe(builder);
        client = builder.build();
    }

    public static final int GLIDE_TIME_OUT_SECONDS = 10;

    void initGlideClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(GLIDE_TIME_OUT_SECONDS, TimeUnit.SECONDS);
        builder.readTimeout(GLIDE_TIME_OUT_SECONDS, TimeUnit.SECONDS);
        builder.writeTimeout(GLIDE_TIME_OUT_SECONDS, TimeUnit.SECONDS);
        builder.addInterceptor(BASIC_LOGGER);
        HttpsUtils.setUnsafe(builder);
        glideClient = builder.build();
    }

    /**
     * @return 连接超时（ >= 5000ms）
     */
    public abstract int getConnectTimeOutSeconds();

    /**
     * @return 下载超时
     */
    public abstract int getReadTimeOutSeconds();

    /**
     * @return 上传超时
     */
    public abstract int getWriteTimeOutSeconds();

    /**
     * @return 默认的主机地址
     */
    public abstract String getDefaultBaseUrl();

    public static OkHttpClient getClient() {
        return client;
    }

    public static OkHttpClient getGlideClient() {
        return glideClient;
    }

    public PersistentCookieJar getCookieJar() {
        return null;
    }

    public SharedPrefsCookiePersistor getSpcp() {
        return spcp;
    }
}
