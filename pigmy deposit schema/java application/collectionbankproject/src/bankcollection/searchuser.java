/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankcollection;


public class searchuser 
{
    private int id;
    private int accountno;
    private int balance;
    private int loan;
    
    public searchuser(int Id,int Account,int Balance,int Loan )
    {
        this.id = Id;
        this.accountno = Account;
        this.balance=Balance;
        this.loan=Loan;
    }
    
    public int getId()
    {
        return id;
    }
    
    
    public int getAccount()
    {
        return accountno;
    }
    public int getBalance()
    {
        return balance;
    }
    public int getLoan()
    {
        return loan;
    }
    
}
