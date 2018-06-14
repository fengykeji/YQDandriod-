package com.ccsoft.yunqudao.data.model.viewmodel;

import com.ccsoft.yunqudao.data.base.BaseViewModel;

/**
 * @author: Pein
 * @data: 2018/5/25 0025
 */

public class CustomerDetailViewModel extends BaseViewModel {

    public String name;

    public int sex;

    public String birth;

    public String tel;

    public int cardType;

    public String cardID;

    public String address;

    @Override
    public String toString() {
        return "CustomerDetailViewModel{" + "name='" + name + '\'' + ", sex=" + sex + ", birth='" + birth + '\'' + ", tel='" + tel + '\'' + ", cardType=" + cardType + ", cardID='" + cardID + '\'' + ", address='" + address + '\'' + '}';
    }
}
