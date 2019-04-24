package com.update.module_base.base.recyclerview;

/**
 * @author : liupu
 * date   : 2019/4/24
 * desc   :
 */
public class BaseRecyclerViewItem {
    public int type = -1;
    public Object object;

    public BaseRecyclerViewItem(int type, Object object) {
        this.type = type;
        this.object = object;
    }
}
