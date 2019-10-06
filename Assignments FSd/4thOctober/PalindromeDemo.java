

import java.util.Scanner;
 
class PalindromeDemo
{
   public static void main(String args[])
   {
      String str, rev = "";
      Scanner scan = new Scanner(System.in);
 
      System.out.println("Enter a string:");
      str = scan.nextLine();
 
      int length = str.length();
     // System.out.println("length of string" +str.length());
 for ( int num = length - 1; num >= 0; num-- )
         rev = rev + str.charAt(num);
 
      if (str.equals(rev))
         System.out.println(str+" is a palindrome");
      else
         System.out.println(str+" is not a palindrome");
      
 
   }
}