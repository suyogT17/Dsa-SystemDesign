package com.systemdesign.lowleveldesignexamples.hotelmanagement.room;

public class StandardRoom extends Room{
    public StandardRoom(int roomCapacity, int roomCharge, RoomKey roomKey) {
        super(RoomType.STANDARD, roomCapacity, roomCharge, roomKey);
    }
}
