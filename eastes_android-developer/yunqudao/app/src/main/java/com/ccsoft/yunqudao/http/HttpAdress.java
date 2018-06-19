package com.ccsoft.yunqudao.http;

import com.ccsoft.yunqudao.data.AppConstants;

/**
 * Created by lixinke on 2018/5/28.
 */

public class HttpAdress {

    public static String clientList = AppConstants.URL+"agent/client/list";
    public static String captcha = AppConstants.URL+"agent/user/captcha";
    public static String regiest = AppConstants.URL+"agent/user/register";
    public static String login = AppConstants.URL+"agent/user/login";
    public static String getBaseInfo = AppConstants.URL+"agent/personal/getBaseInfo";
    public static String update = AppConstants.URL + "agent/client/update";

    public static String addClientAndNeed = AppConstants.URL + "agent/client/addClientAndNeed";

    public static String waitConfirm = AppConstants.URL+"agent/work/broker/waitConfirm";
    public static String value = AppConstants.URL+"agent/work/broker/value";
    public static String disabled = AppConstants.URL+"agent/work/broker/disabled";

    public static String waitConfirm_project = AppConstants.URL+"agent/work/project/waitConfirm";
    public static String value_project = AppConstants.URL+"agent/work/project/value";
    public static String disabled_project = AppConstants.URL+"agent/work/project/disabled";

    /*房源展示列表*/
    public static String HOUSELIST = AppConstants.URL+"user/project/list?city=510700";
    /*房源项目详情*/
    public static String HOUSEDETAIL = AppConstants.URL+"user/project/detail?project_id=3&agent_id=18";
    /*项目分析*/
    public static String HOUSTANALYSE = AppConstants.URL+"user/houseType/analyse?";
    /*项目规则*/
    public static String HOUSEGETRULENEW = AppConstants.URL+"user/project/getRuleNew?project_id=3&agent_id=18";
    /*快速报备*/
    public static String ADDANDRECOMMEND = AppConstants.URL+"project/client/addAndRecommend";
    /*增加跟进信息*/
    public static String ADDFOLLOW = AppConstants.URL+"agent/client/addFollow";

}
