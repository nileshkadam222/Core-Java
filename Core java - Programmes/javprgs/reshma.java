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
int c=20;
void print()
{
System.out.println("print called");
}
}
class D extends A
{
public static void main(String ar[])
{
D r=new D();
r.show();
C n=new C();
n.print();
B s=new B();
s.disp();
}
} 