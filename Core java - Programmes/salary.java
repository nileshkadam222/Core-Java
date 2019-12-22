import java.io.*;
class salary
{
 public static  void main(String arg[])throws IOException
 {
  int a,b,c,d;
  BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
System.out.println("ENTER YOUR SALARY");
a=Integer.parseInt(in.readLine());
if(a<10000)
{
  b=a/10;
  System.out.println("comission is ="+b);
 }

else

   {
     if(a>10000 && a<30000)
       {
         c=a/25;
         System.out.println("the comission is = " +c);
        }
       else 
          {
            if(a>30000)
             {
              d=a/30;
              System.out.println("the comission is =" +d);
             }
            } 
        }
}
}
}