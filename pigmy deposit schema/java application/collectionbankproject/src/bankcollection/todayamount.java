/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankcollection;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Nilesh
 */
public class todayamount extends javax.swing.JInternalFrame {

    /**
     * Creates new form todayamount
     */
    Connection con;
    ResultSet rs;
    Statement st;
     int a=0;
    PreparedStatement ps;
    int ab;
    public todayamount() {
        initComponents();
        try {
            getCheckbox();
        } catch (SQLException ex) {
            Logger.getLogger(todayamount.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        
    }

    
     public void getCheckbox() throws SQLException
     {
        con = DriverManager.getConnection("jdbc:mysql://:3306/db_hlbank","root","");
    st = con.createStatement();
    ResultSet rs = st.executeQuery("SELECT * FROM `tbl_agentaccount`");
    while(rs.next()){
        aname.addItem(rs.getString("accountno"));
        }
    rs.close();
    st.close();
    con.close();
     }
     
     
      public Connection getConnection()
   {
       

       try {
           con = DriverManager.getConnection("jdbc:mysql://localhost/db_hlbank", "root","");
           return con;
       } 
      catch (Exception e) {
           e.printStackTrace();
           return null;
       }
   }
      
      
      public ArrayList<tran> getUsersList()
   {
       ArrayList<tran> usersList = new ArrayList<tran>();
       Connection connection = getConnection();
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(tdate.getSelectedDate().getTime());
        String toacc=aname.getSelectedItem().toString();
      
       Statement st;
       ResultSet rs;
       int sum=0;
       try {
           PreparedStatement ps;
           ps=con.prepareStatement("SELECT * FROM `tblf_transaction` WHERE `date`=? AND `agentaccountno`=?");
            ps.setString(1,date);
            ps.setString(2,toacc);
           rs = ps.executeQuery();

          tran user;

           while(rs.next())
           {
user = new tran(rs.getInt("amount"),rs.getString("to_accno"));
               usersList.add(user);
               sum=sum+rs.getInt("amount");
               tc.setText(Integer.toString(sum));
               
           }

       } 
      catch (Exception e) {
           e.printStackTrace();
       }
       return usersList;
   }

      // Display Data In JTable
      
       public void Show_Users_In_JTable()
   {
       ArrayList<tran> list = getUsersList();
       DefaultTableModel model = (DefaultTableModel)show.getModel();
       Object[] row = new Object[5];
       for(int i = 0; i < list.size(); i++)
       {
           row[0] = list.get(i).getBalance();
           row[1] = list.get(i).getAccountno();
           
           model.addRow(row);
       }
    }
      
       //deposit all agent dated values into main table
       
       public void deposit()
       {
             Connection connection = getConnection();
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(tdate.getSelectedDate().getTime());
        String toacc=aname.getSelectedItem().toString();
      
       Statement st;
       ResultSet rs;
       
       try {
           PreparedStatement ps;
           ps=con.prepareStatement("SELECT * FROM `tblf_transaction` WHERE `date`=? AND `agentaccountno`=?");
            ps.setString(1,date);
            ps.setString(2,toacc);
           rs = ps.executeQuery();

  

           while(rs.next())
           {
               String tx_no1=rs.getString("tx_no");
               String tx_type1=rs.getString("tx_type");
              int amount1=rs.getInt("amount");
               String dec1=rs.getString("description");
               String to_accno1=rs.getString("to_accno");
               String  status1=rs.getString("status");
               
              PreparedStatement ps1 =con.prepareStatement("INSERT INTO `tbl_transaction`(`tx_no`, `tx_type`, `amount`, `date`, `description`, `to_accno`, `status`, `agentaccountno`) VALUES(?,?,?,?,?,?,?,?)");
              ps1.setString(1,tx_no1);
            ps1.setString(2,tx_type1);
            ps1.setInt(3,amount1);
            ps1.setString(4,date);
            ps1.setString(5,dec1);
            ps1.setString(6,to_accno1);
            ps1.setString(7,status1);
            ps1.setString(8,toacc);
            ps1.executeUpdate();
            
                     
             PreparedStatement ps2 =con.prepareStatement("DELETE FROM `tblf_transaction` WHERE `date`=? AND `agentaccountno`=?");
            ps2.setString(1,date);
            ps2.setString(2,toacc);
           ps2.executeUpdate();
           
           
            PreparedStatement ps6 =con.prepareStatement("SELECT `balance` FROM `tbl_accounts` WHERE `acc_no`=?");
            ps6.setString(1,to_accno1);
            ResultSet result=ps6.executeQuery();
            if(result.next())
        {
           
           int bal=result.getInt("balance");
           int famount=amount1+bal;
            //Update  amount into customer  table
     Statement stmt = null;
     stmt = con.createStatement();
     String query = "UPDATE `tbl_accounts` SET `balance`='"+famount+"' WHERE `acc_no` = "+to_accno1;
      stmt.executeUpdate(query);
      
      
      PreparedStatement ps12 =con.prepareStatement("SELECT `balance` FROM `tbl_agentaccount` WHERE `accountno`=?");
            ps12.setString(1,toacc);
            ResultSet result1=ps12.executeQuery();
            if(result1.next())
        {
           
           int bal1=result1.getInt("balance");
                ab = amount1+bal1;
//Update  amount into agent table
     Statement stmt1 = null;
     stmt1 = con.createStatement();
     String query1 = "UPDATE `tbl_agentaccount` SET `balance`='"+ab+"' WHERE `accountno` = "+toacc;
      stmt.executeUpdate(query1);
      
      JOptionPane.showMessageDialog(null, "your transaction was successfully processed");
        }
        }
           }
       } 
      catch (Exception e) {
           e.printStackTrace();
       }
     
       }
       
       
        void lbshow()
    {
       
            //get data from SELECT * FROM `tbl_agentaccount`
            
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(tdate.getSelectedDate().getTime());
        String accnoi=accno.getText();
              
        date11.setText(date);
         
         try {
            //get data from SELECT * FROM `tbl_agentaccount`

            PreparedStatement ps6 =con.prepareStatement("SELECT `user_id`,`balance` FROM `tbl_accounts` WHERE `acc_no`=?");
            ps6.setString(1,accnoi);
            ResultSet result=ps6.executeQuery();
            if(result.next())
        {
           int uid=result.getInt("user_id");
           int bal=result.getInt("balance");
           
           balance123.setText(Integer.toString(bal));
           System.out.println(uid);
           
           PreparedStatement ps7 =con.prepareStatement("SELECT `fname`,`lname`,`pics` FROM `tbl_users` WHERE `id`=?");
            ps7.setInt(1,uid);
            ResultSet result12=ps7.executeQuery();
        if(result12.next())
        {
          String f=result12.getString("fname");
          String l=result12.getString("lname");
          Blob blob = result12.getBlob("pics");
          String fi=f+" "+l;
          name.setText(fi);
          int blobLength = (int) blob.length();  
          byte[] bytes = blob.getBytes(1, blobLength);
           final BufferedImage bufferedImage;
               try {
                   bufferedImage = ImageIO.read(new ByteArrayInputStream(bytes));
                    photo.setIcon(new ImageIcon(bufferedImage));
               } catch (IOException ex) {
                   Logger.getLogger(todayamount.class.getName()).log(Level.SEVERE, null, ex);
               }
          
        
      
          
        }
          
          
           
         }
            
        } catch (SQLException ex) {
            Logger.getLogger(viewagent.class.getName()).log(Level.SEVERE, null, ex);
        }
       
           
          
           
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
        jLabel2 = new javax.swing.JLabel();
        aname = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        tdate = new datechooser.beans.DateChooserCombo();
        jButton5 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        tc = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        show = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        photo = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        accno = new javax.swing.JLabel();
        date11 = new javax.swing.JLabel();
        amount = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        balance123 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);

        jLabel1.setText("Select Agent :");

        jLabel2.setText("Date :");

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Deposit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton5.setText("Go Back");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel9.setText("Total Collection:");

        tc.setText("jLabel10");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel2)
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(aname, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tc))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(tdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tc))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        show.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Account no", "Amount"
            }
        ));
        show.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(show);

        jLabel3.setText("Name :");

        jLabel4.setText("Account No :");

        jLabel5.setText("Date :");

        jLabel6.setText("Amount :");

        photo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setText("Photo");

        name.setText("jLabel9");

        accno.setText("jLabel10");

        date11.setText("jLabel11");

        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel7.setText("Total Balance :");

        balance123.setText("jLabel9");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(45, 45, 45)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(45, 45, 45)
                                .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(87, 87, 87)
                                .addComponent(jLabel8))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(date11))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(55, 55, 55)
                                        .addComponent(name))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(27, 27, 27)
                                        .addComponent(accno))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(balance123)))
                                .addGap(128, 128, 128)
                                .addComponent(photo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jButton3)
                        .addGap(30, 30, 30)
                        .addComponent(jButton4)))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(name))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(accno))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(date11))
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(balance123)))
                            .addComponent(photo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton4)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       if(a==0)
       {
        
                Show_Users_In_JTable();
                a++;
       }
       else
       {
            // refresh jtable data
               DefaultTableModel model = (DefaultTableModel)show.getModel();
               model.setRowCount(0);
               Show_Users_In_JTable();
       }
    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       deposit();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void showMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showMouseClicked
        int i = show.getSelectedRow();

        TableModel model = show.getModel();
        
         // Display Slected Row In JTexteFields
        
        amount.setText(model.getValueAt(i, 0).toString());
        accno.setText(model.getValueAt(i,1).toString()); 
        lbshow();
    }//GEN-LAST:event_showMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         Statement stmt = null;
       
    
        try {
             int l=Integer.parseInt(amount.getText());
             String an=accno.getText();
            
            stmt = con.createStatement();
             String query = "UPDATE `tblf_transaction` SET `amount`='"+l+"' WHERE `to_accno` = "+an;
             stmt.executeUpdate(query);
             // refresh jtable data
               DefaultTableModel model = (DefaultTableModel)show.getModel();
               model.setRowCount(0);
               Show_Users_In_JTable();
             JOptionPane.showMessageDialog(null, "Customer Entry is Update");
        } catch (SQLException ex) {
            Logger.getLogger(loan.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Statement stmt = null;
       
    
        try {
             int l=Integer.parseInt(amount.getText());
             String an=accno.getText();
            
            stmt = con.createStatement();
             String query = "DELETE FROM `tblf_transaction` WHERE `to_accno` = "+an;
             stmt.executeUpdate(query);
             // refresh jtable data
               DefaultTableModel model = (DefaultTableModel)show.getModel();
               model.setRowCount(0);
               Show_Users_In_JTable();
             JOptionPane.showMessageDialog(null, "Customer Entry is Update");
        } catch (SQLException ex) {
            Logger.getLogger(loan.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       this.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accno;
    private javax.swing.JTextField amount;
    private javax.swing.JComboBox<String> aname;
    private javax.swing.JLabel balance123;
    private javax.swing.JLabel date11;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel name;
    private javax.swing.JLabel photo;
    private javax.swing.JTable show;
    private javax.swing.JLabel tc;
    private datechooser.beans.DateChooserCombo tdate;
    // End of variables declaration//GEN-END:variables
}
