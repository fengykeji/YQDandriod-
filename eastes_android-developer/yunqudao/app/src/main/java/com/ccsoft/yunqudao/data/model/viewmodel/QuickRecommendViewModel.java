package com.ccsoft.yunqudao.data.model.viewmodel;

import com.ccsoft.yunqudao.data.base.BaseViewModel;
import java.util.List;

/**
 * desc   :
 * author : YangFan
 * date   : 2018/5/27 00:24
 * email  : 928902646@qq.com
 */
public class QuickRecommendViewModel extends BaseViewModel {

    /**
     * project_id : 3
     * project_name : 大唐公馆
     * province : 510000
     * city : 510100
     * district : 510124
     * project_tags : 56,57,58
     * deposit : 3000
     * sale_state : 待售
     * img_url : upload/agent/headimg/1523850012_10.jpg
     * absolute_address : 月球
     * guarantee_brokerage : 2
     * property_tags : [61]
     * sort : 1
     * brokerSortCompare : 0   0 无图片  1上升 2下降
     * cycle : 4
     */
    public int           project_id;
    public String        project_name;
    public String        province;
    public String        city;
    public String        district;
    public String        project_tags;
    public int           deposit;
    public String        sale_state;
    public String        img_url;
    public String        absolute_address;
    public int           guarantee_brokerage;
    public List<Integer> property_tags;
    public int sort;
    public int brokerSortCompare;
    public int cycle;
}
