package HotelManagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

public class HotelGUI extends JFrame implements ActionListener{
    String location;
    String hotelNames[];
    int count;
    JButton buttons[]; 
    String username;
    int rooms;
    Date checkin,checkout;
    String roomtype;
    
    public HotelGUI(String username,int rooms,String location,String hotelNames[],int count,Date checkin,Date checkout,String roomtype) {
        this.roomtype = roomtype;
        this.checkin = checkin;
        this.checkout = checkout;
        this.rooms = rooms;
        this.username = username;
        this.count = count;
        this.hotelNames = new String[count];
        this.hotelNames = hotelNames;
        buttons = new JButton[count];
        this.location = location;
        this.setTitle("Available hotels");
        for(int i=0;i<count;i++)
        {
            buttons[i] = new JButton(hotelNames[i]);
            buttons[i].addActionListener(this);
            this.add(buttons[i]);
        }
        this.setLayout(new GridLayout(10,1));
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        
        this.setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        boolean fl = true;
        for(int j=0;j<count;j++)
        {
            if(buttons[j].hasFocus())
            {
                new HotelParticularGUI(username,rooms,location,hotelNames[j],checkin,checkout,roomtype,this);
            }
        }
    }
    public static void main(String args[])
    {
    }
}
