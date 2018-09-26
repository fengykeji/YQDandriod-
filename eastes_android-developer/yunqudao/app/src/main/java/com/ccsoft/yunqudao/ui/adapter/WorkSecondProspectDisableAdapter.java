package com.ccsoft.yunqudao.ui.adapter;

import android.content.Context;

import com.ccsoft.yunqudao.bean.SurveyDisabledBean;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.BaseViewHolder;

import java.util.List;

public class WorkSecondProspectDisableAdapter extends BaseRecyclerAdapter<SurveyDisabledBean.DataBean> {
    public WorkSecondProspectDisableAdapter(Context context, int layoutId, List<SurveyDisabledBean.DataBean> data) {
        super(context, layoutId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, SurveyDisabledBean.DataBean bean, int position) {

    }
}
