package com.ccsoft.yunqudao.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.model.PersonCenterModel;
import com.ccsoft.yunqudao.ui.me.GongSiRenZhengActivity;
import com.ccsoft.yunqudao.ui.me.GongZuoJingLiActivity;
import com.ccsoft.yunqudao.ui.me.WoDeGuanZhuActivity;
import com.ccsoft.yunqudao.ui.me.WoDeYongJinActivity;
import com.ccsoft.yunqudao.ui.me.WoDeZiLiaoActivity;
import com.ccsoft.yunqudao.ui.me.YiJianFanKuiActivity;
import com.ccsoft.yunqudao.ui.me.PactActivity;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import okhttp3.Call;
import okhttp3.Response;

/**
 * @author: Pein
 * @data: 2018/5/2 0002
 */

public class MeFragment extends Fragment implements View.OnClickListener {

    /**
     * 我的页面id
     */
    private View         mView;
    private ImageView    mMe_icon_icon;
    private TextView     mMe_text_yunsuan_id;
    private LinearLayout mMe_item_linearlayout_personal;
    private LinearLayout mMe_item_linearlayout_company;
    private LinearLayout mMe_Item_linearlayout_work_list;
    private LinearLayout mMe_Item_linearlayout_brokerage;
    private LinearLayout mMe_Item_linearlayout_attention;
    private LinearLayout mMe_Item_linearlayout_opinion;
    private LinearLayout mMe_Item_linearlayout_about_yunsuan;
    private TextView     mMe_item_text_authentication;
    private TextView     mMe_item_text_versions;
    private PersonCenterModel.Data data;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        /**
         * 填充布局
         */
        mView = inflater.inflate(R.layout.fragment_me, container, false);
        initView();
        initListener();
        loadData();

        return mView;
    }

    private void initView() {
        /**
         * 初始化id
         */
        this.mMe_item_linearlayout_personal = mView.findViewById(R.id.me_item_linearlayout_personal);
        this.mMe_item_linearlayout_company = mView.findViewById(R.id.me_item_linearlayout_company);
        this.mMe_Item_linearlayout_work_list = mView.findViewById(R.id.me_item_linearlayout_work_list);
        this.mMe_Item_linearlayout_brokerage = mView.findViewById(R.id.me_item_linearlayout_brokerage);
        this.mMe_Item_linearlayout_attention = mView.findViewById(R.id.me_item_linearlayout_attention);
        this.mMe_Item_linearlayout_opinion = mView.findViewById(R.id.me_item_linearlayout_opinion);
        this.mMe_Item_linearlayout_about_yunsuan = mView.findViewById(R.id.me_item_linearlayout_about_yunsuan);
        this.mMe_icon_icon = mView.findViewById(R.id.me_icon_icon);
        this.mMe_text_yunsuan_id = mView.findViewById(R.id.me_text_yunsuan_id);
        this.mMe_item_text_authentication = mView.findViewById(R.id.me_item_text_authentication);
        this.mMe_item_text_versions = mView.findViewById(R.id.me_item_text_versions);
    }

    /**
     * 初始化监听器
     */
    private void initListener() {

        this.mMe_item_linearlayout_personal.setOnClickListener(this);
        this.mMe_item_linearlayout_company.setOnClickListener(this);
        this.mMe_Item_linearlayout_work_list.setOnClickListener(this);
        this.mMe_Item_linearlayout_brokerage.setOnClickListener(this);
        this.mMe_Item_linearlayout_attention.setOnClickListener(this);
        this.mMe_Item_linearlayout_opinion.setOnClickListener(this);
        this.mMe_Item_linearlayout_about_yunsuan.setOnClickListener(this);
        this.mMe_icon_icon.setOnClickListener(this);
        this.mMe_text_yunsuan_id.setOnClickListener(this);
        this.mMe_item_text_authentication.setOnClickListener(this);
        this.mMe_item_text_versions.setOnClickListener(this);
    }

    /**
     * 点击事件
     */
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.me_item_linearlayout_personal:
                startActivity(new Intent(getActivity(),WoDeZiLiaoActivity.class)
                .putExtra("data",data));

                break;
            case R.id.me_item_linearlayout_company:
                GongSiRenZhengActivity.start(getActivity());
                break;
            case R.id.me_item_linearlayout_work_list:
                GongZuoJingLiActivity.start(getActivity());
                break;
            case R.id.me_item_linearlayout_brokerage:
                WoDeYongJinActivity.start(getActivity());
                break;
            case R.id.me_item_linearlayout_attention:
                WoDeGuanZhuActivity.start(getActivity());
                break;
            case R.id.me_item_linearlayout_opinion:
                YiJianFanKuiActivity.start(getActivity());
                break;
            case R.id.me_item_linearlayout_about_yunsuan:
                PactActivity.start(getActivity());
                break;
            case R.id.me_icon_icon:
                Toast.makeText(getActivity(), "你点击了头像", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void loadData(){
        OkHttpUtils.post(HttpAdress.getBaseInfo)
                .tag(this)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        PersonCenterModel model = JsonUtil.jsonToEntity(s,PersonCenterModel.class);
                        data = model.getData();
                        if(model.getCode()==200){
                            mMe_text_yunsuan_id.setText(model.getData().getAccount());
                        }
                    }
                });
    }

}
