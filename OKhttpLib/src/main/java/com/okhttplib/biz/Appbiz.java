package com.okhttplib.biz;

import android.content.Context;

import com.okhttplib.BaseBiz;
import com.okhttplib.HJGHttp;
import com.okhttplib.HttpBase;

import io.reactivex.Observable;

/**
 * 范例APPbiz
 */
public class Appbiz extends BaseBiz {

    private static Appbiz appbiz;

    private Appbiz(Context context) {
        super(context);
    }

    public static Appbiz getAppbiz() {
        if (appbiz == null) {
            appbiz = new Appbiz(HJGHttp.app);
        }
        return appbiz;
    }


    public Observable<String> validate(String model) {
        return getRxGsonApi(ServiceApi.class).validate(model).compose(HttpBase.IO_UI);
    }

}

