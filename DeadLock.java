class DeadLock 
{
	public static void main(String[] args)
	{
		ReadingTask task = new ReadingTask();
		Thread t1 = new Thread(task);
		t1.setName("batman");

		Thread t2 = new Thread(task);
		t2.setName("superman");

		t1.start();
		t2.start();
	}
}

class ReadingTask implements Runnable
{
	Library l = new Library();
	public void run()
	{
		String tname = Thread.currentThread().getName();
		try{
			if(tname.equals("batman"))
				l.batmanReads();
			else
				l.supermanReads();
		} catch (InterruptedException e) {
			System.out.println("Some exception occured");
			e.printStackTrace();
		}
	}
}

class Library
{
	String res1 = "Java book";
	String res2 = "sql book";
	String res3 = "React book";

/*
	public void batmanReads() throws InterruptedException
	{
		String tname = Thread.currentThread().getName();
		synchronized(res1) {
			//to show that someone is occupying this resource
			System.out.println(res1 + " is occupied by " +tname);
			Thread.sleep(3000);
		}
		synchronized(res2) {
			//to show that someone is occupying this resource
			System.out.println(res2 + " is occupied by " +tname);
			Thread.sleep(3000);
		}
		synchronized(res3) {
			//to show that someone is occupying this resource
			System.out.println(res3 + " is occupied by " +tname);
			Thread.sleep(3000);
		}
	}

	public void supermanReads() throws InterruptedException
	{
		String tname = Thread.currentThread().getName();
		synchronized(res1) {
			//to show that someone is occupying this resource
			System.out.println(res1 + " is occupied by  " +tname);
			Thread.sleep(3000);
		}
		synchronized(res2) {
			//to show that someone is occupying this resource
			System.out.println(res2 + " is occupied by  " +tname);
			Thread.sleep(3000);
		}
		synchronized(res3) {
			//to show that someone is occupying this resource
			System.out.println(res3 + " is occupied by  " +tname);
			Thread.sleep(3000);
		}
	}
*/

// Introducing deadlock
	public void batmanReads() throws InterruptedException
	{
		String tname = Thread.currentThread().getName();
		//Nested Synchronized blocks - acquires one after the other but only after all the three are read acquired, all of the resources will be released
		synchronized(res1) {
			System.out.println(res1 + " is occupied by " +tname);
			Thread.sleep(3000);
			synchronized(res2) {
				System.out.println(res2 + " is occupied by " +tname);
				Thread.sleep(3000);
				synchronized(res3) {
					System.out.println(res3 + " is occupied by " +tname);
					Thread.sleep(3000);
				}
			}
		}
		
	}

	public void supermanReads() throws InterruptedException
	{
		String tname = Thread.currentThread().getName();
		
		//Order of acquiring the resouces is reversed
		synchronized(res3) {
			System.out.println(res3 + " is occupied by  " +tname);
			Thread.sleep(3000);
			synchronized(res2) {
				System.out.println(res2 + " is occupied by  " +tname);
				Thread.sleep(3000);
				synchronized(res1) {
					System.out.println(res1 + " is occupied by  " +tname);
					Thread.sleep(3000);
				}
			}
		}
	}
}

/*
how does Deadlock occur? 
- Mututal Exclusion, hold and wait, No Preemption, Circular wait

ReentrantLock allows a thread to acquire the same lock multiple times without getting blocked, offering more control than the synchronized keyword
*/
