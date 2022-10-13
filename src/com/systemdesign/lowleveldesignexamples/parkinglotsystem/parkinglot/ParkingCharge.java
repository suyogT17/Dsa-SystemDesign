package com.systemdesign.lowleveldesignexamples.parkinglotsystem.parkinglot;

import com.systemdesign.lowleveldesignexamples.parkinglotsystem.parkinglot.vehicle.VehicleType;

import java.util.Map;

public abstract class ParkingCharge {
    private ParkingChargeType parkingChargeType;

    public ParkingCharge(ParkingChargeType parkingChargeType){
        this.parkingChargeType = parkingChargeType;
    }
}
