package com.ccsoft.yunqudao.data;

import com.ccsoft.yunqudao.utils.OkHttpManager;

/**
 * App常量池
 *
 * @author: Pein
 * @data: 2018/4/10 0010
 */

public class AppConstants {

    /**
     * 服务器地址
     */

    public static final String URL = "http://47.106.39.169:2797/";//演示
//    public static final String URL = "http://120.78.69.178:2902/";//线上环境
//    public static final String URL = "http://120.27.21.136:2798/";//测试环境

    /**
     * sp常量池
     */
    public interface SP {
        String IS_SHOW_GUIDE = "is_show_guide";//是否显示引导页
        String TOKEN         = "token";// token
    }

    /**
     * eventbus 常量池
     */
    public interface EVENTBUS {
        String FINISH_ADD_CUSTOMERS = "finish";//是否finish添加客户1}
    }

    /**
     * positionid常量池
     */
    public interface POSITIONID {

        int HOUSE_AGENT = 1;//经纪人
        int RECEIVER    = 2;//到访确认人
    }

    /**
     * 验证器常量
     */
    public interface Validator {
        // 正则表达式：验证用户名（规则：11位手机号或邮箱）
        String REGEX_ACCOUNT = "^(\\d{11})|([\\w\\.\\-_]+@[\\w-]+[\\.][\\w-]+[\\w-_.]*)$";

        // 正则表达式：验证密码（规则6-20位数字或字母或符号至少包括2种）
        //  String REGEX_PASSWORD = "^([A-Z]|[a-z]|[0-9]|[`-=[];,./~!@#$%^*()_+}{:?]){6,20}$";
        String REGEX_PASSWORD = "^(?!^[0-9]+$)(?!^[a-zA-Z]+$)(?!^[^a-zA-Z0-9]+$)^.{6,20}$";

        // 正则表达式：验证手机号
        // String REGEX_MOBILE = "^[1][34578][0-9]{9}$";
        String REGEX_MOBILE = "^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$";

        // 正则表达式：验证昵称
        String REGEX_NICKNAME = "^([\\u4e00-\\u9fa5\\w_-]*)$";

        // 正则表达式：验证汉字、字母、数字
        String REGEX_CHAR_NUMBER = "^([\\u4e00-\\u9fa5\\w]*)$";

        // 正则表达式：验证邮箱
        //String REGEX_EMAIL = "^([a-z0-9A-Z_]+[-|\\.]?)+@([a-z0-9A-Z]+?\\.)+[a-zA-Z]{2,}$";
        String REGEX_EMAIL = "[\\w\\.\\-_]+@[\\w-]+[\\.][\\w-]+[\\w-_.]*$";

        // 定义html转义字符的正则表达式 如：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        String REGEX_HTML_SPECIAL = "\\&[a-zA-Z]{1,10};";
    }

    /**
     * sex 常量池
     */
    public static final int NO   = 0; //空
    public static final int MAN  = 1; //男
    public static final int GIRL = 2; //女

    /**
     * config常量池
     */

    public static final int BANK_TYPE = 1; //银行类型

    public static final int CARD_TYPE = 2; //证件类型

    public static final int COMMISSION_TYPE = 3; //提成方式

    public static final int COMPLAINT_TYPE = 4; //投诉方式

    public static final int COMPLAINT_RESOLVE_TYPE = 5; //投诉解决方式

    public static final int CONTRACT_END_REASON = 6; //合同终止原因

    public static final int ENABLED_TYPE = 7;//禁用类型

    public static final int HOUSE_OLD = 8;//房龄

    public static final int HOUSE_TYPE = 9;//住房类型

    public static final int MONEY_TYPE = 10;//货币类型

    public static final int OPEN_TYPE = 11;//开盘方式

    public static final int BUY_TYPE = 12;//置业目的

    public static final int PAY_WAY = 13;//支付方式

    public static final int PROJECT_IMG_TYPE = 14;//项目图片类型

    public static final int PROJECT_TAGS_DEFAULT = 15;//项目标签默认

    public static final int PROPERTY_TYPE = 16;//物业类型

    public static final int BUILD_TYPE = 17;//建筑类型

    public static final int USER_DISABLED_TYPE = 18;//用户失效类型

    public static final int FACE = 19;//朝向

    public static final int LADDER_RATIO = 20;//梯户比

    public static final int DECORATE = 21;//装修标准、

    public static final int AVERAGE = 22;//均价

    public static final int FOLLOW_TYPE = 23;//跟进方式

    public static final int APPEAL_TYPE = 24;//申述类型

    public static final int TOTAL_PRICE = 25;//总价

    public static final int AREA = 26;//面积

    public static final int PAYMENT_FAIL = 27;//佣金结算失败原因


    public static final String REFRESH_CUSTOM_LIST = "refresh_custom_list";




}
