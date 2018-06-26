package com.ccsoft.yunqudao.data.model.viewmodel;

import com.ccsoft.yunqudao.data.base.BaseData;

/**
 * @author: Pein
 * @data: 2018/5/27 0027
 */

public class WorkModel extends BaseData{

    public Recommend   recommend;
    public Preparation preparation;


    public class Recommend extends BaseData{

        public int value;
        public int total;
        public int disabled;

        @Override
        public String toString() {
            return "Recommend{" + "value=" + value + ", total=" + total + ", disabled=" + disabled + '}';
        }
    }

    public class Preparation extends BaseData{

        public int value;
        public int total;
        public int disabled;

        @Override
        public String toString() {
            return "Preparation{" + "value=" + value + ", total=" + total + ", disabled=" + disabled + '}';
        }
    }


}
