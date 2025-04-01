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
			if (Thread.interrupted()) // or (Thread.currentThread().isInterrrupted()) // isInterrupted is a non-static method so should be called on the object
				return;
			System.out.println("Executed task : " +i);
		}
	}
}

/*
When an interrupted thread is in a blocking operaton like Thread.sleep(), then  it throws an InterruptedEception which needs to be handled to ensure a graceful shutdown.

interrrupt() is preferred over stop() as interrupt() gives th ethread a chance to stop gracefully and release resources, whereas stop() can leave shared resources in an inconsistent state.
*/
