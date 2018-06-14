package com.ccsoft.yunqudao.data.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.ccsoft.yunqudao.R;


/**
 * Created by lxk on 2017/9/11.
 */

public class FooterHolder extends RecyclerView.ViewHolder {

    private LinearLayout ll_loding;
    private LinearLayout ll_end;
    private LinearLayout ll_error;

    public static final int KEY_NORMAL = 0x001;
    public static final int KEY_LOADING = 0x002;
    public static final int KEY_NETWORK_ERROR = 0x003;
    public static final int KEY_END = 0x004;

    private int mState = KEY_NORMAL;

    public FooterHolder(View itemView) {
        super(itemView);
        ll_loding = itemView.findViewById(R.id.ll_loding);
        ll_end = itemView.findViewById(R.id.ll_end);
        ll_error = itemView.findViewById(R.id.ll_error);
    }

    public void setData(int status){
        switch (status){
            case KEY_NORMAL:
                mState = KEY_NORMAL;
                setAllGone();
                break;
            case KEY_LOADING:
                setAllGone();
                mState = KEY_LOADING;
                ll_loding.setVisibility(View.VISIBLE);
                break;
            case KEY_NETWORK_ERROR:
                setAllGone();
                mState = KEY_NETWORK_ERROR;
                ll_error.setVisibility(View.VISIBLE);
                break;
            case KEY_END:
                setAllGone();
                mState = KEY_END;
                ll_end.setVisibility(View.VISIBLE);
                break;
        }
    }

    public int getmState(){
        return mState;
    }

    private void setAllGone(){
        if(ll_loding!=null)ll_loding.setVisibility(View.GONE);
        if (ll_end!=null)ll_end.setVisibility(View.GONE);
        if (ll_error!=null)ll_error.setVisibility(View.GONE);
    }


}
