class ThrowsDemo{
   static void throwOne() throws IllegalAccessException{
   	System.out.println("Inside throwOne");
	throw new IllegalAccessException("Java Demo");
                     }
	public static void main(String args[]){
                  try{
      	      throwOne();
                         }catch(IllegalAccessException e)
                        {
                           System.out.println("The Exception caught;" +e);
                          }
            }
}