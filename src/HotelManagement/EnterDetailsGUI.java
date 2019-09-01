/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelManagement;

import UserManagement.InterScreen;
import UserManagement.JDBCConnections;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;
import java.sql.ResultSet;
/**
 *
 * @author Inderraj
 */
public class EnterDetailsGUI extends JFrame {

    /**
     * Creates new form EnterDetailsGUI
     */
    int set;
    String message;
    String roomTypes[];
    int count;
    String user;
    
    public EnterDetailsGUI(String username) {
        user = username;
        initComponents();
        jComboBox1.addItem("Deluxe");
        jComboBox1.addItem("Super-Deluxe");
        jComboBox1.addItem("Standard-AC");
        jComboBox1.addItem("Single-AC");
        jComboBox1.addItem("Executive");
        count = 0;
        roomTypes = new String[10];
        message = "";
        set = 0;
        
       Date date1 = new Date();
        Date date2 = new Date();
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(date1);
        c2.setTime(date2);
        c1.add(Calendar.DATE, 1);
        c2.add(Calendar.DATE, 2);
        date1 = c1.getTime();
        date2 = c2.getTime();
        checkin.setMinSelectableDate(date1);
        checkout.setMinSelectableDate(date2);
        this.setLocationRelativeTo(null);
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EnterDetailsGUI().setVisible(true);
            }
        });*/
        }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDayChooser2 = new com.toedter.calendar.JDayChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        location = new javax.swing.JComboBox<>();
        checkout = new com.toedter.calendar.JDateChooser();
        checkin = new com.toedter.calendar.JDateChooser();
        room_tf = new javax.swing.JTextField();
        people_tf = new javax.swing.JTextField();
        proceed = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Find Hotels");
        setMaximumSize(new java.awt.Dimension(736, 450));
        setMinimumSize(new java.awt.Dimension(736, 450));
        setPreferredSize(new java.awt.Dimension(736, 450));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Location");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(193, 104, 146, 22);

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Check-in Date");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(190, 200, 130, 20);

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Check-out Date");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(190, 240, 130, 20);

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Rooms required");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(190, 280, 130, 17);

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("No. of people");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(190, 310, 130, 17);

        location.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        location.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chennai", "Gangtok", "Hyderabad", "Jaipur", "Jodhpur", "Kolkata", " " }));
        location.setBorder(new javax.swing.border.MatteBorder(null));
        location.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locationActionPerformed(evt);
            }
        });
        getContentPane().add(location);
        location.setBounds(372, 104, 202, 23);
        getContentPane().add(checkout);
        checkout.setBounds(370, 230, 202, 30);
        getContentPane().add(checkin);
        checkin.setBounds(372, 191, 202, 30);

        room_tf.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        room_tf.setBorder(new javax.swing.border.MatteBorder(null));
        room_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                room_tfActionPerformed(evt);
            }
        });
        getContentPane().add(room_tf);
        room_tf.setBounds(370, 280, 202, 19);

        people_tf.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        people_tf.setBorder(new javax.swing.border.MatteBorder(null));
        getContentPane().add(people_tf);
        people_tf.setBounds(370, 310, 202, 19);

        proceed.setBackground(new java.awt.Color(51, 255, 51));
        proceed.setText("Proceed");
        proceed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proceedActionPerformed(evt);
            }
        });
        getContentPane().add(proceed);
        proceed.setBounds(231, 381, 80, 23);

        cancel.setBackground(new java.awt.Color(255, 51, 0));
        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        getContentPane().add(cancel);
        cancel.setBounds(390, 380, 70, 23);

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Room type");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(193, 151, 130, 20);

        jComboBox1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jComboBox1.setBorder(new javax.swing.border.MatteBorder(null));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(372, 150, 202, 23);

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel7.setText("Booking");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(310, 10, 120, 44);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserManagement/Images/paul-earle-39322-unsplash.jpg"))); // NOI18N
        jLabel8.setText("jLabel8");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(0, 0, 740, 450);

        pack();
    }// </editor-fold>//GEN-END:initComponents

        void deletePreviousBookings()
    {
        JDBCConnections ob = new JDBCConnections("SELECT * FROM bookinglist","hoteldetails");
        JDBCConnections ob2 = new JDBCConnections("SELECT * FROM hotellist","hoteldetails");
        ResultSet RS = ob.rs;
        ResultSet RS2 = ob2.rs;
        
        try
        {    
            int rooms = 0;
            String hotelname = "";
            String location = "";
            Date date = new Date();
            
            while(RS.next())
            {
                String Checkout = RS.getString("checkout");
                Date check_out = new SimpleDateFormat("dd/MM/yyyy").parse(Checkout);
                if(check_out.before(date))
                {
                    rooms = Integer.parseInt(RS.getString("rooms"));
                    hotelname = RS.getString("hotelname");
                    location = RS.getString("location");
                    RS.deleteRow();
                    RS2.beforeFirst();
                    while(RS2.next())
                    {
                        if(RS2.getString("city").equals(location)&&RS2.getString("name").equals(hotelname))
                        {
                            int ROOMS = RS2.getInt("roomcount")+rooms;
                            RS2.updateInt("roomcount",ROOMS);
                            RS2.updateRow();
                            break;
                        }
                    }
                }
            }
            RS.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        
    }
    boolean validateData(Date check_in,Date check_out,String people,String rooms)
    {
        if(check_in==null||check_out==null||people.equals("")||rooms.equals(""))
        {
            message = "One or more fields empty!";
            return false;
        }
        int People,Rooms;
        try
        {
            People = Integer.parseInt(people);
            try
            {
                Rooms = Integer.parseInt(rooms);
            }
            catch(Exception e)
            {
                message = "No. of rooms must be a positive integer!";
                set = 1;
                return false;
            }
        }
        catch(Exception e)
        {
            set = 2;
            message = "No.of people must be a positive integer!";
            return false;
        }
        if(Rooms<=0&&People<=0)
        {
            set = 3;
            message = "No. of rooms and no. of people must be a positive integer!";
            return false;
        }
        if(Rooms<=0)
        {
            set = 4;
            message = "Number of rooms must be a positive integer!";
            return false;
        }
        else if(People<=0)
        {
            set = 5;
            message = "Number of people must be a positive integer!";
            return false;
        }
        Date date = new Date();
        if(check_in.before(date))
        {
            set = 6;
            message = "Check-in date before today not allowed!";
            return false;
        }
        else if(check_out.before(check_in))
        {
            set = 7;
            message = "Check-out date cannot be before or on check-in date!";
            return false;
        }
        return true;
    }
    
    private void proceedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proceedActionPerformed
        // TODO add your handling code here:
        
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //String check_in = sdf.format(checkin.getDate());
        //String check_out = sdf.format(checkout.getDate());
        String people,rooms;
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        
        
        Date check_in = checkin.getDateEditor().getDate();
        dateFormat.format(check_in);
        Date check_out = checkout.getDateEditor().getDate();
        dateFormat.format(check_out);
        
        people = (people_tf.getText());
        rooms = (room_tf.getText());
        boolean fl = validateData(check_in,check_out,people,rooms);
        if(fl==false)
        {
            if(set==1)
            {
                room_tf.setText("");
            }
            else if(set==2)
            {
                people_tf.setText("");
            }
            else if(set==3)
            {
                room_tf.setText("");
                people_tf.setText("");
            }
            else if(set==4)
            {
                room_tf.setText("");
            }
            else if(set==5)
            {
                people_tf.setText("");
            }
            else if(set==6)
            {
                checkin.setCalendar(null);
            }
            else if(set==7)
            {
                checkin.setCalendar(null);
                checkout.setCalendar(null);
            }
            new ErrorDialog(message);
        }
        else if(fl==true)
        {
            System.out.println(Integer.parseInt(rooms));
            System.out.println(Integer.parseInt(people));
                    
            new EnterDetails(user,(String)location.getSelectedItem(),(String)jComboBox1.getSelectedItem(),check_in,check_out,Integer.parseInt(rooms),Integer.parseInt(people),proceed);
        }
    }//GEN-LAST:event_proceedActionPerformed
    
    void createRoomTypes(String Location)
    {
        if(Location.equals("Chennai"))
        {
            roomTypes[count++] = "Deluxe";
            roomTypes[count++] = "Super-Deluxe";
            roomTypes[count++] = "Standard-AC";
            roomTypes[count++] = "Single-AC";
            roomTypes[count++] = "Executive";
        }
        else if(Location.equals("Gangtok"))
        {
            roomTypes[count++] = "Deluxe";
            roomTypes[count++] = "Super-Deluxe";
            roomTypes[count++] = "Standard-AC";
            roomTypes[count++] = "Standard-Non-AC";
            roomTypes[count++] = "Royal-Executive";
            roomTypes[count++] = "Economy";
        }
        else if(Location.equals("Jaipur"))
        {
            
            roomTypes[count++] = "Deluxe";
            roomTypes[count++] = "Super-Deluxe";
            roomTypes[count++] = "Standard-AC";
            roomTypes[count++] = "Single-AC";
            roomTypes[count++] = "Cottage";
        }
        else if(Location.equals("Jaisalmer"))
        {
            roomTypes[count++] = "Deluxe";
            roomTypes[count++] = "Super-Deluxe";
            roomTypes[count++] = "Standard-AC";
            roomTypes[count++] = "Standard-Non-AC";
        }
        else if(Location.equals("Jodhpur"))
        {
            roomTypes[count++] = "Deluxe";
            roomTypes[count++] = "Standard-AC";
            roomTypes[count++] = "Standard-Non-AC";
            roomTypes[count++] = "Economy";
            roomTypes[count++] = "Cottage";
            roomTypes[count++] = "Tent";
        }
        else if(Location.equals("Hyderabad"))
        {
            roomTypes[count++] = "Super-Deluxe";
            roomTypes[count++] = "Standard-AC";
            roomTypes[count++] = "Standard-Non-AC";
            roomTypes[count++] = "Executive";
        }
        else if(Location.equals("Kolkata"))
        {
            roomTypes[count++] = "Deluxe";
            roomTypes[count++] = "Standard-AC";
            roomTypes[count++] = "Standard-Non-AC";
            roomTypes[count++] = "Executive";
            roomTypes[count++] = "Cottage";
        }
    }
    
    
    
    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        // TODO add your handling code here:
        dispose() ;
        new InterScreen(user).setVisible(true) ;
    }//GEN-LAST:event_cancelActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void locationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locationActionPerformed
        // TODO add your handling code here:
        createRoomTypes((String)location.getSelectedItem());
        jComboBox1.removeAllItems();
        for(int i=0;i<count;i++)
        {
            jComboBox1.addItem(roomTypes[i]);
        }
        count = 0;
    }//GEN-LAST:event_locationActionPerformed

    private void room_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_room_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_room_tfActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EnterDetailsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EnterDetailsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EnterDetailsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EnterDetailsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        new EnterDetailsGUI("").setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton cancel;
    public com.toedter.calendar.JDateChooser checkin;
    public com.toedter.calendar.JDateChooser checkout;
    public javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDayChooser jDayChooser2;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    public javax.swing.JComboBox<String> location;
    public javax.swing.JTextField people_tf;
    public javax.swing.JButton proceed;
    public javax.swing.JTextField room_tf;
    // End of variables declaration//GEN-END:variables
}
