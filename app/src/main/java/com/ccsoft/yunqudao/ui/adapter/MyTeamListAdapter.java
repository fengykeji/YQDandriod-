package com.ccsoft.yunqudao.ui.adapter;

import android.content.Context;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.MyTeamListBean;
import com.ccsoft.yunqudao.data.AppConstants;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.BaseViewHolder;
import com.ccsoft.yunqudao.utils.CircleImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyTeamListAdapter extends BaseRecyclerAdapter<MyTeamListBean.DataBean.ChildBean> {
    public MyTeamListAdapter(Context context, int layoutId, List<MyTeamListBean.DataBean.ChildBean> data) {
        super(context, layoutId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, MyTeamListBean.DataBean.ChildBean bean, int position) {
        CircleImageView  imageView = (CircleImageView) holder.getView(R.id.im_headimg);
        Picasso.with(context).load(AppConstants.URL+bean.getHead_img())
                .error(R.drawable.ic_def_head)
                .into(imageView);
        holder.setText(R.id.tv_name,bean.getName());
        holder.setText(R.id.tv_dengji,bean.getGrade()+"");
        holder.setText(R.id.tv_time,bean.getCreate_time());
        holder.setText(R.id.tv_money,bean.getProduce_grade()+"");
        if (bean.getSex()==1){
            holder.setImageResource(R.id.im_sex,R.drawable.ic_man);
        }else if(bean.getSex() == 2){
            holder.setImageResource(R.id.im_sex,R.drawable.ic_girl);
        }

    }
}
