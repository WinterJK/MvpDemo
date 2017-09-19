package com.winterjk.mvp.login.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.winterjk.mvp.R;
import com.winterjk.mvp.login.bean.UserBean;
import com.winterjk.mvp.login.presenter.LoginContract;
import com.winterjk.mvp.login.presenter.LoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 登录界面
 * Created by WinterJK on 2017/8/6.
 */

public class LoginActivity extends Activity implements View.OnClickListener, LoginContract.View {

    @BindView(R.id.et_login_name)
    EditText mLoginName;
    @BindView(R.id.et_login_password)
    EditText mLoginPassword;
    @BindView(R.id.bt_login_login)
    Button mtLoginLogin;
    @BindView(R.id.bt_login_register)
    Button mLoginRegister;
    LoginPresenter mPresenter;
    @BindView(R.id.tv_login_info)
    TextView mLoginInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mPresenter = new LoginPresenter(this);
        mtLoginLogin.setOnClickListener(this);
        mLoginRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.bt_login_login:
                mPresenter.loadUserInfo();
                break;

            case R.id.bt_login_register:
                startActivity(new Intent("com.winterjk.mvp.antion.REGISTER"));
                break;

            default:
                break;

        }

    }

    @Override
    public String getUserName() {
        return mLoginName.getText().toString().trim();
    }

    @Override
    public String getUserPassword() {
        return mLoginPassword.getText().toString().trim();
    }

    @Override
    public UserBean getUserInfo() {
        return null;
    }

    @Override
    public void setUserName(String name) {
        mLoginInfo.setText("用户信息:" + name);
    }

    @Override
    public void setUserInfo() {

    }
}
