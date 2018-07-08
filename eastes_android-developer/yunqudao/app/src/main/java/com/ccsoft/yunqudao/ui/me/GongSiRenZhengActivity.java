package com.ccsoft.yunqudao.ui.me;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.GetCompanyListBean;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.ui.adapter.GongSiRenZhengLiBiaoAdapter;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * @author: Pein
 * @data: 2018/5/3 0003
 */

public class GongSiRenZhengActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton    me_button_返回;
    private RelativeLayout me_button_relativelayout_搜索;
    private Spinner        me_spinner_省份;
    private Spinner        me_spinner_城市;
    private Spinner        me_spinner_区域;
    private RecyclerView   me_recyclerview_公司列表;
    private GongSiRenZhengLiBiaoAdapter adapter;
    private List<GetCompanyListBean.DataBeanX.DataBean> dataList = new ArrayList<>();
    private GetCompanyListBean bean;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_me_xuanzegongsi);
        initView();
        initData();
        initListener();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, GongSiRenZhengActivity.class);
        context.startActivity(intent);
    }

    private void initView() {
        /**
         * 初始化id
         */
        me_button_返回 = findViewById(R.id.me_button_返回);

        me_button_relativelayout_搜索 = findViewById(R.id.me_button_relativelayout_搜索);

        me_spinner_省份 = findViewById(R.id.me_spinner_省份);

        me_spinner_城市 = findViewById(R.id.me_spinner_城市);

        me_spinner_区域 = findViewById(R.id.me_spinner_区域);

        me_recyclerview_公司列表 = findViewById(R.id.me_recyclerview_公司列表);

        me_recyclerview_公司列表.setLayoutManager(new LinearLayoutManager(this));
        adapter = new GongSiRenZhengLiBiaoAdapter(this,R.layout.item_me_renzheng,dataList);
        me_recyclerview_公司列表.setAdapter(adapter);

        adapter.setOnItemClickListner(new BaseRecyclerAdapter.OnItemClickListner() {
            @Override
            public void onItemClickListner(View v, int position) {
                Intent intent = new Intent(GongSiRenZhengActivity.this,GongSiXiangQiangActivity.class);
                intent.putExtra("companyname",bean.getData().getData().get(position).getCompany_name());
                intent.putExtra("address",bean.getData().getData().get(position).getAbsolute_address());
                intent.putExtra("tel",bean.getData().getData().get(position).getContact_tel()+"");
                intent.putExtra("name",bean.getData().getData().get(position).getContact());
                intent.putExtra("comment",bean.getData().getData().get(position).getComment());
                intent.putExtra("imgurl",bean.getData().getData().get(position).getLogo());
                intent.putExtra("companyid",bean.getData().getData().get(position).getCompany_id());
                startActivity(intent);
                finish();
            }
        });
    }

    private void initData(){
        OkHttpUtils.get(HttpAdress.getCompanyList)
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
                        if(code == 200 && data!=null){
                             bean = JsonUtil.jsonToEntity(s,GetCompanyListBean.class);
                            dataList.clear();
                            dataList.addAll(bean.getData().getData());
                            adapter.notifyDataSetChanged();

                        }
                    }
                });
    }

    private void initListener() {
        /**
         * 初始化监听器
         */
        me_button_返回.setOnClickListener(this);
        me_button_relativelayout_搜索.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.me_button_返回:
                finish();
                break;
            case R.id.me_button_relativelayout_搜索:
                Toast.makeText(this, "你点击了搜索", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
