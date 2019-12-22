class myexception extends Exception{
 private int details;

myexception(int a){
detail=a;
}

public String toString(){
return "myexception["+ detail +"]";
}
}

class userexcep{
static void compute(int a) throws myexception {
System.out.println("called comput (" +a+ ")");
if(a>10)
throws new myexception(a);
System.out.println("normal exit");
}

public static void main(String args[]){
try{
compute(1);
 compute(20);
}
catch (myexception e){
System.out.println("caught  "+ e);
}
}
}