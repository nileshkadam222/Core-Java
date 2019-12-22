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
public class searchadmin 
{
 private int id;
    private String fname;
    private String lname;
    private String user;
    private String email;
    private String phone;
    private String address;
    private String type;
    
    public searchadmin(int Id,String Fname,String Lname,String User,String Email,String Phone,String Address,String Type)
    {
        this.id = Id;
        this.fname = Fname;
        this.lname = Lname;
        this.email=Email;
        this.phone=Phone;
        this.address=Address;
        this.phone=Phone;
        this.user=User;
        this.type=Type;
        
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
     public String getAddress()
    {
        return address;
    }
    public String getType()
    {
        return type;
    }
    public String getUsername()
    {
        return user;
    }
   
    
}
