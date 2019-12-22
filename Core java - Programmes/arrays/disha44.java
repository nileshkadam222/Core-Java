import java.io.*;
class disha44
{
public static void main(String ar[])throws Exception
{
  int array[]={0,1,2,3,4,5,6,7,8,9};
  int i; 
  BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
  System.out.println("enter array elements");
  for(i=0;i<9;i++)
  {
        array[i]=Integer.parseInt(in.readLine());
   }
    System.out.println("Array elements are");
   for(i=0;i<9;i++)
  {
         System.out.println(array[i]*array[i]*array[i]);
   }
}
}