 class FibonacciDemo {
	public static void main(String[] args) {
		int firstNumber = 0;
		int secondNumber = 1;
		int thirdNumber = 0;
		int limit = 89;
		System.out.println("Fibonacci Series from 1 to 89 is: ");
		while(thirdNumber != limit) {
			thirdNumber = firstNumber + secondNumber;
			firstNumber = secondNumber;
			secondNumber = thirdNumber;
			System.out.print(thirdNumber + " ");
		}
	}
}