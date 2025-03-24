import java.io.*;

public class CompileTimeException
{
	public static void main(String[] args)
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		try{
			System.out.println("Please enter roll:");
			int roll = Integer.parseInt(br.readLine()); //io exception is achecked excetption, compiler checks it during Compilation only.
			//CompileTimeException.java:11: error: unreported exception IOException; must be caught or declared to be thrown
			System.out.println("Please enter name:");
			String name = br.readLine();
	
			System.out.println("Roll = " + roll);
			System.out.println("Name = " + name);
		} catch (IOException ex)
		{
			ex.printStackTrace();
		}
	}
}