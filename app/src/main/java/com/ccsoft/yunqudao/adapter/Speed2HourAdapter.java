package com.ccsoft.yunqudao.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.HouseDetailBean;
import com.ccsoft.yunqudao.data.AppConstants;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Speed2HourAdapter extends RecyclerView.Adapter<Speed2HourHolder>{
    private List<HouseDetailBean.DataBean.ProjectImgBean.UrlBean> specailList;
    private LayoutInflater mInflater;
    private Context mContext=null;

    public Speed2HourAdapter(Context context , List<HouseDetailBean.DataBean.ProjectImgBean.UrlBean> specailList) {
        this.mContext=context;
        this.specailList = specailList;
        mInflater = LayoutInflater.from(context);
    }

    public void setList(List<HouseDetailBean.DataBean.ProjectImgBean.UrlBean> list) {
        this.specailList = list;
        notifyDataSetChanged();
    }


    public OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickLitener) {
        this.mOnItemClickListener = mOnItemClickLitener;
    }

    @Override
    public Speed2HourHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_project_tupian, parent, false);

        Speed2HourHolder holder = new Speed2HourHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final Speed2HourHolder holder, final int position) {
//        HouseDetailBean.DataBean bean = specailList.get(position);
//        if (bean != null) {
        Picasso.with(mContext)
                .load(AppConstants.URL+specailList.get(position).getImg_url())
                .error(R.drawable.ic_launcher_background)
                .into(holder.speedImage);

//            Glide.with(mContext).load(specailList.get(position).getProject_basic_info().getTotal_float_url()).into(holder.speedImage);
//        }

        holder.speedView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnItemClickListener!=null){
                    mOnItemClickListener.onItemClick(holder.speedView,position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {

        return specailList.size();

    }
}


class Speed2HourHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.speed_view)
    LinearLayout speedView;
    @BindView(R.id.im_tupian)
    ImageView speedImage;


    public Speed2HourHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        itemView.setTag(this);
    }
}
