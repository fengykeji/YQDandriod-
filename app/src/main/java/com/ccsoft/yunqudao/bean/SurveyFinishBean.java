package com.ccsoft.yunqudao.bean;

import java.util.List;

public class SurveyFinishBean {

    /**
     * code : 200
     * msg : 查询成功
     * data : [{"project_name":"翡翠滨江","name":"张三","tel":"15082245107","sex":1,"survey_id":5,"record_agent_id":68,"finish_time":"2018-08-06 09:37:34","record_time":"2018-08-16 18:15:27","house_code":"","survey_time":"2018-08-06 09:33:20","house_id":5,"house":"1栋-一单元-1702","is_other":1}]
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
         * sex : 1
         * survey_id : 5
         * record_agent_id : 68
         * finish_time : 2018-08-06 09:37:34
         * record_time : 2018-08-16 18:15:27
         * house_code :
         * survey_time : 2018-08-06 09:33:20
         * house_id : 5
         * house : 1栋-一单元-1702
         * is_other : 1
         */

        private String project_name;
        private String name;
        private String tel;
        private int sex;
        private int survey_id;
        private int record_agent_id;
        private String finish_time;
        private String record_time;
        private String house_code;
        private String survey_time;
        private int house_id;
        private String house;
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

        public String getFinish_time() {
            return finish_time;
        }

        public void setFinish_time(String finish_time) {
            this.finish_time = finish_time;
        }

        public String getRecord_time() {
            return record_time;
        }

        public void setRecord_time(String record_time) {
            this.record_time = record_time;
        }

        public String getHouse_code() {
            return house_code;
        }

        public void setHouse_code(String house_code) {
            this.house_code = house_code;
        }

        public String getSurvey_time() {
            return survey_time;
        }

        public void setSurvey_time(String survey_time) {
            this.survey_time = survey_time;
        }

        public int getHouse_id() {
            return house_id;
        }

        public void setHouse_id(int house_id) {
            this.house_id = house_id;
        }

        public String getHouse() {
            return house;
        }

        public void setHouse(String house) {
            this.house = house;
        }

        public int getIs_other() {
            return is_other;
        }

        public void setIs_other(int is_other) {
            this.is_other = is_other;
        }
    }
}
