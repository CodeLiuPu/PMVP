package com.update.base.utils.take_photo;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Looper;
import android.provider.ContactsContract;

import com.update.base.GlobalContext;

/**
 * @author : liupu
 * date   : 2019/10/15
 * desc   : 拍照帮助类
 * github : https://github.com/CodeLiuPu/
 */
public class TakePhotoUtil extends GlobalContext {
    private static final String INTERNAL_FRAGMENT_TAG = "take_photo_bridge_fragment";
    static final int INTERNAL_REQUEST_CODE = 9527;

    private Activity activity;
    private TPBridgeFragment bridgeFragment;

    private TakePhotoUtil(Activity activity) {
        this.activity = activity;
        checkThread();
        bridgeFragment = getInternalFragment();
    }

    public static TakePhotoUtil with(Activity activity) {
        return new TakePhotoUtil(activity);
    }


    public void takePhoto(TPBridgeFragment.OnTakePhotoListener listener) {
        if (activity == null) {
            throw new RuntimeException("call with() first");
        }
        bridgeFragment.setResultListener(listener);
        Intent intent = new Intent(Intent.ACTION_PICK,
                ContactsContract.Contacts.CONTENT_URI);
        bridgeFragment.startActivityForResult(intent, INTERNAL_REQUEST_CODE);
    }

    private void checkThread() {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new RuntimeException("u should call this method in Main Thread");
        }
    }

    private TPBridgeFragment getInternalFragment() {
        TPBridgeFragment fragment = findInternalFragment();
        if (fragment == null) {
            synchronized (TakePhotoUtil.class) {
                fragment = findInternalFragment();
                if (fragment == null) {
                    fragment = new TPBridgeFragment();
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

    private TPBridgeFragment findInternalFragment() {
        return (TPBridgeFragment) activity.getFragmentManager().findFragmentByTag(INTERNAL_FRAGMENT_TAG);
    }


}
