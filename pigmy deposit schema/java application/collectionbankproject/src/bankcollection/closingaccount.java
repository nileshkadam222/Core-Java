/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankcollection;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Nilesh
 */
public class closingaccount extends javax.swing.JFrame {

    /**
     * Creates new form closingaccount
     */
    Connection con;
        Statement st;
    public closingaccount() {
        initComponents();
        Show_Users_In_JTable();
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
    
    public ArrayList<view_agent> getUsersList()
   {
       ArrayList<view_agent> usersList = new ArrayList<view_agent>();
       Connection connection = getConnection();
       
       String query = "SELECT * FROM `tbl_users` WHERE `utype`='USER'";
       Statement st;
       ResultSet rs;
       
       try {
           st = connection.createStatement();
           rs = st.executeQuery(query);

          view_agent user;

           while(rs.next())
           {
user = new view_agent(rs.getInt("id"),rs.getString("fname"),rs.getString("lname"),rs.getString("email"),rs.getString("phone"));
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
       ArrayList<view_agent> list = getUsersList();
       DefaultTableModel model = (DefaultTableModel)jTable2.getModel();
       Object[] row = new Object[5];
       for(int i = 0; i < list.size(); i++)
       {
           row[0] = list.get(i).getID();
           row[1] = list.get(i).getAfname();
           row[2] = list.get(i).getAlastname();
           row[3] = list.get(i).getAmail();
           row[4]=list.get(i).getAcontact();
           
           model.addRow(row);
       }
    }

       //search code start hear for customer
        
 
    
    public ArrayList<searchagent> ListUsers(String ValToSearch)
    {
        ArrayList<searchagent> usersList = new ArrayList<searchagent>();
        
        Statement st;
        ResultSet rs;
        
        try{
            Connection con = getConnection();
            st = con.createStatement();
            String searchQuery = "SELECT * FROM `tbl_users`  WHERE `utype`='USER' AND CONCAT(`id`,`fname`,`lname`,email,phone) LIKE '%"+ValToSearch+"%'";
            rs = st.executeQuery(searchQuery);
            
            searchagent user;
            
            while(rs.next())
            {
                user = new searchagent(
                                 rs.getInt("id"),
                                 rs.getString("fname"),
                                 rs.getString("lname"),
                                 rs.getString("email"),
                                 rs.getString("phone")
                                 );
                usersList.add(user);
            }
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        return usersList;
    }
    
    // function to display data in jtable
    public void findUsers()
    {
        ArrayList<searchagent> users = ListUsers(search.getText());
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"ID","First name","Last name","Email Address","phone number"});
        Object[] row = new Object[5];
        
        for(int i = 0; i < users.size(); i++)
        {
            row[0] = users.get(i).getId();
            row[1] = users.get(i).getFname();
            row[2] = users.get(i).getLname();
            row[3]=users.get(i).getEmail();
            row[4]=users.get(i).getPhone();
            model.addRow(row);
        }
       jTable2.setModel(model);
       
    }

             int an=0; 
     int aid=0;
     void lbshow()
    {
      
        try {
            //get data from SELECT * FROM `tbl_agentaccount`

            PreparedStatement ps =con.prepareStatement("SELECT * FROM `tbl_accounts` WHERE `user_id`= ?");
            ps.setInt(1, Integer.parseInt(id.getText()));
            ResultSet result=ps.executeQuery();
            if(result.next())
        {
           int acc=result.getInt("acc_no");
           int bal=result.getInt("balance");
           int loan1=result.getInt("loan");
           String opend=result.getString("opendate");
           String exp=result.getString("expriydate");
           String lo=result.getString("loandate");
           
           System.out.println(exp);
           DateFormat df = new SimpleDateFormat("dd/MM/yy");
           Date dateobj = new Date();
           System.out.println(dateobj);
            String udate1 = df.format(dateobj); 
           Date date12 = df.parse(udate1);
           System.out.println(udate1);
           
           Date date2 = df.parse(exp);
           System.out.println("exp:"+date2);  
           
           System.out.println("lo"+lo);
           
        
          
            //loan date calculation
            String d="no";
            if(lo.equals(d))
            {
            int Servicecharges=0;
           int less=0;
           //loan calculation
           float lin=(loan1*14)/100;
           float dayint=lin/365;
           float loanint=dayint*0;
           System.out.println("loan"+loanint);
           float totalloan=loan1+loanint;
            int sum=0;
          //get balance cf vise data
           PreparedStatement ps1 =con.prepareStatement("SELECT * FROM `tbl_transaction` WHERE `to_accno`= ?");
            ps1.setInt(1, acc);
            ResultSet result1=ps1.executeQuery();
            while(result1.next())
            {
                int am=result1.getInt("amount");
                sum=sum+am;
            }
            System.out.println(sum);
           
           float interet=(sum*3)/100;
           
           float extra=Servicecharges+less+totalloan;
           float ab=interet+bal;
           float total=ab-extra;
            nday.setText("0 Days");
           cin.setText(Float.toString(interet));
           anumber.setText(Integer.toString(acc));
           od.setText(opend);
           bal1.setText(Integer.toString(bal));
           le.setText(Integer.toString(less));
           sc.setText(Integer.toString(Servicecharges));
           loan.setText(Integer.toString(loan1));
           li.setText(Float.toString(loanint));
           tl.setText(Float.toString(totalloan));
           finala.setText(Float.toString(total));
           finalamount.setText(Float.toString(totalloan));
            lod.setText(lo);
 
            }
           else
            {
           
            String dateStart=lo;
           String dateStop=udate1;
           
           System.out.println(lo);
           
           System.out.println(udate1);
      
                Date d1 = null;
		Date d2 = null;
                d1 = df.parse(dateStart);
                d2 = df.parse(dateStop);
             long diff = (int) (d2.getTime() - d1.getTime());
                long diffDays = diff / (24 * 60 * 60 * 1000);
                 System.out.println(diffDays);
      
             //Display all transation   
           
           if(date2.after(dateobj))
          {
           int Servicecharges=25;
           int less=(bal*3)/100;
           int lin=(loan1*14)/100;
           int dayint=lin/365;
         float loanint=dayint*diffDays;
          float totalloan=loan1+loanint;
           System.out.println(loanint);
           float extra=Servicecharges+less+totalloan;
         float total=bal-extra;
           int inter=0;
           nday.setText(Long.toString(diffDays)+" Days");
           anumber.setText(Integer.toString(acc));
           od.setText(opend);
           bal1.setText(Integer.toString(bal));
           le.setText(Integer.toString(less));
           sc.setText(Integer.toString(Servicecharges));
           loan.setText(Integer.toString(loan1));
           li.setText(Float.toString(loanint));
           tl.setText(Float.toString(totalloan));
           finala.setText(Float.toString(total));
           finalamount.setText(Float.toString(totalloan));
           cin.setText(Integer.toString(inter));
           lod.setText(lo);
          }
           
           else
          {
           int Servicecharges=0;
           int less=0;
           //loan calculation
           float lin=(loan1*14)/100;
           float dayint=lin/365;
           float loanint=dayint*diffDays;
           System.out.println("loan"+loanint);
           float totalloan=loan1+loanint;
            int sum=0;
          //get balance cf vise data
           PreparedStatement ps1 =con.prepareStatement("SELECT * FROM `tbl_transaction` WHERE `to_accno`= ?");
            ps1.setInt(1, acc);
            ResultSet result1=ps1.executeQuery();
            while(result1.next())
            {
                int am=result1.getInt("amount");
                sum=sum+am;
            }
            System.out.println(sum);
           
           float interet=(sum*3)/100;
           
           float extra=Servicecharges+less+totalloan;
           float ab=interet+bal;
           float total=ab-extra;
            nday.setText(Long.toString(diffDays)+" Days");
           cin.setText(Float.toString(interet));
           anumber.setText(Integer.toString(acc));
           od.setText(opend);
           bal1.setText(Integer.toString(bal));
           le.setText(Integer.toString(less));
           sc.setText(Integer.toString(Servicecharges));
           loan.setText(Integer.toString(loan1));
           li.setText(Float.toString(loanint));
           tl.setText(Float.toString(totalloan));
           finala.setText(Float.toString(total));
           finalamount.setText(Float.toString(totalloan));
            lod.setText(lo);
          }
           
            }
         }
            
            
            
           
            
            
        } catch (SQLException ex) {
            Logger.getLogger(viewagent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(closingaccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
       
    }
    
     
     public ArrayList<custrepot> getUsersList1()
   {
       ArrayList<custrepot> usersList = new ArrayList<custrepot>();
       Connection connection = getConnection();
       
       try {
         
            PreparedStatement ps3;
            String agno=anumber.getText();
          
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
      
       public void Show_Users_In_JTable1()
   {
      // refresh jtable data
               DefaultTableModel model12 = (DefaultTableModel)jTable3.getModel();
               model12.setRowCount(0);
       ArrayList<custrepot> list = getUsersList1();
       DefaultTableModel model = (DefaultTableModel)jTable3.getModel();
       Object[] row = new Object[5];
       for(int i = 0; i < list.size(); i++)
       {
          
           row[0] = list.get(i).getTrno();
           row[1] = list.get(i).getAmount();
           row[2] = list.get(i).getDate();
            row[3] = list.get(i).getDec();
           
           model.addRow(row);
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
          jPanel3.printAll(g2);
           
            
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
      
      public void executeSQlQuery(String query, String message)
   {
       Connection con = getConnection();
       Statement st;
       try{
           st = con.createStatement();
           if((st.executeUpdate(query)) == 1)
           {
               // refresh jtable data
              
               
               JOptionPane.showMessageDialog(null, "Data "+message+" Succefully");
           }else{
               JOptionPane.showMessageDialog(null, "Data Not "+message);
           }
       }catch(Exception ex){
           ex.printStackTrace();
       }
   }
     
       
    //send information in tbl_close
      public void close_account()
      {
          getConnection();
          String id12=id.getText();
          int fid=Integer.parseInt(id12);
          String id1=anumber.getText();
          String name1=fullname.getText();
          String totalcollect=bal1.getText();
          String bcc=le.getText();
          String service=sc.getText();
          String totalloan=finalamount.getText();
          String Totalamount=finala.getText();
          String start=od.getText();
           DateFormat df = new SimpleDateFormat("dd/MM/yy");
            Date dateobj = new Date();
            String end=df.format(dateobj);
            
             PreparedStatement ps1;
        try {
            ps1 = con.prepareStatement("INSERT INTO `tbl_close`(`name`, `account_no`, `totalbalance`, `beforeclose`, `service`, `totalloan`, `totalamount`, `opendate`, `closedate`) VALUES (?,?,?,?,?,?,?,?,?)");
            ps1.setString(1,name1);
            ps1.setString(2,id1);
            ps1.setString(3,totalcollect);
            ps1.setString(4,bcc);
            ps1.setString(5,service);
            ps1.setString(6,totalloan);
            ps1.setString(7,Totalamount);
            ps1.setString(8,start);
            ps1.setString(9,end);
            ps1.executeUpdate();
            
            
         
             st = con.createStatement();
            
            String query = "DELETE FROM `tbl_users` WHERE id = "+fid;
            st.executeUpdate(query);
            
            String query1 = "DELETE FROM `tbl_address` WHERE user_id = "+fid;
            st.executeUpdate(query1);
            
            String query2 = "DELETE FROM `tbl_accounts` WHERE user_id = "+fid;
            st.executeUpdate(query2);
            
            String query3 = "DELETE FROM `tbl_transaction` WHERE to_accno= "+id1;
            st.executeUpdate(query3);
             JOptionPane.showMessageDialog(null, "Succefully Close Account");
            
           
        } catch (SQLException ex) {
            Logger.getLogger(closingaccount.class.getName()).log(Level.SEVERE, null, ex);
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
        jPanel2 = new javax.swing.JPanel();
        search = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        fullname = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        anumber = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        bal1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        od = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        le = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        sc = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        finalamount = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        loan = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        li = new javax.swing.JLabel();
        tl = new javax.swing.JLabel();
        finala = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cin = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lod = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        nday = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 84, Short.MAX_VALUE)
        );

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });

        jButton2.setText("Print");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jLabel1.setText("Name :");

        fullname.setText("jLabel2");

        jLabel3.setText("Account Number :");

        anumber.setText("jLabel4");

        jLabel5.setText("Total Balance :");

        bal1.setText("jLabel6");

        jLabel7.setText("Opening Date :");

        od.setText("jLabel8");

        jLabel9.setText("Befor Close Charge :");

        le.setText("jLabel10");

        jLabel11.setText("Service charges :");

        sc.setText("jLabel12");

        jLabel13.setText("Your Total Amount :");

        finalamount.setText("jLabel14");

        jLabel15.setText("Your Transations :");

        jLabel2.setText("ID :");

        id.setText("jLabel16");

        jLabel16.setText("Loan Amount :");

        loan.setText("jLabel17");

        jLabel4.setText("Loan Interest (14 % ) :");

        jLabel6.setText("Loan Calculation :");

        jLabel8.setText("Total Loan :");

        jLabel10.setText("Total loan :");

        li.setText("jLabel12");

        tl.setText("jLabel12");

        finala.setText("jLabel12");

        jLabel12.setText("Interest :");

        cin.setText("jLabel14");

        jLabel14.setText("Loan date :");

        lod.setText("jLabel17");

        jLabel17.setText("Number of day :");

        nday.setText("jLabel18");

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tr NO", "Date", "Amount", "Description"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel7))
                                .addGap(44, 44, 44)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(anumber, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bal1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(od)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(id)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(fullname, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(37, 37, 37)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                                    .addComponent(jLabel14)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(lod))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel16)
                                                        .addComponent(jLabel17))
                                                    .addGap(27, 27, 27)
                                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(loan)
                                                        .addComponent(nday))))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel4)
                                                    .addComponent(jLabel8))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(tl)
                                                    .addComponent(li)))))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel13))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addComponent(finalamount))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(finala))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel12))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cin)
                                    .addComponent(le)))
                            .addComponent(jLabel15)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(36, 36, 36)
                                .addComponent(sc))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(id))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fullname)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(lod))
                .addGap(4, 4, 4)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(nday))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(od)
                            .addComponent(jLabel16))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(bal1)
                            .addComponent(jLabel4)
                            .addComponent(li))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(cin)
                            .addComponent(jLabel8)
                            .addComponent(tl))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(le))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(sc)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(anumber))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loan)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(finalamount)
                    .addComponent(jLabel10))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(finala))
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton3.setText("Close Account");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4)
                                .addGap(0, 30, Short.MAX_VALUE))
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton3)
                                    .addComponent(jButton4))
                                .addGap(21, 21, 21)))
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       findUsers();
    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        findUsers();
    }//GEN-LAST:event_jButton1KeyPressed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        int i = jTable2.getSelectedRow();

        TableModel model = jTable2.getModel();
        
         // Display Slected Row In JTexteFields
        
        id.setText(model.getValueAt(i, 0).toString());
        String fname=model.getValueAt(i,1).toString()+" "+model.getValueAt(i, 2).toString();
         fullname.setText(fname);
       lbshow();
       Show_Users_In_JTable1();
    }//GEN-LAST:event_jTable2MouseClicked

    
    
    
    
    
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       printWork();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
close_account();        
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
            java.util.logging.Logger.getLogger(closingaccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(closingaccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(closingaccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(closingaccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new closingaccount().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel anumber;
    private javax.swing.JLabel bal1;
    private javax.swing.JLabel cin;
    private javax.swing.JLabel finala;
    private javax.swing.JLabel finalamount;
    private javax.swing.JLabel fullname;
    private javax.swing.JLabel id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JLabel le;
    private javax.swing.JLabel li;
    private javax.swing.JLabel loan;
    private javax.swing.JLabel lod;
    private javax.swing.JLabel nday;
    private javax.swing.JLabel od;
    private javax.swing.JLabel sc;
    private javax.swing.JTextField search;
    private javax.swing.JLabel tl;
    // End of variables declaration//GEN-END:variables
}
