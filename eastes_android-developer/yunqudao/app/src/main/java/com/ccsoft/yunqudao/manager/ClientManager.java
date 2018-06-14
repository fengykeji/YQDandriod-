package com.ccsoft.yunqudao.manager;

import com.ccsoft.yunqudao.data.base.BaseData;
import com.ccsoft.yunqudao.data.model.response.BrokerWaitConfirmData;
import com.ccsoft.yunqudao.data.model.response.BrrokerDisabledData;
import com.ccsoft.yunqudao.data.model.response.BrrokerValueData;
import com.ccsoft.yunqudao.data.model.response.ClientFollowListData;
import com.ccsoft.yunqudao.data.model.response.ClientPrivateData;
import com.ccsoft.yunqudao.data.model.response.ConfirmDetailData;
import com.ccsoft.yunqudao.data.model.response.LoginData;
import com.ccsoft.yunqudao.data.model.response.RecordAffirmBaseData;
import com.ccsoft.yunqudao.data.model.response.RecordValidData;
import com.ccsoft.yunqudao.data.model.response.ValueDetailData;
import com.ccsoft.yunqudao.data.model.response.WorkReportDisableData;
import com.ccsoft.yunqudao.data.model.viewmodel.ClientFollowViewModel;
import com.ccsoft.yunqudao.data.model.viewmodel.CustomerListViewModel;
import com.ccsoft.yunqudao.data.model.viewmodel.WorkModel;
import com.ccsoft.yunqudao.data.repository.ClientRepository;

import java.util.List;

import rx.Observable;
import rx.functions.Func1;

/**
 * @author: Pein
 * @data: 2018/5/25 0025
 */

public class ClientManager {
    private static volatile ClientManager mInstance;

    public ClientManager() {
    }

    public static ClientManager getInstance() {
        if (null == mInstance) {
            synchronized (ClientManager.class) {
                if (null == mInstance) {
                    mInstance = new ClientManager();
                }
            }
        }
        return mInstance;
    }

    /**
     * 注册
     *
     * @param account
     * @param password
     * @param password_verify
     * @param captcha
     * @return
     */
    public Observable<BaseData> regist(String account, String password, String password_verify, String captcha) {
        return ClientRepository.getInstance().regist(account, password, password_verify, captcha);
    }

    /**
     * 获取验证码
     *
     * @param tel
     * @return
     */
    public Observable<BaseData> getCaptcha(String tel) {
        return ClientRepository.getInstance().getCaptcha(tel);
    }

    /**
     * 登录
     *
     * @param account
     * @param password
     * @return
     */
    public Observable<LoginData> login(String account, String password) {
        return ClientRepository.getInstance().login(account, password);
    }

    /**
     * 获取客源信息列表
     *
     * @return
     */
    public Observable<List<CustomerListViewModel>> getClientList() {
        return ClientRepository.getInstance().getClientList();
    }

    /**
     * 获取客户个人信息
     *
     * @param client_id
     * @return
     */
    public Observable<ClientPrivateData> getClientInfo(int client_id) {
        return ClientRepository.getInstance().getClientInfo(client_id);
    }

    /**
     * 获取客户跟进记录
     *
     * @param client_id
     * @return
     */
    public Observable<List<ClientFollowViewModel>> getClientFollow(int client_id) {
        return ClientRepository.getInstance().getClientFollowListData(client_id);
    }

    /**
     * 获取客户跟进记录
     *
     * @param
     * @return
     */
    public Observable<WorkModel> getWorkInfo() {
        return ClientRepository.getInstance().getWrokInfo();
    }

    /**
     * 推荐-确认中列表
     *
     * @return
     */
    public Observable<BrokerWaitConfirmData> getBrokerWait() {
        return ClientRepository.getInstance().getBrokerWait();
    }

    /**
     * 推荐-确认中列表
     *
     * @return
     */
    public Observable<BrrokerValueData> getBrokerValue() {
        return ClientRepository.getInstance().getBrokerValue();
    }

    /**
     * 推荐-确认中列表
     *
     * @return
     */
    public Observable<BrrokerDisabledData> getBrokerDisabled() {
        return ClientRepository.getInstance().getBrokerDisabled();
    }

    public Observable<ConfirmDetailData> getwaitConfirmDetail(int id) {
        return ClientRepository.getInstance().getwaitConfirmDetail(id);
    }

    public Observable<ValueDetailData> getValueDetail(int id) {
        return ClientRepository.getInstance().getValueDetail(id);
    }

    /**
     * 获取报备确认中
     *
     * @param
     * @return
     */
    public Observable<RecordAffirmBaseData> getRecordAffirm() {
        return ClientRepository.getInstance().getRecordAffirm();
    }

    /**
     * 获取报备有效信息
     *
     * @param
     * @return
     */
    public Observable<RecordValidData> getRecordValid() {
        return ClientRepository.getInstance().getRecordValid();
    }

    /**
     * 获取报备无效信息
     *
     * @param
     * @return
     */
    public Observable<WorkReportDisableData> getRecordDisabled() {
        return ClientRepository.getInstance().getRecordDisabled();
    }

    public Observable<ValueDetailData> getDetail(int id) {
        return ClientRepository.getInstance().getDetail(id);
    }
}