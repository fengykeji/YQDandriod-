package com.ccsoft.yunqudao.ui.house;

import java.util.List;

public class SpeedHourEntity {

    public TopicBean topic;

    public static class TopicBean {
        public long nextupdatetime;
        public List<ItemsBean> items;

        public static class ItemsBean {
            public int id;
            public String theme;
            public int products;
            public int users;
            public String href;
            public boolean follow;
            public int topictype;

            public List<ListBean> list;

            public static class ListBean {
                public String id;
                public int price;
                public String pic;
            }
        }
    }
}
