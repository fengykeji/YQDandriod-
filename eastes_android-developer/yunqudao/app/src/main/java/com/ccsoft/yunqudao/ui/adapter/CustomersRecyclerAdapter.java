package com.ccsoft.yunqudao.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.BaseViewHolder;
import com.ccsoft.yunqudao.data.model.viewmodel.CustomerListViewModel;
import com.ccsoft.yunqudao.model.ClientListModel;
import com.ccsoft.yunqudao.utils.recyclerviwe.BaseRecyclerViewAdapter;
import com.ccsoft.yunqudao.utils.recyclerviwe.BaseRecyclerViewHolder;
import java.util.List;

/**
 * @author: Pein
 * @data: 2018/5/23 0023
 */

public class CustomersRecyclerAdapter extends BaseRecyclerAdapter<ClientListModel.DataBeanX.DataBean>{


    public CustomersRecyclerAdapter(Context context, int layoutId, List<ClientListModel.DataBeanX.DataBean> data) {
        super(context, layoutId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, ClientListModel.DataBeanX.DataBean bean,int position) {
        TextView mCustomers_text_姓名 = (TextView) holder.getView(R.id.customers_text_姓名);
        ImageView mCustomers_image_性别 = (ImageView) holder.getView(R.id.customers_image_性别);
        TextView mCustomers_text_意向总价 = (TextView) holder.getView(R.id.customers_text_意向总价);
        TextView mCustomers_text_联系电话 = (TextView) holder.getView(R.id.customers_text_联系电话);
        TextView mCustomers_text_意向物业 = (TextView) holder.getView(R.id.customers_text_意向物业);
        TextView mCustomers_text_购买意向度 = (TextView) holder.getView(R.id.customers_text_购买意向度);
        TextView mCustomers_text_意向区域 = (TextView) holder.getView(R.id.customers_text_意向区域);
        TextView mCustomers_text_购买紧迫度 = (TextView) holder.getView(R.id.customers_text_购买紧迫度);

        //* 25 : {"type":"总价","param":[{"id":91,"param":"50"},{"id":92,"param":"50-80"},{"id":93,"param":"80-120"},{"id":94,"param":"120-200"},{"id":95,"param":"200"}]}


        if (bean.getTotal_price()!=0){
            switch (bean.getTotal_price()){
                case 91:
                    mCustomers_text_意向总价.setText("50"+"万");
                    break;
                case 92:
                    mCustomers_text_意向总价.setText("50-80"+"万");
                    break;
                case 93:
                    mCustomers_text_意向总价.setText("80-120"+"万");
                    break;
                case 94:
                    mCustomers_text_意向总价.setText("120-200"+"万");
                    break;
                case 95:
                    mCustomers_text_意向总价.setText("200"+"万");
                    break;
            }
        }

        //* 16 : {"type":"物业类型","param":[{"id":59,"param":"住宅"},{"id":60,"param":"公寓"},{"id":61,"param":"别墅"},{"id":62,"param":"商铺"},{"id":63,"param":"写字楼"},{"id":64,"param":"车位"}]}

        if (bean.getProperty_type()!=0){
            switch (bean.getProperty_type()){
                case 59:
                    mCustomers_text_意向物业.setText("住宅");
                    break;
                case 60:
                    mCustomers_text_意向物业.setText("公寓");
                    break;
                case 61:
                    mCustomers_text_意向物业.setText("别墅");
                    break;
                case 62:
                    mCustomers_text_意向物业.setText("商铺");
                    break;
                case 63:
                    mCustomers_text_意向物业.setText("写字楼");
                    break;
                case 64:
                    mCustomers_text_意向物业.setText("车位");
                    break;
            }

        }

        mCustomers_text_姓名.setText(bean.getName());
        if(bean.getSex() == 1){
            mCustomers_image_性别.setImageResource(R.drawable.ic_man);
        }else if(bean.getSex()==2){
            mCustomers_image_性别.setImageResource(R.drawable.ic_girl);
        }

        mCustomers_text_联系电话.setText(String.valueOf(bean.getTel()));
        mCustomers_text_购买意向度.setText(String.valueOf(bean.getIntent()) + "%");
        if(!bean.getRegion().toString().equals("[]")) {
            mCustomers_text_意向区域.setText(bean.getRegion().get(0).getProvince_name()
            +"-"+bean.getRegion().get(0).getCity_name()+"-"+
                    bean.getRegion().get(0).getDistrict_name());
        }
        mCustomers_text_购买紧迫度.setText(String.valueOf(bean.getUrgency()) + "%");

    }
}
