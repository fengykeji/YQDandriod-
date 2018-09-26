package com.ccsoft.yunqudao.ui.adapter;

import android.content.Context;

import com.ccsoft.yunqudao.bean.SurveyFinishBean;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.BaseViewHolder;

import java.util.List;

public class WorkSecondPropectFinismAdapter extends BaseRecyclerAdapter<SurveyFinishBean.DataBean> {
    public WorkSecondPropectFinismAdapter(Context context, int layoutId, List<SurveyFinishBean.DataBean> data) {
        super(context, layoutId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, SurveyFinishBean.DataBean bean, int position) {

    }
}
