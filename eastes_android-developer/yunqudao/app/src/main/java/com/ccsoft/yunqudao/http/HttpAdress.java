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
    /*获取区域*/
    public static String getDistrictList = AppConstants.URL+"getDistrictList";

    /*工作消息列表*/
    public static String worklist = AppConstants.URL+"agent/message/work/list";
    /*消息已读未读总量*/
    public static String getUnread = AppConstants.URL+"agent/message/getUnread";
    /*消息待确认详情*/
    public static String waitConfirmDetail = AppConstants.URL+"agent/message/work/waitConfirmDetail";
    /*消息报备确认详情*/
    public static String confirmDetail = AppConstants.URL+"agent/message/work/confirmDetail";
    /*消息报备有效*/
    public static String projectValueDetail = AppConstants.URL+"agent/message/work/projectValueDetail";
    /*消息成交*/
    public static String projectDealDetail = AppConstants.URL+"agent/message/work/projectDealDetail";
    /*消息无效*/
    public static String DisabledDetail = AppConstants.URL+"agent/message/work/disabledDetail";
    /*项目消息无效*/
    public static String projectDisabledDetail = AppConstants.URL+"agent/message/work/projectDisabledDetail";
    /*抢单列表*/
    public static String qiangdanList = AppConstants.URL+"agent/house/record/list";
    /*抢单*/
    public static String grabRecord = AppConstants.URL+"agent/house/grabRecord";

    /*房源展示列表*/
    public static String HOUSELIST = AppConstants.URL+"user/project/list";
    /*房源项目详情*/
    public static String HOUSEDETAIL = AppConstants.URL+"user/project/detail";
    /*项目分析*/
    public static String HOUSTANALYSE = AppConstants.URL+"user/houseType/analyse";
    /*项目规则*/
    public static String HOUSEGETRULENEW = AppConstants.URL+"user/project/getRuleNew";
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
    /*开放城市*/
    public static String cityChoose = AppConstants.URL+"user/project/openCity";
    /*客服信息*/
    public static String getInfo = AppConstants.URL+"agent/client/getInfo";
    /*楼栋信息*/
    public static String yunsuanbuild = AppConstants.URL+"user/yunsuan/build";
    /*单元信息*/
    public static String yunsuanunit = AppConstants.URL+"user/yunsuan/unit";
    /*快速推荐*/
    public static String fastRecommendList = AppConstants.URL+"agent/matching/fastRecommendList";
    /*新增推荐客户*/
    public static String addAndRecommend = AppConstants.URL+"project/client/addAndRecommend";


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
    /*经纪人信息统计*/
    public static String COUNT = AppConstants.URL+"agent/work/broker/count";
    /*对接人信息统计*/

    /*申诉*/
    public static String SHENSU = AppConstants.URL+"agent/client/appeal";
    /*取消申诉*/
    public static String CANCEL = AppConstants.URL+"agent/client/appealCancel";
    /*重新推荐*/
    public static String RECOMMEND = AppConstants.URL+"agent/client/recommend";
    /*确认失效*/
    public static String flushDate = AppConstants.URL+"agent/work/flushDate";
    /*工作待确认*/
    public static String workwaitConfirmDetail = AppConstants.URL+"agent/work/broker/waitConfirmDetail";
    /*工作推荐确认中列表*/
    public static String workwaitConfirm = AppConstants.URL+"agent/work/broker/waitConfirm";

    /*对接人工作待确认列表*/
    public static String butterWaitConfirm = AppConstants.URL+"agent/work/butter/waitConfirm";

    /*待抢单列表*/
    public static String waitGrab = AppConstants.URL+"agent/house/survey/waitGrab";
    /*待抢单详情*/
    public static String waitGrabDetail = AppConstants.URL+"agent/house/record/waitGrab/detail";
    /*有效列表*/
    public static String recordValue = AppConstants.URL+"agent/house/record/value";
    /*有效详情*/
    public static String recordValueDetail = AppConstants.URL+"agent/house/record/value/detail";
    /*失效列表*/
    public static String disabledList = AppConstants.URL+"agent/house/record/disabled/list";
    /*无效详情*/
    public static String disabledDetail = AppConstants.URL+"agent/house/record/disabled/detail";
    /*申诉列表*/
    public static String appealList = AppConstants.URL+"agent/house/record/appeal/list";
    /*申诉详情*/
    public static String appealDetail = AppConstants.URL+"agent/house/record/appeal/detail";
    /*勘察待确认列表*/
    public static String surveyWaitConfirm = AppConstants.URL+"agent/house/survey/waitConfirm";
    /*勘察确认有效列表*/
    public static String surveyUnderway = AppConstants.URL+"agent/house/survey/underway";
    /*勘察失效列表*/
    public static String surveyDisabled = AppConstants.URL+"agent/house/survey/disabled";
    /*勘察完成列表*/
    public static String surveyFinish = AppConstants.URL+"agent/house/survey/finish";
    /*勘察待确认详情*/
    public static String surveyWaitConfirmDetail = AppConstants.URL+"agent/house/survey/waitConfirm/detail";
    /*勘察中详情*/
    public static String surveyUnderwayDetail = AppConstants.URL+"agent/house/survey/underway/detail";
    /*勘察失效详情*/
    public static String surveyDisabledDetail = AppConstants.URL+"agent/house/survey/disabled/detail";
    /*勘察完成详情*/
    public static String houseSurveyDetail = AppConstants.URL+"agent/house/survey/detail";
    /*勘察维护列表*/
    public static String surveyList = AppConstants.URL+"agent/house/survey/list";
    /*报备申诉列表*/
    public static String recordAppealList = AppConstants.URL+"agent/house/record/appeal/list";
    /*报备申诉详情*/
    public static String recordAppealDetail = AppConstants.URL+"agent/house/record/appeal/detail";
    /*添加联系人*/
    public static String surveyAddContact = AppConstants.URL+"agent/house/survey/addContact";
    /*添加跟进记录*/
    public static String surveyAddFollow = AppConstants.URL+"agent/house/survey/addFollow";



    /*我的公司认证*/
    public static String getAuthInfo = AppConstants.URL+"agent/personal/getAuthInfo";
    /*公司列表*/
    public static String getCompanyList = AppConstants.URL+"agent/personal/getCompanyList";
    /*提交认证*/
    public static String addAuthInfo = AppConstants.URL+"agent/personal/addAuthInfo";
    /*未接佣金*/
    public static String unPayList = AppConstants.URL+"agent/personal/unPayList";
    /*为结佣金详情*/
    public static String unPayDetail = AppConstants.URL+"agent/personal/unPayDetail";
    /*已结佣金*/
    public static String isPayList = AppConstants.URL+"agent/personal/isPayList";
    /*佣金概况*/
    public static String brokerInfo = AppConstants.URL+"agent/personal/brokerInfo";
    /*个人资料之修改密码*/
    public static String changePassword = AppConstants.URL+"agent/user/changePassword";
    /*工作经历*/
    public static String WorkHis = AppConstants.URL+"agent/personal/WorkHis";
    /*个人修改信息*/
    public static String meupdate = AppConstants.URL+"agent/personal/update";
    /*显示个人信息*/
    public static String megetBaseInfo = AppConstants.URL+"agent/personal/getBaseInfo";
    /*获取关注信息*/
    public static String getFocusProjectList = AppConstants.URL+"agent/personal/getFocusProjectList";
    /*催佣*/
    public static String urge = AppConstants.URL+"agent/personal/urge";
    /*我的团队*/
    public static String myTeamList = AppConstants.URL+"agent/personal/myTeamList";


    /*二手房源列表*/
    public static String secondHouseList = AppConstants.URL+"user/house/house/list";
    /*二手房详情*/
    public static String secondHouseDetail = AppConstants.URL+"user/house/house/detail";
    /*二手房提交报备*/
    public static String secondHouseRecord = AppConstants.URL+"agent/house/record";
    /*二手房小区列表*/
    public static String xiaoquHouseList = AppConstants.URL+"user/house/project/list";
    /*二手房小区详情*/
    public static String xiaoquHouseDetail = AppConstants.URL+"user/house/project/detail";
}
