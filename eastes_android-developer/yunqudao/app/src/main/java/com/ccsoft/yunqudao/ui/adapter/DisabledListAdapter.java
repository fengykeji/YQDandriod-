package com.ccsoft.yunqudao.ui.adapter;

import android.content.Context;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.DisabledListBean;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.BaseViewHolder;

import java.util.List;

public class DisabledListAdapter extends BaseRecyclerAdapter<DisabledListBean.DataBean> {
    public DisabledListAdapter(Context context, int layoutId, List<DisabledListBean.DataBean> data) {
        super(context, layoutId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, DisabledListBean.DataBean bean, int position) {
        holder.setText(R.id.name,bean.getName());
        holder.setText(R.id.recommend_num,bean.getProject_name());
        holder.setText(R.id.recommend_name,bean.getHouse_code());

            holder.setText(R.id.address, bean.getDisabled_time());

        holder.setText(R.id.tv_tel,bean.getTel());
    }
}
