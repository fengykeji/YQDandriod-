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
import com.ccsoft.yunqudao.data.model.response.RecordValidData;
import com.ccsoft.yunqudao.utils.recyclerviwe.BaseRecyclerViewAdapter;
import com.ccsoft.yunqudao.utils.recyclerviwe.BaseRecyclerViewHolder;
import java.util.List;

/**
 * author lzx
 * Created on 2018/5/27.
 */

public class RecordValidAdapter extends BaseRecyclerAdapter<RecordValidData.DataBean>{


    public RecordValidAdapter(Context context, int layoutId, List<RecordValidData.DataBean> data) {
        super(context, layoutId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, RecordValidData.DataBean bean,int position) {
        holder.setText(R.id.name_tv,bean.name);
        holder.setText(R.id.num_tv,String.valueOf(bean.client_id));
        holder.setText(R.id.place_tv,bean.project_name);
        holder.setText(R.id.start_date_tv,bean.property_advicer_wish+"");
        holder.setText(R.id.end_date_tv,bean.allot_time+"");
        holder.setText(R.id.status_tv,bean.current_state);

        holder.setOnclick(R.id.phone_iv, new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
