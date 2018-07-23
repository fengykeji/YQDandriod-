package com.ccsoft.yunqudao.bean;

public class GetUnreadBean {

    /**
     * code : 200
     * msg : 查询成功
     * data : {"system":{"total":0,"read":0},"work":{"total":58,"read":0}}
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
         * system : {"total":0,"read":0}
         * work : {"total":58,"read":0}
         */

        private SystemBean system;
        private WorkBean work;

        public SystemBean getSystem() {
            return system;
        }

        public void setSystem(SystemBean system) {
            this.system = system;
        }

        public WorkBean getWork() {
            return work;
        }

        public void setWork(WorkBean work) {
            this.work = work;
        }

        public static class SystemBean {
            /**
             * total : 0
             * read : 0
             */

            private int total;
            private int read;

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public int getRead() {
                return read;
            }

            public void setRead(int read) {
                this.read = read;
            }
        }

        public static class WorkBean {
            /**
             * total : 58
             * read : 0
             */

            private int total;
            private int read;

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public int getRead() {
                return read;
            }

            public void setRead(int read) {
                this.read = read;
            }
        }
    }
}
