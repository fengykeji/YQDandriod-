package com.ccsoft.yunqudao.data.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Administrator on 2018/4/20.
 */

public class HeadHolder extends RecyclerView.ViewHolder {

    private View itemView;

    public HeadHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
    }
    public View getHeadView(){
        return itemView;
    }

}
