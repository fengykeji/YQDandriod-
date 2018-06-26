package com.ccsoft.yunqudao.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.AppealBean;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.BaseViewHolder;

import java.util.List;

public class WorkComplainAdapter extends BaseRecyclerAdapter<AppealBean.DataBeanX.DataBean> {
    public WorkComplainAdapter(Context context, int layoutId, List<AppealBean.DataBeanX.DataBean> data) {
        super(context, layoutId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, AppealBean.DataBeanX.DataBean bean) {
        holder.setText(R.id.name_tv,bean.getName());
        holder.setText(R.id.num_tv,bean.getProject_client_id()+"");
        holder.setText(R.id.place_tv,bean.getProject_name());
        holder.setText(R.id.end_date_tv,bean.getRecommend_time()+"");
        if(bean.getState().equals("处理中")) {
            TextView textView = (TextView) holder.getView(R.id.status_tv);
            textView.setTextColor(Color.parseColor("#ff5858"));
        }
            holder.setText(R.id.status_tv, bean.getState());
        holder.setText(R.id.camplain_date_tv,bean.getCreate_time()+"");

        holder.setOnclick(R.id.phone_iv, new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    }

