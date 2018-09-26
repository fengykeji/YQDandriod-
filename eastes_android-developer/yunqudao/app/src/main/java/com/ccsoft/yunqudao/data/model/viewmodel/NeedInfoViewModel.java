package com.ccsoft.yunqudao.data.model.viewmodel;

import com.ccsoft.yunqudao.data.base.BaseViewModel;

/**
 * @author: Pein
 * @data: 2018/5/25 0025
 */

public class NeedInfoViewModel extends BaseViewModel {

    public int         property_type;
    public int         total_price;
    public int         area;
    public String      house_type;
    public int         floor_min;
    public int         floor_max;
    public int         decorate;
    public int         buy_purpose;
    public int         pay_type;
    public int         intent;
    public int         urgency;

    @Override
    public String toString() {
        return "NeedInfoViewModel{" + "property_type=" + property_type  + ", total_price=" + total_price + ", area=" + area + ", house_type='" + house_type + '\'' + ", floor_min=" + floor_min + ", floor_max=" + floor_max + ", decorate=" + decorate + ", buy_purpose=" + buy_purpose + ", pay_type=" + pay_type + ", intent=" + intent + ", urgency=" + urgency + '}';
    }
}
