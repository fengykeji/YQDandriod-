package com.ccsoft.yunqudao.bean;

import java.util.List;

public class SurveyUnderwayBean {

    /**
     * code : 200
     * msg : 查询成功
     * data : [{"project_name":"翡翠滨江","name":"张三","tel":"15082245107","record_id":3,"sex":1,"survey_id":1,"record_agent_id":68,"reserve_time":"2018-08-21 12:12:12","house":"1栋-一单元-1701","timeLimit":1534824732,"is_other":1}]
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
         * project_name : 翡翠滨江
         * name : 张三
         * tel : 15082245107
         * record_id : 3
         * sex : 1
         * survey_id : 1
         * record_agent_id : 68
         * reserve_time : 2018-08-21 12:12:12
         * house : 1栋-一单元-1701
         * timeLimit : 1534824732
         * is_other : 1
         */

        private String project_name;
        private String name;
        private String tel;
        private int record_id;
        private int sex;
        private int survey_id;
        private int record_agent_id;
        private String reserve_time;
        private String house;
        private int timeLimit;
        private int is_other;

        public String getProject_name() {
            return project_name;
        }

        public void setProject_name(String project_name) {
            this.project_name = project_name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public int getRecord_id() {
            return record_id;
        }

        public void setRecord_id(int record_id) {
            this.record_id = record_id;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public int getSurvey_id() {
            return survey_id;
        }

        public void setSurvey_id(int survey_id) {
            this.survey_id = survey_id;
        }

        public int getRecord_agent_id() {
            return record_agent_id;
        }

        public void setRecord_agent_id(int record_agent_id) {
            this.record_agent_id = record_agent_id;
        }

        public String getReserve_time() {
            return reserve_time;
        }

        public void setReserve_time(String reserve_time) {
            this.reserve_time = reserve_time;
        }

        public String getHouse() {
            return house;
        }

        public void setHouse(String house) {
            this.house = house;
        }

        public int getTimeLimit() {
            return timeLimit;
        }

        public void setTimeLimit(int timeLimit) {
            this.timeLimit = timeLimit;
        }

        public int getIs_other() {
            return is_other;
        }

        public void setIs_other(int is_other) {
            this.is_other = is_other;
        }
    }
}
