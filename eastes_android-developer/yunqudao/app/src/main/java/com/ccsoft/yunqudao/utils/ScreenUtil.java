package com.ccsoft.yunqudao.utils;

import android.app.Activity;
import android.app.KeyguardManager;
import android.app.UiModeManager;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import com.ccsoft.yunqudao.App;
import java.lang.reflect.Field;

/**
 * 屏幕工具类
 *
 * @author PengZhenjin
 * @date 2017-1-10
 */
public class ScreenUtil {
    private static final String TAG = "ScreenUtil";

    private static double RATIO = 0.85;

    public static int screenWidth;  // 屏幕的宽度
    public static int screenHeight; // 屏幕的高度
    public static int screenMin;    // 宽高中，小的一边
    public static int screenMax;    // 宽高中，较大的值

    public static float density;    // 密度值
    public static float scaleDensity;   // 缩放的密度值
    public static float xdpi;   // 在屏幕X维度的dpi值
    public static float ydpi;   // 在屏幕Y维度的dpi值
    public static int   densityDpi; // 密度dpi值

    public static int dialogWidth;  // 对话框的宽度
    public static int statusBarHeight;  // 状态栏的高度
    public static int navBarHeight; // 导航条的高度

    static {
        init(App.getContext());
    }

    /**
     * 初始化
     *
     * @param context
     */
    public static void init(Context context) {
        if (null == context) {
            return;
        }
        DisplayMetrics dm = context.getApplicationContext().getResources().getDisplayMetrics();
        screenWidth = dm.widthPixels;
        screenHeight = dm.heightPixels;
        screenMin = (screenWidth > screenHeight) ? screenHeight : screenWidth;
        screenMax = (screenWidth < screenHeight) ? screenHeight : screenWidth;
        density = dm.density;
        scaleDensity = dm.scaledDensity;
        xdpi = dm.xdpi;
        ydpi = dm.ydpi;
        densityDpi = dm.densityDpi;
        statusBarHeight = getStatusBarHeight(context);
        navBarHeight = getNavBarHeight(context);
        Log.d(TAG, "screenWidth=" + screenWidth + " screenHeight=" + screenHeight + " density=" + density);
    }

    /**
     * dip转换为px
     *
     * @param dipValue
     *
     * @return
     */
    public static int dip2px(float dipValue) {
        return (int) (dipValue * density + 0.5f);
    }

    /**
     * px转换为dip
     *
     * @param pxValue
     *
     * @return
     */
    public static int px2dip(float pxValue) {
        return (int) (pxValue / density + 0.5f);
    }

    /**
     * sp转换为px
     *
     * @param spValue
     *
     * @return
     */
    public static int sp2px(float spValue) {
        return (int) (spValue * scaleDensity + 0.5f);
    }

    /**
     * 获取对话框的宽
     *
     * @return
     */
    public static int getDialogWidth() {
        dialogWidth = (int) (screenMin * RATIO);
        return dialogWidth;
    }

    /**
     * 获取显示的宽度
     *
     * @return
     */
    public static int getDisplayWidth() {
        if (screenWidth == 0) {
            init(App.getContext());
        }
        return screenWidth;
    }

    /**
     * 获取显示的高度
     *
     * @return
     */
    public static int getDisplayHeight() {
        if (screenHeight == 0) {
            init(App.getContext());
        }
        return screenHeight;
    }

    /**
     * 获取状态栏的高度
     *
     * @param context
     *
     * @return
     */
    public static int getStatusBarHeight(Context context) {
        if (statusBarHeight == 0) {
            try {
                Class<?> c = Class.forName("com.android.internal.R$dimen");
                Object o = c.newInstance();
                Field field = c.getField("status_bar_height");
                int x = (Integer) field.get(o);
                statusBarHeight = context.getResources().getDimensionPixelSize(x);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (statusBarHeight == 0) {
            statusBarHeight = ScreenUtil.dip2px(25);
        }
        return statusBarHeight;
    }

    /**
     * 获取导航条的高度
     *
     * @param context
     *
     * @return
     */
    public static int getNavBarHeight(Context context) {
        Resources resources = context.getResources();
        int resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (resourceId > 0) {
            return resources.getDimensionPixelSize(resourceId);
        }
        return 0;
    }

    /**
     * 设置屏幕背景透明度
     *
     * @param activity
     * @param bgAlpha  范围：0.0 - 1.0
     */
    public static void setBackgroundAlpha(Activity activity, float bgAlpha) {
        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        WindowManager.LayoutParams params = activity.getWindow().getAttributes();
        params.alpha = bgAlpha;
        activity.getWindow().setAttributes(params);
        if (bgAlpha == 1) {//如果设置为不透明则移除标识
            activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        }
    }

    /**
     * 判断是否是锁屏状态
     *
     * @param context 上下文
     *
     * @return true: 是<br>false: 否
     */
    public static boolean isScreenLockStatus(Context context) {
        KeyguardManager km = (KeyguardManager) context.getSystemService(Context.KEYGUARD_SERVICE);
        return km.inKeyguardRestrictedInputMode();
    }

    /**
     * 设置无标题
     *
     * @param activity
     */
    public static void setNoTitle(Activity activity) {
        activity.requestWindowFeature(Window.FEATURE_NO_TITLE);
    }

    /**
     * 设置全屏
     *
     * @param activity
     */
    public static void setFullScreen(Activity activity) {
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);   // 全屏
    }

    /**
     * 退出全屏
     *
     * @param activity
     */
    public static void quitFullScreen(Activity activity) {
        WindowManager.LayoutParams attrs = activity.getWindow().getAttributes();
        attrs.flags &= (~WindowManager.LayoutParams.FLAG_FULLSCREEN);
        activity.getWindow().setAttributes(attrs);
        activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }

    /**
     * 设置屏幕背景透明度
     *
     * @param activity
     * @param bgAlpha  0.0-1.0
     */
    public static void backgroundAlpha(Activity activity, float bgAlpha) {
        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        WindowManager.LayoutParams params = activity.getWindow().getAttributes();
        params.alpha = bgAlpha;
        activity.getWindow().setAttributes(params);
    }

    /**
     * 根据屏幕返回当前设备是否是TV
     *
     * @return
     */
    public static boolean isTV(Context context) {
        UiModeManager umm = (UiModeManager) context.getSystemService(Context.UI_MODE_SERVICE);
        if (umm.getCurrentModeType() == Configuration.UI_MODE_TYPE_TELEVISION) {
            return true;
        }
        else {
            return false;
        }
    }
}
