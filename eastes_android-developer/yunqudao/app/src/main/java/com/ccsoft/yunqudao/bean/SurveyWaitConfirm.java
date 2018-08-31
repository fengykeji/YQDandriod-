package com.ccsoft.yunqudao.bean;

import java.util.List;

public class SurveyWaitConfirm {

    /**
     * code : 200
     * msg : 查询成功
     * data : [{"project_name":"翡翠滨江","create_time":"2018-08-20 11:09:33","name":"李四","tel":"15082245107","sex":1,"survey_id":6,"record_id":6,"house":"1栋-一单元-1702","timeLimit":1534820973}]
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
         * create_time : 2018-08-20 11:09:33
         * name : 李四
         * tel : 15082245107
         * sex : 1
         * survey_id : 6
         * record_id : 6
         * house : 1栋-一单元-1702
         * timeLimit : 1534820973
         */

        private String project_name;
        private String create_time;
        private String name;
        private String tel;
        private int sex;
        private int survey_id;
        private int record_id;
        private String house;
        private int timeLimit;

        public String getProject_name() {
            return project_name;
        }

        public void setProject_name(String project_name) {
            this.project_name = project_name;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
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

        public int getRecord_id() {
            return record_id;
        }

        public void setRecord_id(int record_id) {
            this.record_id = record_id;
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
    }
}
