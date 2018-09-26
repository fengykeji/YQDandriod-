package com.ccsoft.yunqudao.ui.adapter;

import android.content.Context;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.GongZuoJingLiBean;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.BaseViewHolder;

import java.util.List;

public class GongZuoJingLiAdapter extends BaseRecyclerAdapter<GongZuoJingLiBean.DataBean> {
    public GongZuoJingLiAdapter(Context context, int layoutId, List<GongZuoJingLiBean.DataBean> data) {
        super(context, layoutId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, GongZuoJingLiBean.DataBean bean, int position) {

        if (position<data.size()-1) {
            holder.setText(R.id.me_workjingli_time, bean.getQuit_time() + "至" + bean.getEntry_time());
            holder.setText(R.id.tv_companyname, bean.getCompany_name());
            holder.setText(R.id.tv_tuijiannum, "推荐客户数量：" + bean.getHis().getRecommend());
            holder.setText(R.id.tv_daofangnum, "到访客户数量：" + bean.getHis().getValue());
            holder.setText(R.id.tv_chengjiaonum, "成交客户数量：" + bean.getHis().getDeal());
            holder.setText(R.id.tv_jingjiren, bean.getRole());
        }else if(data.size()-1 == position){
            holder.setImageResource(R.id.bar_blue,R.drawable.blue);
            holder.setText(R.id.me_workjingli_time, bean.getQuit_time() + "至" + bean.getEntry_time());
            holder.setText(R.id.tv_companyname, bean.getCompany_name());
            holder.setText(R.id.tv_tuijiannum, "推荐客户数量：" + bean.getHis().getRecommend());
            holder.setText(R.id.tv_daofangnum, "到访客户数量：" + bean.getHis().getValue());
            holder.setText(R.id.tv_chengjiaonum, "成交客户数量：" + bean.getHis().getDeal());
        }
    }
}
