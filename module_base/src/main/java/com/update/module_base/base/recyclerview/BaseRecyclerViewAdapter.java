package com.update.module_base.base.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : liupu
 * date    : 2019/4/22
 * desc    :
 */
public abstract class BaseRecyclerViewAdapter<T extends BaseRecyclerViewItem, H extends RecyclerView.ViewHolder> extends RecyclerView.Adapter{

    protected Context context;
    protected List<T> data;

    public BaseRecyclerViewAdapter(Context context) {
        this.context = context;
        data = new ArrayList<T>();
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    protected abstract int getType(int position);
}
