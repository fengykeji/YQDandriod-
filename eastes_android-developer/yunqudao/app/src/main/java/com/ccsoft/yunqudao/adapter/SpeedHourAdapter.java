package com.ccsoft.yunqudao.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.HouseDetailBean;
import com.ccsoft.yunqudao.ui.house.SpeedHourEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SpeedHourAdapter extends RecyclerView.Adapter<SpeedHourHolder> {

    private List<HouseDetailBean.DataBean> specailList;
    private LayoutInflater mInflater;
    private Context mContext=null;

    public SpeedHourAdapter(Context context) {
        this.mContext=context;
        mInflater = LayoutInflater.from(context);
    }

    public void setList(List<HouseDetailBean.DataBean> list) {
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
    public SpeedHourHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.househuxing_activity, parent, false);

        SpeedHourHolder holder = new SpeedHourHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final SpeedHourHolder holder, final int position) {
//        HouseDetailBean.DataBean bean = specailList.get(position);
//        if (bean != null) {
            holder.speedImage.setScaleType(ImageView.ScaleType.FIT_XY);
//            Glide.with(mContext).load(specailList.get(position).getProject_basic_info().getTotal_float_url()).into(holder.speedImage);
            holder.speedName.setText("A型");
            holder.speedArea.setText("102m²");
            holder.speedtype.setText("3室1厅");
            holder.speedsale.setText("在售");
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
        if (specailList!=null)
        return specailList.size();
        return 5;
    }
}


class SpeedHourHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.speed_view)
    LinearLayout speedView;
    @BindView(R.id.im_huxing1)
    ImageView speedImage;
    @BindView(R.id.tv_house_type_name)
    TextView speedName;
    @BindView(R.id.tv_property_area)
    TextView speedArea;
    @BindView(R.id.tv_house_type)
    TextView speedtype;
    @BindView(R.id.tv_sale_state1)
    TextView speedsale;

    public SpeedHourHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        itemView.setTag(this);
    }

}
