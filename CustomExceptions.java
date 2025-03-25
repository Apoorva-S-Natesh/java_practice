import java.util.Scanner;

public class  CustomExceptions	
{
	public static void main(String[] args) // throws LessPercentageException //Or can use try catch block or the exception class can extend to RuntimeException class
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter percentage");
		int p = sc.nextInt();
		if (p > 60)
			System.out.println("You are eligible");
		else
			//throw new LessPercentageException("need min 60%");
			throw new EligibilityException("need min 60%");
		System.out.println("Please enter the graduation year");
		int year = sc.nextInt();
		if (year >= 2023)
			System.out.println("You are eligible");
		else 
			//throw new YearDoesntMatchException("Should be graduated after 2022");	
			throw new EligibilityException("Should be graduated after 2022");		
	}
}

class EligibilityException extends RuntimeException
{
	public EligibilityException(String msg)
	{
		super(msg);
	}
}

/*
class LessPercentageException extends Exception
{
	public LessPercentageException(String msg)
	{
		super(msg);
	}
}

class YearDoesntMatchException extends RuntimeException
{
	public YearDoesntMatchException(String msg)
	{
		super(msg);
	}
}
*/
