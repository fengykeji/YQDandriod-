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
    public static String HOUSEDETAIL = AppConstants.URL+"user/project/detail";
    /*项目分析*/
    public static String HOUSTANALYSE = AppConstants.URL+"user/houseType/analyse?";
    /*项目规则*/
    public static String HOUSEGETRULENEW = AppConstants.URL+"user/project/getRuleNew?project_id=3&agent_id=18";
    /*项目楼盘信息*/
    public static String BUILDINFO = AppConstants.URL+"user/project/buildInfo";
    /*项目动态列表*/
    public static String DYNAMICLIST = AppConstants.URL+"user/dynamic/list";
    /*关注*/
    public static String focusProject = AppConstants.URL+"agent/personal/focusProject";
    /*取消关注*/
    public static String cancelFocusProject = AppConstants.URL+"agent/personal/cancelFocusProject";
    /*户型具体信息*/
    public static String houseTypedetail = AppConstants.URL+"user/houseType/detail";
    /*匹配客户*/
    public static String matchingproject = AppConstants.URL+"agent/matching/project";
    /*相册图片*/
    public static String imgget = AppConstants.URL+"user/img/get";


    /*快速报备*/
    public static String ADDANDRECOMMEND = AppConstants.URL+"project/client/addAndRecommend";
    /*增加跟进信息*/
    public static String ADDFOLLOW = AppConstants.URL+"agent/client/addFollow";
    /*修改客户需求信息*/
    public static String UPDATANEED = AppConstants.URL+"agent/client/updateNeed";
    /*匹配列表*/
    public static String PIPEI = AppConstants.URL+"agent/matching/client";

    /*工作待成交列表*/
    public static String DEALLIST = AppConstants.URL+"agent/work/project/waitDeal";
    /*工作成交列表*/
    public static String DEALEDLIST = AppConstants.URL+"agent/work/project/deal";
    /*工作未成交列表*/
    public static String NODEALDIST = AppConstants.URL+"agent/work/project/dealDisabled";
    /*经纪人推荐申诉列表*/
    public static String APPEAL = AppConstants.URL+"agent/work/broker/appeal";
    /*报备申诉列表*/
    public static String DISABLE = AppConstants.URL+"agent/work/project/appealList";
    /*成交申诉列表*/
    public static String DEALAPPEALAINLIST = AppConstants.URL+"agent/work/project/dealAppealList";
    /*申诉详情列表*/
    public static String APPEALDETAIL = AppConstants.URL+"agent/work/broker/appealDetail";
    /*信息统计*/
    public static String COUNT = AppConstants.URL+"agent/work/broker/count";
    /*申诉*/
    public static String SHENSU = AppConstants.URL+"agent/client/appeal";
    /*取消申诉*/
    public static String CANCEL = AppConstants.URL+"agent/client/appealCancel";
    /*重新推荐*/
    public static String RECOMMEND = AppConstants.URL+"agent/client/recommend";
    /*确认失效*/
    public static String flushDate = AppConstants.URL+"agent/work/flushDate";

}
