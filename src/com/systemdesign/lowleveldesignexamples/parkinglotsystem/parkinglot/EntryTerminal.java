package com.systemdesign.lowleveldesignexamples.parkinglotsystem.parkinglot;

import com.systemdesign.lowleveldesignexamples.parkinglotsystem.parkinglot.vehicle.ParkingTicket;
import com.systemdesign.lowleveldesignexamples.parkinglotsystem.parkinglot.vehicle.ParkingTicketStatus;
import com.systemdesign.lowleveldesignexamples.parkinglotsystem.parkinglot.vehicle.Vehicle;
import com.systemdesign.lowleveldesignexamples.parkinglotsystem.parkinglot.vehicle.VehicleParkingSpot;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EntryTerminal {

    private String terminalNumber;

    public EntryTerminal(String terminalNumber){
        this.terminalNumber = terminalNumber;
    }

    public ParkingTicket getParking(Vehicle vehicle){
        VehicleParkingSpot vehicleParkingSpot = ParkingLotSystem.INSTANCE.findParkingSpot(vehicle);
        return generateParkingTicket(vehicle.getVehicleLicenceNumber(), vehicleParkingSpot);
    }

    private ParkingTicket generateParkingTicket(String vehicleLicenceNumber, VehicleParkingSpot vehicleParkingSpot) {
        ParkingTicket parkingTicket = new ParkingTicket();
        parkingTicket.setParkingTicketId(ParkingLotSystem.INSTANCE.getParkingLotId()+"_"+vehicleParkingSpot.getFloorId()+"_"+vehicleParkingSpot.getParkingSpotId());
        parkingTicket.setVehicleParkingSpot(vehicleParkingSpot);
        parkingTicket.setVehicleLicenceNumber(vehicleLicenceNumber);
        parkingTicket.setIssuedAt(LocalDateTime.now());
        parkingTicket.setParkingTicketStatus(ParkingTicketStatus.ACTIVE);
        return parkingTicket;
    }
}
