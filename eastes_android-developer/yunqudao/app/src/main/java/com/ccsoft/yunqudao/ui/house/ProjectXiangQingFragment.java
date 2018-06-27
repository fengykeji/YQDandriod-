package com.ccsoft.yunqudao.ui.house;

import android.content.Context;
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
import com.ccsoft.yunqudao.utils.BaseCallBack;
import com.ccsoft.yunqudao.utils.ImageUtil;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.ccsoft.yunqudao.utils.OkHttpManager;
import com.ccsoft.yunqudao.utils.SpUtil;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
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
    private SimpleDraweeView              mHouse_imageview_项目图册;
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
            content_tv12,content_tv13;
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

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_house_xiangmuxiangqing_xiangmu, container, false);
        initView();
        initListener();
        loadProjectDetail();
        initAdapter();
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

        recyclerView = mView.findViewById(R.id.re_huxing);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);




        /**
         * 接受上个页面传过来的值
         */
        project_id = getActivity().getIntent().getIntExtra("project_id",0);
        agent_id = SpUtil.getInt("agent_id",0);
        Log.e("ccccc",agent_id+"");
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
                ProjectDongLieBiaoActivity.start(getActivity());
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

    private void loadProjectDetail(){

        okHttpManager.get(HttpAdress.HOUSEDETAIL+"?project_id="+project_id+"&agent_id="+agent_id , new BaseCallBack() {
            @Override
            public void onSuccess(Call call, Response response, Object obj) throws MalformedURLException {
                Type type = new TypeToken<HouseDetailBean>() {}.getType();
                houseDetailBean = new Gson().fromJson(obj.toString(),type);
                Log.e("houseDetailBean",houseDetailBean.getMsg());

                if(houseDetailBean.getCode()==200&&houseDetailBean.getData()!=null) {
                    list = houseDetailBean.getData().getHouse_type();

                    ImageUtil.load(Uri.parse(AppConstants.URL + houseDetailBean.getData().getProject_basic_info().getTotal_float_url_phone()), mHouse_imageview_项目图册, 540, 275);
                    tv_project_name.setText(houseDetailBean.getData().getProject_basic_info().getProject_name());
                    tv_sale_state.setText(houseDetailBean.getData().getProject_basic_info().getSale_state());
                    tv_num.setText(houseDetailBean.getData().getFocus().getNum() + "");
                    tv_handing_room_time.setText(houseDetailBean.getData().getBuild_info().getHanding_room_time());
                    tv_average_price.setText(houseDetailBean.getData().getProject_basic_info().getAverage_price() + "");
                    tv_absolute_address.setText(houseDetailBean.getData().getProject_basic_info().getAbsolute_address());
                    content_tv6.setText(houseDetailBean.getData().getProject_basic_info().getDeveloper_name());
                    content_tv7.setText(houseDetailBean.getData().getBuild_info().getOpen_time());
                    content_tv8.setText(houseDetailBean.getData().getBuild_info().getHanding_room_time());

                    mHouse_imageview_楼栋信息.setImageURI(Uri.parse(houseDetailBean.getData().getProject_basic_info().getTotal_float_url()));
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

    private void initAdapter() {
        speedHourAdapter=new SpeedHourAdapter(getContext());
        recyclerView.setAdapter(speedHourAdapter);




        speedHourAdapter.setOnItemClickListener(new SpeedHourAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }
        });
    }
}



