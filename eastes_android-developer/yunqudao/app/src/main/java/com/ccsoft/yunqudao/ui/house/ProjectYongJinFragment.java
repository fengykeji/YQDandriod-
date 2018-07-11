package com.ccsoft.yunqudao.ui.house;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.ProjectGetRuleBean;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.ui.adapter.ProjectYongjinAdapter;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.ccsoft.yunqudao.utils.OkHttpManager;
import com.ccsoft.yunqudao.utils.SpUtil;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Response;

/**
 * @author: Pein
 * @data: 2018/5/10 0010
 */

public class ProjectYongJinFragment extends Fragment {

    private View mView;
    private ProjectYongJinFragment mProjectYongJinFragment;
    private TextView tv_begintime,tv_yongjinguize,tv_jieyong,tv_daofang,tv_chenjiao;
    private int agent_id;
    private int project_id;
    private RecyclerView recyclerView;
    private ProjectYongjinAdapter adapter;
    private ArrayList<ProjectGetRuleBean.DataBean.PersonBean> dataList = new ArrayList<>();
    private ArrayList<ProjectGetRuleBean.DataBean> list = new ArrayList<>();

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_house_xiangmuxiangqing_yongjin,container,false);
        mProjectYongJinFragment = new ProjectYongJinFragment();
        initView();
        initDta();
        return mView;

    }

    private void initView(){
        tv_begintime = mView.findViewById(R.id.tv_begintime);
        tv_yongjinguize = mView.findViewById(R.id.tv_yongjinguize);
        tv_jieyong = mView.findViewById(R.id.tv_jieyong);
        tv_daofang = mView.findViewById(R.id.tv_daofang);
        tv_chenjiao = mView.findViewById(R.id.tv_chenjiao);
        recyclerView = mView.findViewById(R.id.re_yongjinguize);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        if(dataList!=null) {
            adapter = new ProjectYongjinAdapter(getContext(), R.layout.item_project_yongjin, dataList,list);
            recyclerView.setAdapter(adapter);
        }
    }

    private void initDta() {
        agent_id = SpUtil.getInt("agent_id", 0);
        project_id = getActivity().getIntent().getIntExtra("project_id", 0);

        OkHttpUtils.get(HttpAdress.HOUSEGETRULENEW)
                .tag(getActivity())
                .params("agent_id", agent_id)
                .params("project_id", project_id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        int code = 0 ;
                        String data = null;
                        try {
                            JSONObject jsonObject = new JSONObject(s);
                            code = jsonObject.getInt("code");
                            data = jsonObject.getString("data");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if(code == 200&& data!=null){
                            ProjectGetRuleBean bean = JsonUtil.jsonToEntity(s,ProjectGetRuleBean.class);
                            for (ProjectGetRuleBean.DataBean dataBean : bean.getData()) {
                                if(dataBean.getPerson()!=null) {
                                    dataList.addAll(dataBean.getPerson());
                                }
                            }
                            list.addAll(bean.getData());
                            adapter.notifyDataSetChanged();
                        }
                    }
                });
    }
}
