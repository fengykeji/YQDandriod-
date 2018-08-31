package com.ccsoft.yunqudao.ui.me;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.GongSiRenZhengBean;
import com.ccsoft.yunqudao.data.AppConstants;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.model.StringModel;
import com.ccsoft.yunqudao.ui.customers.IntentServiceResult;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.DateUtil;
import com.ccsoft.yunqudao.utils.HideIMEUtil;
import com.ccsoft.yunqudao.utils.ItemsDialogFragment;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.ccsoft.yunqudao.utils.wheelview.TimePickerView;
import com.lljjcoder.citypickerview.widget.CityPicker;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;
import com.lzy.okhttputils.request.GetRequest;
import com.lzy.okhttputils.request.PostRequest;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import okhttp3.Call;
import okhttp3.Response;

public class GongSiRenZheng1Activity extends AppCompatActivity implements View.OnClickListener{

    private Button button_nex;
    private TextView tv_company,tv_tuzhitime,tv_company1;
    private EditText et_suoshubumen,et_zhiwei,et_gonghao;
    private ImageButton me_button_返回;
    private LinearLayout ll_compamy,ll_company1;
    private String companyname;
    private int companyId  = 0;
    private RelativeLayout ll_timeshow;
    private Uri photoUri;
    private int chongxin = 0;
    private int bId = 0;
    private int role =1;
    private String stringrole;
    private Spinner customers_spinner_card_type;
    private int project_id=0;
    private String project_name;
    private PostRequest getRequest;

    public static final int TAKE_PHOTO = 1;//启动相机标识
    public static final int SELECT_PHOTO = 2;//启动相册标识
    private ImageView imageView;
    private TextView textView;
    private File outputImagepath;//存储拍完照后的图片
    private Bitmap orc_bitmap;//拍照和相册获取图片的Bitmap


    private ImageView mImage;

    private String icon = "上传地址";

    //相册请求码
    private static final int ALBUM_REQUEST_CODE = 4;
//    //相机请求码
//    private static final int CAMERA_REQUEST_CODE = 2;
//    //剪裁请求码
    private static final int CROP_REQUEST_CODE = 3;
    public final int TYPE_TAKE_PHOTO = 1;//Uri获取类型判断

    public final int CODE_TAKE_PHOTO = 1;//相机RequestCode

    public final int CODE_SELECT_IMAGE = 2;//相册RequestCode


    //调用照相机返回图片文件
    private File tempFile;

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void doThis(SendMessage sendMessage) {
        project_id = sendMessage.getProject_id();
        project_name = sendMessage.getProject_name();

        if (project_name==null){
            tv_company1.setText("");
        }else {
            tv_company1.setText(project_name + "");
        }
    }


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.gongsirenzheng1_activity);
        HideIMEUtil.wrap(this);//键盘管理，点击除editText外区域收起键盘
        EventBus.getDefault().register(this);
        initView();
        initlistener();
        initData();
    }

    private void initView(){
//        project_id = getIntent().getIntExtra("project_id",0);
        me_button_返回 = findViewById(R.id.me_button_返回);
        button_nex = findViewById(R.id.button_next);
        tv_company = findViewById(R.id.tv_company);
        tv_tuzhitime = findViewById(R.id.tv_tuzhitime);
        et_suoshubumen = findViewById(R.id.et_suoshubumen);
        et_zhiwei = findViewById(R.id.et_zhiwei);
        mImage = findViewById(R.id.ib_photo);
        ll_compamy = findViewById(R.id.ll_company);
        ll_company1 = findViewById(R.id.ll_company1);
        et_gonghao = findViewById(R.id.et_gonghao);
        ll_timeshow = findViewById(R.id.ll_timeshow);
        customers_spinner_card_type = findViewById(R.id.customers_spinner_card_type);
        tv_company1 = findViewById(R.id.tv_company1);



        companyname = getIntent().getStringExtra("companyname");
        companyId = getIntent().getIntExtra("companyId",0);

        chongxin = getIntent().getIntExtra("chongxin",0);
        bId = getIntent().getIntExtra("bId",0);
        customers_spinner_card_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] languages = getResources().getStringArray(R.array.公司认证);
                stringrole = languages[i];
                if (stringrole.equals("经纪人")) {
                    role = 1;
                }
                else if(stringrole.equals("对接人")){
                    role = 2;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        tv_company.setText(companyname);




    }

    private void initlistener(){
        me_button_返回.setOnClickListener(this);
        button_nex.setOnClickListener(this);
        tv_tuzhitime.setOnClickListener(this);
        mImage.setOnClickListener(this);
        ll_compamy.setOnClickListener(this);
        ll_timeshow.setOnClickListener(this);
        ll_company1.setOnClickListener(this);
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


                if(chongxin==123) {
                   getRequest = OkHttpUtils.post(AppConstants.URL + "agent/personal/reAuth")
                            .params("company_id", companyId)
                            .params("work_code", et_gonghao.getText().toString())
                            .params("role", role)
                            .params("department", et_suoshubumen.getText().toString())
                            .params("position", et_zhiwei.getText().toString())
                            .params("entry_time", tv_tuzhitime.getText().toString())
                            .params("before_id", bId);
                   if(project_id!=0){
                       Log.e("cccc",project_id+"");
                       getRequest.params("project_id",project_id);
                   }
                   getRequest.execute(new StringCallback() {
                                @Override
                                public void onSuccess(String s, Call call, Response response) {
                                    StringModel model = JsonUtil.jsonToEntity(s, StringModel.class);
                                    if (model.getCode() == 200) {
                                        finish();
                                    }
                                    Toast.makeText(GongSiRenZheng1Activity.this, model.getMsg(), Toast.LENGTH_SHORT).show();
                                }
                            });
                    return;
                }


                    getRequest =OkHttpUtils.post(HttpAdress.addAuthInfo)
                            .params("company_id", companyId)
                            .params("work_code", et_gonghao.getText().toString())
                            .params("role", role)
                            .params("department", et_suoshubumen.getText().toString())
                            .params("position", et_zhiwei.getText().toString())
                            .params("entry_time", tv_tuzhitime.getText().toString());
                if(project_id!=0){
                    getRequest.params("project_id",project_id);
                }
                getRequest.execute(new StringCallback() {
                                @Override
                                public void onSuccess(String s, Call call, Response response) {
                                    StringModel model = JsonUtil.jsonToEntity(s, StringModel.class);
                                    if (model.getCode() == 200) {
                                        finish();
                                    }
                                    Toast.makeText(GongSiRenZheng1Activity.this, model.getMsg(), Toast.LENGTH_SHORT).show();
                                }
                            });


                break;
            case R.id.ll_company:
                Intent intent = new Intent(this,GongSiRenZhengActivity.class);
                intent.putExtra("chongxin",chongxin);
                intent.putExtra("bId", bId);
                startActivity(intent);
                finish();
                break;
            case R.id.ll_timeshow:
                showBirthdayPicker(tv_tuzhitime.getText().toString());
                break;
            case R.id.ib_photo:
                showItemsDialogFragment();
                break;
            case R.id.ll_company1:
                if (role == 1){
                    Toast.makeText(this,"到访确认人才能选择项目",Toast.LENGTH_SHORT).show();
                    return;
                }else if(companyId == 0){
                    Toast.makeText(this,"请选择公司",Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent1 = new Intent(this,XuanZheXiangMuActivity.class);
                    intent1.putExtra("company_id",companyId);
                    startActivity(intent1);
                }
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
                       xiangjiClick();
                        break;
                    case 1:
                        xiangceClick();
                        break;
                    case 2:
                        itemsDialogFragment.dismiss();
                        break;

                }
            }
        }, getSupportFragmentManager());
    }



    /**
     * 打开相机
     *
     */
    public void xiangjiClick() {
        //checkSelfPermission 检测有没有 权限
//        PackageManager.PERMISSION_GRANTED 有权限
//        PackageManager.PERMISSION_DENIED  拒绝权限
        //一定要先判断权限,再打开相机,否则会报错
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            //权限发生了改变 true  //  false,没有权限时
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.CAMERA)){
                new AlertDialog.Builder(this).setTitle("title")
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // 请求授权
                                ActivityCompat.requestPermissions(GongSiRenZheng1Activity.this,new String[]{Manifest.permission.CAMERA},1);
                            }
                        }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //不请求权限的操作
                    }
                }).create().show();
            }else {
                ActivityCompat.requestPermissions(GongSiRenZheng1Activity.this,new String[]{Manifest.permission.CAMERA},1);
            }
        }else{
            take_photo();//已经授权了就调用打开相机的方法
        }
    }

    /**
     * 打开相册
     */
    public void xiangceClick() {
        select_photo();
    }

    /**
     * 拍照获取图片
     **/
    public void take_photo() {
        //获取系統版本
        int currentapiVersion = Build.VERSION.SDK_INT;
        // 激活相机
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // 判断存储卡是否可以用，可用进行存储
        if (hasSdcard()) {
            SimpleDateFormat timeStampFormat = new SimpleDateFormat(
                    "yyyy_MM_dd_HH_mm_ss");
            String filename = timeStampFormat.format(new Date());
            outputImagepath = new File(Environment.getExternalStorageDirectory(),
                    filename + ".jpg");
            if (currentapiVersion < 24) {
                // 从文件中创建uri
                Uri uri = Uri.fromFile(outputImagepath);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
            } else {
                //兼容android7.0 使用共享文件的形式
                ContentValues contentValues = new ContentValues(1);
                contentValues.put(MediaStore.Images.Media.DATA, outputImagepath.getAbsolutePath());
                Uri uri = getApplication().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
            }
        }
        // 开启一个带有返回值的Activity，请求码为PHOTO_REQUEST_CAREMA
        startActivityForResult(intent, TAKE_PHOTO);
    }


    /*
     * 判断sdcard是否被挂载
     */
    public static boolean hasSdcard() {
        return Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED);
    }

    /**
     * 从相册中获取图片
     */
    public void select_photo() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        } else {
            openAlbum();
        }
    }

    /**
     * 打开相册的方法
     */
    private void openAlbum() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        startActivityForResult(intent, SELECT_PHOTO);
    }


    /**
     * 4.4以下系统处理图片的方法
     */
    private void handleImageBeforeKitKat(Intent data) {
        Uri uri = data.getData();
        String imagePath = getImagePath(uri, null);
        displayImage(imagePath);
    }

    /**
     * 4.4及以上系统处理图片的方法
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    private void handleImgeOnKitKat(Intent data) {
        String imagePath = null;
        Uri uri = data.getData();
        Log.d("uri=intent.getData :", "" + uri);
        if (DocumentsContract.isDocumentUri(this, uri)) {
            String docId = DocumentsContract.getDocumentId(uri);        //数据表里指定的行
            Log.d("getDocumentId(uri) :", "" + docId);
            Log.d("uri.getAuthority() :", "" + uri.getAuthority());
            if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
                String id = docId.split(":")[1];
                String selection = MediaStore.Images.Media._ID + "=" + id;
                imagePath = getImagePath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, selection);
            } else if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
                Uri contentUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(docId));
                imagePath = getImagePath(contentUri, null);
            }

        } else if ("content".equalsIgnoreCase(uri.getScheme())) {
            imagePath = getImagePath(uri, null);
        }
        displayImage(imagePath);
    }
    /**
     * 通过uri和selection来获取真实的图片路径,从相册获取图片时要用
     */
    private String getImagePath(Uri uri, String selection) {
        String path = null;
        Cursor cursor = getContentResolver().query(uri, null, selection, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
            }
            cursor.close();
        }
        return path;
    }


    /**
     * 拍完照和从相册获取玩图片都要执行的方法(根据图片路径显示图片)
     */
    private void displayImage(String imagePath) {
        if (!TextUtils.isEmpty(imagePath)) {
            //orc_bitmap = BitmapFactory.decodeFile(imagePath);//获取图片
            orc_bitmap = comp(BitmapFactory.decodeFile(imagePath)); //压缩图片
            ImgUpdateDirection(imagePath);//显示图片,并且判断图片显示的方向,如果不正就放正
        } else {
            Toast.makeText(this, "图片获取失败", Toast.LENGTH_LONG).show();
        }
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            //打开相机后返回
            case TAKE_PHOTO:
                if (resultCode == RESULT_OK) {
                    /**
                     * 这种方法是通过内存卡的路径进行读取图片，所以的到的图片是拍摄的原图
                     */
                    displayImage(outputImagepath.getAbsolutePath());
                    Log.i("tag", "拍照图片路径>>>>" + outputImagepath);
                }
                break;
            //打开相册后返回
            case SELECT_PHOTO:
                if (resultCode == RESULT_OK) {
                    //判断手机系统版本号
                    if (Build.VERSION.SDK_INT > 19) {
                        //4.4及以上系统使用这个方法处理图片
                        handleImgeOnKitKat(data);
                    } else {
                        handleImageBeforeKitKat(data);
                    }
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1:
                //判断是否有权限
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    openAlbum();//打开相册
                    take_photo();//打开相机
                } else {
                    Toast.makeText(this, "你需要许可", Toast.LENGTH_LONG).show();
                }
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (orc_bitmap != null) {
            orc_bitmap.recycle();
        } else {
            orc_bitmap = null;
        }
        EventBus.getDefault().unregister(this);
    }


    /**
     * 质量压缩方法
     *
     * @param image
     * @return
     */
    public static Bitmap compressImage(Bitmap image) {
        if (image != null) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            image.compress(Bitmap.CompressFormat.JPEG, 100, baos);//质量压缩方法，这里100表示不压缩，把压缩后的数据存放到baos中
            int options = 100;
            while (baos.toByteArray().length / 1024 > 100) { //循环判断如果压缩后图片是否大于100kb,大于继续压缩
                baos.reset();//重置baos即清空baos
                options -= 10;//每次都减少10
                image.compress(Bitmap.CompressFormat.JPEG, options, baos);//这里压缩options%，把压缩后的数据存放到baos中

            }
            ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());//把压缩后的数据baos存放到ByteArrayInputStream中
            Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, null);//把ByteArrayInputStream数据生成图片
            return bitmap;
        } else {
            return null;
        }

    }
    //比例压缩
    private Bitmap comp(Bitmap image) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        if (baos.toByteArray().length / 1024 > 1024) {//判断如果图片大于1M,进行压缩避免在生成图片（BitmapFactory.decodeStream）时溢出
            baos.reset();//重置baos即清空baos
            image.compress(Bitmap.CompressFormat.JPEG, 50, baos);//这里压缩50%，把压缩后的数据存放到baos中
        }
        ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());
        BitmapFactory.Options newOpts = new BitmapFactory.Options();
        //开始读入图片，此时把options.inJustDecodeBounds 设回true了
        newOpts.inJustDecodeBounds = true;
        Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, newOpts);
        newOpts.inJustDecodeBounds = false;
        int w = newOpts.outWidth;
        int h = newOpts.outHeight;
        //现在主流手机比较多是800*480分辨率，所以高和宽我们设置为
        float hh = 800f;//这里设置高度为800f
        float ww = 480f;//这里设置宽度为480f
        //缩放比。由于是固定比例缩放，只用高或者宽其中一个数据进行计算即可
        int be = 1;//be=1表示不缩放
        if (w > h && w > ww) {//如果宽度大的话根据宽度固定大小缩放
            be = (int) (newOpts.outWidth / ww);
        } else if (w < h && h > hh) {//如果高度高的话根据宽度固定大小缩放
            be = (int) (newOpts.outHeight / hh);
        }
        if (be <= 0)
            be = 1;
        newOpts.inSampleSize = be;//设置缩放比例
        newOpts.inPreferredConfig = Bitmap.Config.RGB_565;//降低图片从ARGB888到RGB565
        //重新读入图片，注意此时已经把options.inJustDecodeBounds 设回false了
        isBm = new ByteArrayInputStream(baos.toByteArray());
        bitmap = BitmapFactory.decodeStream(isBm, null, newOpts);
        return bitmap;//压缩好比例大小后再进行质量压缩
    }


    //改变拍完照后图片方向不正的问题
    private void ImgUpdateDirection(String filepath) {
        int digree = 0;//图片旋转的角度
        //根据图片的URI获取图片的绝对路径
        Log.i("tag", ">>>>>>>>>>>>>开始");
        //String filepath = ImgUriDoString.getRealFilePath(getApplicationContext(), uri);
        Log.i("tag", "》》》》》》》》》》》》》》》" + filepath);
        //根据图片的filepath获取到一个ExifInterface的对象
        ExifInterface exif = null;
        try {
            exif = new ExifInterface(filepath);
            Log.i("tag", "exif》》》》》》》》》》》》》》》" + exif);
            if (exif != null) {

                // 读取图片中相机方向信息
                int ori = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_UNDEFINED);

                // 计算旋转角度
                switch (ori) {
                    case ExifInterface.ORIENTATION_ROTATE_90:
                        digree = 90;
                        break;
                    case ExifInterface.ORIENTATION_ROTATE_180:
                        digree = 180;
                        break;
                    case ExifInterface.ORIENTATION_ROTATE_270:
                        digree = 270;
                        break;
                    default:
                        digree = 0;
                        break;

                }

            }
            //如果图片不为0
            if (digree != 0) {
                // 旋转图片
                Matrix m = new Matrix();
                m.postRotate(digree);
                orc_bitmap = Bitmap.createBitmap(orc_bitmap, 0, 0, orc_bitmap.getWidth(),
                        orc_bitmap.getHeight(), m, true);
            }
            if (orc_bitmap != null) {
                mImage.setImageBitmap(orc_bitmap);
            }
        } catch (IOException e) {
            e.printStackTrace();
            exif = null;
        }
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
