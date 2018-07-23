package com.ccsoft.yunqudao.ui.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.GuanZhuBean;
import com.ccsoft.yunqudao.bean.PeizhiBean;
import com.ccsoft.yunqudao.data.AppConstants;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.BaseViewHolder;
import com.ccsoft.yunqudao.ui.mian.MainActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

import static android.view.View.GONE;

public class GuanZhuAdapter extends BaseRecyclerAdapter<GuanZhuBean.DataBean> {
    public GuanZhuAdapter(Context context, int layoutId, List<GuanZhuBean.DataBean> data) {
        super(context, layoutId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, GuanZhuBean.DataBean bean, int position) {
        ImageView imageView = (ImageView) holder.getView(R.id.icon_iv);
        Picasso.with(context).load(AppConstants.URL + bean.getImg_url())
                .error(R.drawable.default_1)
                .fit()
                .into(imageView);

        holder.setText(R.id.title_tv1, bean.getProject_name());

        if (bean.getGuarantee_brokerage()==2) {
            holder.setText(R.id.content_tv1, "荐");
        }else if(bean.getGuarantee_brokerage()==1){
            holder.setText(R.id.content_tv4, "保证结佣");
        }
        holder.setText(R.id.content_tv3, bean.getAbsolute_address());



        /**
         * 设置物业类型和项目标签
         */

        LinearLayout linearLayout = (LinearLayout) holder.getView(R.id.ll_property);
        LinearLayout linearLayout1 = (LinearLayout) holder.getView(R.id.ll_project_tags);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.leftMargin = 16;
        layoutParams.topMargin = 16;
        layoutParams.bottomMargin = 16;
        linearLayout.removeAllViews();
        linearLayout1.removeAllViews();
        PeizhiBean peizhiBean = MainActivity.savePeizhi();
        peizhiBean.getData().get_$16().getParam();
        peizhiBean.getData().get_$15().getParam();

        if(bean.getProperty_tags()!=null){
            if (bean.getProperty_tags().size() > 0) {
                linearLayout.removeAllViews();
                for (int j = 0; j < bean.getProperty_tags().size(); j++) {
                    if(true) {
                        imageView = new ImageView(context);
                        if (bean.getProperty_tags().get(j).equals("住宅")) {
                            imageView.setImageResource(R.drawable.ic_residential2);
                            linearLayout.addView(imageView, layoutParams);
                        } else if (bean.getProperty_tags().get(j).equals("公寓")) {
                            imageView.setImageResource(R.drawable.ic_apartment);
                            linearLayout.addView(imageView, layoutParams);
                        } else if (bean.getProperty_tags().get(j).equals("写字楼")) {
                            imageView.setImageResource(R.drawable.ic_officebuilding);
                            linearLayout.addView(imageView, layoutParams);
                        } else if (bean.getProperty_tags().get(j).equals("商铺")) {
                            imageView.setImageResource(R.drawable.ic_shops);
                            linearLayout.addView(imageView, layoutParams);
                        } else if (bean.getProperty_tags().get(j).equals("别墅")) {
                            imageView.setImageResource(R.drawable.ic_villa);
                            linearLayout.addView(imageView, layoutParams);
                        }
                    }
                }
            }
        }


        List<String> ss = bean.getProject_tags_name();
        if (ss.size()==0) {
            return;
        }

        List<PeizhiBean.DataBean._$15Bean.ParamBeanXXXXXXXXXXXXXX> list = peizhiBean.getData().get_$15().getParam();
        for (String s : ss) {
            for (PeizhiBean.DataBean._$15Bean.ParamBeanXXXXXXXXXXXXXX bean3 : list) {
                if(bean3.getParam().equals(s)){
                    TextView textView = new TextView(context);
                    textView.setText(bean3.getParam());
                    textView.setTextSize(13);
                    textView.setBackgroundResource(R.drawable.shape_laber);
                    textView.setPadding(10,1,10,1);
                    linearLayout1.addView(textView,layoutParams);
                }
            }
        }
        holder.setVisible(R.id.ll_yongjing,GONE);
    }
    }

