package HotelManagement;

import UserManagement.JDBCConnections;
import java.sql.ResultSet;
import javax.swing.JTextArea;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class HotelParticularGUI extends javax.swing.JFrame {
    String hotelname;
    String location;
    JDBCConnections ob;
    String username;
    int rooms;
    Date checkin,checkout;
    String roomtype;
    HotelGUI OB;
    
    public HotelParticularGUI(String username,int rooms,String location,String hotelname,Date checkin,Date checkout,String roomtype,HotelGUI OB2) {
        OB = OB2;
        this.roomtype = roomtype;
        this.rooms = rooms;
        this.username = username;
        initComponents();
        this.location = location;
        this.hotelname = hotelname;
        this.checkin = checkin;
        this.checkout = checkout;
        this.setTitle(hotelname);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        ob = new JDBCConnections("SELECT * FROM hotellist","hoteldetails");
        try
        {
            ResultSet RS = ob.rs;
            while(RS.next())
            {
                if(RS.getString("city").equals(location)&&RS.getString("name").equals(hotelname))
                {
                    jLabel13.setText(RS.getString("address"));
                    //tf_address.setEditable(false);
                    //tf_area.setText(RS.getString("area"));
                    //tf_area.setEditable(false);
                    tf_description.setLineWrap(true);
                    tf_description.setWrapStyleWord(true);
                    tf_description.setText(RS.getString("hoteldescription"));
                    tf_description.setEditable(false);
                    //tf_categoryrating.setText(RS.getString("generalrating"));
                    //tf_categoryrating.setEditable(false);
                    //tf_facilities.setText(RS.getString("hotelfacilities"));
                    //tf_facilities.setEditable(false);
                    jLabel4.setText(Integer.toString(RS.getInt("numberofratings")));
                    //tf_noofratings.setEditable(false);
                    jLabel2.setText(Integer.toString(RS.getInt("rating")));
                    //tf_overallrating.setEditable(false);
                    tf_roomfacilities.setText(RS.getString("roomfacilities"));
                    tf_roomfacilities.setEditable(false);
                    int costpernight = RoomRate.getCost(roomtype);
                    jLabel7.setText(Integer.toString(costpernight));
                    //tf_costpernight.setEditable(false);
                    long diff = checkout.getTime() - checkin.getTime();
                    int days = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
                    int totalcost = days*costpernight;
                    jLabel12.setText(Integer.toString(totalcost));
                    //tf_totalcost.setEditable(false);
                    break;
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tf_description = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        tf_roomfacilities = new javax.swing.JTextArea();
        bookhotel = new javax.swing.JButton();
        goback = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(997, 618));
        setMinimumSize(new java.awt.Dimension(997, 618));
        setPreferredSize(new java.awt.Dimension(997, 618));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Address");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(123, 99, 117, 38);

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Description");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(120, 210, 100, 28);

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Overall rating");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(120, 430, 117, 35);

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Room facilities");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(123, 357, 117, 33);

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Number of ratings");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(570, 430, 117, 31);

        jLabel13.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        getContentPane().add(jLabel13);
        jLabel13.setBounds(300, 104, 330, 20);

        tf_description.setBackground(new java.awt.Color(240, 240, 240));
        tf_description.setColumns(20);
        tf_description.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        tf_description.setRows(5);
        tf_description.setBorder(null);
        jScrollPane3.setViewportView(tf_description);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(298, 133, 545, 200);

        tf_roomfacilities.setBackground(new java.awt.Color(240, 240, 240));
        tf_roomfacilities.setColumns(20);
        tf_roomfacilities.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        tf_roomfacilities.setRows(5);
        tf_roomfacilities.setBorder(null);
        jScrollPane5.setViewportView(tf_roomfacilities);

        getContentPane().add(jScrollPane5);
        jScrollPane5.setBounds(298, 354, 545, 40);

        bookhotel.setBackground(new java.awt.Color(0, 255, 0));
        bookhotel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        bookhotel.setText("Book Hotel");
        bookhotel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookhotelActionPerformed(evt);
            }
        });
        getContentPane().add(bookhotel);
        bookhotel.setBounds(570, 560, 135, 25);

        goback.setBackground(new java.awt.Color(255, 0, 0));
        goback.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        goback.setText("Go Back");
        goback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gobackActionPerformed(evt);
            }
        });
        getContentPane().add(goback);
        goback.setBounds(270, 560, 139, 25);

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel9.setText("Cost per night");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(120, 500, 117, 36);

        jLabel10.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel10.setText("Total cost");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(570, 500, 117, 36);

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel11.setText("Hotel Details");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(396, 30, 200, 39);
        getContentPane().add(jLabel4);
        jLabel4.setBounds(710, 430, 110, 20);

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(300, 440, 120, 20);

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(300, 500, 95, 30);
        getContentPane().add(jLabel12);
        jLabel12.setBounds(710, 500, 100, 20);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserManagement/Images/architecture-background-blue-633520.jpg"))); // NOI18N
        jLabel14.setText("jLabel14");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(0, 0, 1000, 620);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bookhotelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookhotelActionPerformed
        // TODO add your handling code here:
        // Call the class which will enable us to book the hotel!
        OB.setVisible(false);
        this.dispose();
        new BookHotel(this,username,rooms,location,hotelname,checkin,checkout,roomtype);
    }//GEN-LAST:event_bookhotelActionPerformed

    private void gobackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gobackActionPerformed
        // TODO add your handling code here:
        this.dispose();
        OB.setVisible(true);
    }//GEN-LAST:event_gobackActionPerformed

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
            java.util.logging.Logger.getLogger(HotelParticularGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HotelParticularGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HotelParticularGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HotelParticularGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HotelParticularGUI("Chennai","xyz").setVisible(true);
            }
        });*/
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bookhotel;
    private javax.swing.JButton goback;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea tf_description;
    private javax.swing.JTextArea tf_roomfacilities;
    // End of variables declaration//GEN-END:variables

}