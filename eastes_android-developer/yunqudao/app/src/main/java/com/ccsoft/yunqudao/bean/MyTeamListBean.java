package com.ccsoft.yunqudao.bean;

import java.util.List;

public class MyTeamListBean {


    /**
     * code : 200
     * msg : 查询成功
     * data : {"person":{"name":"","grade":"新秀","head_img":null,"sex":0},"parent":{"account":"34286851","name":"123","grade":"新秀","sex":1,"create_time":"2018-08-14 10:15:46","head_img":null,"tel":"18181423263","company_name":"全民经纪人","work_year":1},"child":[{"account":"12925027","agent_id":41,"name":"","grade":"新秀","sex":1,"create_time":"2018-06-13 06:31:06","produce_grade":0,"head_img":"upload/project/img/1527824479_69.jpg","company_name":"全民经纪人","tel":"15082245110","work_year":1},{"account":"61899108","agent_id":45,"name":"","grade":"新秀","sex":1,"create_time":"2018-06-13 09:07:20","produce_grade":0,"head_img":"upload/project/img/1527824479_69.jpg","company_name":"全民经纪人","tel":"15082245115","work_year":1},{"account":"62845784","agent_id":42,"name":"","grade":"新秀","sex":1,"create_time":"2018-06-13 06:31:06","produce_grade":0,"head_img":null,"company_name":"全民经纪人","tel":"15082245111","work_year":1},{"account":"34286851","agent_id":72,"name":"123","grade":"新秀","sex":1,"create_time":"2018-08-14 10:15:46","produce_grade":0,"head_img":null,"company_name":"全民经纪人","tel":"18181423263","work_year":1}],"recommend":{"today":0,"total":4}}
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
         * person : {"name":"","grade":"新秀","head_img":null,"sex":0}
         * parent : {"account":"34286851","name":"123","grade":"新秀","sex":1,"create_time":"2018-08-14 10:15:46","head_img":null,"tel":"18181423263","company_name":"全民经纪人","work_year":1}
         * child : [{"account":"12925027","agent_id":41,"name":"","grade":"新秀","sex":1,"create_time":"2018-06-13 06:31:06","produce_grade":0,"head_img":"upload/project/img/1527824479_69.jpg","company_name":"全民经纪人","tel":"15082245110","work_year":1},{"account":"61899108","agent_id":45,"name":"","grade":"新秀","sex":1,"create_time":"2018-06-13 09:07:20","produce_grade":0,"head_img":"upload/project/img/1527824479_69.jpg","company_name":"全民经纪人","tel":"15082245115","work_year":1},{"account":"62845784","agent_id":42,"name":"","grade":"新秀","sex":1,"create_time":"2018-06-13 06:31:06","produce_grade":0,"head_img":null,"company_name":"全民经纪人","tel":"15082245111","work_year":1},{"account":"34286851","agent_id":72,"name":"123","grade":"新秀","sex":1,"create_time":"2018-08-14 10:15:46","produce_grade":0,"head_img":null,"company_name":"全民经纪人","tel":"18181423263","work_year":1}]
         * recommend : {"today":0,"total":4}
         */

        private PersonBean person;
        private ParentBean parent;
        private RecommendBean recommend;
        private List<ChildBean> child;

        public PersonBean getPerson() {
            return person;
        }

        public void setPerson(PersonBean person) {
            this.person = person;
        }

        public ParentBean getParent() {
            return parent;
        }

        public void setParent(ParentBean parent) {
            this.parent = parent;
        }

        public RecommendBean getRecommend() {
            return recommend;
        }

        public void setRecommend(RecommendBean recommend) {
            this.recommend = recommend;
        }

        public List<ChildBean> getChild() {
            return child;
        }

        public void setChild(List<ChildBean> child) {
            this.child = child;
        }

        public static class PersonBean {
            /**
             * name :
             * grade : 新秀
             * head_img : null
             * sex : 0
             */

            private String name;
            private String grade;
            private Object head_img;
            private int sex;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getGrade() {
                return grade;
            }

            public void setGrade(String grade) {
                this.grade = grade;
            }

            public Object getHead_img() {
                return head_img;
            }

            public void setHead_img(Object head_img) {
                this.head_img = head_img;
            }

            public int getSex() {
                return sex;
            }

            public void setSex(int sex) {
                this.sex = sex;
            }
        }

        public static class ParentBean {
            /**
             * account : 34286851
             * name : 123
             * grade : 新秀
             * sex : 1
             * create_time : 2018-08-14 10:15:46
             * head_img : null
             * tel : 18181423263
             * company_name : 全民经纪人
             * work_year : 1
             */

            private String account;
            private String name;
            private String grade;
            private int sex;
            private String create_time;
            private Object head_img;
            private String tel;
            private String company_name;
            private int work_year;

            public String getAccount() {
                return account;
            }

            public void setAccount(String account) {
                this.account = account;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getGrade() {
                return grade;
            }

            public void setGrade(String grade) {
                this.grade = grade;
            }

            public int getSex() {
                return sex;
            }

            public void setSex(int sex) {
                this.sex = sex;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public Object getHead_img() {
                return head_img;
            }

            public void setHead_img(Object head_img) {
                this.head_img = head_img;
            }

            public String getTel() {
                return tel;
            }

            public void setTel(String tel) {
                this.tel = tel;
            }

            public String getCompany_name() {
                return company_name;
            }

            public void setCompany_name(String company_name) {
                this.company_name = company_name;
            }

            public int getWork_year() {
                return work_year;
            }

            public void setWork_year(int work_year) {
                this.work_year = work_year;
            }
        }

        public static class RecommendBean {
            /**
             * today : 0
             * total : 4
             */

            private int today;
            private int total;

            public int getToday() {
                return today;
            }

            public void setToday(int today) {
                this.today = today;
            }

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }
        }

        public static class ChildBean {
            /**
             * account : 12925027
             * agent_id : 41
             * name :
             * grade : 新秀
             * sex : 1
             * create_time : 2018-06-13 06:31:06
             * produce_grade : 0
             * head_img : upload/project/img/1527824479_69.jpg
             * company_name : 全民经纪人
             * tel : 15082245110
             * work_year : 1
             */

            private String account;
            private int agent_id;
            private String name;
            private String grade;
            private int sex;
            private String create_time;
            private int produce_grade;
            private String head_img;
            private String company_name;
            private String tel;
            private int work_year;

            public String getAccount() {
                return account;
            }

            public void setAccount(String account) {
                this.account = account;
            }

            public int getAgent_id() {
                return agent_id;
            }

            public void setAgent_id(int agent_id) {
                this.agent_id = agent_id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getGrade() {
                return grade;
            }

            public void setGrade(String grade) {
                this.grade = grade;
            }

            public int getSex() {
                return sex;
            }

            public void setSex(int sex) {
                this.sex = sex;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public int getProduce_grade() {
                return produce_grade;
            }

            public void setProduce_grade(int produce_grade) {
                this.produce_grade = produce_grade;
            }

            public String getHead_img() {
                return head_img;
            }

            public void setHead_img(String head_img) {
                this.head_img = head_img;
            }

            public String getCompany_name() {
                return company_name;
            }

            public void setCompany_name(String company_name) {
                this.company_name = company_name;
            }

            public String getTel() {
                return tel;
            }

            public void setTel(String tel) {
                this.tel = tel;
            }

            public int getWork_year() {
                return work_year;
            }

            public void setWork_year(int work_year) {
                this.work_year = work_year;
            }
        }
    }
}
