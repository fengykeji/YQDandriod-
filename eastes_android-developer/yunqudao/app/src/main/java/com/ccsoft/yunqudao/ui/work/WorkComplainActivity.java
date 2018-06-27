package com.ccsoft.yunqudao.ui.work;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.AppealDetailBean;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.model.StringModel;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.BaseCallBack;
import com.ccsoft.yunqudao.utils.OkHttpManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Response;

/**
 * @author: Pein
 * @data: 2018/5/9 0009
 */

public class WorkComplainActivity extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemSelectedListener {

    private ImageButton mWork_button_back;
    private Button      mWork_button_commit;
    private TextView tv_shensuleixing;
    private Spinner sp_shensuleixing;
    private EditText et_comment;
    private int poject_client_id;
    private String shensuleixing,comment;
    private ArrayAdapter adapter;
    private int type;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_work_shensu);
        initView();
        initListener();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, WorkComplainActivity.class);
        context.startActivity(intent);
    }

    /**
     * 初始化
     */
    private void initView() {

        mWork_button_back = findViewById(R.id.work_button_back);
        mWork_button_commit = findViewById(R.id.work_button_commit);
        tv_shensuleixing = findViewById(R.id.tv_shensuleixing);
        sp_shensuleixing = findViewById(R.id.sp_shensuleixing);
        et_comment = findViewById(R.id.et_comment);
        poject_client_id = getIntent().getIntExtra("poject_client_id",0);

        setSpinnerData();

    }

    /**
     * 初始化
     */
    private void initListener() {

        mWork_button_back.setOnClickListener(this);
        mWork_button_commit.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.work_button_back:
                finish();
                break;
            case R.id.work_button_commit:

                if(shensuleixing.equals("")){
                    Toast.makeText(this,"请选择申诉类型",Toast.LENGTH_LONG).show();
                    return;
                }else if(shensuleixing.equals("申诉类型1")){
                    type = 107;
                }else if(shensuleixing.equals("申诉类型2")){
                    type = 108;
                }else if(shensuleixing.equals("申诉类型3")){
                    type = 109;
                }

                if(et_comment.getText().toString().equals("")){
                    Toast.makeText(this,"请输入申诉描述",Toast.LENGTH_LONG).show();
                    return;
                }else {
                comment = et_comment.getText().toString();}

                Log.e("cccccc",type+" "+ poject_client_id+"  "+comment);

                HashMap<String,String> map = new HashMap<>();
                map.put("project_client_id",poject_client_id+"");
                map.put("type",type+"");
                map.put("comment",comment);
                OkHttpManager.getInstance().post(HttpAdress.SHENSU, map, new BaseCallBack() {
                    @Override
                    public void onSuccess(Call call, Response response, Object obj) throws MalformedURLException {
                        Type type = new TypeToken<StringModel>() {}.getType();
                        StringModel model = new Gson().fromJson(obj.toString(), type);
                        if(model.getCode()==200) {
                            Toast.makeText(WorkComplainActivity.this, "申诉成功", Toast.LENGTH_SHORT).show();
                            finish();
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

    /**
     * 设置需求类型
     */
    private void setSpinnerData(){
        adapter = ArrayAdapter.createFromResource(this, R.array.申诉类型,
                android.R.layout.simple_spinner_item);
        sp_shensuleixing.setAdapter(adapter);
        sp_shensuleixing.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                shensuleixing = (String) adapter.getItem(i);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        switch (view.getId()) {
            case R.id.sp_shensuleixing:

                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
