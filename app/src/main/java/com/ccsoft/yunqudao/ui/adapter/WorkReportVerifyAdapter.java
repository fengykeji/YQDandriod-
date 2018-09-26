package com.ccsoft.yunqudao.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.BaseViewHolder;
import com.ccsoft.yunqudao.data.model.response.RecordAffirmBaseData;
import com.ccsoft.yunqudao.utils.recyclerviwe.BaseRecyclerViewAdapter;
import com.ccsoft.yunqudao.utils.recyclerviwe.BaseRecyclerViewHolder;
import java.util.List;

/**
 * author lzx
 * Created on 2018/5/27.
 */

public class WorkReportVerifyAdapter extends BaseRecyclerAdapter<RecordAffirmBaseData.DataBean> {


    public WorkReportVerifyAdapter(Context context, int layoutId, List<RecordAffirmBaseData.DataBean> data) {
        super(context, layoutId, data);
    }


    @Override
    protected void convert(BaseViewHolder holder, RecordAffirmBaseData.DataBean bean,int position) {
        holder.setText(R.id.name_tv,bean.name);
        holder.setText(R.id.num_tv,String.valueOf(bean.client_id));
        holder.setText(R.id.place_tv,bean.project_name);
        holder.setText(R.id.start_date_tv,bean.create_time+"");
        holder.setText(R.id.end_date_tv,bean.timsLimit+"");
        holder.setOnclick(R.id.phone_iv, new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
