package com.systemdesign.lowleveldesignexamples.hotelmanagement.booking;

import com.systemdesign.lowleveldesignexamples.hotelmanagement.account.Customer;
import com.systemdesign.lowleveldesignexamples.hotelmanagement.room.Room;

import java.util.Date;
import java.util.List;

public class Booking {
    private  int bookingId;
    private Customer customer;
    private Date from;
    private int numberOfDays;
    private Date to;
    private double totalCharge;
    private List<Room> roomsBooked;
    private BookingStatus bookingStatus;
}
