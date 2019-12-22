 class NewThread extends Thread
{
	NewThread()
	{
	super("demo thread");
	System.out.println("Child thread : "+this);
	start();
	}

	public void run()
	{	
		try
		{
			for(int i=5;i>0;i--)
			{
			System.out.println("child thread: "+i);
			Thread.sleep(500);	
			}
		}
		catch(InterruptedException e)
		{
		System.out.println("child interrupted.");
		}
	System.out.println("Exiting child thread.");
	}
}


class Thread3
{
public static void main(String args[])
	{
	new NewThread();
	try
	{
	for(int i=5;i>0;i--)
	{
	System.out.println("main thread:"+i);
	Thread.sleep(1000);
	}
}
	catch(InterruptedException e)
	{
	System.out.println("Main thread interruped:");
	}	
	System.out.println("Main thread exiting:");
	}
}
