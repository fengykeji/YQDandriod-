package com.ccsoft.yunqudao.bean;

import java.util.List;

public class CityBean {

    /**
     * code : 200
     * msg : 查询成功
     * data : [{"city_name":"绵阳","city_code":"510700"}]
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
        @Override
        public String toString() {
            return "DataBean{" +
                    "city_name='" + city_name + '\'' +
                    ", city_code='" + city_code + '\'' +
                    '}';
        }

        /**
         * city_name : 绵阳
         * city_code : 510700
         */

        private String city_name;
        private String city_code;

        public String getCity_name() {
            return city_name;
        }

        public void setCity_name(String city_name) {
            this.city_name = city_name;
        }

        public String getCity_code() {
            return city_code;
        }

        public void setCity_code(String city_code) {
            this.city_code = city_code;
        }
    }
}
