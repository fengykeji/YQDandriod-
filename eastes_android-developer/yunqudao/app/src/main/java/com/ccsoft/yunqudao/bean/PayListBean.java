package com.ccsoft.yunqudao.bean;

public class PayListBean {


    /**
     * code : 200
     * msg : 查询成功
     * data : {"total":30297,"is_pay":{"count":0,"total":0},"un_pay":{"count":30297,"total":9}}
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
         * total : 30297
         * is_pay : {"count":0,"total":0}
         * un_pay : {"count":30297,"total":9}
         */

        private int total;
        private IsPayBean is_pay;
        private UnPayBean un_pay;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public IsPayBean getIs_pay() {
            return is_pay;
        }

        public void setIs_pay(IsPayBean is_pay) {
            this.is_pay = is_pay;
        }

        public UnPayBean getUn_pay() {
            return un_pay;
        }

        public void setUn_pay(UnPayBean un_pay) {
            this.un_pay = un_pay;
        }

        public static class IsPayBean {
            /**
             * count : 0
             * total : 0
             */

            private int count;
            private int total;

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }
        }

        public static class UnPayBean {
            /**
             * count : 30297
             * total : 9
             */

            private int count;
            private int total;

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }
        }
    }
}
