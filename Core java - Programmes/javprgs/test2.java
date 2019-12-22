class test
{
 void show()
  {
    System.out.println("Deepa");
  }
 void show(int x)
 {
   System.out.println(x);
 }
}
class test2
{
  public static void main(String ar[]) throws Exception
 {
  test t=new test();
  t.show(100);
  t.show();
 }
}