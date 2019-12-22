/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentapp;

import static agentapp.oppenaccount.uid1;
import static agentapp.outermainframe.agentno;
import static agentapp.outermainframe.uid;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author mca14_13
 */
public class todayamount extends javax.swing.JFrame {

    /**
     * Creates new form todayamount
     */
    String u;
   public static String agentno;
    int userid;
     int pos = 0;
     public static String id;
     int a1;
     String m;
    public todayamount() {
        initComponents();
        
      
    }
    
    
     // get the connection
    public Connection getConnection()
    {
        Connection con = null;
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_hlbank", "root", "");
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return con;
    }
    
     //getting current agent account no
     public void getdata()
     {
      
      Connection connection = getConnection();
     a1 = Integer.parseInt(uid2.getText());
     System.out.println(a1);
       PreparedStatement ps5;
        try {
            ps5 = connection.prepareStatement("SELECT `accountno` FROM `tbl_agentaccount` WHERE `agentid`=?");
              ps5.setInt(1,a1);
            ResultSet result9=ps5.executeQuery();
      
       if(result9.next())
        {
          agentno=result9.getString("accountno");
          System.out.println(agentno);
        }
        } catch (SQLException ex) {
            Logger.getLogger(outermainframe.class.getName()).log(Level.SEVERE, null, ex);
        }
      
     }
      // bind a list of item from mysql database
    public List<user> getItemsList()
    {
        try {
            
            
            Connection connection = getConnection();
            PreparedStatement ps3;
            int ag=Integer.parseInt(agentno);
            ps3 = connection.prepareStatement("SELECT * FROM `tbl_accounts` WHERE `agentaccountno`=?");
            ps3.setInt(1,ag);
            ResultSet rs=ps3.executeQuery();
               
           

            List<user> list = new ArrayList<user>();

            user u;

            while(rs.next())
            {
               u = new user(rs.getString("acc_no"),rs.getInt("balance"),
                      rs.getInt("loan"),rs.getString("expriydate"));
               
               list.add(u);
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    // show records and image from database 
    public void showItem(int index)
    {
        
        
        
        accno.setText(getItemsList().get(index).getAccno());
        amount.setText( Integer.toString(getItemsList().get(index).getAmount()));
        loan.setText( Integer.toString(getItemsList().get(index).getLoan()));
        exp.setText(getItemsList().get(index).getExp());
        
        System.out.println(accno.getText());
        
     //getting user id from tbl_account
        Connection connection = getConnection();
     
       PreparedStatement ps6;
        try {
            ps6 = connection.prepareStatement("SELECT `user_id` FROM `tbl_accounts` WHERE `acc_no`=?");
              ps6.setString(1,accno.getText());
            ResultSet result12=ps6.executeQuery();
      
       if(result12.next())
        {
          userid=result12.getInt("user_id");
          System.out.println("uid"+userid);
          
        }
        } catch (SQLException ex) {
            Logger.getLogger(outermainframe.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        //getting name and image from user table
        
        PreparedStatement ps7;
        try {
            ps7 = connection.prepareStatement("SELECT `fname`,`lname`,`pics` FROM `tbl_users` WHERE `id`=?");
            ps7.setInt(1,userid);
            ResultSet result13=ps7.executeQuery();
      
       if(result13.next())
        {
          String f=result13.getString("fname");
          String l=result13.getString("lname");
          Blob blob = result13.getBlob("pics");
          String fi=f+" "+l;
          name.setText(fi);
          int blobLength = (int) blob.length();  
          byte[] bytes = blob.getBytes(1, blobLength);
           final BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(bytes));
          
         photo.setIcon(new ImageIcon(bufferedImage));
          System.out.println("uid"+userid);
          
        }
        } catch (SQLException ex) {
            Logger.getLogger(outermainframe.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(outermainframe.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        //ImageIcon icon = new ImageIcon(getItemsList().get(index).getImage());

        //Image image = icon.getImage().getScaledInstance(jLabel_image.getWidth(), 
           //                      jLabel_image.getHeight(), Image.SCALE_SMOOTH);

        //jLabel_image.setIcon(new ImageIcon(image));
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        uid2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        accno = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        amount = new javax.swing.JLabel();
        loan = new javax.swing.JLabel();
        exp = new javax.swing.JLabel();
        photo = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tamount = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        tdate = new datechooser.beans.DateChooserCombo();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Today collection");

        uid2.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(uid2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93)
                .addComponent(jLabel1)
                .addContainerGap(263, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(uid2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jLabel2.setText("Name :");

        jLabel3.setText("Account no :");

        name.setText("jLabel4");

        accno.setText("jLabel5");

        jLabel6.setText("Amount :");

        jLabel7.setText("Loan :");

        jLabel8.setText("Expiry Date :");

        amount.setText("jLabel9");

        loan.setText("loan");

        exp.setText("jLabel11");

        photo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel13.setText("Today amount :");

        tamount.setName("tamount"); // NOI18N

        jButton1.setText("First");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Next");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Privious");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Last");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Add");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel14.setText("Select Date :");

        jButton6.setText("Load");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Go Back");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(amount))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(accno))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addGap(55, 55, 55)
                                            .addComponent(name)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8))
                                        .addGap(26, 26, 26)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(exp)
                                            .addComponent(loan))))
                                .addGap(101, 101, 101)
                                .addComponent(photo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(tamount, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jButton5))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)
                                .addGap(27, 27, 27)
                                .addComponent(jButton3)
                                .addGap(28, 28, 28)
                                .addComponent(jButton4)
                                .addGap(18, 18, 18)
                                .addComponent(jButton7))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(tdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6)))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel14)
                        .addComponent(tdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton6))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(name))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(accno))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(amount))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(loan)))
                    .addComponent(photo, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(exp))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(tamount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton3)
                            .addComponent(jButton4))
                        .addGap(2, 2, 2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton7))))
        );

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       getdata();
        showItem(pos);
        tamount.requestFocus();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //First Buttomn code
        pos = 0;
        showItem(pos);
        tamount.requestFocus();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         
        //next Button code hear
        pos++;
        if(pos >= getItemsList().size())
        {
            pos = getItemsList().size()-1;
        }
        showItem(pos);
        tamount.requestFocus();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //privious button code
        pos--;
        if(pos < 0)
        {
            pos = 0;
        }
        showItem(pos);
        tamount.requestFocus();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        pos = getItemsList().size() - 1;
        showItem(pos);
        tamount.requestFocus();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       
        Connection conn = getConnection();  
        //getting current agent account no
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
  String date = sdf.format(tdate.getSelectedDate().getTime());
  String toacc=accno.getText();
  int n=Integer.parseInt(toacc);
 
      PreparedStatement ps;  
        try {
            ps=conn.prepareStatement("SELECT `date`,`to_accno` FROM `tblf_transaction` WHERE `date`=? and `to_accno`=?");
            ps.setString(1,date);
            ps.setString(2,toacc);
            ResultSet result=ps.executeQuery();
          if(result.next())
        {
            tamount.setEditable(false);
            JOptionPane.showMessageDialog(null, "you cant make dublicate entry");
        }
          else
          {
            int a1 = Integer.parseInt(uid2.getText());
      System.out.println(a1);
       PreparedStatement ps5;
        try {
            ps5 = conn.prepareStatement("SELECT `accountno` FROM `tbl_agentaccount` WHERE `agentid`=?");
            ps5.setInt(1,a1);
        ResultSet result9=ps5.executeQuery();
         if(result9.next())
        {
          agentno=result9.getString("accountno");
          System.out.println(agentno);
        }
      
        } catch (SQLException ex) {
            Logger.getLogger(todayamount.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      
      
        
        
        
        //generate uniqe transation number
String ni="TX";
 Random ran1=new Random();
 int n1=100000+ran1.nextInt(900000);
 String tn=ni+n1;

 
 
 String m2=tamount.getText();
 int am=Integer.parseInt(m2);
  int ag = Integer.parseInt(agentno);
  String des="Credeted"+am+"by Agent";

//insert amount value into transation
      
      PreparedStatement ps3;
        try {
            ps3 = conn.prepareStatement("INSERT INTO `tblf_transaction`(`tx_no`, `tx_type`, `amount`, `date`, `description`, `to_accno`, `status`, `agentaccountno`) VALUES(?,?,?,?,?,?,?,?)");
            ps3.setString(1,tn);
            ps3.setString(2,"credit");
            ps3.setInt(3,am);
            ps3.setString(4,date);
            ps3.setString(5,des);
            ps3.setInt(6,n);
            ps3.setString(7,"SUCCESS");
            ps3.setInt(8,ag);
            ps3.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(todayamount.class.getName()).log(Level.SEVERE, null, ex);
        }
    
  
          }
        
        } catch (SQLException ex) {
            Logger.getLogger(todayamount.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        
        
        
      
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton7ActionPerformed

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
            java.util.logging.Logger.getLogger(todayamount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(todayamount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(todayamount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(todayamount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new todayamount().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accno;
    private javax.swing.JLabel amount;
    private javax.swing.JLabel exp;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel loan;
    private javax.swing.JLabel name;
    private javax.swing.JLabel photo;
    private javax.swing.JTextField tamount;
    private datechooser.beans.DateChooserCombo tdate;
    public static javax.swing.JLabel uid2;
    // End of variables declaration//GEN-END:variables
}
