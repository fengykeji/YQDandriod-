package com.ccsoft.yunqudao.ui.adapter;

import android.content.Context;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.PeizhiBean;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.BaseViewHolder;

import java.util.List;

public class ScoreTeamAdapter1 extends BaseRecyclerAdapter<PeizhiBean.DataBean._$22Bean.ParamBeanXXXXXXXXXXXXXXXXXXXXX> {
    public ScoreTeamAdapter1(Context context, int layoutId, List<PeizhiBean.DataBean._$22Bean.ParamBeanXXXXXXXXXXXXXXXXXXXXX> data) {
        super(context, layoutId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, PeizhiBean.DataBean._$22Bean.ParamBeanXXXXXXXXXXXXXXXXXXXXX bean, int position) {
        holder.setText(R.id.tv_woye,bean.getParam());

    }
}
