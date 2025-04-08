import java.io.*;

public class FileHandling1
{
	public static void main(String[] args) throws IOException
	{
		/*
		File f = new File("sample.txt"); //Objectof File class is created with name f, file name as sample.txt
		if (f.createNewFile()) //Checks and creates if file doesnt exist
			System.out.println("New file created");
		else
			System.out.println("File already exists");
		*/

		//FileWriter writer = new FileWriter("sample.txt"); //Checks and creates a new file if doest exit already. Previous data will be replaced with the new data as default is false for append
		FileWriter writer = new FileWriter("sample.txt", true);
		writer.write("\nThis is the First line"); //Nothing will be written to the file if writer is not closed. 

		/* First way - byte by byte
		FileReader reader = new FileReader("sample.txt");
		int ch = 0;
		while((ch=reader.read()) != -1) 
		{
			System.out.print((char)ch);
		}
		*/

		/*Second way - line by line */
		FileReader reader = new FileReader("sample.txt");
		BufferedReader br = new BufferedReader(reader);
		
		String line = "";
		while ((line = br.readLine()) != null)
		{
			System.out.println(line);
		}

		reader.close();
		writer.close();
	}
}