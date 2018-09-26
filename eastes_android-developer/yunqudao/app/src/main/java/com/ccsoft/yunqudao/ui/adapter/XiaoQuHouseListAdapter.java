package com.ccsoft.yunqudao.ui.adapter;

import android.content.Context;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.XiaoQuHouseListBean;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.BaseViewHolder;

import java.util.List;

public class XiaoQuHouseListAdapter extends BaseRecyclerAdapter<XiaoQuHouseListBean.DataBeanX.DataBean>{
    public XiaoQuHouseListAdapter(Context context, int layoutId, List<XiaoQuHouseListBean.DataBeanX.DataBean> data) {
        super(context, layoutId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, XiaoQuHouseListBean.DataBeanX.DataBean bean, int position) {

        holder.setText(R.id.title_tv1,bean.getProject_name());
        holder.setText(R.id.content_tv3,bean.getAbsolute_address());
        holder.setText(R.id.tv_woye1,bean.getAverage_price()+"");
        holder.setText(R.id.tv_mendian1,bean.getOn_sale()+"");
        holder.setText(R.id.tv_woye,bean.getProject_code());
        holder.setText(R.id.tv_mendian,bean.getSale_focus_num()+"");
    }
}
