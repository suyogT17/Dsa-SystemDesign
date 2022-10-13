package com.systemdesign.lowleveldesignexamples.parkinglotsystem.parkinglot.vehicle;

public class Bike extends Vehicle {
    public Bike(String vehicleLicenceNumber, String vehicleColor){
        super(vehicleLicenceNumber, vehicleColor, VehicleType.BIKE);
    }
}
