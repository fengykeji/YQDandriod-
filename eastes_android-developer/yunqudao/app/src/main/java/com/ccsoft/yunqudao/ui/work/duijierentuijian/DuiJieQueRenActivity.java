package com.ccsoft.yunqudao.ui.work.duijierentuijian;

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
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Message;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.GetHouseTypeDetailBean;
import com.ccsoft.yunqudao.bean.GetNeedInfoBean;
import com.ccsoft.yunqudao.bean.StringBean;
import com.ccsoft.yunqudao.bean.UpLoadBean;
import com.ccsoft.yunqudao.data.AppConstants;
import com.ccsoft.yunqudao.data.base.BaseRecyclerAdapter;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.model.StringModel;
import com.ccsoft.yunqudao.ui.adapter.RecommendPopupwindowAdapter;
import com.ccsoft.yunqudao.ui.house.AdvicerChooseActivity;
import com.ccsoft.yunqudao.ui.me.MyTeamActivity;
import com.ccsoft.yunqudao.ui.message.WorkMessageActivity;
import com.ccsoft.yunqudao.utils.ActivityManager;
import com.ccsoft.yunqudao.utils.ItemsDialogFragment;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.ccsoft.yunqudao.utils.UploadUtil;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import org.jaaksi.pickerview.dataset.OptionDataSet;
import org.jaaksi.pickerview.picker.BasePicker;
import org.jaaksi.pickerview.picker.OptionPicker;
import org.jaaksi.pickerview.widget.PickerView;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Response;

public class DuiJieQueRenActivity extends AppCompatActivity {

    private ImageButton work_button_back;
    private Button button_next;
    private EditText customers_edittext_kehu;
    private EditText customers_edittext_tel,customers_edittext_tel1,customers_edittext_tel2,customers_edittext_tel3
            ,customers_edittext_tel4,customers_edittext_tel5,customers_edittext_tel6,customers_edittext_tel7
            ,customers_edittext_tel8,customers_edittext_tel9,customers_edittext_tel10,et_comment;
    private Spinner customers_spinner_card_type;
    private TextView customers_edittext_zhiye;
    private OptionPicker mPicker;
    private GetHouseTypeDetailBean  bean;
    private List<GetHouseTypeDetailBean.DataBean.RowsBean> datalist = new ArrayList<>();
    private RecommendPopupwindowAdapter adapter;
    private int project_id,client_id,property_advicer_wish_id,visit_num;
    private String client_name,client_tel,visit_time;
    private int daofangid;
    private String a,b,c,d,e,f,g,h,i,j,k;
    private int tel_complete_state;
    private LinearLayout ll_yincang;
    private ImageView querenzhaopian,daofangzhaopian;


    private Uri photoUri;

    public static final int TAKE_PHOTO = 1;//启动相机标识
    public static final int SELECT_PHOTO = 2;//启动相册标识

    private File outputImagepath;//存储拍完照后的图片
    private Bitmap orc_bitmap;//拍照和相册获取图片的Bitmap
    private File filepath1;

    private int UPLOAD_FILE_DONE,UPLOAD_IN_PROCESS,UPLOAD_INIT_PROCESS;

    private String path="",path1="";


    private int aa;




    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setContentView(R.layout.actiivty_duijiequeren);
        initView();
//        initListener();
        getneedInfo();
    }
    private void initView(){
        getData();
        daofangid = getIntent().getIntExtra("daofangid",0);
        project_id = getIntent().getIntExtra("project_id",0);
        client_name = getIntent().getStringExtra("client_name");
        client_tel = getIntent().getStringExtra("client_tel");
        client_id = getIntent().getIntExtra("client_id",0);
        tel_complete_state = getIntent().getIntExtra("tel_complete_state",10);
        getHouseTypeDatil(project_id);
        work_button_back = findViewById(R.id.work_button_back);
        button_next = findViewById(R.id.button_next);
        ll_yincang = findViewById(R.id.ll_yincang);
        daofangzhaopian = findViewById(R.id.daofangzhaopian);
        querenzhaopian = findViewById(R.id.querenzhaopian);
        customers_edittext_kehu = findViewById(R.id.customers_edittext_kehu);
        customers_edittext_tel = findViewById(R.id.customers_edittext_tel);
        customers_edittext_tel1 = findViewById(R.id.customers_edittext_tel1);
        customers_edittext_tel2 = findViewById(R.id.customers_edittext_tel2);
        customers_edittext_tel3 = findViewById(R.id.customers_edittext_tel3);
        customers_edittext_tel4 = findViewById(R.id.customers_edittext_tel4);
        customers_edittext_tel5 = findViewById(R.id.customers_edittext_tel5);
        customers_edittext_tel6 = findViewById(R.id.customers_edittext_tel6);
        customers_edittext_tel7 = findViewById(R.id.customers_edittext_tel7);
        customers_edittext_tel8 = findViewById(R.id.customers_edittext_tel8);
        customers_edittext_tel9 = findViewById(R.id.customers_edittext_tel9);
        customers_edittext_tel10 = findViewById(R.id.customers_edittext_tel10);
        customers_spinner_card_type = findViewById(R.id.customers_spinner_card_type);
        customers_edittext_zhiye = findViewById(R.id.customers_edittext_zhiye);
        et_comment = findViewById(R.id.et_comment);

        customers_edittext_kehu.setText(client_name);

        a = client_tel.substring(0,1);
        b = client_tel.substring(1,2);
        c = client_tel.substring(2,3);
        d = client_tel.substring(3,4);
        e = client_tel.substring(4,5);
        f = client_tel.substring(5,6);
        g = client_tel.substring(6,7);
        h = client_tel.substring(7,8);
        i = client_tel.substring(8,9);
        j = client_tel.substring(9,10);
        k = client_tel.substring(10,11);
        Log.e("cccccw",tel_complete_state+" s");

        if(tel_complete_state == 0||tel_complete_state==2){
            ll_yincang.setVisibility(View.GONE);
        }
        customers_edittext_tel.setText(a);
        customers_edittext_tel1.setText(b);
        customers_edittext_tel2.setText(c);
        customers_edittext_tel3.setText(d);
        customers_edittext_tel4.setText(e);
        customers_edittext_tel5.setText(f);
        customers_edittext_tel6.setText(g);
        customers_edittext_tel7.setText(h);
        customers_edittext_tel8.setText(i);
        customers_edittext_tel9.setText(j);
        customers_edittext_tel10.setText(k);
        if(tel_complete_state == 2||tel_complete_state == 5){
            customers_edittext_tel3.setText("X");
            customers_edittext_tel4.setText("X");
            customers_edittext_tel5.setText("X");
            customers_edittext_tel6.setText("X");
        }

        customers_edittext_tel3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b) {
                    customers_edittext_tel3.setText("");
                }else {

                }
            }
        });
        customers_edittext_tel4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b) {
                    customers_edittext_tel4.setText("");
                }else {

                }            }
        });
        customers_edittext_tel5.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b) {
                    customers_edittext_tel5.setText("");
                }else {

                }
            }
        });
        customers_edittext_tel6.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b) {
                    customers_edittext_tel6.setText("");
                }else {

                }
            }
        });



        work_button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(customers_edittext_zhiye.getText().toString().equals("")){
                    Toast.makeText(DuiJieQueRenActivity.this,"请选择置业顾问",Toast.LENGTH_SHORT).show();
                    return;
                }
                initData();
            }
        });

        customers_edittext_zhiye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getVisitNum();
                backgroundAlpha((float) 0.5);
            }
        });

        customers_spinner_card_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] data = getResources().getStringArray(R.array.到访人数);
                visit_num = Integer.parseInt(data[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        querenzhaopian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aa = 1;
                showItemsDialogFragment();
            }
        });

        daofangzhaopian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aa = 2;
                showItemsDialogFragment();
            }
        });


    }

    private void getneedInfo(){
        OkHttpUtils.get(AppConstants.URL+"agent/client/needInfo")
                .params("client_id",client_id)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        GetNeedInfoBean bean = JsonUtil.jsonToEntity(s,GetNeedInfoBean.class);
                        if(bean.getCode() == 200){
                            customers_edittext_zhiye.setText(bean.getData().getComsulatent_advicer());
                            if(!bean.getData().getId().equals("")) {
                                property_advicer_wish_id = Integer.parseInt(bean.getData().getId());
                            }
                        }
                    }
                });
    }
    private void initData(){

        Log.e("ccccccw",client_id+" "+customers_edittext_kehu.getText().toString()+" "+
                customers_edittext_tel.getText().toString()+" "+visit_num+" " +
                visit_time+" "+customers_edittext_zhiye.getText().toString()+" "+property_advicer_wish_id+" "+
                et_comment.getText().toString());

        String tel = customers_edittext_tel.getText().toString()+customers_edittext_tel1.getText().toString()
                +customers_edittext_tel2.getText().toString()
                +customers_edittext_tel3.getText().toString()
                +customers_edittext_tel4.getText().toString()
                +customers_edittext_tel5.getText().toString()
                +customers_edittext_tel6.getText().toString()
                +customers_edittext_tel7.getText().toString()
                +customers_edittext_tel8.getText().toString()
                +customers_edittext_tel9.getText().toString()
                +customers_edittext_tel10.getText().toString();
        if(tel_complete_state == 2&& customers_edittext_tel3.getText().toString().equals("X")
                || customers_edittext_tel4.getText().toString().equals("X")
                || customers_edittext_tel5.getText().toString().equals("X")
                || customers_edittext_tel6.getText().toString().equals("X")){
            Toast.makeText(DuiJieQueRenActivity.this,"请补全电话号码",Toast.LENGTH_SHORT).show();
            return;
        }

        OkHttpUtils.post(AppConstants.URL+"agent/client/confirmValue")
                .params("client_id",client_id)
                .params("client_name",customers_edittext_kehu.getText().toString())
                .params("client_tel",tel)
                .params("visit_num",visit_num)
                .params("visit_time",visit_time)
                .params("visit_img_url",path)
                .params("verify_img_url",path1)
                .params("property_advicer_wish",customers_edittext_zhiye.getText().toString())
                .params("property_advicer_wish_id",property_advicer_wish_id)
                .params("comment",et_comment.getText().toString())
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        StringBean bean = JsonUtil.jsonToEntity(s,StringBean.class);
                        Log.e("cccccws",bean.getCode()+" "+bean.getMsg());
                        if(bean.getCode() == 200){
                            if(daofangid == 1){
                                Intent intent = new Intent(DuiJieQueRenActivity.this, WorkMessageActivity.class);
                                startActivity(intent);
                            }else if(daofangid == 3){
                                Intent intent1 = new Intent(DuiJieQueRenActivity.this,WorkDuiJieRecommendActivity.class);
                                startActivity(intent1);
                            }
                            finish();
                        }
                        Toast.makeText(DuiJieQueRenActivity.this,bean.getMsg(),Toast.LENGTH_SHORT).show();
                    }
                });
    }


    private void getVisitNum() {
        View view = LayoutInflater.from(this).inflate(R.layout.popupwindow_duijie,null);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.select);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new RecommendPopupwindowAdapter(this,R.layout.item_zhiye_activity,datalist);
        recyclerView.setAdapter(adapter);
        PopupWindow popupWindow = new PopupWindow(ViewGroup.LayoutParams.MATCH_PARENT, 600);
        popupWindow.setContentView(view);
        popupWindow.setFocusable(true);
        popupWindow.showAtLocation(DuiJieQueRenActivity.this.getWindow().getDecorView(), Gravity.BOTTOM,0,0);

        adapter.setOnItemClickListner(new BaseRecyclerAdapter.OnItemClickListner() {
            @Override
            public void onItemClickListner(View v, int position) {
                property_advicer_wish_id = Integer.parseInt(bean.getData().getRows().get(position).getID());
//                customers_edittext_zhiye.setText(bean.getData().getRows().get(position).getGSMC()+"/"+bean.getData().getRows().get(position).getRYXM()
//                +"/"+bean.getData().getRows().get(position).getRYDH());
                customers_edittext_zhiye.setText(bean.getData().getRows().get(position).getRYXM());
                backgroundAlpha(1);
                popupWindow.dismiss();
            }
        });

        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1);
            }
        });
    }


    /**
     * 获取置业顾问
     */
    private void getHouseTypeDatil(int project_id){
        Log.e("ccccww",project_id+"s");
        OkHttpUtils.get(AppConstants.URL+"user/project/getAdvicer")
                .tag(this)
                .params("project_id",project_id)
                .execute(new StringCallback() {
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

                        bean = JsonUtil.jsonToEntity(s,GetHouseTypeDetailBean.class);
                        Log.e("cccccwws",bean.getCode()+"sw"+bean.getData().getRows().size());
                        if (bean.getCode() == 200){
                           datalist.clear();
                           datalist.addAll(bean.getData().getRows());
                        }
                    }
                });
    }

    /**
     * 获取系统当前时间
     */
    private void getData(){
        SimpleDateFormat formatter    =   new    SimpleDateFormat    ("yyyy-MM-dd HH:mm:ss");
        Date curDate    =   new    Date(System.currentTimeMillis());//获取当前时间
        visit_time   =    formatter.format(curDate);
    }

    public void backgroundAlpha(float bgAlpha)  //阴影改变
    {
        WindowManager.LayoutParams lp =getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        getWindow().setAttributes(lp);
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
                                ActivityCompat.requestPermissions(DuiJieQueRenActivity.this,new String[]{Manifest.permission.CAMERA},1);
                            }
                        }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //不请求权限的操作
                    }
                }).create().show();
            }else {
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA},1);
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
        Cursor cursor = this.getContentResolver().query(uri, null, selection, null, null);
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
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
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
    public void onDestroy() {
        super.onDestroy();
        if (orc_bitmap != null) {
            orc_bitmap.recycle();
        } else {
            orc_bitmap = null;
        }
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
                try {
                    //获得图片路径
                    filepath1 = UploadUtil.saveFile(orc_bitmap, Environment.getExternalStorageDirectory().toString(), "hand.jpg");
                    //上传照片
                    if(aa == 2){
                        toUploadFile();
                    }else if(aa ==1){
                        toUploadFile1();
                    }
                    toUploadFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if(aa==1){
                    upload1(filepath1);
                    querenzhaopian.setImageBitmap(orc_bitmap);
                }else if(aa == 2) {
                    upload(filepath1);
                    daofangzhaopian.setImageBitmap(orc_bitmap);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            exif = null;
        }
    }

    /**
     * 上传图片到服务器
     */
    private void toUploadFile() {

        String fileKey = "avatarFile";
        UploadUtil uploadUtil = UploadUtil.getInstance();
        uploadUtil.setOnUploadProcessListener(new UploadUtil.OnUploadProcessListener() {
            @Override
            public void onUploadDone(int responseCode, String message) {
                Message msg = Message.obtain();
                msg.what = UPLOAD_FILE_DONE;
                msg.arg1 = responseCode;
                msg.obj = message;
            }

            @Override
            public void onUploadProcess(int uploadSize) {
                Message msg = Message.obtain();
                msg.what = UPLOAD_IN_PROCESS;
                msg.arg1 = uploadSize;
            }

            @Override
            public void initUpload(int fileSize) {
                Message msg = Message.obtain();
                msg.what = UPLOAD_INIT_PROCESS;
                msg.arg1 = fileSize;
            }
        }); //设置监听器监听上传状态

        Map<String, String> params = new HashMap<String, String>();//上传map对象
        params.put("file_name", "img");
        params.put("img",filepath1.getAbsolutePath());
        uploadUtil.uploadFile(filepath1, fileKey,AppConstants.URL+"agent/file/upload", params);

    }

    /**
     * 上传图片到服务器
     */
    private void toUploadFile1() {

        String fileKey = "avatarFile";
        UploadUtil uploadUtil = UploadUtil.getInstance();
        uploadUtil.setOnUploadProcessListener(new UploadUtil.OnUploadProcessListener() {
            @Override
            public void onUploadDone(int responseCode, String message) {
                Message msg = Message.obtain();
                msg.what = UPLOAD_FILE_DONE;
                msg.arg1 = responseCode;
                msg.obj = message;
            }

            @Override
            public void onUploadProcess(int uploadSize) {
                Message msg = Message.obtain();
                msg.what = UPLOAD_IN_PROCESS;
                msg.arg1 = uploadSize;
            }

            @Override
            public void initUpload(int fileSize) {
                Message msg = Message.obtain();
                msg.what = UPLOAD_INIT_PROCESS;
                msg.arg1 = fileSize;
            }
        }); //设置监听器监听上传状态

        Map<String, String> params = new HashMap<String, String>();//上传map对象
        params.put("file_name", "verify");
        params.put("verify",filepath1.getAbsolutePath());
        uploadUtil.uploadFile(filepath1, fileKey,AppConstants.URL+"agent/file/upload", params);

    }

    UpLoadBean bean1;
    private void upload(File file){

        OkHttpUtils.post(AppConstants.URL+"agent/file/upload")
                .tag(this)
                .params("file_name","img")
                .params("img",file)
                .execute(new StringCallback() {
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
                            bean1 = JsonUtil.jsonToEntity(s,UpLoadBean.class);
                            path = bean1.getData();
                            Log.e("ccccc",path);
                        }
                        Toast.makeText(DuiJieQueRenActivity.this,bean.getMsg(),Toast.LENGTH_SHORT).show();
                    }
                });
    }

    UpLoadBean bean2;
    private void upload1(File file){

        OkHttpUtils.post(AppConstants.URL+"agent/file/upload")
                .tag(this)
                .params("file_name","verify")
                .params("verify",file)
                .execute(new StringCallback() {
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
                            bean2 = JsonUtil.jsonToEntity(s,UpLoadBean.class);
                            path1 = bean2.getData();
                            Log.e("ccccc",path1);
                        }
                        Toast.makeText(DuiJieQueRenActivity.this,bean.getMsg(),Toast.LENGTH_SHORT).show();
                    }
                });
    }


}
