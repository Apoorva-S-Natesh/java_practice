import java.util.Scanner;
import java.util.*;

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
		catch(ArithmeticException ae) //Exception object
		{
			System.out.println("Exception : Cannot divide by 0");
			System.out.println("Exception was handled");
			ae.printStackTrace();		
		}
		catch(InputMismatchException ime)
		{
			System.out.println("Exception: Oops you need to enter an integer");
			System.out.println("Exception was handled");
			ime.printStackTrace();	
		}

		/* One generic catch block but using the instance of different exception classes
		catch (Exception ex)
		{
			if ( ex instanceOf ArithmeticException)
				System.out.println("Exception : Cannot divide by 0");
			else if (ex instanceOf InputMismatchException)
				System.out.println("Exception: Oops you need to enter an integer");
    			else
       				System.out.println("Some exception  occured");
		}
		*/
			
		catch(Exception ex){ //for some new exception, to make the code safe,one catch block to handle all the other exceptions
			System.out.println("Some exception  occured");
			System.out.println("Exception was handled");
			ex.printStackTrace();
		} finally 
		{
			System.out.println("division is ending");
			System.out.println("Other Operations");
			exceptionExamples();
		}
	}

	public static void exceptionExamples()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number");
		try{
			int num1 = sc.nextInt(); //give a string as input -java.util.InputMismatchException
		} catch (InputMismatchException ex) {
			System.out.println("Enter an integer");
			ex.printStackTrace();
		}

		int [] n = {1, 2, 3};
		System.out.println("Array is  " +Arrays.toString(n)+" you are trying to access index 3");
		try
		{
			System.out.println(n[3]); //ArrayIndexOutOfBoundsException
		} catch (ArrayIndexOutOfBoundsException ex){
			System.out.println("Check the index you are trying to accesss");
			ex.printStackTrace();
		}
		
		try
		{	
			int [] n1 =new int[-1]; // java.lang.NegativeArraySizeException: -1
		} catch(NegativeArraySizeException ex) {
			System.out.println("Check array size! array size cannot be negative");
			ex.printStackTrace();
		}
		
	}
}

class NestedTry {
	
	public static void main(String args[])
	{
		// Main try block
      		 try {
            			// initializing array
            			int a[] = { 1, 2, 3, 4, 5 };

           			// trying to print element at index 5
            			System.out.println(a[5]);

            			// try-block2 inside another try block
            			try {

               				 // performing division by zero
                				int x = a[2] / 0;
           			 }
            			catch (ArithmeticException e2) {
                				System.out.println("division by zero is not possible");
            			}
        		}
        		catch (ArrayIndexOutOfBoundsException e1) 
		{
           			System.out.println("ArrayIndexOutOfBoundsException");
            			System.out.println("Element at such index does not exists");
        		}
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
