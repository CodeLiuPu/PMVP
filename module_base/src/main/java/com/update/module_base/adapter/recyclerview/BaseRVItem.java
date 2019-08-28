package com.update.module_base.adapter.recyclerview;

/**
 * @author : liupu
 * date   : 2019/4/24
 * desc   :
 * github : https://github.com/CodeLiuPu/
 */
public class BaseRVItem implements Comparable<BaseRVItem> {
    public int type = -1;
    public Object object;

    public BaseRVItem(int type, Object object) {
        this.type = type;
        this.object = object;
    }

    @Override
    public int compareTo(BaseRVItem item) {
        return this.type >= item.type ? 1 : -1;
    }
}
