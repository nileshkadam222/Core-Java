
import java.awt.*;
class disha34 extends Frame implements Runnable
{
  Thread th1=new Thread(this);
  Thread th2=new Thread(this);
  Panel p=new Panel();
  TextField t1=new TextField(10);
  TextField t2=new TextField(10);
  disha34()
  {
    setSize(300,300);
    p.add(t1);
    p.add(t2);
    add(p);
    th1.start();
    th2.start();
  }
  public void run()
{
  for(int i=1;i<=50;i++)
  {
    try
    {
	if(Thread.currentThread().equals(th1))
	{
	  t1.setText("i="+i);
	  Thread.sleep(100);
          p.setBackground(Color.red);
  	}
        if(Thread.currentThread().equals(th2))
	{
	  t2.setText("i="+i);
	  Thread.sleep(100);
          p.setBackground(Color.blue);
  	}
     }
    catch(Exception e)
    {
       System.out.println("Error Encountered");
    }
  }
}

public static void main(String ar[])
{
   disha34 d=new disha34();
   d.setVisible(true);
}
}

