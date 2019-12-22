/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankcollection;

/**
 *
 * @author Nilesh
 */
public class loan1 
{
     private int id;
   private String accountno;
   private int balance;
   private String nominal;
;
   
   
    public loan1(int ID,String Accountno, int Balance,String Nominal)
    {
        this.id=ID;
        this.accountno=Accountno;
        this.balance=Balance;
        this.nominal=Nominal;
        
       
      
    }

  
    
    public int getID()
    {
        return id;
    }
     public String getAccountno()
    {
        return accountno;
    }
      public int getBalance()
    {
        return balance;
    }
 
    public String getNominal()
    {
        return nominal;
    }
}
