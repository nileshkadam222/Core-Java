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
public class view_agent {
     private int id;
   private String afname;
   private String alname;
   private String ausername;
   private String aemail;
   private String acontact;
   
   
    public view_agent(int ID,String Afname, String Alastname,String Amail,String Acontact)
    {
        this.id=ID;
        this.afname=Afname;
        this.alname = Alastname;
        this.aemail=Amail;
        this.acontact=Acontact;
       
        
       
      
    }

  
    
    public int getID()
    {
        return id;
    }
     public String getAfname()
    {
        return afname;
    }
      public String getAlastname()
    {
        return alname;
    }
 
    public String getAmail()
    {
        return aemail;
    }
     public String getAcontact()
    {
        return acontact;
    }
  
    
}
