package com.systemdesign.lowleveldesignexamples.hotelmanagement.room;

public class FamilySuiteRoom extends Room{
    public FamilySuiteRoom(int roomCapacity, int roomCharge, RoomKey roomKey) {
        super(RoomType.FAMILY_SUITE, roomCapacity, roomCharge, roomKey);
    }
}
