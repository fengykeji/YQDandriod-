package com.ccsoft.yunqudao.ui.adapter;

import android.content.Context;
import android.widget.TextView;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.ProjectLouDongChooseBean;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.BaseViewHolder;

import java.util.List;

public class HouseLoudongChooseAdapter extends BaseRecyclerAdapter<ProjectLouDongChooseBean.DataBean> {
    public HouseLoudongChooseAdapter(Context context, int layoutId, List data) {
        super(context, layoutId, data);
    }


    @Override
    protected void convert(BaseViewHolder holder, ProjectLouDongChooseBean.DataBean bean, int position) {
        holder.setText(R.id.tv_loudongchoose,bean.getBuild_info().getBuild_name());

    }
}
