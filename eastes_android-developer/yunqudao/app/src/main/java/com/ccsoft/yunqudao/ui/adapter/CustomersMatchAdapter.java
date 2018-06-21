package com.ccsoft.yunqudao.ui.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.PipeiBean;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.BaseViewHolder;
import com.ccsoft.yunqudao.data.model.response.MatchData;

import java.util.List;

public class CustomersMatchAdapter extends BaseRecyclerAdapter<PipeiBean.DataBean.RecommendProjectBean> {
    public CustomersMatchAdapter(Context context, int layoutId, List<PipeiBean.DataBean.RecommendProjectBean> data) {
        super(context, layoutId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, PipeiBean.DataBean.RecommendProjectBean bean) {
        holder.setText(R.id.tv_project_name,bean.getProject_name());
        holder.setText(R.id.tv_state_change_time,bean.getState_change_time());
        TextView textView= (TextView) holder.getView(R.id.tv_disabled_state);
        if(bean.getDisabled_state()==0){
           textView.setText("无效");
        }else {
            textView.setText("有效");
//            textView.setTextColor();
        }
        ImageView imageView = (ImageView) holder.getView(R.id.im_current_state);
        if(bean.getState_change_time().equals(1)){
            imageView.setImageResource(R.drawable.ic_push_1);
        }else if(bean.getState_change_time().equals(2)){
            imageView.setImageResource(R.drawable.ic_push_2);
        }else if(bean.getState_change_time().equals(3)){
            imageView.setImageResource(R.drawable.ic_push_3);
        }else if(bean.getState_change_time().equals(4)){
            imageView.setImageResource(R.drawable.ic_push_4);
        }else if(bean.getState_change_time().equals(5)){
            imageView.setImageResource(R.drawable.ic_push_5);
        }

    }
}
