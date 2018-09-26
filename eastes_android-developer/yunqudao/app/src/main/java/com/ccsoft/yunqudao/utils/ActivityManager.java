package com.ccsoft.yunqudao.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.util.Log;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Activity 管理类
 *
 * @author: hcc
 * @data: 2018/5/24 0024
 */

public class ActivityManager {

    private static volatile ActivityManager mInstance;
    private Stack<Activity> mActivityStack = new Stack<>();

    private ActivityManager() {
    }

    /**
     * 单一实例
     */
    public static ActivityManager getInstance() {
        if (null == mInstance) {
            synchronized (ActivityManager.class) {
                if (null == mInstance) {
                    mInstance = new ActivityManager();
                }
            }
        }
        return mInstance;
    }

    /**
     * 添加Activity到堆栈
     */
    public void addActivity(Activity activity) {
        if (null != this.mActivityStack) {
            this.mActivityStack.add(activity);
        }
    }

    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    public Activity currentActivity() {
        if (mActivityStack == null || mActivityStack.size() == 0) {
            return null;
        }
        return this.mActivityStack.lastElement();
    }

    /**
     * 结束当前Activity（堆栈中最后一个压入的）
     */
    public void finishActivity() {
        if (null != this.mActivityStack) {
            Activity activity = this.mActivityStack.lastElement();
            this.finishActivity(activity);
        }
    }

    /**
     * 结束指定的Activity
     */
    public void finishActivity(Activity activity) {
        if (null != this.mActivityStack && null != activity) {
            if (this.mActivityStack.contains(activity)) {
                this.mActivityStack.remove(activity);
                if (!activity.isFinishing()) {
                    activity.finish();
                }
            }
            activity = null;
        }
    }

    /**
     * 获取指定类名的Activity
     */
    public Activity findActivity(Class<? extends Activity>... activityClass) {
        if (null != this.mActivityStack && this.mActivityStack.size() > 0) {
            Iterator<Activity> iterator = mActivityStack.iterator();
            while (iterator.hasNext()) {
                Activity activity = iterator.next();
                if (Arrays.asList(activityClass).contains(activity.getClass())) {
                    return activity;
                }
            }
        }
        return null;
    }

    /**
     * 结束指定类名的Activity
     */
    public void finishActivity(Class<? extends Activity>... activityClass) {
        if (null != this.mActivityStack && this.mActivityStack.size() > 0) {
            Iterator<Activity> iterator = mActivityStack.iterator();
            while (iterator.hasNext()) {
                Activity activity = iterator.next();
                if (Arrays.asList(activityClass).contains(activity.getClass())) {
                    iterator.remove();
                    activity.finish();
                }
            }
        }
    }

    /**
     * 结束所有Activity
     */
    public void finishAllActivity() {
        if (null != this.mActivityStack && this.mActivityStack.size() > 0) {
            for (Activity activity : this.mActivityStack) {
                activity.finish();
            }
            this.mActivityStack.clear();
        }
    }

    /**
     * 退出应用程序
     */
    public void AppExit() {
        this.finishAllActivity();
        this.mActivityStack = null;
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }

    /**
     * 是否退出应用程序
     *
     * @return
     */
    public boolean isAppExit() {
        return null == this.mActivityStack || this.mActivityStack.isEmpty();
    }

    /**
     * 判断某个activity是否在栈顶
     *
     * @param context
     * @param activityClass 某个activity
     *
     * @return
     */
    public boolean isTopActivity(Context context, Class activityClass) {
        if (null == context || null == activityClass) {
            return false;
        }
        String activityName = activityClass.getName();
        android.app.ActivityManager am = (android.app.ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<android.app.ActivityManager.RunningTaskInfo> runningTaskInfoList = am.getRunningTasks(1);
        if (runningTaskInfoList != null && runningTaskInfoList.size() > 0) {
            ComponentName cpn = runningTaskInfoList.get(0).topActivity;
            if (activityName.equals(cpn.getClassName())) {
                return true;
            }
        }
        return false;
    }

    public int getActivitySizes() {
        return mActivityStack.size();
    }
}
