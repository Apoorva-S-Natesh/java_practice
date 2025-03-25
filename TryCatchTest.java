public class TryCatchTest {
	public static void main(String[] args) 
	{
		try
		{
			int arr[] = new int[-3];
		}
		catch(Exception ex)
		{
			System.out.println("First catch block");
			try
			{
				int arr2[] = new int[-4];
			}
			//catch(Exception exc)
			//{
			//	System.out.println("Second catch block");
			//}
			finally
			{
				System.out.println("Finally of 2nd try");
			}
		}
		finally {
			System.out.println("Finally of the 1st try");
		}
	}
}

/*
Output:
First catch block
Finally of 2nd try
Finally of the 1st try
Exception in thread "main" java.lang.NegativeArraySizeException: -4
        at TryCatchTest.main(TryCatchTest.java:13)
*/