package com.ccsoft.yunqudao.ui.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.PeizhiBean;
import com.ccsoft.yunqudao.bean.ProjectFastRecommendListBean;
import com.ccsoft.yunqudao.bean.ProjectPiPeiKeHuBean;
import com.ccsoft.yunqudao.data.AppConstants;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.BaseViewHolder;
import com.ccsoft.yunqudao.data.model.response.ResultData;
import com.ccsoft.yunqudao.http.XutilsHttp;
import com.ccsoft.yunqudao.ui.mian.MainActivity;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectFastAdapter extends BaseRecyclerAdapter<ProjectFastRecommendListBean.DataBeanX.DataBean> {
    private int project_id;
    public ProjectFastAdapter(Context context, int layoutId, List<ProjectFastRecommendListBean.DataBeanX.DataBean> data , int project_id) {
        super(context, layoutId, data);
        this.project_id = project_id;
    }

    @Override
    protected void convert(BaseViewHolder holder,ProjectFastRecommendListBean.DataBeanX.DataBean  bean, int position) {
        holder.setText(R.id.tv_name1,bean.getName());
        holder.setText(R.id.tv_zongjia1,bean.getPrice()+"万");
        PeizhiBean peizhiBean = MainActivity.savePeizhi();
        for (PeizhiBean.DataBean._$9Bean.ParamBeanXXXXXXXX bean1 : peizhiBean.getData().get_$9().getParam()) {
            if(!bean.getHouse_type().equals("")) {
                if (bean1.getId() == Integer.parseInt(bean.getHouse_type())) {
                    holder.setText(R.id.tv_huxin1, bean1.getParam());
                }
            }
        }

        if(bean.getRegion().size()>0) {
            holder.setText(R.id.tv_quyu1, bean.getRegion().get(0).getProvince_name() + "-" +
                    bean.getRegion().get(0).getCity_name() + "-" + bean.getRegion().get(0).getDistrict_name());
        }
        holder.setText(R.id.tv_intents1,bean.getIntent()+"");
        holder.setText(R.id.tv_urgency,bean.getUrgency()+"");
        holder.setText(R.id.tv_telnum1,bean.getTel());
        holder.setOnclick(R.id.house_button_推荐1, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               getRecommend(project_id,bean.getNeed_id(),bean.getClient_id());
            }
        });

    }

    private void getRecommend(int project_id,int id,int mClienId ){
        Map<String, String> map = new HashMap<>();
        map.put("project_id", String.valueOf(project_id));
        map.put("client_need_id", String.valueOf(id));
        map.put("client_id", String.valueOf(mClienId));
        XutilsHttp.getInstance().postheader(AppConstants.URL + "agent/client/recommend", map, new XutilsHttp.XCallBack() {
            @Override
            public void onResponse(String result) {
                Gson gson = new Gson();
                ResultData resultData = gson.fromJson(result, ResultData.class);
                if (resultData.code == 200) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle("推荐成功");
                    builder.setMessage(resultData.msg);
                    builder.setNegativeButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();


                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle("推荐失败");
                    builder.setMessage(resultData.msg);
                    builder.setNegativeButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }

            @Override
            public void error(String message) {
                Log.d("666666------》", message);
            }
        });
    }
}
