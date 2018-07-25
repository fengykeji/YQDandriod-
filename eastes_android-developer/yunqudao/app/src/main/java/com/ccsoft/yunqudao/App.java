package com.ccsoft.yunqudao;

import android.app.Application;
import android.content.Context;
import com.ccsoft.yunqudao.utils.SpUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreater;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreater;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;

import org.xutils.x;

/**
 * @author: Pein
 * @data: 2018/4/10 0010
 */

public class App extends Application {

    private static Context mContext;




    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        SpUtil.init(this);
        x.Ext.init(this);
        x.Ext.setDebug(true);//打包的时候改成false 免得影响性能，现在开启是为了看日志gfgfdgfd
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        mContext = null;
    }

    public static Context getContext() {
        return mContext;
    }



}
