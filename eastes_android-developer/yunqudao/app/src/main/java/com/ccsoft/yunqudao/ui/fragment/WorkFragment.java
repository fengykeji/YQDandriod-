package com.ccsoft.yunqudao.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.WorkBean;
import com.ccsoft.yunqudao.bean.duijierentongjibean;
import com.ccsoft.yunqudao.data.AppConstants;
import com.ccsoft.yunqudao.data.api.ApiSubscriber;
import com.ccsoft.yunqudao.data.model.viewmodel.WorkModel;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.manager.ClientManager;
import com.ccsoft.yunqudao.rx.RxSchedulers;
import com.ccsoft.yunqudao.ui.mian.LoginActivity;
import com.ccsoft.yunqudao.ui.work.WorkChengJiaoKeHuActivity;
import com.ccsoft.yunqudao.ui.work.WorkReportActivity;
import com.ccsoft.yunqudao.ui.work.WorkRecommendActivity;
import com.ccsoft.yunqudao.ui.work.duijierentuijian.WorkDuiJieRecommendActivity;
import com.ccsoft.yunqudao.ui.work.secondhandhouse.WorkSecondCompactDaiGouActivity;
import com.ccsoft.yunqudao.ui.work.secondhandhouse.WorkSecondProspectActivity;
import com.ccsoft.yunqudao.ui.work.secondhandhouse.WorkSecondBaoBeiActivity;
import com.ccsoft.yunqudao.ui.work.secondhandhouse.WorkSecondProspectMaintainActivity;
import com.ccsoft.yunqudao.utils.BaseCallBack;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.ccsoft.yunqudao.utils.LogUtil;
import com.ccsoft.yunqudao.utils.OkHttpManager;
import com.ccsoft.yunqudao.utils.SpUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.net.MalformedURLException;

import okhttp3.Call;
import okhttp3.Response;

/**
 * @author: Pein
 * @data: 2018/5/2 0002
 */

public class WorkFragment extends Fragment implements View.OnClickListener{

    private RelativeLayout  mWork_list_item1;
    private RelativeLayout  mWork_list_item2,mWork_list_item3,work_list_second_item1,work_list_second_item2,work_list_second_item3,
    work_list_second_item4,work_list_second_item5,work_list_renting_item1,work_list_renting_item2,work_list_renting_item3,work_list_renting_item4,work_list_renting_item5;
    private TextView    mWork_list_total_recommend;
    private TextView    mWork_list_value_recommend;
    private TextView    mWork_list_disabled_recommend;
    private TextView    mWork_list_count_preparation;
    private TextView    mWork_list_value_preparation;
    private TextView    mWork_list_disabled_preparation;
    private TextView    mWork_list_count_deal,mWork_list_value_deal,mWork_list_disabled_deal
            ,work_list_total_recommend11,work_list_value_recommend11,work_list_disabled_recommend11;
    private WorkModel  mWorkModel;


    private View           mView;
    private int            i;
    private boolean isGetData = false;
    private WorkBean workBean;

    private RelativeLayout work_list_item11;
    private LinearLayout ll_jinjirentuijian;


    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        if (enter && !isGetData) {
            isGetData = true;
           initData();
        } else {
            isGetData = false;
        }
        return super.onCreateAnimation(transit, enter, nextAnim);
    }

    @Override
    public void onPause() {
        super.onPause();
        isGetData = false;
    }




    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        /**
         * 填充布局
         */
        mView = inflater.inflate(R.layout.fragment_work, container, false);
        this.initView();
        initListener();
        initData();
        return mView;
    }

    /**
     * 初始化id
     */
    private void initView() {
        mWork_list_item1 = mView.findViewById(R.id.work_list_item1);
        mWork_list_item2 = mView.findViewById(R.id.work_list_item2);
        mWork_list_item3 = mView.findViewById(R.id.work_list_item3);
        work_list_second_item1 = mView.findViewById(R.id.work_list_second_item1);
        work_list_second_item2 = mView.findViewById(R.id.work_list_second_item2);
        work_list_second_item3 = mView.findViewById(R.id.work_list_second_item3);
        work_list_second_item4 = mView.findViewById(R.id.work_list_second_item4);
        work_list_second_item5 = mView.findViewById(R.id.work_list_second_item5);
        work_list_renting_item1 = mView.findViewById(R.id.work_list_renting_item1);
        work_list_renting_item2 = mView.findViewById(R.id.work_list_renting_item2);
        work_list_renting_item3 = mView.findViewById(R.id.work_list_renting_item3);
        work_list_renting_item4 = mView.findViewById(R.id.work_list_renting_item4);
        work_list_renting_item5 = mView.findViewById(R.id.work_list_renting_item5);
        mWork_list_total_recommend = mView.findViewById(R.id.work_list_total_recommend);
        mWork_list_value_recommend = mView.findViewById(R.id.work_list_value_recommend);
        mWork_list_disabled_recommend = mView.findViewById(R.id.work_list_disabled_recommend);
        mWork_list_count_preparation = mView.findViewById(R.id.work_list_count_preparation);
        mWork_list_value_preparation = mView.findViewById(R.id.work_list_value_preparation);
        mWork_list_disabled_preparation = mView.findViewById(R.id.work_list_disabled_preparation);
        mWork_list_count_deal = mView.findViewById(R.id.work_list_count_deal);
        mWork_list_value_deal = mView.findViewById(R.id.work_list_value_deal);
        mWork_list_disabled_deal = mView.findViewById(R.id.work_list_disabled_deal);


        //对接人：
        work_list_item11 = mView.findViewById(R.id.work_list_item11);
        ll_jinjirentuijian = mView.findViewById(R.id.ll_jinjirentuijian);
        work_list_disabled_recommend11 = mView.findViewById(R.id.work_list_disabled_recommend11);
        work_list_value_recommend11 = mView.findViewById(R.id.work_list_value_recommend11);
        work_list_total_recommend11 = mView.findViewById(R.id.work_list_total_recommend11);


        if(SpUtil.getString("agent_identity","").equals(1+"")){
            work_list_item11.setVisibility(View.GONE);
        }else if(SpUtil.getString("agent_identity","").equals(2+"")){
            ll_jinjirentuijian.setVisibility(View.GONE);
        }
    }


    private void initListener() {

        this.mWork_list_item1.setOnClickListener(this);
        this.mWork_list_item2.setOnClickListener(this);
        this.mWork_list_item3.setOnClickListener(this);
        this.work_list_second_item1.setOnClickListener(this);
        this.work_list_second_item2.setOnClickListener(this);
        this.work_list_second_item3.setOnClickListener(this);
        this.work_list_second_item4.setOnClickListener(this);
        this.work_list_second_item5.setOnClickListener(this);
        this.work_list_renting_item1.setOnClickListener(this);
        this.work_list_renting_item2.setOnClickListener(this);
        this.work_list_renting_item3.setOnClickListener(this);
        this.work_list_renting_item4.setOnClickListener(this);
        this.work_list_renting_item5.setOnClickListener(this);
        this.work_list_item11.setOnClickListener(this);
    }


    private void initData() {
        ClientManager.getInstance().getWorkInfo().compose(RxSchedulers.<WorkModel>io_main()).subscribe(new ApiSubscriber<WorkModel>(getActivity()) {
            @Override
            protected void _onNext(WorkModel workModel) {
                Log.i("hcc------->", "--------------" + workModel.toString());
                mWorkModel  =  workModel;
            }

            @Override
            protected void _onError(String message) {
                LogUtil.e(message);
            }

            @Override
            protected void _onCompleted() {

            }
        });

        OkHttpUtils.get(AppConstants.URL+"agent/work/butter/count")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        duijierentongjibean bean = JsonUtil.jsonToEntity(s,duijierentongjibean.class);
                        if (bean.getCode() == 200){
                            work_list_total_recommend11.setText("累计推荐" + bean.getData().getRecommend_count() + ",");
                            work_list_value_recommend11.setText("有效" + bean.getData().getValue() + ",");
                            work_list_disabled_recommend11.setText("无效" + bean.getData().getValueDisabled());
                        }
                    }
                });

        OkHttpManager.getInstance().get(HttpAdress.COUNT, new BaseCallBack() {
            @Override
            public void onSuccess(Call call, Response response, Object obj) throws MalformedURLException {
                Type type = new TypeToken<WorkBean>() {}.getType();
                workBean = new Gson().fromJson(obj.toString(),type);

                 if(workBean.getCode() == 401){
                    Intent intent = new Intent(getContext(), LoginActivity.class);
                    startActivity(intent);
                }else if(workBean.getCode() == 200) {
                     mWork_list_total_recommend.setText("累计推荐" + workBean.getData().getRecommend().getTotal() + ",");
                     mWork_list_value_recommend.setText("有效" + workBean.getData().getRecommend().getValue() + ",");
                     mWork_list_disabled_recommend.setText("无效" + workBean.getData().getRecommend().getDisabled());
                     mWork_list_count_preparation.setText("累计报备" + workBean.getData().getPreparation().getTotal() + ",");
                     mWork_list_value_preparation.setText("有效" + workBean.getData().getPreparation().getValue() + ",");
                     mWork_list_disabled_preparation.setText("无效" + workBean.getData().getPreparation().getDisabled());
                     mWork_list_count_deal.setText("累计笔数" + workBean.getData().getDeal().getTotal() + ",");
                     mWork_list_value_deal.setText("有效" + workBean.getData().getDeal().getValue() + ",");
                     mWork_list_disabled_deal.setText("无效" + workBean.getData().getDeal().getDisabled());
                 }
            }

            @Override
            public void onFailure(Call call, Exception e) {

            }

            @Override
            public void onError(Response response, int errorCode) {

            }

            @Override
            public void onRequestBefore() {

            }
        });

        OkHttpUtils.get(HttpAdress.flushDate)
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

                        }
                    }
                });


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.work_list_item11:
                Intent intent11 = new Intent(getContext(), WorkDuiJieRecommendActivity.class);
                startActivity(intent11);
                break;
            case R.id.work_list_item1:
                WorkRecommendActivity.start(getActivity());
                break;
            case R.id.work_list_item2:
                WorkReportActivity.start(getActivity());
                break;
            case R.id.work_list_item3:
                Intent intent = new Intent(getContext(), WorkChengJiaoKeHuActivity.class);
                startActivity(intent);
                break;
            case R.id.work_list_second_item1:
                Intent intent1 = new Intent(getContext(), WorkSecondBaoBeiActivity.class);
                startActivity(intent1);
                break;
            case R.id.work_list_second_item2:
                Intent intent2 = new Intent(getContext(), WorkSecondProspectActivity.class);
                startActivity(intent2);
                break;
            case R.id.work_list_second_item3:
                Intent intent3 = new Intent(getContext(), WorkSecondProspectMaintainActivity.class);
                startActivity(intent3);
                break;
            case R.id.work_list_second_item4:
                Intent intent4 = new Intent(getContext(), WorkSecondCompactDaiGouActivity.class);
                startActivity(intent4);
                break;
            case R.id.work_list_second_item5:
                break;
            case R.id.work_list_renting_item1:
                break;
            case R.id.work_list_renting_item2:
                break;
            case R.id.work_list_renting_item3:
                break;
            case R.id.work_list_renting_item4:
                break;
            case R.id.work_list_renting_item5:
                break;
        }
    }


}
