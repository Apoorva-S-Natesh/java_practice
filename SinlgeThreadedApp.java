public class SinlgeThreadedApp 
{
	public static void main(String[] args) throws InterruptedException
	{
		System.out.println(Thread.currentThread().getName());
			System.out.println(Thread.currentThread().toString());
		for (int i = 1; i<= 5;i++)
		{
			System.out.println(Thread.currentThread().getName());
			System.out.println(Thread.currentThread().toString());
			System.out.println("Subtask typing - being executed.....");
			Thread.sleep(1000); // sleep() throws an InturrptedException
		}
		for (int i = 1; i<= 5;i++)
		{
			System.out.println(Thread.currentThread().getName());
			System.out.println(Thread.currentThread().toString());
			System.out.println("Subtask error-check - being executed....");
			Thread.sleep(1000);
		}
		for (int i = 1; i<= 5;i++)
		{
			System.out.println(Thread.currentThread().getName());
			System.out.println(Thread.currentThread().toString());
			System.out.println("Subtask saving- being executed......");
			Thread.sleep(1000);
		}
	}
}