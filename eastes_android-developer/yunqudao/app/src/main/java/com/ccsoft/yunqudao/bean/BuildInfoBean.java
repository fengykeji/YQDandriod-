package com.ccsoft.yunqudao.bean;

import java.util.List;

public class BuildInfoBean {

    /**
     * code : 200
     * msg : 查询成功
     * data : {"project_name":"翡翠滨江","sale_state":"待售","developer_name":"三台县鸿州房地产开发有限公司","province":"510000","city":"510700","district":"510722","decoration_company":"四川寰宇","sale_address":"三台县北坝会仙路与涪滨路交汇处","absolute_address":"三台县北坝会仙路与涪滨路交汇处","build_type":"商住一体","average_price":6000,"min_price":0,"max_price":0,"floor_space":18591.74,"decoration_standard":"毛胚","covered_area":358255.69,"plot_retio":3.5,"greening_rate":30,"households_num":2304,"parking_num":2699,"property_company_name":"英创物业","property_cost":1.6,"heat_supply":"市政供暖","power_supply":"暂无","water_supply":"暂无","province_name":"四川省","city_name":"绵阳市","district_name":"三台县","property":["别墅","商铺","公寓","住宅","写字楼","商墅"],"sale_permit":[{"sale_permit":"EDWETTDD","permit_time":"2018-06-04"},{"sale_permit":"001","permit_time":"2018-06-03"},{"sale_permit":"WDADADWW","permit_time":"2018-06-03"},{"sale_permit":"WWQEQWEQWE","permit_time":"2018-06-10"},{"sale_permit":"ADAS DA","permit_time":"2018-06-10"},{"sale_permit":"wqweqwe","permit_time":"2018-06-10"}]}
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
         * project_name : 翡翠滨江
         * sale_state : 待售
         * developer_name : 三台县鸿州房地产开发有限公司
         * province : 510000
         * city : 510700
         * district : 510722
         * decoration_company : 四川寰宇
         * sale_address : 三台县北坝会仙路与涪滨路交汇处
         * absolute_address : 三台县北坝会仙路与涪滨路交汇处
         * build_type : 商住一体
         * average_price : 6000
         * min_price : 0
         * max_price : 0
         * floor_space : 18591.74
         * decoration_standard : 毛胚
         * covered_area : 358255.69
         * plot_retio : 3.5
         * greening_rate : 30
         * households_num : 2304
         * parking_num : 2699
         * property_company_name : 英创物业
         * property_cost : 1.6
         * heat_supply : 市政供暖
         * power_supply : 暂无
         * water_supply : 暂无
         * province_name : 四川省
         * city_name : 绵阳市
         * district_name : 三台县
         * property : ["别墅","商铺","公寓","住宅","写字楼","商墅"]
         * sale_permit : [{"sale_permit":"EDWETTDD","permit_time":"2018-06-04"},{"sale_permit":"001","permit_time":"2018-06-03"},{"sale_permit":"WDADADWW","permit_time":"2018-06-03"},{"sale_permit":"WWQEQWEQWE","permit_time":"2018-06-10"},{"sale_permit":"ADAS DA","permit_time":"2018-06-10"},{"sale_permit":"wqweqwe","permit_time":"2018-06-10"}]
         */

        private String project_name;
        private String sale_state;
        private String developer_name;
        private String province;
        private String city;
        private String district;
        private String decoration_company;
        private String sale_address;
        private String absolute_address;
        private String build_type;
        private int average_price;
        private int min_price;
        private int max_price;
        private double floor_space;
        private String decoration_standard;
        private double covered_area;
        private double plot_retio;
        private int greening_rate;
        private int households_num;
        private int parking_num;
        private String property_company_name;
        private double property_cost;
        private String heat_supply;
        private String power_supply;
        private String water_supply;
        private String province_name;
        private String city_name;
        private String district_name;
        private List<String> property;
        private List<SalePermitBean> sale_permit;

        public String getProject_name() {
            return project_name;
        }

        public void setProject_name(String project_name) {
            this.project_name = project_name;
        }

        public String getSale_state() {
            return sale_state;
        }

        public void setSale_state(String sale_state) {
            this.sale_state = sale_state;
        }

        public String getDeveloper_name() {
            return developer_name;
        }

        public void setDeveloper_name(String developer_name) {
            this.developer_name = developer_name;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        public String getDecoration_company() {
            return decoration_company;
        }

        public void setDecoration_company(String decoration_company) {
            this.decoration_company = decoration_company;
        }

        public String getSale_address() {
            return sale_address;
        }

        public void setSale_address(String sale_address) {
            this.sale_address = sale_address;
        }

        public String getAbsolute_address() {
            return absolute_address;
        }

        public void setAbsolute_address(String absolute_address) {
            this.absolute_address = absolute_address;
        }

        public String getBuild_type() {
            return build_type;
        }

        public void setBuild_type(String build_type) {
            this.build_type = build_type;
        }

        public int getAverage_price() {
            return average_price;
        }

        public void setAverage_price(int average_price) {
            this.average_price = average_price;
        }

        public int getMin_price() {
            return min_price;
        }

        public void setMin_price(int min_price) {
            this.min_price = min_price;
        }

        public int getMax_price() {
            return max_price;
        }

        public void setMax_price(int max_price) {
            this.max_price = max_price;
        }

        public double getFloor_space() {
            return floor_space;
        }

        public void setFloor_space(double floor_space) {
            this.floor_space = floor_space;
        }

        public String getDecoration_standard() {
            return decoration_standard;
        }

        public void setDecoration_standard(String decoration_standard) {
            this.decoration_standard = decoration_standard;
        }

        public double getCovered_area() {
            return covered_area;
        }

        public void setCovered_area(double covered_area) {
            this.covered_area = covered_area;
        }

        public double getPlot_retio() {
            return plot_retio;
        }

        public void setPlot_retio(double plot_retio) {
            this.plot_retio = plot_retio;
        }

        public int getGreening_rate() {
            return greening_rate;
        }

        public void setGreening_rate(int greening_rate) {
            this.greening_rate = greening_rate;
        }

        public int getHouseholds_num() {
            return households_num;
        }

        public void setHouseholds_num(int households_num) {
            this.households_num = households_num;
        }

        public int getParking_num() {
            return parking_num;
        }

        public void setParking_num(int parking_num) {
            this.parking_num = parking_num;
        }

        public String getProperty_company_name() {
            return property_company_name;
        }

        public void setProperty_company_name(String property_company_name) {
            this.property_company_name = property_company_name;
        }

        public double getProperty_cost() {
            return property_cost;
        }

        public void setProperty_cost(double property_cost) {
            this.property_cost = property_cost;
        }

        public String getHeat_supply() {
            return heat_supply;
        }

        public void setHeat_supply(String heat_supply) {
            this.heat_supply = heat_supply;
        }

        public String getPower_supply() {
            return power_supply;
        }

        public void setPower_supply(String power_supply) {
            this.power_supply = power_supply;
        }

        public String getWater_supply() {
            return water_supply;
        }

        public void setWater_supply(String water_supply) {
            this.water_supply = water_supply;
        }

        public String getProvince_name() {
            return province_name;
        }

        public void setProvince_name(String province_name) {
            this.province_name = province_name;
        }

        public String getCity_name() {
            return city_name;
        }

        public void setCity_name(String city_name) {
            this.city_name = city_name;
        }

        public String getDistrict_name() {
            return district_name;
        }

        public void setDistrict_name(String district_name) {
            this.district_name = district_name;
        }

        public List<String> getProperty() {
            return property;
        }

        public void setProperty(List<String> property) {
            this.property = property;
        }

        public List<SalePermitBean> getSale_permit() {
            return sale_permit;
        }

        public void setSale_permit(List<SalePermitBean> sale_permit) {
            this.sale_permit = sale_permit;
        }

        public static class SalePermitBean {
            /**
             * sale_permit : EDWETTDD
             * permit_time : 2018-06-04
             */

            private String sale_permit;
            private String permit_time;

            public String getSale_permit() {
                return sale_permit;
            }

            public void setSale_permit(String sale_permit) {
                this.sale_permit = sale_permit;
            }

            public String getPermit_time() {
                return permit_time;
            }

            public void setPermit_time(String permit_time) {
                this.permit_time = permit_time;
            }
        }
    }
}
