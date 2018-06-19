package com.ccsoft.yunqudao.ui.customers;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.data.api.ApiSubscriber;
import com.ccsoft.yunqudao.data.model.viewmodel.ClientFollowViewModel;
import com.ccsoft.yunqudao.manager.ClientManager;
import com.ccsoft.yunqudao.rx.RxSchedulers;
import com.ccsoft.yunqudao.model.ClientFollowRecyclerAdapter;
import com.ccsoft.yunqudao.utils.LogUtil;
import java.util.List;

/**
 * @author: Pein
 * @data: 2018/5/14 0014
 */

public class ClientFollowFragment extends Fragment implements View.OnClickListener {

    private View                        mView;
    private ClientFollowFragment        mClientFollowFragment;
    private ImageButton                 mCustomers_button_add_follow;
    private RecyclerView                mCustomers_client_recyclerview;
    private LinearLayoutManager         mLinearLayoutManager;
    private ClientFollowRecyclerAdapter mAdapter;
    private List<ClientFollowViewModel> mList;

    private int id;

    public static ClientFollowFragment newInstance(int id) {
        ClientFollowFragment fragment = new ClientFollowFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("id", id);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_customers_follow, container, false);
        mClientFollowFragment = new ClientFollowFragment();
        id = getArguments().getInt("id");
        initView();
        initListener();
        initData();
        return mView;
    }

    /**
     * 初始化id
     */
    private void initView() {

        this.mCustomers_button_add_follow = mView.findViewById(R.id.customers_button_add_follow);
        this.mCustomers_client_recyclerview = mView.findViewById(R.id.customers_client_recyclerview);
        mCustomers_client_recyclerview.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mAdapter = new ClientFollowRecyclerAdapter(R.layout.item_customers_follow, mList);
        mCustomers_client_recyclerview.setAdapter(mAdapter);
    }

    /**
     * 初始化监听器
     */
    private void initListener() {

        this.mCustomers_button_add_follow.setOnClickListener(this);
    }

    private void initData() {
        ClientManager.getInstance().getClientFollow(id).compose(RxSchedulers.<List<ClientFollowViewModel>>io_main()).subscribe(new ApiSubscriber<List<ClientFollowViewModel>>(getActivity()) {
            @Override
            protected void _onNext(List<ClientFollowViewModel> clientFollowViewModels) {
                if (clientFollowViewModels != null) {
                    mList = clientFollowViewModels;
                    mAdapter.refreshDataList(mList);
                }
            }

            @Override
            protected void _onError(String message) {
                LogUtil.e(message);
            }

            @Override
            protected void _onCompleted() {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.customers_button_add_follow:
                Intent intent = new Intent(getContext(),AddGenJinJiLuActivity.class);
                intent.putExtra("client_id",getActivity().getIntent().getIntExtra("client_id",0));
                startActivity(intent);
//                AddGenJinJiLuActivity.start(getActivity());
        }
    }
}
