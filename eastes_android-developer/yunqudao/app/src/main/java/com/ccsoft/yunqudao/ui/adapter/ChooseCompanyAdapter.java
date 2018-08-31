package com.ccsoft.yunqudao.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.adapter.SpeedHourAdapter;
import com.ccsoft.yunqudao.bean.GetCompanyListBean;
import com.ccsoft.yunqudao.data.AppConstants;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ChooseCompanyAdapter extends RecyclerView.Adapter<ChooseCompanyAdapter.MyViewHolder> {
    private List<GetCompanyListBean.DataBeanX.DataBean> dataList = new ArrayList<>();

    private LayoutInflater layoutInflater;
    private Context context;

    public ChooseCompanyAdapter(Context context,List<GetCompanyListBean.DataBeanX.DataBean> dataList){
        this.dataList = dataList;
        layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    public OnItemClickListener mOnItemClickListener;



    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickLitener) {
        this.mOnItemClickListener = mOnItemClickLitener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.item_me_renzheng, parent, false);
        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
//
//        Picasso.with(context).load(AppConstants.URL+dataList.get(position).getLogo()).error(R.drawable.default_1)
//                .fit().into(holder.imageView);
        holder.tv_companyname.setText(dataList.get(position).getCompany_name());
        holder.tv_content.setText(dataList.get(position).getAbsolute_address());
        holder.tv_person.setText(dataList.get(position).getContact());

        holder.ll_dianji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnItemClickListener!=null){
                    mOnItemClickListener.onItemClick(holder.ll_dianji,position);
                }
            }
        });


    }



    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_companyname;

        private TextView tv_content;
        private TextView tv_tel;
        private TextView tv_person;
        private ImageView imageView;
        private LinearLayout ll_dianji;

        MyViewHolder(View itemView) {
            super(itemView);
            tv_companyname = (TextView) itemView.findViewById(R.id.tv_companyname);
            tv_content = (TextView) itemView.findViewById(R.id.tv_content);
            tv_tel = itemView.findViewById(R.id.tv_tel);
            tv_person = itemView.findViewById(R.id.tv_person);
            ll_dianji = itemView.findViewById(R.id.ll_dianji);
        }
    }


}
