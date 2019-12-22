class add
{
  int x=10, y=10;
 void show()
{
    System.out.println("The arthematic operations are as follows");
}
 void show1()
  {
    System.out.println("The sum of numbers is"+(x+y));
   }
}





class sub extends add
{
  void show2()
  {
     
     System.out.println("The substraction of numbers is"+(x-y));
  }
}


  
class mul extends add
  {
     void show3()
   {
      System.out.println("The product of numbers is"+(x*y));
   }
}



class div extends add
{
   void show4()
   {
      System.out.println("The division of numbers is"+(x/y));
   }
}




class arth extends add
{
   public static void main(String ar[])
   {
       arth a=new arth();
       a.show();
       add a1=new add();
       a1.show1();
       sub a2=new sub();
       a2.show2();
       mul a3=new mul();
      a3.show3();
      div a4=new div();
      a4.show4();
   }
}