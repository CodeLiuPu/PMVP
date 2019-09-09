package com.update.base.mvp.view;

import android.arch.lifecycle.LifecycleObserver;
import android.support.annotation.Nullable;

import com.uber.autodispose.AutoDisposeConverter;

/**
 * @author : liupu
 * date   : 2019/4/15
 * desc   :
 * github : https://github.com/CodeLiuPu/
 */
public interface BaseMVPView {

    <V extends LifecycleObserver> void addObserver(@Nullable V observer);

    /**
     * 绑定Android生命周期 防止RxJava内存泄漏
     */
    <T> AutoDisposeConverter<T> bindAutoDispose();
}