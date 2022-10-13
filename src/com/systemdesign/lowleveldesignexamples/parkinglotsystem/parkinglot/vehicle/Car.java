package com.systemdesign.lowleveldesignexamples.parkinglotsystem.parkinglot.vehicle;

public class Car extends Vehicle {
    public Car(String vehicleLicenceNumber, String vehicleColor){
        super(vehicleLicenceNumber, vehicleColor, VehicleType.CAR);
    }
}
