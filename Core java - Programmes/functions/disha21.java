 class A
{
int a=90;
void show()
{
System.out.println("Reshma");
}
}


class B extends A
{
int b=70;
void disp()
{
System.out.println(a+b);
}
}


class C extends A
{
void print()
{
System.out.println("print called");
}
}


class disha21 extends A
{
public static void main(String ar[])
{
disha21 r=new disha21();
r.show();
C n=new C();
n.print();
B s=new B();
s.disp();
}
} 
