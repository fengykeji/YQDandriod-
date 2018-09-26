package com.ccsoft.yunqudao.ui.adapter;

import android.content.Context;
import android.view.View;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.duijeiwuxiaobean;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.BaseViewHolder;

import java.util.List;

public class WorkDuiJieRecommendDisableAdapter extends BaseRecyclerAdapter<duijeiwuxiaobean.DataBeanX.DataBean> {
    public WorkDuiJieRecommendDisableAdapter(Context context, int layoutId, List<duijeiwuxiaobean.DataBeanX.DataBean> data) {
        super(context, layoutId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, duijeiwuxiaobean.DataBeanX.DataBean bean, int position) {
        holder.setText(R.id.name,bean.getName());
        holder.setText(R.id.recommend_num,String.valueOf(bean.getClient_id()));
        holder.setText(R.id.recommend_name,bean.getProject_name());
        holder.setText(R.id.time,"失效时间: " + bean.getState_change_time());
        holder.setText(R.id.result,bean.getCurrent_state());

        holder.setOnclick(R.id.phone, new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
