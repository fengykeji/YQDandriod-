package com.ccsoft.yunqudao.ui.house;

import com.ccsoft.yunqudao.bean.ProjectImgGetBean;

import java.util.ArrayList;
import java.util.List;

public class EvenBusSendDataList {

    private List<ProjectImgGetBean.DataBeanX.DataBean> list = new ArrayList<>();

    public EvenBusSendDataList(List<ProjectImgGetBean.DataBeanX.DataBean> list){
        this.list = list;
    }

    public List<ProjectImgGetBean.DataBeanX.DataBean> getList() {
        return list;
    }

    public void setList(List<ProjectImgGetBean.DataBeanX.DataBean> list) {
        this.list = list;
    }
}
