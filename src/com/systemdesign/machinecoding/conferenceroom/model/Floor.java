package com.systemdesign.machinecoding.conferenceroom.model;

import com.systemdesign.machinecoding.conferenceroom.exception.ConferenceRoomAlreadyExistsException;
import com.systemdesign.machinecoding.conferenceroom.exception.ConferenceRoomNotExistsException;

import java.util.HashMap;

import java.util.Map;

public class Floor {

    private int floorId;
    private Map<String, ConferenceRoom> conferenceRooms;

    public Floor(int floorId) {
        this.floorId = floorId;
        this.conferenceRooms =  new HashMap<>();
    }

    void addConferenceRoom(ConferenceRoom conferenceRoom) throws ConferenceRoomAlreadyExistsException{
        if(conferenceRooms.containsKey(conferenceRoom.getConferenceRoomName())){
            throw new ConferenceRoomAlreadyExistsException("Conference room with name "+conferenceRoom.getConferenceRoomName()+" already exist on the floor");
        }else conferenceRooms.put(conferenceRoom.getConferenceRoomName(), conferenceRoom);
    }

    void removeConferenceRoom(ConferenceRoom conferenceRoom) throws ConferenceRoomNotExistsException {
        if(!conferenceRooms.containsKey(conferenceRoom.getConferenceRoomName())){
            throw new ConferenceRoomNotExistsException("Conference room with id "+conferenceRoom.getConferenceRoomName()+" does not exist on floor");
        } else conferenceRooms.remove(conferenceRoom.getConferenceRoomName());
    }
}
