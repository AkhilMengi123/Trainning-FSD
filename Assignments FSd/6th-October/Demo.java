import java.io.IOException;
class InvalidNameException extends Exception
{
    public InvalidNameException(String s)
    {
        
        super(s);
    }
}
 
 class Demo
{
   void nameCheck(String firstName, String secondName) throws InvalidNameException{
	if(firstName == " " || secondName == " "){
		throw new InvalidNameException(" Invalid");
	}
    else 
    {
        System.out.println("Valid");
    }
   }
   
    public static void main(String args[])
    {
    	Demo obj = new Demo();
        try
        {
            obj.nameCheck(" ","Mengi");
        }
        catch (InvalidNameException ex)
        {
            System.out.println("Caught the exception");
            System.out.println(ex.getMessage());
        }
    }
}