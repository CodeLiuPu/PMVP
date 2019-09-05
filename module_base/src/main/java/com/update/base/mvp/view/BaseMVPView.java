package com.update.base.mvp.view;

import com.uber.autodispose.AutoDisposeConverter;

/**
 * @author : liupu
 * date   : 2019/4/15
 * desc   :
 * github : https://github.com/CodeLiuPu/
 */
public interface BaseMVPView {
    /**
     * 绑定Android生命周期 防止RxJava内存泄漏
     *
     * @param <T>
     * @return
     */
    <T> AutoDisposeConverter<T> bindAutoDispose();
}