import java.io.*;
import java.util.Scanner;

public class TakingInputWritingToFile
{
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		FileWriter writer = new FileWriter("sample1.txt", true);
		while (true)
		{
			System.out.println("Enter a line or 'exit':");
			String input = sc.nextLine();
			if (input.equals("exit"))
				break;
			else
				writer.write(input + "\n");
		}
		writer.close();
		sc.close();
	}
}	

				