package com.ccsoft.yunqudao.bean;

public class WorkBean {


    /**
     * code : 200
     * msg : 查询成功
     * data : {"recommend":{"value":5,"total":18,"disabled":13},"preparation":{"disabled":1,"count":5,"value":4},"deal":{"total":4,"disabled":1,"value":3}}
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
         * recommend : {"value":5,"total":18,"disabled":13}
         * preparation : {"disabled":1,"count":5,"value":4}
         * deal : {"total":4,"disabled":1,"value":3}
         */

        private RecommendBean recommend;
        private PreparationBean preparation;
        private DealBean deal;

        public RecommendBean getRecommend() {
            return recommend;
        }

        public void setRecommend(RecommendBean recommend) {
            this.recommend = recommend;
        }

        public PreparationBean getPreparation() {
            return preparation;
        }

        public void setPreparation(PreparationBean preparation) {
            this.preparation = preparation;
        }

        public DealBean getDeal() {
            return deal;
        }

        public void setDeal(DealBean deal) {
            this.deal = deal;
        }

        public static class RecommendBean {
            /**
             * value : 5
             * total : 18
             * disabled : 13
             */

            private int value;
            private int total;
            private int disabled;

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public int getDisabled() {
                return disabled;
            }

            public void setDisabled(int disabled) {
                this.disabled = disabled;
            }
        }

        public static class PreparationBean {
            /**
             * disabled : 1
             * count : 5
             * value : 4
             */

            private int disabled;
            private int total;
            private int value;

            public int getDisabled() {
                return disabled;
            }

            public void setDisabled(int disabled) {
                this.disabled = disabled;
            }

            public int getTotal() {
                return total;
            }

            public void setTotal(int count) {
                this.total = count;
            }

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }
        }

        public static class DealBean {
            /**
             * total : 4
             * disabled : 1
             * value : 3
             */

            private int total;
            private int disabled;
            private int value;

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public int getDisabled() {
                return disabled;
            }

            public void setDisabled(int disabled) {
                this.disabled = disabled;
            }

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }
        }
    }
}
