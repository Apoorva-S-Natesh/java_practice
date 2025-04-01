class RaceCondition
{
	//public synchronized final static void main(String[] args) //is a valid syntax
	public static void main(String[] args)
	{
		CheckupTask task = new CheckupTask();

		Thread t1 = new Thread(task);
		t1.setName("superman");

		Thread t2 = new Thread(task);
		t2.setName("batman");

		t1.start();	
		t2.start();
	}
}

//we need multiple threads to do same task
class CheckupTask implements Runnable 
{
	//public void run() without synchronized keywords, threads enter a race condition
	//synchronized public void run()
	public void run()
	{
		String tname = Thread.currentThread().getName();
/*
		try
		{
			System.out.println(tname + " has entered doctor's chamber");
			Thread.sleep(2000);
			System.out.println(tname + " is undergoding checkup");
			Thread.sleep(2000);
			System.out.println(tname + " has exited doctor's chamber");
			Thread.sleep(2000);
*/
		try{
		//select movies
			for(int i = 1; i <= 3; i++)
			{
				System.out.println(tname + " is selecting the movies");
				Thread.sleep(500);
			}
		//select seats - locking  the seat selection - now the mehtod is not synchronized, only this block is synchronized
		synchronized(this)
		{
			for(int i = 1; i <= 2; i++)
			{
				System.out.println(tname + " is selecting the seats");
				Thread.sleep(500);
			}
		}
			//make payments
			for(int i = 1; i <= 2; i++)
			{
				System.out.println(tname + " is making payments");
				Thread.sleep(500);
			}
		} catch(Exception e)
		{
			System.out.println("some exception occured");
		}
	}
}

/*
Race condition - When multiple tasks(threads) try to access and change shared data at the same time
synchronized keyword ensures that only one thread can access a block of code at a time 

atomic variable like AtomicInteger handle synchronization, ensuring thread-safe operations without requiring explicit locking

By default main thread has a priority of 5(NORM_PRIORITY)
*/