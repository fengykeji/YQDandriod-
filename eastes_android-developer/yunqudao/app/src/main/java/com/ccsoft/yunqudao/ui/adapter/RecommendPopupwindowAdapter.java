package com.ccsoft.yunqudao.ui.adapter;

import android.content.Context;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.GetHouseTypeDetailBean;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.BaseViewHolder;

import java.util.List;

public class RecommendPopupwindowAdapter extends BaseRecyclerAdapter<GetHouseTypeDetailBean.DataBean.RowsBean> {
    public RecommendPopupwindowAdapter(Context context, int layoutId, List<GetHouseTypeDetailBean.DataBean.RowsBean> data) {
        super(context, layoutId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, GetHouseTypeDetailBean.DataBean.RowsBean bean, int position) {
        holder.setText(R.id.tv_woye,bean.getRYXM());
    }
}
