package com.systemdesign.lowleveldesignexamples.hotelmanagement.booking;

import com.systemdesign.lowleveldesignexamples.hotelmanagement.account.Address;
import com.systemdesign.lowleveldesignexamples.hotelmanagement.account.Customer;
import com.systemdesign.lowleveldesignexamples.hotelmanagement.account.Employee;
import com.systemdesign.lowleveldesignexamples.hotelmanagement.room.Room;
import com.systemdesign.lowleveldesignexamples.hotelmanagement.room.RoomType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hotel {
    private String hotelId;
    private String hotelName;
    private Address address;

    private Map<RoomType, List<Room>> rooms;
    private Map<Integer,Customer> customers;
    private Map<Integer,Employee> employees;
    private Map<Integer, Booking> bookings;
    private Map<Integer,Room> bookedRooms;

    static Hotel INSTANCE = new Hotel();

    private Hotel(){
        rooms = new HashMap<>();
        customers = new HashMap<>();
        employees = new HashMap<>();
        bookings = new HashMap<>();
        bookedRooms = new HashMap<>();
    }

    public boolean registerCustomer(Customer customer){
        return true;
    }
}
