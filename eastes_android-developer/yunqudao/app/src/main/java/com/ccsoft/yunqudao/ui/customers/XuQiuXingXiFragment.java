package com.ccsoft.yunqudao.ui.customers;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.data.model.response.ClientPrivateData;

/**
 * @author: Pein
 * @data: 2018/5/14 0014
 */

public class XuQiuXingXiFragment extends Fragment implements View.OnClickListener {

    private View                           mView;
    private XuQiuXingXiFragment            mXuQiuXingXiFragment;
    private ImageButton                    mCustomers_button_resetclientneed;
    private ClientPrivateData.NeedInfoBean mData;

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

    private int propertyType = 0;//住宅类型
    private int totalPrice   = 0;//总价类型
    private int area         = 0;//面积类型
    private String house_type;//户型类型
    private int houseType   = 0;//户型类型(String转int)
    private int decorate    = 0;//装修类型
    private int buy_purpose = 0;//置业类型
    private int pay_type    = 0;//付款类型

    public static XuQiuXingXiFragment newInstance(ClientPrivateData.NeedInfoBean needInfoBean) {
        XuQiuXingXiFragment fragment = new XuQiuXingXiFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("data", needInfoBean);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_customers_xiangqing_xuqiu, container, false);
        mData = (ClientPrivateData.NeedInfoBean) getArguments().getSerializable("data");
        initView();
        initListener();
        setData();
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
        mCustomers_button_resetclientneed = mView.findViewById(R.id.customers_button_resetclientneed);
    }

    private void initListener() {

        this.mCustomers_button_resetclientneed.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.customers_button_resetclientneed:
                ResetClientNeedActivity.start(getActivity());
        }
    }

    private void setData() {

        if (mData != null) {
            propertyType = mData.property_type;
            totalPrice = mData.total_price;
            area = mData.area;
            decorate = mData.decorate;
            buy_purpose = mData.buy_purpose;
            pay_type = mData.pay_type;
            // houseType = Integer.valueOf(mData.house_type).intValue();

            // setPropertyType(mData.property_type, mCustomers_property_type);
            setTotalPrice(mData.total_price, mCustomers_total_price);
            setArea(mData.area, mCustomers_area);
            //  setHouseType(Integer.valueOf(mData.house_type).intValue(), mCustomers_house_type);
            setDecorate(mData.decorate, mCustomers_decorate);
            setBuyPurpose(mData.buy_purpose, mCustomers_buy_purpose);
            setPayType(mData.pay_type, mCustomers_pay_type);

            mCustomers_floor.setText(String.valueOf(mData.floor_min) + "层" + " - " + String.valueOf(mData.floor_max) + "层");
            mCustomers_intent.setText(String.valueOf(mData.intent) + "%");
            mCustomers_urgency.setText(String.valueOf(mData.urgency) + "%");
            String address = "";
            //for (int i = 0; i < 3; i++) {
            //    ClientPrivateData.NeedInfoBean.Region info = mData.region.get(i);
            //    address = address + info.city_name + " - " + info.district_name + "   ";
            //}
            mCustomers_regions.setText(address);
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
        if (totalPrice != 0) {
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
    private void setHouseType(int type, TextView textView) {
        if (totalPrice != 0) {
            switch (type) {
                case 32:
                    textView.setText("3室2厅2卫");
                    break;
                case 33:
                    textView.setText("1室1厅2卫");
                    break;
                case 106:
                    textView.setText("1室1厅1卫");
                    break;
            }
        }
    }

    /**
     * type : 装修标准
     * param : [{"id":80,"param":"毛坯"},{"id":81,"param":"简装"},{"id":82,"param":"精装"}]
     */
    private void setDecorate(int type, TextView textView) {
        if (totalPrice != 0) {
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
        if (totalPrice != 0) {
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
        if (totalPrice != 0) {
            switch (type) {
                case 46:
                    textView.setText("一次性付款");
                    break;
                case 47:
                    textView.setText("公积金贷款");
                    break;
                case 48:
                    textView.setText("综合贷款");
                    break;
            }
        }
    }
}