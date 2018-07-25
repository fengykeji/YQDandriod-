package com.ccsoft.yunqudao.ui.home;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.support.multidex.MultiDex;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jpush.android.api.JPushInterface;


import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.ashokvarma.bottomnavigation.TextBadgeItem;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.ui.fragment.CustomersFragment;
import com.ccsoft.yunqudao.ui.fragment.HouseFragment;
import com.ccsoft.yunqudao.ui.fragment.MeFragment;
import com.ccsoft.yunqudao.ui.fragment.MessageFragment;
import com.ccsoft.yunqudao.ui.fragment.WorkFragment;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.SpUtil;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *
 * BottomNavigationBar实现底部导航
 */
public class HomeActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener,MessageFragment.CallBackValue {

    @BindView(R.id.frameLayout)
    FrameLayout         frameLayout;
    @BindView(R.id.bottom_navigation_bar)
    BottomNavigationBar mBottomNavigationBar;
    private FragmentTransaction mFragmentTransaction;
    private CustomersFragment   mCustomersFragment;
    private HouseFragment       mHouseFragment;
    private MessageFragment     mMessageFragment;
    private MeFragment          mMeFragment;
    private WorkFragment        mWorkFragment;
    private Fragment            mFragment;//当前显示的Fragment
    private long firstTime = 0;//记录用户首次点击返回键的时间
    private int fid;
    private String noread;
    private TextBadgeItem badgeItem;




    protected void requestPermission(int requestCode) {
        // TODO Auto-generated method stub
        // 6.0以上系统才可以判断权限
        // 进入设置系统应用权限界面
        Intent intent = new Intent(Settings.ACTION_SETTINGS);
        startActivity(intent);
    }

    public HomeActivity() {}
    public static void start(Context context) {

        Intent intent = new Intent(context, HomeActivity.class);
        context.startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.activity_main);
        MultiDex.install(this);
        initView();
        ButterKnife.bind(this);
        //底部导航栏
        setBottomNavigationBar();
//setBottomNavigationBar的选中事件
        mBottomNavigationBar.setTabSelectedListener(this);

        setBadge();

    }

    private void initView() {
         fid= getIntent().getIntExtra("fid",0);
        mMessageFragment = new MessageFragment();
        mHouseFragment = new HouseFragment();
        mCustomersFragment = new CustomersFragment();
        mWorkFragment = new WorkFragment();
        mMeFragment = new MeFragment();

        mFragmentTransaction = getSupportFragmentManager().beginTransaction();
//        mFragmentTransaction.replace(R.id.frameLayout,mCustomersFragment)
        if(fid == 1){
            mFragmentTransaction.replace(R.id.frameLayout, mHouseFragment)
                    .commit();
            mFragment = mHouseFragment;

        }else if(fid == 2){
            mFragmentTransaction.replace(R.id.frameLayout, mCustomersFragment)
                    .commit();
            mFragment = mCustomersFragment;
        }else if(fid == 3){
            mFragmentTransaction.replace(R.id.frameLayout, mWorkFragment)
                    .commit();
            mFragment = mWorkFragment;
        }
        else {
            mFragmentTransaction.replace(R.id.frameLayout, mMessageFragment)
                    .commit();
            mFragment = mMessageFragment;
        }
//        mFragment = mCustomersFragment;
    }

    private void setBottomNavigationBar() {


        /**
         *  setMode() 内的参数有三种模式类型：
         *  MODE_DEFAULT 自动模式：导航栏Item的个数<=3 用 MODE_FIXED 模式，否则用 MODE_SHIFTING 模式
         *  MODE_FIXED 固定模式：未选中的Item显示文字，无切换动画效果。
         *  MODE_SHIFTING 切换模式：未选中的Item不显示文字，选中的显示文字，有切换动画效果。
         */
        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);

        /**setBackgroundStyle()内的参数有三种模式类型：
         * BACKGROUND_STYLE_DEFAULT：如果设置的Mode为MODE_FIXED，将使用BACKGROUND_STYLE_STATIC 。如果Mode为MODE_SHIFTING将使用BACKGROUND_STYLE_RIPPLE。
         * BACKGROUND_STYLE_STATIC：点击的时候没有水波纹效果
         * BACKGROUND_STYLE_RIPPLE：点击的时候有水波纹效果
         */
        mBottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        /**
         * 添加导航按钮
         */

//        badgeItem = new TextBadgeItem().setText(noread);
        mBottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.ic_message_selected, "消息").setActiveColorResource(R.color.qianlan).setInactiveIconResource(R.drawable.ic_message));
        mBottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.ic_housing_selected, "房源").setActiveColorResource(R.color.qianlan).setInactiveIconResource(R.drawable.ic_housing));
        mBottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.ic_customers_selected, "客源").setActiveColorResource(R.color.qianlan).setInactiveIconResource(R.drawable.ic_customers));
        mBottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.ic_work_selected, "工作").setActiveColorResource(R.color.qianlan).setInactiveIconResource(R.drawable.ic_work2));
        mBottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.ic_me_selected, "我的").setActiveColorResource(R.color.qianlan).setInactiveIconResource(R.drawable.ic_me));
        mBottomNavigationBar.setInActiveColor(R.color.huxing);
        if(fid==1){
            mBottomNavigationBar.setFirstSelectedPosition(1);
        }else if(fid == 2){
            mBottomNavigationBar.setFirstSelectedPosition(2);

        } else if(fid == 3){
            mBottomNavigationBar.setFirstSelectedPosition(3);
        }
        else {
            mBottomNavigationBar.setFirstSelectedPosition(0);
        }
        mBottomNavigationBar.initialise();
    }

    @Override
    public void onTabSelected(int position) {
        switch (position){
            case 0:
                switchFragment(mMessageFragment);
                break;
            case 1:
                switchFragment(mHouseFragment);
                break;
            case 2:
                switchFragment(mCustomersFragment);
                break;
            case 3:
                switchFragment(mWorkFragment);
                break;
            case 4:
                switchFragment(mMeFragment);
                break;
        }
    }
    @Override
    public void onTabUnselected(int position) {}
    @Override
    public void onTabReselected(int position) {}

    private void switchFragment(Fragment fragment) {
        //判断当前显示的Fragment是不是切换的Fragment
        if(mFragment != fragment) {
            //判断切换的Fragment是否已经添加过
            if (!fragment.isAdded()) {
                //如果没有，则先把当前的Fragment隐藏，把切换的Fragment添加上
                getSupportFragmentManager().beginTransaction().hide(mFragment).add(R.id.frameLayout,fragment).commit();
            } else {
                //如果已经添加过，则先把当前的Fragment隐藏，把切换的Fragment显示出来
                getSupportFragmentManager().beginTransaction().hide(mFragment).show(fragment).commit();
            }
            mFragment = fragment;
        }
    }

    /**
     * 双击返回键退出
     */
//    @Override
//    public void onBackPressed() {
//        long secondTime = System.currentTimeMillis();
//        if (secondTime - firstTime > 2000) {
//            Toast.makeText(HomeActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
//            firstTime = secondTime;
//        }
//        else {
//            System.exit(0);
//        }
//    }


    @Override
    public void SendMessageValue(String strValue) {
        noread = strValue;


    }

    /**
     * 设置角标
     */
     private void setBadge(){
         NotificationManager mNotificationManager = (NotificationManager) this

                 .getSystemService(Context.NOTIFICATION_SERVICE);



         Notification.Builder builder = new Notification.Builder(this)

                 .setContentTitle("title").setContentText("text").setSmallIcon(R.drawable.icon);

         Notification notification = builder.build();

         try {

             Field field = notification.getClass().getDeclaredField("extraNotification");

             Object extraNotification = field.get(notification);

             Method method = extraNotification.getClass().getDeclaredMethod("setMessageCount", int.class);

             method.invoke(extraNotification, 35);

         } catch (Exception e) {

             e.printStackTrace();

         }

         mNotificationManager.notify(0,notification);
     }
}
