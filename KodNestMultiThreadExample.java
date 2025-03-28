class KodNestMultiThreadExample
{
	public static void main(String[] args) throws InterruptedException
	{
		System.out.println("Kodnest services has started");

		Training t = new Training();
		t.start();
		Placements p = new Placements();
		p.start();
		
		//When I dont want the main thread to end before the training and placement thread has finished, in that case should use join() so main or any thread will stop and wait till the mentioned threads are finished
		t.join();
		p.join();
		System.out.println("Kodnest services ended");
		
	}
}

class Training extends Thread{
	public void run()
	{
	System.out.println("Training has started");
	for (int i=1; i <=5; i++)
	{
		System.out.println("Training is goin on");
	}
	System.out.println("Training has ended");
	}
}

class Placements extends Thread{
	public void run()
	{
	System.out.println("Placement has started");
	for (int i=1; i <=5; i++)
	{
		System.out.println("Placement is goin on");
	}
	System.out.println("Placement has ended");
	}
}

/*
Output without join:
Kodnest services has started
Training has started
Training is goin on
Training is goin on
Training is goin on
Kodnest services ended
Training is goin on
Training is goin on
Training has ended
Placement has started
Placement is goin on
Placement is goin on
Placement is goin on
Placement is goin on
Placement is goin on
Placement has ended


Output with join
Kodnest services has started
Training has started
Training is goin on
Training is goin on
Training is goin on
Training is goin on
Training is goin on
Training has ended
Placement has started
Placement is goin on
Placement is goin on
Placement is goin on
Placement is goin on
Placement is goin on
Placement has ended
Kodnest services ended
*/