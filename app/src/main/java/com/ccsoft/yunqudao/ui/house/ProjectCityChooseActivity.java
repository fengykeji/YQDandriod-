package com.ccsoft.yunqudao.ui.house;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.CityBean;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.ui.adapter.CityAdapter;
import com.ccsoft.yunqudao.ui.home.HomeActivity;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Call;
import okhttp3.Response;


public class ProjectCityChooseActivity extends AppCompatActivity implements View.OnClickListener {
    private ListView mCityLit;
    private TextView overlay,tv_cityChoose,tv_sure;
    private ImageButton work_button_back;
    private QuicLocationBar mQuicLocationBar;
    private HashMap<String, Integer> alphaIndexer;
    private ArrayList<CityBean.DataBean> mCityNames;
    private CityBean cityModel;
    private String city_name,city_code;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);

        work_button_back = findViewById(R.id.tv_work_button_back);
        tv_sure = findViewById(R.id.tv_sure);


        mQuicLocationBar =  findViewById(R.id.city_loactionbar);
        mQuicLocationBar
                .setOnTouchLitterChangedListener( new LetterListViewListener());
        overlay = findViewById(R.id.city_dialog);
        tv_cityChoose = findViewById(R.id.tv_cityChoose);
        mCityLit =  findViewById(R.id.city_list);
        mQuicLocationBar.setTextDialog(overlay);
        initList();

        work_button_back.setOnClickListener(this);
        tv_sure.setOnClickListener(this);
    }

    private void initList() {

        OkHttpUtils.get(HttpAdress.cityChoose)
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
                        if(code == 200&& data!=null){
                            cityModel = JsonUtil.jsonToEntity(s,CityBean.class);
                            mCityNames = (ArrayList<CityBean.DataBean>) cityModel.getData();
                            CityAdapter adapter = new CityAdapter(ProjectCityChooseActivity.this, mCityNames);
                            mCityLit.setAdapter(adapter);
                            alphaIndexer = adapter.getCityMap();
                            mCityLit.setOnItemClickListener(new CityListOnItemClick());
                        }
                    }
                });


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_sure:
                Intent intent = new Intent(this, HomeActivity.class);
                intent.putExtra("fid",1);
                intent.putExtra("city_name",city_name);
                intent.putExtra("city_code",city_code);
                startActivity(intent);
                break;
            case R.id.tv_work_button_back:
                finish();
                break;
        }
    }

    private class CityListOnItemClick implements OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> arg0, View arg1, int pos,
                                long arg3) {
            CityBean.DataBean cityModel = (CityBean.DataBean) mCityLit.getAdapter()
                    .getItem(pos);
            tv_cityChoose.setText(cityModel.getCity_name());
            city_code = cityModel.getCity_code();
            city_name = cityModel.getCity_name();
        }

    }

    private class LetterListViewListener implements
            QuicLocationBar.OnTouchLetterChangedListener {

        @Override
        public void touchLetterChanged(String s) {
            // TODO Auto-generated method stub
            if (alphaIndexer.get(s) != null) {
                int position = alphaIndexer.get(s);
                mCityLit.setSelection(position);
            }
        }

    }

}
