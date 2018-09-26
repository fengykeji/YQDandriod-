package com.ccsoft.yunqudao.data.model.response;

import com.ccsoft.yunqudao.data.base.BaseData;
import com.ccsoft.yunqudao.data.model.viewmodel.MatchListViewModel;
import java.io.Serializable;
import java.security.PublicKey;
import java.util.List;

/**
 * @author: Pein
 * @data: 2018/5/26 0026
 */

public class MatchData extends BaseData implements Serializable {

    public List<MatchListData> matchListDataList;
    public List<RecommendData> recommendData;

    public class MatchListData extends BaseData {

    }

    public class RecommendData extends BaseData {

        public int    current_state;
        public String project_name;
        public int    disabled_state;
        public String state_change_time;

        @Override
        public String toString() {
            return "RecommendData{" + "current_state=" + current_state + ", project_name='" + project_name + '\'' + ", disabled_state=" + disabled_state + ", state_change_time='" + state_change_time + '\'' + '}';
        }
    }
}

