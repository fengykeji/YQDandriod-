package com.ccsoft.yunqudao.ui.adapter;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.BaseViewHolder;
import com.ccsoft.yunqudao.data.model.response.BrrokerDisabledData;
import com.ccsoft.yunqudao.data.model.response.BrrokerValueData;
import com.ccsoft.yunqudao.utils.RxPermissionUtil;
import com.ccsoft.yunqudao.utils.recyclerviwe.BaseRecyclerViewAdapter;
import com.ccsoft.yunqudao.utils.recyclerviwe.BaseRecyclerViewHolder;
import java.util.List;
import rx.functions.Action1;

/**
 * desc   :
 * author : YangFan
 * date   : 2018/5/27 19:47
 * email  : 928902646@qq.com
 */
public class WorkRecommendDisableAdapter extends BaseRecyclerAdapter<BrrokerDisabledData.DisabledData> {

    private OnCallListener mOnCallListener;

    public WorkRecommendDisableAdapter(Context context, int layoutId, List<BrrokerDisabledData.DisabledData> data) {
        super(context, layoutId, data);
    }

    public void setOnCallListener(OnCallListener listener) {
        this.mOnCallListener = listener;
    }

    @Override
    protected void convert(BaseViewHolder holder, BrrokerDisabledData.DisabledData bean) {

        holder.setText(R.id.name,bean.name);
        holder.setText(R.id.recommend_num,String.valueOf(bean.client_id));
        holder.setText(R.id.recommend_name,bean.project_name);
        holder.setText(R.id.time,"失效时间: " + bean.state_change_time);
        holder.setText(R.id.result,bean.current_state);

        holder.setOnclick(R.id.phone, new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
