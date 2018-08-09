package com.ccsoft.yunqudao.ui.fragment;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.GetUnreadBean;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.ui.message.SystemMessageActivity;
import com.ccsoft.yunqudao.ui.message.WorkMessageActivity;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.ccsoft.yunqudao.utils.SpUtil;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

import cn.jpush.android.api.JPushInterface;
import okhttp3.Call;
import okhttp3.Response;

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
    CallBackValue callBackValue;
    int total;
    int read;
    int noread;
    int total1;
    int read1;
    int noread1;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        callBackValue = (CallBackValue) activity;

    }

    //把传递进来的activity对象释放掉
    @Override
    public void onDetach() {
        super.onDetach();
        callBackValue = null;
    }

    @Override
    public void onStart() {
        super.onStart();

        initData();
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //填充布局
        mView = inflater.inflate(R.layout.fragment_message, container, false);
        initView();
        initData();
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

    private void initData(){
        OkHttpUtils.get(HttpAdress.getUnread)
                .tag(this)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        int code = 0;
                        String data = null;
                        try {
                            JSONObject jsonObject = new JSONObject(s);
                            code = jsonObject.getInt("code");
                            data = jsonObject.getString("data");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (code == 200 && data != null) {
                            GetUnreadBean bean = JsonUtil.jsonToEntity(s,GetUnreadBean.class);
                             total = bean.getData().getSystem().getTotal();
                             read = bean.getData().getSystem().getRead();
                             noread = total-read;
                             total1 = bean.getData().getWork().getTotal();
                             read1 = bean.getData().getWork().getRead();
                             noread1 = total1-read1;
                            mMessage_text_未读系统消息条数.setText("未读消息"+0+"条");
                            if(noread1<0){
                                mMessage_text_未读工作消息条数.setText("未读消息"+0+"条");
                            }else {
                                mMessage_text_未读工作消息条数.setText("未读消息" + noread1 + "条");
                            }
                            callBackValue.SendMessageValue(noread1+"");
                            SpUtil.setString("noread",noread1+"");


                        }
                    }
                });
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

    //定义一个回调接口
    public interface CallBackValue{
        public void SendMessageValue(String strValue);
    }

}
