package com.systemdesign.lowleveldesignexamples.parkinglotsystem.parkinglot;


import com.systemdesign.lowleveldesignexamples.parkinglotsystem.account.Address;
import com.systemdesign.lowleveldesignexamples.parkinglotsystem.parkinglot.parkingstrategy.LowestFloorParkingStrategy;
import com.systemdesign.lowleveldesignexamples.parkinglotsystem.parkinglot.parkingstrategy.ParkingStrategy;
import com.systemdesign.lowleveldesignexamples.parkinglotsystem.parkinglot.vehicle.ParkingTicket;
import com.systemdesign.lowleveldesignexamples.parkinglotsystem.parkinglot.vehicle.Vehicle;
import com.systemdesign.lowleveldesignexamples.parkinglotsystem.parkinglot.vehicle.VehicleParkingSpot;
import com.systemdesign.lowleveldesignexamples.parkinglotsystem.parkinglot.vehicle.VehicleType;
import lombok.Getter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ParkingLotSystem {
    @Getter
    private String parkingLotId;
    private Address address;

    private List<ParkingFloor> floors = new LinkedList();
    private List<EntryTerminal> entryTerminalList = new ArrayList();
    private List<ExitTerminal> exitTerminalList = new ArrayList();
    private ParkingStrategy parkingStrategy = new LowestFloorParkingStrategy();

    public static ParkingLotSystem INSTANCE = new ParkingLotSystem();

    private ParkingLotSystem(){}

    public Map<VehicleType, List<String>> getVacantSlots(){
        return null;
    }

    public Map<VehicleType, List<String>> getOccupiedSlots(){
        return null;
    }

    public boolean canPark(Vehicle vehicle){ return true; }

    public VehicleParkingSpot findParkingSpot(Vehicle vehicle){ return parkingStrategy.findParkingSlot(); }

    public void unparkVehicle(ParkingTicket parkingTicket) {}
}
