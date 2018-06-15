package com.ccsoft.yunqudao.ui.customers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.PeizhiBean;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.ui.adapter.AddLabelAdapter;
import com.ccsoft.yunqudao.ui.mian.MainActivity;
import com.ccsoft.yunqudao.utils.ActivityManager;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Pein
 * @data: 2018/5/9 0009
 */

public class AddLabelActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton mCustomers_button_back;
    private Button      mCustomers_button_commit;
    private RecyclerView re_add_label_list,re_add_text_label_list;
    private AddLabelAdapter adapter;
    private List<PeizhiBean.DataBean._$15Bean.ParamBeanXXXXXXXXXXXXXX> dataList = new ArrayList<>();
    private String param;
    private LinearLayout ll_addTextLabel,ll_addTextLabel2,ll_addTextLabel3,ll_addTextLabel4,show_label;
    private List<String> list = new ArrayList<>();


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_customers_add_label);
        initView();
        initListener();
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, AddLabelActivity.class);
        context.startActivity(intent);
    }

    /**
     * 初始化id
     */
    private void initView() {

        mCustomers_button_back = findViewById(R.id.customers_button_back);
        mCustomers_button_commit = findViewById(R.id.customers_button_commit);
        re_add_label_list = findViewById(R.id.re_add_label_list);
        ll_addTextLabel = findViewById(R.id.ll_addTextLabel);
        show_label = findViewById(R.id.show_label);
        ll_addTextLabel2 = findViewById(R.id.ll_addTextLabel2);
        ll_addTextLabel3 = findViewById(R.id.ll_addTextLabel3);
        ll_addTextLabel4 = findViewById(R.id.ll_addTextLabel4);

        dataList = MainActivity.savePeizhi().getData().get_$15().getParam();
        re_add_label_list.setLayoutManager(new GridLayoutManager(this,4));
        adapter = new AddLabelAdapter(this,R.layout.activity_addlabel,dataList);
        re_add_label_list.setAdapter(adapter);

//        re_add_text_label_list.setLayoutManager(new GridLayoutManager(this,4));

    }

    /**
     * 初始化监听器
     */
    private void initListener() {

        mCustomers_button_back.setOnClickListener(this);
        mCustomers_button_commit.setOnClickListener(this);

        adapter.setOnItemClickListner(new BaseRecyclerAdapter.OnItemClickListner() {
            @Override
            public void onItemClickListner(View v, int position) {
                param = dataList.get(position).getParam();

                TextView textView = new TextView(AddLabelActivity.this);
                textView.setText(param);
                textView.setBackgroundResource(R.drawable.shape_addlabel);
                textView.setPadding(14,14,14,14);
                textView.setTextSize(19);

               ImageView imageView = new ImageView(AddLabelActivity.this);
               imageView.setImageResource(R.drawable.ic_delete_3);
               imageView.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       ll_addTextLabel.removeView(imageView);
                       ll_addTextLabel.removeView(textView);
                       ll_addTextLabel2.removeView(imageView);
                       ll_addTextLabel2.removeView(textView);
                       ll_addTextLabel3.removeView(imageView);
                       ll_addTextLabel3.removeView(textView);
                       ll_addTextLabel4.removeView(imageView);
                       ll_addTextLabel4.removeView(textView);
                      for(int i = 0;i<list.size();i++){
                          if(param.equals(list.get(i))) {
                              list.remove(i);
                              if (list.size() < 5) {
                                  ll_addTextLabel2.setVisibility(View.GONE);
                                  ll_addTextLabel3.setVisibility(View.GONE);
                                  ll_addTextLabel4.setVisibility(View.GONE);
                              } else if (list.size() < 8) {
                                  ll_addTextLabel3.setVisibility(View.GONE);
                                  ll_addTextLabel4.setVisibility(View.GONE);
                              } else if (list.size() < 12) {
                                  ll_addTextLabel4.setVisibility(View.GONE);
                              }

                          }}
                       if (list.size() < 5) {
                           ll_addTextLabel2.setVisibility(View.GONE);
                           ll_addTextLabel3.setVisibility(View.GONE);
                           ll_addTextLabel4.setVisibility(View.GONE);
                       } else if (list.size() < 8) {
                           ll_addTextLabel3.setVisibility(View.GONE);
                           ll_addTextLabel4.setVisibility(View.GONE);
                       } else if (list.size() < 12) {
                           ll_addTextLabel4.setVisibility(View.GONE);


                       }
                   }
               });


                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                layoutParams.leftMargin = 6;

                list.add(param);
                if(list.size()<5) {
                    ll_addTextLabel.addView(textView, layoutParams);
                    ll_addTextLabel.addView(imageView);
                }else if(list.size()<8){
                    ll_addTextLabel2.addView(textView, layoutParams);
                    ll_addTextLabel2.addView(imageView);
                } else if(list.size()<12){
                    ll_addTextLabel3.addView(textView, layoutParams);
                    ll_addTextLabel3.addView(imageView);
                }else if(list.size()<16){
                    ll_addTextLabel4.addView(textView, layoutParams);
                    ll_addTextLabel4.addView(imageView);
                }




            }
        });
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.customers_button_back:
                finish();
                break;
            case R.id.customers_button_commit:
                finish();
                break;
        }
    }
}
