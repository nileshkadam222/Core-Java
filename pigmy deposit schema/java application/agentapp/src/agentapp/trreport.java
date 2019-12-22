/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentapp;

/**
 *
 * @author Nilesh
 */
public class trreport {
     private String accountno;
     private int amount;
     private String trno;
   
   
   
    public trreport(String Accountno,int Amount,String Trno)
    {
        this.accountno=Accountno;
        this.amount=Amount;
        this.trno=Trno;
            
      
    }

  
    
    public String getAccountno()
    {
        return accountno;
    }
     public int getAmount()
    {
        return amount;
    }
      public String getTrno()
    {
        return trno;
    }
 
}
