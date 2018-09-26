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
import com.ccsoft.yunqudao.data.model.response.RecordValidData;
import com.ccsoft.yunqudao.data.model.response.ValueDetailData;
import com.ccsoft.yunqudao.data.model.response.WorkReportDisableData;
import com.ccsoft.yunqudao.data.model.viewmodel.WorkModel;

import com.ccsoft.yunqudao.utils.SpUtil;
import java.util.HashMap;
import java.util.Map;
import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Desc:
 * Author: WangGuoku.
 * Date:2018/3/13 18:27
 */
public class ApiFactory {
    private ApiService mApiService;

    public ApiFactory() {
        this.mApiService = ApiManager.getInstance().getApiService();
    }

    public ApiFactory(ApiService apiService) {
        this.mApiService = apiService;
    }

    /**
     * 注册
     *
     * @param account
     * @param password
     * @param password_verify
     * @param captcha
     *
     * @return
     */
    public Observable<BaseData> regist(String account, String password, String password_verify, String captcha) {
        Map<String, String> params = new HashMap<>();
        params.put("account", account);
        params.put("password", password);
        params.put("password_verify", password_verify);
        params.put("captcha", captcha);
        return this.mApiService.regist(params).map(new ApiResultFunc<BaseData>()).subscribeOn(Schedulers.io());
    }

    /**
     * 登录
     *
     * @param account
     * @param password
     *
     * @return
     */
    public Observable<LoginData> login(String account, String password) {
        Map<String, String> params = new HashMap<>();
        params.put("account", account);
        params.put("password", password);
        return this.mApiService.login(params).map(new ApiResultFunc<LoginData>()).subscribeOn(Schedulers.io());
    }

    /**
     * 获取验证码
     *
     * @param tel
     *
     * @return
     */
    public Observable<BaseData> getCaptcha(String tel) {
        Map<String, String> params = new HashMap<>();
        params.put("tel", tel);
        return this.mApiService.getCaptcha(params).map(new ApiResultFunc<BaseData>()).subscribeOn(Schedulers.io());
    }

    /**
     * 获取客源信息列表
     *
     * @return
     */
    public Observable<ClientListData> getClientList() {
        Map<String, String> headers = new HashMap<>();
        headers.put("ACCESS-TOKEN", SpUtil.getToken());
        headers.put("ACCESS-ROLE", "agent");
        return this.mApiService.getClientList(headers).map(new ApiResultFunc<ClientListData>()).subscribeOn(Schedulers.io());
    }

    /**
     * 获取客户信息列表
     *
     * @return
     */

    public Observable<ClientPrivateData> getClientInfo(int client_id) {
        Map<String, String> headers = new HashMap<>();
        headers.put("ACCESS-TOKEN", SpUtil.getToken());
        headers.put("ACCESS-ROLE", "agent");
        return this.mApiService.getClientInfo(headers, String.valueOf(client_id)).map(new ApiResultFunc<ClientPrivateData>()).subscribeOn(Schedulers.io());
    }

    /**
     * 获取客户跟进记录列表
     * @param client_id
     * @return
     */

    public Observable<ClientFollowListData> getClientFollow(int client_id) {
        Map<String, String> headers = new HashMap<>();
        headers.put("ACCESS-TOKEN", SpUtil.getToken());
        headers.put("ACCESS-ROLE", "agent");
        return this.mApiService.getClientFollow(headers, String.valueOf(client_id)).map(new ApiResultFunc<ClientFollowListData>()).subscribeOn(Schedulers.io());
    }

    /**
     * 获取工作信息
     * @return
     */
    public Observable<WorkModel> getWrokInfo() {
        Map<String, String> headers = new HashMap<>();
        headers.put("ACCESS-TOKEN", SpUtil.getToken());
        headers.put("ACCESS-ROLE", "agent");
        return this.mApiService.getWrokInfo(headers).map(new ApiResultFunc<WorkModel>()).subscribeOn(Schedulers.io());
    }

    /**
     * 推荐-确认中列表
     *
     * @return
     */
    public Observable<BrokerWaitConfirmData> getBrokerWait() {
        Map<String, String> headers = new HashMap<>();
        headers.put("ACCESS-TOKEN", SpUtil.getToken());
        headers.put("ACCESS-ROLE", "agent");
        return this.mApiService.getBrokerWait(headers, String.valueOf(1)).map(new ApiResultFunc<BrokerWaitConfirmData>()).subscribeOn(Schedulers.io());
    }

    /**
     * 推荐-有效列表
     *
     * @return
     */
    public Observable<BrrokerValueData> getBrokerValue() {
        Map<String, String> headers = new HashMap<>();
        headers.put("ACCESS-TOKEN", SpUtil.getToken());
        headers.put("ACCESS-ROLE", "agent");
        return this.mApiService.getBrokerValue(headers, String.valueOf(1)).map(new ApiResultFunc<BrrokerValueData>()).subscribeOn(Schedulers.io());
    }

    /**
     * 推荐-无效列表
     *
     * @return
     */
    public Observable<BrrokerDisabledData> getBrokerDisabled() {
        Map<String, String> headers = new HashMap<>();
        headers.put("ACCESS-TOKEN", SpUtil.getToken());
        headers.put("ACCESS-ROLE", "agent");
        return this.mApiService.getBrokerDisabled(headers, String.valueOf(1)).map(new ApiResultFunc<BrrokerDisabledData>()).subscribeOn(Schedulers.io());
    }

    public Observable<ConfirmDetailData> getwaitConfirmDetail(int id) {
        Map<String, String> headers = new HashMap<>();
        headers.put("ACCESS-TOKEN", SpUtil.getToken());
        headers.put("ACCESS-ROLE", "agent");
        return this.mApiService.getwaitConfirmDetail(headers, String.valueOf(id)).map(new ApiResultFunc<ConfirmDetailData>()).subscribeOn(Schedulers.io());
    }
    public Observable<ValueDetailData> getValueDetail(int id) {
        Map<String, String> headers = new HashMap<>();
        headers.put("ACCESS-TOKEN", SpUtil.getToken());
        headers.put("ACCESS-ROLE", "agent");
        return this.mApiService.getValueDetail(headers, String.valueOf(id)).map(new ApiResultFunc<ValueDetailData>()).subscribeOn(Schedulers.io());
    }

    /**
     * 获取工作信息
     * @return
     */
    public Observable<RecordAffirmBaseData> getRecordAffirm() {
        Map<String, String> headers = new HashMap<>();
        headers.put("ACCESS-TOKEN", SpUtil.getToken());
        headers.put("ACCESS-ROLE", "agent");
        return this.mApiService.getRecordAffirm(headers,String.valueOf(1)).map(new ApiResultFunc<RecordAffirmBaseData>()).subscribeOn(Schedulers.io());
    }

    /**
     * 获去报备有效信息
     * @return
     */
    public Observable<RecordValidData> getRecordValid() {
        Map<String, String> headers = new HashMap<>();
        headers.put("ACCESS-TOKEN", SpUtil.getToken());
        headers.put("ACCESS-ROLE", "agent");
        return this.mApiService.getRecordValid(headers,String.valueOf(1)).map(new ApiResultFunc<RecordValidData>()).subscribeOn(Schedulers.io());
    }

    /**
     * 获取报备无效信息
     * @return
     */
    public Observable<WorkReportDisableData> getRecordDisabled() {
        Map<String, String> headers = new HashMap<>();
        headers.put("ACCESS-TOKEN", SpUtil.getToken());
        headers.put("ACCESS-ROLE", "agent");
        return this.mApiService.getRecordDisabled(headers,String.valueOf(1)).map(new ApiResultFunc<WorkReportDisableData>()).subscribeOn(Schedulers.io());
    }

    public Observable<ValueDetailData> getDetail(int id) {
        Map<String, String> headers = new HashMap<>();
        headers.put("ACCESS-TOKEN", SpUtil.getToken());
        headers.put("ACCESS-ROLE", "agent");
        return this.mApiService.getDetail(headers, String.valueOf(id)).map(new ApiResultFunc<ValueDetailData>()).subscribeOn(Schedulers.io());
    }

}
