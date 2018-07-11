package com.ccsoft.yunqudao.ui.me;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.GongSiRenZhengBean;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.model.StringModel;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.DateUtil;
import com.ccsoft.yunqudao.utils.ItemsDialogFragment;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.ccsoft.yunqudao.utils.wheelview.TimePickerView;
import com.lljjcoder.citypickerview.widget.CityPicker;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import okhttp3.Call;
import okhttp3.Response;

public class GongSiRenZheng1Activity extends AppCompatActivity implements View.OnClickListener{

    private Button button_nex;
    private TextView tv_company,tv_tuzhitime;
    private EditText et_suoshubumen,et_zhiwei,et_gonghao;
    private ImageButton me_button_返回;
    private LinearLayout ll_compamy;
    private String companyname;
    private int companyId  = 0;
    private RelativeLayout ll_timeshow;


    private ImageView mImage;

    private String icon = "上传地址";

    //相册请求码
    private static final int ALBUM_REQUEST_CODE = 1;
    //相机请求码
    private static final int CAMERA_REQUEST_CODE = 2;
    //剪裁请求码
    private static final int CROP_REQUEST_CODE = 3;

    //调用照相机返回图片文件
    private File tempFile;


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.gongsirenzheng1_activity);
        initView();
        initlistener();
        initData();
    }

    private void initView(){

        me_button_返回 = findViewById(R.id.me_button_返回);
        button_nex = findViewById(R.id.button_next);
        tv_company = findViewById(R.id.tv_company);
        tv_tuzhitime = findViewById(R.id.tv_tuzhitime);
        et_suoshubumen = findViewById(R.id.et_suoshubumen);
        et_zhiwei = findViewById(R.id.et_zhiwei);
        mImage = findViewById(R.id.ib_photo);
        ll_compamy = findViewById(R.id.ll_company);
        et_gonghao = findViewById(R.id.et_gonghao);
        ll_timeshow = findViewById(R.id.ll_timeshow);

        companyname = getIntent().getStringExtra("companyname");
        companyId = getIntent().getIntExtra("companyId",0);
        tv_company.setText(companyname);




    }

    private void initlistener(){
        me_button_返回.setOnClickListener(this);
        button_nex.setOnClickListener(this);
        tv_tuzhitime.setOnClickListener(this);
        mImage.setOnClickListener(this);
        ll_compamy.setOnClickListener(this);
        ll_timeshow.setOnClickListener(this);
    }

    private void initData(){

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.me_button_返回:
                finish();
                break;
            case R.id.button_next:
                if(companyId==0){
                    Toast.makeText(this,"请选择公司",Toast.LENGTH_SHORT).show();
                    return;
                }


                OkHttpUtils.post(HttpAdress.addAuthInfo)
                        .params("company_id",companyId)
                        .params("work_code",et_gonghao.getText().toString())
                        .params("role",1)
                        .params("department",et_suoshubumen.getText().toString())
                        .params("position",et_zhiwei.getText().toString())
                        .params("entry_time",tv_tuzhitime.getText().toString())
                        .execute(new StringCallback() {
                            @Override
                            public void onSuccess(String s, Call call, Response response) {
                                StringModel model = JsonUtil.jsonToEntity(s,StringModel.class);
                                if(model.getCode()==200){
                                    finish();
                                }
                                Toast.makeText(GongSiRenZheng1Activity.this,model.getMsg(),Toast.LENGTH_SHORT).show();
                            }
                        });

                break;
            case R.id.ll_company:
                Intent intent = new Intent(this,GongSiRenZhengActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.ll_timeshow:
                showBirthdayPicker(tv_tuzhitime.getText().toString());
                break;
            case R.id.ib_photo:
                showItemsDialogFragment();
                break;
        }
    }

    public void showItemsDialogFragment() {
        ItemsDialogFragment itemsDialogFragment = new ItemsDialogFragment();
        String[] items = {"相机", "相册","取消" };
        itemsDialogFragment.show("", items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case 0:
                       checkPermission();
                        break;
                    case 1:
                        getPicFromAlbm();
                        break;
                    case 2:
                        itemsDialogFragment.dismiss();
                        break;

                }
            }
        }, getSupportFragmentManager());
    }



    private void checkPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            // 进入这儿表示没有权限
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
                // 提示已经禁止

            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 100);
            }
        } else {
            getPicFromCamera();
        }
    }


    /**
     * 从相机获取图片
     */
    private void getPicFromCamera() {
        //用于保存调用相机拍照后所生成的文件
        tempFile = new File(Environment.getExternalStorageDirectory().getPath(), System.currentTimeMillis() + ".jpg");
        //跳转到调用系统相机
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //判断版本
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {   //如果在Android7.0以上,使用FileProvider获取Uri
            intent.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            Uri contentUri = FileProvider.getUriForFile(GongSiRenZheng1Activity.this, "com.ccsoft.yunqudao.fileProvider", tempFile);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, contentUri);
            Log.e("dasd", contentUri.toString());
        } else {    //否则使用Uri.fromFile(file)方法获取Uri
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(tempFile));
        }
        startActivityForResult(intent, CAMERA_REQUEST_CODE);
    }
    /**
     * 从相册获取图片
     */
    private void getPicFromAlbm() {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, ALBUM_REQUEST_CODE);
    }
    /**
     * 裁剪图片
     */
    private void cropPhoto(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("outputX", 300);
        intent.putExtra("outputY", 300);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, CROP_REQUEST_CODE);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        switch (requestCode) {
            case CAMERA_REQUEST_CODE:   //调用相机后返回
                if (resultCode == RESULT_OK) {
                    //用相机返回的照片去调用剪裁也需要对Uri进行处理
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        Uri contentUri = FileProvider.getUriForFile(GongSiRenZheng1Activity.this, "com.ccsoft.yunqudao.fileProvider", tempFile);
                        cropPhoto(contentUri);
                    } else {
                        cropPhoto(Uri.fromFile(tempFile));
                    }
                }
                break;
            case ALBUM_REQUEST_CODE:    //调用相册后返回
                if (resultCode == RESULT_OK) {
                    Uri uri = intent.getData();
                    cropPhoto(uri);
                }
                break;
            case CROP_REQUEST_CODE:     //调用剪裁后返回
                Bundle bundle = intent.getExtras();
                if (bundle != null) {
                    //在这里获得了剪裁后的Bitmap对象，可以用于上传
                    Bitmap image = bundle.getParcelable("data");
                    //设置到ImageView上
                    mImage.setImageBitmap(image);
                    //也可以进行一些保存、压缩等操作后上传
//                    String path = saveImage("crop", image);
                }
                break;
        }
    }
    public String saveImage(String name, Bitmap bmp) {
        File appDir = new File(Environment.getExternalStorageDirectory().getPath());
        if (!appDir.exists()) {
            appDir.mkdir();
        }
        String fileName = name + ".jpg";
        File file = new File(appDir, fileName);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.flush();
            fos.close();
            return file.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 显示生日时间选择器
     *
     * @param birthdayStr
     */
    private void showBirthdayPicker(String birthdayStr) {
        Calendar selectedDate = Calendar.getInstance();
        if (!TextUtils.isEmpty(birthdayStr) && !birthdayStr.equals("无")) {
            Date birthdayDate = DateUtil.stringToDate(birthdayStr);
            selectedDate.setTime(birthdayDate);
        }

        Calendar startDate = Calendar.getInstance();
        startDate.set(1950, 0, 1);

        Calendar endDate = Calendar.getInstance();
        endDate.set(2050,12,30);

        TimePickerView.Builder builder = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {   // 选中事件回调
                tv_tuzhitime.setText(DateUtil.dateToString(date));
            }
        }).setDividerColor(R.color.danlan) // 设置分割线的颜色
                .setTextColorCenter(Color.parseColor("#333333")) // 设置分割线之间的文字的颜色
                .setTextColorOut(Color.parseColor("#cccccc"))    // 设置分割线以外文字的颜色
                .setContentSize(18)   // 设置滚轮字体大小
                .setOutSideCancelable(true)   // 设置允许点击外面消失
                .isCenterLabel(false) // 是否只显示中间选中项的label文字，false则每项item全部都带有label
                .setSubmitColor(R.color.colorPrimary)  // 设置“确定”的字体颜色
                .setCancelColor(Color.parseColor("#333333"))  // 设置“取消”的字体颜色
                .setSubCalSize(16)    // 设置“确定”和“取消”的字体大小
                .setTitleBgColor(Color.parseColor("#ffffff"))// 设置标题背景色
                .setType(new boolean[] { true, true, true, false, false, false })  // 设置类型
                .setDate(selectedDate)    // 设置默认时间
                .setRangDate(startDate, endDate);  // 设置时间范围

        TimePickerView timePickerView = new TimePickerView(builder);
        timePickerView.show();
    }

}
