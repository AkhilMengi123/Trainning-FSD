import java.util.Scanner;

class AddDemo {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter Three Numbers:");
		int number1 = scan.nextInt();
		int number2 = scan.nextInt();
		int number3 = scan.nextInt();
		boolean flag = true;

		if (number1 < 40) flag = false;
		if (number2 < 40) flag = false;
		if (number3 < 40) flag = false;
		if (number1 + number2 + number3 < 125) flag = false;
			
		if (flag) System.out.println("Passing");
		if (!flag) System.out.println("Failing");
	}
}