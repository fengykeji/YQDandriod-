package com.ccsoft.yunqudao.data.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.data.AppConstants;
import com.ccsoft.yunqudao.utils.GlideUtil;




/**
 * Created by lxk on 2016/11/21.
 */
public class BaseViewHolder extends RecyclerView.ViewHolder {
    View convertView;
    Context context;
    int mPosition;

    public int getmPosition() {
        return mPosition;
    }

    public void setmPosition(int mPosition) {
        this.mPosition = mPosition;
    }

    public BaseViewHolder(View itemView, Context context) {
        super(itemView);
        this.convertView = itemView;
        this.context = context;
    }

    public void setText(int id, String text) {
        TextView tx =  convertView.findViewById(id);
        tx.setText(text);
    }

    public void setImageResource(int id, int resouceId) {
        ImageView img= convertView.findViewById(id);
        img.setImageResource(resouceId);
    }

    public void setImageResource(int id, String url) {
        ImageView img= convertView.findViewById(id);
        GlideUtil.loadImage(url, context, img, R.drawable.ic_launcher_background, false);
    }

    public void setVisible(int id,int type){
        View view = convertView.findViewById(id);
        view.setVisibility(type);
    }
    public void setEnable(int id,boolean enabled){
        View view = convertView.findViewById(id);
        view.setEnabled(enabled);
    }

    public void setOnclick(int id, View.OnClickListener onClickListener){
        View view = convertView.findViewById(id);
        view.setOnClickListener(onClickListener);
    }

    public View getView(int id){
        return convertView.findViewById(id);
    }

}
