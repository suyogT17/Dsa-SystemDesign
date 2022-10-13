package com.systemdesign.lowleveldesignexamples.parkinglotsystem.parkinglot.vehicle;

public class Truck extends Vehicle {
    public Truck(String vehicleLicenceNumber, String vehicleColor){
        super(vehicleLicenceNumber, vehicleColor, VehicleType.TRUCK);
    }
}
