package com.ccsoft.yunqudao.ui.house;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.ProjectDanYuanBean;
import com.ccsoft.yunqudao.bean.ProjectLouDongChooseBean;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.ui.adapter.ProjectDanYuanAdapter;
import com.ccsoft.yunqudao.utils.ActivityManager;
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

public class ProjectDanYuanXiangQingActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton mHouse_button_返回;
    private int project_id,build_id;
    private String unit_id;
    private RecyclerView re_loudong,re_danyuan;
    private ProjectDanYuanBean bean;
    private List<ProjectDanYuanBean.DataBean> dataList = new ArrayList<>();
    private ProjectDanYuanAdapter adapter;
    private TextView tv_zonghushu,tv_kaipanfangshi,tv_loushangcengshu,tv_louxiacengshu,
            tv_kaipanshijian,tv_jiaofangshijian;
    private LinearLayout ll_closectent,ll_showcontent,ll_colse;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_house_project_danyuanxiangqing);
        initView();
        initData();
        initListener();

    }

    public static void start(Context context) {
        Intent intent = new Intent(context, ProjectDanYuanXiangQingActivity.class);
        context.startActivity(intent);
    }



    /**
     * 初始化
     */
    private void initView() {

        mHouse_button_返回 = findViewById(R.id.house_button_返回);
        re_loudong = findViewById(R.id.re_loudong);
        tv_zonghushu = findViewById(R.id.tv_zonghushu);
        tv_kaipanfangshi = findViewById(R.id.tv_kaipanfangshi);
        tv_loushangcengshu= findViewById(R.id.tv_loushangcengshu);
        tv_louxiacengshu = findViewById(R.id.tv_louxiacengshu);
        tv_kaipanshijian = findViewById(R.id.tv_kaipanshijian);
        tv_jiaofangshijian = findViewById(R.id.tv_jiaofangshijian);
        ll_closectent = findViewById(R.id.ll_closectent);
        ll_showcontent = findViewById(R.id.ll_showcontent);
        ll_colse = findViewById(R.id.ll_close);


        project_id = getIntent().getIntExtra("project_id",0);
        build_id = getIntent().getIntExtra("build_id",0);
        unit_id = getIntent().getStringExtra("unit_id");
        Bundle bundle = getIntent().getExtras();
        ProjectLouDongChooseBean.DataBean.BuildInfoBean bean = (ProjectLouDongChooseBean.DataBean.BuildInfoBean) bundle.getSerializable("data");

        if(bean!=null) {
            tv_zonghushu.setText("总户数:"+bean.getTotal_house_num());
            tv_kaipanfangshi.setText("开盘方式:"+bean.getOpen_way());
            tv_loushangcengshu.setText("楼上层数:"+bean.getUpper_floor_num());
            tv_louxiacengshu.setText("楼下层数:"+bean.getDown_floor_num());
            tv_kaipanshijian.setText("开盘时间"+bean.getOpen_time());
            tv_jiaofangshijian.setText("交房时间:"+bean.getHanding_room_time());

        }



        re_loudong.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ProjectDanYuanAdapter(this,R.layout.item_project_danyuan,dataList);
        re_loudong.setAdapter(adapter);


    }



    /**
     * 初始化
     */
    private void initListener() {

        mHouse_button_返回.setOnClickListener(this);
        ll_showcontent.setOnClickListener(this);
        ll_closectent.setOnClickListener(this);
        ll_colse.setOnClickListener(this);

    }

    private void initData(){
        OkHttpUtils.get(HttpAdress.yunsuanunit)
                .tag(this)
                .params("project_id",project_id)
                .params("build_id",build_id)
                .params("unit_id",unit_id)
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
                        if(code == 200 && data!=null){
                            bean = JsonUtil.jsonToEntity(s,ProjectDanYuanBean.class);
                            dataList.clear();
                            dataList.addAll(bean.getData());
                            adapter.notifyDataSetChanged();

                        }
                    }
                });
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.house_button_返回:
                finish();
                break;
            case R.id.ll_closectent:
                ll_closectent.setVisibility(View.GONE);
                ll_showcontent.setVisibility(View.VISIBLE);
                break;
            case R.id.ll_close:
                ll_showcontent.setVisibility(View.GONE);
                ll_closectent.setVisibility(View.VISIBLE);
                break;
        }
    }
}
