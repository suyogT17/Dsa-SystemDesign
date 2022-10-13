package com.systemdesign.lowleveldesignexamples.parkinglotsystem.account;

import com.systemdesign.lowleveldesignexamples.parkinglotsystem.parkinglot.EntryTerminal;
import com.systemdesign.lowleveldesignexamples.parkinglotsystem.parkinglot.ParkingFloor;
import com.systemdesign.lowleveldesignexamples.parkinglotsystem.parkinglot.vehicle.VehicleParkingSpot;

public class Admin extends Account {

    public void addParkingFloor(ParkingFloor newParkingFloor){}

    public void removeParkingFloor(int floorId){}

    public void addEntryTerminal(EntryTerminal newEntryTerminal){}

    public void removeEntryTerminal(int entryTerminalId){}

    public void addExitTerminal(EntryTerminal newEntryTerminal){}

    public void removeExitTerminal(int entryTerminalId){}

    public void addParkingSpot(int floorId, VehicleParkingSpot newVehicleParkingSpot){}

    public void removeParkingSpot(int floorId, String parkingSpotId){}
}
