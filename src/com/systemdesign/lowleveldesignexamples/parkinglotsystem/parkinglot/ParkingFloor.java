package com.systemdesign.lowleveldesignexamples.parkinglotsystem.parkinglot;

import com.systemdesign.lowleveldesignexamples.parkinglotsystem.parkinglot.vehicle.VehicleParkingSpot;
import com.systemdesign.lowleveldesignexamples.parkinglotsystem.parkinglot.vehicle.VehicleType;

import java.util.*;

public class ParkingFloor {
    private int floorId;
    private Map<VehicleType, Deque<VehicleParkingSpot>> vehicleTypeParkingSlots = new HashMap<>();
    private Map<String, VehicleParkingSpot> occupiedSlots = new HashMap<>();

    public ParkingFloor(){
        vehicleTypeParkingSlots.put(VehicleType.CAR, new ArrayDeque<>());
        vehicleTypeParkingSlots.put(VehicleType.TRUCK, new ArrayDeque<>());
        vehicleTypeParkingSlots.put(VehicleType.BIKE, new ArrayDeque<>());
    }





}
