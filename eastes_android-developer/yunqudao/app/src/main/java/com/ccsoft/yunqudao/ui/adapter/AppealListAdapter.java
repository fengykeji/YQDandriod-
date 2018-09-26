package com.ccsoft.yunqudao.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.AppealListBean;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.BaseViewHolder;

import java.util.List;

public class AppealListAdapter extends BaseRecyclerAdapter<AppealListBean.DataBean> {
    public AppealListAdapter(Context context, int layoutId, List<AppealListBean.DataBean> data) {
        super(context, layoutId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, AppealListBean.DataBean bean, int position) {
        holder.setText(R.id.name,bean.getName());
        holder.setText(R.id.recommend_num,bean.getProject_name()+"");
        holder.setText(R.id.recommend_name,bean.getHouse_code());
        holder.setText(R.id.address,bean.getAppeal_time()+"");
        if(bean.getAppeal_state()==1) {
            TextView textView = (TextView) holder.getView(R.id.status_tv);
            textView.setTextColor(Color.parseColor("#ff5858"));
            holder.setText(R.id.tv_tel1, "处理中");
        }
        holder.setText(R.id.tv_tel1, "处理完成");



    }
}
