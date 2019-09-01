
package HotelManagement;

import UserManagement.InterScreen;
import UserManagement.JDBCConnections;
import static java.lang.System.exit;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.time.format.DateTimeFormatter; 

public class CancellationAndModificationPortal extends javax.swing.JFrame {

 String u;
     String message;
    public long getDiffrence(Date one ,Date two)
    {
        long difference =  (-1*one.getTime()+two.getTime())/86400000;
        System.out.println(difference);
        return Math.abs(difference);
    }
    public CancellationAndModificationPortal() {
        initComponents();
        message = "";
            this.setLocationRelativeTo(null) ; 
      //  deleteInvalidRecords();
    }

    /*void deleteInvalidRecords()
    {
        Date date = new Date();
        JDBCConnections obj = new JDBCConnections("SELECT * FROM bookinglist","hoteldetails");
        ResultSet rr = obj.rs;
        try
        {
            while(rr.next())
            {
                String checkout = rr.getString("checkout");
                SimpleDateFormat formatter2 = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
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
    }*/
    
    boolean checkEmpty(String user,String pass)
    {u=user ;
        if(user.equals("")||pass.equals(""))
        {
            message = "Empty username and/or password!";
            return true;
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tf_bookingrefno = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cancel_button = new javax.swing.JButton();
        modify_button = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(768, 476));
        setMinimumSize(new java.awt.Dimension(768, 476));
        setPreferredSize(new java.awt.Dimension(768, 476));
        setResizable(false);
        getContentPane().setLayout(null);

        tf_bookingrefno.setBorder(new javax.swing.border.MatteBorder(null));
        getContentPane().add(tf_bookingrefno);
        tf_bookingrefno.setBounds(360, 196, 301, 30);

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Booking reference number");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(120, 193, 167, 40);

        cancel_button.setBackground(new java.awt.Color(255, 51, 0));
        cancel_button.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        cancel_button.setText("Cancel booking");
        cancel_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(cancel_button);
        cancel_button.setBounds(80, 360, 184, 25);

        modify_button.setBackground(new java.awt.Color(0, 255, 102));
        modify_button.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        modify_button.setText("Modify booking");
        modify_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modify_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(modify_button);
        modify_button.setBounds(520, 360, 165, 25);

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel5.setText("Cancellation and Modification");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(154, 41, 446, 44);

        jButton1.setBackground(new java.awt.Color(255, 102, 102));
        jButton1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(350, 360, 59, 25);

        jLabel2.setText("*** Please note*** You can cancel or modify for free any date 3 days before your checkin date");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(120, 400, 520, 40);

        jLabel4.setText("If cancelled 2 or 1 day before your check in date then cancellation cost = 50% of totalcost");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(130, 440, 450, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserManagement/Images/cesar-couto-420982-unsplash.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 770, 480);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancel_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_buttonActionPerformed
        // TODO add your handling code here:
        boolean test=true;
        int bookingref=0;
        String checkin = null; // its the date on which the booking is to be cancelled
        try{
            bookingref=Integer.parseInt(tf_bookingrefno.getText());
        }
        catch(NumberFormatException ne){
            new ErrorDialog("Invalid Booking reference");
            test = false;
            //this.setVisible(false);
        }
        
        
        int rooms=0;
        String hotelname="",location="";
        Date today = new Date();
        
      /*do{
            bookingref = tf_bookingrefno.getText();
            if(bookingref.equals("")){
                new ErrorDialog("Press Get Booking Reference number, Booking reference feild should not be empty");
            }
        }while(!bookingref.equals(""));*/
        JDBCConnections obj = new JDBCConnections("SELECT * FROM bookinglist where bookingrefnumber = '"+bookingref+"'","hoteldetails");
        ResultSet rr = obj.rs;
        try{if(rr.next()){
        try{
           // String username,location,hotelname,roomtype
            rr.first();
            String temp=rr.getString("checkin");
            System.out.println(temp);
            Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(temp);
            hotelname = rr.getString("hotelname");
            System.out.println(hotelname);
            location = rr.getString("location");
            System.out.println(location);
            rooms = rr.getInt("rooms");
            long totalcost=RoomRate.getCost(rr.getString("roomtype"))*getDiffrence(new SimpleDateFormat("dd/MM/yyyy").parse(rr.getString("checkin")),new SimpleDateFormat("dd/MM/yyyy").parse(rr.getString("checkout")));
            rr.deleteRow();
            
            long day = getDiffrence(new Date(),date1);
            
            if(day<3){
                new ErrorDialog("Cancelation done, you are liable to pay "+ totalcost/2 +" ruppes","Cancellation");
            }
            else{
                new ErrorDialog("Cancelation done, no cost incurred","Cancellation");
            }
        }catch(Exception e){
            // there should not be any error it is confirmed during get booking ref number
        }
        
        obj = new JDBCConnections("Select * from hotellist where name = '"+hotelname+"' and city = '"+location+"'","hoteldetails");
        rr = obj.rs;
        try{
            rr.next();
            rooms = rr.getInt("roomcount")+rooms;
            rr.updateInt("roomcount",rooms);
            rr.updateRow();
        }catch(Exception e){
            
            }
        }
        else{
            if(test)
            new ErrorDialog("Invalid Booking Id");
        }
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_cancel_buttonActionPerformed

    private void modify_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modify_buttonActionPerformed
        // TODO add your handling code here:
        if (tf_bookingrefno.getText().equals(""))
            new ErrorDialog("No Booking reference number") ;
        else
            new Modification (tf_bookingrefno.getText()).setVisible(true) ;        
//new ModificationForm().setVisible(true);
    }//GEN-LAST:event_modify_buttonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();        
        new InterScreen(u).setVisible(true) ;        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed
    
     /*class ModificationForm extends javax.swing.JFrame{
        
         public ModificationForm() {
            initComponents();
        }
        private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        checkin = new com.toedter.calendar.JDateChooser();
        checkout = new com.toedter.calendar.JDateChooser();
        submitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Checkin");

        jLabel2.setText("Checkout");

        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(88, 88, 88)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(checkin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }
        
        boolean validateData(Date checkin,Date checkout,String bookrefno)
        {
            if(checkin==null||checkout==null||bookrefno.equals(""))
            {
               return false;
            }
            return true;
        }
        
        private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        
        
        Date check_in = checkin.getDateEditor().getDate();
        
        Date check_out = checkout.getDateEditor().getDate();
        
        boolean fl = validateData(check_in,check_out,tf_bookingrefno.getText());
        if(fl==false)
        {
            new ErrorDialog("One or more fields empty!");
        }
        else
        {
            String bookingref = tf_bookingrefno.getText();
            try{
                JDBCConnections obj = new JDBCConnections("SELECT * FROM bookinglist","hoteldetails");
                ResultSet RS = obj.rs;
                validateData(check_in,check_out,bookingref);
                try
                {
                    int bookrefno = Integer.parseInt(bookingref);
                    while(RS.next())
                    {
                        if(RS.getInt("bookingrefnumber")==bookrefno)
                        {
                            RS.updateString("checkin",dateFormat.format(check_in));
                            RS.updateString("checkout",dateFormat.format(check_out));
                            RS.updateRow();
                            break;
                        }
                    }
                }
                catch(NumberFormatException e)
                {
                    new ErrorDialog("Please enter a positive integer!");
                }
                catch(Exception e){}
                new ErrorDialog("Your Checkin and Checkout dates have succesfully updated");
                
            }catch(Exception e){
                
            }
            finally{
                this.setVisible(false);
            }
            
        }   
        }  
        private com.toedter.calendar.JDateChooser checkin;
        private com.toedter.calendar.JDateChooser checkout;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JButton submitButton;
    }*/
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
            java.util.logging.Logger.getLogger(CancellationAndModificationPortal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CancellationAndModificationPortal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CancellationAndModificationPortal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CancellationAndModificationPortal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CancellationAndModificationPortal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel_button;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton modify_button;
    private javax.swing.JTextField tf_bookingrefno;
    // End of variables declaration//GEN-END:variables
}
