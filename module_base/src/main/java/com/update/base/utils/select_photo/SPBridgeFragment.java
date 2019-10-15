package com.update.base.utils.select_photo;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import static android.app.Activity.RESULT_OK;

/**
 * @author : liupu
 * date   : 2019/10/15
 * desc   : 拍照 辅助Fragment
 * github : https://github.com/CodeLiuPu/
 */
public class SPBridgeFragment extends Fragment {
    public interface OnSelectPhotoResultListener {
        void onSelectPhotoResultSuccess(Bitmap bitmap);

        void onSelectPhotoResultFail();
    }

    private OnSelectPhotoResultListener onResultListener;

    void setOnResultListener(OnSelectPhotoResultListener listener) {
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
        if (SelectPhotoUtil.INTERNAL_REQUEST_CODE == requestCode
                && resultCode == RESULT_OK
                && this.onResultListener != null
                && (getActivity() != null
                && !getActivity().isFinishing())
                && intent != null
                && intent.getData() != null) {
            Bitmap bitmap = SelectPhotoUtil.uri2Bitmap(intent.getData());
            this.onResultListener.onSelectPhotoResultSuccess(bitmap);
        } else {
            this.onResultListener.onSelectPhotoResultFail();
        }
    }
}
