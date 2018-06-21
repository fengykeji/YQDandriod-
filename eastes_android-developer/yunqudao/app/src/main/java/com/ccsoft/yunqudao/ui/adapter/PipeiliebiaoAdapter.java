package com.ccsoft.yunqudao.ui.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.PeizhiBean;
import com.ccsoft.yunqudao.bean.PipeiBean;
import com.ccsoft.yunqudao.data.AppConstants;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.BaseViewHolder;
import com.ccsoft.yunqudao.ui.mian.MainActivity;

import java.util.List;

public class PipeiliebiaoAdapter extends BaseRecyclerAdapter<PipeiBean.DataBean.ListBean>{
    public PipeiliebiaoAdapter(Context context, int layoutId, List data) {
        super(context, layoutId, data);
    }



    @Override
    protected void convert(BaseViewHolder holder, PipeiBean.DataBean.ListBean bean) {
        holder.setText(R.id.content_tv1,"匹配度："+bean.getSort());

        holder.setImageResource(R.id.icon_iv, AppConstants.URL + bean.getImg_url());
        if (bean.getBrokerSortCompare() == 1) {
            holder.setImageResource(R.id.icon_iv2, R.drawable.ic_rising);
        } else if (bean.getBrokerSortCompare() == 2) {
            holder.setImageResource(R.id.icon_iv2, R.drawable.ic_falling);
        } else {
            holder.setVisible(R.id.icon_iv2, View.INVISIBLE);
        }

        holder.setText(R.id.content_tv3, bean.getAbsolute_address());
        holder.setText(R.id.number, "第" + bean.getSort() + "名");
        if (bean.getCycle() == 0) {
            holder.setImageResource(R.id.im_dian1, R.drawable.ic_lightning_1);
            holder.setImageResource(R.id.im_dian2, R.drawable.ic_lightning_1);
            holder.setImageResource(R.id.im_dian3, R.drawable.ic_lightning_1);
            holder.setImageResource(R.id.im_dian4, R.drawable.ic_lightning_1);
            holder.setImageResource(R.id.im_dian5, R.drawable.ic_lightning_1);
        } else if (bean.getCycle() == 1) {
            holder.setImageResource(R.id.im_dian1, R.drawable.ic_lightning);
            holder.setImageResource(R.id.im_dian2, R.drawable.ic_lightning_1);
            holder.setImageResource(R.id.im_dian3, R.drawable.ic_lightning_1);
            holder.setImageResource(R.id.im_dian4, R.drawable.ic_lightning_1);
            holder.setImageResource(R.id.im_dian5, R.drawable.ic_lightning_1);
        } else if (bean.getCycle() == 2) {
            holder.setImageResource(R.id.im_dian1, R.drawable.ic_lightning);
            holder.setImageResource(R.id.im_dian2, R.drawable.ic_lightning);
            holder.setImageResource(R.id.im_dian3, R.drawable.ic_lightning_1);
            holder.setImageResource(R.id.im_dian4, R.drawable.ic_lightning_1);
            holder.setImageResource(R.id.im_dian5, R.drawable.ic_lightning_1);
        } else if (bean.getCycle() == 3) {
            holder.setImageResource(R.id.im_dian1, R.drawable.ic_lightning);
            holder.setImageResource(R.id.im_dian2, R.drawable.ic_lightning);
            holder.setImageResource(R.id.im_dian3, R.drawable.ic_lightning);
            holder.setImageResource(R.id.im_dian4, R.drawable.ic_lightning_1);
            holder.setImageResource(R.id.im_dian5, R.drawable.ic_lightning_1);
        } else if (bean.getCycle() == 4) {
            holder.setImageResource(R.id.im_dian1, R.drawable.ic_lightning);
            holder.setImageResource(R.id.im_dian2, R.drawable.ic_lightning);
            holder.setImageResource(R.id.im_dian3, R.drawable.ic_lightning);
            holder.setImageResource(R.id.im_dian4, R.drawable.ic_lightning);
            holder.setImageResource(R.id.im_dian5, R.drawable.ic_lightning_1);
        } else if (bean.getCycle() == 5) {
            holder.setImageResource(R.id.im_dian1, R.drawable.ic_lightning);
            holder.setImageResource(R.id.im_dian2, R.drawable.ic_lightning);
            holder.setImageResource(R.id.im_dian3, R.drawable.ic_lightning);
            holder.setImageResource(R.id.im_dian4, R.drawable.ic_lightning);
            holder.setImageResource(R.id.im_dian5, R.drawable.ic_lightning);
        }

        /**
         * 设置物业类型和项目标签
         */

        LinearLayout linearLayout = (LinearLayout) holder.getView(R.id.ll_property);
        LinearLayout linearLayout1 = (LinearLayout) holder.getView(R.id.ll_project_tags);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.leftMargin = 6;
        layoutParams.topMargin = 6;
        layoutParams.bottomMargin = 6;
        linearLayout.removeAllViews();
        linearLayout1.removeAllViews();
        PeizhiBean peizhiBean = MainActivity.savePeizhi();
        peizhiBean.getData().get_$16().getParam();
        peizhiBean.getData().get_$15().getParam();
        ImageView imageView;

        for (int i = 0; i < peizhiBean.getData().get_$16().getParam().size(); i++) {
            if (bean.getProperty_tags().size() > 0) {
                for (int j = 0; j < bean.getProperty_tags().size(); j++) {
                    if (peizhiBean.getData().get_$16().getParam().get(i).getId() == bean.getProperty_tags().get(j)) {
                        String s = peizhiBean.getData().get_$16().getParam().get(i).getParam();
                        if(true) {
                            imageView = new ImageView(context);
                            if (peizhiBean.getData().get_$16().getParam().get(i).getId() == 59) {
                                imageView.setImageResource(R.drawable.ic_residential2);
                                linearLayout.addView(imageView, layoutParams);
                            } else if (peizhiBean.getData().get_$16().getParam().get(i).getId() == 60) {
                                imageView.setImageResource(R.drawable.ic_apartment);
                                linearLayout.addView(imageView, layoutParams);
                            } else if (peizhiBean.getData().get_$16().getParam().get(i).getId() == 61) {
                                imageView.setImageResource(R.drawable.ic_officebuilding);
                                linearLayout.addView(imageView, layoutParams);
                            } else if (peizhiBean.getData().get_$16().getParam().get(i).getId() == 62) {
                                imageView.setImageResource(R.drawable.ic_shops);
                                linearLayout.addView(imageView, layoutParams);
                            } else if (peizhiBean.getData().get_$16().getParam().get(i).getId() == 64) {
                                imageView.setImageResource(R.drawable.ic_villa);
                                linearLayout.addView(imageView, layoutParams);
                            }
                        }
                    }
                }
            }
        }


        String ss = bean.getProject_tags();
        if (TextUtils.isEmpty(ss)) {
            return;
        }
        String[] b = ss.split(",");
        for (int i = 0; i < peizhiBean.getData().get_$15().getParam().size(); i++) {
            if (bean.getProject_tags().length() > 0) {
                for (int j = 0; j < b.length; j++) {
                    int h = Integer.parseInt(b[j]);
                    if (peizhiBean.getData().get_$15().getParam().get(i).getId() == h) {

                        imageView = new ImageView(context);
                        if (peizhiBean.getData().get_$15().getParam().get(i).getId() == 56) {
                            imageView.setImageResource(R.drawable.ic_elevatorroom);
                            linearLayout1.addView(imageView,layoutParams);
                        } else if (peizhiBean.getData().get_$15().getParam().get(i).getId() == 57) {
                            imageView.setImageResource(R.drawable.ic_schooldistrictroom);
                            linearLayout1.addView(imageView, layoutParams);
                        } else if (peizhiBean.getData().get_$15().getParam().get(i).getId() == 58) {
                            imageView.setImageResource(R.drawable.ic_subwayroom);
                            linearLayout1.addView(imageView, layoutParams);
                        }
                    }
                }
            }

        }
    }}

