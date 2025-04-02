//Daemon threads are supporting threads, supporting the major activity

class DaemonThreads
{
	public static void main(String[] args)
	{
		VideoThread vt = new VideoThread();

		PictureThread pt = new PictureThread();
		pt.setDaemon(true);
		pt.setPriority(1); // 1 -10, 1 being lowest mian has 5
		NoiseThread nt = new NoiseThread();
		nt.setDaemon(true);
		nt.setPriority(1);

		vt.start();
		pt.start();
		nt.start();
	}
}

class VideoThread extends Thread 
{
	@Override
	public void run()
	{
		for (int i=1; i <=10;i++)
		{
			try{
				System.out.println("Video is playing....");
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println("Some exception occured");
			}
		}
	}
}

class PictureThread extends Thread 
{
	@Override
	public void run()
	{
		for (int i=1; i <=10;i++)
		{
			try
			{
				for(;;){
					System.out.println("Enhancing picture quality....");
					Thread.sleep(500);
				}
			} 
			catch (InterruptedException e) 
			{
				System.out.println("Some exception occured");
			}
		}
	}
}

class NoiseThread extends Thread 
{
	@Override
	public void run()
	{
		for (int i=1; i <=10;i++)
		{
			try{
				for(;;){
					System.out.println("Removing background noise....");
					Thread.sleep(500);
				}
			} catch (InterruptedException e) {
				System.out.println("Some exception occured");
			}
		}
	}
}

/*
The main player or core activity has to finish first, the supporting activity will finish later
like when we go watch a moive, I watch and go home but the supporting actors like cleaning, admin work will run even after. 1. To make a Thread supporting thread, need to declare them as true for setDaemon, 2. also set a low priority for them 3.whatever task the Daemon thread performs needs to be put inside an infinite loop. As soon as the major thread stops, the daemon threads also stop running, but major will always end first before the supporting thread.
If only Daemon threads are left running, the program will exit.

Usage:
For tasks like cleanup operations, monitoring, sending periiodic updates.
*/