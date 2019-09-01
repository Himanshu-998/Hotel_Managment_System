package UserManagement;

import javax.swing.*;
import HotelManagement.EnterDetailsGUI ;

public class Message
{
    String name,date,address,email;
    Message(String title,String message,JButton b)
    {
        showMessage(title,message,b);
    }
    
    public Message(String title,String message,JButton b,String name,String date,String address,String email)
    {
        this.name = name;
        this.date = date;
        this.address = address;
        this.email = email;
        showMessage(title,message,b);
    }
    
    public void showMessage(String title,String message,JButton b)
    {
        JOptionPane ob = new JOptionPane();
        int type;
       
        if(title.equals("ERROR!"))
        {
            type = ob.showConfirmDialog(null, message, title, JOptionPane.DEFAULT_OPTION);

        }
        
        else if(title.equals("SUCCESS!"))
        {
            type = ob.showConfirmDialog(null, message+", your login is successfull", "Sign Up successfull!", JOptionPane.DEFAULT_OPTION);
                ob.setVisible(false);  
            
       
        }
        else if(message.equals("Sign Up Successful!"))
        {
            type = ob.showConfirmDialog(null, message, title, JOptionPane.DEFAULT_OPTION);
            //if(type==JOptionPane.OK_OPTION)
            //{
                ob.setVisible(false);
                new SignIn().setVisible(true) ;
                // Connect with Part2
                //For now
            //}

        }
        else if(title.equals("CONTINUE!"))
        {
            type = ob.showConfirmDialog(null, message, "Registration succesfull", JOptionPane.DEFAULT_OPTION);
                new Credentials(name,date,address,email).setVisible(true);
        }
    }
    
    public static void main(String args[])
    {
    }
}