package com.systemdesign.lowleveldesignexamples.parkinglotsystem.parkinglot;

import com.systemdesign.lowleveldesignexamples.parkinglotsystem.parkinglot.vehicle.VehicleType;
import lombok.Data;

@Data
public class Bill {
    private String billNumber;
    private String vehicleLicenceNumber;
    private VehicleType vehicleType;
    private String parkingTicketId;
    private double parkingCharge;
    private BillStatus billStatus;

}
