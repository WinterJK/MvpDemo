package com.winterjk.mvp.login.model;

import com.winterjk.mvp.login.bean.UserBean;

/**
 * 数据接口
 * Created by WinterJk on 2017/7/23.
 */

public interface IUserData {

    void saveUserInfo(int id, String name, String password, int age, String sex, String address, String email);

    void saveUserInfo(int id, String name, String password);

    void saveUserInfo(String name, String password);

    UserBean loadUserInfo(int id);

    boolean loadUserInfo(String name);

    boolean loadUserInfo(String name, String password);
}
