import java.io.*;
class test10 implements Runnable
{
  Thread t1=new Thread(this);
  Thread t2=new Thread(this);
  test10()
  {
    t1.start();
    t2.start();
  }
 public void run()
 {
   if(Thread.currentThread.equals(t1));
  {
    for(int i=1;i<=10;i++)
    {
       try
       {
          Thread.sleep(1000);
          System.out.println("Silford");
      }
     catch(Exception e)
     {
         System.out.println("There is some error in code");
     }
   }
  if(Thread.currentThread.equals(t2));
  {
     for(int i=1;i<=10;i++)
    {
      try
     {
       Thread.sleep(3000);
        System.out.println("Braganza");
     }
     catch (Exception e)
    { System.out.println("There is some error in the code");
    }
  }
 }
}
public static void main(String ar[]) throws Exception
{
  test10 t=new test10();
  }
}
   