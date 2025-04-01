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

/*
States of threads - thread lifecycle
1. New - the thread is created but hasn't started working yet, this is where we set the name 
	Thread thread = new Thread(new MyRunnabe());
2. Runnable - the thread is ready to run and waiting for its turn
	thread.start();
Running - Thread scheduler allots CPU time, thread is running now
3. Blocked - the thread is waiting to use a resource that's currently in use
4. Waiting - the thread is waiting for another thread to perform an action
	synchronized (lock) {
		lock.wait();
		//The thread is now in the waiting state
		}
	The thread waits until another thread calls notify() or notifyAll()
5. Timed Waiting - the thread is waiting for a specific amount of time.
	Thread.sleep(15000);

		or 
	synchronized (lock) {
		lock.wait(5000);
		//thread waits for either notification or 5 seconds
	}
 	thread cannot go to the running directly, once the sleep time is over the thread has to go to the runnable state and when TS allots CPU time, then it can run
6. Terminated or dead - the thread has finished its task
from any state can call interrupt(), thread goes to dead state 
*/
