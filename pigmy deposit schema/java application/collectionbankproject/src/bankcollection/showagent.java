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
public class showagent {
    private String date;
     private int amount;
     private String trno;
     private String dec;
     private String account;
   
   
   
    public showagent(String Account,String Trno,int Amount,String Date,String Dec)
    {
        this.trno=Trno;
        this.date=Date;
        this.amount=Amount;
       this.dec=Dec;
       this.account=Account;
            
      
    }

  public String getAccount()
  {
   return account;   
  }
    
    public String getTrno()
    {
        return trno;
    }
     public int getAmount()
    {
        return amount;
    }
      public String getDate()
    {
        return date;
    }
 
    public String getDec()
    {
        return dec;
    }
    
}
