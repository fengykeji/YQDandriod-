package com.ccsoft.yunqudao.ui.me;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.StringBean;
import com.ccsoft.yunqudao.data.AppConstants;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.ccsoft.yunqudao.utils.QRCode;
import com.ccsoft.yunqudao.utils.ZXingUtils;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import cn.sharesdk.onekeyshare.OnekeyShare;
import okhttp3.Call;
import okhttp3.Response;

public class YaoQingErWeiMaActivity extends AppCompatActivity {

    private ImageButton me_button_返回;
    private Button me_button_二维码分享;
    private String url;
    private ImageView mMe_image_二维码;
    private String name ;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yaoqingerweima);
        initView();
        getUrl();
//        initData();
//        initListener();
    }

    private void initView(){
        me_button_返回 = findViewById(R.id.me_button_返回);
        me_button_二维码分享 = findViewById(R.id.me_button_二维码分享);
        mMe_image_二维码 = findViewById(R.id.me_image_二维码);


        name = getIntent().getStringExtra("name");

        me_button_返回.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        me_button_二维码分享.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showShare();
            }
        });
    }



    private void showShare() {
        OnekeyShare oks = new OnekeyShare();
//关闭sso授权
        oks.disableSSOWhenAuthorize();

        oks.setUrl(AppConstants.URL+url);
// title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间等使用
        oks.setTitle(name+"邀请你加入他的团队");
// titleUrl是标题的网络链接，QQ和QQ空间等使用
        oks.setTitleUrl(AppConstants.URL+url);
// text是分享文本，所有平台都需要这个字段
        oks.setText("加入云渠道，享受便捷佣金赚取之道");
// imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
//oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
// url仅在微信（包括好友和朋友圈）中使用
        oks.setImageUrl(AppConstants.URL+"assets/img/logo.jpg");
// comment是我对这条分享的评论，仅在人人网和QQ空间使用
//        oks.setComment("我是测试评论文本");
// site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(getString(R.string.app_name));
// siteUrl是分享此内容的网站地址，仅在QQ空间使用
//        oks.setSiteUrl("http://sharesdk.cn");

// 启动分享GUI
        oks.show(this);
    }


    /**
     * 获取分享链接
     */
    private void getUrl(){
        OkHttpUtils.get(AppConstants.URL+"agent/personal/joinAgentTeam")
                .tag(this)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        StringBean bean = JsonUtil.jsonToEntity(s,StringBean.class);
                        if(bean.getCode() == 200){
                            url = bean.getData().toString();

                            String content = AppConstants.URL+url;
//                            Bitmap bitmap = ZXingUtils.createQRImage(content, 400, 400);
                            Bitmap bitmap = QRCode.createQRCodeWithLogo(content, 800,
                                    BitmapFactory.decodeResource(getResources(), R.drawable.ic_logo));
                            mMe_image_二维码.setImageBitmap(bitmap);
                        }
                    }
                });
    }
}
