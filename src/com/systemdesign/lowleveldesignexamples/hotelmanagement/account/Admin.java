package com.systemdesign.lowleveldesignexamples.hotelmanagement.account;

import com.systemdesign.lowleveldesignexamples.hotelmanagement.booking.Booking;
import com.systemdesign.lowleveldesignexamples.hotelmanagement.booking.BookingProcessor;
import com.systemdesign.lowleveldesignexamples.hotelmanagement.booking.Search;
import com.systemdesign.lowleveldesignexamples.hotelmanagement.room.HouseKeepingLog;
import com.systemdesign.lowleveldesignexamples.hotelmanagement.room.Room;

import java.util.List;

public class Admin extends Account {
    private Search search;
    private BookingProcessor bookingProcessor;

    public boolean addRoom(Room room){ return true;}

    public boolean removeRoom(int roomId){ return true;}

    public boolean addEmployee(Employee employee) { return true;}

    public boolean fireEmployee(int employeeId) { return true;}

    public Booking getBookingForRoom(int roomId){ return null;}

    public List<Room> getBookedRooms(){ return null;}

    public Booking cancelBooking(int bookingId){ return null;}

    public HouseKeepingLog getHouseKeepingLogs(int roomId){ return null;}

    private class Room {
    }
}
