package com.example.appwork;

public class UserSingleton {

    private static UserSingleton instance;
    private User user;

    public UserSingleton(){

    }

    public static UserSingleton getInstance() {
        if(instance == null){
            instance = new UserSingleton();
        }
        return instance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
