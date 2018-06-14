package com.ccsoft.yunqudao.data.api;

import com.ccsoft.yunqudao.data.base.BaseData;

/**
 * api异常处理
 *
 * @author YangFan
 * @date 2017-1-17
 */
public class ApiException extends RuntimeException {

    private int      errorCode;
    private String   errorMessage;
    private BaseData data;
    private String   desc;

    public ApiException(BaseData data, int responseState, String desc) {
        this.errorCode = responseState;
        this.errorMessage = this.getErrorMessage(responseState);
        this.data = data;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public BaseData getData() {
        return data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * 获取错误信息
     *
     * @param errorCode
     * @return
     */
    private String getErrorMessage(int errorCode) {
        String errorMessage = ResponseStateMap.getErrorMessage(errorCode);
        if (errorMessage == null) {
            return "未知异常" + "（" + errorCode + "）";
        }
        return errorMessage;
    }
}
