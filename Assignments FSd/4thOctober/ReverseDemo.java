 import java.util.Scanner;
class ReverseDemo
{
   public static void main(String args[])
   {
      String str, rev = "";
      Scanner scan = new Scanner(System.in);
 
      System.out.println("Enter a string:");
      str = scan.nextLine();
 
      int length = str.length();
      for ( int num = length - 1; num >= 0; num-- )
         rev = rev + str.charAt(num);
     System.out.println("Reverse of Stringis..."+" "+rev);
	}
}