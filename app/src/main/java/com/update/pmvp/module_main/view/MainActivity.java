package com.update.pmvp.module_main.view;

import android.view.View;
import android.widget.TextView;

import com.update.module_base.base.activity.BaseMvpActivity;
import com.update.pmvp.R;
import com.update.pmvp.module_main.contract.MainContract;
import com.update.pmvp.module_main.presenter.MainPresenter;

/**
 * @author : liupu
 * date   : 2019/4/19
 * desc   :
 */
public class MainActivity extends BaseMvpActivity<MainPresenter> implements MainContract.View {
    TextView tv_content;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        tv_content = findViewById(R.id.tv_content);
        tv_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.loadData();
            }
        });
    }

    @Override
    protected MainPresenter initPresenter() {
        return new MainPresenter();
    }

    @Override
    public void updateUI(String content) {
        tv_content.setText(content);
    }
}
