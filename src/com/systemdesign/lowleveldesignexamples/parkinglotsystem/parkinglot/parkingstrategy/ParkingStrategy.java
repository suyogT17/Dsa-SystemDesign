package com.systemdesign.lowleveldesignexamples.parkinglotsystem.parkinglot.parkingstrategy;

import com.systemdesign.lowleveldesignexamples.parkinglotsystem.parkinglot.vehicle.VehicleParkingSpot;

public interface ParkingStrategy {
    VehicleParkingSpot findParkingSlot();
}
