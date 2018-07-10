package com.ccsoft.yunqudao.ui.adapter;

import android.content.Context;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.PeizhiBean;
import com.ccsoft.yunqudao.bean.ProjectPiPeiKeHuBean;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.BaseViewHolder;
import com.ccsoft.yunqudao.ui.mian.MainActivity;

import java.util.List;

public class ProjectPiPeiAdapter extends BaseRecyclerAdapter<ProjectPiPeiKeHuBean.DataBean> {
    public ProjectPiPeiAdapter(Context context, int layoutId, List<ProjectPiPeiKeHuBean.DataBean> data) {
        super(context, layoutId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, ProjectPiPeiKeHuBean.DataBean bean, int position) {
        holder.setText(R.id.tv_name1,bean.getName());
        holder.setText(R.id.tv_zongjia1,bean.getPrice()+"万");
        PeizhiBean peizhiBean = MainActivity.savePeizhi();
        for (PeizhiBean.DataBean._$9Bean.ParamBeanXXXXXXXX bean1 : peizhiBean.getData().get_$9().getParam()) {
            if(!bean.getHouse_type().equals("")) {
                if (bean1.getId() == Integer.parseInt(bean.getHouse_type())) {
                    holder.setText(R.id.tv_huxin1, bean1.getParam());
                }
            }
        }

        holder.setText(R.id.tv_quyu1,bean.getRegion().get(0).getProvince_name()+"-"+
        bean.getRegion().get(0).getCity_name()+"-"+bean.getRegion().get(0).getDistrict_name());
        holder.setText(R.id.tv_intents1,bean.getIntent()+"");
        holder.setText(R.id.tv_urgency,bean.getUrgency()+"");
        holder.setText(R.id.tv_pepeidu,bean.getScore()+"%");
        holder.setText(R.id.tv_telnum1,bean.getTel());

    }
}
