package com.hjg.hjghttp.http.service;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface LoginService {

    @GET("https://api.openweathermap.org/data/2.5/weather?q=shenzhen&mode=json&APPID=6c113432fd84a6e28268af291821db16")
    Observable<String> weather();

}


