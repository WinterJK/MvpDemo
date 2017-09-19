package com.winterjk.mvp.login.presenter;

import android.text.TextUtils;
import android.widget.Toast;

import com.winterjk.mvp.App;
import com.winterjk.mvp.R;
import com.winterjk.mvp.login.model.IUserData;
import com.winterjk.mvp.login.model.UserDataImpl;

/**
 * Created by WinterJK on 2017/8/6.
 */

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View mView;
    private IUserData mUserData;

    public LoginPresenter(LoginContract.View mView) {
        this.mView = mView;
        mUserData = new UserDataImpl();
    }


    @Override
    public boolean saveUserInfo() {
        if (TextUtils.isEmpty(mView.getUserName()) || TextUtils.isEmpty(mView.getUserPassword())) {
            Toast.makeText(App.getContext(), R.string.hint_none, Toast.LENGTH_LONG).show();
            return false;
        } else {
            mUserData.saveUserInfo(mView.getUserName(), mView.getUserPassword());
            Toast.makeText(App.getContext(), R.string.hint_register_succeed, Toast.LENGTH_LONG).show();
            return true;
        }

    }

    @Override
    public void loadUserInfo() {
        String userName = mView.getUserName();
        String userPassword = mView.getUserPassword();
        boolean succeed = mUserData.loadUserInfo(userName, userPassword);
        if (succeed) {
            Toast.makeText(App.getContext(), R.string.hint_login_succeed, Toast.LENGTH_LONG).show();
            //UserBean bean = mUserData.loadUserInfo(0);
            mView.setUserName(userName);
        } else {
            boolean isTrueName = mUserData.loadUserInfo(userName);
            if (isTrueName) {
                Toast.makeText(App.getContext(), R.string.hint_password_error, Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(App.getContext(), R.string.hint_user_none, Toast.LENGTH_LONG).show();
            }
        }

    }
}
