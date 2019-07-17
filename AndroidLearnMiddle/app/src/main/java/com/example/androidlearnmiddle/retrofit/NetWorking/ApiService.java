package com.example.androidlearnmiddle.retrofit.NetWorking;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    /**************用户模块******************/

    //password
    //phoneNumber
    @POST("/rrd/user/login")
    Observable<ApiResponse> accountLogin(@Body JSONObject jsonObject);

    //password
    //secondPassword
    //phoneNumber
    //verificationCode
    @PUT("/rrd/user/login/forget/password")
    Observable<ApiResponse> forgetPassword(@Body JSONObject jsonObject);

    //phoneNumber
    //verifyCode
    @POST("/rrd/user/login/verifyCode")
    Observable<ApiResponse> mobileLogin(@Body JSONObject jsonObject);

    //unionId
    //nickname
    //headPortrait
    @POST("/rrd/user/login/we")
    Observable<ApiResponse> wechatLogin(@Body JSONObject jsonObject);

    @GET("/rrd/user/login/WeIsFirst")
    Observable<ApiResponse> wechatIsExist(@Query("unionId") String unionId);

    @POST("/rrd/user/register/weRegister")
    Observable<ApiResponse> wechatRegister(@Body JSONObject jsonObject);

    //inviteCode
    //password
    //phoneNumber
    //verifyCode
    @POST("/rrd/user/register")
    Observable<ApiResponse> register(@Body JSONObject jsonObject);

    @GET("/rrd/user/register/getSMSVerifyCode")
    Observable<ApiResponse> getVerifyCode(@Query("phoneNumber") String phoneNumber);

    @GET("/rrd/user/register/invite")
    Observable<ApiResponse> checkInviteCode(@Query("inviteOrTelNum") String inviteOrTelNum);

    @GET("/rrd/user/register/registered")
    Observable<ApiResponse> hasRegistered(@Query("phoneNumber") String phoneNumber);

    //id
    //password
    //phoneNumber
    //unionId
    //verifyCode
    @PUT("/rrd/user/bindPhone")
    Observable<ApiResponse> bindMobile(@Body JSONObject jsonObject);

    //name
    @PUT("/rrd/user/nickname")
    Observable<ApiResponse> updateNickname(@Body JSONObject jsonObject);

    //oldPassword
    //newPassword1
    //newPassword2
    @PUT("/rrd/user/password")
    Observable<ApiResponse> updatePassword(@Body JSONObject jsonObject);

    //phoneNumber
    //verificationCode
    @PUT("/rrd/user/phoneNumber")
    Observable<ApiResponse> updateMobile(@Body JSONObject jsonObject);

    @GET("/rrd/user/SMSVerify")
    Observable<ApiResponse> getVerifyCode();

    /**************订单模块******************/

    //  "area": "浦东新区",
    //  "areaId": 3,
    //  "carAge": 3,
    //  "carBrand": "保时捷",
    //  "carBrandId": 1,
    //  "carMileage": 20.2,
    //  "carModel": 922,
    //  "carModelId": 3,
    //  "carSeries": 911,
    //  "carSeriesId": 2,
    //  "carYear": 2016,
    //  "city": "上海市",
    //  "cityId": 2,
    //  "customerIdCardNumber": 123456789987654320,
    //  "customerName": "张飞",
    //  "customerPhoneNumber": 18866669999,
    //  "loanAmount": 50000,
    //  "loanTerm": 24,
    //  "productId": 1,
    //  "province": "上海市",
    //  "provinceId": 1
    @POST("/rrd/order/submit")
    Observable<ApiResponse> submitOrder(@Body JSONObject jsonObject);

    @GET("/rrd/product")
    Observable<ApiResponse> getProducts();

    @GET("/rrd/loan/term")
    Observable<ApiResponse> getTerms();

    @GET("/rrd/car/brand")
    Observable<ApiResponse> getCarBrands(@Query("ceInitial") String firstLetter);

    @GET("/rrd/car/series")
    Observable<ApiResponse> getCarSerieses(@Query("brandId") String brandId);

    @GET("/rrd/order/level")
    Observable<ApiResponse> queryOrder(
            @Query("agentUserName") String agentUserName,
            @Query("customerName") String customerName,
            @Query("startTime") String startTime,
            @Query("endTime") String endTime,
            @Query("levels") String levels,
            @Query("productIds") String productIds,
            @Query("serialNumber") String serialNumber,
            @Query("statuses") String statuses,
            @Query("pageNum") String pageNum,
            @Query("pageSize") String pageSize);

    @GET("/rrd/user/SMSVerify")
    Observable<ApiResponse> sendVerifyCode();

    @GET("/rrd/bank/card")
    Observable<ApiResponse> getBankCardList();

    @POST("/rrd/bank/card")
    Observable<ApiResponse> addBankCard(@Body JSONObject jsonObject);

    @DELETE("/rrd/bank/card/{id}")
    Observable<ApiResponse> delBankCard(@Path("id") long id);

    @POST("/rrd/user/team/join")
    Observable<ApiResponse> joinTeam(@Body JSONObject json);

    @GET("/rrd/user/team")
    Observable<ApiResponse> getTeamMembers();

    @GET("/rrd/msg")
    Observable<ApiResponse> getMessages(
            @Query("isRead") int isRead,
            @Query("pageNum") int pageNum,
            @Query("pageSize") int pageSize);

    @GET("/rrd/msg/newMsgCount")
    Observable<ApiResponse> getMessageUnreadCount();

    @PUT("/rrd/msg/read")
    Observable<ApiResponse> readMessage(@Body JSONObject jsonObject);

    @Multipart
    @POST("/rrd/user/head")
    Observable<ApiResponse> uploadAvatar(@Part MultipartBody.Part file);

}
