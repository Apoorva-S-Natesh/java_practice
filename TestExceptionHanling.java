public class TestExceptionHandling1 {
	public static void main(String[] args)
	{
		System.out.println("main started");
		try{
		alpha();
		} catch (Exception e) {
			System.out.println("exception received by  main");
		}
		System.out.println("main ended");
	}
	
	private static void alpha() throws Exception
	{
		System.out.println("alpha started");
		try {
			beta();
		} catch(Exception e) {
 			System.out.println("alpha handled exception");
			throw e;
		}
		System.out.println("alpha ended");
	}
	
	protected static void beta() throws Exception
	{	
		System.out.println("beta started");
		gama();
		System.out.println("beta ended");
	} //beta ducking the exception
	
	static void gama()
	{
		System.out.println("gama started");
		try {
			int arr[] = new int[-5];
		} catch(Exception ex) {
 			System.out.println("catch of gama");
			//throw ex; 
		} finally { //not for the exception, ontrol not coming to try block only since the line where exception occurs is not inside try block
			System.out.println("gama ended");
		}
	} //gama not throwing the exception, only handling the exception
}


/*
Output:
main started
alpha started
beta started
gama started
catch of gama
gama ended
beta ended
alpha ended
main ended

alpha is not receiving any exception so catch of alpha and main will not be executed
if we had used throw ex in gama() then output will be
main started
alpha started
beta started
gama started
catch of gama
gama ended
alpha handled exception
exception received by  main
main ended

when we throw the exception from gama all the way to main, notice since "alpha ended is not inside a finally block, it will not be exceuted and alpha doesnt end.
*/
