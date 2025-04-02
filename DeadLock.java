class DeadLock 
{
	public static void main(String[] args)
	{
		ReadingTask rt = new ReadingTask();
		Thread t1 = new Thread(rt);
		t1.setName("batman");

		Thread t2 = new Thread(rt);
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
		try{
			if (Thread.currentThread().equals("batman"))
				l.batmanReads();
			else
				l.supermanReads();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Library
{
	String res1 = "Java book";
	String res2 = "React book";
	String res3 = "sql book";

	public void batmanReads() throws InterruptedException
	{
		synchronized(res1) {
			//to show that someone is occupying this resource
			System.out.println(res1 + " is occupied by batman");
			Thread.sleep(3000);
		}
		synchronized(res2) {
			//to show that someone is occupying this resource
			System.out.println(res2 + " is occupied by batman");
			Thread.sleep(3000);
		}
		synchronized(res3) {
			//to show that someone is occupying this resource
			System.out.println(res3 + " is occupied by batman");
			Thread.sleep(3000);
		}
	}

	public void supermanReads() throws InterruptedException
	{
		synchronized(res1) {
			//to show that someone is occupying this resource
			System.out.println(res1 + " is occupied by superman");
			Thread.sleep(3000);
		}
		synchronized(res2) {
			//to show that someone is occupying this resource
			System.out.println(res2 + " is occupied by superman");
			Thread.sleep(3000);
		}
		synchronized(res3) {
			//to show that someone is occupying this resource
			System.out.println(res3 + " is occupied by superman");
			Thread.sleep(3000);
		}
	}
}

/*
how does Deadlock occur? 
- Mututal Exclusion, hold and wait, No Preemption, Circular wait

ReentrantLock allows a thread to acquire the same lock multiple times without getting blocked, offering more control than the synchronized keyword
*/