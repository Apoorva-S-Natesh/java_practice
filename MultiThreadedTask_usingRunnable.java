public class MultiThreadedTask_usingRunnable
{
	public static void main(String[] args)
	{
		System.out.println(Thread.currentThread().getName());
		/*Runnable interface only has run() method, Thread class has run(), start(), setName(), could inherit all these methods. Now I can only create the object of Thread class and assign these objects as tasks to the Thread class object */

		// Task creation
		VideoTask video = new VideoTask();
		ChattingTask chatting = new ChattingTask();
		ScreenSharingTask screensharing = new ScreenSharingTask();
		
		//Thread creation
		Thread thread1 = new Thread(video);
		thread1.setName("video thread");
		Thread thread2 = new Thread(chatting);
		thread2.setName("chatting thread");
		Thread thread3 = new Thread(screensharing);
		thread3.setName("sceen-sharing-thread");

		/* start() will call  the run() method interanlly and give the thread to Thread Scheduler*/
		thread1.start();
		thread2.start();
		thread3.start();
	}
}

class VideoTask implements Runnable
{
	@Override
	public void run()
	{
		System.out.println(Thread.currentThread().getName());
		for(int i = 0; i <10; i++)
		{
			System.out.println("Video is playing...");
			try
			{
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class ChattingTask implements Runnable
{
	@Override
	public void run()
	{
		System.out.println(Thread.currentThread().getName());
		for(int i = 0; i <5; i++)
		{
			System.out.println("Chatting..");
			try
			{
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class ScreenSharingTask implements Runnable
{
	@Override
	public void run()
	{
		System.out.println(Thread.currentThread().getName());
		for(int i = 0; i <10; i++)
		{
			System.out.println("Screen sharing...");
			try
			{
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

/*
FLOW
1. JVM creates a main thread and gives it to the Thread scheduler, only one present. The Thread stack for main() is created, in  TS for main, stack frame of main() is created. main thread will start executing.

2. 3 objects of Thread are created, the thread stack for these three will be created but not yet given to the Thread Scheduler to begin the thread execution, that happens when run() method from start() is called. The Thread and tasks are ready.

3. Finally starting the Threads, Now Thread Scheduler can decide which thread to give how much run time, cannot be predicted by us

*/