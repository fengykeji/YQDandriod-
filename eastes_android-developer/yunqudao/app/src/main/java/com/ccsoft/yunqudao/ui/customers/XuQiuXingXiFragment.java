package com.ccsoft.yunqudao.ui.customers;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.CustomersGetInfoBean;
import com.ccsoft.yunqudao.bean.PeizhiBean;
import com.ccsoft.yunqudao.data.model.response.ClientPrivateData;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.ui.mian.MainActivity;
import com.ccsoft.yunqudao.utils.BaseCallBack;
import com.ccsoft.yunqudao.utils.OkHttpManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * @author: Pein
 * @data: 2018/5/14 0014
 */

public class XuQiuXingXiFragment extends Fragment implements View.OnClickListener {

    private View                           mView;
    private XuQiuXingXiFragment            mXuQiuXingXiFragment;
    private TextView                    mCustomers_button_resetclientneed;
//    private ClientPrivateData.NeedInfoBean mData;

    private TextView mCustomers_property_type;
    private TextView mCustomers_regions;
    private TextView mCustomers_total_price;
    private TextView mCustomers_area;
    private TextView mCustomers_house_type;
    private TextView mCustomers_floor;
    private TextView mCustomers_decorate;
    private TextView mCustomers_buy_purpose;
    private TextView mCustomers_pay_type;
    private TextView mCustomers_intent;
    private TextView mCustomers_urgency;
    private TextView tv_qitaneeds;

    private CustomersGetInfoBean bean;
    private int mClienID;

    private int propertyType = 0;//住宅类型
    private int totalPrice   = 0;//总价类型
    private int area         = 0;//面积类型
    private int house_type;//户型类型
    private int houseType   = 0;//户型类型(String转int)
    private int decorate    = 0;//装修类型
    private int buy_purpose = 0;//置业类型
    private int pay_type    = 0;//付款类型
    private int foor_min = 0;
    private int foor_max = 0;
    private int intents = 0;
    private int urgency = 0;
    private String commnet = "";
    private String need_id;
    private boolean isGetData = false;
    private String need_tags;
    private LinearLayout ll_showlabers;

    public static XuQiuXingXiFragment newInstance() {
        XuQiuXingXiFragment fragment = new XuQiuXingXiFragment();
        Bundle bundle = new Bundle();
//        bundle.putSerializable("data", (Serializable) needInfoBean);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        //   进入当前Fragment
        if (enter && !isGetData) {
            isGetData = true;
            //   这里可以做网络请求或者需要的数据刷新操作

           initData();
        } else {
            isGetData = false;
        }
        return super.onCreateAnimation(transit, enter, nextAnim);
    }

    @Override
    public void onPause() {
        super.onPause();
        isGetData = false;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_customers_xiangqing_xuqiu, container, false);
//        mData = (ClientPrivateData.NeedInfoBean) getArguments().getSerializable("data");
        initView();

        initData();
        initListener();

        return mView;
    }

    private void initView() {
        mCustomers_property_type = mView.findViewById(R.id.customers_property_type);
        mCustomers_regions = mView.findViewById(R.id.customers_regions);
        mCustomers_total_price = mView.findViewById(R.id.customers_total_price);
        mCustomers_area = mView.findViewById(R.id.customers_area);
        mCustomers_house_type = mView.findViewById(R.id.customers_house_type);
        mCustomers_floor = mView.findViewById(R.id.customers_floor);
        mCustomers_decorate = mView.findViewById(R.id.customers_decorate);
        mCustomers_buy_purpose = mView.findViewById(R.id.customers_buy_purpose);
        mCustomers_pay_type = mView.findViewById(R.id.customers_pay_type);
        mCustomers_intent = mView.findViewById(R.id.customers_intent);
        mCustomers_urgency = mView.findViewById(R.id.customers_urgency);
        tv_qitaneeds = mView.findViewById(R.id.tv_qitaneeds);
        ll_showlabers = mView.findViewById(R.id.ll_showlabel);
        mCustomers_button_resetclientneed = mView.findViewById(R.id.customers_button_resetclientneed);


        mClienID =getActivity().getIntent().getIntExtra("client_id",0);
    }

    private void initListener() {

        this.mCustomers_button_resetclientneed.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.customers_button_resetclientneed:
//                ResetClientNeedActivity.start(getActivity());
                Intent intent = new Intent(getContext(),ResetClientNeedActivity.class);
                intent.putExtra("need_id",need_id);
                intent.putExtra("propertyType",propertyType);
                intent.putExtra("totalPrice",totalPrice);
                intent.putExtra("area",area);
                intent.putExtra("decorate",decorate);
                intent.putExtra("buy_purpose",buy_purpose);
                intent.putExtra("pay_type",pay_type);
                intent.putExtra("houseType",houseType);
                intent.putExtra("need_tags",need_tags);

                intent.putExtra("foor_min",foor_min);
                intent.putExtra("foor_max",foor_max);
                intent.putExtra("intents",intents);
                intent.putExtra("urgency",urgency);
                intent.putExtra("comment",commnet);
                startActivity(intent);
        }
    }

    private void initData(){
        OkHttpManager.getInstance().get(HttpAdress.getInfo + "?client_id=" + mClienID, new BaseCallBack() {
            @Override
            public void onSuccess(Call call, Response response, Object obj) throws MalformedURLException {
                Type type = new TypeToken<CustomersGetInfoBean>() {}.getType();

                bean = new Gson().fromJson(obj.toString(),type);


                if(bean.getCode()==200&&bean.getData()!=null) {
                    CustomersGetInfoBean.DataBean.NeedInfoBean  data= bean.getData().getNeed_info().get(0);
                    setData(data);


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

    private void setData(CustomersGetInfoBean.DataBean.NeedInfoBean  data) {

        if (data != null) {
            need_id = String.valueOf(data.getNeed_id());
            propertyType = data.getProperty_type();
            totalPrice = data.getTotal_price();
            area = data.getArea();
            decorate = data.getDecorate();
            buy_purpose = data.getBuy_purpose();
            pay_type = data.getPay_type();
             houseType = Integer.parseInt(data.getHouse_type());
             need_tags = data.getNeed_tags();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(10,3,10,3);

            String[] b = need_tags.split(",");
            PeizhiBean peizhiBean = MainActivity.savePeizhi();
            List<PeizhiBean.DataBean._$15Bean.ParamBeanXXXXXXXXXXXXXX> list = peizhiBean.getData().get_$15().getParam();

            ll_showlabers.removeAllViews();
                for (String s : b) {
                    for (PeizhiBean.DataBean._$15Bean.ParamBeanXXXXXXXXXXXXXX bean3 : list) {
                        if(!s.equals("")) {
                            if (bean3.getId() == Integer.parseInt(s)) {
                            TextView textView = new TextView(getContext());
                            textView.setText(bean3.getParam());
                            textView.setBackgroundResource(R.drawable.shape_addlabel);
                            textView.setPadding(14, 14, 14, 14);
                                textView.setTextSize(19);
                            ll_showlabers.addView(textView, layoutParams);
                        }
                    }
                }
            }

            setPropertyType(data.getProperty_type(), mCustomers_property_type);
            setTotalPrice(data.getTotal_price(), mCustomers_total_price);
            setArea(data.getArea(), mCustomers_area);
            setHouseType(data.getHouse_type(), mCustomers_house_type);
            setDecorate(data.getDecorate(), mCustomers_decorate);
            setBuyPurpose(data.getBuy_purpose(), mCustomers_buy_purpose);
            setPayType(data.getPay_type(), mCustomers_pay_type);

            foor_min = data.getFloor_min();
            foor_max = data.getFloor_max();
            intents = data.getIntent();
            urgency = data.getUrgency();
            commnet = data.getComment();

            mCustomers_floor.setText(String.valueOf(data.getFloor_min()) + "层" + " - " + String.valueOf(data.getFloor_max()) + "层");
            mCustomers_intent.setText(String.valueOf(data.getIntent()) + "%");
            mCustomers_urgency.setText(String.valueOf(data.getUrgency()) + "%");
            tv_qitaneeds.setText(data.getComment());

            String address = "";
            //for (int i = 0; i < 3; i++) {
            //    ClientPrivateData.NeedInfoBean.Region info = mData.region.get(i);
            //    address = address + info.city_name + " - " + info.district_name + "   ";
            //}
//            mCustomers_regions.setText(address);

            if(data.getHouse_type().equals("32")){
                mCustomers_house_type.setText("3室2厅2卫");
            }else if(data.getHouse_type().equals("33")){
                mCustomers_house_type.setText("1室1厅2卫");
            }else if(data.getHouse_type().equals("106")){
                mCustomers_house_type.setText("1室1厅1卫");
            }
        }
    }

    //* "16":{"type":"物业类型","param":[{"id":59,"param":"住宅"},
    //     * {"id":60,"param":"公寓"},{"id":61,"param":"别墅"},{"id":62,"param":"商铺"},{"id":63,"param":"写字楼"},
    //     * {"id":64,"param":"车位"}]},
    private void setPropertyType(int type, TextView textView) {
        if (propertyType != 0) {
            switch (type) {
                case 59:
                    textView.setText("住宅");
                    break;
                case 60:
                    textView.setText("公寓");
                    break;
                case 61:
                    textView.setText("别墅");
                    break;
                case 62:
                    textView.setText("商铺");
                    break;
                case 63:
                    textView.setText("写字楼");
                    break;
            }
        }
    }

    //* 25 : {"type":"总价","param":[{"id":91,"param":"50"},{"id":92,"param":"50-80"},{"id":93,"param":"80-120"},{"id":94,"param":"120-200"},{"id":95,"param":"200"}]}
    private void setTotalPrice(int type, TextView textView) {
        if (totalPrice != 0) {
            switch (type) {
                case 91:
                    textView.setText("50" + "万");
                    break;
                case 92:
                    textView.setText("50-80" + "万");
                    break;
                case 93:
                    textView.setText("80-120" + "万");
                    break;
                case 94:
                    textView.setText("120-200" + "万");
                    break;
                case 95:
                    textView.setText("200" + "万");
                    break;
            }
        }
    }

    //* param : [{"id":96,"param":"50"},{"id":97,"param":"50-90"},{"id":98,"param":"90-130"},{"id":99,"param":"130-150"},{"id":100,"param":"150"}]
    private void setArea(int type, TextView textView) {
        if (area != 0) {
            switch (type) {
                case 96:
                    textView.setText("50");
                    break;
                case 97:
                    textView.setText("50-90");
                    break;
                case 98:
                    textView.setText("90-130");
                    break;
                case 99:
                    textView.setText("130-150");
                    break;
                case 100:
                    textView.setText("150");
                    break;
            }
        }
    }

    //type : 住房类型 param : [{"id":32,"param":"3室2厅2卫"},{"id":33,"param":"1室1厅2卫"},{"id":106,"param":"1室1厅1卫"}]
    private void setHouseType(String type, TextView textView) {
Log.e("ccccc",type);
        if (house_type != 0) {
//            switch (type) {
//                case 32+"":
//                    textView.setText("3室2厅2卫");
//                    break;
//                case 33+"":
//                    textView.setText("1室1厅2卫");
//                    break;
//                case 106+"":
//                    textView.setText("1室1厅1卫");
//                    break;
//            }
            if(type.equals("32")){
                textView.setText("3室2厅2卫");
            }else if(type.equals("33")){
                textView.setText("1室1厅2卫");
            }else if(type.equals("106")){
                textView.setText("1室1厅1卫");
            }
        }
    }

    /**
     * type : 装修标准
     * param : [{"id":80,"param":"毛坯"},{"id":81,"param":"简装"},{"id":82,"param":"精装"}]
     */
    private void setDecorate(int type, TextView textView) {
        if (decorate != 0) {
            switch (type) {
                case 80:
                    textView.setText("毛坯");
                    break;
                case 81:
                    textView.setText("简装");
                    break;
                case 82:
                    textView.setText("精装");
                    break;
            }
        }
    }
    //* "12":{"type":"置业目的","param":[{"id":43,"param":"投资"},{"id":44,"param":"自住"},{"id":45,"param":"投资兼自住"}]},

    private void setBuyPurpose(int type, TextView textView) {
        if (buy_purpose != 0) {
            switch (type) {
                case 43:
                    textView.setText("投资");
                    break;
                case 44:
                    textView.setText("自住");
                    break;
                case 45:
                    textView.setText("投资兼自住");
                    break;
            }
        }
    }
    //* "13":{"type":"付款方式","param":[{"id":46,"param":"一次性付款"},{"id":47,"param":"公积金贷款"},{"id":48,"param":"综合贷款"},

    private void setPayType(int type, TextView textView) {
        if (pay_type != 0) {
            switch (type) {
                case 46:
                    textView.setText("一次性付款");
                    break;
                case 47:
                    textView.setText("公积金贷款");
                    break;
                case 48:
                    textView.setText("综合贷款");
                case 49:
                    textView.setText("银行按揭贷款");
                case 50:
                    textView.setText("分期付款");
                    break;
            }
        }
    }
}