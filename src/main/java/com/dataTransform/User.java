package com.dataTransform;

/**
 * @BelongsProject: demo
 * @BelongsPackage: com.dataTransform
 * @Author: cuihzh
 * @CreateTime: 2023-04-05  11:18
 * @Description: TODO
 * @Version: 1.0
 */
public class User {
    private String  userName;
    private String passowrd;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassowrd() {
        return passowrd;
    }

    public void setPassowrd(String passowrd) {
        this.passowrd = passowrd;
    }

    public User(String userName, String passowrd) {
        this.userName = userName;
        this.passowrd = passowrd;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", passowrd='" + passowrd + '\'' +
                '}';
    }
}
