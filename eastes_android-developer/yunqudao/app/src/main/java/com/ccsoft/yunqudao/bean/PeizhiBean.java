package com.ccsoft.yunqudao.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PeizhiBean {

    /**
     * code : 200
     * msg : 查询成功
     * data : {"1":{"type":"银行类型","param":[{"id":1,"param":"中国农业银行"},{"id":2,"param":"中国建设银行"},{"id":3,"param":"中国工商银行"},{"id":4,"param":"中国银行"},{"id":5,"param":"交通银行"},{"id":6,"param":"招商银行"},{"id":7,"param":"邮政储蓄银行"},{"id":8,"param":"光大银行"},{"id":9,"param":"民生银行"},{"id":10,"param":"平安银行"},{"id":11,"param":"浦发银行"},{"id":12,"param":"中心银行"},{"id":13,"param":"兴业银行"},{"id":14,"param":"华夏银行"},{"id":15,"param":"北京银行"},{"id":16,"param":"成都农商银行"},{"id":71,"param":"中国招商银行"}]},"2":{"type":"证件类型","param":[{"id":17,"param":"身份证"}]},"3":{"type":"提成方式","param":[{"id":18,"param":"固定金额X套数"},{"id":19,"param":"销售价格X比例"},{"id":20,"param":"面积X单价"}]},"4":{"type":"投诉类型","param":[{"id":21,"param":"客源无效"},{"id":22,"param":"其他"}]},"5":{"type":"投诉解决类型","param":[{"id":23,"param":"客源有效"},{"id":24,"param":"其他"}]},"6":{"type":"合同终止原因","param":[{"id":25,"param":"合同到期"},{"id":26,"param":"强制终止"}]},"7":{"type":"禁用类型","param":[{"id":27,"param":"非法交易"},{"id":28,"param":"利用漏洞"}]},"8":{"type":"房龄","param":[{"id":29,"param":"一年以内"},{"id":30,"param":"三年以内"},{"id":31,"param":"十年以内"}]},"9":{"type":"住房类型","param":[{"id":32,"param":"3室2厅2卫"},{"id":33,"param":"1室1厅2卫"},{"id":106,"param":"1室1厅1卫"},{"id":141,"param":"3室2厅1卫"},{"id":142,"param":"2室2卫1厅"}]},"10":{"type":"货币类型","param":[{"id":34,"param":"人民币"},{"id":35,"param":"美元"},{"id":36,"param":"日元"},{"id":37,"param":"港币"},{"id":38,"param":"英镑"},{"id":39,"param":"欧元"}]},"11":{"type":"开盘方式","param":[{"id":40,"param":"网上开盘"},{"id":41,"param":"线下开盘"},{"id":42,"param":"其他"}]},"12":{"type":"置业目的","param":[{"id":43,"param":"投资"},{"id":44,"param":"自住"},{"id":45,"param":"投资兼自住"}]},"13":{"type":"付款方式","param":[{"id":46,"param":"一次性付款"},{"id":47,"param":"公积金贷款"},{"id":48,"param":"综合贷款"},{"id":49,"param":"银行按揭贷款"},{"id":50,"param":"分期付款"}]},"14":{"type":"项目图片类型","param":[{"id":52,"param":"3D图"},{"id":53,"param":"效果图"},{"id":54,"param":"平面图"},{"id":55,"param":"实景图"}]},"15":{"type":"项目标签","param":[{"id":56,"param":"学区房"},{"id":57,"param":"五证齐全"},{"id":58,"param":"地铁房"},{"id":104,"param":"车位充足"},{"id":105,"param":"品牌房企"},{"id":125,"param":"涪江畔"},{"id":126,"param":"三幼旁"},{"id":127,"param":"大社区"},{"id":130,"param":"农产品批发"},{"id":131,"param":"综合体购物"},{"id":132,"param":"地铁8号线"},{"id":134,"param":"高铁站前"},{"id":135,"param":"5.1米跃层微墅"},{"id":136,"param":"全时商业潮圣地"},{"id":137,"param":"欢乐海底世界"}]},"16":{"type":"物业类型","param":[{"id":59,"param":"住宅"},{"id":60,"param":"公寓"},{"id":61,"param":"别墅"},{"id":62,"param":"商铺"},{"id":63,"param":"写字楼"},{"id":64,"param":"车位"},{"id":138,"param":"微墅"},{"id":139,"param":"商墅"}]},"17":{"type":"建筑类型","param":[{"id":66,"param":"板楼"},{"id":65,"param":"钢混"},{"id":67,"param":"砖混"},{"id":68,"param":"砖木"},{"id":69,"param":"钢结构"},{"id":70,"param":"其他"},{"id":124,"param":"框剪"},{"id":133,"param":"剪力墙"}]},"18":{"type":"用户失效类型","param":[{"id":72,"param":"自然失效"},{"id":73,"param":"置业顾问判断无效"},{"id":74,"param":"销售业内判断无效"},{"id":110,"param":"开发商判断无效"}]},"19":{"type":"朝向","param":[{"id":75,"param":"西南"},{"id":76,"param":"东南"},{"id":77,"param":"西北"}]},"20":{"type":"梯户比","param":[{"id":78,"param":"1：1"},{"id":79,"param":"1：2"}]},"21":{"type":"装修标准","param":[{"id":80,"param":"毛坯"},{"id":81,"param":"简装"},{"id":82,"param":"精装"}]},"22":{"type":"均价","param":[{"id":85,"param":"10000-15000"},{"id":83,"param":"5000-8000"},{"id":84,"param":"8000-1000"}]},"23":{"type":"跟进方式","param":[{"id":86,"param":"电话"},{"id":87,"param":"QQ"},{"id":88,"param":"微信"},{"id":89,"param":"面谈"},{"id":90,"param":"其他"}]},"25":{"type":"总价","param":[{"id":91,"param":"50"},{"id":92,"param":"50-80"},{"id":93,"param":"80-120"},{"id":94,"param":"120-200"},{"id":95,"param":"200"}]},"24":{"type":"申述类型","param":[{"id":108,"param":"申述类型2"},{"id":109,"param":"申述类型3"},{"id":107,"param":"申述类型1"}]},"26":{"type":"面积","param":[{"id":96,"param":"50"},{"id":97,"param":"50-90"},{"id":98,"param":"90-130"},{"id":99,"param":"130-150"},{"id":100,"param":"150"}]},"27":{"type":"佣金结算失败原因","param":[{"id":101,"param":"缺少银行卡信息"},{"id":102,"param":"银行卡打款失败"},{"id":103,"param":"其他"}]},"28":{"type":"客服电话","param":[{"id":128,"param":"15082245107"},{"id":129,"param":"15983804767"}]}}
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
         * 1 : {"type":"银行类型","param":[{"id":1,"param":"中国农业银行"},{"id":2,"param":"中国建设银行"},{"id":3,"param":"中国工商银行"},{"id":4,"param":"中国银行"},{"id":5,"param":"交通银行"},{"id":6,"param":"招商银行"},{"id":7,"param":"邮政储蓄银行"},{"id":8,"param":"光大银行"},{"id":9,"param":"民生银行"},{"id":10,"param":"平安银行"},{"id":11,"param":"浦发银行"},{"id":12,"param":"中心银行"},{"id":13,"param":"兴业银行"},{"id":14,"param":"华夏银行"},{"id":15,"param":"北京银行"},{"id":16,"param":"成都农商银行"},{"id":71,"param":"中国招商银行"}]}
         * 2 : {"type":"证件类型","param":[{"id":17,"param":"身份证"}]}
         * 3 : {"type":"提成方式","param":[{"id":18,"param":"固定金额X套数"},{"id":19,"param":"销售价格X比例"},{"id":20,"param":"面积X单价"}]}
         * 4 : {"type":"投诉类型","param":[{"id":21,"param":"客源无效"},{"id":22,"param":"其他"}]}
         * 5 : {"type":"投诉解决类型","param":[{"id":23,"param":"客源有效"},{"id":24,"param":"其他"}]}
         * 6 : {"type":"合同终止原因","param":[{"id":25,"param":"合同到期"},{"id":26,"param":"强制终止"}]}
         * 7 : {"type":"禁用类型","param":[{"id":27,"param":"非法交易"},{"id":28,"param":"利用漏洞"}]}
         * 8 : {"type":"房龄","param":[{"id":29,"param":"一年以内"},{"id":30,"param":"三年以内"},{"id":31,"param":"十年以内"}]}
         * 9 : {"type":"住房类型","param":[{"id":32,"param":"3室2厅2卫"},{"id":33,"param":"1室1厅2卫"},{"id":106,"param":"1室1厅1卫"},{"id":141,"param":"3室2厅1卫"},{"id":142,"param":"2室2卫1厅"}]}
         * 10 : {"type":"货币类型","param":[{"id":34,"param":"人民币"},{"id":35,"param":"美元"},{"id":36,"param":"日元"},{"id":37,"param":"港币"},{"id":38,"param":"英镑"},{"id":39,"param":"欧元"}]}
         * 11 : {"type":"开盘方式","param":[{"id":40,"param":"网上开盘"},{"id":41,"param":"线下开盘"},{"id":42,"param":"其他"}]}
         * 12 : {"type":"置业目的","param":[{"id":43,"param":"投资"},{"id":44,"param":"自住"},{"id":45,"param":"投资兼自住"}]}
         * 13 : {"type":"付款方式","param":[{"id":46,"param":"一次性付款"},{"id":47,"param":"公积金贷款"},{"id":48,"param":"综合贷款"},{"id":49,"param":"银行按揭贷款"},{"id":50,"param":"分期付款"}]}
         * 14 : {"type":"项目图片类型","param":[{"id":52,"param":"3D图"},{"id":53,"param":"效果图"},{"id":54,"param":"平面图"},{"id":55,"param":"实景图"}]}
         * 15 : {"type":"项目标签","param":[{"id":56,"param":"学区房"},{"id":57,"param":"五证齐全"},{"id":58,"param":"地铁房"},{"id":104,"param":"车位充足"},{"id":105,"param":"品牌房企"},{"id":125,"param":"涪江畔"},{"id":126,"param":"三幼旁"},{"id":127,"param":"大社区"},{"id":130,"param":"农产品批发"},{"id":131,"param":"综合体购物"},{"id":132,"param":"地铁8号线"},{"id":134,"param":"高铁站前"},{"id":135,"param":"5.1米跃层微墅"},{"id":136,"param":"全时商业潮圣地"},{"id":137,"param":"欢乐海底世界"}]}
         * 16 : {"type":"物业类型","param":[{"id":59,"param":"住宅"},{"id":60,"param":"公寓"},{"id":61,"param":"别墅"},{"id":62,"param":"商铺"},{"id":63,"param":"写字楼"},{"id":64,"param":"车位"},{"id":138,"param":"微墅"},{"id":139,"param":"商墅"}]}
         * 17 : {"type":"建筑类型","param":[{"id":66,"param":"板楼"},{"id":65,"param":"钢混"},{"id":67,"param":"砖混"},{"id":68,"param":"砖木"},{"id":69,"param":"钢结构"},{"id":70,"param":"其他"},{"id":124,"param":"框剪"},{"id":133,"param":"剪力墙"}]}
         * 18 : {"type":"用户失效类型","param":[{"id":72,"param":"自然失效"},{"id":73,"param":"置业顾问判断无效"},{"id":74,"param":"销售业内判断无效"},{"id":110,"param":"开发商判断无效"}]}
         * 19 : {"type":"朝向","param":[{"id":75,"param":"西南"},{"id":76,"param":"东南"},{"id":77,"param":"西北"}]}
         * 20 : {"type":"梯户比","param":[{"id":78,"param":"1：1"},{"id":79,"param":"1：2"}]}
         * 21 : {"type":"装修标准","param":[{"id":80,"param":"毛坯"},{"id":81,"param":"简装"},{"id":82,"param":"精装"}]}
         * 22 : {"type":"均价","param":[{"id":85,"param":"10000-15000"},{"id":83,"param":"5000-8000"},{"id":84,"param":"8000-1000"}]}
         * 23 : {"type":"跟进方式","param":[{"id":86,"param":"电话"},{"id":87,"param":"QQ"},{"id":88,"param":"微信"},{"id":89,"param":"面谈"},{"id":90,"param":"其他"}]}
         * 25 : {"type":"总价","param":[{"id":91,"param":"50"},{"id":92,"param":"50-80"},{"id":93,"param":"80-120"},{"id":94,"param":"120-200"},{"id":95,"param":"200"}]}
         * 24 : {"type":"申述类型","param":[{"id":108,"param":"申述类型2"},{"id":109,"param":"申述类型3"},{"id":107,"param":"申述类型1"}]}
         * 26 : {"type":"面积","param":[{"id":96,"param":"50"},{"id":97,"param":"50-90"},{"id":98,"param":"90-130"},{"id":99,"param":"130-150"},{"id":100,"param":"150"}]}
         * 27 : {"type":"佣金结算失败原因","param":[{"id":101,"param":"缺少银行卡信息"},{"id":102,"param":"银行卡打款失败"},{"id":103,"param":"其他"}]}
         * 28 : {"type":"客服电话","param":[{"id":128,"param":"15082245107"},{"id":129,"param":"15983804767"}]}
         */

        @SerializedName("1")
        private _$1Bean _$1;
        @SerializedName("2")
        private _$2Bean _$2;
        @SerializedName("3")
        private _$3Bean _$3;
        @SerializedName("4")
        private _$4Bean _$4;
        @SerializedName("5")
        private _$5Bean _$5;
        @SerializedName("6")
        private _$6Bean _$6;
        @SerializedName("7")
        private _$7Bean _$7;
        @SerializedName("8")
        private _$8Bean _$8;
        @SerializedName("9")
        private _$9Bean _$9;
        @SerializedName("10")
        private _$10Bean _$10;
        @SerializedName("11")
        private _$11Bean _$11;
        @SerializedName("12")
        private _$12Bean _$12;
        @SerializedName("13")
        private _$13Bean _$13;
        @SerializedName("14")
        private _$14Bean _$14;
        @SerializedName("15")
        private _$15Bean _$15;
        @SerializedName("16")
        private _$16Bean _$16;
        @SerializedName("17")
        private _$17Bean _$17;
        @SerializedName("18")
        private _$18Bean _$18;
        @SerializedName("19")
        private _$19Bean _$19;
        @SerializedName("20")
        private _$20Bean _$20;
        @SerializedName("21")
        private _$21Bean _$21;
        @SerializedName("22")
        private _$22Bean _$22;
        @SerializedName("23")
        private _$23Bean _$23;
        @SerializedName("25")
        private _$25Bean _$25;
        @SerializedName("24")
        private _$24Bean _$24;
        @SerializedName("26")
        private _$26Bean _$26;
        @SerializedName("27")
        private _$27Bean _$27;
        @SerializedName("28")
        private _$28Bean _$28;

        public _$1Bean get_$1() {
            return _$1;
        }

        public void set_$1(_$1Bean _$1) {
            this._$1 = _$1;
        }

        public _$2Bean get_$2() {
            return _$2;
        }

        public void set_$2(_$2Bean _$2) {
            this._$2 = _$2;
        }

        public _$3Bean get_$3() {
            return _$3;
        }

        public void set_$3(_$3Bean _$3) {
            this._$3 = _$3;
        }

        public _$4Bean get_$4() {
            return _$4;
        }

        public void set_$4(_$4Bean _$4) {
            this._$4 = _$4;
        }

        public _$5Bean get_$5() {
            return _$5;
        }

        public void set_$5(_$5Bean _$5) {
            this._$5 = _$5;
        }

        public _$6Bean get_$6() {
            return _$6;
        }

        public void set_$6(_$6Bean _$6) {
            this._$6 = _$6;
        }

        public _$7Bean get_$7() {
            return _$7;
        }

        public void set_$7(_$7Bean _$7) {
            this._$7 = _$7;
        }

        public _$8Bean get_$8() {
            return _$8;
        }

        public void set_$8(_$8Bean _$8) {
            this._$8 = _$8;
        }

        public _$9Bean get_$9() {
            return _$9;
        }

        public void set_$9(_$9Bean _$9) {
            this._$9 = _$9;
        }

        public _$10Bean get_$10() {
            return _$10;
        }

        public void set_$10(_$10Bean _$10) {
            this._$10 = _$10;
        }

        public _$11Bean get_$11() {
            return _$11;
        }

        public void set_$11(_$11Bean _$11) {
            this._$11 = _$11;
        }

        public _$12Bean get_$12() {
            return _$12;
        }

        public void set_$12(_$12Bean _$12) {
            this._$12 = _$12;
        }

        public _$13Bean get_$13() {
            return _$13;
        }

        public void set_$13(_$13Bean _$13) {
            this._$13 = _$13;
        }

        public _$14Bean get_$14() {
            return _$14;
        }

        public void set_$14(_$14Bean _$14) {
            this._$14 = _$14;
        }

        public _$15Bean get_$15() {
            return _$15;
        }

        public void set_$15(_$15Bean _$15) {
            this._$15 = _$15;
        }

        public _$16Bean get_$16() {
            return _$16;
        }

        public void set_$16(_$16Bean _$16) {
            this._$16 = _$16;
        }

        public _$17Bean get_$17() {
            return _$17;
        }

        public void set_$17(_$17Bean _$17) {
            this._$17 = _$17;
        }

        public _$18Bean get_$18() {
            return _$18;
        }

        public void set_$18(_$18Bean _$18) {
            this._$18 = _$18;
        }

        public _$19Bean get_$19() {
            return _$19;
        }

        public void set_$19(_$19Bean _$19) {
            this._$19 = _$19;
        }

        public _$20Bean get_$20() {
            return _$20;
        }

        public void set_$20(_$20Bean _$20) {
            this._$20 = _$20;
        }

        public _$21Bean get_$21() {
            return _$21;
        }

        public void set_$21(_$21Bean _$21) {
            this._$21 = _$21;
        }

        public _$22Bean get_$22() {
            return _$22;
        }

        public void set_$22(_$22Bean _$22) {
            this._$22 = _$22;
        }

        public _$23Bean get_$23() {
            return _$23;
        }

        public void set_$23(_$23Bean _$23) {
            this._$23 = _$23;
        }

        public _$25Bean get_$25() {
            return _$25;
        }

        public void set_$25(_$25Bean _$25) {
            this._$25 = _$25;
        }

        public _$24Bean get_$24() {
            return _$24;
        }

        public void set_$24(_$24Bean _$24) {
            this._$24 = _$24;
        }

        public _$26Bean get_$26() {
            return _$26;
        }

        public void set_$26(_$26Bean _$26) {
            this._$26 = _$26;
        }

        public _$27Bean get_$27() {
            return _$27;
        }

        public void set_$27(_$27Bean _$27) {
            this._$27 = _$27;
        }

        public _$28Bean get_$28() {
            return _$28;
        }

        public void set_$28(_$28Bean _$28) {
            this._$28 = _$28;
        }

        public static class _$1Bean {
            /**
             * type : 银行类型
             * param : [{"id":1,"param":"中国农业银行"},{"id":2,"param":"中国建设银行"},{"id":3,"param":"中国工商银行"},{"id":4,"param":"中国银行"},{"id":5,"param":"交通银行"},{"id":6,"param":"招商银行"},{"id":7,"param":"邮政储蓄银行"},{"id":8,"param":"光大银行"},{"id":9,"param":"民生银行"},{"id":10,"param":"平安银行"},{"id":11,"param":"浦发银行"},{"id":12,"param":"中心银行"},{"id":13,"param":"兴业银行"},{"id":14,"param":"华夏银行"},{"id":15,"param":"北京银行"},{"id":16,"param":"成都农商银行"},{"id":71,"param":"中国招商银行"}]
             */

            private String type;
            private List<ParamBean> param;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public List<ParamBean> getParam() {
                return param;
            }

            public void setParam(List<ParamBean> param) {
                this.param = param;
            }

            public static class ParamBean {
                /**
                 * id : 1
                 * param : 中国农业银行
                 */

                private int id;
                private String param;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getParam() {
                    return param;
                }

                public void setParam(String param) {
                    this.param = param;
                }
            }
        }

        public static class _$2Bean {
            /**
             * type : 证件类型
             * param : [{"id":17,"param":"身份证"}]
             */

            private String type;
            private List<ParamBeanX> param;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public List<ParamBeanX> getParam() {
                return param;
            }

            public void setParam(List<ParamBeanX> param) {
                this.param = param;
            }

            public static class ParamBeanX {
                /**
                 * id : 17
                 * param : 身份证
                 */

                private int id;
                private String param;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getParam() {
                    return param;
                }

                public void setParam(String param) {
                    this.param = param;
                }
            }
        }

        public static class _$3Bean {
            /**
             * type : 提成方式
             * param : [{"id":18,"param":"固定金额X套数"},{"id":19,"param":"销售价格X比例"},{"id":20,"param":"面积X单价"}]
             */

            private String type;
            private List<ParamBeanXX> param;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public List<ParamBeanXX> getParam() {
                return param;
            }

            public void setParam(List<ParamBeanXX> param) {
                this.param = param;
            }

            public static class ParamBeanXX {
                /**
                 * id : 18
                 * param : 固定金额X套数
                 */

                private int id;
                private String param;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getParam() {
                    return param;
                }

                public void setParam(String param) {
                    this.param = param;
                }
            }
        }

        public static class _$4Bean {
            /**
             * type : 投诉类型
             * param : [{"id":21,"param":"客源无效"},{"id":22,"param":"其他"}]
             */

            private String type;
            private List<ParamBeanXXX> param;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public List<ParamBeanXXX> getParam() {
                return param;
            }

            public void setParam(List<ParamBeanXXX> param) {
                this.param = param;
            }

            public static class ParamBeanXXX {
                /**
                 * id : 21
                 * param : 客源无效
                 */

                private int id;
                private String param;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getParam() {
                    return param;
                }

                public void setParam(String param) {
                    this.param = param;
                }
            }
        }

        public static class _$5Bean {
            /**
             * type : 投诉解决类型
             * param : [{"id":23,"param":"客源有效"},{"id":24,"param":"其他"}]
             */

            private String type;
            private List<ParamBeanXXXX> param;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public List<ParamBeanXXXX> getParam() {
                return param;
            }

            public void setParam(List<ParamBeanXXXX> param) {
                this.param = param;
            }

            public static class ParamBeanXXXX {
                /**
                 * id : 23
                 * param : 客源有效
                 */

                private int id;
                private String param;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getParam() {
                    return param;
                }

                public void setParam(String param) {
                    this.param = param;
                }
            }
        }

        public static class _$6Bean {
            /**
             * type : 合同终止原因
             * param : [{"id":25,"param":"合同到期"},{"id":26,"param":"强制终止"}]
             */

            private String type;
            private List<ParamBeanXXXXX> param;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public List<ParamBeanXXXXX> getParam() {
                return param;
            }

            public void setParam(List<ParamBeanXXXXX> param) {
                this.param = param;
            }

            public static class ParamBeanXXXXX {
                /**
                 * id : 25
                 * param : 合同到期
                 */

                private int id;
                private String param;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getParam() {
                    return param;
                }

                public void setParam(String param) {
                    this.param = param;
                }
            }
        }

        public static class _$7Bean {
            /**
             * type : 禁用类型
             * param : [{"id":27,"param":"非法交易"},{"id":28,"param":"利用漏洞"}]
             */

            private String type;
            private List<ParamBeanXXXXXX> param;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public List<ParamBeanXXXXXX> getParam() {
                return param;
            }

            public void setParam(List<ParamBeanXXXXXX> param) {
                this.param = param;
            }

            public static class ParamBeanXXXXXX {
                /**
                 * id : 27
                 * param : 非法交易
                 */

                private int id;
                private String param;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getParam() {
                    return param;
                }

                public void setParam(String param) {
                    this.param = param;
                }
            }
        }

        public static class _$8Bean {
            /**
             * type : 房龄
             * param : [{"id":29,"param":"一年以内"},{"id":30,"param":"三年以内"},{"id":31,"param":"十年以内"}]
             */

            private String type;
            private List<ParamBeanXXXXXXX> param;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public List<ParamBeanXXXXXXX> getParam() {
                return param;
            }

            public void setParam(List<ParamBeanXXXXXXX> param) {
                this.param = param;
            }

            public static class ParamBeanXXXXXXX {
                /**
                 * id : 29
                 * param : 一年以内
                 */

                private int id;
                private String param;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getParam() {
                    return param;
                }

                public void setParam(String param) {
                    this.param = param;
                }
            }
        }

        public static class _$9Bean {
            /**
             * type : 住房类型
             * param : [{"id":32,"param":"3室2厅2卫"},{"id":33,"param":"1室1厅2卫"},{"id":106,"param":"1室1厅1卫"},{"id":141,"param":"3室2厅1卫"},{"id":142,"param":"2室2卫1厅"}]
             */

            private String type;
            private List<ParamBeanXXXXXXXX> param;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public List<ParamBeanXXXXXXXX> getParam() {
                return param;
            }

            public void setParam(List<ParamBeanXXXXXXXX> param) {
                this.param = param;
            }

            public static class ParamBeanXXXXXXXX {
                /**
                 * id : 32
                 * param : 3室2厅2卫
                 */

                private int id;
                private String param;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getParam() {
                    return param;
                }

                public void setParam(String param) {
                    this.param = param;
                }
            }
        }

        public static class _$10Bean {
            /**
             * type : 货币类型
             * param : [{"id":34,"param":"人民币"},{"id":35,"param":"美元"},{"id":36,"param":"日元"},{"id":37,"param":"港币"},{"id":38,"param":"英镑"},{"id":39,"param":"欧元"}]
             */

            private String type;
            private List<ParamBeanXXXXXXXXX> param;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public List<ParamBeanXXXXXXXXX> getParam() {
                return param;
            }

            public void setParam(List<ParamBeanXXXXXXXXX> param) {
                this.param = param;
            }

            public static class ParamBeanXXXXXXXXX {
                /**
                 * id : 34
                 * param : 人民币
                 */

                private int id;
                private String param;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getParam() {
                    return param;
                }

                public void setParam(String param) {
                    this.param = param;
                }
            }
        }

        public static class _$11Bean {
            /**
             * type : 开盘方式
             * param : [{"id":40,"param":"网上开盘"},{"id":41,"param":"线下开盘"},{"id":42,"param":"其他"}]
             */

            private String type;
            private List<ParamBeanXXXXXXXXXX> param;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public List<ParamBeanXXXXXXXXXX> getParam() {
                return param;
            }

            public void setParam(List<ParamBeanXXXXXXXXXX> param) {
                this.param = param;
            }

            public static class ParamBeanXXXXXXXXXX {
                /**
                 * id : 40
                 * param : 网上开盘
                 */

                private int id;
                private String param;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getParam() {
                    return param;
                }

                public void setParam(String param) {
                    this.param = param;
                }
            }
        }

        public static class _$12Bean {
            /**
             * type : 置业目的
             * param : [{"id":43,"param":"投资"},{"id":44,"param":"自住"},{"id":45,"param":"投资兼自住"}]
             */

            private String type;
            private List<ParamBeanXXXXXXXXXXX> param;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public List<ParamBeanXXXXXXXXXXX> getParam() {
                return param;
            }

            public void setParam(List<ParamBeanXXXXXXXXXXX> param) {
                this.param = param;
            }

            public static class ParamBeanXXXXXXXXXXX {
                /**
                 * id : 43
                 * param : 投资
                 */

                private int id;
                private String param;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getParam() {
                    return param;
                }

                public void setParam(String param) {
                    this.param = param;
                }
            }
        }

        public static class _$13Bean {
            /**
             * type : 付款方式
             * param : [{"id":46,"param":"一次性付款"},{"id":47,"param":"公积金贷款"},{"id":48,"param":"综合贷款"},{"id":49,"param":"银行按揭贷款"},{"id":50,"param":"分期付款"}]
             */

            private String type;
            private List<ParamBeanXXXXXXXXXXXX> param;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public List<ParamBeanXXXXXXXXXXXX> getParam() {
                return param;
            }

            public void setParam(List<ParamBeanXXXXXXXXXXXX> param) {
                this.param = param;
            }

            public static class ParamBeanXXXXXXXXXXXX {
                /**
                 * id : 46
                 * param : 一次性付款
                 */

                private int id;
                private String param;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getParam() {
                    return param;
                }

                public void setParam(String param) {
                    this.param = param;
                }
            }
        }

        public static class _$14Bean {
            /**
             * type : 项目图片类型
             * param : [{"id":52,"param":"3D图"},{"id":53,"param":"效果图"},{"id":54,"param":"平面图"},{"id":55,"param":"实景图"}]
             */

            private String type;
            private List<ParamBeanXXXXXXXXXXXXX> param;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public List<ParamBeanXXXXXXXXXXXXX> getParam() {
                return param;
            }

            public void setParam(List<ParamBeanXXXXXXXXXXXXX> param) {
                this.param = param;
            }

            public static class ParamBeanXXXXXXXXXXXXX {
                /**
                 * id : 52
                 * param : 3D图
                 */

                private int id;
                private String param;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getParam() {
                    return param;
                }

                public void setParam(String param) {
                    this.param = param;
                }
            }
        }

        public static class _$15Bean {
            /**
             * type : 项目标签
             * param : [{"id":56,"param":"学区房"},{"id":57,"param":"五证齐全"},{"id":58,"param":"地铁房"},{"id":104,"param":"车位充足"},{"id":105,"param":"品牌房企"},{"id":125,"param":"涪江畔"},{"id":126,"param":"三幼旁"},{"id":127,"param":"大社区"},{"id":130,"param":"农产品批发"},{"id":131,"param":"综合体购物"},{"id":132,"param":"地铁8号线"},{"id":134,"param":"高铁站前"},{"id":135,"param":"5.1米跃层微墅"},{"id":136,"param":"全时商业潮圣地"},{"id":137,"param":"欢乐海底世界"}]
             */

            private String type;
            private List<ParamBeanXXXXXXXXXXXXXX> param;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public List<ParamBeanXXXXXXXXXXXXXX> getParam() {
                return param;
            }

            public void setParam(List<ParamBeanXXXXXXXXXXXXXX> param) {
                this.param = param;
            }

            public static class ParamBeanXXXXXXXXXXXXXX {
                /**
                 * id : 56
                 * param : 学区房
                 */

                private int id;
                private String param;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getParam() {
                    return param;
                }

                public void setParam(String param) {
                    this.param = param;
                }
            }
        }

        public static class _$16Bean {
            /**
             * type : 物业类型
             * param : [{"id":59,"param":"住宅"},{"id":60,"param":"公寓"},{"id":61,"param":"别墅"},{"id":62,"param":"商铺"},{"id":63,"param":"写字楼"},{"id":64,"param":"车位"},{"id":138,"param":"微墅"},{"id":139,"param":"商墅"}]
             */

            private String type;
            private List<ParamBeanXXXXXXXXXXXXXXX> param;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public List<ParamBeanXXXXXXXXXXXXXXX> getParam() {
                return param;
            }

            public void setParam(List<ParamBeanXXXXXXXXXXXXXXX> param) {
                this.param = param;
            }

            public static class ParamBeanXXXXXXXXXXXXXXX {
                /**
                 * id : 59
                 * param : 住宅
                 */

                private int id;
                private String param;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getParam() {
                    return param;
                }

                public void setParam(String param) {
                    this.param = param;
                }
            }
        }

        public static class _$17Bean {
            /**
             * type : 建筑类型
             * param : [{"id":66,"param":"板楼"},{"id":65,"param":"钢混"},{"id":67,"param":"砖混"},{"id":68,"param":"砖木"},{"id":69,"param":"钢结构"},{"id":70,"param":"其他"},{"id":124,"param":"框剪"},{"id":133,"param":"剪力墙"}]
             */

            private String type;
            private List<ParamBeanXXXXXXXXXXXXXXXX> param;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public List<ParamBeanXXXXXXXXXXXXXXXX> getParam() {
                return param;
            }

            public void setParam(List<ParamBeanXXXXXXXXXXXXXXXX> param) {
                this.param = param;
            }

            public static class ParamBeanXXXXXXXXXXXXXXXX {
                /**
                 * id : 66
                 * param : 板楼
                 */

                private int id;
                private String param;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getParam() {
                    return param;
                }

                public void setParam(String param) {
                    this.param = param;
                }
            }
        }

        public static class _$18Bean {
            /**
             * type : 用户失效类型
             * param : [{"id":72,"param":"自然失效"},{"id":73,"param":"置业顾问判断无效"},{"id":74,"param":"销售业内判断无效"},{"id":110,"param":"开发商判断无效"}]
             */

            private String type;
            private List<ParamBeanXXXXXXXXXXXXXXXXX> param;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public List<ParamBeanXXXXXXXXXXXXXXXXX> getParam() {
                return param;
            }

            public void setParam(List<ParamBeanXXXXXXXXXXXXXXXXX> param) {
                this.param = param;
            }

            public static class ParamBeanXXXXXXXXXXXXXXXXX {
                /**
                 * id : 72
                 * param : 自然失效
                 */

                private int id;
                private String param;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getParam() {
                    return param;
                }

                public void setParam(String param) {
                    this.param = param;
                }
            }
        }

        public static class _$19Bean {
            /**
             * type : 朝向
             * param : [{"id":75,"param":"西南"},{"id":76,"param":"东南"},{"id":77,"param":"西北"}]
             */

            private String type;
            private List<ParamBeanXXXXXXXXXXXXXXXXXX> param;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public List<ParamBeanXXXXXXXXXXXXXXXXXX> getParam() {
                return param;
            }

            public void setParam(List<ParamBeanXXXXXXXXXXXXXXXXXX> param) {
                this.param = param;
            }

            public static class ParamBeanXXXXXXXXXXXXXXXXXX {
                /**
                 * id : 75
                 * param : 西南
                 */

                private int id;
                private String param;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getParam() {
                    return param;
                }

                public void setParam(String param) {
                    this.param = param;
                }
            }
        }

        public static class _$20Bean {
            /**
             * type : 梯户比
             * param : [{"id":78,"param":"1：1"},{"id":79,"param":"1：2"}]
             */

            private String type;
            private List<ParamBeanXXXXXXXXXXXXXXXXXXX> param;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public List<ParamBeanXXXXXXXXXXXXXXXXXXX> getParam() {
                return param;
            }

            public void setParam(List<ParamBeanXXXXXXXXXXXXXXXXXXX> param) {
                this.param = param;
            }

            public static class ParamBeanXXXXXXXXXXXXXXXXXXX {
                /**
                 * id : 78
                 * param : 1：1
                 */

                private int id;
                private String param;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getParam() {
                    return param;
                }

                public void setParam(String param) {
                    this.param = param;
                }
            }
        }

        public static class _$21Bean {
            /**
             * type : 装修标准
             * param : [{"id":80,"param":"毛坯"},{"id":81,"param":"简装"},{"id":82,"param":"精装"}]
             */

            private String type;
            private List<ParamBeanXXXXXXXXXXXXXXXXXXXX> param;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public List<ParamBeanXXXXXXXXXXXXXXXXXXXX> getParam() {
                return param;
            }

            public void setParam(List<ParamBeanXXXXXXXXXXXXXXXXXXXX> param) {
                this.param = param;
            }

            public static class ParamBeanXXXXXXXXXXXXXXXXXXXX {
                /**
                 * id : 80
                 * param : 毛坯
                 */

                private int id;
                private String param;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getParam() {
                    return param;
                }

                public void setParam(String param) {
                    this.param = param;
                }
            }
        }

        public static class _$22Bean {
            /**
             * type : 均价
             * param : [{"id":85,"param":"10000-15000"},{"id":83,"param":"5000-8000"},{"id":84,"param":"8000-1000"}]
             */

            private String type;
            private List<ParamBeanXXXXXXXXXXXXXXXXXXXXX> param;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public List<ParamBeanXXXXXXXXXXXXXXXXXXXXX> getParam() {
                return param;
            }

            public void setParam(List<ParamBeanXXXXXXXXXXXXXXXXXXXXX> param) {
                this.param = param;
            }

            public static class ParamBeanXXXXXXXXXXXXXXXXXXXXX {
                /**
                 * id : 85
                 * param : 10000-15000
                 */

                private int id;
                private String param;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getParam() {
                    return param;
                }

                public void setParam(String param) {
                    this.param = param;
                }
            }
        }

        public static class _$23Bean {
            /**
             * type : 跟进方式
             * param : [{"id":86,"param":"电话"},{"id":87,"param":"QQ"},{"id":88,"param":"微信"},{"id":89,"param":"面谈"},{"id":90,"param":"其他"}]
             */

            private String type;
            private List<ParamBeanXXXXXXXXXXXXXXXXXXXXXX> param;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public List<ParamBeanXXXXXXXXXXXXXXXXXXXXXX> getParam() {
                return param;
            }

            public void setParam(List<ParamBeanXXXXXXXXXXXXXXXXXXXXXX> param) {
                this.param = param;
            }

            public static class ParamBeanXXXXXXXXXXXXXXXXXXXXXX {
                /**
                 * id : 86
                 * param : 电话
                 */

                private int id;
                private String param;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getParam() {
                    return param;
                }

                public void setParam(String param) {
                    this.param = param;
                }
            }
        }

        public static class _$25Bean {
            /**
             * type : 总价
             * param : [{"id":91,"param":"50"},{"id":92,"param":"50-80"},{"id":93,"param":"80-120"},{"id":94,"param":"120-200"},{"id":95,"param":"200"}]
             */

            private String type;
            private List<ParamBeanXXXXXXXXXXXXXXXXXXXXXXX> param;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public List<ParamBeanXXXXXXXXXXXXXXXXXXXXXXX> getParam() {
                return param;
            }

            public void setParam(List<ParamBeanXXXXXXXXXXXXXXXXXXXXXXX> param) {
                this.param = param;
            }

            public static class ParamBeanXXXXXXXXXXXXXXXXXXXXXXX {
                /**
                 * id : 91
                 * param : 50
                 */

                private int id;
                private String param;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getParam() {
                    return param;
                }

                public void setParam(String param) {
                    this.param = param;
                }
            }
        }

        public static class _$24Bean {
            /**
             * type : 申述类型
             * param : [{"id":108,"param":"申述类型2"},{"id":109,"param":"申述类型3"},{"id":107,"param":"申述类型1"}]
             */

            private String type;
            private List<ParamBeanXXXXXXXXXXXXXXXXXXXXXXXX> param;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public List<ParamBeanXXXXXXXXXXXXXXXXXXXXXXXX> getParam() {
                return param;
            }

            public void setParam(List<ParamBeanXXXXXXXXXXXXXXXXXXXXXXXX> param) {
                this.param = param;
            }

            public static class ParamBeanXXXXXXXXXXXXXXXXXXXXXXXX {
                /**
                 * id : 108
                 * param : 申述类型2
                 */

                private int id;
                private String param;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getParam() {
                    return param;
                }

                public void setParam(String param) {
                    this.param = param;
                }
            }
        }

        public static class _$26Bean {
            /**
             * type : 面积
             * param : [{"id":96,"param":"50"},{"id":97,"param":"50-90"},{"id":98,"param":"90-130"},{"id":99,"param":"130-150"},{"id":100,"param":"150"}]
             */

            private String type;
            private List<ParamBeanXXXXXXXXXXXXXXXXXXXXXXXXX> param;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public List<ParamBeanXXXXXXXXXXXXXXXXXXXXXXXXX> getParam() {
                return param;
            }

            public void setParam(List<ParamBeanXXXXXXXXXXXXXXXXXXXXXXXXX> param) {
                this.param = param;
            }

            public static class ParamBeanXXXXXXXXXXXXXXXXXXXXXXXXX {
                /**
                 * id : 96
                 * param : 50
                 */

                private int id;
                private String param;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getParam() {
                    return param;
                }

                public void setParam(String param) {
                    this.param = param;
                }
            }
        }

        public static class _$27Bean {
            /**
             * type : 佣金结算失败原因
             * param : [{"id":101,"param":"缺少银行卡信息"},{"id":102,"param":"银行卡打款失败"},{"id":103,"param":"其他"}]
             */

            private String type;
            private List<ParamBeanXXXXXXXXXXXXXXXXXXXXXXXXXX> param;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public List<ParamBeanXXXXXXXXXXXXXXXXXXXXXXXXXX> getParam() {
                return param;
            }

            public void setParam(List<ParamBeanXXXXXXXXXXXXXXXXXXXXXXXXXX> param) {
                this.param = param;
            }

            public static class ParamBeanXXXXXXXXXXXXXXXXXXXXXXXXXX {
                /**
                 * id : 101
                 * param : 缺少银行卡信息
                 */

                private int id;
                private String param;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getParam() {
                    return param;
                }

                public void setParam(String param) {
                    this.param = param;
                }
            }
        }

        public static class _$28Bean {
            /**
             * type : 客服电话
             * param : [{"id":128,"param":"15082245107"},{"id":129,"param":"15983804767"}]
             */

            private String type;
            private List<ParamBeanXXXXXXXXXXXXXXXXXXXXXXXXXXX> param;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public List<ParamBeanXXXXXXXXXXXXXXXXXXXXXXXXXXX> getParam() {
                return param;
            }

            public void setParam(List<ParamBeanXXXXXXXXXXXXXXXXXXXXXXXXXXX> param) {
                this.param = param;
            }

            public static class ParamBeanXXXXXXXXXXXXXXXXXXXXXXXXXXX {
                /**
                 * id : 128
                 * param : 15082245107
                 */

                private int id;
                private String param;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getParam() {
                    return param;
                }

                public void setParam(String param) {
                    this.param = param;
                }
            }
        }
    }
}
