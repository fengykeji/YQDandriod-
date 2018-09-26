package com.ccsoft.yunqudao.data.api;

/**
 * 服务器响应状态
 *
 * @author YangFan
 * @date 2017-1-17
 */
public enum ResponseState {

    Unknown(0, "发送错误"),
    RequestFailed(100, "请求失败"),
    NoData(101, "无数据"),
    VerificationCodeFailed(102, "验证码失效"),
    Ok(200, "成功"),
    RequestHandling(202, "请求被处理，请等待"),
    ReceivedRequestNotReturnData(204, "已接收到请求，不需要返回数据"),
    RequestInvalid(400, "请求无效"),
    UnauthorizedRequest(401, "未授权的请求"),
    PaymentRequest(402, "支付请求"),
    UnableIdentifyRequest(403, "服务器无法识别的请求"),
    NotFoundURI(404, "服务器没有找到对应的请求URI"),
    MethodNotAllowedPerform(405, "请求指定的方法服务器不允许执行"),
    AccessContentNotAuthorized(406, "访问内容不被授权"),
    AgentNeedAuthorization(407, "代理需要授权"),
    PeerOffline(408, "对端离线，请求超时"),
    ConflictRequest(409, "有冲突的请求"),
    ParametersOfTheAbnormal(410, "网关错误"),
    LoadDataTooLong(413, "负载数据过长"),
    UnsupportedMediaType(415, "不支持的媒体类型"),
    JointFailure(417, "连接失效"),
    AccessFrequencyOverLimit(429, "访问频率超过限制"),
    TemporarilyUnavailable(480, "暂时不可用"),
    ServerError(500, "服务器内部错误"),
    GatewayTimeout(504, "网关超时"),
    InvalidParameter(704, "无效的参数"),
    ParameterMissing(705, "参数缺失"),
    IllegalParameter(706, "非法参数，如：大小、长度、类型不正确"),
    PagingInformationError(707, "分页信息错误"),
    TokenInvalid(800, "token已失效"),
    IncorrectState(801, "不正确的状态"),
    ContentLengthCrossBorder(810, "内容长度越界"),
    FileSizeOverLimit(811, "文件大小超过限制"),
    FormatError(812, "格式错误"),
    ContentError(813, "内容错误"),
    UploadFileFailed(823, "上传文件失败"),
    HandleFileFailed(825, "处理文件失败"),
    FileLoadingFailed(828, "文件加载失败"),
    LoginAccountAuthorizationError(1001, "登录账号授权错误"),
    LoginTimeout(1002, "登录超时"),
    AuthorizationExpire(1003, "授权过期"),
    MobileFormatError(10001, "账号或密码错误"),
    MobileRegistered(10002, "手机号已注册"),
    MessageVerificationCodeInputError(10003, "验证码错误"),
    EmailFormatError(10004, "邮箱格式错误"),
    EmailRegistered(10005, "邮箱已注册"),
    UsernameOrPasswordError(10006, "账号或密码输入有误"),
    EmailInactive(10007, "邮箱未激活"),
    AccountNotExistError(10008, "账号不存在"),
    VerificationCodeSentOften(10009, "验证码发送太频繁"),
    UnboundedEmail(10010, "未绑定邮箱"),
    UnboundedMobile(10011, "未绑定手机号"),
    BindingEmail(10012, "已绑定邮箱"),
    QrCodeExpired(10013, "二维码已过期"),
    GetQrCodePlatError(10014, "获取二维码平台值错误"),
    GetLicenseError(10018, "获取license失败"),
    FriendAddFailed(10201, "好友添加失败"),
    FriendExisted(10202, "好友已存在"),
    FriendNotExist(10203, "好友不存在"),
    FriendDeleteFailed(10204, "好友删除失败"),
    FriendBatchDeleteFailed(10205, "好友批量删除失败"),
    FriendRenameFailed(10206, "好友重命名失败"),
    FriendQueryFailed(10207, "好友查询失败"),
    FriendBatchQueryFailed(10208, "批量查询好友失败"),
    CategoryCreateFailed(10209, "分组创建失败"),
    CategoryExisted(10210, "分组已存在"),
    CategoryNotExist(10211, "分组不存在"),
    CategoryDeleteFailed(10212, "分组删除失败"),
    CategoryQueryFailed(10213, "分组查询失败"),
    CategoryFriendQueryFailed(10214, "分组好友查询失败"),
    CategoryRenameFailed(10215, "分组重命名失败"),
    RemoveFriendToCategoryFailed(10216, "移动好友至指定分组失败"),
    FriendNotExistCategory(10217, "好友不存在"),
    QueryFriendIDListFailed(10218, "查询好友ID列表失败"),
    NotAddMyselfFriend(10219, "不能添加自己为好友"),
    CategoryDefaultNotUpdate(10220, "默认分组名不可修改"),
    CategoryDefaultNotDelete(10221, "默认分组不可删除"),
    CategoryNameHasExist(10222, "分组名已存在"),
    FriendApplyAddFailed(10250, "好友申请添加失败"),
    FriendApplyQueryFailed1(10251, "好友申请记录查询失败"),
    FriendApplyQueryFailed2(10252, "好友申请单个记录查询失败"),
    FriendApplyNoHandleQueryFailed(10253, "好友申请未处理数量查询失败"),
    FriendApplyHandleFailed(10254, "好友申请处理他人请求失败"),
    FriendApplyDeleteFailed(10255, "申请记录删除失败"),
    FriendApplyClearFailed(10256, "好友申请清空失败"),
    FriendApplyEmpty(10257, " 没有好友申请记录"),
    UserIsNotFound(10258, " 该用户不存在"),
    FriendApplyHandled(10259, "好友申请已处理"),
    NotApplyMyself(10260, "不能自己申请自己"),
    UserFeedbackAddFailed(10270, "用户意见反馈添加失败"),
    GroupDisband(10266, "群已经解散"),
    NoPermissionOperationGroup(10401, "无权限操作群"),
    GroupExistEd(10402, "群已存在"),
    DeleteGroupFailed(10403, "删除群组失败"),
    GroupUpdateFailed(10404, "群信息更新失败"),
    ExitGroupFailed(10405, "退出群失败"),
    TransferGroupFailed(10406, "转让群失败"),
    GroupManagerAddFailed(10407, "管理员添加失败"),
    GroupManagerDeleteFailed(10408, "管理员删除失败"),
    GroupManagerExisted(10409, "管理员已存在"),
    GroupMemberAddFailed(10410, "群成员添加失败"),
    GroupMemberDeleteFailed(10411, "群成员删除失败"),
    GroupMemberExisted(10412, "群成员已存在"),
    GroupNoticeUpdateFailed(10413, "公告更新失败"),
    GroupCreateFailed(10414, "群创建失败 "),
    NotFoundGroup(10415, "查无此群"),
    NotFoundGroupMember(10416, "查无群成员"),
    GroupManagerExceedsMaximumNumber(10417, "管理员已达10人上限"),
    GroupMemberConfigurationUpdateFailed(10418, "群成员配置更新失败"),
    GroupMasterAliasUpdateFailed(10419, "修改群主别名失败"),
    GroupManagerNotExist(10420, "群组管理员和群主不存在"),
    ImportContactFailed(10601, "导入联系人失败"),
    QueryContactListFailed(10602, "查询联系人列表失败 "),
    QueryContactIDListFailed(10603, "查询联系人id列表失败"),
    QueryContactFailedByID(10604, "根据id列表查询联系人信息失败"),
    DeleteContactFailed(10605, "删除联系人失败"),
    ContactMobileError(10606, "手机号格式错误"),
    DeleteContactNotExist(10607, "删除的联系人不存在"),
    ContactNotExist(10608, "联系人不存在"),
    UpdateContactRemarkFailed(10609, "修改联系人备注失败"),
    AddContactFailed(10610, "添加联系人失败"),
    ContactExisted(10611, "联系人已经存在"),
    NotAddMyselfContact(10612, "不能添加自己为联系人"),
    ReportUserOrGroupFailed(11001, "举报用户或群组失败"),
    CreateDisturbSettingFailed(11002, "创建免打扰设置失败"),
    GetDisturbSettingFailed(11003, "获取免打扰设置失败"),
    UploadReportImageFailed(11004, "上传举报图片失败"),
    TwoPasswordsNotMatch(11201, "两次密码不一致"),
    EmailRetrievePasswordLinkInvalid(11202, "邮箱找回密码链接无效"),
    EmailRetrievePasswordFailed(11203, "邮箱找回密码失败"),
    MobileRetrievePasswordFailed(11204, "手机号找回密码失败"),
    RetrievePasswordSentEmailFailed(11205, "找回密码发送邮件失败"),
    RetrievePasswordSentVerificationCodeFailed(11206, "找回密码发送验证码失败"),
    UpdatePasswordFailed(11207, "修改密码失败"),
    VerificationCodeRetrievePasswordFailed(11208, "验证找回密码验证码失败"),
    ValidateOldPasswordFailed(11209, "验证旧密码失败"),
    AccountNotExist(11210, "账号不存在"),
    EmailActivated(11301, "邮箱已经激活"),
    EmailActiveLinkInvalid(11302, "邮箱激活链接无效"),
    EmailActiveFailed(11303, "邮箱激活失败"),
    FileIsNotExist(11604, "文件不存在"),
    FrequentSendSMS(11801, "验证码发送太频繁"),
    DatedSMS(10019, "验证码已过期"),
    InviteAssignNumberFailed(14000, "邀请分配号码失败"),
    InviteOften(14001, "邀请太频繁"),
    InviteLinkInvalid(14002, "邀请链接无效"),
    InviteLinkExpired(14003, "邀请链接已过期"),
    UserInfoNonentity(10020,"用户信息不存在"),
    EngineNonentity(814,"引擎错误"),
    UnknownError(11708,"未知异常");

    public int state;
    public String message;

    ResponseState(int state, String message) {
        this.state = state;
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
