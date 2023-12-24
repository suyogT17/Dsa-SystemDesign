package com.systemdesign.machinecoding.conferenceroom.model;

public class ConferenceRoom {
    private int conferenceRoomId;
    private String conferenceRoomName;
    private  int seatingCapacity;
    private boolean isAvailable;

    public ConferenceRoom(int conferenceRoomId, String conferenceRoomName, int seatingCapacity) {
        this.conferenceRoomId = conferenceRoomId;
        this.conferenceRoomName = conferenceRoomName;
        this.seatingCapacity = seatingCapacity;
        this.isAvailable = true;
    }

    public int getConferenceRoomId() {
        return conferenceRoomId;
    }

    public String getConferenceRoomName() {
        return conferenceRoomName;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
