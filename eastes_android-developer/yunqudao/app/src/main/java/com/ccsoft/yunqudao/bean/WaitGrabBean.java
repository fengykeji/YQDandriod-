package com.ccsoft.yunqudao.bean;

import java.util.List;

public class WaitGrabBean {


    /**
     * code : 200
     * msg : 查询成功
     * data : [{"project_name":"翡翠滨江","house_code":"","record_time":"2018-08-16 15:22:41","name":"张三","tel":"15082245107","sex":1,"record_id":3,"house":"1栋-一单元-1701"},{"project_name":"翡翠滨江","house_code":"","record_time":"2018-08-16 18:15:27","name":"张三","tel":"15082245107","sex":1,"record_id":5,"house":"1栋-一单元-1702"}]
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
         * record_time : 2018-08-16 15:22:41
         * name : 张三
         * tel : 15082245107
         * sex : 1
         * record_id : 3
         * house : 1栋-一单元-1701
         */

        private String project_name;
        private String house_code;
        private String record_time;
        private String name;
        private String tel;
        private int sex;
        private int record_id;
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

        public String getRecord_time() {
            return record_time;
        }

        public void setRecord_time(String record_time) {
            this.record_time = record_time;
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
    }
}
