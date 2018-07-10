package com.ccsoft.yunqudao.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.ProjectDanYuanBean;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.BaseViewHolder;
import com.ccsoft.yunqudao.ui.house.ProjectDanYuanActivity;
import com.ccsoft.yunqudao.utils.CustomLinearLayoutManager;

import java.util.List;

public class ProjectDanYuanAdapter extends BaseRecyclerAdapter<ProjectDanYuanBean.DataBean> {
    private ProjectDanYuan1Adapter adapter;

    public ProjectDanYuanAdapter(Context context, int layoutId, List<ProjectDanYuanBean.DataBean> data) {
        super(context, layoutId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, ProjectDanYuanBean.DataBean bean, int position) {
        holder.setText(R.id.tv_loucheng,"F"+bean.getFLOORNUM());
        RecyclerView recyclerView = (RecyclerView) holder.getView(R.id.re_danyuan);

        CustomLinearLayoutManager linearLayoutManager = new CustomLinearLayoutManager(context);
        linearLayoutManager.setScrollEnabled(false);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);


        adapter = new ProjectDanYuan1Adapter(context,R.layout.item_project_danyuan1,bean.getLIST());
        recyclerView.setAdapter(adapter);
        recyclerView.setNestedScrollingEnabled(false);

        adapter.setOnItemClickListner(new OnItemClickListner() {
            @Override
            public void onItemClickListner(View v, int position) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("list",bean.getLIST().get(position));
                Intent intent = new Intent(context, ProjectDanYuanActivity.class);
                intent.putExtras(bundle);
                context.getApplicationContext().startActivity(intent);
            }
        });


    }
}
