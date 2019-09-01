/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelManagement;

import java.util.Date;

/**
 *
 * @author Inderraj
 */
public class Booking {
    
    String className,location;
    int count;
    String hotelNames[];
    String username;
    int rooms;
    Date checkin,checkout;
    String roomtype;
    
    Booking(String username,int Rooms,String className,String location,String hotelNames[],int count,Date Checkin,Date Checkout,String roomtype)
    {
        this.roomtype = roomtype;
        checkin = Checkin;
        checkout = Checkout;
        rooms = Rooms;
        this.username = username;
        this.count = count;
        this.hotelNames = new String[count];
        this.hotelNames = hotelNames;
        this.className = className;
        this.location = location;
        if(className.equals("EnterDetails"))
        {
            new HotelGUI(username,rooms,location,this.hotelNames,count,checkin,checkout,roomtype);
        }
    }
    public static void main(String args[])
    {
    }
}
