package com.ccsoft.yunqudao.ui.adapter;

import android.content.Context;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.WaitGrabBean;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.BaseViewHolder;

import java.util.List;

public class WaitGrabAdapter extends BaseRecyclerAdapter<WaitGrabBean.DataBean> {
    public WaitGrabAdapter(Context context, int layoutId, List<WaitGrabBean.DataBean> data) {
        super(context, layoutId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, WaitGrabBean.DataBean bean, int position) {

        holder.setText(R.id.name,bean.getName());
        holder.setText(R.id.recommend_num,bean.getProject_name());
        holder.setText(R.id.recommend_name,bean.getHouse_code());
        if(bean.getRecord_time()!=null) {
            holder.setText(R.id.address, bean.getRecord_time());
        }
        holder.setText(R.id.tv_tel,bean.getTel());
    }
}
