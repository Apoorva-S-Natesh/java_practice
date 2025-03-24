import java.util.*;

public class ThrowandThrows {
	public static void main(String[] args)
	{	
		Bank b = new Bank();
		b.bankService();
	}
}

class Bank {
	public void bankService(){
		System.out.println("Bank service executing");
		try {
			Atm atm  =new Atm();
			atm.atmService();
		} catch (InputMismatchException ex) {
			//ex.printStackTrace(); //Only ends the Bank service, Atm service not ending, when thows and finally in atm isnt used
			System.out.println("Bank handled exception");
		}
		System.out.println("Bank service terminating");
	}
}

class Atm{
	public void atmService() throws InputMismatchException // throws - for ducking the exception or when throw is used in catch block
	{
		System.out.println("ATM service executing");

		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Please enter atm pin");
			int pin = sc.nextInt();
			System.out.println("PIN = " + pin);
		} catch (InputMismatchException ime) { //Locally handling the exception - both the ATM service and Bank service ends
			//ime.printStackTrace();
			System.out.println("Pin is incorrect"); //To avoid swallowing the exception
			throw ime; //Information about what exception occured to higher ups -calling methods - rethrowing an exception
		}
		//In case where ATM is not willing to handle the exception but gives a warning to the caller of the method, stating that calling me might casue error , need to use throws - ducking an exception
		finally {
			System.out.println("ATM service terminating");
		} //finally is added here so that after an exception is ducked, we want the method to continue and end the Atm service 
	}
}

/*When dealing with exceptions - there are two options: either a block can hanlde the exception using try and catch, or duck the exception using throws keyword*/