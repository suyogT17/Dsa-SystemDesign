package com.systemdesign.lowleveldesignexamples.parkinglotsystem.parkinglot;

import com.systemdesign.lowleveldesignexamples.parkinglotsystem.parkinglot.parkingstrategy.HourlyCharge;
import com.systemdesign.lowleveldesignexamples.parkinglotsystem.parkinglot.vehicle.ParkingTicket;
import com.systemdesign.lowleveldesignexamples.parkinglotsystem.parkinglot.vehicle.VehicleParkingSpot;
import com.systemdesign.lowleveldesignexamples.parkinglotsystem.parkinglot.vehicle.VehicleType;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAmount;
import java.util.UUID;

public class ExitTerminal {
    private String terminalNumber;

    public ExitTerminal(String terminalNumber){
        this.terminalNumber = terminalNumber;
    }

    public Bill unparkVehicle(ParkingTicket parkingTicket){
        ParkingLotSystem.INSTANCE.unparkVehicle(parkingTicket);
        double parkingCharge = calculateFare(parkingTicket.getVehicleParkingSpot(), parkingTicket.getIssuedAt());
        return generateBill(parkingTicket.getVehicleLicenceNumber(), parkingTicket.getParkingTicketId(),parkingCharge, parkingTicket.getVehicleParkingSpot().getVehicleType());
    }

    private Bill generateBill(String vehicleLicenceNumber, String parkingTicketId, double parkingCharge, VehicleType vehicleType) {
        Bill bill = new Bill();
        bill.setBillNumber(UUID.randomUUID().toString());
        bill.setParkingTicketId(parkingTicketId);
        bill.setVehicleType(vehicleType);
        bill.setVehicleLicenceNumber(vehicleLicenceNumber);
        bill.setParkingCharge(parkingCharge);
        bill.setBillStatus(BillStatus.UNPAID);
        return bill;
    }

    private double calculateFare(VehicleParkingSpot vehicleParkingSpot, LocalDateTime issuedAt) {
        Duration duration = Duration.between(issuedAt, LocalDateTime.now());
        long calculateHours = duration.toHours() == 0 ? 1 : duration.toHours();
        return calculateHours * new HourlyCharge().getParkingCharge(vehicleParkingSpot.getVehicleType());
    }

}
