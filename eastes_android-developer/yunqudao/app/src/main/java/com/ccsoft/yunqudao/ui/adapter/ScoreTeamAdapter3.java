package com.ccsoft.yunqudao.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.GetDistrictListBean;
import com.ccsoft.yunqudao.bean.PeizhiBean;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

public class ScoreTeamAdapter3 extends BaseRecyclerAdapter<PeizhiBean.DataBean._$15Bean.ParamBeanXXXXXXXXXXXXXX> {

    private ArrayList<Integer> isCheck = new ArrayList<>();//控件是否被点击,默认为false，如果被点击，改变值，控件根据值改变自身颜色

    private boolean flag = true;

    public ScoreTeamAdapter3(Context context, int layoutId, List<PeizhiBean.DataBean._$15Bean.ParamBeanXXXXXXXXXXXXXX> data) {
        super(context, layoutId, data);

    }

    @Override
    protected void convert(BaseViewHolder holder, PeizhiBean.DataBean._$15Bean.ParamBeanXXXXXXXXXXXXXX bean, int position) {
        holder.setText(R.id.biaoqian, bean.getParam());
//        CheckBox checkBox = (CheckBox) holder.getView(R.id.biaoqian);



//        checkBox.setChecked(bean.isSelected());
//
//            checkBox.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view){
//                    int c = context.getResources().getColor(R.color.liji_material_blue_500);
//                    if(isCheck.contains(position)){
//                        checkBox.setChecked(false);
//                    }else {
//                        isCheck.clear();
//                        isCheck.add(position);
//                        checkBox.setChecked(true);
//                    }
//
//
//                }
//            });

    }


}
