package com.ccsoft.yunqudao.bean;

public class GongSiRenZhengBean {


    /**
     * code : 200
     * msg : 查询成功
     * data : {"id":65,"agent_id":5,"create_time":"2018-07-07 18:30:11","work_code":"0202","department":"ssss","position":"","img_url":"","company_name":"四川佳林兴房地产营销策划有限公司","butter_project":"保利房屋","state":"认证中"}
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
         * id : 65
         * agent_id : 5
         * create_time : 2018-07-07 18:30:11
         * work_code : 0202
         * department : ssss
         * position :
         * img_url :
         * company_name : 四川佳林兴房地产营销策划有限公司
         * butter_project : 保利房屋
         * state : 认证中
         */

        private int id;
        private int agent_id;
        private String create_time;
        private String work_code;
        private String department;
        private String position;
        private String img_url;
        private String company_name;
        private String butter_project;
        private String state;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getAgent_id() {
            return agent_id;
        }

        public void setAgent_id(int agent_id) {
            this.agent_id = agent_id;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getWork_code() {
            return work_code;
        }

        public void setWork_code(String work_code) {
            this.work_code = work_code;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getImg_url() {
            return img_url;
        }

        public void setImg_url(String img_url) {
            this.img_url = img_url;
        }

        public String getCompany_name() {
            return company_name;
        }

        public void setCompany_name(String company_name) {
            this.company_name = company_name;
        }

        public String getButter_project() {
            return butter_project;
        }

        public void setButter_project(String butter_project) {
            this.butter_project = butter_project;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }
    }
}
