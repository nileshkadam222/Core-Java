 //deadlock threads
public class Thread8
{
   String o1="lock";
   String o2="step";
   Thread t1=(new Thread("printer1")
   {
      public void run()
      {
          while(true)
          {
             synchronized(o1){ 
               synchronized(o2){
               System.out.println(o1+o2);
       }
}
}
}
});
Thread t2=(new Thread("printer2")
{
  public void run()
  {
     while(true)
     {
        synchronized(o2)
        {
           synchronized(o1){
              System.out.println(o2+o1);
           }
}
}
}
});
public static void main(String args[])
{
  //deadlockdanger d=new deadlockdanger();
  Thread8 d=new Thread8();
 d.t1.start();
  d.t2.start();
}
}

