package com.ccsoft.yunqudao.ui.adapter;

import android.content.Context;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.WorkListBean;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.BaseViewHolder;

import java.util.List;

public class WorkListAdapter extends BaseRecyclerAdapter<WorkListBean.DataBeanX.DataBean> {
    public WorkListAdapter(Context context, int layoutId, List<WorkListBean.DataBeanX.DataBean> data) {
        super(context, layoutId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, WorkListBean.DataBeanX.DataBean bean, int position) {

        holder.setText(R.id.tv_title,bean.getTitle());
        holder.setText(R.id.tv_client_id,bean.getClient_id()+"");
        holder.setText(R.id.tv_name,bean.getName());
        holder.setText(R.id.tv_project_name,bean.getProject_name());
        holder.setText(R.id.tv_time,bean.getCreate_time());

    }
}
