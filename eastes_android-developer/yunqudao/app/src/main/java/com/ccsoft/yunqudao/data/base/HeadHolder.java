package com.ccsoft.yunqudao.data.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.ccsoft.yunqudao.R;

import static com.ccsoft.yunqudao.data.base.FooterHolder.KEY_NORMAL;

/**
 * Created by Administrator on 2018/4/20.
 */

public class HeadHolder extends RecyclerView.ViewHolder {

    private View itemView;
    private LinearLayout ll_refresh;
    private int mState = KEY_NORMAL;

    public static final int KEY_BEGIN = 0x005;



    public HeadHolder(View itemView) {
        super(itemView);
        ll_refresh = itemView.findViewById(R.id.ll_refresh);

    }
    public View getHeadView(){
        return itemView;
    }
    public void setData(int status) {
        switch (status) {
            case KEY_NORMAL:
                mState = KEY_NORMAL;
                setAllGone();
                break;
            case KEY_BEGIN:
                setAllGone();
                mState = KEY_BEGIN;
                ll_refresh.setVisibility(View.VISIBLE);
                break;
        }
    }

    public int getmState(){
        return mState;
    }


    private void setAllGone(){
        if(ll_refresh!=null)ll_refresh.setVisibility(View.GONE);

    }

}
