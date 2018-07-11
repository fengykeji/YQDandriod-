package com.ccsoft.yunqudao.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.ProjectGetRuleBean;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

public class ProjectYongjinAdapter extends BaseRecyclerAdapter<ProjectGetRuleBean.DataBean.PersonBean>  {
    LinearLayout ll_showguize,ll_gone,ll_gone1;
    int expandPosition = -1;
    private ArrayList<ProjectGetRuleBean.DataBean> list = new ArrayList<>();


    public ProjectYongjinAdapter(Context context, int layoutId, List<ProjectGetRuleBean.DataBean.PersonBean> data,
                                 ArrayList<ProjectGetRuleBean.DataBean> list ) {
        super(context, layoutId, data);
        this.list = list;
    }

    @Override
    protected void convert(BaseViewHolder holder, ProjectGetRuleBean.DataBean.PersonBean bean ,int position) {



                if (bean.getAct_end().equals("2037-12-31 23:59:59")) {
                    holder.setText(R.id.tv_startTime, bean.getAct_start()+ "起");
                } else
                    {
                    holder.setText(R.id.tv_startTime, bean.getAct_start() + "至" +
                            bean.getAct_end());
                }
                holder.setText(R.id.tv_jieyong, bean.getCommission_describe());



            ll_showguize = (LinearLayout) holder.getView(R.id.ll_showguize);
            ll_gone = (LinearLayout) holder.getView(R.id.ll_gone);
            ll_gone1 = (LinearLayout) holder.getView(R.id.ll_gone2);

            holder.setText(R.id.tv_yongjinguize, list.get(position).getDescribe());
            holder.setText(R.id.tv_paiming, "第" + list.get(position).getStandard() + "名");

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
