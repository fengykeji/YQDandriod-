package com.ccsoft.yunqudao.model;

import java.util.List;

/**
 * Created by lixinke on 2018/5/28.
 */

public class ClientListModel {

    private int current_page;
    private List<Data> data;
    private int last_page;

    public int getCurrent_page() {
        return current_page;
    }

    public void setCurrent_page(int current_page) {
        this.current_page = current_page;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public int getLast_page() {
        return last_page;
    }

    public void setLast_page(int last_page) {
        this.last_page = last_page;
    }

    public class Data {
        private int client_id;
        private String name;
        private int sex;
        private String tel;
        private int property_type;
        private int total_price;
        private String house_type;
        private String intent;
        private String urgency;

        public int getClient_id() {
            return client_id;
        }

        public void setClient_id(int client_id) {
            this.client_id = client_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public int getProperty_type() {
            return property_type;
        }

        public void setProperty_type(int property_type) {
            this.property_type = property_type;
        }

        public int getTotal_price() {
            return total_price;
        }

        public void setTotal_price(int total_price) {
            this.total_price = total_price;
        }

        public String getHouse_type() {
            return house_type;
        }

        public void setHouse_type(String house_type) {
            this.house_type = house_type;
        }

        public String getIntent() {
            return intent;
        }

        public void setIntent(String intent) {
            this.intent = intent;
        }

        public String getUrgency() {
            return urgency;
        }

        public void setUrgency(String urgency) {
            this.urgency = urgency;
        }
    }



}
