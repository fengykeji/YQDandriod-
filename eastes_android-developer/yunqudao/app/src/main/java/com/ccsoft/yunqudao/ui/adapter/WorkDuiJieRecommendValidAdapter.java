package com.ccsoft.yunqudao.ui.adapter;

import android.content.Context;
import android.view.View;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.duijieyouxiaobean;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.BaseViewHolder;

import java.util.List;

public class WorkDuiJieRecommendValidAdapter extends BaseRecyclerAdapter<duijieyouxiaobean.DataBeanX.DataBean> {
    public WorkDuiJieRecommendValidAdapter(Context context, int layoutId, List<duijieyouxiaobean.DataBeanX.DataBean> data) {
        super(context, layoutId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, duijieyouxiaobean.DataBeanX.DataBean bean, int position) {
        holder.setText(R.id.name,bean.getName());
        holder.setText(R.id.recommend_num,String.valueOf(bean.getClient_id()));
        holder.setText(R.id.recommend_name,bean.getProject_name());
        holder.setText(R.id.time,"到访时间: " + bean.getVisit_time());
        holder.setText(R.id.result,bean.getCurrent_state());

        holder.setVisible(R.id.phone, View.GONE);
    }
}
