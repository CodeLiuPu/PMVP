package com.update.base.utils.take_photo;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;

/**
 * @author : liupu
 * date   : 2019/10/15
 * desc   : 拍照 辅助Fragment
 * github : https://github.com/CodeLiuPu/
 */
public class TPBridgeFragment extends Fragment {
    interface OnTakePhotoResultListener {
        void onContactChoiceResult(String name, String phone);
    }
    private OnTakePhotoResultListener onResultListener;

    void setOnResultListener(OnTakePhotoResultListener listener) {
        this.onResultListener = listener;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 默认情况下，但配置发生变化时，Fragment会随着它们的宿主Activity被创建和销毁。
        // 调用Fragment#setRetaininstance(true)允许我们跳过销毁和重新创建的周期。
        // 指示系统保留当前的fragment实例，即使是在Activity被创新创建的时候。
        setRetainInstance(true);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {

//        if (ContactChoiceUtils.INTERNAL_REQUEST_CODE == requestCode && this.onResultListener != null
//                && (getActivity() != null && !getActivity().isFinishing()) && intent != null && intent.getData() != null) {
//            Uri uri = intent.getData();
//            String[] contacts = ContactChoiceUtils.getContactNameAndPhoneNumber(getActivity(), uri);
//            String name = contacts[0];
//            String phone = contacts[1];
//            this.onResultListener.onContactChoiceResult(name, phone);
//        }
    }
}
