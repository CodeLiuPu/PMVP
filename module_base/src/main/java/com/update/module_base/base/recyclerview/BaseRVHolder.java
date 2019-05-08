package com.update.module_base.base.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * @author : liupu
 * date    : 2019/4/22
 * desc    :
 */
public class BaseRVHolder<T extends BaseRVItem> extends RecyclerView.ViewHolder {
    public BaseRVHolder(@NonNull View itemView) {
        super(itemView);
    }

    protected void injectView(T t, Context context){

    }
}
