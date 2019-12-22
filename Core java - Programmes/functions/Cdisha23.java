// inheritance:
//multi level

class A
{
int a=90;
public void show()
{
System.out.println("A class");
}
}



class B extends A
{
int b=90;
public void disp()
{
System.out.println("B class and add="+(a+b));
}
}


class C extends B
{
public void prt()
{
System.out.println("C class");
}


public static void main(String ar[])
{
C t=new C();

t.show();
t.disp();
t.prt();
}
}
