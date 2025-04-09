import java.io.*;

class Student implements Serializable
{
	int roll;
	String name;
	public Student(int roll, String name)
	{
		this.roll = roll;
		this.name = name;
	}
	@Override
	public String toString()
	{
		return "Student [roll= "+ roll + " name= " +name +"]" ;
	}
}
	

public class multipleSerializeDeserialize
{
	public static void main(String[] args) throws Exception
	{
		writeObject();
		readObjects();
	}

	public static void writeObject() throws Exception
	{
		FileOutputStream fos = new FileOutputStream("example1.txt", true);
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		Student st1 = new Student(1, "Apoo");
		Student st2 = new Student(2, "Jay");
		Student st3 = new Student(3, "AJ");

		oos.writeObject(st1);
		oos.writeObject(st2);
		oos.writeObject(st3);

		oos.close(); 
		fos.close();
	}

	public static void readObjects() throws Exception
	{
		FileInputStream fis = new FileInputStream("example1.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
	
		try {
			while(true) {
				Student student1 = (Student) ois.readObject();
				System.out.println(student1);  
   			}
		}catch (Exception ex) {
			System.out.println("Completed reading");
		}
		ois.close();
		fis.close();
	}
}

