package com.winterjk.mvp.login.presenter;

import com.winterjk.mvp.login.bean.UserBean;

/**
 * Created by WinterJk on 2017/8/6.
 */

public interface LoginContract {

    interface View {

        String getUserName();

        String getUserPassword();

        UserBean getUserInfo();

        void setUserName(String name);

        void setUserInfo();
    }

    interface Presenter {
        boolean saveUserInfo();

        void loadUserInfo();
    }
}
