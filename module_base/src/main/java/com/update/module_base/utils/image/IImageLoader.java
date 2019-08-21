package com.update.module_base.utils.image;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.widget.ImageView;

public interface IImageLoader {

    void load(ImageView imageView);

    IImageLoader init(Context context);

    IImageLoader init(Fragment fragment);


}
