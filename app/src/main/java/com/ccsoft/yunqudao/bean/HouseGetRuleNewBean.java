package com.ccsoft.yunqudao.bean;

import java.util.List;

public class HouseGetRuleNewBean {

    /**
     * code : 200
     * msg : 查询成功
     * data : [{"rule_id":7,"visit_confirm_time":100,"valid_visit_time":4,"make_bargain_time":5,"comment":"1","begin_time":"2018-05-10 00:00:00","end_time":"2037-12-31 23:59:59","confirm_settle_commission_time":8,"visit_settle_commission_time":2,"region_settle_commission_time":3,"describe":"1、经纪人带客到访提前报备（即与相应置业顾问联系），并与客户一起到访；\r\n2、置业顾问做好来访登记，并与经纪人当面完成新客户界定，如为新客户，需由经纪人签字确认；\r\n3、新客户签订《商品房买卖合同》并付清应付房款后，即表示经纪人推介成功；否则，视为不成功。\r\n4、经纪人客户享有30天保护期，即确定为经纪人新客户后30天内未成交的，过了30天的保护期，之后成交与否，与经纪人无关。\r\n      5、凡通过行经纪人带访认购并签约奖励2000元/组/套。\r\n6、成功签约并根据回款进度次月发放。\r\n7、所有置业顾问一个月内经纪人带客成交比例原则上不能超过该置业顾问该月业绩的30%。\r\n","standard":1,"person":[]}]
     */

    private int code;
    private String msg;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * rule_id : 7
         * visit_confirm_time : 100
         * valid_visit_time : 4
         * make_bargain_time : 5
         * comment : 1
         * begin_time : 2018-05-10 00:00:00
         * end_time : 2037-12-31 23:59:59
         * confirm_settle_commission_time : 8
         * visit_settle_commission_time : 2
         * region_settle_commission_time : 3
         * describe : 1、经纪人带客到访提前报备（即与相应置业顾问联系），并与客户一起到访；
         2、置业顾问做好来访登记，并与经纪人当面完成新客户界定，如为新客户，需由经纪人签字确认；
         3、新客户签订《商品房买卖合同》并付清应付房款后，即表示经纪人推介成功；否则，视为不成功。
         4、经纪人客户享有30天保护期，即确定为经纪人新客户后30天内未成交的，过了30天的保护期，之后成交与否，与经纪人无关。
         5、凡通过行经纪人带访认购并签约奖励2000元/组/套。
         6、成功签约并根据回款进度次月发放。
         7、所有置业顾问一个月内经纪人带客成交比例原则上不能超过该置业顾问该月业绩的30%。

         * standard : 1
         * person : []
         */

        private int rule_id;
        private int visit_confirm_time;
        private int valid_visit_time;
        private int make_bargain_time;
        private String comment;
        private String begin_time;
        private String end_time;
        private int confirm_settle_commission_time;
        private int visit_settle_commission_time;
        private int region_settle_commission_time;
        private String describe;
        private int standard;
        private List<?> person;

        public int getRule_id() {
            return rule_id;
        }

        public void setRule_id(int rule_id) {
            this.rule_id = rule_id;
        }

        public int getVisit_confirm_time() {
            return visit_confirm_time;
        }

        public void setVisit_confirm_time(int visit_confirm_time) {
            this.visit_confirm_time = visit_confirm_time;
        }

        public int getValid_visit_time() {
            return valid_visit_time;
        }

        public void setValid_visit_time(int valid_visit_time) {
            this.valid_visit_time = valid_visit_time;
        }

        public int getMake_bargain_time() {
            return make_bargain_time;
        }

        public void setMake_bargain_time(int make_bargain_time) {
            this.make_bargain_time = make_bargain_time;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public String getBegin_time() {
            return begin_time;
        }

        public void setBegin_time(String begin_time) {
            this.begin_time = begin_time;
        }

        public String getEnd_time() {
            return end_time;
        }

        public void setEnd_time(String end_time) {
            this.end_time = end_time;
        }

        public int getConfirm_settle_commission_time() {
            return confirm_settle_commission_time;
        }

        public void setConfirm_settle_commission_time(int confirm_settle_commission_time) {
            this.confirm_settle_commission_time = confirm_settle_commission_time;
        }

        public int getVisit_settle_commission_time() {
            return visit_settle_commission_time;
        }

        public void setVisit_settle_commission_time(int visit_settle_commission_time) {
            this.visit_settle_commission_time = visit_settle_commission_time;
        }

        public int getRegion_settle_commission_time() {
            return region_settle_commission_time;
        }

        public void setRegion_settle_commission_time(int region_settle_commission_time) {
            this.region_settle_commission_time = region_settle_commission_time;
        }

        public String getDescribe() {
            return describe;
        }

        public void setDescribe(String describe) {
            this.describe = describe;
        }

        public int getStandard() {
            return standard;
        }

        public void setStandard(int standard) {
            this.standard = standard;
        }

        public List<?> getPerson() {
            return person;
        }

        public void setPerson(List<?> person) {
            this.person = person;
        }
    }
}
