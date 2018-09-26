package com.ccsoft.yunqudao.ui.adapter;

import android.content.Context;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.GetDistrictListBean;
import com.ccsoft.yunqudao.bean.PeizhiBean;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.BaseViewHolder;

import java.util.List;

public class ScoreTeamAdapter2 extends BaseRecyclerAdapter<GetDistrictListBean.DataBean> {
    public ScoreTeamAdapter2(Context context, int layoutId, List<GetDistrictListBean.DataBean> data) {
        super(context, layoutId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, GetDistrictListBean.DataBean bean, int position) {
        holder.setText(R.id.tv_woye,bean.getName());

    }
}
