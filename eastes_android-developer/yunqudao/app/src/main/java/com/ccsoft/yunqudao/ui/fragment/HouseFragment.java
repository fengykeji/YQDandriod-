package com.ccsoft.yunqudao.ui.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.adapter.HouseList_RecyclerViewAdapter;
import com.ccsoft.yunqudao.bean.CustomersGetInfoBean;
import com.ccsoft.yunqudao.bean.GetDistrictListBean;
import com.ccsoft.yunqudao.bean.HouseListBean;
import com.ccsoft.yunqudao.bean.PeizhiBean;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.data.base.FooterHolder;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.model.ClientListModel;
import com.ccsoft.yunqudao.ui.adapter.HouseListAdapter;
import com.ccsoft.yunqudao.ui.adapter.ScoreTeamAdapter;
import com.ccsoft.yunqudao.ui.adapter.ScoreTeamAdapter1;
import com.ccsoft.yunqudao.ui.adapter.ScoreTeamAdapter2;
import com.ccsoft.yunqudao.ui.adapter.ScoreTeamAdapter3;
import com.ccsoft.yunqudao.ui.adapter.ScoreTeamAdapter4;
import com.ccsoft.yunqudao.ui.customers.CustomersXiangQingActivity;
import com.ccsoft.yunqudao.ui.customers.OpenCityActivity;
import com.ccsoft.yunqudao.ui.house.ProjectCityChooseActivity;
import com.ccsoft.yunqudao.ui.house.ProjectXiangQingActivity;
import com.ccsoft.yunqudao.ui.listener.EndlessRecyclerOnScrollListener;
import com.ccsoft.yunqudao.ui.mian.LoginActivity;
import com.ccsoft.yunqudao.ui.mian.MainActivity;
import com.ccsoft.yunqudao.utils.BaseCallBack;
import com.ccsoft.yunqudao.utils.HideIMEUtil;
import com.ccsoft.yunqudao.utils.ItemsDialogFragment;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.ccsoft.yunqudao.utils.OkHttpManager;
import com.ccsoft.yunqudao.utils.SpUtil;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;
import com.lzy.okhttputils.request.GetRequest;
import com.nex3z.flowlayout.FlowLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;


import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;


import okhttp3.Call;
import okhttp3.Response;

import static android.app.Activity.RESULT_OK;

/**
 * @author: Pein
 * @data: 2018/5/2 0002
 */

public class HouseFragment extends Fragment implements View.OnClickListener ,HouseList_RecyclerViewAdapter.OnItemClickListener,OnRefreshListener {
    /**
     * 房源页面id
     */
    private View           mView;
    private HouseFragment mHouseFragment;
    private RelativeLayout mHouse_button_relativelayout搜索;
    private SmartRefreshLayout mCustomers_swiperefreshlayout;
    private TextView house_text_城市;
    private EditText et_search;
    private RecyclerView   recyclerView;
    private String area = "510100";
    private HouseListBean houseListBeans ;
    private HouseListAdapter adapter;
    private OkHttpManager okHttpManager = OkHttpManager.getInstance();
    private List<HouseListBean.DataBean> list = new ArrayList<>();
    private String city_name = "成都",city_code = 510100+"";
    private TextView content_均价,content_类型,content_区域,content_更多;
    private  GetDistrictListBean  getDistrictListBean;
    private String project_name ;
    private String district ;
    private int verage_price =0;
    private int property_id=0;
    private String search;
    private GetRequest getRequest;
    private AnimationDrawable anim;
    private ImageView yunsuan;
    private int agent_id;

    // 选择二手房和租房

    private TextView choosehousetype;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        /**
         * 填充布局
         */
        mView = inflater.inflate(R.layout.fragment_house, container, false);
        HideIMEUtil.wrap(getActivity());
        mHouseFragment = new HouseFragment();
        Fresco.initialize(getContext());
        initView();
        initListener();
        loadFangyuanList();
        return mView;
    }

    private void initView() {
        /**
         * 初始化控件
         */
        this.mHouse_button_relativelayout搜索 = mView.findViewById(R.id.house_button_relativelayout搜索);
        this.mCustomers_swiperefreshlayout = mView.findViewById(R.id.customers_swiperefreshlayout);
        recyclerView = mView.findViewById(R.id.house_recyclerview_list);
        house_text_城市 = mView.findViewById(R.id.house_text_城市);
        content_均价 = mView.findViewById(R.id.content_均价);
        content_类型 = mView.findViewById(R.id.content_类型);
        content_区域 = mView.findViewById(R.id.content_区域);
        content_更多 = mView.findViewById(R.id.content_更多);
        et_search = mView.findViewById(R.id.et_search);
        yunsuan = mView.findViewById(R.id.yunsuan);
        choosehousetype = mView.findViewById(R.id.house_text_housetype);
        yunsuan.setImageResource(R.drawable.animation_refresh);
        anim = (AnimationDrawable) yunsuan.getDrawable();

        agent_id = SpUtil.getInt("agent_id",0);
        if( getActivity().getIntent().getStringExtra("city_name")!=null) {
            city_name = getActivity().getIntent().getStringExtra("city_name");
            city_code = getActivity().getIntent().getStringExtra("city_code");
        }
        house_text_城市.setText(city_name);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new HouseListAdapter(getContext(),R.layout.house_list_activity, list);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(endlessRecyclerOnScrollListener);
    }

    private void initListener() {

        this.mHouse_button_relativelayout搜索.setOnClickListener(this);
        house_text_城市.setOnClickListener(this);
        content_均价.setOnClickListener(this);
        content_类型.setOnClickListener(this);
        content_区域.setOnClickListener(this);
        content_更多.setOnClickListener(this);
        this.mCustomers_swiperefreshlayout.setOnRefreshListener(this);
        choosehousetype.setOnClickListener(this);

        adapter.setOnItemClickListner(new BaseRecyclerAdapter.OnItemClickListner() {
            @Override
            public void onItemClickListner(View v, int position) {
                Intent intent = new Intent(getContext(),ProjectXiangQingActivity.class);
                intent.putExtra("project_id",houseListBeans.getData().get(position).getProject_id());
                intent.putExtra("Cycle",houseListBeans.getData().get(position).getCycle());
                intent.putExtra("brokerage",houseListBeans.getData().get(position).getGuarantee_brokerage());
                startActivity(intent);
            }
        });

        et_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(TextUtils.isEmpty(s)){
                    search = null;
                }else{
                    search = s.toString();
                }
                loadFangyuanList();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.house_button_relativelayout搜索:
                Toast.makeText(getActivity(), "你点击了搜索", Toast.LENGTH_SHORT).show();
                break;
            case R.id.house_text_城市:
                Intent intent = new Intent(getContext(), OpenCityActivity.class);
                intent.putExtra("id",1);
                startActivity(intent);
                break;
            case R.id.content_均价:
                showPopupWindow();
                backgroundAlpha((float) 0.5);
                break;
            case R.id.content_类型:
                showPopupWindow1();
                backgroundAlpha((float) 0.5);
                break;
            case R.id.content_区域:
                showPopupWindow2();
                backgroundAlpha((float) 0.5);
                break;
            case R.id.content_更多:
                showPopupWindow3();
                backgroundAlpha((float) 0.5);
                break;
            case R.id.house_text_housetype:
                showItemsDialogFragment();
                break;
        }
    }

    private void loadFangyuanList(){

         getRequest = OkHttpUtils.get(HttpAdress.HOUSELIST)
                .tag(this)
                .params("city",city_code)
                 .params("agent_id",agent_id)
//                .params("project_name",project_name)
//                .params("district",district)
//                .params("verage_price",verage_price)
//                .params("property_id",property_id)
                .params("page", 1);

        if (search != null) {
            getRequest.params("project_name", search);
        }
        if(district!=null&&!district.equals("区域")&&!district.equals("不限")){

            getRequest.params("district",district);
        }
        if(verage_price!=0){

            getRequest.params("average_price",verage_price);
        }
        if(property_id!=0){

            getRequest.params("property_id",property_id);
        }
        getRequest.execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        houseListBeans = JsonUtil.jsonToEntity(s,HouseListBean.class);
                        if(houseListBeans.getCode() == 200){
                            totalPage = houseListBeans.getData().size();
                            curPage = 2;
                            list.clear();
                            list.addAll(houseListBeans.getData()) ;
                            adapter.notifyDataSetChanged();
                        }
                        else if(houseListBeans.getCode() == 401){
                          Intent intent = new Intent(getContext(), LoginActivity.class);
                          startActivity(intent);
                          Toast.makeText(getContext(),"token失效，请重新登陆",Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onAfter(@Nullable String s, @Nullable Exception e) {
                        super.onAfter(s, e);

                    }
                });

    }

    @Override
    public void setItemClick(View view, int position) {

    }



    private EndlessRecyclerOnScrollListener endlessRecyclerOnScrollListener = new EndlessRecyclerOnScrollListener() {
        @Override
        public void onLoadNextPage(View view) {
            if (adapter.footerHolder == null || adapter.footerHolder.getmState() == FooterHolder.KEY_LOADING) {
                return;
            }
            if (curPage < totalPage) {
                adapter.footerHolder.setData(FooterHolder.KEY_LOADING);
                loadNextData();
            } else {
                adapter.footerHolder.setData(FooterHolder.KEY_END);
            }

        }
    };

    int curPage;
    int totalPage=100;

    private void loadNextData() {
        GetRequest getRequest = OkHttpUtils.get(HttpAdress.HOUSELIST)
                .tag(getActivity())
                .params("page", curPage);

        if (search != null) {
            getRequest.params("search", search);
        }
        getRequest.execute(new StringCallback() {
            @Override
            public void onSuccess(String s, Call call, Response response) {
                int code = 0;
                String data = null;
                try {
                    JSONObject jsonObject = new JSONObject(s);
                    code = jsonObject.getInt("code");
                    data = jsonObject.getString("data");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (code == 200 && data != null) {
                    curPage++;
                    houseListBeans = JsonUtil.jsonToEntity(s,HouseListBean.class);
                    list.addAll(houseListBeans.getData());
                    adapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onAfter(@Nullable String s, @Nullable Exception e) {
                super.onAfter(s, e);
                adapter.footerHolder.setData(FooterHolder.KEY_NORMAL);
            }
        });
    }


    public void showItemsDialogFragment() {
        ItemsDialogFragment itemsDialogFragment = new ItemsDialogFragment();
        String[] items = {"新房", "二手房","租房","取消" };
        itemsDialogFragment.show("", items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case 0:

                        break;
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:
                        itemsDialogFragment.dismiss();
                        break;

                }
            }
        }, getFragmentManager());
    }

    private void showPopupWindow() {
        PeizhiBean peizhiBean = MainActivity.savePeizhi();

        View view = LayoutInflater.from(getContext()).inflate(R.layout.popupwindow,null);
        TextView textView = view.findViewById(R.id.tv_fist);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.select);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        ScoreTeamAdapter1 scoreTeamAdapter = new ScoreTeamAdapter1(getContext(),R.layout.item_woye_activity,peizhiBean.getData().get_$22().getParam());
        recyclerView.setAdapter(scoreTeamAdapter);
        PopupWindow popupWindow = new PopupWindow(ViewGroup.LayoutParams.MATCH_PARENT, 600);
        popupWindow.setContentView(view);
        popupWindow.setFocusable(true);
        popupWindow.showAsDropDown(content_均价);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                content_均价.setText("不限");
                verage_price = 0;
                backgroundAlpha(1);
                popupWindow.dismiss();
                loadFangyuanList();
            }
        });

        scoreTeamAdapter.setOnItemClickListner(new BaseRecyclerAdapter.OnItemClickListner() {
            @Override
            public void onItemClickListner(View v, int position) {
                content_均价.setText(peizhiBean.getData().get_$22().getParam().get(position).getParam());
                verage_price =peizhiBean.getData().get_$22().getParam().get(position).getId();
                backgroundAlpha(1);
                popupWindow.dismiss();
                loadFangyuanList();
            }
        });
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1);
            }
        });
    }

    private void showPopupWindow1() {
        PeizhiBean peizhiBean = MainActivity.savePeizhi();

        View view = LayoutInflater.from(getContext()).inflate(R.layout.popupwindow,null);
        TextView textView = view.findViewById(R.id.tv_fist);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.select);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        ScoreTeamAdapter scoreTeamAdapter = new ScoreTeamAdapter(getContext(),R.layout.item_woye_activity,peizhiBean.getData().get_$16().getParam());
        recyclerView.setAdapter(scoreTeamAdapter);
        PopupWindow popupWindow = new PopupWindow(ViewGroup.LayoutParams.MATCH_PARENT, 600);
        popupWindow.setContentView(view);
        popupWindow.setFocusable(true);
        popupWindow.showAsDropDown(content_类型);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                content_类型.setText("不限");
                property_id = 0;
                backgroundAlpha(1);
                popupWindow.dismiss();
                loadFangyuanList();
            }
        });

        scoreTeamAdapter.setOnItemClickListner(new BaseRecyclerAdapter.OnItemClickListner() {
            @Override
            public void onItemClickListner(View v, int position) {
                content_类型.setText(peizhiBean.getData().get_$16().getParam().get(position).getParam());
                property_id = peizhiBean.getData().get_$16().getParam().get(position).getId();
                backgroundAlpha(1);
                popupWindow.dismiss();
                loadFangyuanList();
            }
        });
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1);
            }
        });
    }

    private void showPopupWindow2() {
        OkHttpManager.getInstance().get(HttpAdress.getDistrictList+"?cityCode="+city_code, new BaseCallBack() {
            @Override
            public void onSuccess(Call call, Response response, Object obj) throws MalformedURLException {
                Type type = new TypeToken<GetDistrictListBean>() {}.getType();
                getDistrictListBean= new Gson().fromJson(obj.toString(),type);
                if(getDistrictListBean.getCode() == 200){
                    View view = LayoutInflater.from(getContext()).inflate(R.layout.popupwindow,null);
                    TextView textView = view.findViewById(R.id.tv_fist);

                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.select);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                    linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    ScoreTeamAdapter2 scoreTeamAdapter = new ScoreTeamAdapter2(getContext(),R.layout.item_woye_activity,getDistrictListBean.getData());
                    recyclerView.setAdapter(scoreTeamAdapter);
                    PopupWindow popupWindow = new PopupWindow(ViewGroup.LayoutParams.MATCH_PARENT, 600);
                    popupWindow.setContentView(view);
                    popupWindow.setFocusable(true);
                    popupWindow.showAsDropDown(content_类型);

                    textView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            content_区域.setText("不限");
                            district = content_区域.getText().toString();
                            backgroundAlpha(1);
                            popupWindow.dismiss();
                            loadFangyuanList();
                        }
                    });

                    scoreTeamAdapter.setOnItemClickListner(new BaseRecyclerAdapter.OnItemClickListner() {
                        @Override
                        public void onItemClickListner(View v, int position) {
                            content_区域.setText(getDistrictListBean.getData().get(position).getName());
                            district = getDistrictListBean.getData().get(position).getCode();
                            backgroundAlpha(1);
                            popupWindow.dismiss();
                            loadFangyuanList();
                        }
                    });

                    popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                        @Override
                        public void onDismiss() {
                            backgroundAlpha(1);
                        }
                    });
                }

            }

            @Override
            public void onFailure(Call call, Exception e) {

            }

            @Override
            public void onError(Response response, int errorCode) {

            }

            @Override
            public void onRequestBefore() {

            }
        });
    }

    boolean flag = true;

    private void showPopupWindow3() {
        PeizhiBean peizhiBean = MainActivity.savePeizhi();
        List<PeizhiBean.DataBean._$15Bean.ParamBeanXXXXXXXXXXXXXX> datalist = peizhiBean.getData().get_$15().getParam();

        View view = LayoutInflater.from(getContext()).inflate(R.layout.popuwindowmore,null);
        RecyclerView recyclerView =  view.findViewById(R.id.tese);
        RecyclerView recyclerView1 =  view.findViewById(R.id.fangxing);
        TextView textView = view.findViewById(R.id.sure);

//        FlowLayout flowLayout = view.findViewById(R.id.flow);

//        for (int i = 0; i < peizhiBean.getData().get_$15().getParam().size(); i++) {
//            TextView textView = buildLabel(peizhiBean.getData().get_$15().getParam().get(i).getParam());
//            flowLayout.addView(textView);
//        }
        

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),4));
        recyclerView1.setLayoutManager(new GridLayoutManager(getContext(),4));


        ScoreTeamAdapter3 scoreTeamAdapter = new ScoreTeamAdapter3(getContext(),R.layout.item_more_activity,datalist);
        recyclerView.setAdapter(scoreTeamAdapter);
        recyclerView.setNestedScrollingEnabled(false);

        ScoreTeamAdapter4 scoreTeamAdapter1 = new ScoreTeamAdapter4(getContext(),R.layout.item_more_activity,peizhiBean.getData().get_$9().getParam());
        recyclerView1.setAdapter(scoreTeamAdapter1);
        recyclerView1.setNestedScrollingEnabled(false);

        PopupWindow popupWindow = new PopupWindow(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setContentView(view);
        popupWindow.setFocusable(true);
        popupWindow.showAsDropDown(content_更多);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backgroundAlpha(0);
                popupWindow.dismiss();
            }
        });

        scoreTeamAdapter.setOnItemClickListner(new BaseRecyclerAdapter.OnItemClickListner() {
            @Override
            public void onItemClickListner(View v, int position) {
                TextView checkBox = v.findViewById(R.id.biaoqian);
               checkBox.setBackgroundResource(R.color.liji_material_blue_500);
                scoreTeamAdapter.notifyDataSetChanged();

            }
        });

        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1);
            }
        });
    }

    private TextView buildLabel(final String text) {
        TextView textView = new TextView(getContext());
        textView.setText(text);
        textView.setMaxEms(12);
        textView.setMaxLines(1);
        textView.setWidth(230);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);
        textView.setPadding((int) dpToPx(16), (int) dpToPx(8), (int) dpToPx(16), (int) dpToPx(8));
        textView.setBackgroundResource(R.color.gray);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setBackgroundResource(R.color.liji_material_blue_500);
                int c  = getResources().getColor(R.color.white);
                textView.setTextColor(c);
            }
        });
        return textView;
    }
    private float dpToPx(float dp) {
        return TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, dp, getResources().getDisplayMetrics());
    }

    /**
     * 下拉刷新
     */

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        loadFangyuanList();
        anim.start();
        mCustomers_swiperefreshlayout.finishRefresh(900);
    }

    /**
     * 设置屏幕背景
     * @param bgAlpha
     */
    public void backgroundAlpha(float bgAlpha)  //阴影改变
    {
        WindowManager.LayoutParams lp =getActivity().getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        getActivity().getWindow().setAttributes(lp);
    }
}
