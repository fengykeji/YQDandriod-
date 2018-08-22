package com.ccsoft.yunqudao.bean;

public class WaitGrabDetailBean {

    /**
     * code : 200
     * msg : 查询成功
     * data : {"store_name":"请问请问","project_name":"翡翠滨江","house_code":"","record_time":"2018-08-16 15:22:41","name":"张三","tel":"15082245107","sex":1,"address":"四川 ","card_type":"","card_id":"","report_type":"业主-主权益人","comment":"123","house":"1栋-一单元-1701"}
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
         * store_name : 请问请问
         * project_name : 翡翠滨江
         * house_code :
         * record_time : 2018-08-16 15:22:41
         * name : 张三
         * tel : 15082245107
         * sex : 1
         * address : 四川
         * card_type :
         * card_id :
         * report_type : 业主-主权益人
         * comment : 123
         * house : 1栋-一单元-1701
         */

        private String store_name;
        private String project_name;
        private String house_code;
        private String record_time;
        private String name;
        private String tel;
        private int sex;
        private String address;
        private String card_type;
        private String card_id;
        private String report_type;
        private String comment;
        private String house;

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

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
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

        public String getReport_type() {
            return report_type;
        }

        public void setReport_type(String report_type) {
            this.report_type = report_type;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public String getHouse() {
            return house;
        }

        public void setHouse(String house) {
            this.house = house;
        }
    }
}
