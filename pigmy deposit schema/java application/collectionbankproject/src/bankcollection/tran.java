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
public class tran {
   
   private String accountno;
   private int balance;
   
;
   
   
    public tran(int Balance,String Accountno)
    {
        
        this.accountno=Accountno;
        this.balance=Balance;   
       
      
    }

  
    
     public String getAccountno()
    {
        return accountno;
    }
      public int getBalance()
    {
        return balance;
    }
 
    
}
