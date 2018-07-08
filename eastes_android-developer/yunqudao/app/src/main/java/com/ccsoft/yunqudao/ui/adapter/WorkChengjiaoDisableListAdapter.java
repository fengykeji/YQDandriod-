package com.ccsoft.yunqudao.ui.adapter;

import android.content.Context;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.WorkDealBean;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.BaseViewHolder;

import java.util.List;

public class WorkChengjiaoDisableListAdapter extends BaseRecyclerAdapter<WorkDealBean.DataBeanX.DataBean> {
    public WorkChengjiaoDisableListAdapter(Context context, int layoutId, List<WorkDealBean.DataBeanX.DataBean> data) {
        super(context, layoutId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, WorkDealBean.DataBeanX.DataBean bean,int position) {
        holder.setText(R.id.name_tv,bean.getName());
        holder.setText(R.id.num_tv,String.valueOf(bean.getClient_id()));
        holder.setText(R.id.place_tv,bean.getProject_name());
        holder.setText(R.id.start_date_tv,bean.getCreate_time()+"");
        holder.setText(R.id.end_date_tv,bean.getState_change_time()+"");
    }
}
