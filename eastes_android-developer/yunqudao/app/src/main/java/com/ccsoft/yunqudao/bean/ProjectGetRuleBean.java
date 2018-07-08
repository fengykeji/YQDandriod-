package com.ccsoft.yunqudao.bean;

import java.util.List;

public class ProjectGetRuleBean {

    /**
     * code : 200
     * msg : 查询成功
     * data : [{"rule_id":40,"visit_confirm_time":1440,"valid_visit_time":1,"make_bargain_time":1,"comment":"","begin_time":"2018-06-11 16:00:00","end_time":"2037-12-31 23:59:59","confirm_settle_commission_time":7,"visit_settle_commission_time":7,"region_settle_commission_time":7,"describe":"1、客户到访前，经纪人需要提前至少1个小时报备（客户姓名、电话、性别）。\r\n2、客户报备后享有24小时保护期，超过保护期时间客户未到售楼部，报备失效，经纪人需要重新对客户进行报备，若未重新报备为无效。\r\n3、客户到访有效后，享有30天保护期，保护期内报备的客户认购并签约，奖励经纪人2000元/组/套；超过保护期成交的客户，经纪人不享受成交奖励。","standard":1,"person":[{"basic_rule_id":40,"rule_name":"测试规则","plan_start":"2018-05-01 00:00:00","plan_end":"2018-05-31 00:00:00","act_start":"2018-06-05 00:00:00","act_end":"2018-07-02 03:08:34","commission_describe":"成交：2000","broker":[{"broker_name":"成交佣金","list":[{"property_type":"住宅","commission_way":"定额","param":5000}]},{"broker_name":"到访佣金","list":[{"property_type":"","commission_way":"定额","param":6854}]},{"broker_name":"推荐佣金","list":[{"property_type":"","commission_way":"定额","param":3245}]}]}]}]
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
         * rule_id : 40
         * visit_confirm_time : 1440
         * valid_visit_time : 1
         * make_bargain_time : 1
         * comment :
         * begin_time : 2018-06-11 16:00:00
         * end_time : 2037-12-31 23:59:59
         * confirm_settle_commission_time : 7
         * visit_settle_commission_time : 7
         * region_settle_commission_time : 7
         * describe : 1、客户到访前，经纪人需要提前至少1个小时报备（客户姓名、电话、性别）。
         2、客户报备后享有24小时保护期，超过保护期时间客户未到售楼部，报备失效，经纪人需要重新对客户进行报备，若未重新报备为无效。
         3、客户到访有效后，享有30天保护期，保护期内报备的客户认购并签约，奖励经纪人2000元/组/套；超过保护期成交的客户，经纪人不享受成交奖励。
         * standard : 1
         * person : [{"basic_rule_id":40,"rule_name":"测试规则","plan_start":"2018-05-01 00:00:00","plan_end":"2018-05-31 00:00:00","act_start":"2018-06-05 00:00:00","act_end":"2018-07-02 03:08:34","commission_describe":"成交：2000","broker":[{"broker_name":"成交佣金","list":[{"property_type":"住宅","commission_way":"定额","param":5000}]},{"broker_name":"到访佣金","list":[{"property_type":"","commission_way":"定额","param":6854}]},{"broker_name":"推荐佣金","list":[{"property_type":"","commission_way":"定额","param":3245}]}]}]
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
        private List<PersonBean> person;

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

        public List<PersonBean> getPerson() {
            return person;
        }

        public void setPerson(List<PersonBean> person) {
            this.person = person;
        }

        public static class PersonBean {
            /**
             * basic_rule_id : 40
             * rule_name : 测试规则
             * plan_start : 2018-05-01 00:00:00
             * plan_end : 2018-05-31 00:00:00
             * act_start : 2018-06-05 00:00:00
             * act_end : 2018-07-02 03:08:34
             * commission_describe : 成交：2000
             * broker : [{"broker_name":"成交佣金","list":[{"property_type":"住宅","commission_way":"定额","param":5000}]},{"broker_name":"到访佣金","list":[{"property_type":"","commission_way":"定额","param":6854}]},{"broker_name":"推荐佣金","list":[{"property_type":"","commission_way":"定额","param":3245}]}]
             */

            private int basic_rule_id;
            private String rule_name;
            private String plan_start;
            private String plan_end;
            private String act_start;
            private String act_end;
            private String commission_describe;
            private List<BrokerBean> broker;

            public int getBasic_rule_id() {
                return basic_rule_id;
            }

            public void setBasic_rule_id(int basic_rule_id) {
                this.basic_rule_id = basic_rule_id;
            }

            public String getRule_name() {
                return rule_name;
            }

            public void setRule_name(String rule_name) {
                this.rule_name = rule_name;
            }

            public String getPlan_start() {
                return plan_start;
            }

            public void setPlan_start(String plan_start) {
                this.plan_start = plan_start;
            }

            public String getPlan_end() {
                return plan_end;
            }

            public void setPlan_end(String plan_end) {
                this.plan_end = plan_end;
            }

            public String getAct_start() {
                return act_start;
            }

            public void setAct_start(String act_start) {
                this.act_start = act_start;
            }

            public String getAct_end() {
                return act_end;
            }

            public void setAct_end(String act_end) {
                this.act_end = act_end;
            }

            public String getCommission_describe() {
                return commission_describe;
            }

            public void setCommission_describe(String commission_describe) {
                this.commission_describe = commission_describe;
            }

            public List<BrokerBean> getBroker() {
                return broker;
            }

            public void setBroker(List<BrokerBean> broker) {
                this.broker = broker;
            }

            public static class BrokerBean {
                /**
                 * broker_name : 成交佣金
                 * list : [{"property_type":"住宅","commission_way":"定额","param":5000}]
                 */

                private String broker_name;
                private List<ListBean> list;

                public String getBroker_name() {
                    return broker_name;
                }

                public void setBroker_name(String broker_name) {
                    this.broker_name = broker_name;
                }

                public List<ListBean> getList() {
                    return list;
                }

                public void setList(List<ListBean> list) {
                    this.list = list;
                }

                public static class ListBean {
                    /**
                     * property_type : 住宅
                     * commission_way : 定额
                     * param : 5000
                     */

                    private String property_type;
                    private String commission_way;
                    private int param;

                    public String getProperty_type() {
                        return property_type;
                    }

                    public void setProperty_type(String property_type) {
                        this.property_type = property_type;
                    }

                    public String getCommission_way() {
                        return commission_way;
                    }

                    public void setCommission_way(String commission_way) {
                        this.commission_way = commission_way;
                    }

                    public int getParam() {
                        return param;
                    }

                    public void setParam(int param) {
                        this.param = param;
                    }
                }
            }
        }
    }
}
