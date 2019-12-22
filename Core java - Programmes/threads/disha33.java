class disha33 implements Runnable
{
  Thread t1=new Thread(this);
  Thread t2=new Thread(this);
  disha33()
  {
     t1.start();
     t2.start();
  }

public void run()
{
  if(Thread.currentThread().equals(t1))
  {
    for(int i=1; i<=10;i++)
    {
      try
	{
	  Thread.sleep(500);
	   System.out.println("ABC");
        }
      catch(Exception e)
        {
	   System.out.println("Error Encountered");
	}
     }
   }
   if(Thread.currentThread().equals(t2))
  {
    for(int i=1; i<=10;i++)
    {
      try
	{
	  Thread.sleep(100);
	   System.out.println("dEF");
        }
      catch(Exception e)
        {
	   System.out.println("Error Encountered");
	}
     }
   }
}

public static void main(String ar[])
{
   disha33 d=new disha33();
 }
}
  