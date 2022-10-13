package com.systemdesign.lowleveldesignexamples.parkinglotsystem.parkinglot.payment;

import com.systemdesign.lowleveldesignexamples.parkinglotsystem.parkinglot.Bill;
import com.systemdesign.lowleveldesignexamples.parkinglotsystem.parkinglot.BillStatus;

public class CardPayment implements Payment{
    @Override
    public BillStatus pay(Bill bill) {
        bill.setBillStatus(BillStatus.PAID);
        return bill.getBillStatus();
    }
}
