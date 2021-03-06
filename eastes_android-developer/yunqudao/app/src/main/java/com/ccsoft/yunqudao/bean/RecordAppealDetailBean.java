package com.ccsoft.yunqudao.bean;

public class RecordAppealDetailBean {

    /**
     * code : 200
     * msg : 查询成功
     * data : {"disabled_state":"客户不想卖了","disabled_reason":"测试","disabled_time":"2018-08-06 15:12:18","survey_time":"2018-08-06 15:08:03","agent_name":"测试人员","agent_tel":"15222080186","store_name":"请问请问","project_name":"翡翠滨江","house_code":"","name":"李四","tel":"15082245107","sex":1,"card_type":"","card_id":"","comment":"123","report_type":"业主-主权益人","record_time":"2018-08-06 15:00:14","appeal_time":"0000-00-00 00:00:00","appeal_type":"申述类型2","appeal_comment":"申述","appeal_solve_info":"","house":"1栋-一单元-1702"}
     */

    private int code;
    private String msg;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * disabled_state : 客户不想卖了
         * disabled_reason : 测试
         * disabled_time : 2018-08-06 15:12:18
         * survey_time : 2018-08-06 15:08:03
         * agent_name : 测试人员
         * agent_tel : 15222080186
         * store_name : 请问请问
         * project_name : 翡翠滨江
         * house_code :
         * name : 李四
         * tel : 15082245107
         * sex : 1
         * card_type :
         * card_id :
         * comment : 123
         * report_type : 业主-主权益人
         * record_time : 2018-08-06 15:00:14
         * appeal_time : 0000-00-00 00:00:00
         * appeal_type : 申述类型2
         * appeal_comment : 申述
         * appeal_solve_info :
         * house : 1栋-一单元-1702
         */

        private String disabled_state;
        private String disabled_reason;
        private String disabled_time;
        private String survey_time;
        private String agent_name;
        private String agent_tel;
        private String store_name;
        private String project_name;
        private String house_code;
        private String name;
        private String tel;
        private int sex;
        private String card_type;
        private String card_id;
        private String comment;
        private String report_type;
        private String record_time;
        private String appeal_time;
        private String appeal_type;
        private String appeal_comment;
        private String appeal_solve_info;
        private String house;

        public String getDisabled_state() {
            return disabled_state;
        }

        public void setDisabled_state(String disabled_state) {
            this.disabled_state = disabled_state;
        }

        public String getDisabled_reason() {
            return disabled_reason;
        }

        public void setDisabled_reason(String disabled_reason) {
            this.disabled_reason = disabled_reason;
        }

        public String getDisabled_time() {
            return disabled_time;
        }

        public void setDisabled_time(String disabled_time) {
            this.disabled_time = disabled_time;
        }

        public String getSurvey_time() {
            return survey_time;
        }

        public void setSurvey_time(String survey_time) {
            this.survey_time = survey_time;
        }

        public String getAgent_name() {
            return agent_name;
        }

        public void setAgent_name(String agent_name) {
            this.agent_name = agent_name;
        }

        public String getAgent_tel() {
            return agent_tel;
        }

        public void setAgent_tel(String agent_tel) {
            this.agent_tel = agent_tel;
        }

        public String getStore_name() {
            return store_name;
        }

        public void setStore_name(String store_name) {
            this.store_name = store_name;
        }

        public String getProject_name() {
            return project_name;
        }

        public void setProject_name(String project_name) {
            this.project_name = project_name;
        }

        public String getHouse_code() {
            return house_code;
        }

        public void setHouse_code(String house_code) {
            this.house_code = house_code;
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

        public String getCard_type() {
            return card_type;
        }

        public void setCard_type(String card_type) {
            this.card_type = card_type;
        }

        public String getCard_id() {
            return card_id;
        }

        public void setCard_id(String card_id) {
            this.card_id = card_id;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public String getReport_type() {
            return report_type;
        }

        public void setReport_type(String report_type) {
            this.report_type = report_type;
        }

        public String getRecord_time() {
            return record_time;
        }

        public void setRecord_time(String record_time) {
            this.record_time = record_time;
        }

        public String getAppeal_time() {
            return appeal_time;
        }

        public void setAppeal_time(String appeal_time) {
            this.appeal_time = appeal_time;
        }

        public String getAppeal_type() {
            return appeal_type;
        }

        public void setAppeal_type(String appeal_type) {
            this.appeal_type = appeal_type;
        }

        public String getAppeal_comment() {
            return appeal_comment;
        }

        public void setAppeal_comment(String appeal_comment) {
            this.appeal_comment = appeal_comment;
        }

        public String getAppeal_solve_info() {
            return appeal_solve_info;
        }

        public void setAppeal_solve_info(String appeal_solve_info) {
            this.appeal_solve_info = appeal_solve_info;
        }

        public String getHouse() {
            return house;
        }

        public void setHouse(String house) {
            this.house = house;
        }
    }
}
