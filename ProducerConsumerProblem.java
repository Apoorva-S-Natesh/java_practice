//Also known as Reader - Writer problem

class ProducerConsumerProblem 
{
	public static void main(String[] args)
	{
		PizzaShop ps = new PizzaShop();

		Chef chef = new Chef(ps);
		Customer customer = new Customer(ps);

		chef.setName("bakingTask");
		customer.setName("eatingTask");
		
		chef.start();
		customer.start();
	}
}

class PizzaShop
{
	int token = 0;
	boolean isReady = false;

	public synchronized void bakePizza()
	{
		if (isReady == false) // If pizza is not ready then make it
		{
				token++;
				System.out.println("Chef has made pizza number : "+token);			
				isReady = true;
				notify(); //Notify customer that pizza is ready  	
		}
		else
		{
			try{
				wait(); // wait till pizza is consumed to prepare more
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}	
		
	}

	public synchronized void eatPizza()
	{
		if (isReady)
		{
				System.out.println("Customer has eaten pizza number : "+token);
				isReady = false;
				notify(); // Notify the chef that pizza has been eaten
		}
		else
		{
			try
			{
				wait(); //thread is in wait state until some other thread calls notify, then the then will be in the runnable state and when Thread scheduler gives the thread time it will go to the running state.
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}	
	}
}

class Chef extends Thread
{
	PizzaShop shop;
	Chef(PizzaShop shop)
	{
		this.shop = shop;
	}

	public void run()
	{
		while (true)
		{
			shop.bakePizza();
			try {
				Thread.sleep(1000); //Representing baking time
			 } catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
			
	}
}

class Customer extends Thread
{
	PizzaShop shop;
	Customer(PizzaShop shop)
	{
		this.shop = shop;
	}
	public void run()
	{
		while (true)
		{
			shop.eatPizza();
			try {
				Thread.sleep(2000); //REpresenting eating time
			 } catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

/* Output when there is no interThread communication

class PizzaShop
{
	int token = 1;

	public void bakePizza()
	{
		System.out.println("Chef has made pizza number : "+token);
		token++;
	}

	public void eatPizza()
	{
		System.out.println("Customer has eaten pizza number : "+token);
	}
}

Customer has eaten pizza number : 1
Customer has eaten pizza number : 1
Customer has eaten pizza number : 1
Customer has eaten pizza number : 1
Chef has made pizza number : 1
Chef has made pizza number : 2
Chef has made pizza number : 3
Customer has eaten pizza number : 1
Customer has eaten pizza number : 4
Customer has eaten pizza number : 4
Customer has eaten pizza number : 4
Customer has eaten pizza number : 4
Customer has eaten pizza number : 4
Chef has made pizza number : 4
Chef has made pizza number : 5
Chef has made pizza number : 6
Customer has eaten pizza number : 4
Chef has made pizza number : 7
Chef has made pizza number : 8
Customer has eaten pizza number : 7
Chef has made pizza number : 9
Customer has eaten pizza number : 9
Chef has made pizza number : 10
Chef has made pizza number : 11
Customer has eaten pizza number : 10
Customer has eaten pizza number : 12

there is more production than consumption
rading more than writing 
*/
