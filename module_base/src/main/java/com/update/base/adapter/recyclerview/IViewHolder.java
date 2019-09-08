package com.update.base.adapter.recyclerview;

import android.support.annotation.IdRes;
import android.support.annotation.StringRes;
import android.view.View;

import com.update.base.utils.ResUtils;


public interface IViewHolder<T> {

    View getConvertView();

    <V extends View> V findViewById(int viewId);

    <V extends View> V putViewById(@IdRes int viewId);

    T setText(@IdRes int viewId, String value);

    default T setText(@IdRes int viewId, @StringRes int value) {
        return setText(viewId, ResUtils.getString(value));
    }

}
