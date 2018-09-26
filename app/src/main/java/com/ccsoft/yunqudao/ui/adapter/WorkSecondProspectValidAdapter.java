package com.ccsoft.yunqudao.ui.adapter;

import android.content.Context;

import com.ccsoft.yunqudao.bean.SurveyUnderwayBean;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.BaseViewHolder;

import java.util.List;

public class WorkSecondProspectValidAdapter extends BaseRecyclerAdapter<SurveyUnderwayBean.DataBean>{
    public WorkSecondProspectValidAdapter(Context context, int layoutId, List<SurveyUnderwayBean.DataBean> data) {
        super(context, layoutId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, SurveyUnderwayBean.DataBean bean, int position) {

    }
}
