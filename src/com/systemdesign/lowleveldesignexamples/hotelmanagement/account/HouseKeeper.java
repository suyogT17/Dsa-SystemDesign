package com.systemdesign.lowleveldesignexamples.hotelmanagement.account;

import com.systemdesign.lowleveldesignexamples.hotelmanagement.room.HouseKeepingLog;

public class HouseKeeper extends Employee{
    public boolean updateHouseKeepingLog(int roomId, HouseKeepingLog houseKeepingLog){
        return true;
    }
}
