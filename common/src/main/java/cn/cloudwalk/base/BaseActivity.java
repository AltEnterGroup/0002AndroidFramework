/**
 * Project Name:pg2
 * Create User:yusr
 * Update User:yusr
 * Package Name:cn.cloudwalk.base
 * Date:2016/9/2711:21
 * Copyright @ 2010-2016 Cloudwalk Information Technology Co.Ltd All Rights Reserved.
 */
package cn.cloudwalk.base;/**
 * Create User:yusr
 * Date:2016/9/2711:21
 * Copyright @ 2010-2016 Cloudwalk Information Technology Co.Ltd All Rights Reserved.
 */

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.view.KeyEvent;

import com.bigkoo.alertview.AlertView;
import com.bigkoo.alertview.OnItemClickListener;
import com.litesuits.common.assist.Toastor;
import com.litesuits.common.utils.DialogUtil;

import java.io.File;
import java.util.List;

import cn.cloudwalk.libproject.progressHUD.CwProgressHUD;
import me.yokeyword.fragmentation.SupportActivity;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;


/**
 * ClassName: BaseActivity <br/>
 * Description: TODO Description. <br/>
 * date: 2016/9/27 11:21<br/>
 *
 * @author 284891377
 * @version v1.0.0
 * @since JDK 1.7
 */
public abstract class BaseActivity extends SupportActivity implements EasyPermissions.PermissionCallbacks {
    //step1 添加fragment
    //step2 移除fragment
    //step3 返回键处理
    //step4 progressDialog的统一处理
    /**
     * 进度框
     **/
    CwProgressHUD processDialog;
    /**
     * 提示框
     **/
    Dialog mDialog;
    Toastor mToastor;
    AlertView alertView;

    //选图片
    private final static int REQ_PHOTO1 = 1, REQ_CAMERA1 = 2;

    //TODO  这三个方法的必要性

    public abstract void initView();

    public abstract void initEvent();

    public abstract void initData();

    /**
     * setContentView里完成 initView() initEvent() initData()
     *
     * @param layoutResID
     */
    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        initView();
        initEvent();
        initData();

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        initView();
//        initEvent();
//        initData();

    }

    //返回键返回事件
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (KeyEvent.KEYCODE_BACK == keyCode) {
            if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
                finish();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (processDialog != null && processDialog.isShowing())
            processDialog.dismiss();
        if (mDialog != null && mDialog.isShowing())
            mDialog.dismiss();
        if (alertView != null && alertView.isShowing())
            alertView.dismiss();
    }


    //对话框----------------------------
    public void showTips(Context context, String title, String des) {
        mDialog = DialogUtil.showTips(context, title, des, null, null);

    }

    public void showTips(Context context, int title, int des) {
        mDialog = DialogUtil.showTips(context, context.getString(title), context.getString(des));
    }

    public void showTips(Context context, int title, int des, int btn, DialogInterface.OnDismissListener dismissListener) {
        mDialog = DialogUtil.showTips(context, context.getString(title), context.getString(des), context.getString(btn), dismissListener);

    }

    //进度框----------------------------
    public void showProcessDialog(String lable) {
        processDialog = CwProgressHUD.create(this).setStyle(CwProgressHUD.Style.SPIN_INDETERMINATE).setLabel(lable)
                .setCancellable(false).setAnimationSpeed(2).setDimAmount(0.5f);
        processDialog.show();
    }

    public void hideProcessDialog() {
        if (processDialog != null && processDialog.isShowing())
            processDialog.dismiss();
    }
    //toast------------------------------

    /**
     * toast显示 Toast.LENGTH_SHORT
     *
     * @param text
     */
    public void showSingletonToast(String text) {
        if (mToastor == null) mToastor = new Toastor(this);
        mToastor.getSingletonToast(text).show();
    }

    /**
     * toast显示 Toast.LENGTH_SHORT
     *
     * @param text
     */
    public void showSingleLongToast(String text) {
        if (mToastor == null) mToastor = new Toastor(this);
        mToastor.getSingleLongToast(text).show();
    }

    /**
     * toast显示 Toast.LENGTH_SHORT
     *
     * @param resId
     */
    public void showSingletonToast(int resId) {
        if (mToastor == null) mToastor = new Toastor(this);
        mToastor.getSingletonToast(resId).show();
    }

    /**
     * toast显示 Toast.LENGTH_SHORT
     *
     * @param resId
     */
    public void showSingleLongToast(int resId) {
        if (mToastor == null) mToastor = new Toastor(this);
        mToastor.getSingleLongToast(resId).show();
    }
    //类之间跳转(动画)


    public void goAct(Class cls) {
        startActivity(new Intent(this, cls));

    }

    //alertView 选择图片
    public void showSelectPic(final int req_photo, final int req_camera, final File cametaImgFile) {
        alertView = new AlertView("上传头像", null, "取消", null,
                new String[]{"拍照", "从相册中选择"},
                this, AlertView.Style.ActionSheet, new OnItemClickListener() {
            public void onItemClick(Object o, int position) {
                if (position == 0) {
                    intentCamera(req_camera, cametaImgFile);
                } else if (position == 1) {
                    IntentPhoto(req_photo);
                } else {
                    alertView.dismiss();
                }
            }
        });
        alertView.show();
    }

    /**
     * 图片选择
     *
     * @param requestCode
     */
    public void IntentPhoto(final int requestCode) {
//new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.MOUNT_UNMOUNT_FILESYSTEMS}
        permissionsTask(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}//
                , null, new OnPermissionsCallBack() {
                    @Override
                    public void permissionsCallBack(boolean isSuc) {
                        if (isSuc) IntentPhoto2(requestCode);
                    }
                });

    }

    public void IntentPhoto2(int requestCode) {
//new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.MOUNT_UNMOUNT_FILESYSTEMS}
        Intent intent;
        if (Build.VERSION.SDK_INT < 19) {
            intent = new Intent();
            intent.setAction(Intent.ACTION_GET_CONTENT);
            intent.setType("image/*");
            startActivityForResult(Intent.createChooser(intent, "选择图片"), requestCode);
        } else {
            intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.setType("image/*");
            startActivityForResult(Intent.createChooser(intent, "选择图片"), requestCode);
        }


    }

    /**
     * 打开照相机
     *
     * @param requestCode
     */
    public void intentCamera(int requestCode, File cametaImgFile) {
        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        Uri mUri = Uri.fromFile(cametaImgFile);
        cameraIntent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, mUri);
        cameraIntent.putExtra("return-data", true);
        startActivityForResult(cameraIntent, requestCode);


    }

    //动态权限
    public interface OnPermissionsCallBack {
        public void permissionsCallBack(boolean isSuc);
    }

    OnPermissionsCallBack onPermissionsCallBack;
    final static int RC_PERM = 1000;

    public void permissionsTask(String[] permissions, String msg, OnPermissionsCallBack onPermissionsCallBack) {
        this.onPermissionsCallBack = onPermissionsCallBack;
        if (EasyPermissions.hasPermissions(this, permissions)) {
            onPermissionsCallBack.permissionsCallBack(true);
        } else {
            EasyPermissions.requestPermissions(this, msg, RC_PERM,
                    permissions);
        }
    }

    //动态权限
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // 请求 EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
        if (onPermissionsCallBack != null) onPermissionsCallBack.permissionsCallBack(true);
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            new AppSettingsDialog.Builder(this, "缺少必要权限\n不然将导致部分功能无法正常使用")
                    .setTitle("温馨提示")
                    .setPositiveButton("去设置")
                    .setNegativeButton("下次吧", null /* click listener */)
                    // .setRequestCode(RC_SETTINGS_SCREEN)
                    .build()
                    .show();
        }
    }
}