package com.update.base.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @author : liupu
 * date   : 2019/4/19
 * desc   :
 * github : https://github.com/CodeLiuPu/
 */
public abstract class BaseSimpleActivity extends AppCompatActivity {
    protected BaseSimpleActivity activity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activity = this;
        setContentView(getLayoutId());

        initView();
        initData();
    }

    protected abstract int getLayoutId();

    protected void initView() {
    }

    protected abstract void initData();

}
