package com.ccsoft.yunqudao.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.TextView;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.ProjectDanYuanBean;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.BaseViewHolder;

import java.util.List;

public class ProjectDanYuan1Adapter  extends BaseRecyclerAdapter<ProjectDanYuanBean.DataBean.LISTBean>{
    public ProjectDanYuan1Adapter(Context context, int layoutId, List<ProjectDanYuanBean.DataBean.LISTBean> data) {
        super(context, layoutId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, ProjectDanYuanBean.DataBean.LISTBean bean, int position) {
        holder.setText(R.id.tv_danyuan,bean.getFJMC());
        TextView textView = (TextView) holder.getView(R.id.tv_danyuan);
        if(bean.getFJZT().equals("4")){
            textView.setBackgroundResource(R.color.saled);
        }
        if(bean.getFJZT().equals("2")||bean.getFJZT().equals("3")||bean.getFJZT().equals("5")
                ||bean.getFJZT().equals("6")
                ){
            textView.setBackgroundResource(R.color.yiding);
        }

    }
}
