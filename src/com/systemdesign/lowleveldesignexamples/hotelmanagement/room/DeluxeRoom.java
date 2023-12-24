package com.systemdesign.lowleveldesignexamples.hotelmanagement.room;

public class DeluxeRoom extends Room {
    public DeluxeRoom(int roomCapacity, int roomCharge, RoomKey roomKey) {
        super(RoomType.DELUX, roomCapacity, roomCharge, roomKey);
    }
}
