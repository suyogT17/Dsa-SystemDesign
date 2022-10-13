package com.systemdesign.lowleveldesignexamples.parkinglotsystem.parkinglot.vehicle;

import lombok.Data;

@Data
public class VehicleParkingSpot {
    private String parkingSpotId;
    private VehicleType vehicleType;
    private int floorId;
    private boolean isReserve = false;

    public VehicleParkingSpot(String newParkingSpotId, VehicleType newVehicleType){
        parkingSpotId = newParkingSpotId;
        vehicleType = newVehicleType;
    }
}

