class RunnableY implements Runnable{
    public void run(){
    try{
      while(true){
      Thread.sleep(1000);
      System.out.println("Hello Java");
     }
}
  catch(InterruptedException ex){
    ex.printStackTrace();
     }
  }
}

class ThreadingDemo{
      public static void main(String args[]){
      RunnableY ry = new RunnableY();
      Thread t = new Thread(ry);
      t.start();
    }
}

