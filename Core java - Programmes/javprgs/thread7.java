class clicker implements Runnable
{
   int click=0;
   Thread t;
   private volatile boolean running=true;
public clicker(int p)
{
  t=new Thread(this);
  t.setPriority(p);
 
}
public void run()
{
   while(running)
   {
      click++;
      System.out.println("click: " + click);
   }
}
public void stop()
{
   running=false;
}
public void start()
{
  t.start();
}
}
class thread7
{
   public static void main(String args[])
   {
      Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
      clicker hi=new clicker(Thread.NORM_PRIORITY +2);
      clicker low=new clicker(Thread.NORM_PRIORITY - 2);      
      low.start();
       hi.start();
   try{
     Thread.sleep(10000);
}
catch(InterruptedException e)
{
  System.out.println("main thread interrupted:");
}
low.stop();
hi.stop();
try
{
  hi.t.join();
  low.t.join();
}
catch(InterruptedException e)
{
  System.out.println("interruptedException caught");
}
 System.out.println("low priority thread"+ " "+ low.click);

 System.out.println("high priority thread:" + " " + hi.click);
}
}