import java.util.Vector;     
class vector4
{
      public static void main(String []args)
     {
         Vector<String> v1=new Vector<String>(10,2); 
        String e1="Element1";
        String e2="Element2";
        String holder;
        v1.add(e1);
        v1.add(e2);
        holder=v1.toString();
        System.out.println("Value is:"+holder);
      
    }
}