package com.ccsoft.yunqudao.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.data.api.ApiSubscriber;
import com.ccsoft.yunqudao.data.model.viewmodel.WorkModel;
import com.ccsoft.yunqudao.manager.ClientManager;
import com.ccsoft.yunqudao.rx.RxSchedulers;
import com.ccsoft.yunqudao.ui.work.WorkReportActivity;
import com.ccsoft.yunqudao.ui.work.WorkRecommendActivity;
import com.ccsoft.yunqudao.utils.LogUtil;

/**
 * @author: Pein
 * @data: 2018/5/2 0002
 */

public class WorkFragment extends Fragment implements View.OnClickListener{

    private RelativeLayout  mWork_list_item1;
    private RelativeLayout  mWork_list_item2;
    private TextView    mWork_list_total_recommend;
    private TextView    mWork_list_value_recommend;
    private TextView    mWork_list_disabled_recommend;
    private TextView    mWork_list_count_preparation;
    private TextView    mWork_list_value_preparation;
    private TextView    mWork_list_disabled_preparation;
    private WorkModel  mWorkModel;


    private View           mView;
    private int            i;
    private boolean isGetData = false;


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


//    @Override
//    public void onResume() {
//        if (!isGetData) {
//            initData();
//            isGetData = true;
//        }
//        super.onResume();
//    }

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
        mWork_list_total_recommend = mView.findViewById(R.id.work_list_total_recommend);
        mWork_list_value_recommend = mView.findViewById(R.id.work_list_value_recommend);
        mWork_list_disabled_recommend = mView.findViewById(R.id.work_list_disabled_recommend);
        mWork_list_count_preparation = mView.findViewById(R.id.work_list_count_preparation);
        mWork_list_value_preparation = mView.findViewById(R.id.work_list_value_preparation);
        mWork_list_disabled_preparation = mView.findViewById(R.id.work_list_disabled_preparation);
    }


    private void initListener() {

        this.mWork_list_item1.setOnClickListener(this);
        this.mWork_list_item2.setOnClickListener(this);
    }


    private void initData() {
        ClientManager.getInstance().getWorkInfo().compose(RxSchedulers.<WorkModel>io_main()).subscribe(new ApiSubscriber<WorkModel>(getActivity()) {
            @Override
            protected void _onNext(WorkModel workModel) {
                Log.i("hcc------->", "--------------" + workModel.toString());
                mWorkModel  =  workModel;
                mWork_list_total_recommend.setText("累计推荐"+String.valueOf(mWorkModel.recommend.total)+",");
                mWork_list_value_recommend.setText("有效"+String.valueOf(mWorkModel.recommend.value)+",");
                mWork_list_disabled_recommend.setText("无效"+String.valueOf(mWorkModel.recommend.disabled));
                mWork_list_count_preparation.setText("累计报备"+String.valueOf(mWorkModel.preparation.total)+",");
                mWork_list_value_preparation.setText("有效"+String.valueOf(mWorkModel.preparation.value)+",");
                mWork_list_disabled_preparation.setText("无效"+String.valueOf(mWorkModel.preparation.disabled));
            }

            @Override
            protected void _onError(String message) {
                LogUtil.e(message);
            }

            @Override
            protected void _onCompleted() {

            }
        });


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.work_list_item1:
                WorkRecommendActivity.start(getActivity());
                break;
            case R.id.work_list_item2:
                WorkReportActivity.start(getActivity());
                break;
        }
    }
}
