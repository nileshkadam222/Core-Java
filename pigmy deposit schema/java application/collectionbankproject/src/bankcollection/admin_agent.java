
package bankcollection;


public class admin_agent 
{
    private int id;
   private String afname;
   private String alname;
   private String ausername;
   private String aemail;
   private String acontact;
   private String aaddress;
   private String type;
    public admin_agent(int ID,String Afname, String Alastname, String Ausername,String Amail,String Acontact,String Aaddress,String Atype)
    {
        this.id=ID;
        this.afname=Afname;
        this.alname = Alastname;
        this.ausername=Ausername;
        this.aemail=Amail;
        this.acontact=Acontact;
        this.aaddress=Aaddress;
        this.type=Atype;
      
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
 public String getAusername()
    {
        return ausername;
    }
    public String getAmail()
    {
        return aemail;
    }
     public String getAcontact()
    {
        return acontact;
    }
     public String getAaddress()
    {
        return aaddress;
    }
    public String getAtype()
    {
        return type;
    }
}
