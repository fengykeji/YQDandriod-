package com.ccsoft.yunqudao.ui.adapter;

import android.content.Context;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.DongLieBiaoBean;
import com.ccsoft.yunqudao.bean.HouseDetailBean;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.BaseViewHolder;

import java.util.List;

public class ProjectDongLieBiaoAdapter extends BaseRecyclerAdapter<DongLieBiaoBean.DataBeanX.DataBean> {
    public ProjectDongLieBiaoAdapter(Context context, int layoutId, List<DongLieBiaoBean.DataBeanX.DataBean> data) {
        super(context, layoutId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, DongLieBiaoBean.DataBeanX.DataBean bean) {
        holder.setText(R.id.tv_title,bean.getTitle());
        holder.setText(R.id.tv_time,bean.getCreate_time());
        holder.setText(R.id.tv_content,bean.getContent());
    }
}
