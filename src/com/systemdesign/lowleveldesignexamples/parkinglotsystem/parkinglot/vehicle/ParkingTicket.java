package com.systemdesign.lowleveldesignexamples.parkinglotsystem.parkinglot.vehicle;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ParkingTicket {
     private String parkingTicketId;
     private VehicleParkingSpot vehicleParkingSpot;
     private LocalDateTime issuedAt;
     private String vehicleLicenceNumber;
     private ParkingTicketStatus parkingTicketStatus;
}
