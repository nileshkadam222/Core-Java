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
public class searchloan {
    private int id;
    private String account;
    private int balance;
    private String nominal;
    
  
    
    public searchloan(int Id,String Account,int Balance,String Nominal)
    {
        this.id = Id;
        this.account = Account;
        this.balance=Balance;
        this.nominal=Nominal;
        
        
    }
    
    public int getId()
    {
        return id;
    }
    
    public String getAccount()
    {
        return account;
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
