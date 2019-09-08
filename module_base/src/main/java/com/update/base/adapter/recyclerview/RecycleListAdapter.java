package com.update.base.adapter.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.update.base.utils.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public abstract class RecycleListAdapter<T, K extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<K> {

    protected List<T> mData;
    private int layoutId;

    public RecycleListAdapter() {
        this(new ArrayList<>());
    }

    public RecycleListAdapter(List<T> data) {
        super();
        this.mData = data;
    }

    @Override
    public abstract K onCreateViewHolder(ViewGroup parent, int viewType);

    @Override
    public abstract void onBindViewHolder(K holder, int position);

    public T getItem(int position) {
        return mData.get(position);
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public void setData(List<T> data) {
        if (CollectionUtils.isEmpty(data)) {
            return;
        }
        this.mData = data;
        notifyDataSetChanged();
    }

    /**
     * addItem 2 First
     */
    public void addItem2First(T item) {
        addItem2First(false, item);
    }

    public void addItem2First(boolean isAnim, T item) {
        addItem(isAnim, 0, item);
    }

    public void addItems2First(T... items) {
        addItems2First(false, items);
    }

    public void addItems2First(boolean isAnim, T... items) {
        addItems(isAnim, 0, items);
    }

    public void addItems2First(List<T> items) {
        addItems2First(false, items);
    }

    public void addItems2First(boolean isAnim, List<T> items) {
        addItems(isAnim, 0, items);
    }


    /**
     * addItem 2 Last
     */
    public void addItem2Last(T item) {
        addItem2Last(false, item);
    }

    public void addItem2Last(boolean isAnim, T item) {
        int count = mData.size();
        addItem(isAnim, count, item);
    }

    public void addItems2Last(T... items) {
        addItems2Last(false, items);
    }

    public void addItems2Last(boolean isAnim, T... items) {
        if (items == null || items.length == 0) {
            return;
        }
        int count = mData.size();
        addItems(isAnim, count, items);
    }

    public void addItems2Last(List<T> items) {
        addItems2Last(false, items);
    }

    public void addItems2Last(boolean isAnim, List<T> items) {
        if (CollectionUtils.isEmpty(items)) {
            return;
        }
        int count = mData.size();
        addItems(isAnim, count, items);
    }

    public void addItems(int index, T... items) {
        addItems(false, index, items);
    }

    /**
     * addItems
     */
    public void addItems(boolean isAnim, int index, T... items) {
        if (items == null || items.length == 0) {
            return;
        }
        mData.addAll(index, Arrays.asList(items));
        if (isAnim) {
            notifyItemRangeInserted(index, items.length);
        } else {
            notifyDataSetChanged();
        }
    }

    public void addItems(int index, List<T> items) {
        addItems(false, index, items);
    }

    public void addItems(boolean isAnim, int index, List<T> items) {
        if (CollectionUtils.isEmpty(items)) {
            return;
        }
        mData.addAll(index, items);
        if (isAnim) {
            notifyItemRangeInserted(index, items.size());
        } else {
            notifyDataSetChanged();
        }
    }

    /**
     * addItem
     */
    public void addItem(int index, T item) {
        addItem(false, index, item);
    }

    public void addItem(boolean isAnim, int index, T item) {
        mData.add(index, item);
        if (isAnim) {
            notifyItemInserted(index);
        } else {
            notifyDataSetChanged();
        }
    }

    /**
     * remove
     */
    public void remove(T data) {
        remove(false, data);
    }

    public void remove(boolean isAnim, T data) {
        int index = mData.indexOf(data);
        if (index >= 0) {
            mData.remove(data);
            if (isAnim) {
                notifyItemRemoved(index);
            } else {
                notifyDataSetChanged();
            }
        }
    }

    /**
     * removes
     */
    public void removes(List<T> data) {
        removes(false, data);
    }

    public void removes(boolean isAnim, List<T> data) {
        if (CollectionUtils.isEmpty(data)) {
            return;
        }
        mData.removeAll(data);
        notifyDataSetChanged();

        int index = Collections.indexOfSubList(mData, data);
        if (index >= 0) {
            mData.removeAll(data);
            if (isAnim) {
                notifyItemRangeRemoved(index, data.size());
            } else {
                notifyDataSetChanged();
            }
        }
    }

    public void clearAll() {
        if (mData != null) {
            mData.clear();
            notifyDataSetChanged();
        }
    }
}
