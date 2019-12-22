class newthread implements Runnable
{
       String name;
       Thread t;
       newthread(String threadname)
       {
           name = threadname;
           t=new Thread(this,name);
            System.out.println("new thread: " + t);
           t.start();
       }
      public void run()
      {
               try{
                     for(int i=5;i >0; i--)
                     {
                               System.out.println(name + ": " + i);
                                Thread.sleep(1000);
                     }
             }
             catch(InterruptedException e)
             {
                          System.out.println(name + "Interrupted");  
            }
              System.out.println(name  + "exciting");
      }
}
class thread4
{
     public static void main(String args[])
     {
           new newthread("one:");
           new newthread("two:");
           new newthread("three:");   
           try{
             Thread.sleep(10000);
           }
           catch(InterruptedException e)
           {
                   System.out.println("main thread interrupted");
            }
                           System.out.println("main thread exiting:");
      }
}

                     
                                             
  