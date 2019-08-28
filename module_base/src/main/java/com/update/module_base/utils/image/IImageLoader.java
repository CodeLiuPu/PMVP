package com.update.module_base.utils.image;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.widget.ImageView;

/**
 * @author : liupu
 * date   : 2019/8/22
 * desc   :
 * github : https://github.com/CodeLiuPu/
 */
public interface IImageLoader {

    void load(ImageView imageView);

    IImageLoader init(Context context);

    IImageLoader init(Fragment fragment);


}
