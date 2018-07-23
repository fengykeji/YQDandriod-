package com.ccsoft.yunqudao.bean;

import org.jaaksi.pickerview.dataset.OptionDataSet;

import java.util.List;

public class Province  {



    private List<DynamicBean> dynamic;

    public List<DynamicBean> getDynamic() {
        return dynamic;
    }

    public void setDynamic(List<DynamicBean> dynamic) {
        this.dynamic = dynamic;
    }


    public static class DynamicBean implements OptionDataSet {
        /**
         * code : 110000
         * name : 北京市
         * city : [{"code":"110100","name":"市辖区","district":[{"code":"110101","name":"东城区"},{"code":"110102","name":"西城区"},{"code":"110105","name":"朝阳区"},{"code":"110106","name":"丰台区"},{"code":"110107","name":"石景山区"},{"code":"110108","name":"海淀区"},{"code":"110109","name":"门头沟区"},{"code":"110111","name":"房山区"},{"code":"110112","name":"通州区"},{"code":"110113","name":"顺义区"},{"code":"110114","name":"昌平区"},{"code":"110115","name":"大兴区"},{"code":"110116","name":"怀柔区"},{"code":"110117","name":"平谷区"},{"code":"110118","name":"密云区"},{"code":"110119","name":"延庆区"}]}]
         */

        private String code;
        private String name;
        private List<CityBean> city;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<CityBean> getCity() {
            return city;
        }

        public void setCity(List<CityBean> city) {
            this.city = city;
        }

        @Override public CharSequence getCharSequence() {
            return name;
        }

        @Override public List<CityBean> getSubs() {
            return city;
        }

        @Override public String getValue() {
            return String.valueOf(code);
        }

        public static class CityBean implements OptionDataSet{
            /**
             * code : 110100
             * name : 市辖区
             * district : [{"code":"110101","name":"东城区"},{"code":"110102","name":"西城区"},{"code":"110105","name":"朝阳区"},{"code":"110106","name":"丰台区"},{"code":"110107","name":"石景山区"},{"code":"110108","name":"海淀区"},{"code":"110109","name":"门头沟区"},{"code":"110111","name":"房山区"},{"code":"110112","name":"通州区"},{"code":"110113","name":"顺义区"},{"code":"110114","name":"昌平区"},{"code":"110115","name":"大兴区"},{"code":"110116","name":"怀柔区"},{"code":"110117","name":"平谷区"},{"code":"110118","name":"密云区"},{"code":"110119","name":"延庆区"}]
             */

            private String code;
            private String name;
            private List<DistrictBean> district;

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<DistrictBean> getDistrict() {
                return district;
            }

            public void setDistrict(List<DistrictBean> district) {
                this.district = district;
            }
            @Override public CharSequence getCharSequence() {
                return name;
            }

            @Override public List<DistrictBean> getSubs() {
                return district;
            }

            @Override public String getValue() {
                return String.valueOf(code);
            }

            public static class DistrictBean implements OptionDataSet{
                /**
                 * code : 110101
                 * name : 东城区
                 */

                private String code;
                private String name;

                public String getCode() {
                    return code;
                }

                public void setCode(String code) {
                    this.code = code;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }
                @Override public CharSequence getCharSequence() {
                    return name;
                }

                @Override public List<OptionDataSet> getSubs() {
                    return null;
                }

                @Override public String getValue() {
                    return String.valueOf(code);
                }
            }
        }
    }
}
