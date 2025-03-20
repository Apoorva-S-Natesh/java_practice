import java.util.Scanner;

class ExceptionHandling {
	public static void main(String[] args)
	{
		Scanner sc =new Scanner(System.in);
		try
		{
			System.out.println("enter 2 numbers");
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			System.out.println("Division is starting");
			int result = n1 /n2;
			System.out.println("The quotient is: "+ result);
			/*Exception in thread "main" java.lang.ArithmeticException: / by zero
        at ExceptionHandling.main(ExceptionHandling.java:9)*/
		}
		catch(Exception ex) //Exception object
		{
			System.out.println("Exception : Cannot divide by 0");
			System.out.println("Exception was handled");
			ex.printStackTrace();		
		}
		System.out.println("division is ending");
		finally 
		{
		System.out.println("Other Operations");
		exceptionExamples();
		}
	}

	public static void exceptionExamples()
	{
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt(); //give a string as input -java.util.InputMismatchException

		//int [] n = {1, 2, 3};
		//System.out.println(n[3]); //ArrayIndexOutOfBoundsException
		
		//int [] n1 =new int[-1]; // java.lang.NegativeArraySizeException: -1
	}
}

/*Program is terminated normally and all the flow of the program is maintained - to handle run itme errors exception handling is required*/

/*When to Expect Exceptions?
1.User Input: anytime users provide input, validate it
2.File Handling: Reading from or writing to files, that doesnt exists
3.Network REquests:when dealing with netwrok reuqests
4.Data casting:downcasting or parsing data, incorrect assumptions
5.NullPointerException: When accessing a null reference
6.ArrayIndexOutOfBoundsException: occurs when trying to access an invalid index
7.ArithmeticException: Results from illegal math operations like division by zero
8.ClassCastException: when casting an object to an incompatible type
9.NumberFormatException: when converting invalid string into numbers
*/

/*
final is used to create constants and prevent method overriding or class inheritance, finally is a block that executes after try-catch for guaranteed execution, typically for cleanup. finalize is a method called before an object's garbage collection, used for final resource release tasks.
*/