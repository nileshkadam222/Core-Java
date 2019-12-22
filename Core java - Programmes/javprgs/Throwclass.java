
class Throwclass
{
static void throwmethod()throws ClassNotFoundException
{
System.out.println("In throwMethod");
throw new ClassNotFoundException();
}
public static void main(String args[])
{
try
{
throwmethod();
}
catch(ClassNotFoundException Obja)
{
System.out.println("throwMethod has thrown an exception:"+Obja);
}
}
}