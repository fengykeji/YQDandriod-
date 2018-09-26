package com.ccsoft.yunqudao.ui.house;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.GetHouseTypeDetailBean;
import com.ccsoft.yunqudao.data.AppConstants;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.model.response.ResultData;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.http.MyStringCallBack;
import com.ccsoft.yunqudao.http.XutilsHttp;
import com.ccsoft.yunqudao.ui.adapter.RecommendPopupwindowAdapter;
import com.ccsoft.yunqudao.ui.customers.AddCustomers2Activity;
import com.ccsoft.yunqudao.ui.work.AddWorkActivity;
import com.ccsoft.yunqudao.ui.work.WorkRecommendActivity;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.google.gson.Gson;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Response;

public class AdvicerChooseActivity extends Activity {

    private TextView tv_name;
    private TextView tv_tel;
    private Button button_next;
    private List<GetHouseTypeDetailBean.DataBean.RowsBean> datalist = new ArrayList<>();
    private GetHouseTypeDetailBean.DataBean.RowsBean bean;
    private PopupWindow popupWindow;
    private RecyclerView recyclerView;
    private LinearLayout ll_nochoose;
    private ImageView im_back;
    private int aa = 0;
    private int project_id;
    private int client_id;
    private int need_id;
    private int card_type = 17,aaaa = 0;
    private String  name,sex,tel,card_id,birth,address,floor_min,floor_max,intent3,urgency,comment,need_tags;
    private int  property_type,price ,area,house_type,decorate,buy_purpose,pay_type;
    private String ID;
    private int tel_complete_state;
    private String name1,tel1,project_name;
    private int advicer_selected;


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        WindowManager m = getWindowManager();
        Display d = m.getDefaultDisplay();//为获取屏幕宽、高
        WindowManager.LayoutParams p = getWindow().getAttributes();//获取对话框当前的参数值
        p.height = (int) (d.getHeight() * 0.7);//高度设置为屏幕的1.0
        p.width = (int) (d.getWidth() * 0.7); //宽度设置为屏幕的1.0
//        p.alpha = 1.0f;//设置本身透明度
        p.dimAmount = 0.8f; //设置黑暗度
        getWindow().setAttributes(p);//设置生效
        setContentView(R.layout.recommendpopupwindow);
        initView();

    }

    private void initView(){
        tv_name = findViewById(R.id.tv_name);
        tv_tel = findViewById(R.id.tv_tel);
        button_next = findViewById(R.id.button_next);
        RecyclerView recyclerView =  findViewById(R.id.select);
        ll_nochoose = findViewById(R.id.ll_nochoose);
        im_back = findViewById(R.id.im_back);
        Bundle bundle = getIntent().getExtras();
        datalist = (List<GetHouseTypeDetailBean.DataBean.RowsBean>) bundle.getSerializable("list");
        project_id = getIntent().getIntExtra("project_id",0);
        need_id = getIntent().getIntExtra("client_need_id",0);
        client_id = getIntent().getIntExtra("client_id",0);
        advicer_selected = getIntent().getIntExtra("advicer_selected",10);
        tel_complete_state = getIntent().getIntExtra("tel_complete_state",10);
        name1 = getIntent().getStringExtra("name");
        tel1 = getIntent().getStringExtra("tel");
        project_name = getIntent().getStringExtra("project_name");


        name = getIntent().getStringExtra("name");
        tel = getIntent().getStringExtra("tel");
        sex = getIntent().getStringExtra("sex");
        card_id = getIntent().getStringExtra("card_id");
        birth = getIntent().getStringExtra("barthday");
        address  = getIntent().getStringExtra("address");
        property_type = getIntent().getIntExtra("property_type",0);
        price = getIntent().getIntExtra("price",0);
        area = getIntent().getIntExtra("area",0);
        house_type = getIntent().getIntExtra("house_type",0);
        floor_min = getIntent().getStringExtra("floor_min");
        floor_max = getIntent().getStringExtra("floor_max");
        decorate = getIntent().getIntExtra("decorate",0);
        buy_purpose = getIntent().getIntExtra("buy_purpose",0);
        pay_type = getIntent().getIntExtra("pay_type",0);
        intent3 = getIntent().getStringExtra("intent");
        urgency = getIntent().getStringExtra("urgency");
        need_tags = getIntent().getStringExtra("need_tags");
        comment = getIntent().getStringExtra("comment");
        aaaa = getIntent().getIntExtra("aaaa",0);


        Log.e("cccccc",advicer_selected+"sw");
        if(advicer_selected == 1){
            tv_name.setText("");
            ll_nochoose.setVisibility(View.GONE);
        }




        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(AdvicerChooseActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        RecommendPopupwindowAdapter adapter = new RecommendPopupwindowAdapter(AdvicerChooseActivity.this,R.layout.item_woye_activity,datalist);
        recyclerView.setAdapter(adapter);
        tv_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(aa%2==0){
                    ll_nochoose.setVisibility(View.VISIBLE);
                    recyclerView.setVisibility(View.VISIBLE);
                }else {
                    ll_nochoose.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.GONE);
                }
                if(advicer_selected == 1){
                    tv_name.setText("");
                    ll_nochoose.setVisibility(View.GONE);
                }
                aa++;
            }
        });

        adapter.setOnItemClickListner(new BaseRecyclerAdapter.OnItemClickListner() {
            @Override
            public void onItemClickListner(View v, int position) {
                tv_name.setText(datalist.get(position).getGSMC()+"/"+datalist.get(position).getRYXM()
                +"/"+datalist.get(position).getRYDH());
                tv_tel.setText(datalist.get(position).getRYDH());
                ID = datalist.get(position).getID();
                recyclerView.setVisibility(View.GONE);
                ll_nochoose.setVisibility(View.GONE);
                bean = datalist.get(position);
            }
        });

        ll_nochoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_name.setText("不选择");
                tv_tel.setText("");
                recyclerView.setVisibility(View.GONE);
                ll_nochoose.setVisibility(View.GONE);
            }
        });

        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("ssss",tv_name.getText().toString()+"sss");
                if(advicer_selected==1&&tv_name.getText().toString().equals("")){
                    Toast.makeText(AdvicerChooseActivity.this,"请选择置业顾问",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(aaaa == 1){
                    if(tv_name.getText().toString().equals("不选择") && need_id == 0){
//                        getRecommend2();
                        getRecommendInfo();
                    }
                    if(!tv_name.getText().toString().equals("不选择") && need_id == 0){
//                        getRecommend2(ID);
                        getRecommendInfo();
                    }
                }else {
                    if (tv_name.getText().toString().equals("不选择") && need_id != 0) {
//                        getRecommend(project_id, need_id, client_id);
                        getRecommendInfo();
                    }
                    if (!tv_name.getText().toString().equals("不选择") && need_id != 0) {
//                        getRecommend1(project_id, need_id, client_id, ID);
                        getRecommendInfo();
                    }
                    if (!tv_name.getText().toString().equals("不选择") && need_id == 0) {
//                        getRecommend(ID);
                        getRecommendInfo();
                    }
                    if (tv_name.getText().toString().equals("不选择") && need_id == 0) {
//                        getRecommend();
                        getRecommendInfo();
                    }
                }

            }
        });

        im_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button textview =  LayoutInflater.from(AdvicerChooseActivity.this).inflate(R.layout.activity_customers_add_customers2, null).findViewById(R.id.customers_button_commit);
                textview.setEnabled(true);
                finish();
            }
        });
    }

    /**
     * 推荐信息
     */
    private void getRecommendInfo(){
        Bundle bundle = new Bundle();
        bundle.putSerializable("list",  bean);
        Intent intent = new Intent(this,RecommendInfoActivity.class);

        intent.putExtra("project_id",project_id);
        intent.putExtra("client_need_id",need_id);
        intent.putExtra("client_id",client_id);
        intent.putExtra("ID",ID);
        intent.putExtra("aaaa",aaaa);
        intent.putExtra("tv_name",tv_name.getText().toString());

        intent.putExtra("tel_complete_state",tel_complete_state);
        intent.putExtra("project_name",project_name);
        intent.putExtra("name",name1);
        intent.putExtra("tel",tel1);


        intent.putExtra("project_id",project_id);

        intent.putExtra("name",name);
        intent.putExtra("sex",sex);
        intent.putExtra("tel",tel);
        intent.putExtra("barthday",birth);
        intent.putExtra("card_type",card_type);
        intent.putExtra("card_id",card_id);
        intent.putExtra("address",address);
        intent.putExtra("property_type",property_type);
        intent.putExtra("price",price);
        intent.putExtra("area",area);
        intent.putExtra("house_type",house_type);
        intent.putExtra("floor_min",floor_min);
        intent.putExtra("floor_max",floor_max);
        intent.putExtra("decorate",decorate);
        intent.putExtra("buy_purpose",buy_purpose);
        intent.putExtra("pay_type",pay_type);
        intent.putExtra("intent",intent3);
        intent.putExtra("urgency",urgency);
        intent.putExtra("need_tags",need_tags);
        intent.putExtra("comment",comment);
        intent.putExtras(bundle);
        startActivity(intent);

    }

    /**
     * 推荐
     * @param project_id
     * @param id
     * @param mClienId
     */
    private void getRecommend(int project_id,int id,int mClienId ){
        Map<String, String> map = new HashMap<>();
        map.put("project_id", String.valueOf(project_id));
        map.put("client_need_id", String.valueOf(id));
        map.put("client_id", String.valueOf(mClienId));
        XutilsHttp.getInstance().postheader(AppConstants.URL + "agent/client/recommend", map, new XutilsHttp.XCallBack() {
            @Override
            public void onResponse(String result) {
                Gson gson = new Gson();
                ResultData resultData = gson.fromJson(result, ResultData.class);
                if (resultData.code == 200) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(AdvicerChooseActivity.this);
                    builder.setTitle("恭喜你推荐成功");
                    builder.setMessage(resultData.msg);
                    builder.setNegativeButton("知道了" , new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();


                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(AdvicerChooseActivity.this);
                    builder.setTitle("推荐失败");
                    builder.setMessage(resultData.msg);
                    builder.setNegativeButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }

            @Override
            public void error(String message) {
                Log.d("666666------》", message);
            }
        });
    }


    /**
     * 带置业顾问推荐
     * @param project_id
     * @param id
     * @param mClienId
     */
    private void getRecommend1(int project_id,int id,int mClienId,String ID ){
        Map<String, String> map = new HashMap<>();
        map.put("project_id", String.valueOf(project_id));
        map.put("client_need_id", String.valueOf(id));
        map.put("client_id", String.valueOf(mClienId));
        map.put("consultant_advicer_id",ID);

        XutilsHttp.getInstance().postheader(AppConstants.URL + "agent/client/recommend", map, new XutilsHttp.XCallBack() {
            @Override
            public void onResponse(String result) {
                Gson gson = new Gson();
                ResultData resultData = gson.fromJson(result, ResultData.class);
                if (resultData.code == 200) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(AdvicerChooseActivity.this);
                    builder.setTitle("推荐成功");
                    builder.setMessage(resultData.msg);
                    builder.setNegativeButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();


                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(AdvicerChooseActivity.this);
                    builder.setTitle("推荐失败");
                    builder.setMessage(resultData.msg);
                    builder.setNegativeButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }

            @Override
            public void error(String message) {
                Log.d("666666------》", message);
            }
        });
    }

    /**
     * 添加并带推荐
     */
    private void getRecommend(String ID){
        OkHttpUtils.post(HttpAdress.addAndRecommend)
                .tag(this)
                .params("project_id",project_id)
                .params("name", name)
                .params("sex", sex)
                .params("tel", tel)
                .params("birth", birth)
                .params("card_type",card_type)
                .params("card_id", card_id)
                .params("address", address)
                .params("property_type", property_type)
                .params("total_price", price)
                .params("area", area)
                .params("house_type", house_type)
                .params("floor_min", floor_min)
                .params("floor_max", floor_max)
                .params("decorate", decorate)
                .params("buy_purpose", buy_purpose)
                .params("pay_type", pay_type)
                .params("intent", intent3)
                .params("urgency", urgency)
                .params("need_tags", need_tags)
                .params("comment", comment)
                .params("consultant_advicer_id",ID)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        ResultData resultData = JsonUtil.jsonToEntity(s, ResultData.class);
                        if (resultData.code == 200) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(AdvicerChooseActivity.this);
                            builder.setTitle("推荐成功");
                            builder.setMessage(resultData.msg);
                            builder.setNegativeButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    finish();
                                }
                            });
                            AlertDialog dialog = builder.create();
                            dialog.show();


                        } else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(AdvicerChooseActivity.this);
                            builder.setTitle("推荐失败");
                            builder.setMessage(resultData.msg);
                            builder.setNegativeButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            });
                            AlertDialog dialog = builder.create();
                            dialog.show();
                        }

                    }
                });
    }

    /**
     * 添加并带推荐
     */
    private void getRecommend(){

        OkHttpUtils.post(HttpAdress.addAndRecommend)
                .tag(this)
                .params("project_id",project_id)
                .params("name", name)
                .params("sex", sex)
                .params("tel", tel)
                .params("birth", birth)
                .params("card_type",card_type)
                .params("card_id", card_id)
                .params("address", address)
                .params("property_type", property_type)
                .params("total_price", price)
                .params("area", area)
                .params("house_type", house_type)
                .params("floor_min", floor_min)
                .params("floor_max", floor_max)
                .params("decorate", decorate)
                .params("buy_purpose", buy_purpose)
                .params("pay_type", pay_type)
                .params("intent", intent3)
                .params("urgency", urgency)
                .params("need_tags", need_tags)
                .params("comment", comment)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        ResultData resultData = JsonUtil.jsonToEntity(s, ResultData.class);
                        if (resultData.code == 200) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(AdvicerChooseActivity.this);
                            builder.setTitle("推荐成功");
                            builder.setMessage(resultData.msg);
                            builder.setNegativeButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    finish();
                                }
                            });
                            AlertDialog dialog = builder.create();
                            dialog.show();


                        } else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(AdvicerChooseActivity.this);
                            builder.setTitle("推荐失败");
                            builder.setMessage(resultData.msg);
                            builder.setNegativeButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            });
                            AlertDialog dialog = builder.create();
                            dialog.show();
                        }

                    }
                });
    }


    /**
     * 工作推荐
     */
    private void getRecommend2(){
        OkHttpUtils.post(HttpAdress.ADDANDRECOMMEND)
                .tag(this)
                .params("name", name)
                .params("sex", sex)
                .params("tel", tel)
                .params("card_id",card_id)
                .params("birth", birth)
                .params("address",address)
                .params("project_id",project_id)
                .execute(new MyStringCallBack() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        super.onSuccess(s, call, response);
                        Gson gson = new Gson();
                        ResultData model = gson.fromJson(s, ResultData.class);
                        if(model.code==200){
                            AlertDialog.Builder builder = new AlertDialog.Builder(AdvicerChooseActivity.this);
                            builder.setTitle("推荐成功");
                            builder.setMessage(model.msg);
                            builder.setNegativeButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent(AdvicerChooseActivity.this,WorkRecommendActivity.class);
                                    startActivity(intent);
                                }
                            });
                            AlertDialog dialog = builder.create();
                            dialog.show();


                        } else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(AdvicerChooseActivity.this);
                            builder.setTitle("推荐失败");
                            builder.setMessage(model.msg);
                            builder.setNegativeButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            });
                            AlertDialog dialog = builder.create();
                            dialog.show();
                        }

                    }
                });
    }

    /**
     * 工作推荐带置业顾问
     */
    private void getRecommend2(String ID){
        OkHttpUtils.post(HttpAdress.ADDANDRECOMMEND)
                .tag(this)
                .params("name", name)
                .params("sex", sex)
                .params("tel", tel)
                .params("card_id",card_id)
                .params("birth", birth)
                .params("address",address)
                .params("consultant_advicer_id",ID)
                .params("project_id",project_id)
                .params("comment",comment)
                .execute(new MyStringCallBack() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        super.onSuccess(s, call, response);
                        Gson gson = new Gson();
                        ResultData model = gson.fromJson(s, ResultData.class);
                        if(model.code==200){
                            AlertDialog.Builder builder = new AlertDialog.Builder(AdvicerChooseActivity.this);
                            builder.setTitle("推荐成功");
                            builder.setMessage(model.msg);
                            builder.setNegativeButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent(AdvicerChooseActivity.this,WorkRecommendActivity.class);
                                    startActivity(intent);
                                }
                            });
                            AlertDialog dialog = builder.create();
                            dialog.show();


                        } else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(AdvicerChooseActivity.this);
                            builder.setTitle("推荐失败");
                            builder.setMessage(model.msg);
                            builder.setNegativeButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            });
                            AlertDialog dialog = builder.create();
                            dialog.show();
                        }

                    }
                });
    }
}
