import java.util.Vector;     
class vector5
{
      public static void main(String []args)
     {
         Vector<String> v1=new Vector<String>(10,2); 
        String e1="Element1";
        String e2="Element2";
      int number;
        v1.add(e1);
        v1.add(e2);
       number=v1.size();
         System.out.println("The Number of elements are :"+number);         
      }
}