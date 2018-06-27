package com.ccsoft.yunqudao.ui.house;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.adapter.HouseHuXing_RecyclerViewAdapter;
import com.ccsoft.yunqudao.adapter.SpeedHourAdapter;
import com.ccsoft.yunqudao.bean.HouseDetailBean;
import com.ccsoft.yunqudao.data.AppConstants;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.model.StringModel;
import com.ccsoft.yunqudao.utils.BaseCallBack;
import com.ccsoft.yunqudao.utils.ImageUtil;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.ccsoft.yunqudao.utils.OkHttpManager;
import com.ccsoft.yunqudao.utils.SpUtil;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Response;

/**
 * @author: Pein
 * @data: 2018/5/9 0009
 */

public class ProjectXiangQingFragment extends Fragment implements View.OnClickListener, OnPageChangeListener {

    private View                     mView;
    private ProjectXiangQingFragment mProjectXiangQingFragment;
    private ImageView              mHouse_imageview_项目图册;
    private Button              mHouse_button_查看全部楼盘信息;
    private Button              mHouse_button_查看全部项目动态;
    private ImageView                mHouse_imageview_楼栋信息;
    private Button              mHouse_button_查看全部户型信息;
    private ViewPager                mHouse_viewpager_户型信息;
    private Button                   mHouse_button_教育;
    private Button                   mHouse_button_交通;
    private Button                   mHouse_button_医院;
    private Button                   mHouse_button_购物;
    private Button                   mHouse_button_餐饮;
    private Button              mHouse_button_查看更多推荐;
    private Button                   mHouse_button_推荐1;
    private Button                   mHouse_button_推荐2;
    private Button                   mHouse_button_电话咨询;
    private Button                   mHouse_button_推荐3;
    private TextView tv_project_name,tv_sale_state,tv_num,tv_handing_room_time,tv_average_price,
            tv_absolute_address,content_tv6,content_tv7,content_tv8,content_tv9,content_tv10,content_tv11,
            content_tv12,content_tv13,tv_loupanxiangqing;
    private LinearLayout ll_dongtaixiangqing;
    private ImageButton button;
    private int project_id;
    private OkHttpManager okHttpManager = OkHttpManager.getInstance();
    private HouseDetailBean houseDetailBean;
    private HouseHuXing_RecyclerViewAdapter adapter;
    private RecyclerView recyclerView;
    protected Context mContext;
    protected View contentView;
    protected AtomicBoolean isPreparingData;
    private SpeedHourAdapter speedHourAdapter=null;
    private List list;
//    private SpeedHourEntity entity=null;
    private int agent_id;
    private HouseDetailBean.DataBean bean;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_house_xiangmuxiangqing_xiangmu, container, false);
        initView();
        initData();
        initListener();
        initAdapter();
        setData();
        return mView;
    }

    private void initView() {
        /**
         * 初始化id
         */
        mHouse_imageview_项目图册 = mView.findViewById(R.id.house_imageview_项目图册);
        mHouse_button_查看全部楼盘信息 = mView.findViewById(R.id.house_button_查看全部楼盘信息);
        mHouse_button_查看全部项目动态 = mView.findViewById(R.id.house_button_查看全部项目动态);
        mHouse_imageview_楼栋信息 = mView.findViewById(R.id.house_imageview_楼栋信息);
        mHouse_viewpager_户型信息 = mView.findViewById(R.id.house_viewpager_户型信息);
        mHouse_button_查看全部户型信息 = mView.findViewById(R.id.house_button_查看全部户型信息);

        mHouse_button_教育 = mView.findViewById(R.id.house_button_教育);
        mHouse_button_交通 = mView.findViewById(R.id.house_button_交通);
        mHouse_button_医院 = mView.findViewById(R.id.house_button_医院);
        mHouse_button_购物 = mView.findViewById(R.id.house_button_购物);
        mHouse_button_餐饮 = mView.findViewById(R.id.house_button_餐饮);

        mHouse_button_查看更多推荐 = mView.findViewById(R.id.house_button_查看更多推荐);
        mHouse_button_推荐1 = mView.findViewById(R.id.house_button_推荐1);
        mHouse_button_推荐2 = mView.findViewById(R.id.house_button_推荐2);
        mHouse_button_电话咨询 = mView.findViewById(R.id.house_button_电话咨询);
        mHouse_button_推荐3 = mView.findViewById(R.id.house_button_推荐3);
        button = mView.findViewById(R.id.im_dianzan);

        tv_project_name = mView.findViewById(R.id.tv_project_name);
        tv_sale_state = mView.findViewById(R.id.tv_sale_state);
        tv_num = mView.findViewById(R.id.tv_num);
        tv_handing_room_time = mView.findViewById(R.id.tv_handing_room_time);
        tv_average_price = mView.findViewById(R.id.tv_average_price);
        tv_absolute_address = mView.findViewById(R.id.tv_absolute_address);
        content_tv6 = mView.findViewById(R.id.content_tv6);
        content_tv7 = mView.findViewById(R.id.content_tv7);
        content_tv8 = mView.findViewById(R.id.content_tv8);
        content_tv9 = mView.findViewById(R.id.content_tv9);
        content_tv10 = mView.findViewById(R.id.content_tv10);
        content_tv11 = mView.findViewById(R.id.content_tv11);
        content_tv12 = mView.findViewById(R.id.content_tv12);
        content_tv13 = mView.findViewById(R.id.content_tv13);
        tv_loupanxiangqing = mView.findViewById(R.id.tv_loupanxiangqing);
        ll_dongtaixiangqing = mView.findViewById(R.id.ll_dongtaixiangqing);

        recyclerView = mView.findViewById(R.id.re_huxing);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);




        /**
         * 接受上个页面传过来的值
         */
        project_id = getActivity().getIntent().getIntExtra("project_id",0);
        agent_id = SpUtil.getInt("agent_id",0);

    }

    private void initListener() {
        /**
         * 初始化监听器
         */
        this.mHouse_imageview_项目图册.setOnClickListener(this);
        this.mHouse_button_查看全部楼盘信息.setOnClickListener(this);
        this.mHouse_button_查看全部项目动态.setOnClickListener(this);
        this.mHouse_imageview_楼栋信息.setOnClickListener(this);
        this.mHouse_button_查看全部户型信息.setOnClickListener(this);
        //this.mHouse_button_教育.setOnClickListener(this);
        //this.mHouse_button_交通.setOnClickListener(this);
        //this.mHouse_button_医院.setOnClickListener(this);
        //this.mHouse_button_购物.setOnClickListener(this);
        //this.mHouse_button_餐饮.setOnClickListener(this);
        this.mHouse_button_查看更多推荐.setOnClickListener(this);
        this.mHouse_button_推荐1.setOnClickListener(this);
        this.mHouse_button_推荐2.setOnClickListener(this);
        this.mHouse_button_电话咨询.setOnClickListener(this);
        this.mHouse_button_推荐3.setOnClickListener(this);
        this.tv_loupanxiangqing.setOnClickListener(this);
        this.ll_dongtaixiangqing.setOnClickListener(this);
        this.button.setOnClickListener(this);

        isPreparingData = new AtomicBoolean(false);
        ButterKnife.bind(getActivity());
    }

    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.house_imageview_项目图册:
                ProjectXiangCeActivity.start(getActivity());
                break;
            case R.id.house_button_查看全部楼盘信息:
                ProjectJiChuXinXiActivity.start(getActivity());
                break;
            case R.id.house_button_查看全部项目动态:
                Intent intent1 = new Intent(getContext(),ProjectDongLieBiaoActivity.class);
                intent1.putExtra("project_id",project_id);
                startActivity(intent1);
                break;
            case R.id.house_imageview_楼栋信息:
                ProjectLouDongXiangQingActivity.start(getActivity());
                break;
            case R.id.house_button_查看全部户型信息:
                ProjectHuXingXiangQingActivity.start(getActivity());
                break;
            case R.id.house_button_教育:
                Toast.makeText(getActivity(), "查询了周边教育", Toast.LENGTH_SHORT).show();
                break;
            case R.id.house_button_交通:
                Toast.makeText(getActivity(), "查询了周边交通", Toast.LENGTH_SHORT).show();
                break;
            case R.id.house_button_医院:
                Toast.makeText(getActivity(), "查询了周边医院", Toast.LENGTH_SHORT).show();
                break;
            case R.id.house_button_购物:
                Toast.makeText(getActivity(), "查询了周边购物", Toast.LENGTH_SHORT).show();
                break;
            case R.id.house_button_餐饮:
                Toast.makeText(getActivity(), "查询了周边餐饮", Toast.LENGTH_SHORT).show();
                break;
            case R.id.house_button_查看更多推荐:
                ProjectPiPeiKeHuActivity.start(getActivity());
                break;
            case R.id.house_button_推荐1:
                Toast.makeText(getActivity(), "你推荐了该户型", Toast.LENGTH_SHORT).show();
                break;
            case R.id.house_button_推荐2:
                Toast.makeText(getActivity(), "你推荐了该户型", Toast.LENGTH_SHORT).show();
                break;
            case R.id.house_button_电话咨询:
                //String number = mHouse_text_客户联系电话.getText().toString();
                //Intent intent = new Intent();
                //intent.setAction(Intent.ACTION_CALL);
                //intent.setData(Uri.parse("tel:"+number));
                //startActivity(intent);
                Toast.makeText(getActivity(), "你拨打了电话", Toast.LENGTH_SHORT).show();
                break;
            case R.id.house_button_推荐3:

                break;
            case R.id.tv_loupanxiangqing:
                Intent intent = new Intent(getContext(),ProjectJiChuXinXiActivity.class);
                intent.putExtra("project_id",project_id);
                startActivity(intent);
                break;
            case R.id.im_dianzan:
                Log.e("cccc",bean.getFocus().getIs_focus()+"");
                if(bean.getFocus().getIs_focus()==0) {
                    OkHttpUtils.get(HttpAdress.focusProject)
                            .tag(getActivity())
                            .params("project_id", project_id)
                            .execute(new StringCallback() {
                                @Override
                                public void onSuccess(String s, Call call, Response response) {
                                    Log.e("ccccw","点击了");
                                    StringModel model = JsonUtil.jsonToEntity(s, StringModel.class);
                                    if (model.getCode() == 200) {
                                        Toast.makeText(getContext(), "关注成功", Toast.LENGTH_SHORT).show();
                                        button.setImageResource(R.drawable.ic_focus_selected);
                                        initData();
                                    }
                                    Toast.makeText(getContext(), model.getMsg(), Toast.LENGTH_SHORT).show();
                                }
                            });
                }else {
                    OkHttpUtils.get(HttpAdress.cancelFocusProject)
                            .tag(getActivity())
                            .params("project_id", project_id)
                            .execute(new StringCallback() {
                                @Override
                                public void onSuccess(String s, Call call, Response response) {
                                    Log.e("ccccs","点击了");
                                    StringModel model = JsonUtil.jsonToEntity(s, StringModel.class);
                                    if (model.getCode() == 200) {
                                        Toast.makeText(getContext(), "取消关注成功", Toast.LENGTH_SHORT).show();
                                        button.setImageResource(R.drawable.ic_focus_2);
//
                                        initData();
                                    }
                                    Toast.makeText(getContext(), model.getMsg(), Toast.LENGTH_SHORT).show();
                                }
                            });
                }
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

    private void initData(){
        OkHttpUtils.get(HttpAdress.HOUSEDETAIL)
                .tag(getActivity())
                .params("project_id",project_id)
                .params("agent_id",agent_id)
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
                        if(code == 200&& data!=null){
                            GsonBuilder builder = new GsonBuilder();
                            Gson gson = builder.create();
                             bean = gson.fromJson(data,HouseDetailBean.DataBean.class);

//                            ImageUtil.load(Uri.parse(AppConstants.URL + bean.getProject_basic_info().getTotal_float_url_phone()), mHouse_imageview_项目图册, 540, 275);
                            tv_project_name.setText(bean.getProject_basic_info().getProject_name());
                            tv_sale_state.setText(bean.getProject_basic_info().getSale_state());
                            tv_num.setText(bean.getFocus().getNum() + "");
                            tv_handing_room_time.setText(bean.getProject_basic_info().getDeveloper_name());
                            tv_average_price.setText(bean.getProject_basic_info().getAverage_price() + "/m2");
                            tv_absolute_address.setText(bean.getProject_basic_info().getAbsolute_address());
                            content_tv6.setText(bean.getProject_basic_info().getDeveloper_name());
                            content_tv7.setText(bean.getBuild_info().getOpen_time());
                            content_tv8.setText(bean.getBuild_info().getHanding_room_time());
                            content_tv10.setText("共"+bean.getDynamic().getCount()+"条");
                            content_tv11.setText(bean.getDynamic().getFirst().getTitle());
                            content_tv13.setText(bean.getDynamic().getFirst().getContent());
                            content_tv12.setText(bean.getDynamic().getFirst().getCreate_time());
                            if(bean.getFocus().getIs_focus()==1){
                                button.setImageResource(R.drawable.ic_focus_selected);
                            }else {
                                button.setImageResource(R.drawable.ic_focus_2);
                            }
                        }
                    }
                });
    }

    private void initAdapter() {
        speedHourAdapter=new SpeedHourAdapter(getContext());
        recyclerView.setAdapter(speedHourAdapter);




        speedHourAdapter.setOnItemClickListener(new SpeedHourAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }
        });
    }

    private void setData(){
        ll_dongtaixiangqing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getContext(),ProjectDongTaiXiangQingActivity.class);
                intent2.putExtra("url",bean.getDynamic().getFirst().getImg_url());
                startActivity(intent2);
            }
        });
    }
}



