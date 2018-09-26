package com.ccsoft.yunqudao.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.SecondHouseListBean;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.BaseViewHolder;

import java.lang.reflect.Array;
import java.util.List;

public class SecondHouseListAdapter extends BaseRecyclerAdapter<SecondHouseListBean.DataBeanX.DataBean> {
    public SecondHouseListAdapter(Context context, int layoutId, List<SecondHouseListBean.DataBeanX.DataBean> data) {
        super(context, layoutId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, SecondHouseListBean.DataBeanX.DataBean bean, int position) {

        holder.setText(R.id.title_tv1,bean.getTitle());
        holder.setText(R.id.title2,bean.getPrice()+"");
        holder.setText(R.id.title3,bean.getUnit_price()+"");
        if(bean.getPrice_change()==1){
            holder.setImageResource(R.id.icon_iv2,R.drawable.ic_rising);
        }else if(bean.getPrice_change() == 2){
            holder.setImageResource(R.id.icon_iv2, R.drawable.ic_falling);
        }else {
            holder.setVisible(R.id.icon_iv2, View.INVISIBLE);
        }
        holder.setText(R.id.content_tv3,bean.getDescribe());
        holder.setText(R.id.tv_woye,bean.getProperty_type());
        holder.setText(R.id.tv_mendian,bean.getStore_name());

        /**
         * 设置标签
         */

        LinearLayout linearLayout1 = (LinearLayout) holder.getView(R.id.ll_property);
        LinearLayout linearLayout = (LinearLayout) holder.getView(R.id.ll_project_tags);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.leftMargin = 16;
        layoutParams.topMargin = 16;
        layoutParams.bottomMargin = 16;
        linearLayout.removeAllViews();
        linearLayout1.removeAllViews();

        List<String> project_tags = bean.getProject_tags();
        for (String project_tag : project_tags) {
            TextView textView = new TextView(context);
            textView.setText(project_tag);
            textView.setTextSize(10);
            textView.setBackgroundResource(R.drawable.shape_laber);
            textView.setPadding(15,5,15,5);
            linearLayout1.addView(textView,layoutParams);
        }

        List<String> house_tags = bean.getHouse_tags();
        for (String house_tag : house_tags) {
            TextView textView = new TextView(context);
            textView.setText(house_tag);
            textView.setTextSize(10);
            textView.setBackgroundResource(R.drawable.shape_laber);
            textView.setPadding(15,5,15,5);
            linearLayout.addView(textView,layoutParams);
        }
    }
}
