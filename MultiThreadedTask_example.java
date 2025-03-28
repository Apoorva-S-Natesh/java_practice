public class MultiThreadedTask_example
{
	public static void main(String[] args)
	{
		System.out.println(Thread.currentThread().getName());
		/* In java  to create a thread either create a thread of the Thread class or object of the child class of  Thread */
		VideoThread video = new VideoThread();
		video.setName("video-thread");
		ChattingThread chatting = new ChattingThread();
		chatting.setName("chatting-thread");
		ScreenSharingThread screensharing = new ScreenSharingThread();
		screensharing.setName("screen-sharing-thread");

		/* start() will call  the run() method interanlly and give the thread to Thread Scheduler*/
		video.start();
		screensharing.start();
		chatting.start();
	}
}

class VideoThread extends Thread
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

class ChattingThread extends Thread
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

class ScreenSharingThread extends Thread
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
JVM creates a main thread and gives it to the Thread scheduler. The Thread stack for main is created, in  TS for main, stack frame of main is created.

when video.start() is executed a New line of execution is created and asigned to the scheduler, and inside the ThreadStcak of video Thread a stack frame for run() is created

Now Thread Scheduler can decide which thread to give how much run time, cannot be predicted by us

*/
