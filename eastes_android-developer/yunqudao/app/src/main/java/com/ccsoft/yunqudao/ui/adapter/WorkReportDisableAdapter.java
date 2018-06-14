package com.ccsoft.yunqudao.ui.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.BaseViewHolder;
import com.ccsoft.yunqudao.data.model.response.WorkReportDisableData;
import com.ccsoft.yunqudao.utils.recyclerviwe.BaseRecyclerViewAdapter;
import com.ccsoft.yunqudao.utils.recyclerviwe.BaseRecyclerViewHolder;
import java.util.List;

/**
 * author lzx
 * Created on 2018/5/28.
 */

public class WorkReportDisableAdapter extends BaseRecyclerAdapter<WorkReportDisableData.DataBean>{


    public WorkReportDisableAdapter(Context context, int layoutId, List<WorkReportDisableData.DataBean> data) {
        super(context, layoutId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, WorkReportDisableData.DataBean bean) {
        holder.setText(R.id.name_tv,bean.name);
        holder.setText(R.id.num_tv,String.valueOf(bean.client_id));
        holder.setText(R.id.place_tv,bean.project_name);
        holder.setText(R.id.start_date_tv,bean.allot_time+"");
        holder.setText(R.id.end_date_tv,bean.state_change_time+"");
        holder.setText(R.id.status_tv,bean.disabled_state+"");
        holder.setOnclick(R.id.phone_iv, new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
