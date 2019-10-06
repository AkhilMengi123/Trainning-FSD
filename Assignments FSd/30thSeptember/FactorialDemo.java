import java.util.Scanner;
class FactorialDemo{
	public static void main(String[] args) {
		int number;
		Scanner scan=new Scanner(System.in);

		System.out.println("Enter the Number");
		number=scan.nextInt();
         
         int factorial = 1;
        for(int var = 1; var <= number; var++)
        {
            
            factorial = factorial*var;
        }
        System.out.println("Factorial number"+ factorial);
    }    
  }    

