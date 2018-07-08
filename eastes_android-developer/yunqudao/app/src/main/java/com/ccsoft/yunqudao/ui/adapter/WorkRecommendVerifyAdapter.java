package com.ccsoft.yunqudao.ui.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.BaseViewHolder;
import com.ccsoft.yunqudao.data.model.response.BrokerWaitConfirmData;
import com.ccsoft.yunqudao.utils.recyclerviwe.BaseRecyclerViewAdapter;
import com.ccsoft.yunqudao.utils.recyclerviwe.BaseRecyclerViewHolder;
import java.util.List;

/**
 * desc   :
 * author : YangFan
 * date   : 2018/5/27 19:47
 * email  : 928902646@qq.com
 */
public class WorkRecommendVerifyAdapter extends BaseRecyclerAdapter<BrokerWaitConfirmData.WaitConfirmData>{


    public WorkRecommendVerifyAdapter(Context context, int layoutId, List<BrokerWaitConfirmData.WaitConfirmData> data) {
        super(context, layoutId, data);
    }
    @Override
    protected void convert(BaseViewHolder holder, BrokerWaitConfirmData.WaitConfirmData bean,int position) {
        holder.setText(R.id.name,bean.name);
        holder.setText(R.id.recommend_num,String.valueOf(bean.client_id));
        holder.setText(R.id.recommend_name,bean.project_name);
        holder.setText(R.id.timsLimit,bean.timsLimit);
        holder.setText(R.id.address,bean.absolute_address);
    }
}
