package com.ccsoft.yunqudao.ui.me;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.data.AppConstants;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.HideIMEUtil;
import com.squareup.picasso.Picasso;

public class GongSiXiangQiangActivity extends AppCompatActivity implements View.OnClickListener{

    private Button bt_sure;
    private ImageButton im_back;
    private ImageView im_photo;
    private TextView tv_company,tv_content,tv_lianxi,tv_fuzheren,tv_jianjie;
    private String companyname,addaress,tel,name,comment,imgurl;
    private int companyId;
    private int chongxin = 0;
    private int bId = 0;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_me_gongsixiangqing);
        HideIMEUtil.wrap(this);
        initView();
        initListener();
    }

    private void initView(){
        bt_sure = findViewById(R.id.bt_sure);
        im_back = findViewById(R.id.im_back);
        im_photo = findViewById(R.id.im_photo);
        tv_company = findViewById(R.id.tv_company);
        tv_content = findViewById(R.id.tv_content);
        tv_lianxi = findViewById(R.id.tv_lianxi);
        tv_fuzheren = findViewById(R.id.tv_fuzheren);
        tv_jianjie = findViewById(R.id.tv_jianjie);

        companyname  = getIntent().getStringExtra("companyname");
        addaress = getIntent().getStringExtra("addaress");
        tel= getIntent().getStringExtra("tel");
        name= getIntent().getStringExtra("name");
        comment= getIntent().getStringExtra("comment");
        imgurl= getIntent().getStringExtra("imgurl");
        companyId = getIntent().getIntExtra("companyid",0);
        chongxin = getIntent().getIntExtra("chongxin",0);
        bId = getIntent().getIntExtra("bId", 0);

        Picasso.with(this).load(AppConstants.URL+imgurl)
                .fit()
                .error(R.drawable.default_3)
                .into(im_photo);
        tv_company.setText(companyname);
        tv_content.setText(addaress);
        if(tel.equals("null")){
            tv_lianxi.setText("联系电话：");
        }else {
            tv_lianxi.setText("联系电话：" + tel);
        }
        tv_fuzheren.setText("负责人："+name);
        tv_jianjie.setText(comment);

    }

    private void initListener(){
        bt_sure.setOnClickListener(this);
        im_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.im_back:
                finish();
                break;
            case R.id.bt_sure:
                Intent intent = new Intent(this,GongSiRenZheng1Activity.class);
                intent.putExtra("companyname",companyname);

                intent.putExtra("companyId",companyId);
                intent.putExtra("chongxin",chongxin);
                intent.putExtra("bId", bId);
                startActivity(intent);
                finish();
                break;
        }
    }
}
