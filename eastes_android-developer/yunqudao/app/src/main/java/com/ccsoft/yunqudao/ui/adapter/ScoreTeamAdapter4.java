package com.ccsoft.yunqudao.ui.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.PeizhiBean;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.BaseViewHolder;

import java.util.List;

public class ScoreTeamAdapter4 extends BaseRecyclerAdapter<PeizhiBean.DataBean._$9Bean.ParamBeanXXXXXXXX> {
    public ScoreTeamAdapter4(Context context, int layoutId, List<PeizhiBean.DataBean._$9Bean.ParamBeanXXXXXXXX> data) {
        super(context, layoutId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, PeizhiBean.DataBean._$9Bean.ParamBeanXXXXXXXX bean, int position) {
        holder.setText(R.id.biaoqian,bean.getParam());
        TextView textView = (TextView) holder.getView(R.id.biaoqian);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int c = context.getResources().getColor(R.color.liji_material_blue_500);
                textView.setBackgroundResource(R.color.liji_material_blue_500);
            }
        });

    }
}
