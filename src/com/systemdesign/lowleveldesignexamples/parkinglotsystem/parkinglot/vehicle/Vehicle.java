package com.systemdesign.lowleveldesignexamples.parkinglotsystem.parkinglot.vehicle;

import lombok.Data;

@Data
public abstract class Vehicle {
    private String vehicleLicenceNumber;
    private VehicleType vehicleType;
    private String vehicleColor;

    public Vehicle(String vehicleLicenceNumber, String vehicleColor, VehicleType vehicleType){
        this.vehicleLicenceNumber = vehicleLicenceNumber;
        this.vehicleColor =  vehicleColor;
        this.vehicleType = vehicleType;
    }

}
