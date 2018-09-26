package com.ccsoft.yunqudao.bean;

import java.util.List;

public class GetCompanyListBean {

    /**
     * code : 200
     * msg : 查询成功
     * data : {"current_page":1,"data":[{"company_id":1,"company_name":"四川云算科技","province":"510000","city":"510100","district":"510100","absolute_address":"某某某街某某某号","contact":"切格瓦拉","contact_tel":null,"logo":"uploadFile/provide/code/1521799786_55.png","comment":"这李是个备注"},{"company_id":2,"company_name":"链家","province":"510000","city":"510100","district":"510100","absolute_address":"吃吃吃吃吃皮","contact":"切格瓦拉","contact_tel":null,"logo":"uploadFile/provide/code/1521799786_55.png","comment":"这李是个备注"},{"company_id":4,"company_name":"大唐","province":"","city":"","district":"","absolute_address":"","contact":"","contact_tel":null,"logo":null,"comment":""},{"company_id":5,"company_name":"测试分销公司5","province":"","city":"","district":"","absolute_address":"","contact":"","contact_tel":null,"logo":null,"comment":""},{"company_id":6,"company_name":"测试分销公司6","province":"","city":"","district":"","absolute_address":"","contact":"","contact_tel":null,"logo":null,"comment":""},{"company_id":10,"company_name":"四川佳林兴房地产营销策划有限公司","province":"","city":"","district":"","absolute_address":"","contact":"","contact_tel":null,"logo":null,"comment":""}],"first_page_url":"http://127.0.0.1:2797/lumen/public/index.php/agent/personal/getCompanyList?page=1","from":1,"last_page":1,"last_page_url":"http://127.0.0.1:2797/lumen/public/index.php/agent/personal/getCompanyList?page=1","next_page_url":null,"path":"http://127.0.0.1:2797/lumen/public/index.php/agent/personal/getCompanyList","per_page":15,"prev_page_url":null,"to":6,"total":6}
     */

    private int code;
    private String msg;
    private DataBeanX data;

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

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public static class DataBeanX {
        /**
         * current_page : 1
         * data : [{"company_id":1,"company_name":"四川云算科技","province":"510000","city":"510100","district":"510100","absolute_address":"某某某街某某某号","contact":"切格瓦拉","contact_tel":null,"logo":"uploadFile/provide/code/1521799786_55.png","comment":"这李是个备注"},{"company_id":2,"company_name":"链家","province":"510000","city":"510100","district":"510100","absolute_address":"吃吃吃吃吃皮","contact":"切格瓦拉","contact_tel":null,"logo":"uploadFile/provide/code/1521799786_55.png","comment":"这李是个备注"},{"company_id":4,"company_name":"大唐","province":"","city":"","district":"","absolute_address":"","contact":"","contact_tel":null,"logo":null,"comment":""},{"company_id":5,"company_name":"测试分销公司5","province":"","city":"","district":"","absolute_address":"","contact":"","contact_tel":null,"logo":null,"comment":""},{"company_id":6,"company_name":"测试分销公司6","province":"","city":"","district":"","absolute_address":"","contact":"","contact_tel":null,"logo":null,"comment":""},{"company_id":10,"company_name":"四川佳林兴房地产营销策划有限公司","province":"","city":"","district":"","absolute_address":"","contact":"","contact_tel":null,"logo":null,"comment":""}]
         * first_page_url : http://127.0.0.1:2797/lumen/public/index.php/agent/personal/getCompanyList?page=1
         * from : 1
         * last_page : 1
         * last_page_url : http://127.0.0.1:2797/lumen/public/index.php/agent/personal/getCompanyList?page=1
         * next_page_url : null
         * path : http://127.0.0.1:2797/lumen/public/index.php/agent/personal/getCompanyList
         * per_page : 15
         * prev_page_url : null
         * to : 6
         * total : 6
         */

        private int current_page;
        private String first_page_url;
        private int from;
        private int last_page;
        private String last_page_url;
        private Object next_page_url;
        private String path;
        private int per_page;
        private Object prev_page_url;
        private int to;
        private int total;
        private List<DataBean> data;

        public int getCurrent_page() {
            return current_page;
        }

        public void setCurrent_page(int current_page) {
            this.current_page = current_page;
        }

        public String getFirst_page_url() {
            return first_page_url;
        }

        public void setFirst_page_url(String first_page_url) {
            this.first_page_url = first_page_url;
        }

        public int getFrom() {
            return from;
        }

        public void setFrom(int from) {
            this.from = from;
        }

        public int getLast_page() {
            return last_page;
        }

        public void setLast_page(int last_page) {
            this.last_page = last_page;
        }

        public String getLast_page_url() {
            return last_page_url;
        }

        public void setLast_page_url(String last_page_url) {
            this.last_page_url = last_page_url;
        }

        public Object getNext_page_url() {
            return next_page_url;
        }

        public void setNext_page_url(Object next_page_url) {
            this.next_page_url = next_page_url;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public int getPer_page() {
            return per_page;
        }

        public void setPer_page(int per_page) {
            this.per_page = per_page;
        }

        public Object getPrev_page_url() {
            return prev_page_url;
        }

        public void setPrev_page_url(Object prev_page_url) {
            this.prev_page_url = prev_page_url;
        }

        public int getTo() {
            return to;
        }

        public void setTo(int to) {
            this.to = to;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * company_id : 1
             * company_name : 四川云算科技
             * province : 510000
             * city : 510100
             * district : 510100
             * absolute_address : 某某某街某某某号
             * contact : 切格瓦拉
             * contact_tel : null
             * logo : uploadFile/provide/code/1521799786_55.png
             * comment : 这李是个备注
             */

            private int company_id;
            private String company_name;
            private String province;
            private String city;
            private String district;
            private String absolute_address;
            private String contact;
            private Object contact_tel;
            private String logo;
            private String comment;

            public int getCompany_id() {
                return company_id;
            }

            public void setCompany_id(int company_id) {
                this.company_id = company_id;
            }

            public String getCompany_name() {
                return company_name;
            }

            public void setCompany_name(String company_name) {
                this.company_name = company_name;
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

            public String getAbsolute_address() {
                return absolute_address;
            }

            public void setAbsolute_address(String absolute_address) {
                this.absolute_address = absolute_address;
            }

            public String getContact() {
                return contact;
            }

            public void setContact(String contact) {
                this.contact = contact;
            }

            public Object getContact_tel() {
                return contact_tel;
            }

            public void setContact_tel(Object contact_tel) {
                this.contact_tel = contact_tel;
            }

            public String getLogo() {
                return logo;
            }

            public void setLogo(String logo) {
                this.logo = logo;
            }

            public String getComment() {
                return comment;
            }

            public void setComment(String comment) {
                this.comment = comment;
            }
        }
    }
}
