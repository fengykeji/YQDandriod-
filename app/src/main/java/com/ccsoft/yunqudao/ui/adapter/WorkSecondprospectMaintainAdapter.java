package com.ccsoft.yunqudao.ui.adapter;

import android.content.Context;

import com.ccsoft.yunqudao.bean.SurveyListBean;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.BaseViewHolder;

import java.util.List;

public class WorkSecondprospectMaintainAdapter extends BaseRecyclerAdapter<SurveyListBean.DataBeanX.DataBean> {
    public WorkSecondprospectMaintainAdapter(Context context, int layoutId, List<SurveyListBean.DataBeanX.DataBean> data) {
        super(context, layoutId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, SurveyListBean.DataBeanX.DataBean bean, int position) {

    }
}
