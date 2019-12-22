//yield() helps in notifying the system that the current thread is willing to giveup the cpu time //for a while.

class worker implements Runnable 
{
  private Thread thethread;
  public void kickstart()
  {
     if(thethread==null)
     {
           thethread=new Thread(this);
           thethread.start();
      }
}
public void terminate()
{
  thethread=null;
}
  public void run()
  {  
    while(thethread==Thread.currentThread())
    {
      System.out.println("going around in loops:");
   }
}
}
public class thread5
{
   public static void main(String args[])
   {
      worker w=new worker();
      w.kickstart();
     Thread.yield();
      //w.terminate();
   }
}
