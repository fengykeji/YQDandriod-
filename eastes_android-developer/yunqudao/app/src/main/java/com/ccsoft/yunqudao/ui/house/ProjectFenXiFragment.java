package com.ccsoft.yunqudao.ui.house;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.HouseAnalyseBean;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.utils.BaseCallBack;
import com.ccsoft.yunqudao.utils.OkHttpManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.net.MalformedURLException;

import okhttp3.Call;
import okhttp3.Response;

/**
 * @author: Pein
 * @data: 2018/5/9 0009
 */

public class ProjectFenXiFragment extends Fragment {

    private View                 mView;
    private ProjectFenXiFragment mProjectFenXiFragment;
    private TextView content_tv6,content_tv7,content_tv8,content_tv9;
    private HouseAnalyseBean houseAnalyseBean;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_house_xiangmuxiangqing_fenxi, container, false);
        mProjectFenXiFragment = new ProjectFenXiFragment();
        this.initView();
        this.initListener();
        loadHouseAnalyse();
        return mView;
    }
    private void initView(){
        content_tv6 = mView.findViewById(R.id.content_tv6);
        content_tv7 = mView.findViewById(R.id.content_tv7);
        content_tv8 = mView.findViewById(R.id.content_tv8);
        content_tv9 = mView.findViewById(R.id.content_tv9);
    }
    private void initListener(){

    }
    private void loadHouseAnalyse(){
        OkHttpManager.getInstance().get(HttpAdress.HOUSTANALYSE + "project_id=" + 3, new BaseCallBack() {
            @Override
            public void onSuccess(Call call, Response response, Object obj) throws MalformedURLException {
                Type type = new TypeToken<HouseAnalyseBean>() {}.getType();
                houseAnalyseBean = new Gson().fromJson(obj.toString(),type);
                Log.e("houseAnalyseBean",houseAnalyseBean.getMsg());

                if(houseAnalyseBean.getMsg()!=null&&houseAnalyseBean.getCode()==200) {
                    content_tv6.setText(houseAnalyseBean.getData().getAdvantage());
                    content_tv7.setText(houseAnalyseBean.getData().getRim());
                    content_tv8.setText(houseAnalyseBean.getData().getFetch());
                    content_tv9.setText(houseAnalyseBean.getData().getIncrease_value());
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
    }
}
