package com.systemdesign.machinecoding.conferenceroom.account;

import com.systemdesign.machinecoding.conferenceroom.model.ConferenceRoom;

import java.util.List;

abstract class User {
    private int userId;
    private Account account;

    public User(int userId, Account account) {
        this.userId = userId;
        this.account = account;
    }

    public int getUserId() {
        return userId;
    }

    public Account getAccount() {
        return account;
    }

    public boolean resetPassword(String password){
        account.setPassWord(password);
        return true;
    }
}
