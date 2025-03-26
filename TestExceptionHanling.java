import java.util.*;

public class TestExceptionHandling {
	public static void main(String[] args)
	{
		System.out.println("main started");
		alpha();
		System.out.println("main ended");
	}
	
	private static void alpha()
	{
		System.out.println("alpha started");
		try {
			beta();
		} catch(Exception e) {
 			System.out.println("alpha handled exception");
		}
		System.out.println("alpha ended");
	}
	
	protected static void beta() throws Exception
	{	
		System.out.println("beta started");
		gama();
		System.out.println("beta ended");
	}
	
	static void gama()
	{
		System.out.println("gama started");
		int arr[] = new int[-5];
		try {
			
		} catch(Exception ex) {
 			System.out.println("catch of gama");
		} finally { //not for the exception, ontrol not coming to try block only since the line where exception occurs is not inside try block
		System.out.println("gama ended");
		}
	}
}

/*Accesss modifiers in the same class will not make any difference for the exception*/