package com.ccsoft.yunqudao.data.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.ccsoft.yunqudao.R;

import java.util.List;

/**
 * Created by lxk on 2016/11/21.
 */
public abstract class BaseRecyclerAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private int layoutId;
    private int empty_layout = R.layout.empty_layout;
    private View head_layout;
    public List<T> data;
    public Context context;
    public OnItemClickListner onItemClickListner;//单击事件
    private OnItemLongClickListner onItemLongClickListner;//长按单击事件
    private boolean clickFlag = true;//单击事件和长单击事件的屏蔽标识

    private static final int FOOTER_LAYOUT = 0;
    private static final int NORMAL_LAYOUT = 1;
    private static final int ENMPTY_LAYOUT = 2;
    private static final int HEAD_LAYOUT = 3;

    public FooterHolder footerHolder;
    public HeadHolder headHolder;

    /**
     * @param context  //上下文
     * @param layoutId //布局id
     * @param data     //数据源
     */
    public BaseRecyclerAdapter(Context context, int layoutId, List<T> data) {
        this.layoutId = layoutId;
        this.data = data;
        this.context = context;
    }

    public BaseRecyclerAdapter(Context context, int layoutId, List<T> data, int empty_layout) {
        this.layoutId = layoutId;
        this.data = data;
        this.context = context;
        if (empty_layout != -1) {//传-1表示使用默认的空白布局
            this.empty_layout = empty_layout;
        }
    }

    public BaseRecyclerAdapter(Context context, int layoutId, List<T> data, int empty_layout, View head_layout) {
        this.layoutId = layoutId;
        this.data = data;
        this.context = context;
        if (empty_layout != -1) {//传-1表示使用默认的空白布局
            this.empty_layout = empty_layout;
        }
        this.head_layout = head_layout;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ENMPTY_LAYOUT) {
            View v = LayoutInflater.from(context).inflate(empty_layout, parent, false);
            BaseViewHolder holder = new BaseViewHolder(v, context);
            return holder;
        }
        if (viewType == FOOTER_LAYOUT) {
            View v = LayoutInflater.from(context).inflate(R.layout.item_footer, parent, false);
            footerHolder = new FooterHolder(v);
            return footerHolder;
        }
        if (viewType == HEAD_LAYOUT) {
            View v = LayoutInflater.from(context).inflate(R.layout.item_header, parent, false);
//            headHolder = new HeadHolder(head_layout);
            headHolder = new HeadHolder(v);

            return headHolder;
        }

        View v = LayoutInflater.from(context).inflate(layoutId, parent, false);
        final BaseViewHolder holder = new BaseViewHolder(v, context);
        //单击事件回调
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickFlag && onItemClickListner != null) {
                    onItemClickListner.onItemClickListner(v, head_layout==null?holder.getLayoutPosition():holder.getLayoutPosition()-1);
                }
                clickFlag = true;
            }
        });
        //单击长按事件回调
        v.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (onItemLongClickListner != null) {
                    onItemLongClickListner.onItemLongClickListner(v, head_layout==null?holder.getLayoutPosition():holder.getLayoutPosition()-1);
                    clickFlag = false;
                }
                return false;
            }
        });
        return holder;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (data.size() == 0) {
            return;
        }

        if(head_layout==null){
            if (position == data.size()) {
                return;
            }
            if (holder instanceof BaseViewHolder) {
                ((BaseViewHolder) holder).setmPosition(position);
                convert(((BaseViewHolder) holder), data.get(position), position);
            }
        }else{
            if (position == data.size()+1) {
                return;
            }
            if(position==0){
                return;
            }
            if (holder instanceof BaseViewHolder) {
                ((BaseViewHolder) holder).setmPosition(position-1);
                convert(((BaseViewHolder) holder), data.get(position-1), position);
            }
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (data.size() == 0) {
            return ENMPTY_LAYOUT;
        }
        if(head_layout==null){
            if (position == data.size()) {
                return FOOTER_LAYOUT;
            }
        }else{
            if (position == data.size()+1) {
                return FOOTER_LAYOUT;
            }
            if (position == 0) {
                return HEAD_LAYOUT;
            }
        }
        return NORMAL_LAYOUT;

    }

    protected abstract void convert(BaseViewHolder holder, T bean ,int position);

    @Override
    public int getItemCount() {
        if(data==null||data.size()==0){
            return 1;
        }
        if (head_layout==null) {
            return data.size() + 1;
        } else {
            return data.size() + 2;
        }
    }

    public void setOnItemClickListner(OnItemClickListner onItemClickListner) {
        this.onItemClickListner = onItemClickListner;
    }

    public void setOnItemLongClickListner(OnItemLongClickListner onItemLongClickListner) {
        this.onItemLongClickListner = onItemLongClickListner;
    }

    public interface OnItemClickListner {
        void onItemClickListner(View v, int position);
    }

    public interface OnItemLongClickListner {
        void onItemLongClickListner(View v, int position);
    }


}
