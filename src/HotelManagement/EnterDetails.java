package HotelManagement;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import UserManagement.JDBCConnections;
import UserManagement.Message;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;
import java.sql.*;

public class EnterDetails{
    
    JDBCConnections ob,ob2;
    String message;
    String[] cityNames = new String[] {"Chennai", "Gangtok","Hyderabad","Jaipur","Jaisalmer","Jodhpur","Kolkata"};
    String hotelNames[];
    String roomTypes[];
    int total1;
    String Location;
    Date Checkin;
    Date Checkout;
    int Rooms;
    int People;
    JButton B;
    String username;
    String roomType;
    int count;
    
    EnterDetails(String user,String location,String roomType,Date checkin,Date checkout,int rooms,int people,JButton b)
    {
        username = user;
        // IF THE LOGIN SUCCEEDS, Username has to be passed from LoginPageGUI class in UserManagement to this class!
        B = b;
        Location = location;
        this.roomType = roomType;
        Checkin = checkin;
        Checkout = checkout;
        Rooms = rooms;
        People = people;
        total1 = 0;
        hotelNames = new String[10];
        roomTypes = new String[10];
        message = "";
        ob = new JDBCConnections("SELECT * FROM hotellist","hoteldetails");
        ob2 = new JDBCConnections("SELECT * FROM waitinglist","hoteldetails");
        searchDatabase();
    }
    
    void insertElements(String hotelname)
    {
        hotelNames[total1++] = hotelname;
    }
    
    
    public void searchDatabase()
    {
        boolean existsHotel = false;
        message = "Click OK to continue";
        ResultSet rs = ob.rs;
        try {
            rs.beforeFirst();
            int set = 0;
            int set2 = 0;
            while (rs.next()) {
                // Create a panel for each acceptable hotel
                if (rs.getString("city").equals(Location)&&rs.getString("roomtype").equals(roomType)) 
                {
                    int maxroomcount = rs.getInt("maxroomcount");
                    int roomcount = rs.getInt("roomcount");
                    String hotelname = rs.getString("name");
                    int capacity = Capacity.getCapacity(roomType);
                   // MODIFICATION 1
                    if(Rooms<=maxroomcount)
                    {
                        set = 1;
                    }
                    if((People*1.0)/Rooms<=capacity)
                    {
                        set2 = 1;
                    }
                    if (Rooms <= roomcount && ((People*1.0)/Rooms) <= (capacity)) {
                        // Such hotels are acceptable, rs is still pointing to such hotels
                        existsHotel = true;
                        insertElements(hotelname);
                    }
                }
            }
            rs.close();
            if(set==0)
            {
                new ErrorDialog("No. of rooms chosen is more than those available in any hotel!");
            }
            else if(set2==0)
            {
                new ErrorDialog("No. of people chosen cannot be accomodated in given number of rooms");
            }
            else
            {
            if (existsHotel == false) {
                new MessageDialog(B,"EnterDetails","Click OK to proceed, Cancel to change","Hotels currently unavailable. Enroll in waiting list?");
                //In MessageDialog class only, waitinglist details will be stored in database!
                
                ResultSet rs2 = ob2.rs;
                rs2.beforeFirst();
                while(rs2.next())
                {
                    String user = rs2.getString("username");
                    if(user.equals(username))
                    {
                        new ErrorDialog("User already in waiting list! Not allowed again!");
                        System.exit(0);
                    }
                }
                ResultSet rs3 = ob2.rs;
                if(MessageDialog.fl_EnterDetails==true)
                {
                    // Denotes he has pressed OK on the message dialog box
                    // Store waiting list into Database
                    try
                    {
                        DateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
                        rs3.beforeFirst();
                        rs3.moveToInsertRow();
                        rs3.updateString("username",username);
                        rs3.updateString("location", Location);
                        rs3.updateString("checkin", dateformat.format(Checkin));
                        rs3.updateString("checkout",dateformat.format(Checkout));
                        rs3.updateInt("rooms",Rooms);
                        rs3.updateInt("people",People);
                        rs3.updateString("roomtype", roomType);
                        rs3.insertRow();
                        rs3.close();
                        System.exit(0);
                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }
            }
            }
                else {
                // Now move forward and pass array hotelNames and Location to next class to allow the user to book
                // also pass an indicator meaning that user has found hotel rooms so he is booking not from the waitinglist!!
                int Count = 0;
                for(int j=0;j<hotelNames.length;j++)
                {
                    if(hotelNames[j]==null)
                        break;
                    Count++;
                }
                new Booking(username,Rooms,"EnterDetails",Location,hotelNames,Count,Checkin,Checkout,roomType);
            }
        }
        }
        
        catch (Exception e2) {
                System.out.println(e2);
            }
    }

    
    public static void main(String args[])
    {
    }
}
