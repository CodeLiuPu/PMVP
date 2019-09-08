package com.update.base.adapter.pager;

import java.util.List;


public interface IViewPagerAdapterHelper<K, V extends IViewPagerAdapterHelper<K, V>> {

    V addTitle(CharSequence charSequence);

    V addItem(K item);

    V addItemTitles(List<CharSequence> itemTitles);

    V addItems(List<K> items);

    default V addItem(K item, CharSequence itemTitle) {
        return addItem(item).addTitle(itemTitle);
    }

    default V addItems(List<K> items, List<CharSequence> itemTitles) {
        return addItems(items).addItemTitles(itemTitles);
    }

}
