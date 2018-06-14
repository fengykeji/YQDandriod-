package com.ccsoft.yunqudao.utils;

import android.text.TextUtils;
import android.widget.ImageView;
import com.ccsoft.yunqudao.R;

/**
 * 根据类型设置图片icon
 *
 * @author: Pein
 * @data: 2018/4/17 0017
 */

public class ItemIconUtil {

    private static final int SYSTEM_MESSAGE = 1;    // 假如系统消息是1
    private static final int JOB_MESSAGE = 2;       // 假如工作消息是2

    /**
     * @param imageView
     * @param name      需要设置图片的title名，根据名称不同设置图
     */
    public static void setMsgIcon(ImageView imageView, String name) {
        if (TextUtils.isEmpty(name)) {
            return;
        }
        if (name.contains("系统")) {
            imageView.setImageResource(R.drawable.ic_systemmessage);
        }
        else if (name.contains("工作")) {
            imageView.setImageResource(R.drawable.ic_worknews);
        }
    }

    /**
     * @param imageView
     * @param type      根据Type设置图片icon
     */
    public static void setMsgIcon(ImageView imageView, int type) {
        if (type < 0) {//这里写小于0是因为你可以给type默认设置成-1 ，如果默认就有其他值得话 这一步也没什么影响
            return;
        }
        switch (type) {
            case SYSTEM_MESSAGE:
                imageView.setImageResource(R.drawable.ic_systemmessage);
                break;

            case JOB_MESSAGE:
                imageView.setImageResource(R.drawable.ic_worknews);// 这里的设置对应的就行 如果还有别的消息类型 你再增加就可以了 现在两个方法 可以根据不同类型来改无论是TYPE还是title（也就是名字）
                break;
        }
    }


}
