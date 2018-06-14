package com.ccsoft.yunqudao.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.ui.message.SystemMessageActivity;
import com.ccsoft.yunqudao.ui.message.WorkMessageActivity;

/**
 * @author: Pein
 * @data: 2018/4/16 0016
 */

public class MessageFragment extends Fragment implements View.OnClickListener {

    private View         mView;
    private LinearLayout mMssage_item_linearlayout_系统消息;
    private TextView     mMessage_text_未读系统消息条数;
    private RecyclerView mMessage_recyclerview_系统消息列表;
    private LinearLayout mMessage_item_linearlayout_工作消息;
    private TextView     mMessage_text_未读工作消息条数;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //填充布局
        mView = inflater.inflate(R.layout.fragment_message, container, false);
        initView();
        initListener();
        return mView;
    }

    private void initView() {

        /**
         * 初始化id
         */

        this.mMssage_item_linearlayout_系统消息 = mView.findViewById(R.id.message_item_linearlayout_系统消息);
        this.mMessage_text_未读系统消息条数 = mView.findViewById(R.id.message_text_未读系统消息条数);
        this.mMessage_recyclerview_系统消息列表 = mView.findViewById(R.id.message_recyclerview_系统消息列表);
        this.mMessage_item_linearlayout_工作消息 = mView.findViewById(R.id.message_item_linearlayout_工作消息);
        this.mMessage_text_未读工作消息条数 = mView.findViewById(R.id.message_text_未读工作消息条数);
    }

    private void initListener() {
        /**
         * 初始化监听器
         */
        this.mMssage_item_linearlayout_系统消息.setOnClickListener(this);
        this.mMessage_item_linearlayout_工作消息.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.message_item_linearlayout_系统消息:
                SystemMessageActivity.start(getActivity());
                break;
            case R.id.message_item_linearlayout_工作消息:
                WorkMessageActivity.start(getActivity());
                break;
        }
    }
}
