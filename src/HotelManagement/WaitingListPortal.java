/* While enrolling in waiting list,
the user has first selected a location, then a roomtype and then if rooms weren't available in any hotel, 
then he has enolled in the waiting list.
So if his waiting list number is one, he must be given the functionality of choosing any hotel where that room is available,
depending upon the type of room he had chosen at the time of enrolling in the waiting list!
*/
package HotelManagement;
import java.util.*;
import UserManagement.JDBCConnections;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class WaitingListPortal extends javax.swing.JFrame {
    
    String message;
    int count;
    String hotelNames[];
    String roomTypes[];
    int total1;
    
    public WaitingListPortal() {
        initComponents();
        // Each time we'll run the function and delete those entries in waiting list whose checkout date is before today's date!
        deleteInvalidRecords();
        total1 = 0;
        count = 0;
        message = "";
        hotelNames = new String[10];
        roomTypes = new String[10];
        this.setVisible(true);
        this.setLocationRelativeTo(null) ; 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        username = new javax.swing.JLabel();
        password = new javax.swing.JLabel();
        tf_username = new javax.swing.JTextField();
        tf_password = new javax.swing.JTextField();
        checkstatus = new javax.swing.JButton();
        bookhotel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Waiting List Portal");
        setMaximumSize(new java.awt.Dimension(649, 448));
        setMinimumSize(new java.awt.Dimension(649, 448));
        setPreferredSize(new java.awt.Dimension(649, 448));
        setResizable(false);
        getContentPane().setLayout(null);

        username.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        username.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        username.setText("Username");
        getContentPane().add(username);
        username.setBounds(142, 124, 84, 19);

        password.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        password.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        password.setText("Password");
        getContentPane().add(password);
        password.setBounds(142, 196, 84, 17);

        tf_username.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        tf_username.setBorder(new javax.swing.border.MatteBorder(null));
        getContentPane().add(tf_username);
        tf_username.setBounds(323, 124, 210, 19);

        tf_password.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        tf_password.setBorder(new javax.swing.border.MatteBorder(null));
        tf_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_passwordActionPerformed(evt);
            }
        });
        getContentPane().add(tf_password);
        tf_password.setBounds(323, 196, 210, 20);

        checkstatus.setBackground(new java.awt.Color(0, 255, 0));
        checkstatus.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        checkstatus.setText("Check Status");
        checkstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkstatusActionPerformed(evt);
            }
        });
        getContentPane().add(checkstatus);
        checkstatus.setBounds(189, 320, 103, 25);

        bookhotel.setBackground(new java.awt.Color(0, 255, 204));
        bookhotel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        bookhotel.setText("Book Hotel");
        bookhotel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookhotelActionPerformed(evt);
            }
        });
        getContentPane().add(bookhotel);
        bookhotel.setBounds(365, 320, 123, 25);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel1.setText("Waiting List Portal");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(195, 20, 273, 44);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserManagement/Images/evan-kirby-226482-unsplash.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 650, 450);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    void deleteInvalidRecords()
    {
        Date date = new Date();
        JDBCConnections obj = new JDBCConnections("SELECT * FROM waitinglist","hoteldetails");
        ResultSet rr = obj.rs;
        try
        {
            while(rr.next())
            {
                String checkout = rr.getString("checkout");
                SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                Date check_out = formatter2.parse(checkout);
                if(check_out.before(date))
                {
                    rr.deleteRow();
                }
            }
            rr.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    boolean checkEmpty(String username,String password)
    {
        if(username.equals("")||password.equals(""))
            return false;
        return true;
    }
    
    void insertElements(String hotelname)
    {
        hotelNames[total1++] = hotelname;
    }
    
    int returnStatus(String username,String location)
    {
        count = 0;
        JDBCConnections ob = new JDBCConnections("SELECT * FROM waitinglist","hoteldetails");
        ResultSet r = ob.rs;
        System.out.println(location);
        try
        {
            while(r.next())
            {
                if(r.getString("location").equals(location))
                    count++;
                if(r.getString("location").equals(location)&&r.getString("username").equals(username))
                {
                    return count;
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return count;
    }
    
    private void tf_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_passwordActionPerformed

    private void checkstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkstatusActionPerformed
        // TODO add your handling code here:
            boolean fl = checkEmpty(tf_username.getText(),tf_password.getText());
        if(fl==false)
            new ErrorDialog("Empty username or password!");
        else
        {
            fl = false;
            JDBCConnections ob = new JDBCConnections("SELECT * FROM credentials","userdetails");
            ResultSet RS = ob.rs;
            try
            {
                RS.beforeFirst();
                while(RS.next())
                {
                    String user = RS.getString("username");
                    System.out.println(user);
                    String pass = RS.getString("password");
                    System.out.println(pass);
                    if(tf_username.getText().equals(user)&&tf_password.getText().equals(pass))
                    {
                        fl = true;
                        break;
                    }
                }
                RS.close();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            if(fl==false)
            {
                new ErrorDialog("Wrong username and/or password!");
            }
            else
            {
                fl = false;
                JDBCConnections ob2 = new JDBCConnections("SELECT * FROM waitinglist","hoteldetails");
                ResultSet RS3 = ob2.rs;
                String location = "";
                try
                {
                    while(RS3.next())
                    {
                        if(tf_username.getText().equals(RS3.getString("username")))
                        {
                            fl = true;
                            location = RS3.getString("location");
                            break;
                        }
                    }
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
                if(fl==true)
                {
                    int count = returnStatus(tf_username.getText(),location);
                    try
                    {
                        RS3.close();
                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }
                    new MessageDialog(checkstatus,"WaitingListPortal","Status","Your waiting list number is " + Integer.toString(count));
                }
                else
                {
                    try
                    {
                        RS3.close();
                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }
                    new ErrorDialog("User not in waiting list!");
                }
            }
        }
    }//GEN-LAST:event_checkstatusActionPerformed

    private void bookhotelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookhotelActionPerformed
        // TODO add your handling code here:
        boolean fl = checkEmpty(tf_username.getText(),tf_password.getText());
        if(fl==false)
            new ErrorDialog("Empty username or password!");
        else
        {
            fl = false;
            JDBCConnections ob = new JDBCConnections("SELECT * FROM credentials","userdetails");
            ResultSet RS = ob.rs;
            try
            {
                RS.beforeFirst();
                while(RS.next())
                {
                    String user = RS.getString("username");
                    String pass = RS.getString("password");
                    if(tf_username.getText().equals(user)&&tf_password.getText().equals(pass))
                    {
                        fl = true;
                        break;
                    }
                }
                RS.close();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            if(fl==false)
            {
                new ErrorDialog("Wrong username and/or password!");
            }
            else
            {
                fl = false;
                JDBCConnections ob2 = new JDBCConnections("SELECT * FROM waitinglist","hoteldetails");
                ResultSet RS2 = ob2.rs;
                try
                {
                    RS2.beforeFirst();
                    while(RS2.next())
                    {
                        if(RS2.getString("username").equals(tf_username.getText()))
                        {
                            fl = true;
                            break;
                        }
                    }
                    RS2.close();
                }
                catch(Exception e2)
                {
                    System.out.println(e2);
                }
                if(fl==false)
                {
                    new ErrorDialog("User not in waiting list!");
                }
                // If he reached here implies user is in the waiting list
                // Now we need to check if he is the first user in the waiting list for that particular location
                else
                {
                    JDBCConnections ob3 = new JDBCConnections("SELECT * FROM waitinglist","hoteldetails");
                    ResultSet RS3 = ob3.rs;
                    String location = "";
                    try
                    {
                        while(RS3.next())
                        {
                            if(tf_username.getText().equals(RS3.getString("username")))
                            {
                                location = RS3.getString("location");
                                break;
                            }
                        }
                        RS3.close();
                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }
                    int count = returnStatus(tf_username.getText(),location);
                    System.out.println(count);
                    if(count==1)
                    {
                        // allow user to proceed with booking- i.e call booking class if there are rooms available!!
                        // First we need to check if at all rooms are available!
                        boolean existsHotel = false;
                        message = "Click OK to continue";
                        JDBCConnections OB = new JDBCConnections("SELECT * FROM waitinglist","hoteldetails");
                        ResultSet RS4 = OB.rs;
                        String Username = tf_username.getText();
                        String Location,roomtype;
                        roomtype = "";
                        Location = "";
                        int rooms = 0;
                        int people = 0;
                        Date checkin = null,checkout = null;
                        
                        try
                        {
                            RS4.beforeFirst();
                            while(RS4.next())
                            {
                                if(RS4.getString("username").equals(Username))
                                {
                                    Location = RS4.getString("location");
                                    roomtype = RS4.getString("roomtype");
                                    rooms = RS4.getInt("rooms");
                                    people = RS4.getInt("people");
                                    SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);  
                                    checkin = formatter.parse(RS4.getString("checkin"));
                                    checkout = formatter.parse(RS4.getString("checkout"));
                                }
                            }
                            RS4.close();
                        }
                        catch(Exception e)
                        {
                            System.out.println(e);
                        }
                        JDBCConnections ob1 = new JDBCConnections("SELECT * FROM hotellist","hoteldetails");
                        ResultSet RS5 = ob1.rs;
                        try
                        {
                            while(RS5.next())
                            {
                                if (RS5.getString("city").equals(Location)&&RS5.getString("roomtype").equals(roomtype)) 
                                {
                                    int roomcount = RS5.getInt("roomcount");
                                    String hotelname = RS5.getString("name");
                                    int capacity = Capacity.getCapacity(roomtype);
                                    if (rooms <= roomcount && ((1.0 * people)/rooms) <= (capacity * roomcount))
                                    {
                                        // Such hotels are acceptable, rs is still pointing to such hotels
                                        existsHotel = true;
                                        insertElements(hotelname);
                                    }
                                }
                            }
                            RS5.close();
                        }
                        catch(Exception e)
                        {
                            System.out.println(e);
                        }
                        if (existsHotel == false)
                        {
                            new ErrorDialog("Hotels not currently available, try again later!");
                            System.exit(0);
                        }
                        else
                        {
                            new HotelGUI(Username,rooms,location,hotelNames,count,checkin,checkout,roomtype);
                            // this user has to be removed from the waiting list too! Irrespective of whether he books
                            // a hotel or not!
                            
                            JDBCConnections o = new JDBCConnections("SELECT * FROM waitinglist","hoteldetails");
                            try
                            {
                                ResultSet r = o.rs;
                                while(r.next())
                                {
                                    String user = r.getString("username");
                                    if(user.equals(Username))
                                        r.deleteRow();
                                }
                                r.close();
                            }
                            catch(Exception e)
                            {
                            }
                        }
                    }
                    else
                    {
                        // meaning user isn't number 1 on the waiting list
                        new ErrorDialog("Your waiting list no. is " + Integer.toString(count));
                    }
                }
            }
        }
    }//GEN-LAST:event_bookhotelActionPerformed

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
            java.util.logging.Logger.getLogger(WaitingListPortal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WaitingListPortal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WaitingListPortal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WaitingListPortal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        new WaitingListPortal();
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bookhotel;
    private javax.swing.JButton checkstatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel password;
    private javax.swing.JTextField tf_password;
    private javax.swing.JTextField tf_username;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}
