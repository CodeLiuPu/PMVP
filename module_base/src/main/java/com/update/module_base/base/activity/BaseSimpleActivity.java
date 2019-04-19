package com.update.module_base.base.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * author : liupu
 * date   : 2019/4/19
 * desc   :
 */
public abstract class BaseSimpleActivity extends AppCompatActivity {
    protected Context mContext;
    protected BaseSimpleActivity mActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = this;
        mActivity = this;
        setContentView(getLayoutId());

        initView();
        initData();
    }

    protected abstract int getLayoutId();

    protected void initView() {
    }

    protected abstract void initData();

}
