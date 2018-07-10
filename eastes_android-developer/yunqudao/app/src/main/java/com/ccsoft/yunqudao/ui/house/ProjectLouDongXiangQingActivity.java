package com.ccsoft.yunqudao.ui.house;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.ProjectLouDongChooseBean;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.ui.adapter.HouseLoudongChooseAdapter;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.ItemsDialogFragment;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * @author: Pein
 * @data: 2018/5/9 0009
 */

public class ProjectLouDongXiangQingActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton mHouse_button_返回;
    private ImageView   mHouse_imageview_楼栋详情;
    private WebView webView;
    private DrawerLayout drawerLayout;
    private RecyclerView recyclerView;
    private TextView tv_showdrawer;
    private RelativeLayout rlRight;
    private ImageButton im_closedrawer;
    private HouseLoudongChooseAdapter adapter;
    private int project_id;
    private ProjectLouDongChooseBean bean;
    private List<ProjectLouDongChooseBean.DataBean> dataList = new ArrayList<>();

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_house_project_loudongxiangqing);
        initView();
        initData();
        initListener();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, ProjectLouDongXiangQingActivity.class);
        context.startActivity(intent);
    }

    /**
     * 初始化
     */
    private void initView() {

        mHouse_button_返回 = findViewById(R.id.house_button_返回);
        mHouse_imageview_楼栋详情 = findViewById(R.id.house_imageview_楼栋详情);
        webView = findViewById(R.id.wv_webview);
        drawerLayout = findViewById(R.id.drawerLayout);
        recyclerView = findViewById(R.id.re_loudong);
        tv_showdrawer = findViewById(R.id.tv_showdrawer);
        rlRight = findViewById(R.id.rlRight);
        im_closedrawer = findViewById(R.id.im_closedrawer);

        project_id = getIntent().getIntExtra("project_id",0);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://120.27.21.136:2798/360/test4/index.html");

        controlDrawer();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new HouseLoudongChooseAdapter(this,R.layout.item_house_loudong,dataList);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListner(new BaseRecyclerAdapter.OnItemClickListner() {
            @Override
            public void onItemClickListner(View v, int position) {
                if(bean.getData().get(position).getDYLIST().size()>0){
                    showItemsDialogFragment(position);
                }else {
                    Intent intent = new Intent(ProjectLouDongXiangQingActivity.this,ProjectDanYuanXiangQingActivity.class);
                    intent.putExtra("project_id",project_id);
                    intent.putExtra("build_id",bean.getData().get(position).getBuild_info().getYs_build_id());
                    intent.putExtra("unit_id","0");
                    startActivity(intent);
                }
            }
        });


    }



    /**
     * 初始化
     */
    private void initListener() {

        mHouse_button_返回.setOnClickListener(this);
        tv_showdrawer.setOnClickListener(this);
        im_closedrawer.setOnClickListener(this);
    }

    private void initData(){
        OkHttpUtils.get(HttpAdress.yunsuanbuild)
                .tag(this)
                .params("project_id",project_id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        int code = 0;
                        String data = null;
                        try {
                            JSONObject jsonObject = new JSONObject(s);
                            code = jsonObject.getInt("code");
                            data = jsonObject.getString("data");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if(code == 200&&data!=null){
                            bean = JsonUtil.jsonToEntity(s,ProjectLouDongChooseBean.class);
                            dataList.clear();
                            dataList.addAll(bean.getData());
                            adapter.notifyDataSetChanged();
                        }
                    }
                });
    }

    /**
     * 控制侧拉菜单
     */

    private void controlDrawer(){
        // 关闭手势滑动
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // 打开手势滑动
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                // 关闭手势滑动
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);

                    tv_showdrawer.setVisibility(View.VISIBLE);

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.house_button_返回:
                finish();
                break;
            case R.id.tv_showdrawer:
                if (!drawerLayout.isDrawerOpen(rlRight)) {
                    drawerLayout.openDrawer(rlRight);
                    tv_showdrawer.setVisibility(View.GONE);
                }
                break;
            case R.id.im_closedrawer:
                if(drawerLayout.isDrawerOpen(rlRight)){
                    drawerLayout.closeDrawer(rlRight);
                    tv_showdrawer.setVisibility(View.VISIBLE);
                }
                break;
        }
    }

    public void showItemsDialogFragment(int position) {
        ItemsDialogFragment itemsDialogFragment = new ItemsDialogFragment();
        List<ProjectLouDongChooseBean.DataBean.DYBean> list = new ArrayList<>();
        list =  bean.getData().get(position).getDYLIST();

        String[] items= new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            items[i] = list.get(i).getDYMC();
        }



        itemsDialogFragment.show(bean.getData().get(position).getBuild_info().getBuild_name()+"单元选择", items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               Intent intent = new Intent(ProjectLouDongXiangQingActivity.this,
                       ProjectDanYuanXiangQingActivity.class);

                intent.putExtra("project_id",project_id);
                intent.putExtra("build_id",bean.getData().get(position).getBuild_info().getYs_build_id());
                intent.putExtra("unit_id",bean.getData().get(position).getDYLIST().get(which).getDYID());
               startActivity(intent);
            }
        }, getSupportFragmentManager());
    }
}
