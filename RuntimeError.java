import java.util.ArrayList;

class RuntimeError
{
	public static void fun()
	{
		System.out.println("fun() is executing");
		//Need to have a base case for recuresive methods to avoid StackOverflowError.
		try{
		fun(); //Causing Recursion
		}catch (StackOverflowError e) {
			System.out.println("Stack Overflow Error caught.");
			exit;
		}
		
		try
		{
			ArrayList<int[]> list = new ArrayList<>();
			for (int i = 0; i < 1000; i++)
			{
				list.add(new int[1000000]); //will throw OutOfMemoryError, so needs to be caught
			}
		} catch(OutOfMemoryError e) {
			System.out.println("Ran Out of memory. Try optimizing your  code to use less memory");
		}

	}

	public static void main(String[] args)
	{
		fun(); // Will throw a StackOverflowError
	}
}

/* Runtime errors occuer when program is running like OutOfMemoryError, StackOverflowError
Throable is parent class of Error class and Exception class*/