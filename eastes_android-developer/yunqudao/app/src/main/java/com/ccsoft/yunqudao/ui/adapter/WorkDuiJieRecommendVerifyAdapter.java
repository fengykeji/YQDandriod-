package com.ccsoft.yunqudao.ui.adapter;

import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.ButterWaitConfirmbean;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.BaseViewHolder;
import com.ccsoft.yunqudao.data.model.response.BrokerWaitConfirmData;
import com.ccsoft.yunqudao.utils.ItemsDialogFragment;

import java.util.List;

public class WorkDuiJieRecommendVerifyAdapter extends BaseRecyclerAdapter<ButterWaitConfirmbean.DataBeanX.DataBean>{


    private FragmentManager fragmentManager ;
    public WorkDuiJieRecommendVerifyAdapter(Context context, int layoutId, List<ButterWaitConfirmbean.DataBeanX.DataBean> data) {
        super(context, layoutId, data);
        this.fragmentManager = fragmentManager;
    }
    @Override
    protected void convert(BaseViewHolder holder, ButterWaitConfirmbean.DataBeanX.DataBean bean, int position) {
        holder.setText(R.id.name,bean.getName());
        holder.setText(R.id.recommend_num,String.valueOf(bean.getClient_id()));
        holder.setText(R.id.recommend_name,bean.getProject_name());
        holder.setText(R.id.timsLimit,bean.getTimsLimit());
        holder.setText(R.id.address,bean.getAbsolute_address());




    }


}
