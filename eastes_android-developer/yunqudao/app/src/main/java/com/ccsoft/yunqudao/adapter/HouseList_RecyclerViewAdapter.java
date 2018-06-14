package com.ccsoft.yunqudao.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.HouseListBean;
import com.ccsoft.yunqudao.data.AppConstants;
import com.ccsoft.yunqudao.utils.ImageUtil;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class HouseList_RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements
        View.OnClickListener {
    private Context mcontext;
    private OnItemClickListener listener = null;
    private List<HouseListBean.DataBean> mlist  ;

    public HouseList_RecyclerViewAdapter(Context mContext , List<HouseListBean.DataBean> mlist){
        this.mcontext= mContext;
        this.mlist = mlist;
    }

    public void setmList(List<HouseListBean.DataBean> mList) {
        this.mlist = mList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view ;
        RecyclerView.ViewHolder holder = null;
        mcontext = parent.getContext();
        view = LayoutInflater.from(mcontext).inflate(R.layout.house_list_activity,null);
        view.setOnClickListener(this);
        holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder) {
            MyViewHolder holder1 = (MyViewHolder) holder;
            ImageUtil.load(Uri.parse(AppConstants.URL+mlist.get(position).getImg_url()),holder1.im_house_list,150,133);
            holder1.tv_place.setText(mlist.get(position).getProject_name());
            holder1.tv_mingci.setText(mlist.get(position).getAbsolute_address());
            holder1.tv_sale_state.setText(mlist.get(position).getSale_state());
            holder.itemView.setTag(position);
        }
    }

        @Override
        public int getItemCount () {
            return mlist.size();
        }

        @Override
        public void onClick (View v){
            if (listener != null) {
                listener.setItemClick(v, (Integer) v.getTag());
            }
        }
    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }
    public interface OnItemClickListener{
        void setItemClick(View view, int position);
    }

    }

class MyViewHolder extends RecyclerView.ViewHolder{
    SimpleDraweeView im_house_list;
    TextView tv_place,tv_mingci,tv_keywords,tv_keywords2,tv_sale_state;

    public MyViewHolder(View itemView) {
        super(itemView);
        im_house_list = itemView.findViewById(R.id.im_house_list);
        tv_place = itemView.findViewById(R.id.tv_place);
        tv_mingci = itemView.findViewById(R.id.tv_mingci);
        tv_keywords = itemView.findViewById(R.id.tv_keywords);
        tv_keywords2 = itemView.findViewById(R.id.tv_keywords2);
        tv_sale_state = itemView.findViewById(R.id.tv_sale_state);
    }
}
