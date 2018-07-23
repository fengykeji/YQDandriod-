package com.ccsoft.yunqudao.ui.customers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
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
import com.ccsoft.yunqudao.ui.adapter.AddLabelAdapter1;
import com.ccsoft.yunqudao.ui.mian.MainActivity;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.HideIMEUtil;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Pein
 * @data: 2018/5/9 0009
 */

public class AddLabelActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton mCustomers_button_back;
    private Button      mCustomers_button_commit;
    private RecyclerView re_add_label_list,re_add_label_list1;
    private AddLabelAdapter adapter;
    private AddLabelAdapter1 adapter1;
    private List<PeizhiBean.DataBean._$15Bean.ParamBeanXXXXXXXXXXXXXX> dataList = new ArrayList<>();
    private String param;
    private LinearLayout ll_addTextLabel,ll_addTextLabel2,ll_addTextLabel3,ll_addTextLabel4,show_label;
    private ArrayList<Integer> list = new ArrayList<>();
    private List<String> lists = new ArrayList<>();
    private String name;
    private String sex;
    private String tel;
    private String birth;
    private String card_id;
    private String address;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_customers_add_label);
        HideIMEUtil.wrap(this);
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
        Submit();

        mCustomers_button_back = findViewById(R.id.customers_button_back);
        mCustomers_button_commit = findViewById(R.id.customers_button_commit);
        re_add_label_list = findViewById(R.id.re_add_label_list);
        re_add_label_list1 = findViewById(R.id.re_add_label_list1);
        ll_addTextLabel = findViewById(R.id.ll_addTextLabel);
        show_label = findViewById(R.id.show_label);
//        ll_addTextLabel2 = findViewById(R.id.ll_addTextLabel2);
//        ll_addTextLabel3 = findViewById(R.id.ll_addTextLabel3);
//        ll_addTextLabel4 = findViewById(R.id.ll_addTextLabel4);

        dataList = MainActivity.savePeizhi().getData().get_$15().getParam();
        re_add_label_list.setLayoutManager(new GridLayoutManager(this,4));
        adapter = new AddLabelAdapter(this,R.layout.activity_addlabel,dataList);
        re_add_label_list.setAdapter(adapter);





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
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
                textView.setMaxEms(4);



//               ImageView imageView = new ImageView(AddLabelActivity.this);
//               imageView.setImageResource(R.drawable.ic_delete_3);
//               imageView.setOnClickListener(new View.OnClickListener() {
//                   @Override
//                   public void onClick(View view) {
//                       ll_addTextLabel.removeView(imageView);
//                       ll_addTextLabel.removeView(textView);
//                       ll_addTextLabel2.removeView(imageView);
//                       ll_addTextLabel2.removeView(textView);
//                       ll_addTextLabel3.removeView(imageView);
//                       ll_addTextLabel3.removeView(textView);
//                       ll_addTextLabel4.removeView(imageView);
//                       ll_addTextLabel4.removeView(textView);
//                      for(int i = 0;i<list.size();i++){
//                          if(param.equals(list.get(i))) {
//                              list.remove(i);
//                          }}
//                       if (list.size() < 5) {
//                           ll_addTextLabel2.setVisibility(View.GONE);
//                           ll_addTextLabel3.setVisibility(View.GONE);
//                           ll_addTextLabel4.setVisibility(View.GONE);
//                           ll_addTextLabel.setVisibility(View.VISIBLE);
//                       } else if (list.size() < 8) {
//                           ll_addTextLabel3.setVisibility(View.GONE);
//                           ll_addTextLabel4.setVisibility(View.GONE);
//                           ll_addTextLabel.setVisibility(View.VISIBLE);
//                           ll_addTextLabel2.setVisibility(View.VISIBLE);
//                       } else if (list.size() < 12) {
//                           ll_addTextLabel4.setVisibility(View.GONE);
//                           ll_addTextLabel2.setVisibility(View.VISIBLE);
//                           ll_addTextLabel3.setVisibility(View.VISIBLE);
//                           ll_addTextLabel.setVisibility(View.VISIBLE);
//
//
//                       }
//                   }
//               });


                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                layoutParams.leftMargin = 6;

                list.add(dataList.get(position).getId());
                lists.add(param);

//                if(list.size()<5) {
//                    ll_addTextLabel.addView(textView, layoutParams);
//                    ll_addTextLabel.addView(imageView);
//                }else if(list.size()<8&&list.size()>=5){
//                    ll_addTextLabel2.addView(textView, layoutParams);
//                    ll_addTextLabel2.addView(imageView);
//                } else if(list.size()<12&&list.size()>=8){
//                    ll_addTextLabel3.addView(textView, layoutParams);
//                    ll_addTextLabel3.addView(imageView);
//                }else if(list.size()<16&&list.size()>=12){
//                    ll_addTextLabel4.addView(textView, layoutParams);
//                    ll_addTextLabel4.addView(imageView);
//                }
                re_add_label_list1.setLayoutManager(new GridLayoutManager(AddLabelActivity.this,4));
                adapter1 = new AddLabelAdapter1(AddLabelActivity.this,R.layout.activity_show_label,lists);
                re_add_label_list1.setAdapter(adapter1);
                adapter1.setOnItemClickListner(new BaseRecyclerAdapter.OnItemClickListner() {
                    @Override
                    public void onItemClickListner(View v, int position) {
                        lists.remove(position);
                        adapter1.notifyDataSetChanged();
                    }
                });




            }
        });
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.customers_button_back:
                finish();
                break;
            case R.id.customers_button_commit:

                EventBus.getDefault().post(new IntentServiceResult(list,lists));
//                Intent intent = new Intent(this,AddCustomers2Activity.class);
//                intent.putIntegerArrayListExtra("list", (ArrayList<Integer>) list);
//                intent.putStringArrayListExtra("lists", (ArrayList<String>) lists);
//                intent.putExtra("name",name);
//                intent.putExtra("sex",sex);
//                intent.putExtra("tel",tel);
//                intent.putExtra("birth",birth);
//                intent.putExtra("card_id",card_id);
//                intent.putExtra("address",address);
//                startActivity(intent);
                finish();
                break;
        }
    }

    private void Submit() {
        name = getIntent().getStringExtra("name");
        sex = getIntent().getStringExtra("sex");
        if (sex == null) {
            sex = "";
        } else if (sex.equals(2)) {
            sex = "女";
        } else if (sex.equals(1)) {
            sex = "男";
        }
        tel = getIntent().getStringExtra("tel");

        birth = getIntent().getStringExtra("birth");
        card_id = getIntent().getStringExtra("card_id");
        address = getIntent().getStringExtra("address");
    }
}
