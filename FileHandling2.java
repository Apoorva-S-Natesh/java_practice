import java.io.*;

class FileHandling2
{
	public static void main(String[] args) throws IOException
	{
		FileReader reader = new FileReader("sample.txt");
		BufferedReader br = new BufferedReader(reader);

		FileWriter writer = new FileWriter("Output.txt", true);
		BufferedWriter bw = new BufferedWriter(writer);

		String line = "";
		while((line=br.readLine()) != null)
		{
			bw.write(line+"\n");
		}
		
		br.close();
		bw.close();
	}
}