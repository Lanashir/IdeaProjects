package com.lanashir.entity;

/**
 * Created by agosipov on 13.10.2016.
 */
public class User {
    int Id;
    String UserName;
    String Password;
    int PersDisc;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getPersDisc() {
        return PersDisc;
    }

    public void setPersDisc(int persDisc) {
        PersDisc = persDisc;
    }
}
