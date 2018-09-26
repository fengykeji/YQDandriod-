package com.ccsoft.yunqudao.data.model.response;

/**
 * @author: Pein
 * @data: 2018/5/16 0016
 */

public class test {

    /**
     * code : 0
     * data : {"verification":{"addition":"string","applier":{"cube":"string","face":"string","lFace":"string","nickname":"string","sFace":"string","spapId":0,"uid":0},"cgId":"string","createTime":0,"from":0,"group":{"face":"string","groupId":"string","groupName":"string"},"groupDestroy":0,"manager":{"dealTime":0,"nickname":"string","uid":0},"receiver":{"cube":"string","face":"string","lFace":"string","nickname":"string","sFace":"string","spapId":0,"uid":0},"status":0,"type":0,"updateTime":0,"vid":0}}
     * desc : string
     */

    private int code;
    private DataBean data;
    private String   desc;

    public int getCode() { return code;}

    public void setCode(int code) { this.code = code;}

    public DataBean getData() { return data;}

    public void setData(DataBean data) { this.data = data;}

    public String getDesc() { return desc;}

    public void setDesc(String desc) { this.desc = desc;}

    public static class DataBean {
        /**
         * verification : {"addition":"string","applier":{"cube":"string","face":"string","lFace":"string","nickname":"string","sFace":"string","spapId":0,"uid":0},"cgId":"string","createTime":0,"from":0,"group":{"face":"string","groupId":"string","groupName":"string"},"groupDestroy":0,"manager":{"dealTime":0,"nickname":"string","uid":0},"receiver":{"cube":"string","face":"string","lFace":"string","nickname":"string","sFace":"string","spapId":0,"uid":0},"status":0,"type":0,"updateTime":0,"vid":0}
         */

        private VerificationBean verification;

        public VerificationBean getVerification() { return verification;}

        public void setVerification(VerificationBean verification) { this.verification = verification;}

        public static class VerificationBean {
            /**
             * addition : string
             * applier : {"cube":"string","face":"string","lFace":"string","nickname":"string","sFace":"string","spapId":0,"uid":0}
             * cgId : string
             * createTime : 0
             * from : 0
             * group : {"face":"string","groupId":"string","groupName":"string"}
             * groupDestroy : 0
             * manager : {"dealTime":0,"nickname":"string","uid":0}
             * receiver : {"cube":"string","face":"string","lFace":"string","nickname":"string","sFace":"string","spapId":0,"uid":0}
             * status : 0
             * type : 0
             * updateTime : 0
             * vid : 0
             */

            private String addition;
            private ApplierBean  applier;
            private String       cgId;
            private int          createTime;
            private int          from;
            private GroupBean    group;
            private int          groupDestroy;
            private ManagerBean  manager;
            private ReceiverBean receiver;
            private int          status;
            private int          type;
            private int          updateTime;
            private int          vid;

            public String getAddition() { return addition;}

            public void setAddition(String addition) { this.addition = addition;}

            public ApplierBean getApplier() { return applier;}

            public void setApplier(ApplierBean applier) { this.applier = applier;}

            public String getCgId() { return cgId;}

            public void setCgId(String cgId) { this.cgId = cgId;}

            public int getCreateTime() { return createTime;}

            public void setCreateTime(int createTime) { this.createTime = createTime;}

            public int getFrom() { return from;}

            public void setFrom(int from) { this.from = from;}

            public GroupBean getGroup() { return group;}

            public void setGroup(GroupBean group) { this.group = group;}

            public int getGroupDestroy() { return groupDestroy;}

            public void setGroupDestroy(int groupDestroy) { this.groupDestroy = groupDestroy;}

            public ManagerBean getManager() { return manager;}

            public void setManager(ManagerBean manager) { this.manager = manager;}

            public ReceiverBean getReceiver() { return receiver;}

            public void setReceiver(ReceiverBean receiver) { this.receiver = receiver;}

            public int getStatus() { return status;}

            public void setStatus(int status) { this.status = status;}

            public int getType() { return type;}

            public void setType(int type) { this.type = type;}

            public int getUpdateTime() { return updateTime;}

            public void setUpdateTime(int updateTime) { this.updateTime = updateTime;}

            public int getVid() { return vid;}

            public void setVid(int vid) { this.vid = vid;}

            public static class ApplierBean {
                /**
                 * cube : string
                 * face : string
                 * lFace : string
                 * nickname : string
                 * sFace : string
                 * spapId : 0
                 * uid : 0
                 */

                private String cube;
                private String face;
                private String lFace;
                private String nickname;
                private String sFace;
                private int    spapId;
                private int    uid;

                public String getCube() { return cube;}

                public void setCube(String cube) { this.cube = cube;}

                public String getFace() { return face;}

                public void setFace(String face) { this.face = face;}

                public String getLFace() { return lFace;}

                public void setLFace(String lFace) { this.lFace = lFace;}

                public String getNickname() { return nickname;}

                public void setNickname(String nickname) { this.nickname = nickname;}

                public String getSFace() { return sFace;}

                public void setSFace(String sFace) { this.sFace = sFace;}

                public int getSpapId() { return spapId;}

                public void setSpapId(int spapId) { this.spapId = spapId;}

                public int getUid() { return uid;}

                public void setUid(int uid) { this.uid = uid;}
            }

            public static class GroupBean {
                /**
                 * face : string
                 * groupId : string
                 * groupName : string
                 */

                private String face;
                private String groupId;
                private String groupName;

                public String getFace() { return face;}

                public void setFace(String face) { this.face = face;}

                public String getGroupId() { return groupId;}

                public void setGroupId(String groupId) { this.groupId = groupId;}

                public String getGroupName() { return groupName;}

                public void setGroupName(String groupName) { this.groupName = groupName;}
            }

            public static class ManagerBean {
                /**
                 * dealTime : 0
                 * nickname : string
                 * uid : 0
                 */

                private int dealTime;
                private String nickname;
                private int    uid;

                public int getDealTime() { return dealTime;}

                public void setDealTime(int dealTime) { this.dealTime = dealTime;}

                public String getNickname() { return nickname;}

                public void setNickname(String nickname) { this.nickname = nickname;}

                public int getUid() { return uid;}

                public void setUid(int uid) { this.uid = uid;}
            }

            public static class ReceiverBean {
                /**
                 * cube : string
                 * face : string
                 * lFace : string
                 * nickname : string
                 * sFace : string
                 * spapId : 0
                 * uid : 0
                 */

                private String cube;
                private String face;
                private String lFace;
                private String nickname;
                private String sFace;
                private int    spapId;
                private int    uid;

                public String getCube() { return cube;}

                public void setCube(String cube) { this.cube = cube;}

                public String getFace() { return face;}

                public void setFace(String face) { this.face = face;}

                public String getLFace() { return lFace;}

                public void setLFace(String lFace) { this.lFace = lFace;}

                public String getNickname() { return nickname;}

                public void setNickname(String nickname) { this.nickname = nickname;}

                public String getSFace() { return sFace;}

                public void setSFace(String sFace) { this.sFace = sFace;}

                public int getSpapId() { return spapId;}

                public void setSpapId(int spapId) { this.spapId = spapId;}

                public int getUid() { return uid;}

                public void setUid(int uid) { this.uid = uid;}
            }
        }
    }
}
