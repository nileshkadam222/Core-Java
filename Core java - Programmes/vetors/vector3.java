import java.util.Vector;     
class vector3
{
      public static void main(String []args)
     {
         Vector<String> v1=new Vector<String>(10,2); 
         String sample="tester";    
        String holder;       
         v1.add(sample);  
       holder=v1.elementAt(0);       
       System.out.println("Value is :"+holder);    
        v1.remove(0);  
      
    }
}