import java.util.Scanner;

class BinaryNumber {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int number, tmp, singleNumber;
		String binaryNumber = "";

		System.out.println("Enter the number to convert to Binary: ");
		number = scan.nextInt();

		tmp = number;
		System.out.println("Binary number for entered number is: ");
		while(tmp > 0)
        {
            singleNumber = tmp % 2;
            binaryNumber = "" + singleNumber + "" + binaryNumber;
            tmp = tmp / 2;
        }
        System.out.println(binaryNumber);
	}
}