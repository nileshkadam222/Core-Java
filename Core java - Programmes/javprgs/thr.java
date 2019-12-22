import java.awt.*;
class thr extends Frame implements Runnable
{
   Thread th1, th2;
   TextField t1, t2;
   Panel p;
   thr()
   {
      setSize(300,300);
     p=new Panel();
     t1=new TextField(10);
     t2=new TextField(10);
     th1=new Thread(this);
     th2=new Thread(this);
     p.add(t1);
     p.add(t2);
     add(p);
     th1.start();
     th2.start();
   }
   public void run()
   {
     for(int i=1; i<=50; i++)
     {
       try
       {
          if(Thread.currentThread().equals(th1))
          {
	t1.setText("i=" +i);
	Thread.sleep(100);
	p.setBackground(Color.red);
          }
         if(Thread.currentThread().equals(th2))
         {
	t2.setText("i=" +i);
                Thread.sleep(200);
	p.setBackground(Color.blue);
         }
      }
     catch(Exception e) {}
}
}
public static void main(String ar[])
{
   thr t=new thr();
   t.setVisible(true);
}
}     