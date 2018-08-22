package com.ccsoft.yunqudao.ui.house;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.ProjectDanYuanBean;
import com.ccsoft.yunqudao.ui.work.secondhandhouse.CommitBaoBeiActivity;
import com.ccsoft.yunqudao.utils.ActivityManager;

import java.util.ArrayList;
import java.util.List;

public class ProjectDanYuanActivity extends Activity {

    private ProjectDanYuanBean.DataBean.LISTBean list ;
    private TextView tv_fanghao,tv_loudong,tv_danyuan,tv_louceng,
            tv_danjia,tv_zongjia,tv_mianji,tv_taonei,tv_huxin,tv_wuye,tv_baobeiquxiao,tv_baobeoqueren;
    private ImageView im_back;
    private int build_id,project_id,unit_id;
    private String unit_name,build_name;

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
        setContentView(R.layout.activity_project_danyuan);
        initView();

    }
    private void initView(){
        Bundle bundle =getIntent().getExtras();
        list = (ProjectDanYuanBean.DataBean.LISTBean) bundle.getSerializable("list");
        project_id= getIntent().getIntExtra("project_id",0);
        build_id = getIntent().getIntExtra("build_id",0);
        unit_id = getIntent().getIntExtra("unit_id",0);
        unit_name = getIntent().getStringExtra("unit_name");
        build_name = getIntent().getStringExtra("build_name");


        tv_fanghao = findViewById(R.id.tv_fanghao);
        tv_loudong = findViewById(R.id.tv_loudong);
        tv_danyuan = findViewById(R.id.tv_danyuan);
        tv_louceng = findViewById(R.id.tv_louceng);
        tv_danjia = findViewById(R.id.tv_danjia);
        tv_zongjia = findViewById(R.id.tv_zongjia );
        tv_mianji = findViewById(R.id.tv_mianji);
        tv_taonei = findViewById(R.id.tv_taonei);
        tv_huxin = findViewById(R.id.tv_huxin);
        tv_wuye = findViewById(R.id.tv_wuye);
        im_back = findViewById(R.id.im_back);
        tv_baobeiquxiao = findViewById(R.id.tv_baobeiquxiao);
        tv_baobeoqueren = findViewById(R.id.tv_baobeoqueren);

        tv_fanghao.setText(list.getFJMC());
        tv_loudong.setText(list.getLDMC());
        tv_danyuan.setText(list.getDYMC());
        tv_louceng.setText(list.getFLOORNUM());
        tv_danjia.setText(list.getJZDJ());
        tv_zongjia.setText(list.getFJZJ());
        tv_mianji.setText(list.getJZMJ());
        tv_taonei.setText(list.getTNMJ());
        tv_huxin.setText(list.getHXMC());
        tv_wuye.setText(list.getWYMC());

        im_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        tv_baobeiquxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        tv_baobeoqueren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("list",list);
                Intent intent = new Intent(ProjectDanYuanActivity.this, CommitBaoBeiActivity.class);
                intent.putExtra("project_id",project_id);
                intent.putExtra("build_id",build_id);
                intent.putExtra("record_type",1);
                intent.putExtra("build_name",build_name);
                intent.putExtra("unit_id",unit_id);
                intent.putExtra("unit_name",unit_name);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

}
