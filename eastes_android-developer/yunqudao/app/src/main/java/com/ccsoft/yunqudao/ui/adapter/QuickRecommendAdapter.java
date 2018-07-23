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
import com.ccsoft.yunqudao.bean.PeizhiBean;
import com.ccsoft.yunqudao.data.AppConstants;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.BaseViewHolder;
import com.ccsoft.yunqudao.data.model.viewmodel.QuickRecommendViewModel;
import com.ccsoft.yunqudao.ui.mian.MainActivity;
import com.ccsoft.yunqudao.utils.GlideUtil;
import com.ccsoft.yunqudao.utils.recyclerviwe.BaseRecyclerViewAdapter;
import com.ccsoft.yunqudao.utils.recyclerviwe.BaseRecyclerViewHolder;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;



/**
 * desc   :
 * author : YangFan
 * date   : 2018/5/27 00:14
 * email  : 928902646@qq.com
 */
public class QuickRecommendAdapter extends BaseRecyclerAdapter<QuickRecommendViewModel> {
    List list = new ArrayList<>();
    ImageView imageView;

    public QuickRecommendAdapter(Context context, int layoutId, List<QuickRecommendViewModel> data) {
        super(context, layoutId, data);
    }

//    @Override
//    protected void convert(BaseRecyclerViewHolder viewHolder, QuickRecommendViewModel data, int position) {
//        ImageView icon_iv = viewHolder.getView(R.id.icon_iv);
//        ImageView icon_iv2 = viewHolder.getView(R.id.icon_iv2);
//        TextView title_tv1 = viewHolder.getView(R.id.title_tv1);
//        TextView content_tv1 = viewHolder.getView(R.id.content_tv1);
//        TextView content_tv3 = viewHolder.getView(R.id.content_tv3);
//        TextView content_tv4 = viewHolder.getView(R.id.content_tv4);
//        TextView number = viewHolder.getView(R.id.number);
//        GlideUtil.loadImage(AppConstants.URL+data.img_url, mContext, icon_iv, R.drawable.ic_launcher_background, false);
//        if (data.brokerSortCompare == 1) {//这个改成上升的
//            icon_iv2.setImageResource(R.drawable.ic_falling);
//        }
//        else if (data.brokerSortCompare == 2) {
//            icon_iv2.setImageResource(R.drawable.ic_falling);
//        }
//        else {
//            icon_iv2.setVisibility(View.INVISIBLE);
//        }
//        title_tv1.setText(data.project_name);
//        content_tv1.setText(data.sale_state);
//        content_tv3.setText(data.absolute_address);
//        number.setText("第" + data.sort + "名");
//    }


    @Override
    protected void convert(BaseViewHolder holder, QuickRecommendViewModel bean,int position) {


//        holder.setImageResource(R.id.icon_iv, AppConstants.URL + bean.img_url);
//        if (bean.brokerSortCompare == 1) {
//            holder.setImageResource(R.id.icon_iv2, R.drawable.ic_rising);
//        } else if (bean.brokerSortCompare == 2) {
//            holder.setImageResource(R.id.icon_iv2, R.drawable.ic_falling);
//        } else {
//            holder.setVisible(R.id.icon_iv2, View.INVISIBLE);
//        }
//        holder.setText(R.id.title_tv1, bean.project_name);
//        if (bean.sort != 0 && bean.brokerSortCompare != 0) {
//            holder.setText(R.id.content_tv1, "荐");
//            holder.setText(R.id.content_tv4, "保证结佣");
//        }
//        holder.setText(R.id.content_tv3, bean.absolute_address);
//        holder.setText(R.id.number, "第" + bean.sort + "名");
//        if (bean.cycle == 0) {
//            holder.setImageResource(R.id.im_dian1, R.drawable.ic_lightning_1);
//            holder.setImageResource(R.id.im_dian2, R.drawable.ic_lightning_1);
//            holder.setImageResource(R.id.im_dian3, R.drawable.ic_lightning_1);
//            holder.setImageResource(R.id.im_dian4, R.drawable.ic_lightning_1);
//            holder.setImageResource(R.id.im_dian5, R.drawable.ic_lightning_1);
//        } else if (bean.cycle == 1) {
//            holder.setImageResource(R.id.im_dian1, R.drawable.ic_lightning);
//            holder.setImageResource(R.id.im_dian2, R.drawable.ic_lightning_1);
//            holder.setImageResource(R.id.im_dian3, R.drawable.ic_lightning_1);
//            holder.setImageResource(R.id.im_dian4, R.drawable.ic_lightning_1);
//            holder.setImageResource(R.id.im_dian5, R.drawable.ic_lightning_1);
//        } else if (bean.cycle == 2) {
//            holder.setImageResource(R.id.im_dian1, R.drawable.ic_lightning);
//            holder.setImageResource(R.id.im_dian2, R.drawable.ic_lightning);
//            holder.setImageResource(R.id.im_dian3, R.drawable.ic_lightning_1);
//            holder.setImageResource(R.id.im_dian4, R.drawable.ic_lightning_1);
//            holder.setImageResource(R.id.im_dian5, R.drawable.ic_lightning_1);
//        } else if (bean.cycle == 3) {
//            holder.setImageResource(R.id.im_dian1, R.drawable.ic_lightning);
//            holder.setImageResource(R.id.im_dian2, R.drawable.ic_lightning);
//            holder.setImageResource(R.id.im_dian3, R.drawable.ic_lightning);
//            holder.setImageResource(R.id.im_dian4, R.drawable.ic_lightning_1);
//            holder.setImageResource(R.id.im_dian5, R.drawable.ic_lightning_1);
//        } else if (bean.cycle == 4) {
//            holder.setImageResource(R.id.im_dian1, R.drawable.ic_lightning);
//            holder.setImageResource(R.id.im_dian2, R.drawable.ic_lightning);
//            holder.setImageResource(R.id.im_dian3, R.drawable.ic_lightning);
//            holder.setImageResource(R.id.im_dian4, R.drawable.ic_lightning);
//            holder.setImageResource(R.id.im_dian5, R.drawable.ic_lightning_1);
//        } else if (bean.cycle == 5) {
//            holder.setImageResource(R.id.im_dian1, R.drawable.ic_lightning);
//            holder.setImageResource(R.id.im_dian2, R.drawable.ic_lightning);
//            holder.setImageResource(R.id.im_dian3, R.drawable.ic_lightning);
//            holder.setImageResource(R.id.im_dian4, R.drawable.ic_lightning);
//            holder.setImageResource(R.id.im_dian5, R.drawable.ic_lightning);
//        }
//
//        /**
//         * 设置物业类型和项目标签
//         */
//
//        LinearLayout linearLayout = (LinearLayout) holder.getView(R.id.ll_property);
//        LinearLayout linearLayout1 = (LinearLayout) holder.getView(R.id.ll_project_tags);
//        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        layoutParams.leftMargin = 6;
//        layoutParams.topMargin = 6;
//        layoutParams.bottomMargin = 6;
//        linearLayout.removeAllViews();
//        linearLayout1.removeAllViews();
//        PeizhiBean peizhiBean = MainActivity.savePeizhi();
//        peizhiBean.getData().get_$16().getParam();
//        peizhiBean.getData().get_$15().getParam();
//
//        for (int i = 0; i < peizhiBean.getData().get_$16().getParam().size(); i++) {
//            if (bean.property_tags.size() > 0) {
//                for (int j = 0; j < bean.property_tags.size(); j++) {
//                    if (peizhiBean.getData().get_$16().getParam().get(i).getId() == bean.property_tags.get(j)) {
//                        String s = peizhiBean.getData().get_$16().getParam().get(i).getParam();
//                        if(true) {
//                            imageView = new ImageView(context);
//                            if (peizhiBean.getData().get_$16().getParam().get(i).getId() == 59) {
//                                imageView.setImageResource(R.drawable.ic_residential2);
//                                linearLayout.addView(imageView, layoutParams);
//                            } else if (peizhiBean.getData().get_$16().getParam().get(i).getId() == 60) {
//                                imageView.setImageResource(R.drawable.ic_apartment);
//                                linearLayout.addView(imageView, layoutParams);
//                            } else if (peizhiBean.getData().get_$16().getParam().get(i).getId() == 61) {
//                                imageView.setImageResource(R.drawable.ic_officebuilding);
//                                linearLayout.addView(imageView, layoutParams);
//                            } else if (peizhiBean.getData().get_$16().getParam().get(i).getId() == 62) {
//                                imageView.setImageResource(R.drawable.ic_shops);
//                                linearLayout.addView(imageView, layoutParams);
//                            } else if (peizhiBean.getData().get_$16().getParam().get(i).getId() == 64) {
//                                imageView.setImageResource(R.drawable.ic_villa);
//                                linearLayout.addView(imageView, layoutParams);
//                            }
//                        }
//                    }
//                }
//            }
//        }
//
//
//        String ss = bean.project_tags;
//        if (TextUtils.isEmpty(ss)) {
//            return;
//        }
//        String[] b = ss.split(",");
//        for (int i = 0; i < peizhiBean.getData().get_$15().getParam().size(); i++) {
//            if (bean.project_tags.length() > 0) {
//                for (int j = 0; j < b.length; j++) {
//                    int h = Integer.parseInt(b[j]);
//                    if (peizhiBean.getData().get_$15().getParam().get(i).getId() == h) {
//
//                       imageView = new ImageView(context);
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
//    }

        ImageView imageView = (ImageView) holder.getView(R.id.icon_iv);
        Picasso.with(context).load(AppConstants.URL + bean.img_url)
                .error(R.drawable.default_1)
                .fit()
                .into(imageView);
        if (bean.brokerSortCompare == 1) {
            holder.setImageResource(R.id.icon_iv2, R.drawable.ic_rising);
        } else if (bean.brokerSortCompare == 2) {
            holder.setImageResource(R.id.icon_iv2, R.drawable.ic_falling);
        } else {
            holder.setVisible(R.id.icon_iv2, View.INVISIBLE);
        }
        holder.setText(R.id.title_tv1, bean.project_name);

        if (bean.sort != 0 && bean.cycle != 0) {
            holder.setText(R.id.content_tv1, "荐");
        }
        if(bean.guarantee_brokerage==1){
            holder.setText(R.id.content_tv4, "保证结佣");
        }
        holder.setText(R.id.content_tv3, bean.absolute_address);
        holder.setText(R.id.number, "第" + bean.sort+ "名");
        if (bean.cycle == 0) {
            holder.setImageResource(R.id.im_dian1, R.drawable.ic_lightning_1);
            holder.setImageResource(R.id.im_dian2, R.drawable.ic_lightning_1);
            holder.setImageResource(R.id.im_dian3, R.drawable.ic_lightning_1);
            holder.setImageResource(R.id.im_dian4, R.drawable.ic_lightning_1);
            holder.setImageResource(R.id.im_dian5, R.drawable.ic_lightning_1);
        } else if (bean.cycle== 1) {
            holder.setImageResource(R.id.im_dian1, R.drawable.ic_lightning);
            holder.setImageResource(R.id.im_dian2, R.drawable.ic_lightning_1);
            holder.setImageResource(R.id.im_dian3, R.drawable.ic_lightning_1);
            holder.setImageResource(R.id.im_dian4, R.drawable.ic_lightning_1);
            holder.setImageResource(R.id.im_dian5, R.drawable.ic_lightning_1);
        } else if (bean.cycle == 2) {
            holder.setImageResource(R.id.im_dian1, R.drawable.ic_lightning);
            holder.setImageResource(R.id.im_dian2, R.drawable.ic_lightning);
            holder.setImageResource(R.id.im_dian3, R.drawable.ic_lightning_1);
            holder.setImageResource(R.id.im_dian4, R.drawable.ic_lightning_1);
            holder.setImageResource(R.id.im_dian5, R.drawable.ic_lightning_1);
        } else if (bean.cycle == 3) {
            holder.setImageResource(R.id.im_dian1, R.drawable.ic_lightning);
            holder.setImageResource(R.id.im_dian2, R.drawable.ic_lightning);
            holder.setImageResource(R.id.im_dian3, R.drawable.ic_lightning);
            holder.setImageResource(R.id.im_dian4, R.drawable.ic_lightning_1);
            holder.setImageResource(R.id.im_dian5, R.drawable.ic_lightning_1);
        } else if (bean.cycle == 4) {
            holder.setImageResource(R.id.im_dian1, R.drawable.ic_lightning);
            holder.setImageResource(R.id.im_dian2, R.drawable.ic_lightning);
            holder.setImageResource(R.id.im_dian3, R.drawable.ic_lightning);
            holder.setImageResource(R.id.im_dian4, R.drawable.ic_lightning);
            holder.setImageResource(R.id.im_dian5, R.drawable.ic_lightning_1);
        } else if (bean.cycle == 5) {
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

        if(bean.property_tags!=null){
            if (bean.property_tags.size() > 0) {
                linearLayout.removeAllViews();
                for (int j = 0; j < bean.property_tags.size(); j++) {
                    if(true) {
                        imageView = new ImageView(context);
                        if (bean.property_tags.get(j) == 59) {
                            imageView.setImageResource(R.drawable.ic_residential2);
                            linearLayout.addView(imageView, layoutParams);
                        } else if (bean.property_tags.get(j) == 60) {
                            imageView.setImageResource(R.drawable.ic_apartment);
                            linearLayout.addView(imageView, layoutParams);
                        } else if (bean.property_tags.get(j) == 63) {
                            imageView.setImageResource(R.drawable.ic_officebuilding);
                            linearLayout.addView(imageView, layoutParams);
                        } else if (bean.property_tags.get(j) == 62) {
                            imageView.setImageResource(R.drawable.ic_shops);
                            linearLayout.addView(imageView, layoutParams);
                        } else if (bean.property_tags.get(j) == 61) {
                            imageView.setImageResource(R.drawable.ic_villa);
                            linearLayout.addView(imageView, layoutParams);
                        }
                    }
                }
            }
        }


        String ss = bean.project_tags;
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
                    textView.setTextSize(13);
                    textView.setBackgroundResource(R.drawable.shape_laber);
                    textView.setPadding(10,1,10,1);
                    linearLayout1.addView(textView,layoutParams);
                }
            }
        }

    }


    }
