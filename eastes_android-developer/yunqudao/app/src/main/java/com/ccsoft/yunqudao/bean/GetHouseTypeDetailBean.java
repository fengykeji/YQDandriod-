package com.ccsoft.yunqudao.bean;

import java.io.Serializable;
import java.util.List;

public class GetHouseTypeDetailBean implements Serializable{


    /**
     * code : 200
     * msg : 查询成功
     * data : {"total":"20","rows":[{"ID":"20","RYBH":"5","RYXM":"朱萍","RYDH":"13086680768","RYTP":"","GSMC":"销售代理公司"},{"ID":"21","RYBH":"6","RYXM":"郑爽","RYDH":"17313105370","RYTP":"../UploadFile/201701180601117402281.png","GSMC":"销售代理公司"},{"ID":"22","RYBH":"7","RYXM":"周静","RYDH":"15228817010","RYTP":"","GSMC":"销售代理公司"},{"ID":"23","RYBH":"8","RYXM":"申旭","RYDH":"13688381071","RYTP":"","GSMC":"销售代理公司"},{"ID":"24","RYBH":"30","RYXM":"李雨","RYDH":"18581858465","RYTP":"","GSMC":"销售代理公司"},{"ID":"25","RYBH":"10","RYXM":"黎超","RYDH":"18280466188","RYTP":"","GSMC":"销售代理公司"},{"ID":"26","RYBH":"11","RYXM":"熊容霜","RYDH":"13709076054","RYTP":"","GSMC":"销售代理公司"},{"ID":"27","RYBH":"12","RYXM":"李静","RYDH":"13568604416","RYTP":"","GSMC":"销售代理公司"},{"ID":"28","RYBH":"13","RYXM":"马在银","RYDH":"18583996531","RYTP":"","GSMC":"销售代理公司"},{"ID":"29","RYBH":"14","RYXM":"刘倩婷","RYDH":"18308466339","RYTP":"","GSMC":"销售代理公司"},{"ID":"69","RYBH":"20464595","RYXM":"王欢","RYDH":"18215578319","RYTP":"","GSMC":"销售代理公司"},{"ID":"70","RYBH":"20463335","RYXM":"巫沁瑞","RYDH":"18200596135","RYTP":"","GSMC":"销售代理公司"},{"ID":"71","RYBH":"20461821","RYXM":"李梅","RYDH":"18215600198","RYTP":"","GSMC":"销售代理公司"},{"ID":"72","RYBH":"20464824","RYXM":"王雪梅","RYDH":"13551046412","RYTP":"","GSMC":"销售代理公司"},{"ID":"74","RYBH":"204655366","RYXM":"刘丽","RYDH":"13880282384","RYTP":"","GSMC":"销售代理公司"},{"ID":"125","RYBH":"20273297","RYXM":"张鸿飞","RYDH":"13699417770","RYTP":"","GSMC":"销售代理公司"},{"ID":"126","RYBH":"202742783","RYXM":"彭芳芳","RYDH":"15184461976","RYTP":"","GSMC":"销售代理公司"},{"ID":"127","RYBH":"202730905","RYXM":"李旺康","RYDH":"18682751615","RYTP":"","GSMC":"销售代理公司"},{"ID":"138","RYBH":"206123969","RYXM":"置业顾问","RYDH":"13500000001","RYTP":"","GSMC":"营销策划部（甲方）"},{"ID":"143","RYBH":"204446767","RYXM":"薛俊","RYDH":"18780076166","RYTP":"","GSMC":"销售代理公司"}],"advicer_select":1,"tel_complete_state":0}
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

    public static class DataBean implements Serializable{
        /**
         * total : 20
         * rows : [{"ID":"20","RYBH":"5","RYXM":"朱萍","RYDH":"13086680768","RYTP":"","GSMC":"销售代理公司"},{"ID":"21","RYBH":"6","RYXM":"郑爽","RYDH":"17313105370","RYTP":"../UploadFile/201701180601117402281.png","GSMC":"销售代理公司"},{"ID":"22","RYBH":"7","RYXM":"周静","RYDH":"15228817010","RYTP":"","GSMC":"销售代理公司"},{"ID":"23","RYBH":"8","RYXM":"申旭","RYDH":"13688381071","RYTP":"","GSMC":"销售代理公司"},{"ID":"24","RYBH":"30","RYXM":"李雨","RYDH":"18581858465","RYTP":"","GSMC":"销售代理公司"},{"ID":"25","RYBH":"10","RYXM":"黎超","RYDH":"18280466188","RYTP":"","GSMC":"销售代理公司"},{"ID":"26","RYBH":"11","RYXM":"熊容霜","RYDH":"13709076054","RYTP":"","GSMC":"销售代理公司"},{"ID":"27","RYBH":"12","RYXM":"李静","RYDH":"13568604416","RYTP":"","GSMC":"销售代理公司"},{"ID":"28","RYBH":"13","RYXM":"马在银","RYDH":"18583996531","RYTP":"","GSMC":"销售代理公司"},{"ID":"29","RYBH":"14","RYXM":"刘倩婷","RYDH":"18308466339","RYTP":"","GSMC":"销售代理公司"},{"ID":"69","RYBH":"20464595","RYXM":"王欢","RYDH":"18215578319","RYTP":"","GSMC":"销售代理公司"},{"ID":"70","RYBH":"20463335","RYXM":"巫沁瑞","RYDH":"18200596135","RYTP":"","GSMC":"销售代理公司"},{"ID":"71","RYBH":"20461821","RYXM":"李梅","RYDH":"18215600198","RYTP":"","GSMC":"销售代理公司"},{"ID":"72","RYBH":"20464824","RYXM":"王雪梅","RYDH":"13551046412","RYTP":"","GSMC":"销售代理公司"},{"ID":"74","RYBH":"204655366","RYXM":"刘丽","RYDH":"13880282384","RYTP":"","GSMC":"销售代理公司"},{"ID":"125","RYBH":"20273297","RYXM":"张鸿飞","RYDH":"13699417770","RYTP":"","GSMC":"销售代理公司"},{"ID":"126","RYBH":"202742783","RYXM":"彭芳芳","RYDH":"15184461976","RYTP":"","GSMC":"销售代理公司"},{"ID":"127","RYBH":"202730905","RYXM":"李旺康","RYDH":"18682751615","RYTP":"","GSMC":"销售代理公司"},{"ID":"138","RYBH":"206123969","RYXM":"置业顾问","RYDH":"13500000001","RYTP":"","GSMC":"营销策划部（甲方）"},{"ID":"143","RYBH":"204446767","RYXM":"薛俊","RYDH":"18780076166","RYTP":"","GSMC":"销售代理公司"}]
         * advicer_select : 1
         * tel_complete_state : 0
         */

        private String total;
        private int advicer_selected;
        private int tel_complete_state;
        private String project_name;

        public String getProject_name() {
            return project_name;
        }

        public int getAdvicer_selected() {

            return advicer_selected;
        }

        private List<RowsBean> rows;

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public int getAdvicer_select() {
            return advicer_selected;
        }

        public void setAdvicer_select(int advicer_select) {
            this.advicer_selected = advicer_select;
        }

        public int getTel_complete_state() {
            return tel_complete_state;
        }

        public void setTel_complete_state(int tel_complete_state) {
            this.tel_complete_state = tel_complete_state;
        }

        public List<RowsBean> getRows() {
            return rows;
        }

        public void setRows(List<RowsBean> rows) {
            this.rows = rows;
        }

        public static class RowsBean implements Serializable{
            /**
             * ID : 20
             * RYBH : 5
             * RYXM : 朱萍
             * RYDH : 13086680768
             * RYTP :
             * GSMC : 销售代理公司
             */

            private String ID;
            private String RYBH;
            private String RYXM;
            private String RYDH;
            private String RYTP;
            private String GSMC;

            public String getID() {
                return ID;
            }

            public void setID(String ID) {
                this.ID = ID;
            }

            public String getRYBH() {
                return RYBH;
            }

            public void setRYBH(String RYBH) {
                this.RYBH = RYBH;
            }

            public String getRYXM() {
                return RYXM;
            }

            public void setRYXM(String RYXM) {
                this.RYXM = RYXM;
            }

            public String getRYDH() {
                return RYDH;
            }

            public void setRYDH(String RYDH) {
                this.RYDH = RYDH;
            }

            public String getRYTP() {
                return RYTP;
            }

            public void setRYTP(String RYTP) {
                this.RYTP = RYTP;
            }

            public String getGSMC() {
                return GSMC;
            }

            public void setGSMC(String GSMC) {
                this.GSMC = GSMC;
            }
        }
    }
}
