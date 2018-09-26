package com.ccsoft.yunqudao.data;

import com.ccsoft.yunqudao.data.base.BaseData;

/**
 * Created by Guoxin on 2018/4/27.
 */

public class RefreshTokenData extends BaseData {

    public Session session;

    public class Session extends BaseData {
        public String osName;
        public String appVersion;
        public long   timestamp;
        public int    type;
        public String deviceId;

        @Override
        public String toString() {
            return "Session{" + "osName='" + osName + '\'' + ", appVersion='" + appVersion + '\'' + ", timestamp=" + timestamp + ", type=" + type + ", deviceId='" + deviceId + '\'' + '}';
        }
    }

    @Override
    public String toString() {
        return "RefreshTokenData{" + "session=" + session + '}';
    }
}
