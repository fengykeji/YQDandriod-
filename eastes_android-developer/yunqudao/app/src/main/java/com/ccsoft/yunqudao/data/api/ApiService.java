package com.ccsoft.yunqudao.data.api;

import com.ccsoft.yunqudao.data.base.BaseData;
import com.ccsoft.yunqudao.data.model.response.BrokerWaitConfirmData;
import com.ccsoft.yunqudao.data.model.response.BrrokerDisabledData;
import com.ccsoft.yunqudao.data.model.response.BrrokerValueData;
import com.ccsoft.yunqudao.data.model.response.ClientFollowListData;
import com.ccsoft.yunqudao.data.model.response.ClientListData;
import com.ccsoft.yunqudao.data.model.response.ClientPrivateData;
import com.ccsoft.yunqudao.data.model.response.ConfirmDetailData;
import com.ccsoft.yunqudao.data.model.response.LoginData;
import com.ccsoft.yunqudao.data.model.response.RecordAffirmBaseData;
import com.ccsoft.yunqudao.data.model.response.ValueDetailData;
import com.ccsoft.yunqudao.data.model.response.RecordValidData;
import com.ccsoft.yunqudao.data.model.response.WorkReportDisableData;
import com.ccsoft.yunqudao.data.model.viewmodel.WorkModel;
import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Desc:retrofit2基础service
 * Author: WangGuoku.
 * Date:2018/3/13 14:08
 */
public interface ApiService {
    /**
     * 注册
     *
     * @param params
     *
     * @return
     */
    @POST("agent/user/register")
    @FormUrlEncoded
    Observable<ResultData<BaseData>> regist(@FieldMap Map<String, String> params);

    /**
     * 登录
     *
     * @param params
     *
     * @return
     */
    @POST("agent/user/login")
    @FormUrlEncoded
    Observable<ResultData<LoginData>> login(@FieldMap Map<String, String> params);

    /**
     * 获取验证码
     *
     * @param params
     *
     * @return
     */
    @GET("agent/user/captcha")
    Observable<ResultData<BaseData>> getCaptcha(@FieldMap Map<String, String> params);

    /**
     * 获取客源信息列表
     *
     * @param headers
     *
     * @return
     */
    @GET("agent/client/list")
    Observable<ResultData<ClientListData>> getClientList(@HeaderMap Map<String, String> headers);

    /**
     * 获取客户信息列表
     *
     * @param headers
     *
     * @return
     */
    @GET("agent/client/getInfo")
    Observable<ResultData<ClientPrivateData>> getClientInfo(@HeaderMap Map<String, String> headers, @Query("client_id") String id);

    /**
     * 获取客户跟进记录列表
     *
     * @param headers
     *
     * @return
     */
    @GET("agent/client/getFollowList")
    Observable<ResultData<ClientFollowListData>> getClientFollow(@HeaderMap Map<String, String> headers, @Query("client_id") String id);

    /**
     * 获取工作信息
     *
     * @param headers
     *
     * @return
     */
    @GET("agent/work/broker/count")
    Observable<ResultData<WorkModel>> getWrokInfo(@HeaderMap Map<String, String> headers);

    /**
     * 获取城市列表
     */
    @GET("user/project/openCity")
    Observable<ResultData<BaseData>> getOpenCity(@HeaderMap Map<String, String> headers);

    /**
     * 推荐-确认中列表
     */
    @GET("agent/work/broker/waitConfirm")
    Observable<ResultData<BrokerWaitConfirmData>> getBrokerWait(@HeaderMap Map<String, String> headers, @Query("page") String page);

    /**
     * 推荐-有效列表
     *
     * @param headers
     * @param page
     *
     * @return
     */
    @GET("agent/work/broker/value")
    Observable<ResultData<BrrokerValueData>> getBrokerValue(@HeaderMap Map<String, String> headers, @Query("page") String page);

    /**
     * 推荐-无效列表
     *
     * @param headers
     * @param page
     *
     * @return
     */
    @GET("agent/work/broker/disabled")
    Observable<ResultData<BrrokerDisabledData>> getBrokerDisabled(@HeaderMap Map<String, String> headers, @Query("page") String page);


    @GET("agent/work/broker/waitConfirmDetail")
    Observable<ResultData<ConfirmDetailData>> getwaitConfirmDetail(@HeaderMap Map<String, String> headers, @Query("client_id") String client_id);

    @GET("agent/work/broker/valueDetail")
    Observable<ResultData<ValueDetailData>> getValueDetail(@HeaderMap Map<String, String> headers, @Query("client_id") String client_id);

    /**
     * 获取报备确认中
     */
    @GET("agent/work/project/waitConfirm")
    Observable<ResultData<RecordAffirmBaseData>> getRecordAffirm(@HeaderMap Map<String, String> headers,@Query("page")String page);


    /**
     * 获取报备有效中
     */
    @GET("agent/work/project/value")
    Observable<ResultData<RecordValidData>> getRecordValid(@HeaderMap Map<String, String> headers,@Query("page")String page);


    /**
     * 获取报备无效中
     */
    @GET("agent/work/project/disabled")
    Observable<ResultData<WorkReportDisableData>> getRecordDisabled(@HeaderMap Map<String, String> headers,@Query("page")String page);

    /**
     * 有效报备详情
     * @param headers
     * @param client_id
     * @return
     */
    @GET("agent/work/project/valueDetail")
    Observable<ResultData<ValueDetailData>> getDetail(@HeaderMap Map<String, String> headers, @Query("client_id") String client_id);
}
