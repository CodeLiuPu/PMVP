package com.update.base.adapter.recyclerview;

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
 * github : https://github.com/CodeLiuPu/
 */
public class BaseRVAdapter<T extends BaseRVItem, H extends RecyclerView.ViewHolder> extends RecyclerView.Adapter{

    protected Context context;
    protected List<T> data;

    public BaseRVAdapter(Context context) {
        this.context = context;
        data = new ArrayList<>();
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
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        return data.get(position).type;
    }
}