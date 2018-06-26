package com.ccsoft.yunqudao.bean;

public class WorkBean {

    /**
     * code : 200
     * msg : 查询成功
     * data : {"recommend":{"value":6,"total":8,"disabled":1},"preparation":{"value":1,"total":6,"disabled":5},"deal":{"value":1,"total":1,"disabled":0}}
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
         * recommend : {"value":6,"total":8,"disabled":1}
         * preparation : {"value":1,"total":6,"disabled":5}
         * deal : {"value":1,"total":1,"disabled":0}
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
             * value : 6
             * total : 8
             * disabled : 1
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
             * value : 1
             * total : 6
             * disabled : 5
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

        public static class DealBean {
            /**
             * value : 1
             * total : 1
             * disabled : 0
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
    }
}
