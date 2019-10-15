package com.update.pmvp.ui.main.view;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.update.base.ui.activity.BaseMvpActivity;
import com.update.base.utils.log.LogUtil;
import com.update.base.utils.select_photo.SPBridgeFragment;
import com.update.base.utils.select_photo.SelectPhotoUtil;
import com.update.pmvp.R;
import com.update.pmvp.ui.login.contract.LoginContract;
import com.update.pmvp.ui.main.contract.MainContract;
import com.update.pmvp.ui.main.presenter.MainPresenter;

/**
 * @author : liupu
 * date   : 2019/4/19
 * desc   :
 * github : https://github.com/CodeLiuPu/
 */
public class MainActivity extends BaseMvpActivity<MainPresenter> implements MainContract.View, LoginContract.View, View.OnClickListener {
    TextView tv_content;
    ImageView iv;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        super.initView();
        tv_content = findViewById(R.id.tv_content);
        iv = findViewById(R.id.iv);

        findViewById(R.id.btn).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected MainPresenter initPresenter() {
        return new MainPresenter(this);
    }

    @Override
    public void loadDataSuccess(String content) {
        tv_content.setText(content);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                mPresenter.loadData();
                break;
            case R.id.btn2:
//                new LoginPresenter(this).login();
//                startActivity(new Intent(this, LoginActivity.class));

                SelectPhotoUtil.with(this).takePhoto(new SPBridgeFragment.OnSelectPhotoListener() {
                    @Override
                    public void onSelectPhotoSuccess(Bitmap bitmap) {
                        LogUtil.e("SelectPhotoUtil succss");
                        iv.setImageBitmap(bitmap);
                    }

                    @Override
                    public void onSelectPhotoFail() {
                        LogUtil.e("SelectPhotoUtil failllllll");
                    }
                });
                break;
            default:
        }
    }

    @Override
    public void loginSuccess(String content) {
        tv_content.setText("login");

    }
}
