package com.ccsoft.yunqudao.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.HouseDetailBean;
import com.ccsoft.yunqudao.bean.HouseListBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class HouseHuXing_RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements
        View.OnClickListener {
    private Context mcontext;
    private HouseList_RecyclerViewAdapter.OnItemClickListener listener = null;
    private List<HouseDetailBean.DataBean> mlist  ;

    public HouseHuXing_RecyclerViewAdapter(Context mContext , List<HouseDetailBean.DataBean> mlist){
        this.mcontext= mContext;
        this.mlist = mlist;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view ;
        RecyclerView.ViewHolder holder = null;
        mcontext = parent.getContext();
        view = LayoutInflater.from(mcontext).inflate(R.layout.househuxing_activity,null);
        view.setOnClickListener(this);
        holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder) {
            MyViewHolder holder1 = (MyViewHolder) holder;
            holder.itemView.setTag(position);
        }
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    @Override
    public void onClick(View v) {
        if (listener != null) {
            listener.setItemClick(v, (Integer) v.getTag());
        }
    }
    public void setOnItemClickListener(HouseList_RecyclerViewAdapter.OnItemClickListener listener){
        this.listener = listener;
    }
    public interface OnItemClickListener{
        void setItemClick(View view, int position);
    }
    class MyViewHolder extends RecyclerView.ViewHolder {
       ImageView im_huxing1;

        public MyViewHolder(View itemView) {
            super(itemView);
           im_huxing1 = itemView.findViewById(R.id.im_huxing1);
        }
    }
}
