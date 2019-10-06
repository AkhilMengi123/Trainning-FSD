import java.util.Scanner;
class Table{
	public static void main(String[] args) {
		int number,limit,num;
		 	Scanner scan=new Scanner(System.in);
		 	System.out.println("Enter the Number");
		       number=scan.nextInt();
		       System.out.println("Enter the limit");
		        limit=scan.nextInt();
		          for ( num= 1; num <= limit; num++)
      System.out.println(number + "*" + num + " = " + (number*num));
	}
} 