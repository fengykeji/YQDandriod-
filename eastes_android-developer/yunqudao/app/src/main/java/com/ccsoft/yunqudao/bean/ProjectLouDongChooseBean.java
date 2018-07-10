package com.ccsoft.yunqudao.bean;

import java.util.List;

public class ProjectLouDongChooseBean {


    /**
     * code : 200
     * msg : 查询成功
     * data : [{"LDID":"31","LDBM":"5","LDMC":"5栋","DYLIST":[],"build_info":{"build_name":"2栋","total_house_num":1,"upper_floor_num":11,"down_floor_num":1,"open_way":"网上开盘","handing_room_time":"2018-06-05","ys_build_id":31,"open_time":"2018-06-12"}},{"LDID":"49","LDBM":"12","LDMC":"12栋","DYLIST":[{"DYID":"16","DYBM":"1","DYMC":"一单元"}],"build_info":{"build_name":"3栋","total_house_num":2,"upper_floor_num":1,"down_floor_num":1,"open_way":"线下开盘","handing_room_time":"2018-06-03","ys_build_id":49,"open_time":"2018-06-02"}}]
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
        /**
         * LDID : 31
         * LDBM : 5
         * LDMC : 5栋
         * DYLIST : []
         * build_info : {"build_name":"2栋","total_house_num":1,"upper_floor_num":11,"down_floor_num":1,"open_way":"网上开盘","handing_room_time":"2018-06-05","ys_build_id":31,"open_time":"2018-06-12"}
         */

        private String LDID;
        private String LDBM;
        private String LDMC;
        private BuildInfoBean build_info;
        private List<DYBean> DYLIST;

        public String getLDID() {
            return LDID;
        }

        public void setLDID(String LDID) {
            this.LDID = LDID;
        }

        public String getLDBM() {
            return LDBM;
        }

        public void setLDBM(String LDBM) {
            this.LDBM = LDBM;
        }

        public String getLDMC() {
            return LDMC;
        }

        public void setLDMC(String LDMC) {
            this.LDMC = LDMC;
        }

        public BuildInfoBean getBuild_info() {
            return build_info;
        }

        public void setBuild_info(BuildInfoBean build_info) {
            this.build_info = build_info;
        }

        public List<DYBean> getDYLIST() {
            return DYLIST;
        }

        public void setDYLIST(List<DYBean> DYLIST) {
            this.DYLIST = DYLIST;
        }

        public static class DYBean{
            private String DYID;
            private String DYBM;
            private String DYMC;

            public void setDYID(String DYID) {
                this.DYID = DYID;
            }

            public void setDYBM(String DYBM) {
                this.DYBM = DYBM;
            }

            public void setDYMC(String DYMC) {
                this.DYMC = DYMC;
            }

            public String getDYID() {

                return DYID;
            }

            public String getDYBM() {
                return DYBM;
            }

            public String getDYMC() {
                return DYMC;
            }



        }

        public static class BuildInfoBean {
            /**
             * build_name : 2栋
             * total_house_num : 1
             * upper_floor_num : 11
             * down_floor_num : 1
             * open_way : 网上开盘
             * handing_room_time : 2018-06-05
             * ys_build_id : 31
             * open_time : 2018-06-12
             */

            private String build_name;
            private int total_house_num;
            private int upper_floor_num;
            private int down_floor_num;
            private String open_way;
            private String handing_room_time;
            private int ys_build_id;
            private String open_time;

            public String getBuild_name() {
                return build_name;
            }

            public void setBuild_name(String build_name) {
                this.build_name = build_name;
            }

            public int getTotal_house_num() {
                return total_house_num;
            }

            public void setTotal_house_num(int total_house_num) {
                this.total_house_num = total_house_num;
            }

            public int getUpper_floor_num() {
                return upper_floor_num;
            }

            public void setUpper_floor_num(int upper_floor_num) {
                this.upper_floor_num = upper_floor_num;
            }

            public int getDown_floor_num() {
                return down_floor_num;
            }

            public void setDown_floor_num(int down_floor_num) {
                this.down_floor_num = down_floor_num;
            }

            public String getOpen_way() {
                return open_way;
            }

            public void setOpen_way(String open_way) {
                this.open_way = open_way;
            }

            public String getHanding_room_time() {
                return handing_room_time;
            }

            public void setHanding_room_time(String handing_room_time) {
                this.handing_room_time = handing_room_time;
            }

            public int getYs_build_id() {
                return ys_build_id;
            }

            public void setYs_build_id(int ys_build_id) {
                this.ys_build_id = ys_build_id;
            }

            public String getOpen_time() {
                return open_time;
            }

            public void setOpen_time(String open_time) {
                this.open_time = open_time;
            }
        }
    }
}
