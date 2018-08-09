package com.ccsoft.yunqudao.ui.house;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.adapter.MyFragmentPagerAdapter;
import com.ccsoft.yunqudao.adapter.SpeedHourAdapter;
import com.ccsoft.yunqudao.bean.HouseDetailBean;
import com.ccsoft.yunqudao.bean.ProjectHuXingXiangQingBean;
import com.ccsoft.yunqudao.bean.ProjectPiPeiKeHuBean;
import com.ccsoft.yunqudao.bean.StringBean;
import com.ccsoft.yunqudao.data.AppConstants;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.ui.adapter.ProjectPiPeiAdapter;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.BaseCallBack;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.ccsoft.yunqudao.utils.OkHttpManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import cn.sharesdk.onekeyshare.OnekeyShare;
import okhttp3.Call;
import okhttp3.Response;

/**
 * @author: Pein
 * @data: 2018/5/9 0009
 */

public class ProjectHuXingXiangQingActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {

    private ImageButton mHouse_button_返回;
    private ImageButton mHouse_button_分享;
    private Button      mHouse_button_平面图;
    private Button      mHouse_button_效果图;
    private Button      mHouse_button_3D图;
    private Button      mHouse_button_实景图;
    private ViewPager   mHouse_viewpager_户型信息;
    private Button      mHouse_button_查看更多匹配客户;
    private Button      mHouse_button_推荐1;
    private Button      mHouse_button_推荐2;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private TextView tv_house_type_name,tv_property_area,tv_sell_point;
    private int id;
    private ProjectHuXingXiangQingBean bean;
    private RecyclerView recyclerView;
    private SpeedHourAdapter speedHourAdapter=null;
    private List<HouseDetailBean.DataBean.HouseTypeBean> dataList = new ArrayList<>();
    private List<HouseDetailBean.DataBean.HouseTypeBean> dataList2 = new ArrayList<>();
    private List<ProjectPiPeiKeHuBean.DataBean> dataList3 = new ArrayList<>();
    private int project_id;
    private TextView content_tv14;
    private ProjectPiPeiKeHuBean piPeiKeHuBean = new ProjectPiPeiKeHuBean();
    private RecyclerView re_pipei;
    private ProjectPiPeiAdapter adapter;
    private String url;
    private ImageView a3D;

    @Override
    protected void onStart() {
        super.onStart();
        initData();
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_house_huxingxiangqing);
        initView();
        initData();
        getUrl();
        initListener();

    }

    public static void start(Context context) {
        Intent intent = new Intent(context, ProjectHuXingXiangQingActivity.class);
        context.startActivity(intent);
    }

    /**
     * 初始化
     */
    private void initView() {



        mHouse_button_返回 = findViewById(R.id.house_button_返回);
        mHouse_button_分享 = findViewById(R.id.house_button_分享);
        mHouse_button_平面图 = findViewById(R.id.house_button_平面图);
        mHouse_button_效果图 = findViewById(R.id.house_button_效果图);
        mHouse_button_3D图 = findViewById(R.id.house_button_3D图);
        mHouse_button_实景图 = findViewById(R.id.house_button_实景图);
        mHouse_viewpager_户型信息 = findViewById(R.id.house_viewpager_户型信息);
        mHouse_button_查看更多匹配客户 = findViewById(R.id.house_button_查看更多匹配客户);
        mHouse_button_推荐1 = findViewById(R.id.house_button_推荐1);
        mHouse_button_推荐2 = findViewById(R.id.house_button_推荐2);
        tv_house_type_name = findViewById(R.id.tv_house_type_name);
        tv_property_area = findViewById(R.id.tv_property_area);
        tv_sell_point= findViewById(R.id.tv_sell_point);
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tl_tablaout);
        content_tv14 = findViewById(R.id.content_tv14);
        re_pipei = findViewById(R.id.re_pipei);
        recyclerView = findViewById(R.id.re_huxing);
        a3D = findViewById(R.id.a3D);



        project_id = getIntent().getIntExtra("project_id",0);
        id = getIntent().getIntExtra("id",0);

        re_pipei.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ProjectPiPeiAdapter(this,R.layout.item_project_pipei,dataList3,project_id);
        re_pipei.setAdapter(adapter);


        dataList = (List<HouseDetailBean.DataBean.HouseTypeBean>) getIntent().getSerializableExtra("list");
        dataList2 = dataList;


//        for (int i = 0; i < dataList.size(); i++) {
//            if(dataList.get(i).getId()==id){
//                dataList.remove(i);
//            }
//        }


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        speedHourAdapter = new SpeedHourAdapter(this,dataList);
        recyclerView.setAdapter(speedHourAdapter);
        getPiPeiKeHu();




        speedHourAdapter.setOnItemClickListener(new SpeedHourAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                Intent intent = new Intent(ProjectHuXingXiangQingActivity.this,ProjectHuXingXiangQingActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("list", (Serializable) dataList);
                intent.putExtra("project_id",project_id);
                intent.putExtra("id",dataList.get(position).getId());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });



    }

    /**
     * 初始化
     */
    private void initListener() {

        mHouse_button_返回.setOnClickListener(this);
        mHouse_button_分享.setOnClickListener(this);
        mHouse_button_平面图.setOnClickListener(this);
        mHouse_button_效果图.setOnClickListener(this);
        mHouse_button_3D图.setOnClickListener(this);
        mHouse_button_实景图.setOnClickListener(this);
        mHouse_button_查看更多匹配客户.setOnClickListener(this);
        mHouse_button_推荐1.setOnClickListener(this);
        mHouse_button_推荐2.setOnClickListener(this);
    }

    private void initData(){
        OkHttpManager.getInstance().get(HttpAdress.houseTypedetail + "?id=" + id, new BaseCallBack() {
            @Override
            public void onSuccess(Call call, Response response, Object obj) throws MalformedURLException {
                Type type = new TypeToken<ProjectHuXingXiangQingBean>(){}.getType();
                bean = new Gson().fromJson(obj.toString(),type);
                if(bean.getCode()==200&&bean.getData()!=null){

                    tv_house_type_name.setText(bean.getData().getBaseInfo().getHouse_type_name());
                    tv_property_area.setText(bean.getData().getBaseInfo().getProperty_area_min()+"m2--"
                    +bean.getData().getBaseInfo().getProperty_area_max()+"m2");
                    tv_sell_point.setText(bean.getData().getBaseInfo().getSell_point());


                    ArrayList<Fragment> fragments = new ArrayList<>();
                    ArrayList<String> mTitles = new ArrayList<>();
                    Bundle bundle = new Bundle();
                    for (ProjectHuXingXiangQingBean.DataBean.ImgInfoBean imgInfoBean : bean.getData().getImgInfo()) {
                        if (imgInfoBean.getType().equals("平面图")){
                            ProjectPingMianTuFragment fragment = new ProjectPingMianTuFragment();
                            fragments.add(fragment);
                            bundle.putSerializable("list", (Serializable) bean.getData().getImgInfo());
                            fragment.setArguments(bundle);
                            mTitles.add(imgInfoBean.getType());
                        }else if(imgInfoBean.getType().equals("效果图")){
                            ProjectTuXiaoGuoFragment fragment = new ProjectTuXiaoGuoFragment();
                            fragments.add(fragment);
                            bundle.putSerializable("list", (Serializable) bean.getData().getImgInfo());
                            fragment.setArguments(bundle);
                            mTitles.add(imgInfoBean.getType());
                        }else if(imgInfoBean.getType().equals("3D图")){

                            ProjectTu3DFragment fragment = new ProjectTu3DFragment();
                            fragments.add(fragment);
                            bundle.putSerializable("list", (Serializable) bean.getData().getImgInfo());
                            fragment.setArguments(bundle);
                            mTitles.add(imgInfoBean.getType());
                        }else if(imgInfoBean.getType().equals("实景图")){
                            ProjectTuShiJingFragment fragment = new ProjectTuShiJingFragment();
                            fragments.add(fragment);
                            bundle.putSerializable("list", (Serializable) bean.getData().getImgInfo());
                            fragment.setArguments(bundle);
                            mTitles.add(imgInfoBean.getType());
                        }
                    }
                    MyFragmentPagerAdapter fragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(),  fragments,  mTitles);
                    viewPager.setAdapter(fragmentPagerAdapter);
                    tabLayout.setupWithViewPager(viewPager);



                }
            }

            @Override
            public void onFailure(Call call, Exception e) {

            }

            @Override
            public void onError(Response response, int errorCode) {

            }

            @Override
            public void onRequestBefore() {

            }
        });
    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.house_button_返回:
                finish();
                break;

            case R.id.house_button_分享:
                showShare();
                break;

            case R.id.house_button_平面图:
                Toast.makeText(this, "你点击了平面图", Toast.LENGTH_SHORT).show();
                break;

            case R.id.house_button_效果图:
                Toast.makeText(this, "你点击了效果图", Toast.LENGTH_SHORT).show();
                break;

            case R.id.house_button_3D图:
                Toast.makeText(this, "你点击了3D图", Toast.LENGTH_SHORT).show();
                break;

            case R.id.house_button_实景图:
                Toast.makeText(this, "你点击了实景图", Toast.LENGTH_SHORT).show();
                break;

            case R.id.house_button_查看更多匹配客户:
//                ProjectPiPeiKeHuActivity.start(this);
                Bundle bundle = new Bundle();
                if(piPeiKeHuBean.getData()!=null) {
                    bundle.putSerializable("list", (Serializable) piPeiKeHuBean.getData());
                    bundle.putInt("project_id", project_id);
                    Intent intent3 = new Intent(this, ProjectPiPeiKeHuActivity.class);
                    intent3.putExtras(bundle);
                    startActivity(intent3);
                }
                break;

            case R.id.house_button_推荐1:
                Toast.makeText(this, "你推荐了该户型", Toast.LENGTH_SHORT).show();
                break;

            case R.id.house_button_推荐2:
                Toast.makeText(this, "你推荐了该户型", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private void getPiPeiKeHu() {

        OkHttpUtils.get(AppConstants.URL+"agent/matching/houseType")
                .tag(this)
                .params("project_id", project_id)
                .params("house_type_id",id)
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
                            piPeiKeHuBean = JsonUtil.jsonToEntity(s, ProjectPiPeiKeHuBean.class);
                            content_tv14.setText("(" + piPeiKeHuBean.getData().size() + ")");
                            dataList3.clear();
                            if (piPeiKeHuBean.getData().size()>0&&piPeiKeHuBean.getData().size()<2) {
                                dataList3.add(piPeiKeHuBean.getData().get(0));
                            }
                            if(piPeiKeHuBean.getData().size()>1){
                                dataList3.add(piPeiKeHuBean.getData().get(0));
                            dataList3.add(piPeiKeHuBean.getData().get(1));
                            }
                            adapter.notifyDataSetChanged();

                        }
                    }
                });
    }
    private void showShare() {
        OnekeyShare oks = new OnekeyShare();
//关闭sso授权
        oks.disableSSOWhenAuthorize();

// title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间等使用
        oks.setTitle("云渠道");
// titleUrl是标题的网络链接，QQ和QQ空间等使用
        oks.setTitleUrl(url);
// text是分享文本，所有平台都需要这个字段
        oks.setText("房地产分销渠道平台");
// imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
//oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
// url仅在微信（包括好友和朋友圈）中使用
        oks.setImageUrl(AppConstants.URL+"assets/img/logo.jpg");
// comment是我对这条分享的评论，仅在人人网和QQ空间使用
//        oks.setComment("我是测试评论文本");
// site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(getString(R.string.app_name));
// siteUrl是分享此内容的网站地址，仅在QQ空间使用
//        oks.setSiteUrl("http://sharesdk.cn");

// 启动分享GUI
        oks.show(this);
    }


    /**
     * 获取分享链接
     */
    private void getUrl(){
        OkHttpUtils.get(AppConstants.URL+"user/project/getHouseType")
                .tag(this)
                .params("house_type_id", id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        StringBean bean = JsonUtil.jsonToEntity(s,StringBean.class);
                        if(bean.getCode() == 200){
                            url = bean.getData().toString();
                        }
                    }
                });
    }

}