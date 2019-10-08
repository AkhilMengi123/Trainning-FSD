import java.io.IOException;
class InvalidAgeException extends Exception
{
    public InvalidAgeException(String s)
    {
        
        super(s);
    }
}
 
 class AgeException
{
   void ageCheck(int age) throws InvalidAgeException{
	if(age < 15){
		throw new InvalidAgeException(" Invalid");
	}
    else 
    {
        System.out.println("Valid");
    }
   }
   
    public static void main(String args[])
    {
    	AgeException obj = new AgeException();
        try
        {
            obj.ageCheck(13);
        }
        catch (InvalidAgeException ex)
        {
            System.out.println("Caught the exception");
            System.out.println(ex.getMessage());
        }
    }
}