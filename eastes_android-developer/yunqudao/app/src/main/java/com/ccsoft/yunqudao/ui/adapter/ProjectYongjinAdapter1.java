package com.ccsoft.yunqudao.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.ProjectGetRuleBean;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

public class ProjectYongjinAdapter1 extends BaseRecyclerAdapter<ProjectGetRuleBean.DataBean>  {
    LinearLayout ll_showguize,ll_gone,ll_gone1;
    int expandPosition = -1;
    private ArrayList<ProjectGetRuleBean.DataBean> list = new ArrayList<>();
    int Cycle;


    public ProjectYongjinAdapter1(Context context, int layoutId, List<ProjectGetRuleBean.DataBean> data) {
        super(context, layoutId, data);

    }



    @Override
    protected void convert(BaseViewHolder holder, ProjectGetRuleBean.DataBean bean ,int position) {




            holder.setVisible(R.id.ll_closeyongjin,View.GONE);
            holder.setVisible(R.id.ll_closebiaozhun,View.GONE);



            holder.setText(R.id.tv_startTime, bean.getBegin_time() + "至" +
                    bean.getEnd_time());

        holder.setText(R.id.tv_yongjinguize, bean.getDescribe());

            holder.setVisible(R.id.ll_showguize,position == expandPosition ? View.VISIBLE : View.GONE);
            holder.setOnclick(R.id.ib_showguize, new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    togglePosition(position);
                }
            });

        }




    public void togglePosition(int position) {
        if (expandPosition != position) {
            notifyItemChanged(expandPosition);
            expandPosition = position;
        } else {
            expandPosition = -1;
        }
        notifyItemChanged(position);
    }
}
