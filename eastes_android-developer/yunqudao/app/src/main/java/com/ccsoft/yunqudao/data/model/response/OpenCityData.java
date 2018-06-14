package com.ccsoft.yunqudao.data.model.response;

import com.ccsoft.yunqudao.data.base.BaseData;
import com.ccsoft.yunqudao.utils.indexbar.bean.BaseIndexPinyinBean;
import java.io.Serializable;
import java.util.List;

/**
 * @author: Pein
 * @data: 2018/5/26 0026
 */

public class OpenCityData extends BaseData {

    /**
     * code : 200
     * msg : 查询成功
     * data : [{"city_name":"成都","city_code":"510100"},{"city_name":"内江","city_code":"511000"},{"city_name":"绵阳","city_code":"510700"},{"city_name":"眉山","city_code":"511400"}]
     */

    private int code;
    private String         msg;
    private List<DataBean> data;

    public int getCode() { return code;}

    public void setCode(int code) { this.code = code;}

    public String getMsg() { return msg;}

    public void setMsg(String msg) { this.msg = msg;}

    public List<DataBean> getData() { return data;}

    public void setData(List<DataBean> data) { this.data = data;}

    public static class DataBean extends BaseIndexPinyinBean implements Serializable {
        /**
         * city_name : 成都
         * city_code : 510100
         */

        private String city_name;
        private String city_code;

        public String getCity_name() { return city_name;}

        public void setCity_name(String city_name) { this.city_name = city_name;}

        public String getCity_code() { return city_code;}

        public void setCity_code(String city_code) { this.city_code = city_code;}

        @Override
        public String getTarget() {
            return city_name;
        }

        @Override
        public String toString() {
            return "DataBean{" + "city_name='" + city_name + '\'' + ", city_code='" + city_code + '\'' + '}';
        }
    }

    @Override
    public String toString() {
        return "OpenCityData{" + "code=" + code + ", msg='" + msg + '\'' + ", data=" + data + '}';
    }
}
