package com.ccsoft.yunqudao.data.repository;

import com.ccsoft.yunqudao.data.api.ApiFactory;
import com.ccsoft.yunqudao.data.base.BaseData;
import com.ccsoft.yunqudao.data.model.mapper.CustomerMapper;
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
import com.ccsoft.yunqudao.data.model.viewmodel.ClientFollowViewModel;
import com.ccsoft.yunqudao.data.model.viewmodel.CustomerListViewModel;
import com.ccsoft.yunqudao.data.model.viewmodel.WorkModel;
import java.util.List;
import rx.Observable;
import rx.functions.Func1;

/**
 * @author: Pein
 * @data: 2018/5/25 0025
 */

public class ClientRepository {
    private static volatile ClientRepository mInstance;

    private final ApiFactory     mApiFactory;
    private final CustomerMapper mMapper;

    private ClientRepository() {
        this.mApiFactory = new ApiFactory();
        this.mMapper = new CustomerMapper();
    }

    public static ClientRepository getInstance() {
        if (mInstance == null) {
            synchronized (ClientRepository.class) {
                if (mInstance == null) {
                    mInstance = new ClientRepository();
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
     *
     * @return
     */
    public Observable<BaseData> regist(String account, String password, String password_verify, String captcha) {
        return mApiFactory.regist(account, password, password_verify, captcha);
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
        return mApiFactory.login(account, password);
    }

    /**
     * 获取验证码
     *
     * @param tel
     *
     * @return
     */
    public Observable<BaseData> getCaptcha(String tel) {
        return mApiFactory.getCaptcha(tel);
    }

    /**
     * 获取客源信息列表
     *
     * @return
     */
    public Observable<List<CustomerListViewModel>> getClientList() {
        return mApiFactory.getClientList().map(new Func1<ClientListData, List<CustomerListViewModel>>() {
            @Override
            public List<CustomerListViewModel> call(ClientListData clientListData) {
                return mMapper.buildCustomerViewModel(clientListData.data);
            }
        });
    }

    /**
     * 获取客户信息详情
     *
     * @return
     */

    public Observable<ClientPrivateData> getClientInfo(int client_id) {
        return mApiFactory.getClientInfo(client_id);
    }

    public Observable<List<ClientFollowViewModel>> getClientFollowListData(int client_id) {
        return mApiFactory.getClientFollow(client_id).map(new Func1<ClientFollowListData, List<ClientFollowViewModel>>() {
            @Override
            public List<ClientFollowViewModel> call(ClientFollowListData clientFollowListData) {
                return mMapper.buildClientFollowViewModels(clientFollowListData.data);
            }
        });
    }

    /**
     * 获取工作信息
     *
     * @return
     */
    public Observable<WorkModel> getWrokInfo() {
        return mApiFactory.getWrokInfo();
    }

    /**
     * 推荐-确认中列表
     *
     * @return
     */
    public Observable<BrokerWaitConfirmData> getBrokerWait() {
        return mApiFactory.getBrokerWait();
    }

    /**
     * 推荐-有效列表
     *
     * @return
     */
    public Observable<BrrokerValueData> getBrokerValue() {
        return mApiFactory.getBrokerValue();
    }

    /**
     * 推荐-无效列表
     *
     * @return
     */
    public Observable<BrrokerDisabledData> getBrokerDisabled() {
        return mApiFactory.getBrokerDisabled();
    }

    public Observable<ConfirmDetailData> getwaitConfirmDetail(int id) {
        return mApiFactory.getwaitConfirmDetail(id);
    }

    public Observable<ValueDetailData> getValueDetail(int id) {
        return mApiFactory.getValueDetail(id);
    }

    /**
     * 获取工报备确认中信息
     *
     * @return
     */
    public Observable<RecordAffirmBaseData> getRecordAffirm() {
        return mApiFactory.getRecordAffirm();

    }
    /**
     * 获取工报备有效信息
     *
     * @return
     */
    public Observable<RecordValidData> getRecordValid() {
        return mApiFactory.getRecordValid();

    }
    /**
     * 获取工报备无效信息
     *
     * @return
     */
    public Observable<WorkReportDisableData> getRecordDisabled() {
        return mApiFactory.getRecordDisabled();

    }
    public Observable<ValueDetailData> getDetail(int id) {
        return mApiFactory.getDetail(id);
    }

}

