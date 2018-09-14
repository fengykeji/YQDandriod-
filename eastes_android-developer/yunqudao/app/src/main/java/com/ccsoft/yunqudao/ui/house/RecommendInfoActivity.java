package com.ccsoft.yunqudao.ui.house;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.GetHouseTypeDetailBean;
import com.ccsoft.yunqudao.data.AppConstants;
import com.ccsoft.yunqudao.data.model.response.ResultData;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.http.MyStringCallBack;
import com.ccsoft.yunqudao.http.XutilsHttp;
import com.ccsoft.yunqudao.ui.work.WorkRecommendActivity;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.google.gson.Gson;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Response;

public class RecommendInfoActivity extends AppCompatActivity {

    private TextView tv_close,tv_sure,tv_gongsimingzi,tv_name,tv_telnum;
    private GetHouseTypeDetailBean.DataBean.RowsBean data ;
    private int tel_complete_state;
    private String tel2;
    private String name1,tel1,project_name;
    private int aa = 0;
    private int project_id;
    private int client_id;
    private int need_id;
    private int card_type = 17,aaaa = 0;
    private String  name,sex,tel,card_id,birth,address,floor_min,floor_max,intent,urgency,comment,need_tags;
    private int  property_type,price ,area,house_type,decorate,buy_purpose,pay_type;
    private String ID;
    private String tv_name11;
    private LinearLayout ll_yincang;

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
        setContentView(R.layout.activity_recommendinfo);
        initView();

    }
    private void initView(){
        tv_close = findViewById(R.id.tv_close);
        tv_sure = findViewById(R.id.tv_sure);
        tv_gongsimingzi = findViewById(R.id.tv_gongsimingzi);
        tv_name = findViewById(R.id.tv_name);
        tv_telnum = findViewById(R.id.tv_telnum);
        ll_yincang = findViewById(R.id.ll_yincang);

        project_id = getIntent().getIntExtra("project_id",0);
        need_id = getIntent().getIntExtra("client_need_id",0);
        client_id = getIntent().getIntExtra("client_id",0);
        ID = getIntent().getStringExtra("ID");
        Log.e("ccccc",project_id+" "+need_id+" "+client_id+" "+ID);
        tv_name11 = getIntent().getStringExtra("tv_name");

        tel_complete_state = getIntent().getIntExtra("tel_complete_state",10);
        project_name = getIntent().getStringExtra("project_name");
        name1 = getIntent().getStringExtra("name");
        tel1 = getIntent().getStringExtra("tel");



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
        intent = getIntent().getStringExtra("intent");
        urgency = getIntent().getStringExtra("urgency");
        need_tags = getIntent().getStringExtra("need_tags");
        comment = getIntent().getStringExtra("comment");
        aaaa = getIntent().getIntExtra("aaaa",0);



//        Bundle bundle = getIntent().getExtras();
//        data = (GetHouseTypeDetailBean.DataBean.RowsBean) bundle.getSerializable("list");


//            tel2 = tel1;
            tv_gongsimingzi.setText(project_name);
            tv_name.setText(name1);
            if(tel_complete_state!=0){
                tel2 = tel1.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1XXXX$2");
                Log.e("ssssw",tel2);
                ll_yincang.setVisibility(View.VISIBLE);
            }else {
                ll_yincang.setVisibility(View.GONE);
            }

        tv_telnum.setText(tel2);


        tv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        tv_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("ccccs",aaaa+" "+tv_name11);
                if(aaaa == 1){
                    if(tv_name11.equals("不选择") && need_id == 0){
                        getRecommend2();

                    }
                    if(!tv_name11.equals("不选择") && need_id == 0){
                        getRecommend2(ID);

                    }
                }else {
                    if (tv_name11.equals("不选择") && need_id != 0) {
                        getRecommend(project_id, need_id, client_id);


//
                    }
                    if (!tv_name11.equals("不选择") && need_id != 0) {
                        getRecommend1(project_id, need_id, client_id, ID);

//
                    }
                    if (!tv_name11.equals("不选择") && need_id == 0) {
                        getRecommend(ID);


//
                    }
                    if (tv_name11.equals("不选择") && need_id == 0) {
                        getRecommend();
                    }
                }
            }
        });

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
                Log.e("cccc",resultData.code+" ");
                if (resultData.code == 200) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(RecommendInfoActivity.this);
                    builder.setTitle("恭喜你推荐成功");
                    builder.setMessage("推荐项目："+project_name+"\n"+"\n"+"姓名："+name1+"\n"+
                    "\n"+"联系电话："+tel2);
                    builder.setNegativeButton("知道了" , new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
//                    Intent intent = new Intent(RecommendInfoActivity.this,RecommendInfoActivity.class);
//                    startActivity(intent);


                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(RecommendInfoActivity.this);
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
                Log.e("cccc",message+"ss");
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
                Log.e("cccc",resultData.code+" ");
                if (resultData.code == 200) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(RecommendInfoActivity.this);
                    builder.setTitle("推荐成功");
                    builder.setMessage("推荐项目："+project_name+"\n"+"\n"+"姓名："+name1+"\n"+
                            "\n"+"联系电话："+tel2);
                    builder.setNegativeButton("知道了", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();


                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(RecommendInfoActivity.this);
                    builder.setTitle("推荐失败");
                    builder.setMessage(resultData.msg);
                    builder.setNegativeButton("知道了", new DialogInterface.OnClickListener() {
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
                .params("intent", intent)
                .params("urgency", urgency)
                .params("need_tags", need_tags)
                .params("comment", comment)
                .params("consultant_advicer_id",ID)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        ResultData resultData = JsonUtil.jsonToEntity(s, ResultData.class);
                        Log.e("cccc",resultData.code+" ");
                        if (resultData.code == 200) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(RecommendInfoActivity.this);
                            builder.setTitle("推荐成功");
                            builder.setMessage("推荐项目："+project_name+"\n"+"\n"+"姓名："+name1+"\n"+
                                    "\n"+"联系电话："+tel2);
                            builder.setNegativeButton("知道了", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    finish();
                                }
                            });
                            AlertDialog dialog = builder.create();
                            dialog.show();


                        } else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(RecommendInfoActivity.this);
                            builder.setTitle("推荐失败");
                            builder.setMessage(resultData.msg);
                            builder.setNegativeButton("知道了", new DialogInterface.OnClickListener() {
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

        Log.e("ccccww",project_id+" "+name+" "+tel);
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
                .params("intent", intent)
                .params("urgency", urgency)
                .params("need_tags", need_tags)
                .params("comment", comment)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        ResultData resultData = JsonUtil.jsonToEntity(s, ResultData.class);
                        Log.e("ccccss",resultData.code+" ");
                        if (resultData.code == 200) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(RecommendInfoActivity.this);
                            builder.setTitle("推荐成功");
                            builder.setMessage("推荐项目："+project_name+"\n"+"\n"+"姓名："+name1+"\n"+
                                    "\n"+"联系电话："+tel2);
                            builder.setNegativeButton("知道了", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    finish();
                                }
                            });
                            AlertDialog dialog = builder.create();
                            dialog.show();


                        } else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(RecommendInfoActivity.this);
                            builder.setTitle("推荐失败");
                            builder.setMessage(resultData.msg);
                            builder.setNegativeButton("知道了", new DialogInterface.OnClickListener() {
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
                        Log.e("cccc",model.code+" ");
                        if(model.code==200){
                            AlertDialog.Builder builder = new AlertDialog.Builder(RecommendInfoActivity.this);
                            builder.setTitle("推荐成功");
                            builder.setMessage("推荐项目："+project_name+"\n"+"\n"+"姓名："+name1+"\n"+
                                    "\n"+"联系电话："+tel2);
                            builder.setNegativeButton("知道了", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent(RecommendInfoActivity.this,WorkRecommendActivity.class);
                                    startActivity(intent);
                                }
                            });
                            AlertDialog dialog = builder.create();
                            dialog.show();


                        } else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(RecommendInfoActivity.this);
                            builder.setTitle("推荐失败");
                            builder.setMessage(model.msg);
                            builder.setNegativeButton("知道了", new DialogInterface.OnClickListener() {
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
                        Log.e("cccc",model.code+" ");
                        if(model.code==200){
                            AlertDialog.Builder builder = new AlertDialog.Builder(RecommendInfoActivity.this);
                            builder.setTitle("推荐成功");
                            builder.setMessage("推荐项目："+project_name+"\n"+"\n"+"姓名："+name1+"\n"+
                                    "\n"+"联系电话："+tel2);
                            builder.setNegativeButton("知道了", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intent = new Intent(RecommendInfoActivity.this,WorkRecommendActivity.class);
                                    startActivity(intent);
                                }
                            });
                            AlertDialog dialog = builder.create();
                            dialog.show();


                        } else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(RecommendInfoActivity.this);
                            builder.setTitle("推荐失败");
                            builder.setMessage(model.msg);
                            builder.setNegativeButton("知道了", new DialogInterface.OnClickListener() {
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
