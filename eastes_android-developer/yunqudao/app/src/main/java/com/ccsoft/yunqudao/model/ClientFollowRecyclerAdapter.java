package com.ccsoft.yunqudao.model;

import android.widget.TextView;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.data.model.viewmodel.ClientFollowViewModel;
import com.ccsoft.yunqudao.utils.recyclerviwe.BaseRecyclerViewAdapter;
import com.ccsoft.yunqudao.utils.recyclerviwe.BaseRecyclerViewHolder;
import java.util.List;

/**
 * @author: Pein
 * @data: 2018/5/26 0026
 */

public class ClientFollowRecyclerAdapter extends BaseRecyclerViewAdapter<ClientFollowViewModel, BaseRecyclerViewHolder> {

    public ClientFollowRecyclerAdapter(int layoutResId, List<ClientFollowViewModel> dataList) {
        super(layoutResId, dataList);
    }

    @Override
    protected void convert(BaseRecyclerViewHolder viewHolder, ClientFollowViewModel data, int position) {


        TextView mCustomers_follow_type = viewHolder.getView(R.id.customers_follow_type);
        TextView mCustomers_follow_intent = viewHolder.getView(R.id.customers_follow_intent);
        TextView mCustomers_follow_urgency = viewHolder.getView(R.id.customers_follow_urgency);
        TextView mFollow_text = viewHolder.getView(R.id.follow_text);
        TextView mFollow_time = viewHolder.getView(R.id.follow_time);

        //mCustomers_follow_type.setText(String.valueOf(data.follow_type));

        setPropertyType(data.follow_type,mCustomers_follow_type);
        mCustomers_follow_intent.setText(String.valueOf(data.intent));
        mCustomers_follow_urgency.setText(String.valueOf(data.urgency));
        mFollow_text.setText(data.comment);
        mFollow_time.setText(data.follow_time);

    }



    private void setPropertyType(int type, TextView textView) {
            switch (type) {
                case 86:
                    textView.setText("电话");
                    break;
                case 87:
                    textView.setText("QQ");
                    break;
                case 88:
                    textView.setText("微信");
                    break;
                case 89:
                    textView.setText("面谈");
                    break;
                case 90:
                    textView.setText("其他");
                    break;
            }
        }
    }

