package com.systemdesign.lowleveldesignexamples.parkinglotsystem.parkinglot.vehicle;

public class TruckParkingSpot extends VehicleParkingSpot{
    public TruckParkingSpot(String newParkingSpotId){
        super(newParkingSpotId, VehicleType.TRUCK);
    }
}