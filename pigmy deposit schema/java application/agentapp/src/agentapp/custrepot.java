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
public class custrepot {
    
     private String date;
     private int amount;
     private String trno;
   
   
   
    public custrepot(String Trno,int Amount,String Date)
    {
        this.trno=Trno;
        this.date=Date;
        this.amount=Amount;
       
            
      
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
 
    
}
