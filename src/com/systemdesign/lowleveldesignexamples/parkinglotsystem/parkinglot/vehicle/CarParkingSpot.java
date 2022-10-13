package com.systemdesign.lowleveldesignexamples.parkinglotsystem.parkinglot.vehicle;

public class CarParkingSpot extends VehicleParkingSpot{
    public CarParkingSpot(String newParkingSpotId){
        super(newParkingSpotId, VehicleType.CAR);
    }
}
