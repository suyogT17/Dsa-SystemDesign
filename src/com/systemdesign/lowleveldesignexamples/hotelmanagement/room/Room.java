package com.systemdesign.lowleveldesignexamples.hotelmanagement.room;

//import lombok.Setter;

import java.util.List;

public abstract class Room {
    private int roomId;
    private RoomType roomType;
    private int roomCapacity;
 //   @Setter
    private boolean roomStatus;
   // @Setter
    private RoomCharge roomCharge;
    private List<RoomKey> roomKeys;

    private List<HouseKeepingLog> houseKeepingLogs;

    public Room(RoomType roomType, int roomCapacity, int roomCharge, RoomKey roomKey){
    }

    public boolean addRoomKey(RoomKey roomKey){
        return true;
    }
}
