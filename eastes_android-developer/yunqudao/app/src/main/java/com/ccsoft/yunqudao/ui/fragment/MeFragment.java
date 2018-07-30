package com.ccsoft.yunqudao.ui.fragment;


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
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ccsoft.yunqudao.R;
import com.ccsoft.yunqudao.bean.GongSiRenZhengBean;
import com.ccsoft.yunqudao.bean.UpLoadBean;
import com.ccsoft.yunqudao.data.AppConstants;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.model.PersonCenterModel;
import com.ccsoft.yunqudao.model.StringModel;
import com.ccsoft.yunqudao.ui.me.GongSiRenZheng1Activity;
import com.ccsoft.yunqudao.ui.me.GongSiRenZhengWanActivity;
import com.ccsoft.yunqudao.ui.me.GongSiRenZhengZhongActivity;
import com.ccsoft.yunqudao.ui.me.GongZuoJingLiActivity;
import com.ccsoft.yunqudao.ui.me.PactActivity;
import com.ccsoft.yunqudao.ui.me.WoDeErWeiMaActivity;
import com.ccsoft.yunqudao.ui.me.WoDeGuanZhuActivity;
import com.ccsoft.yunqudao.ui.me.WoDeYongJinActivity;
import com.ccsoft.yunqudao.ui.me.WoDeZiLiaoActivity;
import com.ccsoft.yunqudao.ui.me.YiJianFanKuiActivity;
import com.ccsoft.yunqudao.ui.mian.LoginActivity;
import com.ccsoft.yunqudao.ui.mian.MainActivity;
import com.ccsoft.yunqudao.utils.CircleImageView;
import com.ccsoft.yunqudao.utils.ItemsDialogFragment;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.ccsoft.yunqudao.utils.UploadUtil;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Response;

import static android.app.Activity.RESULT_OK;


/**
 * @author: Pein
 * @data: 2018/5/2 0002
 */

public class MeFragment extends Fragment implements View.OnClickListener  {

    /**
     * 我的页面id
     */
    private View         mView;
    private CircleImageView mImage;
    private TextView mMe_text_yunsuan_id;
    private LinearLayout mMe_item_linearlayout_personal;
    private LinearLayout mMe_item_linearlayout_company;
    private LinearLayout mMe_Item_linearlayout_work_list;
    private LinearLayout mMe_Item_linearlayout_brokerage;
    private LinearLayout mMe_Item_linearlayout_attention;
    private LinearLayout mMe_Item_linearlayout_opinion;
    private LinearLayout mMe_Item_linearlayout_about_yunsuan;
    private TextView     mMe_item_text_authentication;
    private TextView     mMe_item_text_versions;
    private PersonCenterModel.Data data;

    private Uri photoUri;

    public static final int TAKE_PHOTO = 1;//启动相机标识
    public static final int SELECT_PHOTO = 2;//启动相册标识

    private File outputImagepath;//存储拍完照后的图片
    private Bitmap orc_bitmap;//拍照和相册获取图片的Bitmap
    private File filepath1;

    private int UPLOAD_FILE_DONE,UPLOAD_IN_PROCESS,UPLOAD_INIT_PROCESS;

    private String path;







    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        /**
         * 填充布局
         */
        mView = inflater.inflate(R.layout.fragment_me, container, false);
        initView();
        initListener();
        loadData();

        return mView;
    }

    private void initView() {
        /**
         * 初始化id
         */
        this.mMe_item_linearlayout_personal = mView.findViewById(R.id.me_item_linearlayout_personal);
        this.mMe_item_linearlayout_company = mView.findViewById(R.id.me_item_linearlayout_company);
        this.mMe_Item_linearlayout_work_list = mView.findViewById(R.id.me_item_linearlayout_work_list);
        this.mMe_Item_linearlayout_brokerage = mView.findViewById(R.id.me_item_linearlayout_brokerage);
        this.mMe_Item_linearlayout_attention = mView.findViewById(R.id.me_item_linearlayout_attention);
        this.mMe_Item_linearlayout_opinion = mView.findViewById(R.id.me_item_linearlayout_opinion);
        this.mMe_Item_linearlayout_about_yunsuan = mView.findViewById(R.id.me_item_linearlayout_about_yunsuan);
        this.mImage = mView.findViewById(R.id.me_icon_icon);
        this.mMe_text_yunsuan_id = mView.findViewById(R.id.me_text_yunsuan_id);
        this.mMe_item_text_authentication = mView.findViewById(R.id.me_item_text_authentication);
        this.mMe_item_text_versions = mView.findViewById(R.id.me_item_text_versions);
    }

    /**
     * 初始化监听器
     */
    private void initListener() {

        this.mMe_item_linearlayout_personal.setOnClickListener(this);
        this.mMe_item_linearlayout_company.setOnClickListener(this);
        this.mMe_Item_linearlayout_work_list.setOnClickListener(this);
        this.mMe_Item_linearlayout_brokerage.setOnClickListener(this);
        this.mMe_Item_linearlayout_attention.setOnClickListener(this);
        this.mMe_Item_linearlayout_opinion.setOnClickListener(this);
        this.mMe_Item_linearlayout_about_yunsuan.setOnClickListener(this);
        this.mImage.setOnClickListener(this);
        this.mMe_text_yunsuan_id.setOnClickListener(this);
        this.mMe_item_text_authentication.setOnClickListener(this);
        this.mMe_item_text_versions.setOnClickListener(this);
    }

    /**
     * 点击事件
     */
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.me_item_linearlayout_personal:
                startActivity(new Intent(getActivity(),WoDeZiLiaoActivity.class)
                .putExtra("data",data));

                break;
            case R.id.me_item_linearlayout_company:
//                GongSiRenZhengActivity.start(getActivity());
                OkHttpUtils.get(HttpAdress.getAuthInfo)
                        .tag(this)
                        .execute(new StringCallback() {
                            @Override
                            public void onSuccess(String s, Call call, Response response) {
                                int code = 0;
                                String data =null;
                                Object data1 = null;
                                try {
                                    JSONObject jsonObject = new JSONObject(s);
                                    code = jsonObject.getInt("code");
                                    data = jsonObject.getString("data");
                                    data1 = jsonObject.getJSONObject("data");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                                if (code == 200) {

                                    if (data1 == null) {
                                        Intent intent = new Intent(getContext(), GongSiRenZheng1Activity.class);
                                        startActivity(intent);
                                    } else {
                                        GongSiRenZhengBean bean = JsonUtil.jsonToEntity(s, GongSiRenZhengBean.class);

                                        if (bean.getData().getState().equals("认证中")) {
                                            Intent intent = new Intent(getContext(), GongSiRenZhengZhongActivity.class);
                                            intent.putExtra("id", bean.getData().getId());
                                            startActivity(intent);

                                        } else if (bean.getData().getState().equals("认证通过")) {
                                            Intent intent = new Intent(getContext(), GongSiRenZhengWanActivity.class);
                                            intent.putExtra("id", bean.getData().getId());
                                            startActivity(intent);

                                        }else {
                                            Intent intent = new Intent(getContext(), GongSiRenZheng1Activity.class);
                                            intent.putExtra("id", bean.getData().getId());
                                            startActivity(intent);
                                        }

                                    }
                                }
                                else if(code == 401){
                                    Intent intent = new Intent(getContext(), LoginActivity.class);
                                    startActivity(intent);
                                    Toast.makeText(getContext(),"token失效，请重新登陆", Toast.LENGTH_SHORT).show();
                                }
                                }

                        });

                break;
            case R.id.me_item_linearlayout_work_list:
                GongZuoJingLiActivity.start(getActivity());
                break;
            case R.id.me_item_linearlayout_brokerage:
                WoDeYongJinActivity.start(getActivity());
                break;
            case R.id.me_item_linearlayout_attention:
                WoDeGuanZhuActivity.start(getActivity());
                break;
            case R.id.me_item_linearlayout_opinion:
                YiJianFanKuiActivity.start(getActivity());
                break;
            case R.id.me_item_linearlayout_about_yunsuan:
                PactActivity.start(getActivity());
                break;
            case R.id.me_icon_icon:
                showItemsDialogFragment();
                break;
        }
    }






    private void loadData(){
        OkHttpUtils.post(HttpAdress.getBaseInfo)
                .tag(this)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        PersonCenterModel model = JsonUtil.jsonToEntity(s,PersonCenterModel.class);
                        data = model.getData();
                        if(model.getCode()==200){
                            mMe_text_yunsuan_id.setText(model.getData().getAccount());
                            Picasso.with(getContext()).load(AppConstants.URL+model.getData().getHead_img())
                                    .error(R.drawable.ic_def_head)
                                    .into(mImage);
                        }
                    }
                });
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
        }, getFragmentManager());
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
        if(ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            //权限发生了改变 true  //  false,没有权限时
            if(ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),Manifest.permission.CAMERA)){
                new AlertDialog.Builder(getContext()).setTitle("title")
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // 请求授权
                                ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.CAMERA},1);
                            }
                        }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //不请求权限的操作
                    }
                }).create().show();
            }else {
                ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.CAMERA},1);
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
                Uri uri = getActivity().getApplication().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
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
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
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
        if (DocumentsContract.isDocumentUri(getContext(), uri)) {
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
        Cursor cursor = getActivity().getContentResolver().query(uri, null, selection, null, null);
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
            Toast.makeText(getContext(), "图片获取失败", Toast.LENGTH_LONG).show();
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
                    Toast.makeText(getContext(), "你需要许可", Toast.LENGTH_LONG).show();
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
                    toUploadFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                upload(filepath1);

               mImage.setImageBitmap(orc_bitmap);
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
        params.put("file_name", "headimg");
        params.put("headimg",filepath1.getAbsolutePath());
        uploadUtil.uploadFile(filepath1, fileKey,AppConstants.URL+"agent/file/upload", params);

    }

    UpLoadBean bean;
    private void upload(File file){

        OkHttpUtils.post(AppConstants.URL+"agent/file/upload")
                .tag(this)
                .params("file_name","headimg")
                .params("headimg",file)
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
                            bean = JsonUtil.jsonToEntity(s,UpLoadBean.class);
                            path = bean.getData();
                            updata();
                        }
                        Toast.makeText(getContext(),bean.getMsg(),Toast.LENGTH_SHORT).show();
                    }
                });
    }


    public void updata(){
        OkHttpUtils.post(HttpAdress.meupdate)
                .params("head_img",path)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        StringModel model = JsonUtil.jsonToEntity(s,StringModel.class);
                        if(model.getCode() == 200){

                        }
                    }
                });
    }


}
