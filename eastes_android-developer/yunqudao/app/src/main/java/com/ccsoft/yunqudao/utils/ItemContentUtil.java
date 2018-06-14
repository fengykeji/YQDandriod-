package com.ccsoft.yunqudao.utils;

import android.widget.TextView;

/**
 * @author: Pein
 * @data: 2018/4/17 0017
 */

public class ItemContentUtil {

    private static final int SYSTEM_MESSAGE=1;  //假如系统消息是1
    private static final int JOB_MESSAGE=2;     //假如工作消息是2

    /**
     *
     * @param textView
     * @param type  根据type设置title
     */
    public static void setItemtitle(TextView textView,int type){
        switch (type) {
            case SYSTEM_MESSAGE:
                textView.setText("系统消息");
                break;

            case JOB_MESSAGE:
                textView.setText("工作消息");
                break;
        }
    }
}
