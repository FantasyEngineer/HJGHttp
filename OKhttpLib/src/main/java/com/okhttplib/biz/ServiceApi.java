package com.okhttplib.biz;


import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


/**
 * 范例service
 */
public interface ServiceApi {

    /**
     * 校验
     *
     * @return
     */
    @FormUrlEncoded
    @POST("/bsd/sampleInfo/validateProduct")
    Observable<String> validate(@Field("productName") String productName);
//
//    /**
//     * 获取出样信息
//     *
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("/bsd/sampleInfo/getSampleInfo")
//    Observable<SampleInfo> getSampleInfo(@Field("sampleSerialNumber") String sampleSerialNumber,
//                                         @Field("exchange") String exchange);
//
//    /**
//     * 保存数据
//     *
//     * @return
//     */
//    @POST("/bsd/tvBoot/saveTime")
//    Observable<SaveStatusBean> saveTime(@Body InfoRo infoRo);
//
//
//    /**
//     * 更换门店
//     *
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("/bsd/sampleInfo/exchangeOutlet")
//    Observable<SaveStatusBean> exchangeOutlet(@Field("lastScanTime") String lastScanTime,
//                                              @Field("productName") String productName,
//                                              @Field("sampleSerialNumber") String sampleSerialNumber);
//
//    /**
//     * 生成二维码
//     *
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("/bsd/qr/create")
//    Observable<CreatCodeBean> create(@Field("productName") String productName,
//                                     @Field("sampleSerialNumber") String sampleSerialNumber);
////
//    /**
//     * 注册
//     *
//     * @return
//     */
//    @POST("eSolverOmniChannel/account/register.do")
//    Observable<RegisterResultBean> register(@Body RegisterInputJson json);
//
//
//    /**
//     * opt
//     *
//     * @return
//     */
//    @Headers({"Content-Type: application/json", "Accept: application/json"})//需要添加头
//    @POST("eSolverOmniChannel/account/sendOTP.do")
//    Observable<OptResultBean> opt(@Body OptInputJson json);
//
//    /**
//     * mobile register
//     *
//     * @return
//     */
//    @Headers({"Content-Type: application/json", "Accept: application/json"})//需要添加头
//    @POST("eSolverService/omniservice/quickProductRegister.do")
//    Observable<OptResultBean> quickProductRegister(@Query("access_token") String token,
//                                                   @Body MobileRegisterInputJson json);
//
//
//    @Headers({"Content-Type: application/json", "Accept: application/json"})
//    @POST("eSolverOmniChannel/forgottenpassword/validateQuickPWDOTP.do")
//    Observable<ValiatePwdResultBean> validateQuickPWDOTP(@Body ValiatePwdBean valiatePwdBean);
//
//
//    @Headers({"Content-Type: application/json", "Accept: application/json"})
//    @POST("eSolverOmniChannel/forgottenpassword/updatePassword.do")
//    Observable<ValiatePwdResultBean> updatePassword(@Body UpdatePwdBean updatePwdBean);
}

