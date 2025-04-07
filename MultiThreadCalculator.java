import java.util.Scanner;

class MultiThreadCalculator {
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();

		Calculator calc = new Calculator(n);
		FactorialThread factThread = new FactorialThread(calc);	
		FibonacciThread fiboThread = new FibonacciThread(calc);

		factThread.start();
		fiboThread.start();
	}	
}

class Calculator
{
	boolean status = false; // If factorial is calculated or not
	int fact= 1; // Stored factorial of the given number
	int n;

	public Calculator(int n)
	{
		this.n = n;
	}

	public synchronized void findFactorial(int n)
	{
		for (int i = n; i >=2; i--)
			fact *= i;
		
		System.out.println("Factorial of " +n+ ": is " +fact);
		status = true;
		notify();
	}
	
	public synchronized void printFibonacci() throws InterruptedException
	{
		if (status == false)
			wait();
		else
		{
			int n1 = 0, n2 = 1;
			while (n1 <= fact)
			{
				System.out.print(n1 + " " );
				int sum = n1 + n2;
				n1 = n2;
				n2 = sum;
			}
		}
	}	
}

class FactorialThread extends Thread
{
	Calculator cal;
	public FactorialThread(Calculator cal)
	{
		this.cal = cal;
	}
	public void run()
	{
		cal.findFactorial(cal.n);
	}
}

class FibonacciThread extends Thread
{
	Calculator cal;
	public FibonacciThread(Calculator cal)
	{
		this.cal = cal;
	}
	public void run()
	{
		try{
			cal.printFibonacci();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}


/*
Example Output

6
Factorial of 6: is 720
0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610

*/
