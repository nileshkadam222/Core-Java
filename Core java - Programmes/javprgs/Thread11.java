class NewThread implements Runnable
{
String name;
Thread t;
boolean suspendFlag;

NewThread(String threadname)
{
name=threadname;
t=new Thread(this,name);
System.out.println("new thread:"+t);
suspendFlag=false;
t.start();
}

public void run()
{
try
{
for(int i=15;i>0;i--)
{
System.out.println(name + " : "+i);
Thread.sleep(200);
synchronized(this)
{
while(suspendFlag)
{
wait();
}
}
}
}
catch(InterruptedException e)
{
System.out.println(name +" interrupted");
}
System.out.println(name+ " exiting");
}

void mysuspend()
{
suspendFlag=true;
}

synchronized void myresume()
{
suspendFlag=false;
notify();
}
}

class Thread11
{
public static void main(String args[])
{
NewThread ob1=new NewThread("one");
NewThread ob2=new NewThread("two");

try
{
Thread.sleep(1000);
ob1.mysuspend();
System.out.println("Suspending thread one");
Thread.sleep(1000);
ob1.myresume();
System.out.println("resume thread one");
ob2.mysuspend();
System.out.println("Suspending thread two");
Thread.sleep(1000);

ob2.myresume();
System.out.println("resume thread two");
}
catch(InterruptedException e)
{
System.out.println("main thread interrupted");
}
System.out.println("main thread exiting");
}
}
