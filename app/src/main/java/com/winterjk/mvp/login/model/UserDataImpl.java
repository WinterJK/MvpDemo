package com.winterjk.mvp.login.model;

import android.content.Context;
import android.text.TextUtils;

import com.winterjk.mvp.App;
import com.winterjk.mvp.login.bean.UserBean;
import com.winterjk.mvp.utils.SPUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据实现类
 * Created by WinterJk on 2017/7/23.
 */

public class UserDataImpl implements IUserData {

    private List userArray = new ArrayList<>();
    private Context mContext;
    private static final String USER_INFO_NAME = "UserName";
    private static final String USER_INFO_PASSWORD = "UserPassword";

    public UserDataImpl() {
        this.mContext = App.getContext();
    }

    public UserDataImpl(Context context) {
        this.mContext = context;
    }

    @Override
    public void saveUserInfo(int id, String name, String password, int age, String sex, String address, String email) {
        userArray.add(id, new UserBean(name, password, age, sex, address, email));

    }

    @Override
    public void saveUserInfo(int id, String name, String password) {
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(password)) {
            return;
        }
        userArray.add(id, new UserBean(name, password));
        SPUtil.putAndApply(mContext, USER_INFO_NAME, name);
        SPUtil.putAndApply(mContext, USER_INFO_PASSWORD, password);
    }

    @Override
    public void saveUserInfo(String name, String password) {
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(password)) {
            return;
        }
        userArray.add(new UserBean(name, password));
        SPUtil.putAndApply(mContext, USER_INFO_NAME, name);
        SPUtil.putAndApply(mContext, USER_INFO_PASSWORD, password);
    }

    @Override
    public UserBean loadUserInfo(int id) {
        if (userArray.size() < id) {
            return (UserBean) userArray.get(id);
        }
        return null;
    }

    @Override
    public boolean loadUserInfo(String name) {
        String userName = (String) SPUtil.get(mContext, USER_INFO_NAME, "");

        if (TextUtils.equals(name, userName)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean loadUserInfo(String name, String password) {
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(password)) {
            return false;
        }
        String userName = (String) SPUtil.get(mContext, USER_INFO_NAME, "");
        String userPassword = (String) SPUtil.get(mContext, USER_INFO_PASSWORD, "");

        if (TextUtils.equals(name, userName) && TextUtils.equals(password, userPassword)) {
            return true;
        }
        return false;
    }

}
