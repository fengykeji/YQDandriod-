package com.ccsoft.yunqudao.data.model.viewmodel;

import com.ccsoft.yunqudao.data.base.BaseViewModel;

/**
 * @author: Pein
 * @data: 2018/5/23 0023
 */

public class CustomerListViewModel extends BaseViewModel {
    public int    client_id;
    public int    sex;
    public int    property_type;
    public int    total_price;
    public int    intent;
    public int    urgency;
    public String name;
    public String tel;
    public String house_type;
    public String region;

    @Override
    public String toString() {
        return "CustomerListViewModel{" + "client_id=" + client_id + ", sex=" + sex + ", property_type=" + property_type + ", total_price=" + total_price + ", intent=" + intent + ", urgency=" + urgency + ", name='" + name + '\'' + ", tel='" + tel + '\'' + ", house_type='" + house_type + '\'' + ", region='" + region + '\'' + '}';
    }
}
