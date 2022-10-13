package com.systemdesign.lowleveldesignexamples.parkinglotsystem.parkinglot.parkingstrategy;

import com.systemdesign.lowleveldesignexamples.parkinglotsystem.parkinglot.ParkingCharge;
import com.systemdesign.lowleveldesignexamples.parkinglotsystem.parkinglot.ParkingChargeType;
import com.systemdesign.lowleveldesignexamples.parkinglotsystem.parkinglot.vehicle.VehicleType;

import java.util.HashMap;
import java.util.Map;

public class HourlyCharge extends ParkingCharge {
    private Map<VehicleType, Double> parkingCostForVehicle = new HashMap<>();

    public HourlyCharge(){
        super(ParkingChargeType.Hourly);
        parkingCostForVehicle.put(VehicleType.BIKE, 20.0);
        parkingCostForVehicle.put(VehicleType.CAR, 50.0);
        parkingCostForVehicle.put(VehicleType.TRUCK, 100.0);
    }

    public double getParkingCharge(VehicleType vehicleType){
        return parkingCostForVehicle.get(vehicleType);
    }
}
