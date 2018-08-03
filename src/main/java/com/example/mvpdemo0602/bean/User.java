package com.example.mvpdemo0602.bean;


/**
 * Created by Administrator on 2018/6/5.
 */
public class User {
    private long id;
    private String userName;
    private String userPassword;
    private String userRePassword;
    private boolean isRemember;
    private int permission;
    private String userNick;
    private String six;
    private int age;
    private String userPhone;
    private String userMail;
    private String userQQ;
    private String userInterest;
    private String userIconUrl;

    public User(long id, String userName, String userPassword,
            String userRePassword, boolean isRemember, int permission,
            String userNick, String six, int age, String userPhone, String userMail,
            String userQQ, String userInterest, String userIconUrl) {
        this.id = id;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userRePassword = userRePassword;
        this.isRemember = isRemember;
        this.permission = permission;
        this.userNick = userNick;
        this.six = six;
        this.age = age;
        this.userPhone = userPhone;
        this.userMail = userMail;
        this.userQQ = userQQ;
        this.userInterest = userInterest;
        this.userIconUrl = userIconUrl;
    }
    public User() {
    }

    @Override
    public boolean equals(Object obj) {
        if (this ==obj) return true;
        if (!(obj instanceof User))return false;
        User user= (User) obj;
        return userName.equals(user.userName);
    }
    @Override
    public int hashCode() {
        return (int)(id ^(id >>> 32));
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userNick='" + userNick + '\'' +
                ", six='" + six + '\'' +
                ", age=" + age +
                ", userPhone='" + userPhone + '\'' +
                '}';
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getUserName() {
        return this.userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserPassword() {
        return this.userPassword;
    }
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    public String getUserRePassword() {
        return this.userRePassword;
    }
    public void setUserRePassword(String userRePassword) {
        this.userRePassword = userRePassword;
    }
    public boolean getIsRemember() {
        return this.isRemember;
    }
    public void setIsRemember(boolean isRemember) {
        this.isRemember = isRemember;
    }
    public int getPermission() {
        return this.permission;
    }
    public void setPermission(int permission) {
        this.permission = permission;
    }
    public String getUserNick() {
        return this.userNick;
    }
    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }
    public String getSix() {
        return this.six;
    }
    public void setSix(String six) {
        this.six = six;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getUserPhone() {
        return this.userPhone;
    }
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
    public String getUserMail() {
        return this.userMail;
    }
    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }
    public String getUserQQ() {
        return this.userQQ;
    }
    public void setUserQQ(String userQQ) {
        this.userQQ = userQQ;
    }
    public String getUserInterest() {
        return this.userInterest;
    }
    public void setUserInterest(String userInterest) {
        this.userInterest = userInterest;
    }
    public String getUserIconUrl() {
        return this.userIconUrl;
    }
    public void setUserIconUrl(String userIconUrl) {
        this.userIconUrl = userIconUrl;
    }

}
