package com.ccsoft.yunqudao.ui.adapter;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.QiangDanListBean;
import com.ccsoft.yunqudao.bean.StringBean;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.BaseViewHolder;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

public class QiangDanAdapter extends BaseRecyclerAdapter<QiangDanListBean.DataBeanX.DataBean> {

    private int record_id;

    public QiangDanAdapter(Context context, int layoutId, List<QiangDanListBean.DataBeanX.DataBean> data) {
        super(context, layoutId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, QiangDanListBean.DataBeanX.DataBean bean, int position) {
//        holder.setText(R.id.tv_client_id,bean.get);
        holder.setText(R.id.tv_name,bean.getHouse_type());
        holder.setText(R.id.tv_xiaoquname,bean.getProject_name());
        holder.setText(R.id.tv_project_name,bean.getCreate_time());

        record_id = bean.getRecord_id();

        holder.setOnclick(R.id.tv_qiangdan, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getGrabRecord();
            }
        });
    }

    private void getGrabRecord(){
        OkHttpUtils.get(HttpAdress.grabRecord)
                .tag(this)
                .params("record_id",record_id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        StringBean bean = JsonUtil.jsonToEntity(s,StringBean.class);
                        Toast.makeText(context,bean.getMsg(),Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
