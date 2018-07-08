package com.ccsoft.yunqudao.ui.adapter;

import android.content.Context;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.GetCompanyListBean;
import com.ccsoft.yunqudao.data.AppConstants;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.BaseViewHolder;

import java.util.List;

public class GongSiRenZhengLiBiaoAdapter extends BaseRecyclerAdapter<GetCompanyListBean.DataBeanX.DataBean> {
    public GongSiRenZhengLiBiaoAdapter(Context context, int layoutId, List data) {
        super(context, layoutId, data);
    }



    @Override
    protected void convert(BaseViewHolder holder, GetCompanyListBean.DataBeanX.DataBean bean, int position) {
        holder.setImageResource(R.id.im_photo, AppConstants.URL+bean.getLogo());
        holder.setText(R.id.tv_companyname,bean.getCompany_name());
        holder.setText(R.id.tv_content,bean.getAbsolute_address());
        holder.setText(R.id.tv_tel,"联系方式："+bean.getContact_tel());
        holder.setText(R.id.tv_person,"负责人："+bean.getContact());
    }
}
