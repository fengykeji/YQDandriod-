package com.ccsoft.yunqudao.bean;

import java.util.List;

public class AppealListBean {


    /**
     * code : 200
     * msg : 查询成功
     * data : [{"project_name":"翡翠滨江","house_code":"","name":"李四","tel":"15082245107","sex":1,"appeal_id":91,"appeal_time":"0000-00-00 00:00:00","appeal_state":2,"house":"1栋-一单元-1702"},{"project_name":"翡翠滨江","house_code":"","name":"李四","tel":"15082245107","sex":1,"appeal_id":93,"appeal_time":"0000-00-00 00:00:00","appeal_state":2,"house":"1栋-一单元-1702"}]
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
         * house_code :
         * name : 李四
         * tel : 15082245107
         * sex : 1
         * appeal_id : 91
         * appeal_time : 0000-00-00 00:00:00
         * appeal_state : 2
         * house : 1栋-一单元-1702
         */

        private String project_name;
        private String house_code;
        private String name;
        private String tel;
        private int sex;
        private int appeal_id;
        private String appeal_time;
        private int appeal_state;
        private String house;

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

        public int getAppeal_id() {
            return appeal_id;
        }

        public void setAppeal_id(int appeal_id) {
            this.appeal_id = appeal_id;
        }

        public String getAppeal_time() {
            return appeal_time;
        }

        public void setAppeal_time(String appeal_time) {
            this.appeal_time = appeal_time;
        }

        public int getAppeal_state() {
            return appeal_state;
        }

        public void setAppeal_state(int appeal_state) {
            this.appeal_state = appeal_state;
        }

        public String getHouse() {
            return house;
        }

        public void setHouse(String house) {
            this.house = house;
        }
    }
}
