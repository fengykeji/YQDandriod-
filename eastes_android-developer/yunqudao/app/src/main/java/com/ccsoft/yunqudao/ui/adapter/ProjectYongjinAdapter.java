package com.ccsoft.yunqudao.ui.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.ProjectGetRuleBean;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.BaseViewHolder;

import java.util.List;

public class ProjectYongjinAdapter extends BaseRecyclerAdapter<ProjectGetRuleBean.DataBean>  implements View.OnClickListener{
    LinearLayout ll_showguize,ll_gone,ll_gone1;
    public ProjectYongjinAdapter(Context context, int layoutId, List<ProjectGetRuleBean.DataBean> data) {
        super(context, layoutId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, ProjectGetRuleBean.DataBean bean ,int position) {

            for (ProjectGetRuleBean.DataBean.PersonBean personBean : bean.getPerson()) {
                if(personBean.getAct_end().equals("2037-12-31 23:59:59")) {
                    holder.setText(R.id.tv_startTime, bean.getBegin_time()+"起");
                }else {
                holder.setText(R.id.tv_startTime, personBean.getAct_start()+"至"+
                personBean.getAct_end());
                }
                holder.setText(R.id.tv_jieyong,personBean.getCommission_describe());
        }
        ImageButton imageButton = (ImageButton) holder.getView(R.id.ib_showguize);
        imageButton.setOnClickListener(this);

        ll_showguize = (LinearLayout) holder.getView(R.id.ll_showguize);
        ll_gone = (LinearLayout) holder.getView(R.id.ll_gone);
        ll_gone1 = (LinearLayout) holder.getView(R.id.ll_gone2);
        holder.setText(R.id.tv_yongjinguize,bean.getDescribe());
        holder.setText(R.id.tv_paiming,"第"+bean.getStandard()+"名");

        if(position>1){
            ll_gone.setVisibility(View.GONE);
            ll_gone1.setVisibility(View.GONE);
        }


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ib_showguize:
                if(ll_showguize.getVisibility()==View.GONE) {
                    ll_showguize.setVisibility(View.VISIBLE);
                }else {
                    ll_showguize.setVisibility(View.GONE);
                }
                break;
        }
    }
}
