package com.ccsoft.yunqudao.ui.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.HouseListBean;
import com.ccsoft.yunqudao.bean.PeizhiBean;
import com.ccsoft.yunqudao.data.AppConstants;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.BaseViewHolder;
import com.ccsoft.yunqudao.ui.mian.MainActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HouseListAdapter extends BaseRecyclerAdapter<HouseListBean.DataBean> {
    public HouseListAdapter(Context context, int layoutId, List<HouseListBean.DataBean> data) {
        super(context, layoutId, data);
    }

    ImageView imageView;
    @Override
    protected void convert(BaseViewHolder holder, HouseListBean.DataBean bean,int position) {
//        holder.setImageResource(R.id.icon_iv, AppConstants.URL + bean.getImg_url());
        ImageView imageView = (ImageView) holder.getView(R.id.icon_iv);
        Picasso.with(context).load(AppConstants.URL + bean.getImg_url())
                .error(R.drawable.default_da2)
                .fit()
                .into(imageView);
        if (bean.getBrokerSortCompare() == 1) {
            holder.setImageResource(R.id.icon_iv2, R.drawable.ic_rising);
        } else if (bean.getBrokerSortCompare() == 2) {
            holder.setImageResource(R.id.icon_iv2, R.drawable.ic_falling);
        } else {
            holder.setVisible(R.id.icon_iv2, View.INVISIBLE);
        }
        holder.setText(R.id.title_tv1, bean.getProject_name());

        if (bean.getSort() != 0 && bean.getCycle() != 0) {
            holder.setText(R.id.content_tv1, "荐");
        }
        if(bean.getGuarantee_brokerage()==1){
            holder.setText(R.id.content_tv4, "保证结佣");
        }
        holder.setText(R.id.content_tv3, bean.getAbsolute_address());
        holder.setText(R.id.number, "第" + bean.getSort()+ "名");
        if (bean.getCycle() == 0) {
            holder.setImageResource(R.id.im_dian1, R.drawable.ic_lightning_1);
            holder.setImageResource(R.id.im_dian2, R.drawable.ic_lightning_1);
            holder.setImageResource(R.id.im_dian3, R.drawable.ic_lightning_1);
            holder.setImageResource(R.id.im_dian4, R.drawable.ic_lightning_1);
            holder.setImageResource(R.id.im_dian5, R.drawable.ic_lightning_1);
        } else if (bean.getCycle()== 1) {
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
                            if (bean.getProperty_tags().get(j) == 59) {
                                imageView.setImageResource(R.drawable.ic_residential2);
                                linearLayout.addView(imageView, layoutParams);
                            } else if (bean.getProperty_tags().get(j) == 60) {
                                imageView.setImageResource(R.drawable.ic_apartment);
                                linearLayout.addView(imageView, layoutParams);
                            } else if (bean.getProperty_tags().get(j) == 63) {
                                imageView.setImageResource(R.drawable.ic_officebuilding);
                                linearLayout.addView(imageView, layoutParams);
                            } else if (bean.getProperty_tags().get(j) == 62) {
                                imageView.setImageResource(R.drawable.ic_shops);
                                linearLayout.addView(imageView, layoutParams);
                            } else if (bean.getProperty_tags().get(j) == 61) {
                                imageView.setImageResource(R.drawable.ic_villa);
                                linearLayout.addView(imageView, layoutParams);
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
//        for (int i = 0; i < peizhiBean.getData().get_$15().getParam().size(); i++) {
//            if (bean.getProject_tags().length() > 0) {
//                for (int j = 0; j < b.length; j++) {
//                    int h = Integer.parseInt(b[j]);
//                    if (peizhiBean.getData().get_$15().getParam().get(i).getId() == h) {
//
//                        imageView = new ImageView(context);
//                        if (peizhiBean.getData().get_$15().getParam().get(i).getId() == 56) {
//                            imageView.setImageResource(R.drawable.ic_elevatorroom);
//                            linearLayout1.addView(imageView,layoutParams);
//                        } else if (peizhiBean.getData().get_$15().getParam().get(i).getId() == 57) {
//                            imageView.setImageResource(R.drawable.ic_schooldistrictroom);
//                            linearLayout1.addView(imageView, layoutParams);
//                        } else if (peizhiBean.getData().get_$15().getParam().get(i).getId() == 58) {
//                            imageView.setImageResource(R.drawable.ic_subwayroom);
//                            linearLayout1.addView(imageView, layoutParams);
//                        }
//                    }
//                }
//            }
//
//        }

        List<PeizhiBean.DataBean._$15Bean.ParamBeanXXXXXXXXXXXXXX> list = peizhiBean.getData().get_$15().getParam();
        for (String s : b) {
            for (PeizhiBean.DataBean._$15Bean.ParamBeanXXXXXXXXXXXXXX bean3 : list) {
                if(bean3.getId()==Integer.parseInt(s)){
                    TextView textView = new TextView(context);
                    textView.setText(bean3.getParam());
                    textView.setTextSize(10);
                    textView.setBackgroundResource(R.drawable.shape_laber);
                    textView.setPadding(15,5,15,5);
                    linearLayout1.addView(textView,layoutParams);
                }
            }
        }

    }
    }

