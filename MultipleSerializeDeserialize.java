import java.io.*;

class Student implements Serializable
{
	int roll;
	String name;
	transient int otp; /*When Object is punctured and tried to be saved by serialization, this will not be. transient keyword will make that particular field not saved in the file and instead defaultvalue will be saved*/

	public Student(int roll, String name, int otp)
	{
		super();
		this.roll = roll;
		this.name = name;
		this.otp = otp;
	}
	@Override
	public String toString()
	{
		return "Student [roll= "+ roll + " name= " +name +" otp= "+ otp +"]" ;
	}
}
	

public class MultipleSerializeDeserialize
{
	public static void main(String[] args) throws Exception
	{
		writeObject();
		readObjects();
	}

	public static void writeObject() throws Exception
	{
		FileOutputStream fos = new FileOutputStream("example2.txt", true);
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		Student st1 = new Student(1, "Apoo", 5345);
		Student st2 = new Student(2, "Jay", 2039);
		Student st3 = new Student(3, "AJ", 2345);

		oos.writeObject(st1);
		oos.writeObject(st2);
		oos.writeObject(st3);

		oos.close(); 
		fos.close();
	}

	public static void readObjects() throws Exception
	{
		FileInputStream fis = new FileInputStream("example2.txt");
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

