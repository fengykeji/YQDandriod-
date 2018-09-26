package com.ccsoft.yunqudao.ui.adapter;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.PayListBean;
import com.ccsoft.yunqudao.bean.StringBean;
import com.ccsoft.yunqudao.bean.UnPlayListBean;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.BaseViewHolder;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.ui.me.WeiJieYongJinXiangQingActivity;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

public class UnPlayListAdapter extends BaseRecyclerAdapter<UnPlayListBean.DataBeanX.DataBean> {
    public UnPlayListAdapter(Context context, int layoutId, List<UnPlayListBean.DataBeanX.DataBean> data) {
        super(context, layoutId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, UnPlayListBean.DataBeanX.DataBean bean, int position) {
        holder.setText(R.id.tv_title,bean.getName());
        holder.setText(R.id.tv_tel,bean.getTel());
        holder.setText(R.id.tv_project_name,bean.getProject_name());
        holder.setText(R.id.tv_client_id,bean.getClient_id()+"");
        holder.setText(R.id.tv_name,bean.getBroker_type());
        holder.setText(R.id.tv_time,bean.getCreate_time());
        if(bean.getType()==2){
            holder.setText(R.id.tv_money,bean.getBroker_num()+"");
        }else {
            holder.setText(R.id.tv_money,"");
            holder.setVisible(R.id.tv_cuiyong, View.GONE);
        }

        holder.setOnclick(R.id.tv_cuiyong, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OkHttpUtils.post(HttpAdress.urge)
                        .tag(this)
                        .params("broker_id",bean.getBroker_id())
                        .execute(new StringCallback() {
                            @Override
                            public void onSuccess(String s, Call call, Response response) {
                                StringBean model = JsonUtil.jsonToEntity(s,StringBean.class);
                                Toast.makeText(context,model.getMsg(),Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

    }

}
