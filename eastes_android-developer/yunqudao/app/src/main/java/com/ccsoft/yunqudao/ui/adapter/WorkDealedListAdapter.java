package com.ccsoft.yunqudao.ui.adapter;

import android.content.Context;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.WorkDealedBean;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.BaseViewHolder;

import java.util.List;

public class WorkDealedListAdapter extends BaseRecyclerAdapter<WorkDealedBean.DataBeanX.DataBean> {
    public WorkDealedListAdapter(Context context, int layoutId, List<WorkDealedBean.DataBeanX.DataBean> data) {
        super(context, layoutId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, WorkDealedBean.DataBeanX.DataBean bean) {
        holder.setText(R.id.name_tv,bean.getName());
        holder.setText(R.id.num_tv,String.valueOf(bean.getClient_id()));
        holder.setText(R.id.place_tv,bean.getProject_name());

        holder.setText(R.id.end_date_tv,bean.getState_change_time());
    }
}
