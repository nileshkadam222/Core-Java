class jae
{
public static void main(String arg[])
{
int a=5,b=0,c=0;
try{
c=a/b;
}
catch( Exception e)
{
System.out.println(e);
System.out.println(e.getMessage());
System.out.println(" u cannot divide by zero");
}
}
}