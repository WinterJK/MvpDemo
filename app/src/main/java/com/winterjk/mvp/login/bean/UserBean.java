package com.winterjk.mvp.login.bean;

/**
 * 用户信息类
 * Created by WinterJk on 2017/7/23.
 */

public class UserBean {

    private String userName;
    private String password;
    private int age;
    private String email;
    private String sex;
    private String address;

    public UserBean() {

    }

    public UserBean(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public UserBean(String userName, String password, int age, String email, String sex, String address) {
        this.userName = userName;
        this.password = password;
        this.age = age;
        this.email = email;
        this.sex = sex;
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserBean)) return false;

        UserBean userBean = (UserBean) o;

        if (getAge() != userBean.getAge()) return false;
        if (getUserName() != null ? !getUserName().equals(userBean.getUserName()) : userBean.getUserName() != null)
            return false;
        if (getPassword() != null ? !getPassword().equals(userBean.getPassword()) : userBean.getPassword() != null)
            return false;
        if (getEmail() != null ? !getEmail().equals(userBean.getEmail()) : userBean.getEmail() != null)
            return false;
        if (getSex() != null ? !getSex().equals(userBean.getSex()) : userBean.getSex() != null)
            return false;
        return getAddress() != null ? getAddress().equals(userBean.getAddress()) : userBean.getAddress() == null;

    }

    @Override
    public int hashCode() {
        int result = getUserName() != null ? getUserName().hashCode() : 0;
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        result = 31 * result + getAge();
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getSex() != null ? getSex().hashCode() : 0);
        result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
        return result;
    }
}
