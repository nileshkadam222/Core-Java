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
public class user {
     private String accno;
    private int amount;
    private int loan;
    private String exp;

    public user(){}
    public user(String Accno,int Amount,int Loan,String Exp){
        this.accno = Accno;
        this.amount = Amount;
        this.loan = Loan;
        this.exp = Exp;  
    }
    
    public String getAccno(){
     return this.accno;
    }
    
    public int getAmount(){
        return this.amount;
    }
    
    
    public int getLoan(){
        return this.loan;
    }
    
    public String getExp(){
        return this.exp;
    }
    
}
