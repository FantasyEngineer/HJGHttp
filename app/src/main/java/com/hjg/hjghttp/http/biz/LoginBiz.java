package com.hjg.hjghttp.http.biz;

import android.content.Context;

import com.hjg.hjghttp.http.service.LoginService;
import com.okhttplib.BaseBiz;
import com.okhttplib.HttpBase;

import io.reactivex.Observable;

public class LoginBiz extends BaseBiz {

    public LoginBiz(Context context) {
        super(context);
    }

    public Observable<String> wealther() {
        return getRxGsonApi(LoginService.class).weather().compose(HttpBase.IO_UI);
    }


}
