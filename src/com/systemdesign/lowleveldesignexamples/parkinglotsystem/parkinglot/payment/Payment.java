package com.systemdesign.lowleveldesignexamples.parkinglotsystem.parkinglot.payment;

import com.systemdesign.lowleveldesignexamples.parkinglotsystem.parkinglot.Bill;
import com.systemdesign.lowleveldesignexamples.parkinglotsystem.parkinglot.BillStatus;

public interface Payment {
    BillStatus pay(Bill bill);
}
