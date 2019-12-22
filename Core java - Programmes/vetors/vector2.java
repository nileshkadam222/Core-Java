import java.util.Vector;     
class vector2
{
      public static void main(String []args)
     {
         Vector<String> v1=new Vector<String>(10,2); 
         String sample="tester";          
         v1.add(sample);         
       System.out.println("Value is :"+v1.get(0));    
        v1.remove(0);  
        System.out.println("Value is :"+v1.get(0));     
    }
}