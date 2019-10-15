package com.update.base.utils.select_photo;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Looper;
import android.provider.MediaStore;

import com.update.base.GlobalContext;
import com.update.base.utils.take_photo.TakePhotoUtil;

import java.io.IOException;

/**
 * @author : liupu
 * date   : 2019/10/15
 * desc   : 从相册选择照片帮助类
 * github : https://github.com/CodeLiuPu/
 */
public class SelectPhotoUtil extends GlobalContext {
    private static final String INTERNAL_FRAGMENT_TAG = "select_photo_bridge_fragment";
    static final int INTERNAL_REQUEST_CODE = 9527;

    private Activity activity;
    private SPBridgeFragment bridgeFragment;

    private SelectPhotoUtil(Activity activity) {
        this.activity = activity;
        checkThread();
        bridgeFragment = getInternalFragment();
    }

    public static SelectPhotoUtil with(Activity activity) {
        return new SelectPhotoUtil(activity);
    }

    public void takePhoto(SPBridgeFragment.OnSelectPhotoListener listener) {
        if (activity == null) {
            throw new RuntimeException("call with() first");
        }
        bridgeFragment.setResultListener(listener);

        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        bridgeFragment.startActivityForResult(intent, INTERNAL_REQUEST_CODE);
    }

    private void checkThread() {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new RuntimeException("u should call this method in Main Thread");
        }
    }

    private SPBridgeFragment getInternalFragment() {
        SPBridgeFragment fragment = findInternalFragment();
        if (fragment == null) {
            synchronized (TakePhotoUtil.class) {
                fragment = findInternalFragment();
                if (fragment == null) {
                    fragment = new SPBridgeFragment();
                    FragmentManager fragmentManager = activity.getFragmentManager();
                    fragmentManager.beginTransaction()
                            .add(fragment, INTERNAL_FRAGMENT_TAG)
                            .commitAllowingStateLoss();
                    // commit()调用之后加上 executePendingTransactions()来保证立即执行, 即变异步为同步.
                    fragmentManager.executePendingTransactions();
                }
            }
        }
        return fragment;
    }

    private SPBridgeFragment findInternalFragment() {
        return (SPBridgeFragment) activity.getFragmentManager().findFragmentByTag(INTERNAL_FRAGMENT_TAG);
    }


    public static Bitmap uri2Bitmap(Uri uri) {
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(getApp().getContentResolver(), uri);
            return bitmap;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}