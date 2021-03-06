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
    int Cycle;


    public ProjectYongjinAdapter(Context context, int layoutId, List<ProjectGetRuleBean.DataBean.PersonBean> data,
                                 ArrayList<ProjectGetRuleBean.DataBean> list,int Cycle ) {
        super(context, layoutId, data);
        this.list = list;
        this.Cycle = Cycle;
    }



    @Override
    protected void convert(BaseViewHolder holder, ProjectGetRuleBean.DataBean.PersonBean bean ,int position) {





        if(position==0){
            holder.setVisible(R.id.ll_closeyongjin,View.VISIBLE);
        }else {
            holder.setVisible(R.id.ll_closeyongjin,View.GONE);
        }
        if (Cycle == 0) {
            holder.setImageResource(R.id.im_dian1, R.drawable.ic_lightning_1);
            holder.setImageResource(R.id.im_dian2, R.drawable.ic_lightning_1);
            holder.setImageResource(R.id.im_dian3, R.drawable.ic_lightning_1);
            holder.setImageResource(R.id.im_dian4, R.drawable.ic_lightning_1);
            holder.setImageResource(R.id.im_dian5, R.drawable.ic_lightning_1);
        } else if (Cycle== 1) {
            holder.setImageResource(R.id.im_dian1, R.drawable.ic_lightning);
            holder.setImageResource(R.id.im_dian2, R.drawable.ic_lightning_1);
            holder.setImageResource(R.id.im_dian3, R.drawable.ic_lightning_1);
            holder.setImageResource(R.id.im_dian4, R.drawable.ic_lightning_1);
            holder.setImageResource(R.id.im_dian5, R.drawable.ic_lightning_1);
        } else if (Cycle == 2) {
            holder.setImageResource(R.id.im_dian1, R.drawable.ic_lightning);
            holder.setImageResource(R.id.im_dian2, R.drawable.ic_lightning);
            holder.setImageResource(R.id.im_dian3, R.drawable.ic_lightning_1);
            holder.setImageResource(R.id.im_dian4, R.drawable.ic_lightning_1);
            holder.setImageResource(R.id.im_dian5, R.drawable.ic_lightning_1);
        } else if (Cycle == 3) {
            holder.setImageResource(R.id.im_dian1, R.drawable.ic_lightning);
            holder.setImageResource(R.id.im_dian2, R.drawable.ic_lightning);
            holder.setImageResource(R.id.im_dian3, R.drawable.ic_lightning);
            holder.setImageResource(R.id.im_dian4, R.drawable.ic_lightning_1);
            holder.setImageResource(R.id.im_dian5, R.drawable.ic_lightning_1);
        } else if (Cycle == 4) {
            holder.setImageResource(R.id.im_dian1, R.drawable.ic_lightning);
            holder.setImageResource(R.id.im_dian2, R.drawable.ic_lightning);
            holder.setImageResource(R.id.im_dian3, R.drawable.ic_lightning);
            holder.setImageResource(R.id.im_dian4, R.drawable.ic_lightning);
            holder.setImageResource(R.id.im_dian5, R.drawable.ic_lightning_1);
        } else if (Cycle == 5) {
            holder.setImageResource(R.id.im_dian1, R.drawable.ic_lightning);
            holder.setImageResource(R.id.im_dian2, R.drawable.ic_lightning);
            holder.setImageResource(R.id.im_dian3, R.drawable.ic_lightning);
            holder.setImageResource(R.id.im_dian4, R.drawable.ic_lightning);
            holder.setImageResource(R.id.im_dian5, R.drawable.ic_lightning);
        }

        for (int i = 0; i < list.size(); i++) {
            holder.setText(R.id.tv_yongjinguize, list.get(i).getDescribe());
            holder.setText(R.id.tv_paiming, "第" + list.get(i).getStandard() + "名");


            if(list.get(i).getPerson()!=null) {
                for (int i1 = 0; i1 < list.get(i).getPerson().size(); i1++) {
                    if (list.get(i).getPerson().get(i1).getAct_end().equals("2037-12-31 23:59:59")) {
                        holder.setText(R.id.tv_startTime, list.get(i).getPerson().get(i1).getAct_start() + "起");
                    } else {
                        holder.setText(R.id.tv_startTime, list.get(i).getPerson().get(i1).getAct_start() + "至" +
                                bean.getAct_end());
                    }
                    holder.setText(R.id.tv_jieyong, list.get(i).getPerson().get(i1).getCommission_describe());

                }
            }
        }



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
