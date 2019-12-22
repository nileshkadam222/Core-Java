import java.util.*;
import java.io.*; 
class vec 
{ 
    public static void main(String args[])throws IOException
   {
      Vector<Integer> v = new Vector<Integer>(5, 2); 
      int i,w;
      //String w=" ";
     BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
     System.out.println("Initial size: " + v.size());  
     
    System.out.println("Initial capacity: " +v.capacity()); 
   System.out.println("Type 9 to stop loop");
    
    for(i=0;i<=v.size();i++)
    {
         w=Integer.parseInt(in.readLine());
         
             if(w==9)
             {
                   break;
             }
             else
              {
                    v.add(w);
              }
    }
   System.out.println("The elements are");
   for(i=0;i<=v.size();i++) 
   {
       System.out.print(v.get(i));
       System.out.println();
   }
 }
}
   
   