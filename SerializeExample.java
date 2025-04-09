import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.io.FileNotFoundException;
import java.lang.ClassNotFoundException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

//Serializable is a tagged or marker interface, no methods in the interface

class Student implements Serializable
{
	int roll;
	String name;
	public Student(int roll, String name)
	{
		this.roll = roll;
		this.name = name;
	}
}

public class SerializeExample 
{
	public static void main(String[] args) throws IOException
	{
/*
		Student st = new Student(1, "Apoo");
		// Serialize an Object
		FileOutputStream fos = new FileOutputStream("example.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(st);

		oos.close(); //will work even if we not closed, but always better to close resources
		fos.close();
*/
		// Deserialize an Object
		try
		{
			FileInputStream fis = new FileInputStream("example.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Student student = (Student) ois.readObject(); //return type of readObject is an Object, so need to downcast
			System.out.println("Deserialized Student: " + student.roll + " Name: " +student.name); //Or should have overridden toString method in the Student class
			ois.close();
			fis.close();
		} catch (FileNotFoundException e) {
			System.out.println("FIle not found");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
  			System.out.println("Class definition not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("An error occured during deserialization");
			e.printStackTrace();
		}
	}
}


