import java.util.Scanner;
class NonRecursivefibonacciDemo {
	public static void main(String args[ ]) {
		Scanner input=new Scanner(System.in);
		int i, a=1, b=1, c=0, num;
		System.out.println("Enter value of num:");
		num = input.nextInt();
		System.out.print(a);
		System.out.print(" "+b);
		for(i=0; i < num-2; i++) {
			c = a+b;
			a = b;
			b = c;
			System.out.print(" "+c);
		}
		System.out.println();
		System.out.print(num +"th value of the series is: " +c);
	}
}/*






























 Recursive Solution
import java.io.*;
import java.lang.*;
class Demo {
	int fib(int n) {
		if(n==1)
			return (1);
		else if(n==2)
			return (1);
		else
			return (fib(n-1)+fib(n-2));
	}
}
class RecFibDemo {
	public static void main(String args[])throws IOException {
		InputStreamReader obj=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(obj);
		System.out.println("enter last number");
		int n=Integer.parseInt(br.readLine());
		Demo ob=new Demo();
		System.out.println("fibonacci series is as follows");
		int res=0;
		for(int i=1;i<=n;i++) {
			res=ob.fib(i);
			System.out.println(" "+res);
		}
		System.out.println();
		System.out.println(n+"th value of the series is "+res);
	}
}*/