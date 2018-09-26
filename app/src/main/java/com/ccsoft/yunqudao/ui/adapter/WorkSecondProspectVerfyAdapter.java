package com.ccsoft.yunqudao.ui.adapter;

import android.content.Context;

import com.ccsoft.yunqudao.bean.SurveyWaitConfirm;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.BaseViewHolder;

import java.util.List;

public class WorkSecondProspectVerfyAdapter extends BaseRecyclerAdapter<SurveyWaitConfirm.DataBean>{
    public WorkSecondProspectVerfyAdapter(Context context, int layoutId, List<SurveyWaitConfirm.DataBean> data) {
        super(context, layoutId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, SurveyWaitConfirm.DataBean bean, int position) {

    }
}
