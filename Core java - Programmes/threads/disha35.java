import java.awt.*;
class disha35 extends Frame
{
   static int r=20;
  Thread th1;
  disha35()
   {
      setSize(300,300);

      hand h=new hand();
      th1=new Thread(h);
      th1.start();
   }
  class hand extends Thread
{
   public void run()
   {
       for(int i=0;i<=20;i++)
       repaint();
   }
}

public void paint(Graphics g)
{
     for(int i=10;i<=30;i++)
{
     g.drawRect(20+i,200,100+i,100);
    try
    {
        Thread.sleep(1000);
    }
    catch(Exception e)
    {
        System.out.println("There is some error");
     }
}
}

public static void main(String ar[])
{
   disha35 d=new disha35();
   d.setVisible(true);
}
}