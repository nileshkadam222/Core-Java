/*Exception Handling:
class tst
{
public static void main(String ar[])
{
int a=10,b=0,c=0;
try{
c=a/b;
System.out.println("c="+c);

   }
catch(Exception e)
{
System.out.println("cannot divide by 0");
System.out.println(e.getMessage());
}
}
}
*/

class tst
{
public static void main(String ar[])
{
int[] a={10,50};
try{
//System.out.println("value="+a[2]);

   }
catch(Exception e)
{
System.out.println("array index error");
System.out.println(e);
}
finally
{
System.out.println("page end");
}
}
}