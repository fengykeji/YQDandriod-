package com.ccsoft.yunqudao.ui.adapter;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.data.model.response.OpenCityData;
import com.ccsoft.yunqudao.utils.recyclerviwe.BaseRecyclerViewAdapter;
import com.ccsoft.yunqudao.utils.recyclerviwe.BaseRecyclerViewHolder;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

/**
 * author lzx
 * Created on 2018/5/26.
 */

public class OpenCityAdapter extends BaseRecyclerViewAdapter<OpenCityData.DataBean, BaseRecyclerViewHolder> {

    private String mCity;

    public OpenCityAdapter(int layoutResId, List<OpenCityData.DataBean> dataList) {
        super(layoutResId, dataList);
    }

    @Override
    protected void convert(BaseRecyclerViewHolder viewHolder, OpenCityData.DataBean data, int position) {
        TextView mCityTv = viewHolder.getView(R.id.city_tv);
        if (!TextUtils.isEmpty(data.getCity_name())) {
            //附加消息，进过了URI编码，因此用于显示时需要在本地做URI解码
            try {
                mCity = URLDecoder.decode(data.getCity_name(), "UTF-8");

                Log.d("OpenCityAdapter-----》", mCity);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            mCityTv.setText(mCity);
        }
    }
}
