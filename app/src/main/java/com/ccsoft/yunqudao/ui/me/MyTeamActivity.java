package com.ccsoft.yunqudao.ui.me;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.MyTeamListBean;
import com.ccsoft.yunqudao.bean.StringBean;
import com.ccsoft.yunqudao.data.AppConstants;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.FooterHolder;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.ui.adapter.MyTeamListAdapter;
import com.ccsoft.yunqudao.ui.listener.EndlessRecyclerOnScrollListener;
import com.ccsoft.yunqudao.utils.CircleImageView;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import cn.sharesdk.onekeyshare.OnekeyShare;
import okhttp3.Call;
import okhttp3.Response;

public class MyTeamActivity extends AppCompatActivity implements OnRefreshListener, View.OnClickListener{

    private TextView tv_jinrituijian;
    private TextView tv_suoyuochengyuan;
    private TextView tv_name;
    private TextView tv_dengji,tv_tuijianrenname,tv_time,tv_tuijianrendengji;
    private CircleImageView im_headimg,im_tuijianrenimg;
    private ImageView im_sex,im_sex1;
    private RecyclerView recyclerView;
    private AnimationDrawable anim;
    private ImageView yunsuan;
    private SmartRefreshLayout mCustomers_swiperefreshlayout;
    private MyTeamListAdapter adapter;
    private List<MyTeamListBean.DataBean.ChildBean> datalist = new ArrayList<>();
    private ImageButton me_button_返回;
    private TextView house_button_分享;
    private MyTeamListBean bean;
    private LinearLayout ll_tuijianren,ll_wodetuijian;
    private String name = "";


    @Override
    protected void onStart() {
        super.onStart();
        initData();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myteam);
        initView();
        initData();
        initListener();
    }
    private void initView(){
        tv_jinrituijian = findViewById(R.id.tv_jinrituijian);
        this.mCustomers_swiperefreshlayout = findViewById(R.id.customers_swiperefreshlayout);
        ll_tuijianren = findViewById(R.id.ll_tuijianren);
        tv_suoyuochengyuan = findViewById(R.id.tv_suoyuochengyuan);
        tv_name = findViewById(R.id.tv_name);
        tv_dengji = findViewById(R.id.tv_dengji);
        im_headimg = findViewById(R.id.im_headimg);
        im_tuijianrenimg = findViewById(R.id.im_tuijianrenimg);
        tv_tuijianrenname = findViewById(R.id.tv_tuijianrenname);
        tv_time = findViewById(R.id.tv_time);
        tv_tuijianrendengji = findViewById(R.id.tv_tuijianrendengji);
        im_sex = findViewById(R.id.im_sex);
        im_sex1 = findViewById(R.id.im_sex1);
        recyclerView = findViewById(R.id.re_myteamlist);
        me_button_返回 = findViewById(R.id.me_button_返回);
        house_button_分享 = findViewById(R.id.house_button_分享);
        ll_wodetuijian = findViewById(R.id.ll_wodetuijian);
        yunsuan = findViewById(R.id.yunsuan);
        yunsuan.setImageResource(R.drawable.animation_refresh);
        anim = (AnimationDrawable) yunsuan.getDrawable();


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyTeamListAdapter(this,R.layout.item_myteamlist,datalist);
        recyclerView.setAdapter(adapter);
//        recyclerView.addOnScrollListener(endlessRecyclerOnScrollListener);

        me_button_返回.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }

    private void initListener(){

        adapter.setOnItemClickListner(new BaseRecyclerAdapter.OnItemClickListner() {
            @Override
            public void onItemClickListner(View v, int position) {
                View view = LayoutInflater.from(MyTeamActivity.this).inflate(R.layout.activity_teamdetail,null);
                TextView me_text_云算号 = view.findViewById(R.id.me_text_云算号);
                TextView tv_renzhicompany = view.findViewById(R.id.tv_renzhicompany);
                TextView me_text_电话号码 = view.findViewById(R.id.me_text_电话号码);
                TextView tv_ruzhitime = view.findViewById(R.id.tv_ruzhitime);
                TextView me_text_二维码内名字 = view.findViewById(R.id.me_text_二维码内名字);
                CircleImageView me_icon_二维码头像 = view.findViewById(R.id.me_icon_二维码头像);
                Picasso.with(MyTeamActivity.this).load(AppConstants.URL+bean.getData().getChild().get(position).getHead_img())
                        .error(R.drawable.ic_def_head)
                        .into(me_icon_二维码头像);
                me_text_二维码内名字.setText(bean.getData().getChild().get(position).getName());
                me_text_云算号.setText("云算编号："+bean.getData().getChild().get(position).getAccount());
                tv_renzhicompany.setText("任职公司:"+bean.getData().getChild().get(position).getCompany_name());
                me_text_电话号码.setText("电话号码："+bean.getData().getChild().get(position).getTel());
                tv_ruzhitime.setText("入职年限:"+bean.getData().getChild().get(position).getWork_year());


                PopupWindow popupWindow = new PopupWindow(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT );
                popupWindow.setContentView(view);
                popupWindow.setFocusable(true);
                popupWindow.showAtLocation(MyTeamActivity.this.getWindow().getDecorView(), Gravity.CENTER, 0, 0);

                popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        backgroundAlpha(1);
                    }
                });
                backgroundAlpha((float) 0.5);

            }
        });

        house_button_分享.setOnClickListener(this);
        this.mCustomers_swiperefreshlayout.setOnRefreshListener(this);
        ll_tuijianren.setOnClickListener(this);
    }

    private void initData(){
        OkHttpUtils.get(HttpAdress.myTeamList)
                .tag(this)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                         bean = JsonUtil.jsonToEntity(s,MyTeamListBean.class);
                        if(bean.getCode() == 200&& bean.getData()!=null){
                            tv_jinrituijian.setText(bean.getData().getRecommend().getToday()+"");
                            tv_suoyuochengyuan.setText(bean.getData().getRecommend().getTotal()+"");
                            tv_name.setText(bean.getData().getPerson().getName());
                            name = bean.getData().getPerson().getName();
                            tv_dengji.setText(bean.getData().getPerson().getGrade());
                            Picasso.with(MyTeamActivity.this).load(AppConstants.URL+bean.getData().getPerson().getHead_img())
                                    .error(R.drawable.ic_def_head)
                                    .into(im_headimg);
                            if(bean.getData().getPerson().getSex()==1){
                                im_sex.setImageResource(R.drawable.ic_man);
                            }else if(bean.getData().getPerson().getSex() == 2){
                                im_sex.setImageResource(R.drawable.ic_girl);
                            }

                            if(bean.getData().getParent().getName()!=null){
                                Picasso.with(MyTeamActivity.this).load(AppConstants.URL+bean.getData().getParent().getHead_img())
                                        .error(R.drawable.ic_def_head)
                                        .into(im_tuijianrenimg);
                                tv_tuijianrenname.setText(bean.getData().getParent().getName());
                                tv_tuijianrendengji.setText(bean.getData().getParent().getGrade());
                                tv_time.setText(bean.getData().getParent().getCreate_time());
                                if(bean.getData().getParent().getSex()==1){
                                    im_sex1.setImageResource(R.drawable.ic_man);
                                }else if(bean.getData().getParent().getSex() == 2){
                                    im_sex1.setImageResource(R.drawable.ic_girl);
                                }
                            }else {
                                ll_wodetuijian.setVisibility(View.GONE);
                            }
                            datalist.clear();
                            datalist.addAll(bean.getData().getChild());
                            adapter.notifyDataSetChanged();
                        }
                    }
                });
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        initData();
        anim.start();
        mCustomers_swiperefreshlayout.finishRefresh(900);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.house_button_分享:
                Intent intent = new Intent(MyTeamActivity.this,YaoQingErWeiMaActivity.class);

                    intent.putExtra("name", name);

                startActivity(intent);
                break;
            case R.id.ll_tuijianren:
                showDetail();
                backgroundAlpha((float) 0.5);
                break;
        }
    }

    private void showDetail(){
        View view = LayoutInflater.from(this).inflate(R.layout.activity_teamdetail,null);
        TextView me_text_云算号 = view.findViewById(R.id.me_text_云算号);
        TextView tv_renzhicompany = view.findViewById(R.id.tv_renzhicompany);
        TextView me_text_电话号码 = view.findViewById(R.id.me_text_电话号码);
        TextView tv_ruzhitime = view.findViewById(R.id.tv_ruzhitime);
        TextView me_text_二维码内名字 = view.findViewById(R.id.me_text_二维码内名字);
        CircleImageView me_icon_二维码头像 = view.findViewById(R.id.me_icon_二维码头像);
        Picasso.with(this).load(AppConstants.URL+bean.getData().getParent().getHead_img())
                .error(R.drawable.ic_def_head)
                .into(me_icon_二维码头像);
        me_text_二维码内名字.setText(bean.getData().getParent().getName());
        me_text_云算号.setText("云算编号："+bean.getData().getParent().getAccount());
        tv_renzhicompany.setText("任职公司:"+bean.getData().getParent().getCompany_name());
        me_text_电话号码.setText("电话号码："+bean.getData().getParent().getTel());
        tv_ruzhitime.setText("入职年限:"+bean.getData().getParent().getWork_year());


        PopupWindow popupWindow = new PopupWindow(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT );
        popupWindow.setContentView(view);
        popupWindow.setFocusable(true);
        popupWindow.showAtLocation(this.getWindow().getDecorView(), Gravity.CENTER, 0, 0);

        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1);
            }
        });
    }

    /**
     * 设置屏幕背景
     * @param bgAlpha
     */
    public void backgroundAlpha(float bgAlpha)  //阴影改变
    {
        WindowManager.LayoutParams lp =this.getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        this.getWindow().setAttributes(lp);
    }
}
