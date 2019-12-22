/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankcollection;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nilesh
 */
public class Viewtransation extends javax.swing.JFrame {

    /**
     * Creates new form Viewtransation
     */
     Connection con;
    public Viewtransation() {
        initComponents();
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

     public ArrayList<custrepot> getUsersList()
   {
       ArrayList<custrepot> usersList = new ArrayList<custrepot>();
       Connection connection = getConnection();
       
       try {
         
            PreparedStatement ps3;
            String agno=accountnumber.getText();
          
           int sum=0;
            ps3 = connection.prepareStatement("SELECT `tx_no`,`amount`,`date`,`description` FROM `tbl_transaction` WHERE `to_accno`=?");
            ps3.setString(1,agno);
            ResultSet rs=ps3.executeQuery();
           custrepot user;
           while(rs.next())
            {
               user = new custrepot(rs.getString("tx_no"),rs.getInt("amount"),
                      rs.getString("date"),rs.getString("description"));
               
                              
     
               usersList.add(user);
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
       ArrayList<custrepot> list = getUsersList();
       DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
       Object[] row = new Object[5];
       for(int i = 0; i < list.size(); i++)
       {
           jTable1.getColumnModel().getColumn(i).setMinWidth(0);
           row[1] = list.get(i).getTrno();
           row[2] = list.get(i).getAmount();
           row[3] = list.get(i).getDate();
            row[4] = list.get(i).getDec();
           
           model.addRow(row);
       }
    }  

       
       public void show_info() 
       {
            Connection connection = getConnection();
           String accno=accountnumber.getText();
             PreparedStatement ps6;
        try {
            ps6 = connection.prepareStatement("SELECT * FROM `tbl_accounts` WHERE `acc_no`=?");
              ps6.setString(1,accno);
            ResultSet result12=ps6.executeQuery();
      
       if(result12.next())
        {
          int userid=result12.getInt("user_id");
          int bal=result12.getInt("balance");
          String agentno=result12.getString("agentaccountno");
          int loan=result12.getInt("loan");
          String opendate=result12.getString("opendate");
          String exp1=result12.getString("expriydate");
          System.out.println(userid);
          
          PreparedStatement ps7;
       
            ps7 = connection.prepareStatement("SELECT `fname`,`lname`,`pics` FROM `tbl_users` WHERE `id`=?");
              ps7.setInt(1,userid);
            ResultSet result13=ps7.executeQuery();
      
       if(result13.next())
        {
            String fname=result13.getString("fname");
            String lname=result13.getString("lname");
             Blob blob = result13.getBlob("pics");
             
             String name=fname+" "+lname;
             nm.setText(name);
             acno.setText(accno);
             opendt.setText("Open Date :");
             open.setText(opendate);
             expdate.setText("Exp Date :");
             exp.setText(exp1);
             dyn.setText("Loan :");
             comm.setText(Integer.toString(loan));
             amount.setText(Integer.toString(bal));
              int blobLength = (int) blob.length();  
          byte[] bytes = blob.getBytes(1, blobLength);
           final BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(bytes));
          
         photo.setIcon(new ImageIcon(bufferedImage));
             
             
        }
         
          
        }
       } catch (SQLException ex) {
             Logger.getLogger(Viewtransation.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(Viewtransation.class.getName()).log(Level.SEVERE, null, ex);
         }
       }
    
       
       public void printWork()
{
    PrinterJob pj = PrinterJob.getPrinterJob();
    pj.setJobName(" Opt De Solver Printing ");

    pj.setPrintable(new Printable()
    {
        public int print(Graphics pg, PageFormat pf, int pageNum)
        {
            if(pageNum > 0)
                return Printable.NO_SUCH_PAGE;

            Graphics2D g2 = (Graphics2D)pg;
            g2.translate(pf.getImageableX(), pf.getImageableY());
          printpanel.printAll(g2);
           
            
            /* I've tried the following commented codes but they don't work */
            //MainAppPanel.this.printAll(g2);
            //MainAppPanel.this.print(g2);
            //MainAppPanel.this.print(g2);
            return Printable.PAGE_EXISTS;
        }
    });
    if(pj.printDialog() == false)
        return;
    try
    {
        pj.print();
    }
    catch(PrinterException xcp)
    {
        xcp.printStackTrace(System.err);
    }
}
      
public void show_agent()
{
      Connection connection = getConnection();
           String accno=accountnumber.getText();
             PreparedStatement ps6;
        try {
            ps6 = connection.prepareStatement("SELECT * FROM `tbl_agentaccount` WHERE `accountno`=?");
              ps6.setString(1,accno);
            ResultSet result12=ps6.executeQuery();
      
       if(result12.next())
        {
          int userid=result12.getInt("agentid");
          int bal=result12.getInt("balance");
         
          
          PreparedStatement ps7;
       
            ps7 = connection.prepareStatement("SELECT `fname`,`lname`,`pics` FROM `tbl_users` WHERE `id`=?");
              ps7.setInt(1,userid);
            ResultSet result13=ps7.executeQuery();
      
       if(result13.next())
        {
            String fname=result13.getString("fname");
            String lname=result13.getString("lname");
             Blob blob = result13.getBlob("pics");
             
             String name=fname+" "+lname;
             int com=(bal*3)/100;
             nm.setText(name);
             acno.setText(accno);
             dyn.setText("Com :");
             comm.setText(Integer.toString(com));
             amount.setText(Integer.toString(bal));
              int blobLength = (int) blob.length();  
          byte[] bytes = blob.getBytes(1, blobLength);
           final BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(bytes));
          
         photo.setIcon(new ImageIcon(bufferedImage));
             
             
        }
         
          
        }
       } catch (SQLException ex) {
             Logger.getLogger(Viewtransation.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(Viewtransation.class.getName()).log(Level.SEVERE, null, ex);
         }
}
       
    

 public ArrayList<showagent> getUsersList1()
   {
       ArrayList<showagent> usersList = new ArrayList<showagent>();
       Connection connection = getConnection();
       
       try {
         
            PreparedStatement ps3;
            String agno=accountnumber.getText();
          
      
            ps3 = connection.prepareStatement("SELECT * FROM `tbl_transaction` WHERE `agentaccountno`=?");
            ps3.setString(1,agno);
            ResultSet rs=ps3.executeQuery();
           showagent user;
           while(rs.next())
            {
               user = new showagent(rs.getString("to_accno"),rs.getString("tx_no"),rs.getInt("amount"),
                      rs.getString("date"),rs.getString("description"));
               
                              
     
               usersList.add(user);
            }
           
           }
      catch (Exception e) {
           e.printStackTrace();
       }
       return usersList;
   }

   // Display Data In JTable
      
       public void Show_Agent_In_JTable()
   {
       ArrayList<showagent> list = getUsersList1();
       DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
       Object[] row = new Object[5];
       for(int i = 0; i < list.size(); i++)
       {
          row[0] = list.get(i).getAccount();
           row[1] = list.get(i).getTrno();
           row[2] = list.get(i).getAmount();
           row[3] = list.get(i).getDate();
            row[4] = list.get(i).getDec();
           
           model.addRow(row);
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
        sel = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        accountnumber = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        printpanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        photo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nm = new javax.swing.JLabel();
        acno = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        amount = new javax.swing.JLabel();
        dyn = new javax.swing.JLabel();
        comm = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        opendt = new javax.swing.JLabel();
        open = new javax.swing.JLabel();
        expdate = new javax.swing.JLabel();
        exp = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        sel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Agent", "Customer" }));

        jLabel1.setText("Select Report :");

        jButton1.setText("Show Report");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Account Number :");

        jButton2.setText("Print Report");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Go Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addComponent(sel, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addComponent(accountnumber, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton3)
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(accountnumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jLabel3.setText("Name :");

        photo.setText("Photo :");
        photo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setText("Account no :");

        nm.setText("jLabel6");

        acno.setText("jLabel7");

        jLabel8.setText("Total amount :");

        amount.setText("jLabel9");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Account No", "transaction No", "Amount", "Date", "Description"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("Your Transation Report :");

        javax.swing.GroupLayout printpanelLayout = new javax.swing.GroupLayout(printpanel);
        printpanel.setLayout(printpanelLayout);
        printpanelLayout.setHorizontalGroup(
            printpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(printpanelLayout.createSequentialGroup()
                .addGroup(printpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(printpanelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel12))
                    .addGroup(printpanelLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(printpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(opendt)
                            .addGroup(printpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel5)))
                        .addGap(31, 31, 31)
                        .addGroup(printpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(open, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nm, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(acno, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(70, 70, 70)
                .addGroup(printpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(dyn)
                    .addComponent(expdate))
                .addGap(18, 18, 18)
                .addGroup(printpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exp, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comm)
                    .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addComponent(photo, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
            .addGroup(printpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
        );
        printpanelLayout.setVerticalGroup(
            printpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(printpanelLayout.createSequentialGroup()
                .addGroup(printpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(printpanelLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(printpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(nm)
                            .addComponent(jLabel8)
                            .addComponent(amount))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(printpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(acno)
                            .addComponent(dyn)
                            .addComponent(comm))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(printpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(opendt)
                            .addComponent(open)
                            .addComponent(expdate)
                            .addComponent(exp))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12))
                    .addComponent(photo, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(printpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(printpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       String select=sel.getSelectedItem().toString();
       nm.setText("");
       amount.setText("");
       acno.setText("");
       dyn.setText("");
       comm.setText("");
       if(select.equals("Customer"))
       {
           show_info();
            // refresh jtable data
               DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
               model.setRowCount(0);
               Show_Users_In_JTable();
       }
       else if(select.equals("Agent"))
       {
           show_agent();
            // refresh jtable data
               DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
               model.setRowCount(0);
               Show_Agent_In_JTable();
              
       }
       
    }//GEN-LAST:event_jButton1ActionPerformed

    
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        printWork();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Viewtransation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Viewtransation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Viewtransation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Viewtransation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Viewtransation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField accountnumber;
    private javax.swing.JLabel acno;
    private javax.swing.JLabel amount;
    private javax.swing.JLabel comm;
    private javax.swing.JLabel dyn;
    private javax.swing.JLabel exp;
    private javax.swing.JLabel expdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel nm;
    private javax.swing.JLabel open;
    private javax.swing.JLabel opendt;
    private javax.swing.JLabel photo;
    private javax.swing.JPanel printpanel;
    private javax.swing.JComboBox<String> sel;
    // End of variables declaration//GEN-END:variables
}
