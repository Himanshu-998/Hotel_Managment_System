/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelManagement;
import javax.swing.*;

/**
 *
 * @author Inderraj
 */
public class MessageDialog {
    
    static boolean fl_EnterDetails;
    
    MessageDialog(JButton b,String className,String title,String message)
    {
        fl_EnterDetails = false;
        showMessage(b,className,title,message);
    }
    
    void showMessage(JButton b,String className,String title,String message)
    {
        JOptionPane ob = new JOptionPane();
        int type;
        if(className.equals("EnterDetails"))
        {
            //type = ob.showConfirmDialog(b, message, title, JOptionPane.OK_CANCEL_OPTION);
            type = ob.showConfirmDialog(null, message, title, JOptionPane.DEFAULT_OPTION);
            //if(type==JOptionPane.OK_OPTION)
           // {
                fl_EnterDetails = true;
                ob.setVisible(false);
           // }
            //else if(type==JOptionPane.CANCEL_OPTION)
            //{
           //     fl_EnterDetails = true;
             //   System.exit(0);
           // }
        }
        else if(className.equals("WaitingListPortal"))
        {
            type = ob.showConfirmDialog(null, message, title, JOptionPane.DEFAULT_OPTION);
            //if(type==JOptionPane.OK_OPTION)
            //{
                //ob.setVisible(false);
            //}
        }
        else if(className.equals("BookHotel"))
        {
            type = ob.showConfirmDialog(null, message, title, JOptionPane.DEFAULT_OPTION);
           
            
                System.exit(0);
        }
    }
}
