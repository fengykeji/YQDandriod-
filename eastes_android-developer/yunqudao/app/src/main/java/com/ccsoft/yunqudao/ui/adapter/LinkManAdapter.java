package com.ccsoft.yunqudao.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.ProspectFinishBean;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.BaseViewHolder;
import com.ccsoft.yunqudao.ui.work.secondhandhouse.YeZhuInfoActivity;

import java.util.List;

public class LinkManAdapter extends BaseRecyclerAdapter<ProspectFinishBean.DataBean.ContactBean> {
    public LinkManAdapter(Context context, int layoutId, List<ProspectFinishBean.DataBean.ContactBean> data) {
        super(context, layoutId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, ProspectFinishBean.DataBean.ContactBean bean, int position) {
        holder.setText(R.id.tv_name1,bean.getName());
        holder.setText(R.id.tv_zongjia1,bean.getReport_type());
        holder.setText(R.id.tv_huxin1,bean.getTel()+"");

        holder.setOnclick(R.id.tv_chakanquanbu, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("bean",bean);
                Intent intent = new Intent(context,YeZhuInfoActivity.class);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

    }
}
