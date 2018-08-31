package com.ccsoft.yunqudao.ui.work.duijierentuijian;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.GetHouseTypeDetailBean;
import com.ccsoft.yunqudao.bean.GetNeedInfoBean;
import com.ccsoft.yunqudao.bean.StringBean;
import com.ccsoft.yunqudao.data.AppConstants;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.ui.adapter.RecommendPopupwindowAdapter;
import com.ccsoft.yunqudao.ui.house.AdvicerChooseActivity;
import com.ccsoft.yunqudao.ui.me.MyTeamActivity;
import com.ccsoft.yunqudao.ui.message.WorkMessageActivity;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import org.jaaksi.pickerview.dataset.OptionDataSet;
import org.jaaksi.pickerview.picker.BasePicker;
import org.jaaksi.pickerview.picker.OptionPicker;
import org.jaaksi.pickerview.widget.PickerView;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

public class DuiJieQueRenActivity extends AppCompatActivity {

    private ImageButton work_button_back;
    private Button button_next;
    private EditText customers_edittext_kehu;
    private EditText customers_edittext_tel,et_comment;
    private Spinner customers_spinner_card_type;
    private TextView customers_edittext_zhiye;
    private OptionPicker mPicker;
    private GetHouseTypeDetailBean  bean;
    private List<GetHouseTypeDetailBean.DataBean.RowsBean> datalist = new ArrayList<>();
    private RecommendPopupwindowAdapter adapter;
    private int project_id,client_id,property_advicer_wish_id,visit_num;
    private String client_name,client_tel,visit_time;
    private int daofangid;




    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.actiivty_duijiequeren);
        initView();
//        initListener();
        getneedInfo();
    }
    private void initView(){
        getData();
        daofangid = getIntent().getIntExtra("daofangid",0);
        project_id = getIntent().getIntExtra("project_id",0);
        client_name = getIntent().getStringExtra("client_name");
        client_tel = getIntent().getStringExtra("client_tel");
        client_id = getIntent().getIntExtra("client_id",0);
        getHouseTypeDatil(project_id);
        work_button_back = findViewById(R.id.work_button_back);
        button_next = findViewById(R.id.button_next);
        customers_edittext_kehu = findViewById(R.id.customers_edittext_kehu);
        customers_edittext_tel = findViewById(R.id.customers_edittext_tel);
        customers_spinner_card_type = findViewById(R.id.customers_spinner_card_type);
        customers_edittext_zhiye = findViewById(R.id.customers_edittext_zhiye);
        et_comment = findViewById(R.id.et_comment);

        customers_edittext_kehu.setText(client_name);
        customers_edittext_tel.setText(client_tel);

        work_button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(customers_edittext_zhiye.getText().toString().equals("")){
                    Toast.makeText(DuiJieQueRenActivity.this,"请选择置业顾问",Toast.LENGTH_SHORT).show();
                    return;
                }
                initData();
            }
        });

        customers_edittext_zhiye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getVisitNum();
                backgroundAlpha((float) 0.5);
            }
        });

        customers_spinner_card_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] data = getResources().getStringArray(R.array.到访人数);
                visit_num = Integer.parseInt(data[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    private void getneedInfo(){
        OkHttpUtils.get(AppConstants.URL+"agent/client/needInfo")
                .params("client_id",client_id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        GetNeedInfoBean bean = JsonUtil.jsonToEntity(s,GetNeedInfoBean.class);
                        if(bean.getCode() == 200){
                            customers_edittext_zhiye.setText(bean.getData().getComsulatent_advicer());
                            property_advicer_wish_id = Integer.parseInt(bean.getData().getId());
                        }
                    }
                });
    }
    private void initData(){

        Log.e("ccccccw",client_id+" "+customers_edittext_kehu.getText().toString()+" "+
                customers_edittext_tel.getText().toString()+" "+visit_num+" " +
                visit_time+" "+customers_edittext_zhiye.getText().toString()+" "+property_advicer_wish_id+" "+
                et_comment.getText().toString());

        OkHttpUtils.post(AppConstants.URL+"agent/client/confirmValue")
                .params("client_id",client_id)
                .params("client_name",customers_edittext_kehu.getText().toString())
                .params("client_tel",customers_edittext_tel.getText().toString())
                .params("visit_num",visit_num)
                .params("visit_time",visit_time)
                .params("property_advicer_wish",customers_edittext_zhiye.getText().toString())
                .params("property_advicer_wish_id",property_advicer_wish_id)
                .params("comment",et_comment.getText().toString())
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        StringBean bean = JsonUtil.jsonToEntity(s,StringBean.class);
                        Log.e("cccccws",bean.getCode()+" "+bean.getMsg());
                        if(bean.getCode() == 200){
                            if(daofangid == 1){
                                Intent intent = new Intent(DuiJieQueRenActivity.this, WorkMessageActivity.class);
                                startActivity(intent);
                            }else if(daofangid == 3){
                                Intent intent1 = new Intent(DuiJieQueRenActivity.this,WorkDuiJieRecommendActivity.class);
                                startActivity(intent1);
                            }
                            finish();
                        }
                        Toast.makeText(DuiJieQueRenActivity.this,bean.getMsg(),Toast.LENGTH_SHORT).show();
                    }
                });
    }


    private void getVisitNum() {
        View view = LayoutInflater.from(this).inflate(R.layout.popupwindow_duijie,null);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.select);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new RecommendPopupwindowAdapter(this,R.layout.item_zhiye_activity,datalist);
        recyclerView.setAdapter(adapter);
        PopupWindow popupWindow = new PopupWindow(ViewGroup.LayoutParams.MATCH_PARENT, 600);
        popupWindow.setContentView(view);
        popupWindow.setFocusable(true);
        popupWindow.showAtLocation(DuiJieQueRenActivity.this.getWindow().getDecorView(), Gravity.BOTTOM,0,0);

        adapter.setOnItemClickListner(new BaseRecyclerAdapter.OnItemClickListner() {
            @Override
            public void onItemClickListner(View v, int position) {
                property_advicer_wish_id = Integer.parseInt(bean.getData().getRows().get(position).getID());
//                customers_edittext_zhiye.setText(bean.getData().getRows().get(position).getGSMC()+"/"+bean.getData().getRows().get(position).getRYXM()
//                +"/"+bean.getData().getRows().get(position).getRYDH());
                customers_edittext_zhiye.setText(bean.getData().getRows().get(position).getRYXM());
                backgroundAlpha(1);
                popupWindow.dismiss();
            }
        });

        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1);
            }
        });
    }


    /**
     * 获取置业顾问
     */
    private void getHouseTypeDatil(int project_id){
        OkHttpUtils.get(AppConstants.URL+"user/project/advicer")
                .tag(this)
                .params("project_id",project_id)
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

                        bean = JsonUtil.jsonToEntity(s,GetHouseTypeDetailBean.class);
                        if (bean.getCode() == 200){
                           datalist.clear();
                           datalist.addAll(bean.getData().getRows());
                        }
                    }
                });
    }

    /**
     * 获取系统当前时间
     */
    private void getData(){
        SimpleDateFormat formatter    =   new    SimpleDateFormat    ("yyyy-MM-dd HH:mm:ss");
        Date curDate    =   new    Date(System.currentTimeMillis());//获取当前时间
        visit_time   =    formatter.format(curDate);
    }

    public void backgroundAlpha(float bgAlpha)  //阴影改变
    {
        WindowManager.LayoutParams lp =getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        getWindow().setAttributes(lp);
    }
}
