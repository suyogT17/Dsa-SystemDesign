package com.systemdesign.machinecoding.conferenceroom.account;

public class Admin extends User{
    public Admin(int userId, Account account) {
        super(userId, account);
    }

    boolean addBuilding(){
        return true;
    }

    boolean removeBuilding(){
        return true;
    }

    boolean addFloor(){
        return true;
    }

    boolean removeFloor(){
        return true;
    }

    boolean addConferenceRoom(){
        return true;
    }

    boolean removeConferenceRoom(){
        return true;
    }
}
