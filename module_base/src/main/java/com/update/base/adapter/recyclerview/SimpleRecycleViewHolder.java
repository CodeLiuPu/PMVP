package com.update.base.adapter.recyclerview;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public final class SimpleRecycleViewHolder extends RecyclerView.ViewHolder implements IViewHolder<SimpleRecycleViewHolder> {

    public static SimpleRecycleViewHolder getViewHolder(ViewGroup parent, int layoutId) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(layoutId, parent, false);
        return new SimpleRecycleViewHolder(itemView);
    }

    public SimpleRecycleViewHolder(View itemView) {
        super(itemView);
    }

    private final SparseArrayCompat<View> views = new SparseArrayCompat<>();

    @Override
    public final View getConvertView() {
        return itemView;
    }

    @Override
    public final <V extends View> V findViewById(int viewId) {
        View view = views.get(viewId);
        if (view != null) {
            return (V) view;
        } else {
            return putViewById(viewId);
        }
    }

    @Override
    public final <V extends View> V putViewById(@IdRes int viewId) {
        V tView = (V) itemView.findViewById(viewId);
        views.put(viewId, tView);
        return tView;
    }

    @Override
    public SimpleRecycleViewHolder setText(int viewId, String value) {
        TextView textView = findViewById(viewId);
        textView.setText(value);
        return this;
    }

    @Override
    public void setOnClickListener(int viewId, View.OnClickListener listener) {
        findViewById(viewId).setOnClickListener(listener);
    }
}
