public class MultiThreadedTask 
{
	public static void main(String[] args) throws InterruptedException
	{
		System.out.println(Thread.currentThread().getName()); //main thread
		TypeThread type = new TypeThread();
		type.setName("type-thread"); //setting the name of the thread
		ErrorCheckThread echeck = new ErrorCheckThread();
		echeck.setName("error check-thread");
		SavingThread save = new SavingThread();
		save.setName("save-thread");

		type.start(); //only once tis started the Thread Scheduler can allocate time for it
		echeck.start();
		save.start();
	}
}

class TypeThread extends Thread
{
   	 @Override 
      	public void run()
	{
		System.out.println(Thread.currentThread().getName());
		for (int i = 1; i<= 5;i++)
		{
			System.out.println("typing...");
			try {
				Thread.sleep(1000); // sleep() throws an InturrptedException
			} catch (InterruptedException e) {
				e.printStackTrace();
			} //Overridden methods can throw Exceptions, so long as the method being overridden also throws the same Exceptions. You can't introduce new Exceptions. So use try catch
		}
			
	}
}

class ErrorCheckThread extends Thread
{
   	 @Override 
      	public void run()
	{
		System.out.println(Thread.currentThread().getName());
		for (int i = 1; i<= 5;i++)
		{
			System.out.println("error-checking....");
			try {
				Thread.sleep(1000); // sleep() throws an InturrptedException
			} catch (InterruptedException e) {
				e.printStackTrace();
			} //Overridden methods can throw Exceptions, so long as the method being overridden also throws the same Exceptions. You can't introduce new Exceptions. So use try catch
		}
			
	}
}

class SavingThread extends Thread
{
   	 @Override 
      	public void run()
	{
		System.out.println(Thread.currentThread().getName());
		for (int i = 1; i<= 5;i++)
		{
			System.out.println("saving....");
			try {
				Thread.sleep(1000); // sleep() throws an InturrptedException
			} catch (InterruptedException e) {
				e.printStackTrace();
			} //Overridden methods can throw Exceptions, so long as the method being overridden also throws the same Exceptions. You can't introduce new Exceptions. So use try catch
		}
			
	}
}			
