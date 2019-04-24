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
public abstract class BaseRecyclerViewHolder<T extends BaseRecyclerViewItem> extends RecyclerView.ViewHolder {
    public BaseRecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    protected abstract void injectView(T t, Context context);
}
