package com.systemdesign.machinecoding.conferenceroom.exception;

import com.systemdesign.machinecoding.conferenceroom.model.ConferenceRoom;

public class ConferenceRoomAlreadyExistsException extends Exception{

    public ConferenceRoomAlreadyExistsException(String msg){
        super(msg);
    }
}
