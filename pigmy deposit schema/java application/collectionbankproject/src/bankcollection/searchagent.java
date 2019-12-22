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
public class searchagent {
     private int id;
    private String fname;
    private String lname;
    private String email;
    private String phone;
    
    public searchagent(int Id,String Fname,String Lname,String Email,String Phone )
    {
        this.id = Id;
        this.fname = Fname;
        this.lname = Lname;
        this.email=Email;
        this.phone=Phone;
        
    }
    
    public int getId()
    {
        return id;
    }
    
    public String getFname()
    {
        return fname;
    }
    
    public String getLname()
    {
        return lname;
    }
    
    public String getEmail()
    {
        return email;
    }
    public String getPhone()
    {
        return phone;
    }
    
   
    
}
