package com.ccsoft.yunqudao.bean;

import java.io.Serializable;
import java.util.List;

public class GetHouseTypeDetailBean implements Serializable{

    /**
     * code : 200
     * msg : 查询成功
     * data : {"total":"19","rows":[{"ID":"20","RYBH":"5","RYXM":"朱萍","RYDH":"13086680768","RYTP":""},{"ID":"21","RYBH":"6","RYXM":"郑爽","RYDH":"17313105370","RYTP":"../UploadFile/201701180601117402281.png"},{"ID":"22","RYBH":"7","RYXM":"周静","RYDH":"15228817010","RYTP":""},{"ID":"23","RYBH":"8","RYXM":"申旭","RYDH":"13688381071","RYTP":""},{"ID":"24","RYBH":"30","RYXM":"李雨","RYDH":"18581858465","RYTP":""},{"ID":"25","RYBH":"10","RYXM":"黎超","RYDH":"18280466188","RYTP":""},{"ID":"26","RYBH":"11","RYXM":"熊容霜","RYDH":"13709076054","RYTP":""},{"ID":"27","RYBH":"12","RYXM":"李静","RYDH":"13568604416","RYTP":""},{"ID":"28","RYBH":"13","RYXM":"马在银","RYDH":"18583996531","RYTP":""},{"ID":"29","RYBH":"14","RYXM":"刘倩婷","RYDH":"18308466339","RYTP":""},{"ID":"69","RYBH":"20464595","RYXM":"王欢","RYDH":"18215578319","RYTP":""},{"ID":"70","RYBH":"20463335","RYXM":"巫沁瑞","RYDH":"18200596135","RYTP":""},{"ID":"71","RYBH":"20461821","RYXM":"李梅","RYDH":"18215600198","RYTP":""},{"ID":"72","RYBH":"20464824","RYXM":"王雪梅","RYDH":"13551046412","RYTP":""},{"ID":"74","RYBH":"204655366","RYXM":"刘丽","RYDH":"13880282384","RYTP":""},{"ID":"125","RYBH":"20273297","RYXM":"张鸿飞","RYDH":"13699417770","RYTP":""},{"ID":"126","RYBH":"202742783","RYXM":"彭芳芳","RYDH":"15184461976","RYTP":""},{"ID":"127","RYBH":"202730905","RYXM":"李旺康","RYDH":"18682751615","RYTP":""},{"ID":"138","RYBH":"206123969","RYXM":"置业顾问","RYDH":"13500000001","RYTP":""}]}
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
         * total : 19
         * rows : [{"ID":"20","RYBH":"5","RYXM":"朱萍","RYDH":"13086680768","RYTP":""},{"ID":"21","RYBH":"6","RYXM":"郑爽","RYDH":"17313105370","RYTP":"../UploadFile/201701180601117402281.png"},{"ID":"22","RYBH":"7","RYXM":"周静","RYDH":"15228817010","RYTP":""},{"ID":"23","RYBH":"8","RYXM":"申旭","RYDH":"13688381071","RYTP":""},{"ID":"24","RYBH":"30","RYXM":"李雨","RYDH":"18581858465","RYTP":""},{"ID":"25","RYBH":"10","RYXM":"黎超","RYDH":"18280466188","RYTP":""},{"ID":"26","RYBH":"11","RYXM":"熊容霜","RYDH":"13709076054","RYTP":""},{"ID":"27","RYBH":"12","RYXM":"李静","RYDH":"13568604416","RYTP":""},{"ID":"28","RYBH":"13","RYXM":"马在银","RYDH":"18583996531","RYTP":""},{"ID":"29","RYBH":"14","RYXM":"刘倩婷","RYDH":"18308466339","RYTP":""},{"ID":"69","RYBH":"20464595","RYXM":"王欢","RYDH":"18215578319","RYTP":""},{"ID":"70","RYBH":"20463335","RYXM":"巫沁瑞","RYDH":"18200596135","RYTP":""},{"ID":"71","RYBH":"20461821","RYXM":"李梅","RYDH":"18215600198","RYTP":""},{"ID":"72","RYBH":"20464824","RYXM":"王雪梅","RYDH":"13551046412","RYTP":""},{"ID":"74","RYBH":"204655366","RYXM":"刘丽","RYDH":"13880282384","RYTP":""},{"ID":"125","RYBH":"20273297","RYXM":"张鸿飞","RYDH":"13699417770","RYTP":""},{"ID":"126","RYBH":"202742783","RYXM":"彭芳芳","RYDH":"15184461976","RYTP":""},{"ID":"127","RYBH":"202730905","RYXM":"李旺康","RYDH":"18682751615","RYTP":""},{"ID":"138","RYBH":"206123969","RYXM":"置业顾问","RYDH":"13500000001","RYTP":""}]
         */

        private String total;
        private List<RowsBean> rows;

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
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
             */

            private String ID;
            private String RYBH;
            private String RYXM;
            private String RYDH;
            private String RYTP;

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
        }
    }
}
