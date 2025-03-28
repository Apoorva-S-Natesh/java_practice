public class MTRunnableEclipseExample 
{
	public static void main (String[] args)
	{
		//creating objects of task class
		TaskType type = new TaskType();
		TaskCheck check = new TaskCheck();
		TaskSave save = new TaskSave();

		// creating threads of Thread class and setting names fro those threads
		Thread t1 = new Thread(type);
		t1.setName("Typing-thread");
		Thread t2 = new Thread(check);
		t2.setName("Checking-thread");
		Thread t3 = new Thread(save);
		t3.setName("Saving thread");

		//starting the multi threading process
		t1.start();
		t2.start();
		t3.start();
	}
}

class TaskType implements Runnable
{
	@Override
	public void run()
	{
		System.out.println(Thread.currentThread().toString());
		for (int i = 0; i <=10; i++)
		{
			System.out.println("Typing code....");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex)
			{
				ex.printStackTrace();
			}
		}
	}
}

class TaskCheck implements Runnable
{
	@Override
	public void run()
	{
		for (int i = 0; i <=10; i++)
		{
			System.out.println("Checking syntax....");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex)
			{
				ex.printStackTrace();
			}
		}
	}
}

class TaskSave implements Runnable
{
	@Override
	public void run()
	{
		for (int i = 0; i <=5; i++)
		{
			System.out.println("Saving code....");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex)
			{
				ex.printStackTrace();
			}
		}
	}
}
		