package com.ccsoft.yunqudao.ui.house.secondhandhouse;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baidu.mapapi.SDKInitializer;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.SecondHouseDetailBean;
import com.ccsoft.yunqudao.data.AppConstants;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;
import com.squareup.picasso.Picasso;

import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

public class SecondHouseXiangQingFragment extends Fragment implements View.OnClickListener{

    private View                     mView;
    private TextView tv_fangyuanxinxi,tv_num,tv_shoujia,tv_huxing,tv_chanquanmianji,tv_project_name
            ,tv_kandangfangshi,tv_chanquanmianji1,tv_chaoxiang,tv_maifangyiyuan,tv_maifangjinpo
            ,tv_danjia,tv_zhuangxiu,tv_project_name1,tv_junjia,tv_loudongzongshu,tv_fangwuzongshu
            ;
    private ImageView tv_project_img;
    private int house_id;


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        SDKInitializer.initialize(getContext().getApplicationContext());
        mView = inflater.inflate(R.layout.activity_secondhousexiangqiang, container, false);
        initView();
        initData();
        initListener();
        return mView;
    }

    private void initView(){
        house_id = getActivity().getIntent().getIntExtra("house_id",0);
        tv_fangyuanxinxi = mView.findViewById(R.id.tv_fangyuanxinxi);
        tv_num = mView.findViewById(R.id.tv_num);
        tv_shoujia = mView.findViewById(R.id.tv_shoujia);
        tv_huxing = mView.findViewById(R.id.tv_huxing);
        tv_chanquanmianji = mView.findViewById(R.id.tv_chanquanmianji);
        tv_project_name = mView.findViewById(R.id.tv_project_name);
        tv_kandangfangshi = mView.findViewById(R.id.tv_kandangfangshi);
        tv_chanquanmianji1 = mView.findViewById(R.id.tv_chanquanmianji1);
        tv_chaoxiang = mView.findViewById(R.id.tv_chaoxiang);
        tv_maifangyiyuan = mView.findViewById(R.id.tv_maifangyiyuan);
        tv_maifangjinpo = mView.findViewById(R.id.tv_maifangjinpo);
        tv_danjia = mView.findViewById(R.id.tv_danjia);
        tv_zhuangxiu = mView.findViewById(R.id.tv_zhuangxiu);
        tv_project_name1 = mView.findViewById(R.id.tv_project_name1);
        tv_junjia = mView.findViewById(R.id.tv_junjia);
        tv_loudongzongshu = mView.findViewById(R.id.tv_loudongzongshu);
        tv_fangwuzongshu = mView.findViewById(R.id.tv_fangwuzongshu);
        tv_project_img = mView.findViewById(R.id.tv_project_img);
    }

    private void initListener(){
        tv_fangyuanxinxi.setOnClickListener(this);
    }

    private void initData(){
        OkHttpUtils.get(HttpAdress.secondHouseDetail)
                .tag(this)
                .params("house_id",house_id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        SecondHouseDetailBean bean = JsonUtil.jsonToEntity(s,SecondHouseDetailBean.class);
                        if(bean.getCode() == 200){
                            tv_num.setText(bean.getData().getFocus().getNum()+"");
                            tv_shoujia.setText(bean.getData().getBasic_info().getPrice()+"");
                            tv_huxing.setText(bean.getData().getBasic_info().getHouse_type());
                            tv_chanquanmianji.setText(bean.getData().getBasic_info().getBuild_area()+"");
                            tv_project_name.setText(bean.getData().getBasic_info().getTitle());
                            tv_kandangfangshi.setText(bean.getData().getBasic_info().getCheck_way());
                            tv_chanquanmianji1.setText(bean.getData().getBasic_info().getBuild_area()+"");
                            tv_chaoxiang.setText(bean.getData().getBasic_info().getOrientation());
                            tv_maifangyiyuan.setText(bean.getData().getBasic_info().getIntent()+"");
                            tv_maifangjinpo.setText(bean.getData().getBasic_info().getUrgency()+"");
                            tv_danjia.setText(bean.getData().getBasic_info().getUnit_price()+"");
                            tv_zhuangxiu.setText(bean.getData().getBasic_info().getDecoration());
                            tv_project_name1.setText(bean.getData().getBasic_info().getProject_name());
                            tv_junjia.setText(bean.getData().getBasic_info().getProject_average_price()+"");
                            tv_loudongzongshu.setText(bean.getData().getBasic_info().getProject_total_build()+"");
//                            tv_fangwuzongshu.setText(bean.getData().getBasic_info().getp);
                            Picasso.with(getContext()).load(AppConstants.URL+bean.getData().getBasic_info().getProject_img_url())
                                    .error(R.drawable.default_1)
                                    .into(tv_project_img);

                            /**
                             * 设置标签
                             */

                            LinearLayout linearLayout1 =  mView.findViewById(R.id.ll_property);
                            LinearLayout linearLayout = mView.findViewById(R.id.ll_project_tags);
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                            layoutParams.leftMargin = 16;
                            layoutParams.topMargin = 16;
                            layoutParams.bottomMargin = 16;
                            linearLayout.removeAllViews();
                            linearLayout1.removeAllViews();

                            List<String> project_tags = bean.getData().getBasic_info().getProject_tags();
                            for (String project_tag : project_tags) {
                                TextView textView = new TextView(getContext());
                                textView.setText(project_tag);
                                textView.setTextSize(10);
                                textView.setBackgroundResource(R.drawable.shape_laber);
                                textView.setPadding(15,5,15,5);
                                linearLayout1.addView(textView,layoutParams);
                            }

                            List<String> house_tags = bean.getData().getBasic_info().getHouse_tags();
                            for (String house_tag : house_tags) {
                                TextView textView = new TextView(getContext());
                                textView.setText(house_tag);
                                textView.setTextSize(10);
                                textView.setBackgroundResource(R.drawable.shape_laber);
                                textView.setPadding(15,5,15,5);
                                linearLayout.addView(textView,layoutParams);
                            }

                        }
                    }
                });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_fangyuanxinxi:
                Intent intent = new Intent(getContext(),SencondHouseFangYuanInfoActivity.class);
                startActivity(intent);
                break;
        }
    }
}
