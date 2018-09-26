package com.ccsoft.yunqudao.ui.Guide;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;
import com.ccsoft.yunqudao.data.AppConstants;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.ui.adapter.GuideAdapter;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.SpUtil;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Pein
 * @data: 2018/4/10 0010
 */

public class GuideActivity extends AppCompatActivity{

    private List<Fragment>  mList;
    private ViewPager       mGuide_viewpager;
    private GuideAdapter    mGuideAdapter;
    private Button mGuide_next;
    private long firstTime = 0;//记录用户首次点击返回键的时间

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_guide);
        initView();

    }


    public static void start(Context context) {
        Intent intent = new Intent(context, GuideActivity.class);
        context.startActivity(intent);
    }

    /**
     * 初始化id,把fm添加到list集合里
     */
    private void initView() {
        mGuide_viewpager = findViewById(R.id.guide_viewpager);
        mGuide_next = findViewById(R.id.guide_next);
        mList = new ArrayList<>();
        mList.add(new GuideFragment1());
        mList.add(new GuideFragment2());
        mList.add(new GuideFragment3());
        mList.add(new GuideFragment4());
        mList.add(new GuideFragment5());
        mGuideAdapter = new GuideAdapter(getSupportFragmentManager(), mList);
        mGuide_viewpager.setAdapter(mGuideAdapter);
        mGuide_viewpager.setCurrentItem(0);
    }



    /**
     * 双击返回键退出
     */
    @Override
    public void onBackPressed() {
        long secondTime = System.currentTimeMillis();
        if (secondTime - firstTime > 2000) {
            Toast.makeText(GuideActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            firstTime = secondTime;
        }
        else {
            System.exit(0);
        }
    }
    }




