package com.ccsoft.yunqudao.data.model.response;

import com.ccsoft.yunqudao.data.base.BaseData;
import java.util.List;

/**
 * desc   :
 * author : YangFan
 * date   : 2018/5/27 01:40
 * email  : 928902646@qq.com
 */
public class QuickRecommendData extends BaseData {

    public int             code;
    public String          msg;
    public List<QuickData> data;

    public class QuickData {
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
        public int           sort;
        public int           brokerSortCompare;
        public int           cycle;
        public List<Integer> property_tags;
    }
}
