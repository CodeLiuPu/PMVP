package com.update.base.utils;

import java.util.Collection;

/**
 * @author : liupu
 * date    : 2019/9/8
 * desc    :
 * github : https://github.com/CodeLiuPu/
 */
public class CollectionUtils {

    public static boolean notEmpty(Collection collection) {
        return collection != null && collection.size() > 0;
    }

    public static boolean isEmpty(Collection collection) {
        return !notEmpty(collection);
    }

}
