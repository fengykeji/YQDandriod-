package com.ccsoft.yunqudao.ui.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.BaseViewHolder;
import com.ccsoft.yunqudao.data.model.response.BrokerWaitConfirmData;
import com.ccsoft.yunqudao.data.model.response.BrrokerValueData;
import com.ccsoft.yunqudao.utils.recyclerviwe.BaseRecyclerViewAdapter;
import com.ccsoft.yunqudao.utils.recyclerviwe.BaseRecyclerViewHolder;
import java.util.List;

/**
 * desc   :
 * author : YangFan
 * date   : 2018/5/27 19:47
 * email  : 928902646@qq.com
 */
public class WorkRecommendValidAdapter extends BaseRecyclerAdapter<BrrokerValueData.ValueData> {


    public WorkRecommendValidAdapter(Context context, int layoutId, List<BrrokerValueData.ValueData> data) {
        super(context, layoutId, data);
    }


    @Override
    protected void convert(BaseViewHolder holder, BrrokerValueData.ValueData bean,int position) {
        holder.setText(R.id.name,bean.name);
        holder.setText(R.id.recommend_num,String.valueOf(bean.client_id));
        holder.setText(R.id.recommend_name,bean.project_name);
        holder.setText(R.id.time,"到访时间: " + bean.visit_time);
        holder.setText(R.id.result,bean.current_state);

        holder.setVisible(R.id.phone,View.GONE);
    }
}
