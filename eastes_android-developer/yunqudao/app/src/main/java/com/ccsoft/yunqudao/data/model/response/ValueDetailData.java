package com.ccsoft.yunqudao.data.model.response;

import com.ccsoft.yunqudao.data.base.BaseData;
import java.util.List;

/**
 * desc   :
 * author : YangFan
 * date   : 2018/5/27 23:17
 * email  : 928902646@qq.com
 */
public class ValueDetailData extends BaseData{

    /**
     * client_id : 196
     * create_time : 2018-05-16 21:30:27
     * name : 鲁
     * sex : 1
     * tel : 13900000001
     * property_type : 0
     * butter_name : 云算对接人
     * butter_tel : 15082245102
     * broker_name :
     * broker_tel : 18048798935
     * project_name : 云算2
     * province : 510000
     * city : 510100
     * district : 510107
     * absolute_address : 成都郫县菁蓉大禹东路123号
     * visit_num : 2
     * property_advicer_wish : 周静
     * confirm_name : 鲁
     * confirm_tel : 13900000001
     * province_name : 四川省
     * city_name : 成都市
     * district_name : 武侯区
     * process : [{"process_name":"推荐","time":"2018-05-16 21:30:27"},{"process_name":"到访","time":"2018-05-16 21:31:00"},{"process_name":"确认有效","time":"2018-05-16
     * 21:33:47"},{"process_name":"认购","time":"2018-05-16 21:35:24"}]
     */

    public int               client_id;
    public String            create_time;
    public String            name;
    public int               sex;
    public String            tel;
    public int               property_type;
    public String            butter_name;
    public String            butter_tel;
    public String            broker_name;
    public String            broker_tel;
    public String            project_name;
    public String            province;
    public String            city;
    public String            district;
    public String            absolute_address;
    public int               visit_num;
    public String            property_advicer_wish;
    public String            confirm_name;
    public String            confirm_tel;
    public String            province_name;
    public String            city_name;
    public String            district_name;
    public String            comsulatent_advicer;
    public String recommend_type;
    public String comsulatent_advicer_tel;
    public String comsulatent_advicer_company;
    public String client_comment;
    public List<ProcessBean> process;

    public class ProcessBean {
        /**
         * process_name : 推荐
         * time : 2018-05-16 21:30:27
         */

        public String process_name;
        public String time;

        public String getProcess_name() {
            return process_name;
        }

        public void setProcess_name(String process_name) {
            this.process_name = process_name;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }
}
