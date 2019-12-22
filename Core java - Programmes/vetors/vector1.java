import java.util.Vector;     
class vector1
{
      public static void main(String []args)
     {
         Vector<String> v1=new Vector<String>(10,2); 
         String sample="tester";          
         v1.add(sample);         
       System.out.println("Value is :"+v1.get(0));      
    }
}