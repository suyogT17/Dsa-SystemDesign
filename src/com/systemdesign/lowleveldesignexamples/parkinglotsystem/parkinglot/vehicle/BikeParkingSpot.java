package com.systemdesign.lowleveldesignexamples.parkinglotsystem.parkinglot.vehicle;

public class BikeParkingSpot extends VehicleParkingSpot{
    public BikeParkingSpot(String newParkingSpotId){
        super(newParkingSpotId, VehicleType.BIKE);
    }
}