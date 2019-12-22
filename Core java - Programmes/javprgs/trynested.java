class trynested{
public staticvoid main(String args[])
{
try{
int a=args.length;
int b= 42/a;

System.out.println("a=  "+a);

      try{
           if(a==1) 
               a=a/(a-a);

           if(a==2){
                 int c[] ={1};
                 c[42] = 99;
  }
}
   catch(ArrayindexOutOfBoundException e)
{
System.out.prinln("array index out of bound "+ e);
}

} catch(ArithmeticException e){
System.out.println("divide by 0 : "+e);
}
}
}