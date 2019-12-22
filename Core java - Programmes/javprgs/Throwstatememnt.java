class Throwstatememnt
{
static void throwdemo()
{
  try
  {
    throw new IllegalStateException();
  }
  catch(NullPointerException obja)
  {
    System.out.println("Not caught by catch block insidethrowdemo()");
  }
}

public static void main(String args[])
{
try
{
throwdemo();
}
catch(IllegalStateException objb)
{
System.out.println("Exception caught in:"+objb);
}
}
}