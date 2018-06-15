package com.ccsoft.yunqudao.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.PeizhiBean;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.BaseViewHolder;
import com.ccsoft.yunqudao.data.model.response.ConfigData;
import com.ccsoft.yunqudao.ui.mian.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class AddLabelAdapter extends BaseRecyclerAdapter<PeizhiBean.DataBean._$15Bean.ParamBeanXXXXXXXXXXXXXX> {

    public AddLabelAdapter(Context context, int layoutId, List data) {
        super(context, layoutId, data);
    }




    @Override
    protected void convert(BaseViewHolder holder, PeizhiBean.DataBean._$15Bean.ParamBeanXXXXXXXXXXXXXX bean) {
        holder.setText(R.id.tv_need_tags,bean.getParam());
    }
}
