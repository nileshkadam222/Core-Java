import java.util.Vector;     
class vec1
{
      public static void main(String []args)
     {
         Vector<Integer> v=new Vector<Integer>(10,2); 
         int i=5;
         System.out.println("Initial size: " + v.size()); 
         System.out.println("Initial capacity: " + v.capacity()); 
        v.addElement(new Integer(1)); 
        v.addElement(new Integer(2)); 
        v.addElement(new Integer(3)); 
        v.addElement(new Integer(4));
        
       System.out.println("Capacity after four additions: " + v.capacity());    
       System.out.println("First element: " + (Integer)v.firstElement()); 
       System.out.println("Last element: " + (Integer)v.lastElement());
       
       if(v.contains(new Integer(3))) 
        {
            System.out.println("Vector contains 3.");  
         }
    }
}