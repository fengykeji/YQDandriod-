package com.ccsoft.yunqudao.ui.house;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.DongLieBiaoBean;
import com.ccsoft.yunqudao.bean.HouseDetailBean;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.http.MyStringCallBack;
import com.ccsoft.yunqudao.ui.adapter.ProjectDongLieBiaoAdapter;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.ccsoft.yunqudao.utils.OkHttpManager;
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

public class ProjectDongLieBiaoActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton  mHouse_button_返回;
    private LinearLayout mHouse_item_linearlayout_项目动态1;
    private LinearLayout mHouse_item_linearlayout_项目动态2;
    private RecyclerView recyclerView;
    private List<DongLieBiaoBean.DataBeanX.DataBean> dataList = new ArrayList<>();
    private ProjectDongLieBiaoAdapter adapter;
    private int project_id;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_house_project_dongtailiebiao);
        initView();
        initListener();
        showData();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, ProjectDongLieBiaoActivity.class);
        context.startActivity(intent);
    }

    /**
     * 初始化id
     */
    private void initView() {

        mHouse_button_返回 = findViewById(R.id.house_button_返回);
        mHouse_item_linearlayout_项目动态1 = findViewById(R.id.house_item_linearlayout_项目动态1);
        mHouse_item_linearlayout_项目动态2 = findViewById(R.id.house_item_linearlayout_项目动态2);
        recyclerView = findViewById(R.id.recyclerview_rv);

        project_id = getIntent().getIntExtra("project_id",0);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ProjectDongLieBiaoAdapter(this,R.layout.item_project_dongtai,dataList);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListner(new BaseRecyclerAdapter.OnItemClickListner() {
            @Override
            public void onItemClickListner(View v, int position) {
                Intent intent = new Intent(ProjectDongLieBiaoActivity.this,ProjectDongTaiXiangQingActivity.class);
                intent.putExtra("url",dataList.get(position).getImg_url());
                startActivity(intent);
            }
        });
    }

    /**
     * 初始化监听器
     */
    private void initListener() {

        mHouse_button_返回.setOnClickListener(this);
        mHouse_item_linearlayout_项目动态1.setOnClickListener(this);
        mHouse_item_linearlayout_项目动态2.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.house_button_返回:
                finish();
                break;

            case R.id.house_item_linearlayout_项目动态1:
                ProjectDongTaiXiangQingActivity.start(this);
                break;

            case R.id.house_item_linearlayout_项目动态2:
                ProjectDongTaiXiangQingActivity.start(this);
                break;
        }
    }

    private void showData(){
        OkHttpUtils.get(HttpAdress.DYNAMICLIST)
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
                        if (code == 200 && data != null) {
                            DongLieBiaoBean.DataBeanX bean = JsonUtil.jsonToEntity(data,DongLieBiaoBean.DataBeanX.class);
                            dataList.addAll(bean.getData());
                            adapter.notifyDataSetChanged();
                        }
                    }});

                }
}
