import java.io.FileInputStream;
import java.io.IOException;

#for reading and writing data byte by byte FileInputStream and FileOutputStream

class InputOutPutStream
{
	public static void main(String[] args)
	{
		try(FileInputStream fileInput = new FileInputStream("sample.txt")) 
		{
			int data;
			//Read data byte by  byte
			while ((data = fileInput.read()) != -1) 
			{
				//convert byte to character and print
				System.out.print((char)data);
			}
		} catch(IOException e) {
			System.out.println("An error occured while reading the file.");
			e.printStackTrace();
		}
	}
}