package com.ccsoft.yunqudao.bean;

import java.util.List;

public class GongZuoJingLiBean {

    /**
     * code : 200
     * msg : 查询成功
     * data : [{"company_name":"四川佳林兴房地产营销策划有限公司","entry_time":"2018-07-13","quit_time":"2018-07-17","company_id":10,"role":"经纪人","his":{"recommend":9,"value":3,"deal":0}},{"company_name":"四川佳林兴房地产营销策划有限公司","entry_time":"2018-07-13","quit_time":"2018-07-13","company_id":10,"role":"经纪人","his":{"recommend":9,"value":3,"deal":0}},{"company_name":"四川佳林兴房地产营销策划有限公司","entry_time":"2018-07-13","quit_time":"2018-07-13","company_id":10,"role":"经纪人","his":{"recommend":9,"value":3,"deal":0}},{"company_name":"四川佳林兴房地产营销策划有限公司","entry_time":"2018-06-29","quit_time":"2018-07-13","company_id":10,"role":"经纪人","his":{"recommend":9,"value":3,"deal":0}},{"company_name":"四川佳林兴房地产营销策划有限公司","entry_time":"2018-06-29","quit_time":"2018-07-13","company_id":10,"role":"经纪人","his":{"recommend":9,"value":3,"deal":0}},{"company_name":"四川佳林兴房地产营销策划有限公司","entry_time":"2018-07-13","quit_time":"2018-07-13","company_id":10,"role":"经纪人","his":{"recommend":9,"value":3,"deal":0}},{"company_name":"四川佳林兴房地产营销策划有限公司","entry_time":"2018-07-13","quit_time":"2018-07-13","company_id":10,"role":"经纪人","his":{"recommend":9,"value":3,"deal":0}},{"company_name":"四川佳林兴房地产营销策划有限公司","entry_time":"2018-07-11","quit_time":"2018-07-11","company_id":10,"role":"经纪人","his":{"recommend":9,"value":3,"deal":0}}]
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
         * company_name : 四川佳林兴房地产营销策划有限公司
         * entry_time : 2018-07-13
         * quit_time : 2018-07-17
         * company_id : 10
         * role : 经纪人
         * his : {"recommend":9,"value":3,"deal":0}
         */

        private String company_name;
        private String entry_time;
        private String quit_time;
        private int company_id;
        private String role;
        private HisBean his;

        public String getCompany_name() {
            return company_name;
        }

        public void setCompany_name(String company_name) {
            this.company_name = company_name;
        }

        public String getEntry_time() {
            return entry_time;
        }

        public void setEntry_time(String entry_time) {
            this.entry_time = entry_time;
        }

        public String getQuit_time() {
            return quit_time;
        }

        public void setQuit_time(String quit_time) {
            this.quit_time = quit_time;
        }

        public int getCompany_id() {
            return company_id;
        }

        public void setCompany_id(int company_id) {
            this.company_id = company_id;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public HisBean getHis() {
            return his;
        }

        public void setHis(HisBean his) {
            this.his = his;
        }

        public static class HisBean {
            /**
             * recommend : 9
             * value : 3
             * deal : 0
             */

            private int recommend;
            private int value;
            private int deal;

            public int getRecommend() {
                return recommend;
            }

            public void setRecommend(int recommend) {
                this.recommend = recommend;
            }

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }

            public int getDeal() {
                return deal;
            }

            public void setDeal(int deal) {
                this.deal = deal;
            }
        }
    }
}
