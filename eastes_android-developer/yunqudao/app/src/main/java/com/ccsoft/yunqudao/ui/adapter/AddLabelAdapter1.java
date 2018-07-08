package com.ccsoft.yunqudao.ui.adapter;

import android.content.Context;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.BaseViewHolder;

import java.util.List;

public class AddLabelAdapter1 extends BaseRecyclerAdapter<String>{
    public AddLabelAdapter1(Context context, int layoutId, List<String> data) {
        super(context, layoutId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, String bean,int position) {
        holder.setText(R.id.tv_need_tags,bean);
    }
}
