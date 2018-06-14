package com.ccsoft.yunqudao.data.model.mapper;

import android.util.Log;
import com.ccsoft.yunqudao.data.model.response.ClientFollowListData;
import com.ccsoft.yunqudao.data.model.response.ClientListData;
import com.ccsoft.yunqudao.data.model.viewmodel.ClientFollowViewModel;
import com.ccsoft.yunqudao.data.model.viewmodel.CustomerDetailViewModel;
import com.ccsoft.yunqudao.data.model.viewmodel.CustomerListViewModel;
import com.ccsoft.yunqudao.utils.LogUtil;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Pein
 * @data: 2018/5/23 0023
 */

public class CustomerMapper {

    /**
     * 转换客户列表viewmodel
     *
     * @param listData
     *
     * @return
     */
    public List<CustomerListViewModel> buildCustomerViewModel(List<ClientListData.ClientData> listData) {
        if (listData == null || listData.isEmpty()) {
            Log.e("CustomerMapper", "数据转换失败，list为null");
            return null;
        }
        else {
            List<CustomerListViewModel> viewModelList = new ArrayList<>();
            try {
                for (ClientListData.ClientData clientData : listData) {
                    CustomerListViewModel viewModel = new CustomerListViewModel();
                    viewModel.name = clientData.name;
                    viewModel.client_id = clientData.client_id;
                    viewModel.house_type = clientData.house_type;
                    viewModel.intent = clientData.intent;
                    viewModel.property_type = clientData.property_type;
                    viewModel.sex = clientData.sex;
                    viewModel.tel = clientData.tel;
                    viewModel.total_price = clientData.total_price;
                    viewModel.urgency = clientData.urgency;
                    viewModelList.add(viewModel);
                }
                return viewModelList;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public List<ClientFollowViewModel> buildClientFollowViewModels(List<ClientFollowListData.ClientFollowData> listdata) {
        if (listdata == null) {
            LogUtil.e("CustomerMapper", "数据转换失败，list为null");
            return null;
        }
        else {
            List<ClientFollowViewModel> viewModels = new ArrayList<>();
            try {
                for (ClientFollowListData.ClientFollowData followData : listdata) {
                    ClientFollowViewModel viewModel = new ClientFollowViewModel();
                    viewModel.comment = followData.comment;
                    viewModel.follow_time = followData.follow_time;
                    viewModel.follow_type = followData.follow_type;
                    viewModel.intent = followData.intent;
                    viewModel.urgency = followData.urgency;
                    viewModels.add(viewModel);
                }
                return viewModels;
            } catch (Exception e) {
                e.printStackTrace();
                LogUtil.e("CustomerMapper", "参数异常转换错误");
                return null;
            }
        }
    }
}
