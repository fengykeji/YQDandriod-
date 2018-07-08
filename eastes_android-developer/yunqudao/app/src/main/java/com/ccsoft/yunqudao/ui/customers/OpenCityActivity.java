package com.ccsoft.yunqudao.ui.customers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.ccsoft.yunqudao.App;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.data.AppConstants;
import com.ccsoft.yunqudao.data.model.response.ClientPrivateData;
import com.ccsoft.yunqudao.data.model.response.OpenCityData;
import com.ccsoft.yunqudao.http.XutilsHttp;
import com.ccsoft.yunqudao.ui.adapter.OpenCityAdapter;
import com.ccsoft.yunqudao.ui.home.HomeActivity;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.indexbar.CubeIndexBar;
import com.ccsoft.yunqudao.utils.indexbar.SuspensionDecoration;
import com.ccsoft.yunqudao.utils.recyclerviwe.BaseRecyclerViewAdapter;
import com.ccsoft.yunqudao.utils.recyclerviwe.BaseRecyclerViewHolder;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Pein
 * @data: 2018/5/26 0026
 */

public class OpenCityActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton          mCustomers_button_back;
    private RecyclerView         mCustomers_open_citylist;
    private TextView             mLocationTv;//当前定位
    private TextView             mSureTv;//确定
    private SuspensionDecoration mDecoration;
    private CubeIndexBar         mSidebar;
    private OpenCityAdapter      mOpenCityAdapter;
    private OpenCityData         openCityData;
    private List<OpenCityData.DataBean> mDataBeans = new ArrayList<>();
    private String city_code; //城市code num
    private String city_name;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_opencity);
        initView();
        initListener();
        initData();
    }

    public static void start(Activity context) {
        Intent intent = new Intent(context, OpenCityActivity.class);

        context.startActivityForResult(intent, 1000);
    }

    /**
     * 初始化id
     */
    private void initView() {
        this.mCustomers_button_back = findViewById(R.id.customers_button_back);
        this.mCustomers_button_back = findViewById(R.id.customers_button_back);
        this.mCustomers_open_citylist = findViewById(R.id.customers_open_citylist);
        this.mLocationTv = findViewById(R.id.location_tv);
        this.mSidebar = (CubeIndexBar) this.findViewById(R.id.sidebar);
        this.mSureTv = findViewById(R.id.sure_tv);
        this.mOpenCityAdapter = new OpenCityAdapter(R.layout.item_opencity, mDataBeans);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        this.mCustomers_open_citylist.setLayoutManager(layoutManager);
        this.mDecoration = new SuspensionDecoration(this, null);
        this.mDecoration.setColorTitleBg(getResources().getColor(R.color.white));//设置导航背景颜色
        this.mDecoration.setMarginLeft(18);//设置左间距
        this.mCustomers_open_citylist.addItemDecoration(mDecoration);
        this.mCustomers_open_citylist.setAdapter(this.mOpenCityAdapter);

        // indexBar初始化
        this.mSidebar.setNeedRealIndex(true)   // 设置需要真实的索引
                     .setLayoutManager(layoutManager); // 设置RecyclerView的LayoutManager
    }

    /**
     * 初始化监听器
     */
    private void initListener() {
        mCustomers_button_back.setOnClickListener(this);
        //确定监听
        mSureTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(getIntent().getIntExtra("id",0)==1){
                    Intent intent = new Intent(OpenCityActivity.this, HomeActivity.class);
                    intent.putExtra("city_code", city_code);
                    intent.putExtra("city_name", city_name);
                    intent.putExtra("fid",1);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent();
                    intent.putExtra("city", city_code);
                    intent.putExtra("city_name", city_name);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });
        mOpenCityAdapter.setOnItemClickListener(new BaseRecyclerViewAdapter.OnItemClickListener() {



            @Override
            public void onItemClick(View view, BaseRecyclerViewHolder viewHolder, int position) {
                OpenCityData.DataBean dataBean = mDataBeans.get(position);
                city_name = dataBean.getCity_name();
                mLocationTv.setText("当前选择："+ city_name);//當前選擇
                city_code = dataBean.getCity_code();//城市code码
            }

            @Override
            public boolean onItemLongClick(View view, BaseRecyclerViewHolder viewHolder, int position) {
                return false;
            }
        });
    }

    /**
     * 获取数据
     */
    private void initData() {
        XutilsHttp.getInstance().gethesder(AppConstants.URL + "/user/project/openCity", null, new XutilsHttp.XCallBack() {
            @Override
            public void onResponse(String result) {
                Gson gson = new Gson();
                openCityData = gson.fromJson(result, OpenCityData.class);
                mDataBeans = openCityData.getData();
                Log.d("OpenCityActivity---->", "mDataBeans:" + mDataBeans);
                mSidebar.sortData(mDataBeans); // 对数据进行排序
                mOpenCityAdapter.refreshDataList(mDataBeans);   // 刷新数据列表
                mSidebar.setSourceDataAlreadySorted(true).setSourceData(mDataBeans);    // 设置数据
                mDecoration.setmDatas(mDataBeans);
                Log.i("result=========", result);
            }

            @Override
            public void error(String message) {
                Log.i("msg=========", openCityData.getMsg());
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.customers_button_back:
                finish();
                break;
        }
    }
}
