package com.winterjk.mvp.login.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.winterjk.mvp.R;
import com.winterjk.mvp.login.bean.UserBean;
import com.winterjk.mvp.login.presenter.LoginContract;
import com.winterjk.mvp.login.presenter.LoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 注册页面
 * Created by WinterJK on 2017/8/6.
 */

public class RegisterActivity extends Activity implements View.OnClickListener, LoginContract.View {

    @BindView(R.id.et_register_name)
    EditText mRegisterName;
    @BindView(R.id.et_register_password)
    EditText mtRegisterPassword;
    @BindView(R.id.bt_register)
    Button mRegister;
    @BindView(R.id.bt_back)
    Button mBack;
    private LoginPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        mRegister.setOnClickListener(this);
        mBack.setOnClickListener(this);
        mPresenter = new LoginPresenter(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.bt_back:
                this.finish();
                break;
            case R.id.bt_register:
                mPresenter.saveUserInfo();
                break;
            default:
                break;
        }
    }

    @Override
    public String getUserName() {
        return mRegisterName.getText().toString().trim();
    }

    @Override
    public String getUserPassword() {
        return mtRegisterPassword.getText().toString().trim();
    }

    @Override
    public UserBean getUserInfo() {
        return null;
    }

    @Override
    public void setUserName(String name) {

    }

    @Override
    public void setUserInfo() {

    }
}
