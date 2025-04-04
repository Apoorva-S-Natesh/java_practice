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
		}
	}
}

/* Output when there is no interThread communication
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