package com.hjg.hjghttp.base;

import android.app.Application;

import com.hjg.base.util.Utils;
import com.okhttplib.HJGHttp;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        HJGHttp.init("https://psswaptest.sony.com.cn/", this, true);
        Utils.init(this);
    }
}
