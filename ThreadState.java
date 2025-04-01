public class ThreadState {
	public static void main(String[] args)
	{
		Mythread mt = new Mythread();
		mt.start();
	}
}

class Mythread extends Thread
{
	public void run()
	{
		for (int i=1; i <= 10; i++)
		{
			if (i == 5)
				Thread.currentThread().interrupt();
			if (Thread.interrupted())
				return;
			System.out.println("Executed task : " +i);
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
*/