package com.ccsoft.yunqudao.ui.fragment;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
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
import com.ccsoft.yunqudao.bean.Province;
import com.ccsoft.yunqudao.http.HttpAdress;
import com.ccsoft.yunqudao.model.PersonCenterModel;
import com.ccsoft.yunqudao.ui.me.GongSiRenZheng1Activity;
import com.ccsoft.yunqudao.ui.me.GongSiRenZhengWanActivity;
import com.ccsoft.yunqudao.ui.me.GongSiRenZhengZhongActivity;
import com.ccsoft.yunqudao.ui.me.GongZuoJingLiActivity;
import com.ccsoft.yunqudao.ui.me.WoDeGuanZhuActivity;
import com.ccsoft.yunqudao.ui.me.WoDeYongJinActivity;
import com.ccsoft.yunqudao.ui.me.WoDeZiLiaoActivity;
import com.ccsoft.yunqudao.ui.me.YiJianFanKuiActivity;
import com.ccsoft.yunqudao.ui.me.PactActivity;
import com.ccsoft.yunqudao.ui.mian.LoginActivity;
import com.ccsoft.yunqudao.utils.CircleImageView;
import com.ccsoft.yunqudao.utils.ItemsDialogFragment;
import com.ccsoft.yunqudao.utils.JsonUtil;
import com.ccsoft.yunqudao.utils.LocalJsonResolutionUtils;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.callback.StringCallback;

import org.jaaksi.pickerview.dataset.OptionDataSet;
import org.jaaksi.pickerview.picker.OptionPicker;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

import static android.app.Activity.RESULT_OK;
import static com.umeng.socialize.utils.ContextUtil.getPackageName;

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
    private TextView     mMe_text_yunsuan_id;
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




    private String icon = "上传地址";

    //相册请求码
    private static final int ALBUM_REQUEST_CODE = 4;
    //    //相机请求码
//    private static final int CAMERA_REQUEST_CODE = 2;
//    //剪裁请求码
    private static final int CROP_REQUEST_CODE = 3;
    public final int TYPE_TAKE_PHOTO = 1;//Uri获取类型判断

    public final int CODE_TAKE_PHOTO = 1;//相机RequestCode





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

                                        }

                                    }
                                }
                                else if(code == 401){
                                    Intent intent = new Intent(getContext(), LoginActivity.class);
                                    startActivity(intent);
                                    Toast.makeText(getContext(),"token失效，请重新登陆",Toast.LENGTH_SHORT).show();
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
        }, getFragmentManager());
    }

    private void checkPermission() {
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            // 进入这儿表示没有权限
            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.CAMERA)) {
                // 提示已经禁止

            } else {
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA}, 100);
            }
        } else {
            if (Build.VERSION.SDK_INT >= 24) {
                Intent takeIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                photoUri = get24MediaFileUri(TYPE_TAKE_PHOTO);
                takeIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
                startActivityForResult(takeIntent, CODE_TAKE_PHOTO);
            } else {
                Intent takeIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                photoUri = getMediaFileUri(TYPE_TAKE_PHOTO);
                takeIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
                startActivityForResult(takeIntent, CODE_TAKE_PHOTO);
            }
        }
    }


    /**
     * 从相机获取图片
     */

    public Uri get24MediaFileUri(int type) {
        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "相册名字");
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                return null;
            }
        }
        //创建Media File
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File mediaFile;
        if (type == TYPE_TAKE_PHOTO) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator + "IMG_" + timeStamp + ".jpg");
        } else {
            return null;
        }
        return FileProvider.getUriForFile(getContext(), getPackageName() + ".fileProvider", mediaFile);
    }



    public Uri getMediaFileUri(int type) {
        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "相册名字");
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                return null;
            }
        }
        //创建Media File
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File mediaFile;
        if (type == TYPE_TAKE_PHOTO) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator + "IMG_" + timeStamp + ".jpg");
        } else {
            return null;
        }
        return Uri.fromFile(mediaFile);
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
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        switch (requestCode) {
            case CODE_TAKE_PHOTO:   //调用相机后返回
                if (resultCode == RESULT_OK) {

                    if (intent.hasExtra("data")) {
                        Log.e("URI", "data is not null");
                        Bitmap bitmap = intent.getParcelableExtra("data");
                        mImage.setImageBitmap(bitmap);//imageView即为当前页面需要展示照片的控件，可替换
                    }
                    else {
                        Log.e("URI", "Data is null");
                        if (Build.VERSION.SDK_INT >= 24){
                            Bitmap bitmap = null;
                            try {
                                bitmap = BitmapFactory.decodeStream(getContext().getContentResolver().openInputStream(photoUri));
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                            mImage.setImageBitmap(bitmap);
                        }else {
                            Bitmap bitmap = BitmapFactory.decodeFile(photoUri.getPath());
                            mImage.setImageBitmap(bitmap);
                        }
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


}
